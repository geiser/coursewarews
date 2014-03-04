package createLDFundamentalUoL;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import br.usp.ime.lapessc.coursegenerator.model.Metadata;
import br.usp.ime.lapessc.coursegenerator.model.Property;
import br.usp.ime.lapessc.coursegenerator.planner.jshop2ip.CLScenario;
import br.usp.ime.lapessc.coursegenerator.planner.jshop2ip.CLScenarioList;
import br.usp.ime.lapessc.coursegenerator.planner.jshop2ip.CLStrategy;
import br.usp.ime.lapessc.coursegenerator.planner.jshop2ip.GetCLGroupingOld.LearnerInfo;
import br.usp.ime.lapessc.coursegenerator.util.LDResources;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;


public class GetCLGrouping implements Calculate {



    public class LearnerInfo {
        public String learnerId;
        public String compId;
        public String initStage;
        public String goalStage;
    }

    private Domain domain = null;
    private CLScenarioList clscenarios = new CLScenarioList();

    private int maxPerGroup = Integer.MAX_VALUE;

    public Term call(List args) {
        //-- initialize variables
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        this.clscenarios = new CLScenarioList();

        ArrayList<LearnerInfo> potLearners = new ArrayList<LearnerInfo>();
        ArrayList<LearnerInfo> restLearners = new ArrayList<LearnerInfo>();

        //-- get parameters learner info from individual goals
        List learnerIndGoalList = ((TermList) args.getHead()).getList();
        while (learnerIndGoalList != null) {
            List learnerCompIndGoal = ((TermList) learnerIndGoalList.getHead()).getList();
            String learnerId = ((TermConstant) learnerCompIndGoal.getHead()).getName();
            List compIndGoal = ((TermList) learnerCompIndGoal.getRest().getHead()).getList();
            String comp = ((TermConstant) compIndGoal.getHead()).getName();
            String indGoal = ((TermConstant) compIndGoal.getRest().getHead()).getName();
            //--
            LearnerInfo learnerInfo = new LearnerInfo();
            learnerInfo.learnerId = learnerId;
            learnerInfo.compId = comp;
            //-- get potentials learners s1k3s4k1
            int csl = Integer.parseInt(indGoal.substring(1, 2));
            int ckl = Integer.parseInt(indGoal.substring(3, 4));
            int gsl = Integer.parseInt(indGoal.substring(5, 6));
            int gkl = Integer.parseInt(indGoal.substring(7, 8));
            //-- upgrade indGoal
            int igsl = gsl; int igkl = gkl;
            if (csl > gsl) { igsl = csl; }
            if (ckl > gkl) { igkl = ckl; }
            learnerInfo.goalStage = "s" + igsl + "k" + igkl;
            learnerInfo.initStage = "s" + csl + "k" + ckl;
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

        //-- get nro groups (last group is individual group)
        int nroGroups = LDResources.CLSCENARIOS.size();

        //if (nroGroups > learnerArray.size()) { //-- intentar com grupo de 128, 64, 32, 16, 8, 4 estudantes
        nroGroups = learnerArray.size() / 128;
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 64; }
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 32; }
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 16; }
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 8; }
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 4; }
        if (nroGroups == 0) { nroGroups = learnerArray.size() / 2; }
        if (nroGroups == 0) { nroGroups = 1; } //}
        if (args.getRest() != null) {
            nroGroups = ((TermNumber) args.getRest().getHead()).intValue();
        }
        
        //-- get collaborative scenarios to iterate
        int nroPerGroups = learnerArray.size() / nroGroups;
        //System.out.println("nroGroups : " + nroGroups + " - nroPerGroups : " + nroPerGroups);
        TermConstant compTerm = this.domain.getTermConstant(this.domain.addConstant(learnerArray.get(0).compId));
        ArrayList<Metadata> scenarioMetadatas = new ArrayList<Metadata>(LDResources.CLSCENARIOS.values());
        for (int i = 0; i < nroGroups; i++) {
            int scenarioIdx = (int) (Math.random() * scenarioMetadatas.size());
            Metadata scenarioMetadata = scenarioMetadatas.get(scenarioIdx);
            Map<String, CLStrategy> strategies = new HashMap<String, CLStrategy>();
            for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
                Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());
                String level = new ArrayList<Property>(strategyMetadata.getProperties("hasIndividualGoal")).get(0).getValue().substring(4);
                TermList learnersTerm = TermList.NIL;
                for (int j = 0; j < nroPerGroups / scenarioMetadata.getProperties("hasStrategy").size(); j++) {
                    if (learnerArray.size() > 0) {
                        int learnerIdx = (int) (Math.random() * learnerArray.size());
                        LearnerInfo learner = learnerArray.get(learnerIdx);
                        learnersTerm = new TermList(this.domain.getTermConstant(this.domain.addConstant(learner.learnerId)), learnersTerm);
                        learnerArray.remove(learnerIdx);
                    }
                }
                //-- set strategy
                CLStrategy strategy = new CLStrategy();
                strategy.name = strategyMetadata.getId();
                strategy.level = this.domain.getTermConstant(this.domain.addConstant(level));
                strategy.learners = learnersTerm;
                //-- put data in strategies
                strategies.put(strategy.name, strategy);
            }
            //-- set clscenario
            CLScenario clscenario = new CLScenario();
            clscenario.name = scenarioMetadata.getId();
            clscenario.comp = compTerm;
            clscenario.strategies = strategies;
            //-- put data in clscenarios
            this.clscenarios.add(clscenario);
        }


        //-- iterate over cl scenarios to find problems
        ArrayList<CLScenario> toRemove = new ArrayList<CLScenario>();
        HashSet<LearnerInfo> learnersWithProblem = new HashSet<LearnerInfo>();
        for (CLScenario clscenario : this.clscenarios.values()) {
            boolean hasProblem = false;
            //-- validate clscenarios have all strategies
            for (Property strategyProperty : LDResources.CLSCENARIOS.get(clscenario.name).getProperties("hasStrategy")) {
                String strategyId = strategyProperty.getValue();
                if (!clscenario.strategies.containsKey(strategyId)) {
                    hasProblem = true;
                } else if (clscenario.strategies.get(strategyId).learners.isNil()) {
                    hasProblem = true;
                }
                if (hasProblem) { break; }
            }
            //-- get learners with problem and remove scenario
            if (hasProblem) {
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
                toRemove.add(clscenario);
            }
        }
        for (CLScenario clscenario : toRemove) {
        	this.clscenarios.remove(clscenario);
        }

        //-- obtain to return term list (TODO)
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        TermList toReturn = TermList.NIL;
        for (CLScenario clscenario : this.clscenarios.values()) {
            TermList strategiesGoalsLearnersTermList = TermList.NIL;
            for (CLStrategy strategy : clscenario.strategies.values()) {
                TermConstant strategyNameTerm = domain.getTermConstant(domain.addConstant(strategy.name));
                TermList goalTerm = new TermList(clscenario.comp, new TermList(strategy.level, TermList.NIL));
				TermList strategyGoalLearners = new TermList(strategyNameTerm, new TermList(goalTerm, new TermList(strategy.learners, TermList.NIL)));
                strategiesGoalsLearnersTermList = new TermList(strategyGoalLearners, strategiesGoalsLearnersTermList);
            }
            toReturn = new TermList(new TermList(domain.getTermConstant(domain.addConstant(clscenario.name)), new TermList(strategiesGoalsLearnersTermList, TermList.NIL)), toReturn);
        }
        //System.out.println(" -> clgrouping result: " + toReturn.toString());
        return toReturn;
    }

    private void createUpdateCLScenarios(String id, Metadata scenarioMetadata, Metadata strategyMetadata, LearnerInfo learnerInfo) {
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        // new clscenario
        CLScenario clscenario = new CLScenario();
        clscenario.name = scenarioMetadata.getId();
        clscenario.comp = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
        clscenario.id = id;
        // search in this.clscenarios of clscenario
        TermConstant compTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
        TermConstant levelTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.goalStage));
        TermList goal = new TermList(compTerm, new TermList(levelTerm, TermList.NIL));
        Set<CLScenario> clscenariosSet = this.clscenarios.getCLScenariosBy(scenarioMetadata.getId(), compTerm, strategyMetadata.getId(), levelTerm);
        if (clscenariosSet != null) {
            for (CLScenario element : clscenariosSet) {
                int maxPerStrategy = this.maxPerGroup / scenarioMetadata.getProperties("hasStrategy").size();
                CLStrategy strategy = element.strategies.get(strategyMetadata.getId());
                if (strategy == null || strategy.learners.size() < maxPerStrategy) {
                    clscenario = element;
                    break;
                }
            }
        }
        // get strategy
        CLStrategy strategy = clscenario.strategies.get(strategyMetadata.getId());
        if (strategy == null) {
            strategy = new CLStrategy();
            strategy.name = strategyMetadata.getId();
            strategy.level = levelTerm;
        }
        // set learner list
        strategy.learners = new TermList(domain.getTermConstant(domain.addConstant(learnerInfo.learnerId)), strategy.learners);
        clscenario.strategies.put(strategy.name, strategy);
        // update or save clscenario
        this.clscenarios.add(clscenario);
    }

    private void createUpdateIndependentCLScenario(LearnerInfo learnerInfo) {
        this.domain = JSHOP2Provider.getJSHOP2().getDomain();
        // new independent clscenario
        CLScenario clscenario = new CLScenario();
        clscenario.name = "independent";
        clscenario.comp = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
        // search in this.clscenarios of clscenario
        TermConstant compTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
        TermConstant levelTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.goalStage));
        TermList goal = new TermList(compTerm, new TermList(levelTerm, TermList.NIL));
        Set<CLScenario> clscenariosSet = this.clscenarios.getCLScenariosBy("independent", compTerm, "indstrategy" + learnerInfo.goalStage, levelTerm);
        if (clscenariosSet != null) {
            for (CLScenario element : clscenariosSet) {
                int maxPerStrategy = this.maxPerGroup;
                CLStrategy strategy = element.strategies.get("indstrategy" + learnerInfo.goalStage);
                if (strategy == null || strategy.learners.size() < maxPerStrategy) {
                    clscenario = element;
                    break;
                }
            }
        }
        // get strategy
        CLStrategy strategy = clscenario.strategies.get("indstrategy" + learnerInfo.goalStage);
        if (strategy == null) {
            strategy = new CLStrategy();
            strategy.name = "indstrategy" + learnerInfo.goalStage;
            strategy.level = levelTerm;
        }
        // set learner list
        strategy.learners = new TermList(domain.getTermConstant(domain.addConstant(learnerInfo.learnerId)), strategy.learners);
        clscenario.strategies.put(strategy.name, strategy);
        // update or save clscenario
        this.clscenarios.add(clscenario);
    }

}

