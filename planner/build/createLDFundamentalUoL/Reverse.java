package createLDFundamentalUoL;



import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class Reverse implements Calculate {

  public Term call(List args) {

    TermList result = TermList.NIL;

    List list = ((TermList) args.getHead()).getList();
    while (list != null) {
      result = new TermList(list.getHead(), result);
      list = list.getRest();
    }
    
    return result;
  }

}

