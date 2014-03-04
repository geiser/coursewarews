package createLDFundamentalUoL;



import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class ConcatList implements Calculate {

    public Term call(List args) {
        //System.out.println("args : " + args);
        //if (args == null) { return TermList.NIL; }
    	List listOfList = ((TermList) args.getHead()).getList();
        if (listOfList == null) { return TermList.NIL; }
        if (listOfList.size() == 1) {
            return (TermList) listOfList.getHead();
        }

		//-- insert elements
		Set<Term> exist = new HashSet<Term>();
		TermList invResult = TermList.NIL;
		while (listOfList != null) {
			List list = ((TermList) listOfList.getHead()).getList();
			while (list != null) {
				if (!exist.contains(list.getHead())) {
					exist.add(list.getHead());
					invResult = new TermList(list.getHead(), invResult);
				}
				list = list.getRest();
			}
			listOfList = listOfList.getRest();
		}
			
        //-- reverse of result
        TermList result = TermList.NIL;
        List list = invResult.getList();
        while (list != null) {
            result = new TermList(list.getHead(), result);
            list = list.getRest();
        }
        return result;
    }

}
