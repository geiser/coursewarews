package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class CLStrategy {
    
    public String name;
    
    public TermConstant level;
    
    public TermList learners = TermList.NIL;
    
    @Override
    public int hashCode() {
        int toReturn = 1;
        if (this.name != null) { toReturn *= this.name.hashCode(); }
        if (this.level != null) { toReturn *= this.level.hashCode(); }
        List learnersList = this.learners.getList();
        while (learnersList != null) {
            toReturn *= learnersList.getHead().hashCode();
            learnersList = learnersList.getRest();
        }
        return toReturn;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof CLStrategy) || (obj == null)) { return false; }
        CLStrategy strategy = (CLStrategy) obj;
        return this.name.equals(strategy.name) &&
               this.level.equals(strategy.level) &&
               this.learners.equals(strategy.learners);
    }
    
    
}
