
import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class AssignAndGetValue implements Calculate {

    TermList toReturn = TermList.NIL;
    
    @Override
    public Term call(List l) {
        if (TermList.NIL.equals(l.getHead())) {
            Term result = TermList.NIL;
            List list = toReturn.getList();
            while (list != null) {
                result = new TermList(list.getHead(), result);
                list = list.getRest();
            }
            this.toReturn = TermList.NIL;
            return result;
        } else {
            this.toReturn = new TermList(l.getHead(), toReturn);
            return toReturn;
        }
    }

}
