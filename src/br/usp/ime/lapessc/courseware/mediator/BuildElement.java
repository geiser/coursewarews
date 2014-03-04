package br.usp.ime.lapessc.courseware.mediator;

import java.util.ArrayList;
import java.util.Collection;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.Relation;
import br.usp.ime.lapessc.courseware.model.Resource;
import br.usp.ime.lapessc.courseware.planner.jshop2ip.JSHOP2Provider;
import br.usp.ime.lapessc.courseware.util.LDResources;
import br.usp.ime.lapessc.courseware.util.MetadataConverter;
import br.usp.ime.lapessc.courseware.util.MySQLDAO;
import br.usp.ime.lapessc.courseware.util.UUID;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class BuildElement implements Calculate {

    public Term call(List args) { 
        //-- set parameters
        Metadata metadata = new Metadata();
        Resource resource = new Resource();
        resource.setId(resource.getUuid());
        if (resource.getHref().equals(LDResources.baseURL + "/resources")) {
            resource.setHref(LDResources.baseURL + "/resources/" + resource.getId());
            if (args.getRest() != null) {
                String id = ((TermConstant) args.getRest().getHead()).getName();
                if (id.startsWith("ld-")) {
                    resource.setHref(LDResources.baseURL + "/uols/" + id + ".zip");
                }
            }
        }
        metadata.setResource(resource);
        List conditions = ((TermList) args.getHead()).getList();
        while (conditions != null) {
            List cond = ((TermList) conditions.getHead()).getList();
            String pred = ((TermConstant) cond.getHead()).getName().toLowerCase();
            if ("class".equals(pred)) {
                if (cond.getRest().getHead() instanceof TermList) {
                    List typeList = ((TermList) cond.getRest().getHead()).getList();
                    while (typeList != null) {
                        metadata.addType(typeList.getHead().toString());
                        typeList = typeList.getRest();
                    }
                } else if (cond.getRest().getHead() instanceof TermConstant) {
                    metadata.addType(cond.getRest().getHead().toString());
                }
            } else if ("property".equals(pred)) {
                if (cond.getRest().getRest() != null && cond.getRest().getRest().getRest() != null) {
                    TermConstant destTerm = (TermConstant) cond.getRest().getRest().getHead();
                    Term valueTerm = cond.getRest().getRest().getRest().getHead();
                    if (valueTerm instanceof TermList) {
                        List valueList = ((TermList) valueTerm).getList();
                        while (valueList != null) {
                            metadata.addProperty(new Property().setName(cond.getRest().getHead().toString()).setValue("(" + destTerm.toString() + " " + valueList.getHead().toString() + ")"));
                            valueList = valueList.getRest();
                        }
                    } else if (valueTerm instanceof TermConstant) {
                        metadata.addProperty(new Property().setName(cond.getRest().getHead().toString()).setValue("(" + destTerm.toString() + " " + valueTerm.toString() + ")"));
                    }
                } else {
                    Term valueTerm = cond.getRest().getRest().getHead();
                    if (valueTerm instanceof TermList) {
                        List valueList = ((TermList) valueTerm).getList();
                        while (valueList != null) {
                            metadata.addProperty(new Property().setName(cond.getRest().getHead().toString()).setValue(valueList.getHead().toString()));
                            valueList = valueList.getRest();
                        }
                    } else if (valueTerm instanceof TermConstant) {
                        metadata.addProperty(new Property().setName(cond.getRest().getHead().toString()).setValue(valueTerm.toString()));
                    }
                }
            } else if ("relation".equals(pred)) {
                Term valueTerm = cond.getRest().getRest().getHead();
                if (valueTerm instanceof TermList) {
                    List valueList = ((TermList) valueTerm).getList();
                    while (valueList != null) {
                        metadata.addRelation(new Relation().setName(cond.getRest().getHead().toString()).setDest(valueList.getHead().toString()));
                        valueList = valueList.getRest();
                    }
                } else if (valueTerm instanceof TermConstant) {                    
                    metadata.addRelation(new Relation().setName(cond.getRest().getHead().toString()).setDest(valueTerm.toString()));
                }
            }
            conditions = conditions.getRest();
        }

        //String head = "?_format=xml&function=BuildElement";

        String id = UUID.uuid(15, "build"); // set ?id and ?nro
        int nro = 1;
        if (args.getRest() != null) {
            id = ((TermConstant) args.getRest().getHead()).getName();
            if (args.getRest().getRest() != null) {
                nro = ((TermNumber) args.getRest().getRest().getHead()).intValue();
            }
        }

        //-- get SQL query and set values
        TermList result = TermList.NIL;
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        ArrayList<String> sqls = new ArrayList<String>();
        for (int i = 0; i < nro; i++) {
            metadata.setId(id);
            if (nro > 1) {
                metadata.setId(UUID.uuid(15, id));
            }
            sqls.addAll(new MetadataConverter(metadata).toSQL());
            //--
            result = new TermList(domain.getTermConstant(domain.addConstant(metadata.getId())), result);
            Collection<Predicate> predicates = metadata.toPredicates(domain);
            for (Predicate pred : predicates) {
                JSHOP2Provider.getJSHOP2().getState().add(pred);
            }
        }

        //-- execute SQL query
        if (!id.startsWith("ld-")) {
            MySQLDAO mysql = new MySQLDAO();
            if (!mysql.execute(sqls)) {
                return TermList.NIL;
            } else {
                mysql.close();
            }
        }
        
        //-- return result
        if (nro > 1) {
            return result;
        } else {
            return result.getList().getHead();
        }
    }

}