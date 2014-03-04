package br.usp.ime.lapessc.courseware.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.usp.ime.lapessc.courseware.util.LDResources;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.TermList;


public class Metadata implements Cloneable {

	private String id;

	private Set<String> types = new HashSet<String>();

	private Map<String, Set<Property>> properties = new HashMap<String, Set<Property>>();

	private Map<String, Set<Relation>> relations = new HashMap<String, Set<Relation>>();

	private Resource resource;

	public Metadata() {
	}

	public Metadata(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}

	public Metadata setId(String id) {
		this.id = id;
		return this;
	}

	public Set<String> getTypes() {
		return types;
	}

	public Metadata addType(String type) {
		this.types.add(type);
		return this;
	}

	public Metadata addTypes(Collection<String> types) {
		if (types != null) {
			for (String type : types) {
				this.addType(type);
			}
		}
		return this;
	}

	public Metadata removeType(String type) {
		this.types.remove(type);
		return this;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/* --------------------------------------------------------------------------- */

	public Metadata setProperties(Collection<Property> properties) {
		this.properties = new HashMap<String, Set<Property>>();
		if (properties != null) {
			for (Property property : properties) {
				this.addProperty(property); 
			}
		}
		return this;
	}

	public Set<Property> getProperties() {
		Set<Property> result = new HashSet<Property>();
		for (String name : this.properties.keySet()) {
			Set<Property> properties = this.properties.get(name);
			result.addAll(properties);
		}
		return result;
	}

	public Map<String, Set<Property>> getPropertyMap() {
		return this.properties;
	}

	public Set<Property> getProperties(String name) {
		return this.properties.get(name);
	}

	public Metadata addProperties(Collection<Property> properties) {
		if (properties != null) {
			for (Property property : properties) {
				this.addProperty(property);
			}
		}
		return this;
	}

	public Metadata addProperty(Property property) {
		property.setSource(this);
		Set<Property> properties = new HashSet<Property>();
		if (this.properties.containsKey(property.getName())) {
			properties = this.properties.get(property.getName());
		}
		properties.add(property);
		this.properties.put(property.getName(), properties);
		return this;
	}

	public Metadata removeProperty(Property property) {
		if (this.properties.containsKey(property.getName())) {
			Set<Property> properties = this.properties.get(property.getName());
			properties.remove(property);
			if (properties.isEmpty()) { this.properties.remove(property.getName()); }
			else { this.properties.put(property.getName(), properties); }
		}
		property.setSource(null);
		return this;
	}

	public Metadata removeProperties(String name) {
		this.properties.remove(name);
		return this;
	}


	/* --------------------------------------------------------------------------- */

	public Metadata setRelations(Collection<Relation> relations) {
		this.relations = new HashMap<String, Set<Relation>>();
		if (relations != null) {
			for (Relation relation : relations) {
				this.addRelation(relation); 
			}
		}
		return this;
	}

	public Metadata setRelations(String name, Collection<Relation> relations) {
		name = "relation-" + name;
		if (relations != null && !relations.isEmpty()) {
			this.relations.put(name, new HashSet<Relation>());
			for (Relation relation : relations) {
				if (name.equals(relation.getName())) {
					this.addRelation(relation); 
				}
			}
		}
		return this;
	}

	public Set<Relation> getRelations() {
		Set<Relation> result = new HashSet<Relation>();
		for (Set<Relation> properties : this.relations.values()) {
			result.addAll(properties);
		}
		return result;
	}

	public Map<String, Set<Relation>> getRelationMap() {
		return this.relations;
	}

	public Set<Relation> getRelations(String name) {
		Set<Relation> result = this.relations.get(name);
		if (result == null) {
			result = new HashSet<Relation>();
		}
		return result;
	}


	public Collection<Relation> getRelations(String name, Collection<Metadata> metadatas) {
		Set<Relation> result = this.relations.get(name);
		if (result == null) {
			result = new HashSet<Relation>();
		} else {
			Collection<String> metadataIds = new HashSet<String>();
			for (Metadata metadata : metadatas) {
				metadataIds.add(metadata.getId());
			}
			Iterator<Relation> it = result.iterator();
			while (it.hasNext()) {
				if (!metadataIds.contains(it.next().getDest())) {
					it.remove();
				}
			}
		}
		return result;
	}

	public Metadata addRelations(Collection<Relation> relations) {
		if (relations != null) {
			for (Relation relation : relations) {
				this.addRelation(relation);
			}
		}
		return this;
	}

	public Metadata addRelation(Relation relation) {
		relation.setSource(this);
		Set<Relation> relations = new HashSet<Relation>();
		if (this.relations.containsKey(relation.getName())) {
			relations = this.relations.get(relation.getName());
		}
		relations.add(relation);
		this.relations.put(relation.getName(), relations);
		return this;
	}

	public Metadata removeRelation(Relation relation) {
		if (this.relations.containsKey(relation.getName())) {
			Set<Relation> relations = this.relations.get(relation.getName());
			relations.remove(relation);
			if (relations.isEmpty()) { this.relations.remove(relation.getName()); }
			else { this.relations.put(relation.getName(), relations); }
		}
		relation.setSource(null);
		return this;
	}

	public Metadata removeRelation(String name) {
		this.relations.remove(name);
		return this;
	}

	/* --------------------------------------------------------------------------- */

	public String getType() {
		for (String type : this.types) {
			if (LDResources.kinds.keySet().contains(type)) {
				return type;
			}
		}
		return "";
	}

	public String getTitle() {
		if (this.getProperties("hasTitle") == null || this.getProperties("hasTitle").isEmpty()) {
			return "";
		}
		return this.getProperties("hasTitle").iterator().next().getValue();
	}

	public String getResourceType() {
		if (this.resource != null) {
			String url = LDResources.baseURL + "/resources/" + this.resource.getId();
			if (url.equals(this.resource.getHref())) {
				return "Resource";
			}
		}
		return "URL";
	}

	public String getUrl() {
		if (this.resource != null) {
			return this.resource.getHref();
		}
		return "";
	}

	public boolean getHasChildren() {
		if (this.getRelations("inverseIsPartOf")!=null && !this.getRelations("inverseIsPartOf").isEmpty()) {
			return true;
		}
		return false;
	}

	/* --------------------------------------------------------------------------- */

	public Metadata clone() {
		Metadata toReturn = new Metadata(this.id);
		for (String type : this.getTypes()) {
			toReturn.addType(type);
		}
		for (Property property : this.getProperties()) {
			toReturn.addProperty(property);
		}
		for (Relation relation : this.getRelations()) {
			toReturn.addRelation(relation);
		}
		if (this.resource != null) {
			toReturn.setResource(this.resource);
		}
		return toReturn;
	}

	/* --------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		int toReturn = 1;
		if (this.id != null) return this.id.hashCode();
		for (String type : this.types) {
			if (type != null) toReturn *= type.hashCode();
		}
		return toReturn;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) { return true; }
		if (!(obj instanceof Metadata) || (obj == null)) { return false; }
		Metadata Metadata = (Metadata) obj;
		if (this.id != null) return this.id.equals(Metadata.getId());
		return this.types.hashCode() == Metadata.getTypes().hashCode();
	}

	/**
	 * Function that return this one string that represent one meta-data 
	 * 
	 * (class ?types_{0} ?id)
	 * ...
	 * (class ?types_{n} ?id)
	 */
	@Override
	public String toString() {
		String toReturn = "";
		for (String type : this.types) {
			toReturn += "(class " + type + " " + this.getId() + ")\n";
		}
		if (this.resource != null) { toReturn += "(property " + this.id + " hasResource " + this.getResource().getUuid() + ")\n"; }
		//-- properties
		for (Set<Property> propertySet : this.properties.values()) {
			for (Property property : propertySet) {
				toReturn += property.toString() + "\n";
			}
		}
		//-- relations
		for (Set<Relation> relationSet : this.relations.values()) {
			for (Relation relation : relationSet) {
				toReturn += relation.toString() + "\n";
			}
		}
		//-- include resource
		if (this.resource != null) {
			toReturn += "\n" + this.getResource().toString() + "\n";
		}
		return toReturn;
	}

	public String toHttpRest(String reqdata) throws UnsupportedEncodingException {
		String result = reqdata;
		int count = 0;
		//-- get types
		for (String type : this.types) {
			result += "&types[" + count + "]=" + URLEncoder.encode(type, "UTF-8");
			count++;
		}
		//-- get properties
		count = 0;
		for (Property prop : this.getProperties()) {
			result += "&properties[" + count + "].name=" + URLEncoder.encode(prop.getName(), "UTF-8");
			result += "&properties[" + count + "].value=" + URLEncoder.encode(prop.getValue(), "UTF-8");
			count++;
		}
		//-- get relations
		count = 0;
		for (Relation rel : this.getRelations()) {
			result += "&relations[" + count + "].name=" + URLEncoder.encode(rel.getName(), "UTF-8");
			result += "&relations[" + count + "].dest=" + URLEncoder.encode(rel.getDest(), "UTF-8");
			count++;
		}
		return result;
	}

	public Collection<Predicate> toPredicates(Domain domain) {
		Collection<Predicate> result = new ArrayList<Predicate>();
		for (String type : this.types) {
			result.add(new Predicate(domain.addConstant("class"), 0, new TermList(domain.getTermConstant(domain.addConstant(type)), new TermList(domain.getTermConstant(domain.addConstant(this.id)), TermList.NIL))));
		}
		for (Property property : this.getProperties()) {
			result.add(property.toPredicate(domain));
		}
		for (Relation relation : this.getRelations()) {
			result.add(relation.toPredicate(domain));
		}
		if (this.resource != null) {
			result.add(new Predicate(domain.addConstant("property"), 0,
					new TermList(domain.getTermConstant(domain.addConstant(this.getId())),
							new TermList(domain.getTermConstant(domain.addConstant("hasResource")),
									new TermList(domain.getTermConstant(domain.addConstant(this.getResource().getId())), TermList.NIL)))));
			result.addAll(this.resource.toPredicates(domain));
		}
		return result;
	}

}