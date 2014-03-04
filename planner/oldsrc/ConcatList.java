

import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class ConcatList implements Calculate {

    public Term call(List args) { 
        List listOfList = ((TermList) args.getHead()).getList();
        TermList result = TermList.NIL;
        Set<Term> exist = new HashSet<Term>(); 
        while (listOfList != null) {
            List list = ((TermList) listOfList.getHead()).getList();
            while (list != null) {
                if (!exist.contains(list.getHead())) {
                    result = new TermList(list.getHead(), result);
                    exist.add(list.getHead());
                }
                list = list.getRest();
            }
            listOfList = listOfList.getRest();
        }

        return result;
    }

}