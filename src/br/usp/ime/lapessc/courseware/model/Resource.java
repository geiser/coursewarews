package br.usp.ime.lapessc.courseware.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import br.usp.ime.lapessc.courseware.util.LDResources;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.TermList;

public class Resource implements Serializable {

	private static final long serialVersionUID = 5011239008727436521L;

	private String id;

	private String uuid = "res-" + UUID.randomUUID();

	private String title = "title";

	private String type = "webcontent";

	private String href = LDResources.baseURL + "/resources";

	private String body;

	public Resource() {
	}

	public Resource(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Resource setId(String id) {
		this.id = id;
		return this;
	}

	public Resource setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Resource setBody(String body) {
		this.body = body;
		return this;
	}

	public String getBody() {
		return body;
	}

	@Override
	public int hashCode(){
		int toReturn = 1;
		if (this.id != null) return this.id.hashCode();
		if (this.title != null) toReturn *= this.title.hashCode();
		if (this.body != null) toReturn *= this.body.hashCode();
		if (this.type != null) toReturn *= this.type.hashCode();
		if (this.href != null) toReturn *= this.href.hashCode();
		return toReturn;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) { return true; }
		if (!(obj instanceof Resource) || (obj == null)) { return false; }
		Resource relation = (Resource) obj;
		if (this.id != null) return this.id.equals(relation.getId());
		return (this.title != null && this.title.equals(relation.getTitle())) &&
				(this.body != null && this.body.equals(relation.getBody())) &&
				(this.type != null && this.body.equals(relation.getType())) &&
				(this.href != null && this.href.equals(relation.getHref()));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHref() {
		return href;
	}

	public Resource setHref(String href) {
		this.href = href;
		return this;
	}

	@Override
	public String toString() {
		String toReturn = "(class Resource " + this.getId() + ")\n";
		toReturn += "(property " + this.getId() + " hasHref " + this.getHref() + ")\n";
		toReturn += "(property " + this.getId() + " hasType " + this.getType() + ")\n";
		toReturn += "(property " + this.getId() + " hasTitle " + this.getTitle() + ")\n";
		return toReturn;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Collection<? extends Predicate> toPredicates(Domain domain) {
		Collection<Predicate> result = new ArrayList<Predicate>();
		result.add(new Predicate(domain.addConstant("class"), 0,
				new TermList(domain.getTermConstant(domain.addConstant("Resource")),
						new TermList(domain.getTermConstant(domain.addConstant(this.id)), TermList.NIL))));
		result.add(new Predicate(domain.addConstant("property"), 0,
				new TermList(domain.getTermConstant(domain.addConstant(this.getId())),
						new TermList(domain.getTermConstant(domain.addConstant("hasHref")),
								new TermList(domain.getTermConstant(domain.addConstant(this.getHref())), TermList.NIL)))));
		result.add(new Predicate(domain.addConstant("property"), 0,
				new TermList(domain.getTermConstant(domain.addConstant(this.getId())),
						new TermList(domain.getTermConstant(domain.addConstant("hasType")),
								new TermList(domain.getTermConstant(domain.addConstant(this.getType())), TermList.NIL)))));
		result.add(new Predicate(domain.addConstant("property"), 0,
				new TermList(domain.getTermConstant(domain.addConstant(this.getId())),
						new TermList(domain.getTermConstant(domain.addConstant("hasTitle")),
								new TermList(domain.getTermConstant(domain.addConstant(this.getTitle())), TermList.NIL)))));
		return result;
	}

}