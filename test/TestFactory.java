
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Resource;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.Relation;
import br.usp.ime.lapessc.courseware.util.LDResources;

public abstract class TestFactory {

    public final static int len = 15;
    public final static String endl = System.getProperty("line.separator");

    /* --------------------------------------------------------------------------- */
    public static Set<Property> buildProperties(String name, Metadata dest, String value) {
        return buildProperties(null, name, dest, value);
    }

    public static Set<Property> buildProperties(Metadata source, String name, Metadata dest, String value) {
        Set<Property> result = new HashSet<Property>();
        if (value != null) {
            String[] values = new String[]{value};
            if ("hasEducationalLevel".equals(name) || "hasContext".equals(name)) {
                if ("higher-education".equals(value)) {
                    values = new String[]{"higher-education", "school"};
                }
            } else if ("hasLearningResourceType".equals(name)) {
                if ("theorem".equals(value)) {
                    values = new String[]{"law", "theorem"};
                } else if ("law-of-nature".equals(value)) {
                    values = new String[]{"law", "theorem", "law-of-nature"};
                } else if ("policy".equals(value)) {
                    values = new String[]{"process", "policy"};
                } else if ("procedure".equals(value)) {
                    values = new String[]{"process", "policy", "procedure"};
                } else if ("introduction".equals(value)) {
                    values = new String[] {"explanation", "introduction"};
                } else if ("remark".equals(value)) {
                    values = new String[] {"explanation", "remark"};
                } else if ("conclusion".equals(value)) {
                    values = new String[] {"explanation", "conclusion"};
                } else if ("exercise".equals(value)) {                        
                    values = new String[] {"interactivity", "exercise"};
                } else if ("exploration".equals(value)) {
                    values = new String[] {"interactivity", "exploration"};
                } else if ("invitation".equals(value)) {
                    values = new String[] {"interactivity", "invitation"};
                } else if ("real-world-problem".equals(value)) {
                    values = new String[] {"interactivity", "real-world-problem"};
                } else if ("proof".equals(value)) {
                    values = new String[] {"evidence", "proof"};
                } else if ("demonstration".equals(value)) {
                    values = new String[] {"evidence", "demonstration"};
                } else if ("counter-example".equals(value)) {
                    values = new String[] {"illustration", "counter-example"};
                } else if ("example".equals(value)) {
                    values = new String[] {"illustration", "example"};
                }
            } else if ("hasLearningObjective".equals(name)
                    //|| "hasLearningPrerequisite".equals(name)
                    //|| "hasCompetencyLevel".equals(name)
                    ) {
                int csl = Integer.parseInt(value.substring(1, 2));
                int ckl = Integer.parseInt(value.substring(3, 4));
                values = new String[(csl + 1) * (ckl + 1)];
                int i = 0;
                for (int sl = 0; sl <= csl; sl++) {
                    for (int kl = 0; kl <= ckl; kl++) {
                        values[i] = "s" + sl + "k" + kl;
                        i++;
                    }
                }
            }
            for (String v: values) {
                result.add(new Property().setSource(source).setName(name).setValue("("+ dest + " " + v + ")"));
            }
        } else {
            result.add(new Property().setSource(source).setName(name).setValue(dest.getId()));
        }
        return result;
    }

    /* --------------------------------------------------------------------------- */
    private static Metadata buildBase(Metadata base, HashMap<String, Metadata[]> destinations, HashMap<String, String[]> values) {
        Metadata result = null;
        result = new Metadata(UUID.uuid(len, "idm"));
        if (result != null) {
            for (String type : base.getTypes()) {
                result.addType(type);
            }
            for (Property property : base.getProperties()) {
                //Metadata dest =  (Metadata) property.getDestination();
                Metadata dest = null;
                if (destinations != null && destinations.get(property.getName()) != null) {
                    dest = destinations.get(property.getName())[(int) (Math.random() * destinations.get(property.getName()).length)];
                }
                String value = property.getValue();
                if (values != null && values.get(property.getName()) != null) {
                    value = values.get(property.getName())[(int) (Math.random() * values.get(property.getName()).length)];
                }
				if (dest != null && value != null) {
					value = "( " + dest.getId() + " " + value + " )";
				} else if (dest != null) {
					value = dest.getId();
				}
				result.addProperty(new Property().setName(property.getName()).setValue(value));
                //result.addProperties(buildProperties(property.getName(), dest, value));
            }
        }
        return result;
    }

    @SuppressWarnings("serial")
    protected static Metadata buildAuxiliary(final Metadata competency) {
        return (Metadata) TestFactory.buildBase(new Metadata().addType("Auxiliary")
                .addProperty(new Property().setName("hasContext"))
                .addProperty(new Property().setName("hasDifficult"))
                .addProperty(new Property().setName("hasLearningResourceType"))
                .addProperty(new Property().setName("hasLearningObjective")),
                new HashMap<String, Metadata[]>(){{
                    put("hasLearningObjective", new Metadata[]{competency});
                }},
                new HashMap<String, String[]>(){{
                    put("hasContext", new String[]{"training", "higher-education", "school", "other"});
                    put("hasDifficult", new String[]{"very-easy", "easy", "medium", "difficult", "very-difficult"});
                    put("hasLearningResourceType", new String[]{
                            "explanation", "introduction", "remark",
                            "conclusion", "interactivity", "exercise",
                            "exploration", "invitation", "real-world-problem",
                            "evidence", "proof", "demonstration",
                            "illustration", "counter-example", "example"});
                    put("hasLearningObjective", new String[]{
                            "s0k0", "s0k1", "s0k2", "s0k3",
                            "s1k0", "s1k1", "s1k2", "s1k3",
                            "s2k0", "s2k1", "s2k2", "s2k3",
                            "s3k0", "s3k1", "s3k2", "s3k3",
                            "s4k0", "s4k1", "s4k2", "s4k3"});
                    /*put("hasLearningPrerequisites", new String[]{
                            "s0k0", "s0k1", "s0k2", "s0k3",
                            "s1k0", "s1k1", "s1k2", "s1k3",
                            "s2k0", "s2k1", "s2k2", "s2k3",
                            "s3k0", "s3k1", "s3k2", "s3k3",
                            "s4k0", "s4k1", "s4k2", "s4k3"});*/
                }});
    }

    public static Metadata buildDefaultAuxiliary(final Collection<Metadata> comps, String prefix) {
        Metadata aux = new Metadata(UUID.uuid(len, prefix)).addType("Auxiliary");
        aux.addProperty(new Property().setName("hasTitle").setValue("Default-auxiliary-" + aux.getId()));
        aux.addProperty(new Property().setName("hasContext").setValue("training"));
        aux.addProperty(new Property().setName("hasContext").setValue("higher-education"));
        aux.addProperty(new Property().setName("hasContext").setValue("school"));
        aux.addProperty(new Property().setName("hasContext").setValue("other"));
        aux.addProperty(new Property().setName("hasDifficult").setValue("very-easy"));
        aux.addProperty(new Property().setName("hasDifficult").setValue("easy"));
        aux.addProperty(new Property().setName("hasDifficult").setValue("medium"));
        aux.addProperty(new Property().setName("hasDifficult").setValue("difficult"));
        if (((int) (Math.random() * 10)) % 2 == 0) {
            aux.addProperty(new Property().setName("hasDifficult").setValue("very-difficult"));
        }
        String[] types = new String[]{
                "explanation", "introduction", "remark",
                "conclusion", "interactivity", "exercise",
                "exploration", "invitation", "real-world-problem",
                "evidence", "proof", "demonstration",
                "illustration", "counter-example", "example"};
        for (String type : types) {
            aux.addProperty(new Property().setName("hasLearningResourceType").setValue(type));
        }
        String[] qtypes = new String[]{"questionnaire", "simulation"};
        int indx = (int) (Math.random() * (qtypes.length + 1));
        if (indx < qtypes.length) { aux.addProperty(new Property().setName("hasLearningResourceType").setValue(qtypes[indx])); }

        for (Metadata comp : comps) {
            String[] levels	= new String[] {
                    "s0k0", "s0k1", "s0k2", "s0k3",
                    "s1k0", "s1k1", "s1k2", "s1k3",
                    "s2k0", "s2k1", "s2k2", "s2k3",
                    "s3k0", "s3k1", "s3k2", "s3k3",
                    "s4k0", "s4k1", "s4k2", "s4k3"};
            for (String level : levels) {
                aux.addProperty(new Property().setName("hasLearningObjective").setValue("("+ comp.getId() + " " + level + ")"));
            }
        }
		
		// set resource
		Resource auxResource = new Resource();
		auxResource.setId(auxResource.getUuid());
		auxResource.setTitle("resource-default-aux" + aux.getId());
		auxResource.setHref("base-url-"+ auxResource.getId());
		aux.setResource(auxResource);
		
        return aux;
    }
    
    @SuppressWarnings("serial")
    protected static Metadata buildAuxiliary(final Collection<Metadata> comps) {
        Metadata aux = null;
        if ((int) (Math.random() * 100) % 10 == 0) {
            aux = (Metadata) TestFactory.buildBase(new Metadata().addType("Auxiliary")
                    .addProperty(new Property().setName("hasContext"))
                    .addProperty(new Property().setName("hasDifficult"))
                    .addProperty(new Property().setName("hasLearningResourceType"))
                    .addProperty(new Property().setName("hasLearningPrerequisite")),
                    new HashMap<String, Metadata[]>(){{
                        int i = 0;
                        Metadata[] compArray = new Metadata[2];
                        for (Metadata mcomp : comps) {
                            if (i >= 2) { break; }
                            if ((int) (Math.random() * 10) % 2 == 0) {
                                compArray[i] = mcomp;
                                i++;
                            }
                        }
                        put("hasLearningPrerequisite", compArray);
                    }},
                    new HashMap<String, String[]>(){{
                        put("hasContext", new String[]{"training", "higher-education", "school", "other"});
                        put("hasDifficult", new String[]{"very-easy", "easy", "medium", "difficult", "very-difficult"});
                        put("hasLearningResourceType", new String[]{
                                "explanation", "introduction", "remark",
                                "conclusion", "interactivity", "exercise",
                                "exploration", "invitation", "real-world-problem",
                                "evidence", "proof", "demonstration",
                                "illustration", "counter-example", "example"});
                        put("hasLearningPrerequisite", new String[]{
                                "s0k0", "s0k1", "s0k2", "s0k3",
                                "s1k0", "s1k1", "s1k2", "s1k3",
                                "s2k0", "s2k1", "s2k2", "s2k3",
                                "s3k0", "s3k1", "s3k2", "s3k3",
                                "s4k0", "s4k1", "s4k2", "s4k3"});
                    }});
        } else {
            aux = (Metadata) TestFactory.buildBase(new Metadata().addType("Auxiliary")
                    .addProperty(new Property().setName("hasContext"))
                    .addProperty(new Property().setName("hasDifficult"))
                    .addProperty(new Property().setName("hasLearningResourceType")),
                    new HashMap<String, Metadata[]>(){{
                        Metadata[] compArray = new Metadata[comps.size()]; int i = 0;
                        for (Metadata mcomp : comps) { compArray[i] = mcomp; i++; }
                        put("hasLearningPrerequisites", compArray);
                    }},
                    new HashMap<String, String[]>(){{
                        put("hasContext", new String[]{"training", "higher-education", "school", "other"});
                        put("hasDifficult", new String[]{"very-easy", "easy", "medium", "difficult", "very-difficult"});
                        put("hasLearningResourceType", new String[]{
                                "explanation", "introduction", "remark",
                                "conclusion", "interactivity", "exercise",
                                "exploration", "invitation", "real-world-problem",
                                "evidence", "proof", "demonstration",
                                "illustration", "counter-example", "example"});
                    }});
        }
        return aux;
    }

    @SuppressWarnings("serial")
    private static Metadata buildLearner(Collection<Metadata> auxs) {
        Metadata user = (Metadata) TestFactory.buildBase(new Metadata().addType("User").addType("Learner")
                .addProperty(new Property().setName("hasPersonality"))
                .addProperty(new Property().setName("hasCLExperience"))
                .addProperty(new Property().setName("hasEducationalLevel"))
                .addProperty(new Property().setName("hasBehavioral")),
                null,
                new HashMap<String, String[]>() {{
                    put("hasPersonality", new String[]{"introversion", "extraversion", "ambiversion"});
                    put("hasCLExperience", new String[]{"very-low", "low", "medium", "high", "very-high"});
                    put("hasEducationalLevel", new String[]{"training", "higher-education", "school", "other"});
                    put("hasBehavioral", new String[]{"presenter", "adviser", "imitator", "guide",
                            "reviewer", "evaluator", "presenter", "problem-solver",
                            "passive-learner", "explainer"});
                }});
        if ((int) (Math.random() * 100) % 5 == 0) {
            for (Metadata aux : auxs) {
                if ((int) (Math.random() * 100) % 5 == 0) {
                    user.addProperty(new Property().setName("hasAlreadySeen").setValue("(" + aux.getId() + " true)"));
                }
            }
        }
        return user;
    }

    @SuppressWarnings("serial")
    protected static Metadata buildLearner(final Collection<Metadata> comps, Collection<Metadata> auxs, String prefix) {
        Metadata learner = (Metadata) TestFactory.buildBase(new Metadata().addType("User").addType("Learner")
                .addProperty(new Property().setName("hasPersonality"))
                .addProperty(new Property().setName("hasCLExperience"))
                .addProperty(new Property().setName("hasEducationalLevel"))
                .addProperty(new Property().setName("hasBehavioral")),
                null,
                new HashMap<String, String[]>() {{
                    put("hasPersonality", new String[]{"introversion", "extraversion", "ambiversion"});
                    put("hasCLExperience", new String[]{"very-low", "low", "medium", "high", "very-high"});
                    put("hasEducationalLevel", new String[]{"training", "higher-education", "school", "other"});
                    put("hasBehavioral", new String[]{"presenter", "adviser", "imitator", "guide", "reviewer", "evaluator", "presenter", "problem-solver", "passive-learner", "explainer"});
                }});
        learner.setId(UUID.uuid(len, prefix));
        //-- set hasCompetencyLevel
        for (Metadata competency : comps) {
            if ((int) (Math.random() * 100) % 5 == 0) {
                String[] values = new String[] {"very-low", "low", "medium", "high", "very-high"};
                learner.addProperty(new Property().setName("hasAnxiety").setValue("(" + competency.getId() + " " + values[(int) (Math.random() * values.length)] + ")"));
                learner.addProperty(new Property().setName("hasMotivation").setValue("(" + competency.getId() + " " + values[(int) (Math.random() * values.length)] + ")"));
                values = new String[]{
                        "s0k0", "s0k1", "s0k2", "s0k3",
                        "s1k0", "s1k1", "s1k2", "s1k3",
                        "s2k0", "s2k1", "s2k2", "s2k3",
                        "s3k0", "s3k1", "s3k2", "s3k3",
                        "s4k0", "s4k1", "s4k2", "s4k3"};
                int indx = (int) (Math.random() * values.length);
                for (int i = 0; i <= indx; i++) {
                    learner.addProperty(new Property().setName("hasCompetencyLevel").setValue("(" + competency.getId() + " " + values[i] + ")"));
                }
            }
        }
        //-- set hasAlreadySeen
        for (Metadata aux : auxs) {
            if ((int) (Math.random() * 100) % 5 == 0) {
                learner.addProperty(new Property().setName("hasAlreadySeen").setValue("(" + aux.getId() + " true)"));
            }
        }
        return learner;
    }

    public static String initLDResourcesState(boolean isSQL) {
        String result = "";
        //-- default resources
        /*for (Metadata activity : LDResources.ACTIVITIES.values()) {
            if (!isSQL) {
                result += activity.toString() + endl;
                result += activity.getResource().toString() + endl;
            } else {
                result += activity.toSQL() + endl;
                result += activity.getResource().toSQL() + endl;
            }
        }
        for (Metadata service : LDResources.SERVICES.values()) {
            if (!isSQL) {
                result += service.toString() + endl;
                result += service.getResource().toString() + endl;
            } else {
                result += service.toSQL() + endl;
                result += service.getResource().toSQL() + endl;
            }
        }
        //-- default skill and attitudes
        for (Metadata skill : LDResources.SKILLS.values()) {
            if (!isSQL) {
                result += skill.toString() + endl;
                result += skill.getResource().toString() + endl;
            } else {
                result += skill.toSQL() + endl;
                result += skill.getResource().toSQL() + endl;
            }
        }
        for (Metadata attitude : LDResources.ATTITUDES.values()) {
            if (!isSQL) {
                result += attitude.toString() + endl;
                result += attitude.getResource().toString() + endl;
            } else {
                result += attitude.toSQL() + endl;
                result += attitude.getResource().toSQL() + endl;
            }
        }
        //-- metadatas
        for (Metadata level : LDResources.LEVELS.values()) {
            if (!isSQL) {
                result += level.toString() + endl;
                result += level.getResource().toString() + endl;
            } else {
                result += level.toSQL() + endl;
                result += level.getResource().toSQL() + endl;
            }
        }
        for (Metadata indGoal : LDResources.INDGOALS.values()) {
            if (!isSQL) {
                result += indGoal.toString() + endl;
                result += indGoal.getResource().toString() + endl;
            } else {
                result += indGoal.toSQL() + endl;
                result += indGoal.getResource().toSQL() + endl;
            }
        }
        for (Metadata role : LDResources.CLROLES.values()) {
            if (!isSQL) {
                result += role.toString() + endl;
                result += role.getResource().toString() + endl;
            } else {
                result += role.toSQL() + endl;
                result += role.getResource().toSQL() + endl;
            }
        }
        for (Metadata strategy : LDResources.STRATEGIES.values()) {
            if (!isSQL) {
                result += strategy.toString() + endl;
                result += strategy.getResource().toString() + endl;
            } else {
                result += strategy.toSQL() + endl;
                result += strategy.getResource().toSQL() + endl;
            }
        }
        for (Metadata clscenario : LDResources.CLSCENARIOS.values()) {
            if (!isSQL) {
                result += clscenario.toString() + endl;
                result += clscenario.getResource().toString() + endl;
            } else {
                result += clscenario.toSQL() + endl;
                result += clscenario.getResource().toSQL() + endl;
            }
        }*/
        return result;
    }

    /* --------------------------------------------------------------------------- */

    protected Map<String, Metadata> skills = new HashMap<String, Metadata>();

    protected Map<String, Metadata> funds = new HashMap<String, Metadata>();
    protected Map<String, Metadata> auxs = new HashMap<String, Metadata>();
    
    protected Map<String, Metadata> fundcomps = new HashMap<String, Metadata>();
    protected Map<String, Metadata> auxcomps = new HashMap<String, Metadata>();

    protected Map<String, Metadata> learners = new HashMap<String, Metadata>();
    
    protected Set<Relation> relations = new HashSet<Relation>();

    public int nroComps = 0;
    public int nroLearners = 0;
    public int nroAuxs = 0;
    public int nroGoals = 0;
    public int degree = 0;
    public int depth = 0;

    public TestFactory(int nroComps, int nroAuxs, int nroLearners, int nroGoals, int degree, int depth) {
        //-- set skills
        Metadata skill = new Metadata(UUID.uuid(len, "skill")).addType("Skill");
        skill.addProperty(new Property().setName("hasTitle").setValue("defaul-skill"));
		Resource skillResource = new Resource().setTitle("resource-default-skill");
		skillResource.setId(skillResource.getUuid());
		skillResource.setHref("base-url-"+ skillResource.getId());
		skill.setResource(skillResource);
        this.skills.put(skill.getId(), skill);

        //-- set competences for fundamental and fundamentals
        for (int i = 0; i < nroComps; i++) {
            //-- set fundamental
            Metadata fund = new Metadata(UUID.uuid(len, "fund")).addType("Knowledge").addType("Fundamental");
			Resource fundResource = new Resource();
			fundResource.setId(fundResource.getUuid());
			fundResource.setHref("base-url-"+ fundResource.getId());
			fundResource.setTitle("resource-fund" + fund.getId());
			fund.setResource(fundResource);
            this.funds.put(fund.getId(), fund);
            //-- set competence
            Metadata comp = new Metadata(UUID.uuid(len, "fundcomp")).addType("Competency").addType("ForFundamental");
            comp.addProperty(new Property().setName("hasSkill").setValue(skill.getId()));
            comp.addProperty(new Property().setName("hasKnowledge").setValue(fund.getId()));
            comp.addProperty(new Property().setName("hasTitle").setValue("fundamental-competency-" + comp.getId()));
            this.fundcomps.put(comp.getId(), comp);
        }

        //-- set auxiliaries
        for (int i = 0; i < nroAuxs; i++) {
            Metadata aux = buildDefaultAuxiliary(fundcomps.values(), "aux");
            this.auxs.put(aux.getId(), aux);
            //-- set competence
            Metadata comp = new Metadata(UUID.uuid(len, "auxcomp")).addType("Competency").addType("ForAuxiliary");
            comp.addProperty(new Property().setName("hasSkill").setValue(skill.getId()));
            comp.addProperty(new Property().setName("hasKnowledge").setValue(aux.getId()));
            comp.addProperty(new Property().setName("hasTitle").setValue("auxiliary-competency-" + comp.getId()));
            this.auxcomps.put(comp.getId(), comp);
        }
        
        //-- set learners
        for (int i = 0; i < nroLearners; i++) {
            Metadata learner = buildLearner(this.fundcomps.values(), this.auxs.values(), "learner");
            this.learners.put(learner.getId(), learner);
        }
        
        //-- set relations
        this.relations = this.initStructureForAuxs(this.auxs.values(), degree, depth);
        
        this.nroGoals = nroGoals;
        this.nroLearners = nroLearners;
        this.nroComps = nroComps;
    }
    
    protected Set<Relation> initStructureForAuxs(Collection<Metadata> auxs, int degree, int depth) {
        Set<Relation> relations = new HashSet<Relation>();
        Collection<Metadata> firstLevelAuxs = new HashSet<Metadata>(auxs); 
        Graph<Metadata, String> inverseIsPartOfGraph = new GraphFactory<Metadata, String>(auxs, "inverseIsPartOf").buildTree(depth);
        for (Node<Metadata> nodeFrom : inverseIsPartOfGraph.getNodes()) {
            Collection<Metadata> childrens = new HashSet<Metadata>();
            //--set isPartOf
            for (Node<Metadata> nodeTo : nodeFrom.getNeighbors()) {
                relations.add(new Relation().setSource(nodeTo.getData()).setName("isPartOf").setDest(nodeFrom.getData().getId()));
                childrens.add(nodeTo.getData());
                firstLevelAuxs.remove(nodeTo);
            }
            //-- set isRequiredBy
            if (childrens.size() > 0) {
                Graph<Metadata, String> isRequiredByGraph = new GraphFactory<Metadata, String>(childrens, "isRequiredBy").buildAcyclic(degree);
                relations.addAll(isRequiredByGraph.getRelations());
            }
        }
        relations.addAll(new GraphFactory<Metadata, String>(firstLevelAuxs, "isRequiredBy").buildAcyclic(degree).getRelations());
        return relations;
    }

    protected String getLevel() {
        String[] values = new String[]{
                "s0k0", "s0k1", "s0k2", "s0k3",
                "s1k0", "s1k1", "s1k2", "s1k3",
                "s2k0", "s2k1", "s2k2", "s2k3",
                "s3k0", "s3k1", "s3k2", "s3k3",
                "s4k0", "s4k1", "s4k2", "s4k3"};
        return values[(int) (Math.random() * values.length)];
    }

    protected String getLearnerMotivation(Metadata comp, String level, List<Metadata> group) {
        String[] values = new String[] {"very-low", "low", "medium", "high", "very-high"};
        return values[(int) (Math.random() * values.length)];
    }

    protected String getLearnerCompetencyLevel(Metadata comp, String level, List<Metadata> group) {
        String[] values = new String[]{
                "s0k0", "s0k1", "s0k2", "s0k3",
                "s1k0", "s1k1", "s1k2", "s1k3",
                "s2k0", "s2k1", "s2k2", "s2k3",
                "s3k0", "s3k1", "s3k2", "s3k3",
                "s4k0", "s4k1", "s4k2", "s4k3"};
        return values[(int) (Math.random() * values.length)];
    }

    protected String getLearningObjectiveLevelForAuxs() {
        String[] values = new String[]{
                "s0k0", "s0k1", "s0k2", "s0k3",
                "s1k0", "s1k1", "s1k2", "s1k3",
                "s2k0", "s2k1", "s2k2", "s2k3",
                "s3k0", "s3k1", "s3k2", "s3k3",
                "s4k0", "s4k1", "s4k2", "s4k3"};
        return values[(int) (Math.random() * values.length)];
    }

    public String initTask(String taskName) {
        int indx = 0;
        //-- get groupGoals
		
        ArrayList<String> fundcompIds = new ArrayList<String>(this.fundcomps.keySet());
		ArrayList<String> learnerIds = new ArrayList<String>(this.learners.keySet());

		String goals = "";
		String groups = "";
		int nroLevels = this.nroGoals / this.nroComps;
		for (String compId : fundcompIds) {
			for (int i = 0; i < nroLevels; i++) {
				String group = "";
				int offset = i * learnerIds.size() / nroLevels;
				for (int j = 0; j < learnerIds.size() / nroLevels; j++) {
					group += " " + learnerIds.get(j + offset);
				}
				groups += " (" + group.substring(1) + ")";
				goals += " (" + compId + " " + this.getLevel() + ")";
			}
		}
		goals = "(" + goals.substring(1) + ")";
		groups = "(" + groups.substring(1) + ")";
		
        //--get init task
        return "((" + taskName + " " + goals + " () () " + groups + "))" + endl;
    }
	
    /* --------------------------------------------------------------------------- */
    public static void main(String[] args) throws IOException {
        //-- check the number of arguments.
        if (args.length < 4) {
            System.err.println(String.format("usage: java %s -ln -gn [-cn] [-an] [-dn] [-hn] task output [problemName]", TestFactory.class.getName())); //-- h:depth, d:degree
            System.err.println(String.format("   or: java %s -ln -sn -fn -an testSQL output", TestFactory.class.getName()));
            System.exit(1);
        }
        //-- build problem task or SQL test input
        int nroLearners = Integer.parseInt(args[0].substring(2));
        if ("testSQL".equals(args[4])) {
            int nroAuxs = Integer.parseInt(args[3].substring(2));        
            int nroSkills = Integer.parseInt(args[1].substring(2));
            int nroFundamentals = Integer.parseInt(args[2].substring(2));
        } else {
            //-- get parameters
            int depth = 2;
            int degree = 2;
            int maxPerGroup = Integer.MAX_VALUE;
            int nroGoals = Integer.parseInt(args[1].substring(2));
            int nroComps = nroGoals / 2; //(2) nro de niveis de competencia
            int nroAuxs = nroGoals;
            if (nroGoals > 8) {
                nroAuxs = 4;
            }
            
            int offset = 0;
            if (args.length > 4) {
                if (args[2].startsWith("-c")) { nroComps = Integer.parseInt(args[2].substring(2)); offset++; }
                if (args[2].startsWith("-a")) { nroAuxs = Integer.parseInt(args[2].substring(2)); offset++; }
                if (args[2].startsWith("-d")) { degree = Integer.parseInt(args[2].substring(2)); offset++; }
                if (args[2].startsWith("-h")) { depth = Integer.parseInt(args[2].substring(2)); offset++; }   
				
                if (args.length > 3 && args[3].startsWith("-c")) { nroComps = Integer.parseInt(args[3].substring(2)); offset++; }
                if (args.length > 3 && args[3].startsWith("-a")) { nroAuxs = Integer.parseInt(args[3].substring(2)); offset++; }
                if (args.length > 3 && args[3].startsWith("-d")) { degree = Integer.parseInt(args[3].substring(2)); offset++; }
                if (args.length > 3 && args[3].startsWith("-h")) { depth = Integer.parseInt(args[3].substring(2)); offset++; }

                if (args.length > 4 && args[4].startsWith("-c")) { nroComps = Integer.parseInt(args[4].substring(2)); offset++; }
                if (args.length > 4 && args[4].startsWith("-a")) { nroAuxs = Integer.parseInt(args[4].substring(2)); offset++; }
                if (args.length > 4 && args[4].startsWith("-d")) { degree = Integer.parseInt(args[4].substring(2)); offset++; }
                if (args.length > 4 && args[4].startsWith("-h")) { depth = Integer.parseInt(args[4].substring(2)); offset++; }

                if (args.length > 5 && args[5].startsWith("-c")) { nroComps = Integer.parseInt(args[5].substring(2)); offset++; }
                if (args.length > 5 && args[5].startsWith("-a")) { nroAuxs = Integer.parseInt(args[5].substring(2)); offset++; }
                if (args.length > 5 && args[5].startsWith("-d")) { degree = Integer.parseInt(args[5].substring(2)); offset++; }
                if (args.length > 5 && args[5].startsWith("-h")) { depth = Integer.parseInt(args[5].substring(2)); offset++; }
            }
            
            String taskName = args[offset + 2];
            String outputName = args[offset + 3];
            String problemName = "problem";
            if (args.length > offset + 4) { problemName = args[offset + 4]; }

            //-- Initialize factory
            TestFactory factory = null;
            if ("createLDFundamentalUoL".equals(taskName)) {
                factory = new createLDFundamentalUoL(nroComps, nroAuxs, nroLearners, nroGoals, degree, depth);
            }

            //-- Write lisp File
            BufferedWriter dest = new BufferedWriter(new FileWriter(new File(outputName + ".lisp")));
            String s = "(defproblem " + problemName + " domain(" + endl;
            s += factory.initState();
            if (Integer.MAX_VALUE != maxPerGroup) {
                s += "(maxPerGroup " + maxPerGroup + ")" + endl;
            }
            s += "(currentLDElement nil))" + endl;
            s += factory.initTask(taskName) + endl;
            s += ")";
            dest.write(s, 0, s.length());
            dest.close();
        }
    }

    protected String initState() {
        String result = "";
        //-- description
        for (Metadata description : LDResources.SESSION_DESCRIPTIONS.values()) {
            result += description.toString() + endl;
        }
        for (Metadata description : LDResources.ILEVENT_DESCRIPTIONS.values()) {
            result += description.toString() + endl;
        }
        //-- domain model
        for (Metadata level : LDResources.LEVELS.values()) {
            result += level.toString() + endl;
        }
        for (Metadata skill : this.skills.values()) {
            result += skill.toString() + endl;
        }
        for (Metadata fund : this.funds.values()) {
            result += fund.toString() + endl;
        }
        for (Metadata comp : this.fundcomps.values()) {
            result += comp.toString() + endl;
        }
        for (Metadata aux : this.auxs.values()) {
            result += aux.toString() + endl;
        }
        for (Metadata comp : this.auxcomps.values()) {
            result += comp.toString() + endl;
        }
        //-- learner model
        for (Metadata learner : this.learners.values()) {
            result += learner.toString() + endl;
        }
        result += endl;
        result += ";; relations" + endl;
        //-- structure
        for (Relation rel : this.relations) {
            result += rel.toString() + endl;
        }
        return result;
    }


}
