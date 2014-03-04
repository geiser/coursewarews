package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import br.usp.ime.lapessc.courseware.model.Goal;
import br.usp.ime.lapessc.courseware.model.LDElement;
import br.usp.ime.lapessc.courseware.model.LDElement.Type;
import br.usp.ime.lapessc.courseware.model.LDParameter;
import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.PublicTask;
import br.usp.ime.lapessc.courseware.planner.Solver;
import br.usp.ime.lapessc.courseware.util.LDResources;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.DoubleCost;
import com.gamalocus.jshop2rt.JSHOP2;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Plan;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.State;
import com.gamalocus.jshop2rt.TaskList;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class JShop2ipSolver implements Solver {

    private Domain domain = new domain();
    private JSHOP2 planner = null;
    private String mediatorURL;

    public LDElement solve(PublicTask initialTask, String initialState) {
        //-- set initial task
        TaskList initialTaskList = new TaskList(1, true);
        initialTaskList.subtasks[0] = new TaskList(initialTask.toTaskAtom(domain));

        //-- set initial state
        State state = new State(this.domain.getAxioms());
        this.createState0(state);
        LDElement.count = 0;

        //-- run planner
        this.planner = new JSHOP2(initialTaskList, 10000, new DoubleCost(0.0), this.domain, state);
        JSHOP2Provider.setJSHOP2(this.planner);
        JSHOP2Provider.setMediatorURL(this.mediatorURL);
        // TODO Auto-generated method stub
        while (this.planner.run()){
            if (this.planner.getPlans().size() >= 1) break;
        }
        Plan plan = this.planner.getPlans().getFirst();
        //System.out.println(this.planner.getState().toString(this.domain));
        System.out.println(plan.toString(this.domain));

        return this.convert(plan);
    }

    private void createState0(State state) {
        //-- set default levels
        for (Metadata level : LDResources.LEVELS.values()) {
            for (Predicate predicate : level.toPredicates(this.domain)) {
                state.add(predicate);
            }
        }
        //-- set session descriptions
        for (Metadata sessionDescription : LDResources.SESSION_DESCRIPTIONS.values()) {
            for (Predicate predicate : sessionDescription.toPredicates(this.domain)) {
                state.add(predicate);
            }
        }
        //-- set ilevent description
        for (Metadata ileventDescription : LDResources.ILEVENT_DESCRIPTIONS.values()) {
            for (Predicate predicate : ileventDescription.toPredicates(this.domain)) {
                state.add(predicate);
            }
        }
    }

    private LDElement convert(Plan plan) {

        Map<String, Collection<String>> userGroups = new HashMap<String, Collection<String>>();
        Map<String, Collection<String>> userRoles = new HashMap<String, Collection<String>>();

        Stack<LDElement> stack = new Stack<LDElement>();

        for (Predicate pred : plan.getOps()) {
            List opParamList = ((TermList) pred.getParam()).getList();
            Type type = LDElement.Type.getByValue(domain.getPrimitiveTasks()[pred.getHead()]);
            if (Type.START_LD_ELEMENT.equals(type)) {
                LDElement element = new LDElement();
                element.setType(type);
                element.setTag(((TermConstant) opParamList.getHead()).getName());
                if (opParamList.getRest() != null) { // exist ?parameters
                    List parametersList = ((TermList) opParamList.getRest().getHead()).getList();
                    java.util.List<LDParameter> parameters = new ArrayList<LDParameter>();
                    while (parametersList != null) {
                        List paramList = ((TermList) parametersList.getHead()).getList();
                        parameters.add(new LDParameter(((TermConstant) paramList.getHead()).getName(),
                                ((TermConstant) paramList.getRest().getHead()).getName()));
                        parametersList = parametersList.getRest();
                    }
                    element.setParameters(parameters);
                    //-- process meta information e.g. (?type ?id ?goals ?groups) to (?types ?id ?goals ?skills ?attitudes ?groups)
                    if (opParamList.getRest().getRest() != null) { 
                        List metadataList = ((TermList) opParamList.getRest().getRest().getHead()).getList();
                        Metadata metadata = new Metadata();
                        List typeList = ((TermList) metadataList.getHead()).getList();
                        while (typeList != null) {
                            metadata.addType(((TermConstant) typeList.getHead()).getName());
                            typeList = typeList.getRest();
                        }
                        metadata.setId(((TermConstant) metadataList.getRest().getHead()).getName());
                        // add goals
                        List goalList = ((TermList) metadataList.getRest().getRest().getHead()).getList();
                        while (goalList != null) { // e.g. ((?comp1 ?level1) (?comp2 ?level2) ... (?compN ?levelN))
                            List compValueList = ((TermList) goalList.getHead()).getList();
                            String compId = ((TermConstant) compValueList.getHead()).getName();
                            String level = ((TermConstant) compValueList.getRest().getHead()).getName();
                            metadata.addProperty(new Property().setName("hasGoal").setValue(new Goal().setComp(new Metadata(compId)).setLevel(level).toString()));
                            goalList = goalList.getRest();
                        }
                        // add skill and attitudes
                        List groupList = ((TermList) metadataList.getRest().getRest().getRest().getHead()).getList(); 
                        if (metadataList.getRest().getRest().getRest() != null && metadataList.getRest().getRest().getRest().getRest() != null) {
                            List skillList = ((TermList) metadataList.getRest().getRest().getRest().getHead()).getList();
                            while (skillList != null) {
                                String value = ((TermConstant) skillList.getHead()).getName();
                                metadata.addProperty(new Property().setName("hasSkill").setValue(value));
                                skillList = skillList.getRest();
                            }
                            List attitudeList = ((TermList) metadataList.getRest().getRest().getRest().getRest().getHead()).getList();
                            while (attitudeList != null) {
                                String value = ((TermConstant) attitudeList.getHead()).getName();
                                metadata.addProperty(new Property().setName("hasAttitude").setValue(value));
                                attitudeList = attitudeList.getRest();
                            }
                            groupList = ((TermList) metadataList.getRest().getRest().getRest().getRest().getRest().getHead()).getList();
                        }
                        // add groups
                        while (groupList != null) {
                            List learnerList = ((TermList) groupList.getHead()).getList();
                            while (learnerList != null) {
                                String learnerId = ((TermConstant) learnerList.getHead()).getName();
                                metadata.addProperty(new Property().setName("hasParticipant").setValue(learnerId));
                                learnerList = learnerList.getRest();
                            }
                            groupList = groupList.getRest();
                        }
                        element.setMetadata(metadata);
                    }
                }
                stack.push(element);
            } else if (Type.END_LD_ELEMENT.equals(type)) {
                String tag = ((TermConstant) opParamList.getHead()).getName();
                String id = null;
                if (opParamList.getRest() != null) {
                    id = ((TermConstant) opParamList.getRest().getHead()).getName();
                }

                LDElement element = stack.pop();
                java.util.List<LDElement> children = new ArrayList<LDElement>();
                while (!stack.isEmpty() &&
                        !tag.equals(element.getTag()) &&
                        (id == null ||
                        (id != null && (element.getMetadata() == null ||
                        element.getMetadata().getId() == null  ||
                        !id.equals(element.getMetadata().getId()))))) {
                    children.add(element);
                    element = stack.pop();
                }
                element.setChildren(children);
                //-- push element
                stack.push(element);
            } else if (Type.TEXT.equals(type)) {
                LDElement element = new LDElement();
                element.setType(type);
                //-- set default text
                String tagType = "";
                List typeList = ((TermList) opParamList.getHead()).getList();
                while (typeList != null) {
                    tagType += ((TermConstant) typeList.getHead()).getName();
                    typeList = typeList.getRest();
                    if (typeList != null) { tagType += "."; }
                }
                element.setTag(tagType);
                //-- set values of default text
                java.util.List<LDParameter> parameters = new ArrayList<LDParameter>();
                List firstTextList = ((TermList) opParamList.getRest().getHead()).getList();
                int count = 0;
                while (firstTextList != null) {
                    parameters.add(new LDParameter("\\{f" + count + "\\}", ((TermConstant) firstTextList.getHead()).getName()));
                    firstTextList = firstTextList.getRest();
                    count++;
                }
                count = 0;
                List secondTextList = ((TermList) opParamList.getRest().getRest().getHead()).getList();
                while (secondTextList != null) {
                    parameters.add(new LDParameter("\\{s" + count + "\\}", ((TermConstant) secondTextList.getHead()).getName()));
                    secondTextList = secondTextList.getRest();
                    count++;
                }
                element.setParameters(parameters);
                stack.push(element);
            } else if (Type.INSERT_RESOURCE.equals(type)) {
                LDElement element = new LDElement();
                element.setType(type);
                element.setTag("resource");
                //-- set parameters
                //-- set identifier parameter
                LDParameter identifier = new LDParameter();
                identifier.setName("identifier");
                identifier.setValue(((TermConstant) opParamList.getHead()).getName());
                java.util.List<LDParameter> parameters = new ArrayList<LDParameter>();
                parameters.add(identifier);
                //-- rest parameters
                List parametersList = ((TermList) opParamList.getRest().getHead()).getList();
                while (parametersList != null) {
                    List paramList = ((TermList) parametersList.getHead()).getList();
                    parameters.add(new LDParameter(((TermConstant) paramList.getHead()).getName(),
                            ((TermConstant) paramList.getRest().getHead()).getName()));
                    parametersList = parametersList.getRest();
                }
                element.setParameters(parameters);
                //-- add item
                stack.add(element);
            } else if (Type.ADD_USER_TO_GROUP.equals(type)) {
                String userId = ((TermConstant) opParamList.getHead()).getName();
                Collection<String> groups = userGroups.get(userId);
                if (groups == null) { groups = new ArrayList<String>(); }
                groups.add(((TermConstant) opParamList.getRest().getHead()).getName());
                userGroups.put(userId, groups);
            } else if (Type.ADD_USER_TO_ROLE.equals(type)) {
                String userId = ((TermConstant) opParamList.getHead()).getName();
                Collection<String> roles = userRoles.get(userId);
                if (roles == null) { roles = new ArrayList<String>(); }
                roles.add(((TermConstant) opParamList.getRest().getHead()).getName());
                userRoles.put(userId, roles);
            }
        }
        LDElement toReturn = stack.pop();
        //-- set roles and groups
        for (String userId : userRoles.keySet()) {
            for (String roleId : userRoles.get(userId)) {
                toReturn.getMetadata().addProperty(new Property().setName("hasUserInRole").setValue("(" + userId + " " + roleId + ")"));                            
            }
        }
        for (String userId : userGroups.keySet()) {
            for (String groupId : userGroups.get(userId)) {
                toReturn.getMetadata().addProperty(new Property().setName("hasUserInGroup").setValue("(" + userId + " " + groupId + ")"));                            
            }
        }
        return toReturn;
    }

    public void setMediatorURL(String URL) {
        this.mediatorURL = URL;
    }

}