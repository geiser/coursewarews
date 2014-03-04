package br.usp.ime.lapessc.courseware.util;

import java.util.ArrayList;
import java.util.List;

import br.usp.ime.lapessc.courseware.model.LDElement;
import br.usp.ime.lapessc.courseware.model.LDParameter;

public class LDElementConverter {

    private final LDElement element;

    public LDElementConverter() {
        this(new LDElement());
    }

    public LDElementConverter(LDElement element) {
        this.element = element;
    }
    
    public List<String> toSQL() {
        return this.toSQL("ldelements");
    }
    
    public List<String> toSQL(String table) {
        return this.toSQL(table, "triples");
    }

    public List<String> toSQL(String table, String metadataTable) {
        List<String> toReturn = new ArrayList<String>();

        //-- set children
        String children = "";
        if (this.element.getChildren() != null && !this.element.getChildren().isEmpty()) {
            for (LDElement child : this.element.getChildren()) {
                children += "," + child.getId();
                LDElementConverter converter = new LDElementConverter(child);
                toReturn.addAll(converter.toSQL(table, metadataTable));
            }
        }

        //-- set metadata
        if (this.element.getMetadata() != null) {
            MetadataConverter converter = new MetadataConverter(this.element.getMetadata());
            toReturn.addAll(converter.toSQL(metadataTable));
        }

        //-- set current ldelement
        String sql = "INSERT IGNORE INTO " + table + "(id,";
        String params = "('" + this.element.getId() + "',";
        if (this.element.getTag() != null) {
            sql += "tag,";
            params += "'" + this.element.getTag().toString() + "',";
        }
        if (this.element.getParameters() != null && !this.element.getParameters().isEmpty()) {
            sql += "parameters,";
            String parameters = "";
            for (LDParameter param : this.element.getParameters()) {
                parameters += "," + param.getName() + "=" + param.getValue();
            }
            params += "'" + parameters.substring(1) + "',";
        }
        if (this.element.getChildren() != null && !this.element.getChildren().isEmpty()) {
            sql += "children,";
            params += "'" + children.substring(1) + "',";
        }
        if (this.element.getIsPartOf() != null && this.element.getIsPartOf().getId() != null) {
            sql += "isPartOf,";
            params += "'" + this.element.getIsPartOf().getId() + "',";
        }
        if (this.element.getMetadata() != null) {
            sql += "metadata,";
            params += "'" + this.element.getMetadata().getId() + "',";
        }
        sql += "type)";
        params += "'" + this.element.getType().toString() + "')";
        sql += " VALUES " + params;
        toReturn.add(sql);

        return toReturn;
    }
    
    public static LDElement convert() {
		LDElement toReturn = new LDElement();
		
		return toReturn;
    }

}

