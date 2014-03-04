

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.Relation;
import br.usp.ime.lapessc.courseware.model.Resource;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class BuildElement implements Calculate {
    
    public static Metadata buildMetadata(List query, String id) {
        Metadata metadata = new Metadata(id);
        while (query != null) {
            List condition = ((TermList) query.getHead()).getList();
            String predicate = ((TermConstant) condition.getHead()).getName().toLowerCase();
            if ("class".equals(predicate)) {
                String type = ((TermConstant) condition.getRest().getHead()).getName();
                metadata.addType(type);
            } else if ("property".equals(predicate)) {
                String name = ((TermConstant) condition.getRest().getHead()).getName(); 
                Property property = new Property().setName(name);
                Metadata dest = null;
                String value = "";
                if (condition.getRest().getRest() != null && condition.getRest().getRest().getRest() != null) {
                    String destId = ((TermConstant) condition.getRest().getRest().getHead()).getName();
                    dest = new Metadata(destId);
					Term valueTerm = condition.getRest().getRest().getRest().getHead();
					if (valueTerm instanceof TermList) {
						value = ((TermConstant) ((TermList) valueTerm).getList().getHead()).getName();
					} else {
                    	value = ((TermConstant) valueTerm).getName();
					}
                } else if (condition.getRest().getRest() != null) { //--(TODO) corregir esta parte
                    if (condition.getRest().getRest().getHead() instanceof TermConstant) {
                        value = ((TermConstant) condition.getRest().getRest().getHead()).getName();
                    } else if (condition.getRest().getRest().getHead() instanceof TermList) {
                        TermList destValue = (TermList) condition.getRest().getRest().getHead();
                        if (destValue.size() == 2) {
                            dest = new Metadata(((TermConstant) destValue.getList().getHead()).getName());
                            value = ((TermConstant) destValue.getList().getRest().getHead()).getName();
                        }
                    }
                }
                //--
                if (dest!=null && value!=null && !value.isEmpty()) {
                    value = "(" + dest.getId() + " " + value + ")";
                } else if (dest!=null && value.isEmpty()) {
                    value = dest.getId();
                }
                
                metadata.addProperty(property.setValue(value));
            } else if ("relation".equals(predicate)) {
                String name = ((TermConstant) condition.getRest().getHead()).getName();
                Term destTerm = condition.getRest().getRest().getHead();
                if (destTerm instanceof TermList) {
                    List destList = ((TermList) destTerm).getList();
                    while (destList != null) {
                        metadata.addRelation(new Relation().setName(name).setDest(((TermConstant) destList.getHead()).getName()));
                        destList = destList.getRest();
                    }
                } else {
                    metadata.addRelation(new Relation().setName(name).setDest(((TermConstant) destTerm).getName()));
                }
                /*if ("isPartOf".equals(name)) {
                    String destId = ((TermConstant) condition.getRest().getRest().getHead()).getName();
                    metadata.addRelation(new Relation().setName("isPartOf").setDest(new Metadata(destId)));
                } else { //-- set relation
                }*/
            }
            query = query.getRest();
        }
        return metadata;
    }

    public Term call(List args) {
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        
		List query = ((TermList) args.getHead()).getList();
        if (args.getRest() != null && args.getRest().getRest() != null) {
            int nro = ((TermNumber) args.getRest().getRest().getHead()).intValue();
            TermList result = TermList.NIL;
            for (int i = 0; i < nro; i++) {
                String id = UUID.uuid(15, "build");
                if (args.getRest().getHead() instanceof TermConstant) {
                    id = UUID.uuid(15, ((TermConstant) args.getRest().getHead()).getName());
                }
                Metadata metadata = buildMetadata(query, id);
                /*
                for (Predicate predicate : metadata.toPredicates(domain)) {
                    JSHOP2Provider.getJSHOP2().getState().add(predicate);
                }*/
                result = new TermList(domain.getTermConstant(domain.addConstant(metadata.getId())), result);
            }
            return result;
        }
		
        String id = UUID.uuid(15, "build");
		if (args.getRest() != null) {
		    id = ((TermConstant) args.getRest().getHead()).getName();
		}
		Metadata metadata = buildMetadata(query, id);
		Resource resource =  new Resource();
		resource.setId(resource.getUuid());
        metadata.setResource(resource);
		
        for (Predicate predicate : metadata.toPredicates(domain)) {
            JSHOP2Provider.getJSHOP2().getState().add(predicate);
        }
        return domain.getTermConstant(domain.addConstant(metadata.getId()));
    }

}
