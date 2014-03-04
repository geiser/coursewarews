package br.usp.ime.lapessc.courseware.model;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class Goal {

    private Metadata comp;

    private String level;
    
    public Goal() {
        
    }
    
    public Metadata getComp() {
        return this.comp;
    }

    public Goal setComp(Metadata comp) {
        this.comp = comp;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Goal setLevel(String level) {
        this.level = level;
        return this;
    }
    
    @Override
    public int hashCode() {
        int toReturn = 1;
        if (this.comp != null) toReturn *= this.comp.hashCode();
        if (this.level != null) toReturn *= this.level.hashCode();
        return toReturn;
    }
    
    @Override
    public String toString() {
        return "("+ this.comp.getId() + " " + this.level + ")";
    }

    public TermList toTermList(Domain domain) {
        TermConstant compTermConstant = domain.getTermConstant(domain.addConstant(this.comp.getId()));
        TermConstant levelTermConstant = domain.getTermConstant(domain.addConstant(this.level));
        return new TermList(compTermConstant, new TermList(levelTermConstant, TermList.NIL));
    }
    
}