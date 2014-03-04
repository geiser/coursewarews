package br.usp.ime.lapessc.courseware.model;

import java.io.Serializable;

public class LDParameter implements Serializable {
	
	private static final long serialVersionUID = -756257864889811913L;

	private String name;
	
	private String value;
	
	public LDParameter() { }
	
	public LDParameter(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	private LDElement operator;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setOperator(LDElement operator) {
		this.operator = operator;
	}

	public LDElement getOperator() {
		return operator;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) { return true; }
		if (!(obj instanceof LDParameter) || (obj == null)) { return false; }
		LDParameter ldParameter = (LDParameter) obj;
		return this.getName().equals(ldParameter.getName()) &&
		       this.getValue().equals(ldParameter.getValue());
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() * this.getValue().hashCode();
	}
	
}
