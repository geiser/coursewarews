
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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


public class CopyOfGetCLGrouping implements Calculate {

	private Domain domain = null;
	private CLScenarioList clscenarios = new CLScenarioList();

	private int maxPerGroup = Integer.MAX_VALUE;

	public class CLStrategy {
		public String name;
		public TermList goal;
		public TermList learners = TermList.NIL;
		@Override
		public int hashCode() {
			int toReturn = 1;
			if (name != null) { toReturn *= name.hashCode(); }
			if (goal != null) { toReturn *= goal.hashCode(); }
			if (!learners.isNil()) { toReturn *= learners.hashCode(); }
			return toReturn;
		}
	}

	public class CLScenario {
		public String id = null;
		public String name;
		public Map<String, CLStrategy> strategies = new HashMap<String, CLStrategy>();
		@Override
		public int hashCode() {
			int toReturn = 1;
			if (id != null) { return id.hashCode(); }
			if (name != null) { toReturn *= name.hashCode(); }
			for (CLStrategy strategy : strategies.values()) {
				toReturn *= strategy.hashCode();
			}
			return toReturn;
		}
	}

	public class CLScenarioList {

		private final Map<String, CLScenario> clscenarios = new HashMap<String, CLScenario>();

		/**
		 * clscenarios by competency and name
		 *  - key -> competency : termConstant
		 *  - value -> (level, set of scenarios) : map<String, CLScenario>
		 */
		 private final Map<TermConstant, Map<String, HashSet<CLScenario>>> clscenariosByCompName = new HashMap<TermConstant, Map<String, HashSet<CLScenario>>>(); // element used to search

		 public CLScenarioList save(CLScenario clscenario, TermConstant compTerm) {
			 if (clscenario.id == null) {
				 clscenario.id = UUID.randomUUID().toString();
			 }
			 this.clscenarios.put(clscenario.id, clscenario);
			 //-- get clscenarios using competences and name
			 Map<String, HashSet<CLScenario>> clscenariosByScenarioName = this.clscenariosByCompName.get(compTerm);
			 if (clscenariosByScenarioName == null) {
				 clscenariosByScenarioName = new HashMap<String, HashSet<CLScenario>>();
			 }
			 HashSet<CLScenario> clscenariosSet = clscenariosByScenarioName.get(clscenario.name);
			 if (clscenariosSet == null) {
				 clscenariosSet = new HashSet<CLScenario>();
			 }
			 //-- put clscenario in array list
			 boolean isAdd = clscenariosSet.add(clscenario);
			 if (!isAdd) {
				 clscenariosSet.remove(clscenario);
				 clscenariosSet.add(clscenario);
			 }
			 // -- put clscenario using goal
			 clscenariosByScenarioName.put(clscenario.name, clscenariosSet);
			 // -- put clscenario using term comp
			 this.clscenariosByCompName.put(compTerm, clscenariosByScenarioName);
			 return this;
		 }

		 public CLScenarioList remove(CLScenario clscenario, TermConstant compTerm) {
			 clscenario = this.clscenarios.remove(clscenario.id);
			 //-- get clscenarios using name
			 Map<String, HashSet<CLScenario>> clscenariosByScenarioName = this.clscenariosByCompName.get(compTerm);
			 if (clscenariosByScenarioName == null) {
				 clscenariosByScenarioName = new HashMap<String, HashSet<CLScenario>>();
			 }
			 HashSet<CLScenario> clscenariosSet = clscenariosByScenarioName.get(clscenario.name);
			 if (clscenariosSet == null) {
				 clscenariosSet = new HashSet<CLScenario>();
			 }

			 //-- remove clscenario in set
			 clscenariosSet.remove(clscenario);
			 // -- put clscenario using goal
			 clscenariosByScenarioName.put(clscenario.name, clscenariosSet);
			 // -- put clscenario using strategy
			 this.clscenariosByCompName.put(compTerm, clscenariosByScenarioName);
			 return this;
		 }

		 public HashSet<CLScenario> getCLScenarios(TermConstant compTerm, String clscenario) {
			 if (this.clscenariosByCompName.containsKey(compTerm)) {
				 if (this.clscenariosByCompName.get(compTerm).containsKey(clscenario)) {
					 return this.clscenariosByCompName.get(compTerm).get(clscenario);
				 }
			 }
			 return null; 
		 }

		 public Collection<CLScenario> listAll() {
			 return this.clscenarios.values();
		 }

		 public CLScenarioList remove(CLScenario clscenario) {
			 TermList goalTerm = clscenario.strategies.values().iterator().next().goal;
			 return this.remove(clscenario, (TermConstant) goalTerm.getList().getHead());
		 }

	}

	public class LearnerInfo {
		public String learnerId;
		public String compId;
		public String initStage;
		public String goalStage;
	}

	public Term call(List args) {
		//-- initialize variables
		Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
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
		int nroGroups = learnerArray.size() / 4;
		if (args.getRest() != null) {
			nroGroups = ((TermNumber) args.getRest().getHead()).intValue();
		}

		//-- get collaborative scenarios to iterate
		ArrayList<Metadata> scenarioMetadatas = new ArrayList<Metadata>(LDResources.CLSCENARIOS.values());
		if (scenarioMetadatas.size() > nroGroups) {
			scenarioMetadatas.subList(0, nroGroups-1);
		}
		for (int i = LDResources.CLSCENARIOS.values().size();  i < nroGroups; i++) {
			ArrayList<Metadata> tmpScenarios = new ArrayList<Metadata>(LDResources.CLSCENARIOS.values());
			int index = (int) (tmpScenarios.size() * Math.random());
			scenarioMetadatas.add(tmpScenarios.get(index));
		}

		for (int i = 0; i < learnerArray.size(); i++) {
			LearnerInfo learnerInfo = learnerArray.get(i);
			Metadata scenarioMetadata = scenarioMetadatas.get(i % scenarioMetadatas.size());
			ArrayList<Property> strategyProperties = new ArrayList<Property>(scenarioMetadata.getProperties("hasStrategy"));
			int index =  (int) (Math.random() * strategyProperties.size());
			Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperties.get(index).getValue());
			learnerInfo.goalStage = new ArrayList<Property>(strategyMetadata.getProperties("hasIndividualGoal")).get(0).getValue().substring(4);
			createUpdateCLScenarios(scenarioMetadata, strategyMetadata, learnerInfo);
		}

		//-- iterate over cl scenarios to find problems
		ArrayList<CLScenario> toRemove = new ArrayList<CLScenario>();
		Set<LearnerInfo> learnersWithProblem = new HashSet<LearnerInfo>();
		for (CLScenario clscenario : this.clscenarios.listAll()) {
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
						LearnerInfo learnerInfo = new LearnerInfo();
						learnerInfo.learnerId = ((TermConstant) list.getHead()).getName();
						learnerInfo.compId = ((TermConstant) clstrategy.goal.getList().getHead()).getName();
						String indGoal = ((TermConstant) clstrategy.goal.getList().getRest().getHead()).getName();
						learnerInfo.initStage = indGoal.substring(0, 4);
						learnerInfo.goalStage = indGoal.substring(4);
						//--add and iterate
						learnersWithProblem.add(learnerInfo);
						list = list.getRest();
					}
				}
				toRemove.add(clscenario);
			}
		}
		for (CLScenario clscenario : toRemove) { this.clscenarios.remove(clscenario); }

		int nroLearnersByScenario = learnersWithProblem.size() / scenarioMetadatas.size();
		//int nroLearnersByScenario = ((int) Math.random() * learnersWithProblem.size());
		//if (nroLearnersByScenario < 4 ) { nroLearnersByScenario = 4; }
		for (Metadata scenarioMetadata : scenarioMetadatas) {
			int i = 0;
			while (i < nroLearnersByScenario) {
				for (Property strategyProperty : scenarioMetadata.getProperties("hasStrategy")) {
					Metadata strategyMetadata = LDResources.STRATEGIES.get(strategyProperty.getValue());// (Metadata) strategyProperty.getDestination();
					String indGoal = strategyMetadata.getProperties("hasIndividualGoal").iterator().next().getValue();
					ArrayList<LearnerInfo> learnerInfoWithProblem = new ArrayList<LearnerInfo>(learnersWithProblem);
					int idx = (int) (Math.random() * learnerInfoWithProblem.size());
					//System.out.println("index:" + idx);
					if (!learnerInfoWithProblem.isEmpty()) {
						LearnerInfo learner = learnerInfoWithProblem.get(0);
						learnersWithProblem.remove(learner);
						//learner.initStage = indGoal.substring(0, 4);
						learner.goalStage = indGoal.substring(4);
						createUpdateCLScenarios(scenarioMetadata, strategyMetadata, learner);
					}
					i++;
				}
			}
		}

		//-- iterate over cl scenarios to find problems
		toRemove = new ArrayList<CLScenario>();
		learnersWithProblem = new HashSet<LearnerInfo>();
		for (CLScenario clscenario : this.clscenarios.listAll()) {
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
						LearnerInfo learnerInfo = new LearnerInfo();
						learnerInfo.learnerId = ((TermConstant) list.getHead()).getName();
						learnerInfo.compId = ((TermConstant) clstrategy.goal.getList().getHead()).getName();
						String indGoal = ((TermConstant) clstrategy.goal.getList().getRest().getHead()).getName();
						learnerInfo.initStage = indGoal.substring(0, 4);
						learnerInfo.goalStage = indGoal.substring(4);
						//--add and iterate
						learnersWithProblem.add(learnerInfo);
						list = list.getRest();
					}
				}
				toRemove.add(clscenario);
			}
		}
		for (CLScenario clscenario : toRemove) { this.clscenarios.remove(clscenario); }


		//-- solve problems using individual value
		for (LearnerInfo learner : learnersWithProblem) {
			for (LearnerInfo learnerInfo : learnerArray) {
				if (learner.learnerId.equals(learnerInfo.learnerId) &&
						learner.compId.equals(learnerInfo.compId) //&&
						//learner.initStage.equals(learnerInfo.initStage)
						) {                    
					this.createUpdateIndependentCLScenario(learnerInfo);
					break;
				}
			}
		}

		//-- obtain to return term list (TODO)
		TermList toReturn = TermList.NIL;
		for (CLScenario clscenario : this.clscenarios.listAll()) {
			TermList strategiesGoalsLearnersTermList = TermList.NIL;
			for (CLStrategy strategy : clscenario.strategies.values()) {
				TermConstant strategyNameTerm = domain.getTermConstant(domain.addConstant(strategy.name));
				TermList strategyGoalLearners = new TermList(strategyNameTerm, new TermList(strategy.goal, new TermList(strategy.learners, TermList.NIL)));
				strategiesGoalsLearnersTermList = new TermList(strategyGoalLearners, strategiesGoalsLearnersTermList);
			}
			toReturn = new TermList(new TermList(domain.getTermConstant(domain.addConstant(clscenario.name)), new TermList(strategiesGoalsLearnersTermList, TermList.NIL)), toReturn);
		}
		System.out.println("clgrouping result: " + toReturn.toString());
		return toReturn;
	}

	private void createUpdateCLScenarios(Metadata scenarioMetadata, Metadata strategyMetadata, LearnerInfo learnerInfo) {
		this.domain = JSHOP2Provider.getJSHOP2().getDomain();
		// new clscenario
		CLScenario clscenario = new CLScenario();
		clscenario.name = scenarioMetadata.getId();
		// search in this.clscenarios of clscenario
		TermConstant compTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
		TermConstant levelTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.goalStage));
		TermList goal = new TermList(compTerm, new TermList(levelTerm, TermList.NIL));
		HashSet<CLScenario> clscenariosSet = this.clscenarios.getCLScenarios(compTerm, clscenario.name);
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
			strategy.goal = goal;
		}
		// set learner list
		strategy.learners = new TermList(domain.getTermConstant(domain.addConstant(learnerInfo.learnerId)), strategy.learners);
		clscenario.strategies.put(strategy.name, strategy);
		// update or save clscenario
		this.clscenarios.save(clscenario, compTerm);
	}

	private void createUpdateIndependentCLScenario(LearnerInfo learnerInfo) {
		this.domain = JSHOP2Provider.getJSHOP2().getDomain();
		// new independent clscenario
		CLScenario clscenario = new CLScenario();
		clscenario.name = "independent";
		// search in this.clscenarios of clscenario
		TermConstant compTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.compId));
		TermConstant levelTerm = this.domain.getTermConstant(this.domain.addConstant(learnerInfo.goalStage));
		TermList goal = new TermList(compTerm, new TermList(levelTerm, TermList.NIL));
		HashSet<CLScenario> clscenariosSet = this.clscenarios.getCLScenarios(compTerm, clscenario.name);
		if (clscenariosSet != null) {
			for (CLScenario element : clscenariosSet) {
				int maxPerStrategy = this.maxPerGroup;
				CLStrategy strategy = element.strategies.get("indstrategy");
				if (strategy == null || strategy.learners.size() < maxPerStrategy) {
					clscenario = element;
					break;
				}
			}
		}
		// get strategy
		CLStrategy strategy = clscenario.strategies.get("indstrategy");
		if (strategy == null) {
			strategy = new CLStrategy();
			strategy.name = "indstrategy";
			strategy.goal = goal;
		}
		// set learner list
		strategy.learners = new TermList(domain.getTermConstant(domain.addConstant(learnerInfo.learnerId)), strategy.learners);
		clscenario.strategies.put(strategy.name, strategy);
		// update or save clscenario
		this.clscenarios.save(clscenario, compTerm);
	}

	private boolean canPlayRole(String indGoal, Metadata roleMetadata) {
		boolean canPlayRole = false;
		Set<Property> levelProperties = roleMetadata.getProperties("hasCompetencyLevel");
		for (Property levelProperty : levelProperties) {
			int csl = Integer.parseInt(indGoal.substring(1, 2));
			int ckl = Integer.parseInt(indGoal.substring(3, 4));
			int rsl = Integer.parseInt(levelProperty.getValue().substring(1, 2));
			int rkl = Integer.parseInt(levelProperty.getValue().substring(3, 4));
			if (csl >= rsl && ckl >= rkl) {
				canPlayRole = true;
				break;
			}
		}
		return canPlayRole;
	}

}