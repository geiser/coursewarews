

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class FilterByQuery implements Calculate {

    public Term call2(List args) {
        List elements = ((TermList) args.getHead()).getList();
        
        TermList result = TermList.NIL;
        while (elements != null) {
			Term head = elements.getHead();
			if (head instanceof TermConstant) {
				String str = ((TermConstant) head).getName();
	            if (str.startsWith("aux")  || str.startsWith("fund") || str.startsWith("comp") || str.startsWith("res")) {
	                //if (((int) (Math.random() * 100)) % 2 == 0) 
                	result = new TermList(head, result);
            	}
			}
            elements = elements.getRest();
        }
        
        return result;
    }

    public Term call(List args) {
        return TermList.NIL;
    }

}
