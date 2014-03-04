package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.util.LDResources;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class GetCLGrouping implements Calculate {

    private Domain domain = null;

    private CLScenarioPriorityQueue clscenarioByIndGoal = new CLScenarioPriorityQueue();
    private CLScenarioPriorityQueue clscenariosByRole = new CLScenarioPriorityQueue();

    private CLScenarioList clscenarios = new CLScenarioList();
    private CLScenarioList indscenarios = new CLScenarioList();

    private int nroGroups = -1;
    private int maxPerGroup = Integer.MAX_VALUE;

    public class LearnerInfo {
        public TermConstant learnerId;
        public TermConstant compId;
        public TermConstant initStage;
        public TermConstant goalStage;
    }

    public Term call(List args) {
        //-- initialize variables
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        this.clscenarioByIndGoal = new CLScenarioPriorityQueue();
        this.clscenariosByRole = new CLScenarioPriorityQueue();

        this.clscenarios = new CLScenarioList();
        this.indscenarios = new CLScenarioList();

        ArrayList<LearnerInfo> potLearners = new ArrayList<LearnerInfo>();
        ArrayList<LearnerInfo> restLearners = new ArrayList<LearnerInfo>();

        //-- get parameters learner info from individual goals
        List learnerIndGoalList = ((TermList) args.getHead()).getList();
        while (learnerIndGoalList != null) {
            List learnerCompIndGoal = ((TermList) learnerIndGoalList.getHead()).getList();
            TermConstant learnerId = (TermConstant) learnerCompIndGoal.getHead();
            List compIndGoal = ((TermList) learnerCompIndGoal.getRest().getHead()).getList();
            TermConstant compId = (TermConstant) compIndGoal.getHead();
            String indGoal = ((TermConstant) compIndGoal.getRest().getHead()).getName();
            //--
            LearnerInfo learnerInfo = new LearnerInfo();
            learnerInfo.learnerId = learnerId;
            learnerInfo.compId = compId;
            //-- get potentials learners s1k3s4k1
            int csl = Integer.parseInt(indGoal.substring(1, 2));
            int ckl = Integer.parseInt(indGoal.substring(3, 4));
            int gsl = Integer.parseInt(indGoal.substring(5, 6));
            int gkl = Integer.parseInt(indGoal.substring(7, 8));
            //-- upgrade indGoal
            int igsl = gsl; int igkl = gkl;
            if (csl > gsl) { igsl = csl; }
            if (ckl > gkl) { igkl = ckl; }
            learnerInfo.goalStage = this.domain.getTermConstant(this.domain.addConstant("s" + igsl + "k" + igkl));
            learnerInfo.initStage = this.domain.getTermConstant(this.domain.addConstant("s" + csl + "k" + ckl));
            //--
            if ((csl < gsl) || (ckl < gkl)) {
                potLearners.add(learnerInfo);
            } else {
                restLearners.add(learnerInfo);
            }
            //-- iterate over list
            learnerIndGoalList = learnerIndGoalList.getRest();
        }

        //-- build learners
        ArrayList<LearnerInfo> learnerArray = new ArrayList<LearnerInfo>(potLearners);
        learnerArray.addAll(restLearners);
        ArrayList<LearnerInfo> allLearnerArray = new ArrayList<LearnerInfo>(learnerArray);
        if (args.getRest() != null) {
            this.nroGroups = ((TermNumber) args.getRest().getHead()).intValue();
        }

        //-- for indGoal
        for (LearnerInfo learnerInfo : potLearners) {
            for (Metadata scenarioMetadata : LDResources.CLSCENARIOS.values()) {
                for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
                    Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());
                    for (Property indGoalProperty : strategyMetadata.getProperties("hasIndividualGoal")) {
                        String indGoal = indGoalProperty.getValue();
                        if (indGoal.equals(learnerInfo.initStage.getName() + learnerInfo.goalStage.getName())) {
                            Collection<CLScenario> scenarios = this.clscenarioByIndGoal.getBy(scenarioMetadata.getId(), strategyMetadata.getId(), learnerInfo.compId, learnerInfo.goalStage);
                            for (CLScenario scenario : scenarios) {
                                if (scenario.containLearner(learnerInfo.learnerId)) { continue; }
                                CLStrategy strategy = scenario.strategies.get(strategyMetadata.getId());
                                strategy.learners = new TermList(learnerInfo.learnerId, strategy.learners);
                                scenario.strategies.put(strategy.name, strategy);
                                this.clscenarioByIndGoal.add(scenario);
                            }
                        }
                    }
                }
            }
        }

        //-- for role
        for (LearnerInfo learnerInfo : potLearners) {
            for (Metadata scenarioMetadata : LDResources.CLSCENARIOS.values()) {  
                for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
                    Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());
                    Metadata roleMetadata = LDResources.CLROLES.get(strategyMetadata.getProperties("hasRole").iterator().next().getValue());
                    for (String initStage : this.listPlayRole(learnerInfo.initStage, roleMetadata)) {
                        for (Property indGoalProperty : strategyMetadata.getProperties("hasIndividualGoal")) {
                            String indGoal = indGoalProperty.getValue();
                            if (indGoal.startsWith(initStage) && initStage.equals(learnerInfo.initStage.getName()) ) {
                                TermConstant levelTerm = this.domain.getTermConstant(this.domain.addConstant(indGoal.substring(4)));
                                Collection<CLScenario> scenariosRole = this.clscenariosByRole.getBy(scenarioMetadata.getId(), strategyMetadata.getId(), learnerInfo.compId, levelTerm);
                                for (CLScenario scenario : scenariosRole) {
                                    if (scenario.containLearner(learnerInfo.learnerId)) { continue; }
                                    CLStrategy strategy = scenario.strategies.get(strategyMetadata.getId());
                                    strategy.learners = new TermList(learnerInfo.learnerId, strategy.learners);
                                    scenario.strategies.put(strategy.name, strategy);
                                    this.clscenariosByRole.add(scenario);
                                }
                            }
                        }
                    }
                }
            }
        }

        //-- for support 
        for (LearnerInfo learnerInfo : restLearners) {
            //-- in indGoal
            for (CLScenario scenario: this.clscenarioByIndGoal) {
                if (scenario.containLearner(learnerInfo.learnerId)) { continue; }
                Metadata scenarioMetadata = LDResources.CLSCENARIOS.get(scenario.name);
                for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
                    Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());
                    Metadata roleMetadata = LDResources.CLROLES.get(strategyMetadata.getProperties("hasRole").iterator().next().getValue());
                    for (Property indGoalProperty : strategyMetadata.getProperties("hasIndividualGoal")) {
                        String indGoal = indGoalProperty.getValue();
                        if (indGoal.substring(4).equals(learnerInfo.goalStage.getName()) && !this.listPlayRole(learnerInfo.initStage, roleMetadata).isEmpty()) {
                            CLStrategy strategy = scenario.strategies.get(strategyMetadata.getId());
                            if (strategy == null) {
                                strategy = new CLStrategy();
                                strategy.name = strategyMetadata.getId();
                                strategy.level = learnerInfo.goalStage;
                            }
                            if (!strategy.level.equals(learnerInfo.goalStage)) {
                                continue;
                            }
                            strategy.learners = new TermList(learnerInfo.learnerId, strategy.learners);
                            scenario.strategies.put(strategy.name, strategy);
                        }
                    }
                }
            }

            //-- in roleGoal
            for (CLScenario scenario: this.clscenariosByRole) {
                if (scenario.containLearner(learnerInfo.learnerId)) { continue; }
                Metadata scenarioMetadata = LDResources.CLSCENARIOS.get(scenario.name);
                for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
                    Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());
                    Metadata roleMetadata = LDResources.CLROLES.get(strategyMetadata.getProperties("hasRole").iterator().next().getValue());
                    for (Property indGoalProperty : strategyMetadata.getProperties("hasIndividualGoal")) {
                        String indGoal = indGoalProperty.getValue();
                        if (indGoal.substring(4).equals(learnerInfo.goalStage.getName()) && !this.listPlayRole(learnerInfo.initStage, roleMetadata).isEmpty()) {
                            CLStrategy strategy = scenario.strategies.get(strategyMetadata.getId());
                            if (strategy == null) {
                                strategy = new CLStrategy();
                                strategy.name = strategyMetadata.getId();
                                strategy.level = learnerInfo.goalStage;
                            }
                            if (!strategy.level.equals(learnerInfo.goalStage)) {
                                continue;
                            }
                            strategy.learners = new TermList(learnerInfo.learnerId, strategy.learners);
                            scenario.strategies.put(strategy.name, strategy);
                        }
                    }
                }
            }
        }

        Set<TermConstant> exist = new HashSet<TermConstant>(); 
        while (!this.clscenarioByIndGoal.isEmpty()) {
            CLScenario scenario = this.clscenarioByIndGoal.peek();
            this.clscenarioByIndGoal.remove(scenario);
            scenario.removeLearners(exist);
            boolean hasProblem = false;
            for (Property strategyProperty : LDResources.CLSCENARIOS.get(scenario.name).getProperties("hasStrategy")) {
                String strategyId = strategyProperty.getValue();
                if (!scenario.strategies.containsKey(strategyId) ||
                        scenario.strategies.get(strategyId).learners.isNil()) {
                    hasProblem = true;
                }
                if (hasProblem) { break; }
            }
            if ("distributed-cognition".equals(scenario.name)) {
                int learnercount  = 0;
                for (CLStrategy clstrategy : scenario.strategies.values()) {
                    learnercount += clstrategy.learners.size();
                }
                if (learnercount < 2) { hasProblem = true; }
            }
            if (!hasProblem) {
                for (CLStrategy strategy : scenario.strategies.values()) {
                    List list = strategy.learners.getList();
                    while (list != null) {
                        exist.add((TermConstant) list.getHead());
                        list = list.getRest();
                    }
                }
                this.clscenarios.add(scenario);
            }
        }

        while (!this.clscenariosByRole.isEmpty()) {
            CLScenario scenario = this.clscenariosByRole.peek();
            this.clscenariosByRole.remove(scenario);
            scenario.removeLearners(exist);
            boolean hasProblem = false;
            for (Property strategyProperty : LDResources.CLSCENARIOS.get(scenario.name).getProperties("hasStrategy")) {
                String strategyId = strategyProperty.getValue();
                if (!scenario.strategies.containsKey(strategyId) ||
                        scenario.strategies.get(strategyId).learners.isNil()) {
                    hasProblem = true;
                }
                if (hasProblem) { break; }
            }
            if ("distributed-cognition".equals(scenario.name)) {
                int learnercount  = 0;
                for (CLStrategy clstrategy : scenario.strategies.values()) {
                    learnercount += clstrategy.learners.size();
                }
                if (learnercount < 2) { hasProblem = true; }
            }
            if (!hasProblem) {
                for (CLStrategy strategy : scenario.strategies.values()) {
                    List list = strategy.learners.getList();
                    while (list != null) {
                        exist.add((TermConstant) list.getHead());
                        list = list.getRest();
                    }
                }
                this.clscenarios.add(scenario);
            }
        }


        //-- individual strategy
        for (LearnerInfo learnerInfo : learnerArray) {
            if (!exist.contains(learnerInfo.learnerId)) {
                this.createUpdateIndependentCLScenario(learnerInfo);
            }
        }

        int diff = this.nroGroups - this.clscenarios.size();
        if (this.nroGroups > 0 && this.clscenarios.size()!=(this.nroGroups-1)) {
            if (this.clscenarios.size() < (this.nroGroups-1)) {
                //-- dividir ate obter o valor necesario
                Set<CLScenario> toAdd = new HashSet<CLScenario>();
                do {
                    toAdd = new HashSet<CLScenario>(); 
                    for (CLScenario clscenario : this.clscenarios.values()) {
                        boolean canDivide = true;
                        for (CLStrategy clstrategy : clscenario.strategies.values()) {
                            if (clstrategy.learners.getList().size() < 2) {
                                canDivide = false;
                                break;
                            }
                        }
                        if (canDivide) {
                            CLScenario newscenario = new CLScenario();
                            newscenario.name = clscenario.name;
                            newscenario.comp = clscenario.comp;
                            for (CLStrategy strategy : clscenario.strategies.values()) {
                                CLStrategy newstrategy = new CLStrategy();
                                newstrategy.name = strategy.name;
                                newstrategy.level = strategy.level;
                                //-- get learners for strategy
                                int nrolearners = strategy.learners.size() / 2;
                                List learnerList = strategy.learners.getList();
                                while (learnerList != null && (newstrategy.learners.getList().size() < nrolearners)) {
                                    newstrategy.learners = new TermList(learnerList.getHead(), newstrategy.learners);
                                    learnerList = learnerList.getRest();
                                }
                                strategy.learners = new TermList(learnerList);
                                //--
                                clscenario.strategies.put(strategy.name, strategy);
                                newscenario.strategies.put(newstrategy.name, newstrategy);
                                //--
                                this.clscenarios.add(clscenario);
                                toAdd.add(newscenario);
                            }
                            diff = diff - 1;
                        }
                        if (diff<=1) {
                            break;
                        }
                    }
                    for (CLScenario scenario : toAdd) {
                        this.clscenarios.add(scenario);
                    }
                } while (!toAdd.isEmpty() && diff > 1);
            } else if (this.clscenarios.size() > (this.nroGroups-1)) {
                //-- remove inecesary clscenario and push it in individual
                HashSet<LearnerInfo> learnersWithProblem = new HashSet<LearnerInfo>(allLearnerArray);
                java.util.List<String> clscenarioIds = new ArrayList<String>(this.clscenarios.keySet()).subList(this.nroGroups-1, this.clscenarios.size());
                for (String id : clscenarioIds) {
                    CLScenario clscenario = this.clscenarios.remove(id);
                    for (CLStrategy clstrategy : clscenario.strategies.values()) {
                        List list = clstrategy.learners.getList();
                        while (list != null) {
                            for (LearnerInfo find : learnerArray) {
                                if (((TermConstant) list.getHead()).equals(find.learnerId) &&
                                        find.compId.equals(clscenario.comp)) {
                                    learnersWithProblem.add(find);
                                    break;
                                }
                            }
                            list = list.getRest();
                        }
                    }
                }
                //-- solve problems using individual value
                for (LearnerInfo learnerInfo : learnersWithProblem) {
                    this.createUpdateIndependentCLScenario(learnerInfo);
                }
            }
        }

        //-- obtain individual scenario (TODO)
        TermList toReturn = TermList.NIL;
        /*for (CLScenario indscenario : this.indscenarios.values()) {
            //if ((this.nroGroups > 0) && (diff > 1)){ }
            TermList strategiesGoalsLearnersTermList = TermList.NIL;
            for (CLStrategy strategy : indscenario.strategies.values()) {
                TermConstant strategyNameTerm = this.domain.getTermConstant(this.domain.addConstant("indstrategy"));
                TermList goalTerm = new TermList(indscenario.comp, new TermList(strategy.level, TermList.NIL));
                TermList strategyGoalLearners = new TermList(strategyNameTerm, new TermList(goalTerm, new TermList(strategy.learners, TermList.NIL)));
                strategiesGoalsLearnersTermList = new TermList(strategyGoalLearners, strategiesGoalsLearnersTermList);
            } 
            toReturn = new TermList(new TermList(this.domain.getTermConstant(this.domain.addConstant(indscenario.name)), new TermList(strategiesGoalsLearnersTermList, TermList.NIL)), toReturn);
        }*/
        if (!this.indscenarios.isEmpty()) {
            TermList strategiesGoalsLearnersTermList = TermList.NIL;
            for (CLScenario indscenario : this.indscenarios.values()) {
                //if ((this.nroGroups > 0) && (diff > 1)){ }
                for (CLStrategy strategy : indscenario.strategies.values()) {
                    TermConstant strategyNameTerm = this.domain.getTermConstant(this.domain.addConstant("indstrategy"));
                    TermList goalTerm = new TermList(indscenario.comp, new TermList(strategy.level, TermList.NIL));
                    TermList strategyGoalLearners = new TermList(strategyNameTerm, new TermList(goalTerm, new TermList(strategy.learners, TermList.NIL)));
                    strategiesGoalsLearnersTermList = new TermList(strategyGoalLearners, strategiesGoalsLearnersTermList);
                } 
            }
            toReturn = new TermList(new TermList(this.domain.getTermConstant(this.domain.addConstant("independent")), new TermList(strategiesGoalsLearnersTermList, TermList.NIL)), toReturn);
        }

        //-- iterate over scenarios
        for (CLScenario clscenario : this.clscenarios.values()) {
            TermList strategiesGoalsLearnersTermList = TermList.NIL;
            for (CLStrategy strategy : clscenario.strategies.values()) {
                TermConstant strategyNameTerm = this.domain.getTermConstant(this.domain.addConstant(strategy.name));
                TermList goalTerm = new TermList(clscenario.comp, new TermList(strategy.level, TermList.NIL));
                TermList strategyGoalLearners = new TermList(strategyNameTerm, new TermList(goalTerm, new TermList(strategy.learners, TermList.NIL)));
                strategiesGoalsLearnersTermList = new TermList(strategyGoalLearners, strategiesGoalsLearnersTermList);
            }
            toReturn = new TermList(new TermList(this.domain.getTermConstant(this.domain.addConstant(clscenario.name)), new TermList(strategiesGoalsLearnersTermList, TermList.NIL)), toReturn);
        }
        System.out.println("clgrouping result: " + toReturn.toString());
        return toReturn;
    }

    private void createUpdateIndependentCLScenario(LearnerInfo learnerInfo) {
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        // new independent clscenario
        CLScenario indscenario = new CLScenario();
        indscenario.name = "independent";
        indscenario.comp = learnerInfo.compId;
        // search in this.clscenarios of clscenario
        Set<CLScenario> clscenariosSet = this.indscenarios.getCLScenariosBy(indscenario.name, learnerInfo.compId,
                "indstrategy" + learnerInfo.goalStage.getName(), learnerInfo.goalStage);
        for (CLScenario element : clscenariosSet) {
            CLStrategy strategy = element.strategies.get("indstrategy" + learnerInfo.goalStage.getName());
            if (strategy == null || strategy.learners.size() < this.maxPerGroup) {
                indscenario = element;
                break;
            }
        }
        // get strategy
        CLStrategy strategy = indscenario.strategies.get("indstrategy" + learnerInfo.goalStage.getName());
        if (strategy == null) {
            strategy = new CLStrategy();
            strategy.name = "indstrategy" + learnerInfo.goalStage.getName();
            strategy.level = learnerInfo.goalStage;
        }
        // set learner list
        strategy.learners = new TermList(learnerInfo.learnerId, strategy.learners);
        indscenario.strategies.put(strategy.name, strategy);
        // update or save clscenario
        this.indscenarios.add(indscenario);
    }

    private Set<String> listPlayRole(TermConstant initStage, Metadata roleMetadata) {
        Set<String> toReturn = new HashSet<String>();
        for (Property levelProperty : roleMetadata.getProperties("hasCompetencyLevel")) {
            int csl = Integer.parseInt(initStage.getName().substring(1, 2));
            int ckl = Integer.parseInt(initStage.getName().substring(3, 4));
            int rsl = Integer.parseInt(levelProperty.getValue().substring(1, 2));
            int rkl = Integer.parseInt(levelProperty.getValue().substring(3, 4));
            if (csl >= rsl && ckl >= rkl) {
                toReturn.add(levelProperty.getValue());
            }
        }
        return toReturn;
    }

}
