
import java.util.ArrayList;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;


public class UnionList implements Calculate {

  @Override
  public Term call(List args) { 
    List listOfList = ((TermList) args.getHead()).getList();
    TermList result = TermList.NIL;
    
    java.util.List<Integer> hashCodes = new ArrayList<Integer>();
    while (listOfList != null) {
        List list = ((TermList) listOfList.getHead()).getList();
        while (list != null) {
        	Term head = list.getHead();
        	if (!hashCodes.contains(new Integer(head.hashCode()))) {
        		hashCodes.add(new Integer(head.hashCode()));
        		result = new TermList(head, result);
        	}
        	list = list.getRest();
        }
      listOfList = listOfList.getRest();
    }
    return result;
  }

}

