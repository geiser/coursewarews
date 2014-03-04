

import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class GetElements implements Calculate {

    public Term call(List args) {
        return TermList.NIL;
    }
    
    public Term call2(List args) {

        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        
        String id = null;
        //-- get parameters
        Set<String> types = new HashSet<String>();
        Set<Util.Parameter> relations = new HashSet<Util.Parameter>();
        Set<Util.Parameter> properties = new HashSet<Util.Parameter>();
        List list = ((TermList) args.getHead()).getList();
        while (list != null) {
            List arg = ((TermList) list.getHead()).getList();
            String name = ((TermConstant) arg.getHead()).getName().toLowerCase();
            if ("class".equals(name)) {
                String type = ((TermConstant) arg.getRest().getHead()).getName();
                if ("Auxiliary".equals(type)) {
					id = "aux";
				} else if ("Fundamental".equals(type)) {
					id = "fund";
				} else if ("Resource".equals(type)) {
                    id = "res";
				} else if ("Competency".equals(type)) {
					id = "fundcomp";
				} else if ("ForFundamental".equals(type)) {
					id = "fundcomp";
				} else if ("ForAuxiliary".equals(type)) {
					id = "auxcomp";
				}
                types.add(type);
            } else if ("property".equals(name)) {
                properties.add(Util.listToParameter(arg.getRest()));
            } else if ("relation".equals(name)) {
                relations.add(Util.listToParameter(arg.getRest()));
            }
            list = list.getRest();
        }

        //-- set destination
        TermList result = TermList.NIL;
        if (id != null) {
            for (int i = 0; i < 5; i++) {
                String elementId = UUID.uuid(10, id);
                result = new TermList(domain.getTermConstant(domain.addConstant(elementId)), result);
            }
        }
		
        return result;
    }

}

