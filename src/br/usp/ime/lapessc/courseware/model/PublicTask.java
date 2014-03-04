package br.usp.ime.lapessc.courseware.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.TaskAtom;
import com.gamalocus.jshop2rt.TermList;

public class PublicTask {

	private String identifier;

	private Set<Metadata> skills = new HashSet<Metadata>();
	private Set<Metadata> attitudes = new HashSet<Metadata>();
	private Map<Goal, Set<Metadata>> goals = new HashMap<Goal, Set<Metadata>>();

	public String getIdentifier() {
		return identifier;
	}

	public PublicTask setIdentifier(String identifier) {
		this.identifier = identifier;
		return this;
	}

	public Set<Metadata> getSkills() {
		return this.skills;
	}

	public PublicTask setSkills(Set<Metadata> skills) {
		this.skills = skills;
		return this;
	}

	public PublicTask addSkill(Metadata skill) {
		this.skills.add(skill);
		return this;
	}

	public Set<Metadata> getAttitudes() {
		return this.attitudes;
	}

	public PublicTask setAttitudes(Set<Metadata> attitudes) {
		this.attitudes = attitudes;
		return this;
	}

	public PublicTask addAttitude(Metadata attitude) {
		this.attitudes.add(attitude);
		return this;
	}

	public Map<Goal, Set<Metadata>> getGoals() {
		return this.goals;
	}

	public PublicTask setGoals(Map<Goal, Set<Metadata>> goals) {
		this.goals = goals;
		return this;
	}

	public PublicTask addGoal(Goal goal, Set<Metadata> learners) {
		this.goals.put(goal, learners);
		return this;
	}

	public Set<Metadata> getLearners(Goal goal) {
		Set<Metadata> learners = new HashSet<Metadata>();
		if (this.goals.containsKey(goal)) {
			learners = this.goals.get(goal);
		}
		return learners;
	}

	public PublicTask setLearners(Goal goal, Set<Metadata> learners) {
		this.goals.put(goal, learners);
		return this;
	}

	public PublicTask addLearners(Goal goal, Set<Metadata> learners) {
		if (this.goals.containsKey(goal)) {
			for (Metadata learner : this.goals.get(goal)) {
				learners.add(learner);
			}
		}
		return this.setLearners(goal, learners);
	}

	public TaskAtom toTaskAtom(Domain domain) {
		//-- set attitudes
		TermList attitudesTermList = TermList.NIL;
		if (this.attitudes != null && !this.attitudes.isEmpty()) {
			for (Metadata attitude: this.attitudes) {
				String attitudeId = attitude.getId();
				attitudesTermList = new TermList(domain.getTermConstant(domain.addConstant(attitudeId)), attitudesTermList);
			}
		}

		//-- set skills
		TermList skillTermList = TermList.NIL;
		if (this.skills != null && !this.skills.isEmpty()) {
			for (Metadata skill : this.skills) {
				String skillId = skill.getId();
				skillTermList = new TermList(domain.getTermConstant(domain.addConstant(skillId)), skillTermList);
			}
		}

		//-- set goals and groups
		TermList goalsTermList = TermList.NIL;
		TermList groupsTermList = TermList.NIL;
		for (Goal goal : this.goals.keySet()) {
			TermList groupTermList = TermList.NIL;
			for (Metadata learner : this.goals.get(goal)) {
				groupTermList = new TermList(domain.getTermConstant(domain.addConstant(learner.getId())), groupTermList);
			}
			goalsTermList = new TermList(goal.toTermList(domain), goalsTermList);
			groupsTermList = new TermList(groupTermList, groupsTermList);
		}

		//-- set predicate
		int headIn = domain.getCompoundTaskIndex(this.identifier);
		Predicate pred = new Predicate(headIn, 0, TermList.NIL);
		if ((this.skills == null || this.skills.isEmpty()) && (this.attitudes == null || this.attitudes.isEmpty())) {
			pred = new Predicate(headIn, 0, new TermList(goalsTermList,
					new TermList(groupsTermList, TermList.NIL)));
		} else {
			pred = new Predicate(headIn, 0, new TermList(goalsTermList,
					new TermList(skillTermList,
							new TermList(attitudesTermList,
									new TermList(groupsTermList, TermList.NIL)))));
		}
		TaskAtom result = new TaskAtom(pred, false, false);
		return result;
	}

}
