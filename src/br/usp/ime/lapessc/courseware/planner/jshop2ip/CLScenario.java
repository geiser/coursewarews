package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class CLScenario {
    
    public String id = null;
    public String name;
    public TermConstant comp;
    
    public Map<String, CLStrategy> strategies = new HashMap<String, CLStrategy>();
    
    @Override
    public int hashCode() {
        int toReturn = 1;
        if (this.id != null) { return this.id.hashCode(); }
        if (this.name != null) { toReturn *= this.name.hashCode(); }
        if (this.comp != null) { toReturn *= this.comp.hashCode(); }
        for (CLStrategy strategy : this.strategies.values()) {
            toReturn *= strategy.name.hashCode() * strategy.level.hashCode();
        }
        return toReturn;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof CLScenario) || (obj == null)) { return false; }
        CLScenario scenario = (CLScenario) obj;
        if (this.id != null) return this.id.equals(scenario.id);
        boolean toReturn = this.name.equals(scenario.name) && this.comp.equals(scenario.comp);
        Iterator<CLStrategy> it = this.strategies.values().iterator();
        while (toReturn && it.hasNext()) {
            toReturn = toReturn && scenario.strategies.values().contains(it.next());
        }
        return toReturn;
    }

    public void removeLearners(Set<TermConstant> learners) {
        for (CLStrategy strategy : this.strategies.values()) {
            TermList result = TermList.NIL;
            List list = strategy.learners.getList();
            while (list != null) {
                TermConstant learnerId = ((TermConstant) list.getHead());
                if (!learners.contains(learnerId)) {
                    result = new TermList(learnerId, result);
                }
                list = list.getRest();
            }
            strategy.learners = result;
            this.strategies.put(strategy.name, strategy);
        }
    }
    
    public boolean containLearner(TermConstant learnerId) {
        boolean toReturn = false;
        for (CLStrategy strategy: this.strategies.values()) {
            List list = strategy.learners.getList();
            while (!toReturn && (list != null)) {
                if (learnerId.equals(list.getHead())) {
                    toReturn = true;
                }
                list = list.getRest();
            }
            if (toReturn) { break; } 
        }
        return toReturn;
    }
    
}
