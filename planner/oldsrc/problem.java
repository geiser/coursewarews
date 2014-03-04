import java.util.LinkedList;
import com.gamalocus.jshop2rt.*;

public class problem
{
	public static final String sourcePath = "/Users/gcc/workspace/automated-learning-design/planner/build/problem.lisp";
	public static final long sourceLastModified = 1328745883000L;

	public static final Domain owner = new domain();

	private static String[] defineConstants(Domain owner)
	{
		String[] problemConstants = new String[23];

		owner.addConstant("KnowledgeElement");
		owner.addConstant("k23fe234");
		owner.addConstant("hasTitle");
		owner.addConstant("paper-x");
		owner.addConstant("c103d678");
		owner.addConstant("understand-paper-x");
		owner.addConstant("hasKnowledge");
		owner.addConstant("c02ad23f");
		owner.addConstant("understand-section-1");
		owner.addConstant("c01ae13d");
		owner.addConstant("understand-section-2");
		owner.addConstant("encorage-discussion");
		owner.addConstant("encorajar-discusion");
		owner.addConstant("interdependencia-positiva");
		owner.addConstant("responsabilidade-individual");
		owner.addConstant("u123f098");
		owner.addConstant("unit-of-test");
		owner.addConstant("learner1");
		owner.addConstant("medium");
		owner.addConstant("learner2");
		owner.addConstant("learner3");
		owner.addConstant("learner4");
		owner.addConstant("hasMaxParticipant");

		return problemConstants;
	}

	private static void createState0(Domain owner, State s)	{
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("KnowledgeElement") /*95*/, new TermList(owner.getTermConstant("k23fe234") /*96*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("k23fe234") /*96*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("paper-x") /*98*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("CognitiveCompetency") /*77*/, new TermList(owner.getTermConstant("c103d678") /*99*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c103d678") /*99*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("understand-paper-x") /*100*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c103d678") /*99*/, new TermList(owner.getTermConstant("hasKnowledge") /*101*/, new TermList(owner.getTermConstant("k23fe234") /*96*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("CognitiveCompetency") /*77*/, new TermList(owner.getTermConstant("c02ad23f") /*102*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c02ad23f") /*102*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("understand-section-1") /*103*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c02ad23f") /*102*/, new TermList(owner.getTermConstant("hasKnowledge") /*101*/, new TermList(owner.getTermConstant("k23fe234") /*96*/, TermList.NIL)))));
		s.add(new Predicate(18, 0, new TermList(owner.getTermConstant("c02ad23f") /*102*/, new TermList(owner.getTermConstant("isPartOf") /*17*/, new TermList(owner.getTermConstant("c103d678") /*99*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("CognitiveCompetency") /*77*/, new TermList(owner.getTermConstant("c01ae13d") /*104*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c01ae13d") /*104*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("understand-section-2") /*105*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("c01ae13d") /*104*/, new TermList(owner.getTermConstant("hasKnowledge") /*101*/, new TermList(owner.getTermConstant("k23fe234") /*96*/, TermList.NIL)))));
		s.add(new Predicate(18, 0, new TermList(owner.getTermConstant("c01ae13d") /*104*/, new TermList(owner.getTermConstant("isPartOf") /*17*/, new TermList(owner.getTermConstant("c103d678") /*99*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("Skill") /*62*/, new TermList(owner.getTermConstant("encorage-discussion") /*106*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("encorage-discussion") /*106*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("encorajar-discusion") /*107*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("Attitude") /*63*/, new TermList(owner.getTermConstant("positive-interdependence") /*88*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("positive-interdependence") /*88*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("interdependencia-positiva") /*108*/, TermList.NIL)))));
		s.add(new Predicate(32, 0, new TermList(owner.getTermConstant("Attitude") /*63*/, new TermList(owner.getTermConstant("individual-accountability") /*89*/, TermList.NIL))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("individual-accountability") /*89*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("responsabilidade-individual") /*109*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("u123f098") /*110*/, new TermList(owner.getTermConstant("hasTitle") /*97*/, new TermList(owner.getTermConstant("unit-of-test") /*111*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("learner1") /*112*/, new TermList(owner.getTermConstant("hasExperience") /*91*/, new TermList(owner.getTermConstant("high") /*92*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("learner1") /*112*/, new TermList(owner.getTermConstant("hasExperience") /*91*/, new TermList(owner.getTermConstant("medium") /*113*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("learner2") /*114*/, new TermList(owner.getTermConstant("hasExperience") /*91*/, new TermList(owner.getTermConstant("high") /*92*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("learner3") /*115*/, new TermList(owner.getTermConstant("hasExperience") /*91*/, new TermList(owner.getTermConstant("high") /*92*/, TermList.NIL)))));
		s.add(new Predicate(20, 0, new TermList(owner.getTermConstant("learner4") /*116*/, new TermList(owner.getTermConstant("hasExperience") /*91*/, new TermList(owner.getTermConstant("high") /*92*/, TermList.NIL)))));
		s.add(new Predicate(15, 0, new TermList(TermList.NIL, TermList.NIL)));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		defineConstants(owner);

		State s0 = new State(owner.getAxioms());

		createState0(owner, s0); // jShop2Planner.initialize(d, s0);

		TaskList tl;
			tl = new TaskList(1, true);
			tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 0, new TermList(owner.getTermConstant("u123f098") /*110*/, new TermList(new TermList(new TermList(owner.getTermConstant("c103d678") /*99*/, new TermList(owner.getTermConstant("knowledge-construction") /*90*/, TermList.NIL)), new TermList(owner.getTermConstant("encorage-discussion") /*106*/, new TermList(owner.getTermConstant("positive-interdependence") /*88*/, new TermList(owner.getTermConstant("individual-accountability") /*89*/, TermList.NIL)))), new TermList(new TermList(owner.getTermConstant("learner1") /*112*/, new TermList(owner.getTermConstant("learner2") /*114*/, new TermList(owner.getTermConstant("learner3") /*115*/, new TermList(owner.getTermConstant("learner4") /*116*/, TermList.NIL)))), TermList.NIL)))), false, false));

		JSHOP2 jShop2Planner = new JSHOP2(tl, 100000, new DoubleCost(0.0), owner, s0);
		JSHOP2Provider.setJSHOP2(jShop2Planner);
		while (jShop2Planner.run() && jShop2Planner.getPlans().size() < 1) { 
		}
		returnedPlans.addAll(jShop2Planner.getPlans());
		return returnedPlans;
	}

	public static LinkedList<Predicate> getFirstPlanOps() {
		return getPlans().getFirst().getOps();
	}
}