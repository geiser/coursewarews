package createLDFundamentalUoL;



import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;


public class GetType implements Calculate {

    public Term call(List args) {
        return TermList.NIL;
    }
    
    public Term call2(List args) {
        String e = ((TermConstant) args.getHead()).getName();
	
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        TermList result = TermList.NIL;
		//-- fund elements
		if (e.startsWith("aux")) {
	        result = new TermList(domain.getTermConstant(domain.addConstant("Auxiliary")), result);
		} else if (e.startsWith("fund")) {
	        result = new TermList(domain.getTermConstant(domain.addConstant("Fundamental")), result);
		} else if (e.startsWith("res")) {
	        result = new TermList(domain.getTermConstant(domain.addConstant("Resource")), result);
		}
		//-- aux comps
		if (e.startsWith("auxcomp")) {
	        result = new TermList(domain.getTermConstant(domain.addConstant("Competency")), result);
	        result = new TermList(domain.getTermConstant(domain.addConstant("ForAuxiliary")), result);
		} else if (e.startsWith("fundcomp")) {
	        result = new TermList(domain.getTermConstant(domain.addConstant("Competency")), result);
	        result = new TermList(domain.getTermConstant(domain.addConstant("ForFundamental")), result);
		}
		return result;
    }

}

