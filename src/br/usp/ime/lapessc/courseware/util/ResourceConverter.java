package br.usp.ime.lapessc.courseware.util;

import java.util.ArrayList;
import java.util.List;

import br.usp.ime.lapessc.courseware.model.Resource;

public class ResourceConverter {

    private final Resource resource;

    public ResourceConverter() {
        this(new Resource());
    }
    
    public ResourceConverter(Resource resource) {
        this.resource = resource;
    }
    
    public List<String> toSQL() {
        return this.toSQL("triples");
    }

    public List<String> toSQL(String table) {
        List<String> toReturn = new ArrayList<String>();
        toReturn.add("INSERT IGNORE INTO " + table +
                "(subject, predicate, object) VALUES ('" +
                this.resource.getId() + "', 'type', 'Resource')");
        toReturn.add("INSERT IGNORE INTO " + table +
                "(subject, predicate, object) VALUES ('" +
                this.resource.getId() + "', 'hasHref', '" +
                this.resource.getHref() + "')");
        toReturn.add("INSERT IGNORE INTO " + table +
                "(subject, predicate, object) VALUES ('" +
                this.resource.getId() + "', 'hasType', '" +
                this.resource.getType() + "')");
        toReturn.add("INSERT IGNORE INTO " + table +
                "(subject, predicate, object) VALUES ('" +
                this.resource.getId() + "', 'hasTitle', '" +
                this.resource.getTitle() + "')");
        return toReturn;
    }
    
}
