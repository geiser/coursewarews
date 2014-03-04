package createLDFundamentalUoL;


import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class GetRelated implements Calculate {
    
    public Term call(List args) {
        return TermList.NIL;
    }
    
    public Term call2(List args) {
        String e = ((TermConstant) args.getHead()).getName();
        String relation = ((TermConstant) args.getRest().getHead()).getName();

        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();

        TermList result = TermList.NIL;
        if ("inverseIsPartOf".equals(relation)) {
            //System.out.println("args: " + args);
            if (e.startsWith("aux")) {
                for (int i = 0; i < 2; i++) {
                    String elementId = UUID.uuid(10, "aux");
                    result = new TermList(domain.getTermConstant(domain.addConstant(elementId)), result);
                }
            }
            //System.out.println("result: " + result);
        }
        return result;
    }
    
}
