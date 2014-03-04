

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;


public class Length implements Calculate {

    public Term call(List l) {
        double numberIn = ((TermList) l.getHead()).size();
        return new TermNumber(numberIn);
    }

}
