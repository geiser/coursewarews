package br.usp.ime.lapessc.courseware.model;

import java.io.Serializable;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class Property implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Metadata source;
	
	private String name;
	
	private String value = null;
	
	public Property() {
	}
	
	public Property(Metadata source, String name, String value) {
		this.source = source;
		this.name = name;
		this.value = value;
	}
	
	/*---------------------------------------------------------------------------*/
	
	public Property setSource(Metadata source) {
		this.source = source;
		return this;
	}
	
	public Metadata getSource() {
		return this.source;
	}
	
	public Property setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Property setValue(String value) {
		this.value = value;
		return this;
	}
	
	public String getValue() {
		return this.value;
	}
	
	/*---------------------------------------------------------------------------*/
	
	@Override
	public int hashCode() {
		int toReturn = 1;
		if (this.source != null) toReturn *= this.source.hashCode();
		if (this.name != null) toReturn *= this.name.hashCode();
		if (this.value != null) toReturn *= this.value.hashCode();
		return toReturn;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Property) || (obj == null)) { return false; }
        Property property = (Property) obj;
        return (this.source != null && this.source.equals(property.getSource())) &&
        	   (this.name != null && this.name.equals(property.getName())) &&
        	   (this.value != null && this.value.equals(property.getValue()));
    }
	
	/**
	 * (property ?source.id ?name ?value) or
	 * (property ?source.id ?name ?destination.id) or
	 * (property ?source.id ?name (?destination.id ?value))
	 */
	@Override
	public String toString() {
		return "(property " +
				(this.source != null ? this.source.getId() : "nil") + " " +
				this.name.toString() + " " +
				(this.value != null ? this.value.toString() : "nil") + ")";
	}
	
    public Predicate toPredicate(Domain domain) {
        Term value = null;
        if (this.value.startsWith("(") && this.value.endsWith(")")) {
            value = TermList.NIL;
            for (String v : this.value.substring(1, this.value.length() - 1).split("[ ]+")) { // revert this value
                value = new TermList(domain.getTermConstant(domain.addConstant(v)), value);
            }
        } else {
            value = domain.getTermConstant(domain.addConstant(this.value));
        }
        return new Predicate(domain.addConstant("property"), 0,
                new TermList(domain.getTermConstant(domain.addConstant(this.getSource().getId())),
                new TermList(domain.getTermConstant(domain.addConstant(this.name)),
                new TermList(value, TermList.NIL))));
    }
    
}

