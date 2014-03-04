
import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class GetProduct implements Calculate {
   
  @Override
  public Term call(List args) {    
    TermList result = TermList.NIL;
    List listA = ((TermList) args.getHead()).getList();
    while (listA != null) {
        List listB = ((TermList) args.getRest().getHead()).getList();
        while (listB != null) {
	    TermList term = new TermList(listA.getHead(), new TermList(listB.getHead(), TermList.NIL));
	    result = new TermList(term, result);
	    listB = listB.getRest();
	}
	listA = listA.getRest();
    }
    return result;
  }

}

