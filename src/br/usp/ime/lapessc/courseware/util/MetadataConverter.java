package br.usp.ime.lapessc.courseware.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.Relation;

public class MetadataConverter {

    private final Metadata metadata;

    public MetadataConverter() {
        this(new Metadata());
    }
    
    public MetadataConverter(Metadata metadata) {
        this.metadata = metadata;
    }
    
    public List<String> toSQL() {
        return this.toSQL("triples");
    }

    public List<String> toSQL(String table) {
        List<String> toReturn = new ArrayList<String>();
        for (String type : this.metadata.getTypes()) {
            toReturn.add("INSERT IGNORE INTO " + table +
                    "(subject, predicate, object) VALUES ('" +
                    this.metadata.getId() + "', 'type', '" + type + "')");
        }
        for (Property prop : this.metadata.getProperties()) {
            toReturn.add("INSERT IGNORE INTO " + table +
                    "(subject, predicate, object) VALUES ('" +
                    this.metadata.getId() + "', '" +
                    prop.getName() + "', '" +
                    prop.getValue() + "')");
        }
        for (Relation rel : this.metadata.getRelations()) {
            toReturn.add("INSERT IGNORE INTO " + table +
                    "(subject, predicate, object) VALUES ('" +
                    this.metadata.getId() + "', 'relation-" + rel.getName() + "', '" +
                    rel.getDest() + "')");
            String invName = rel.getName().startsWith("inverseOf") ?
                    rel.getName().substring(9, 10).toLowerCase() + rel.getName().substring(10) :
                    "inverseOf" + rel.getName().substring(0, 1).toUpperCase() + rel.getName().substring(1);
            toReturn.add("INSERT IGNORE INTO " + table +
                    "(subject, predicate, object) VALUES ('" +
                    this.metadata.getId() + "', 'relation-" + invName + "', '" +
                    rel.getDest() + "')");
        }
        if (this.metadata.getResource() != null) {
            toReturn.add("INSERT IGNORE INTO " + table +
                    "(subject, predicate, object) VALUES ('" +
                    this.metadata.getId() + "', 'hasResource', '" +
                    this.metadata.getResource().getId() + "')");
            ResourceConverter converter = new ResourceConverter(this.metadata.getResource());
            toReturn.addAll(converter.toSQL(table));
        }
        return toReturn;
    }

	public static Metadata convert(List<Map<String, Object>> triples, Metadata metadata) {
		for (Map<String, Object> triple : triples) {
			String predicate = (String) triple.get("predicate");
			if ("type".equals(predicate)) {
				metadata.addType((String) triple.get("object"));
			} else if (predicate.startsWith("relation-")) {
				metadata.addRelation(new Relation().setName(predicate.substring(9)).setDest((String) triple.get("object")));
			} else {
				metadata.addProperty(new Property().setName(predicate).setValue((String) triple.get("object")));
			}
		}
		return metadata;
	}
	
}
