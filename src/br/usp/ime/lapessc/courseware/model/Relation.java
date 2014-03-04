package br.usp.ime.lapessc.courseware.model;

import java.io.Serializable;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.TermList;

public class Relation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Metadata source;
	
	private String name;
	
	private String dest = null;
	
	public Relation() {
	}
	
	public Relation(Metadata source, String name, String dest) {
		this.source = source;
		this.name = name;
		this.dest = dest;
	}
	
	/*---------------------------------------------------------------------------*/
	
	public Relation setSource(Metadata source) {
		this.source = source;
		return this;
	}
	
	public Metadata getSource() {
		return this.source;
	}
	
	public Relation setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Relation setDest(String dest) {
		this.dest = dest;
		return this;
	}
	
	public String getDest() {
		return this.dest;
	}
	
	/*---------------------------------------------------------------------------*/
	
	@Override
	public int hashCode() {
		int toReturn = 1;
		if (this.source != null) toReturn *= this.source.hashCode();
		if (this.name != null) toReturn *= this.name.hashCode();
		if (this.dest != null) toReturn *= this.dest.hashCode();
		return toReturn;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Relation) || (obj == null)) { return false; }
        Relation property = (Relation) obj;
        return (this.source != null && this.source.equals(property.getSource())) &&
        	   (this.name != null && this.name.equals(property.getName())) &&
        	   (this.dest != null && this.dest.equals(property.getDest()));
    }
	
	/**
	 * (relation ?source.id ?name ?value) or
	 * (relation ?source.id ?name ?destination.id) or
	 * (relation ?source.id ?name (?destination.id ?value))
	 */
	@Override
	public String toString() {
		return "(relation " +
				(this.source != null ? this.source.getId() : "nil") + " " +
				this.name.toString() + " " +
				(this.dest != null ? this.dest.toString() : "nil") + ")";
	}
	
    public Predicate toPredicate(Domain domain) {
        return new Predicate(domain.addConstant("relation"), 0,
                new TermList(domain.getTermConstant(domain.addConstant(this.getSource().getId())),
                new TermList(domain.getTermConstant(domain.addConstant(this.name)),
                new TermList(domain.getTermConstant(domain.addConstant(this.dest)), TermList.NIL))));
    }
    
}
