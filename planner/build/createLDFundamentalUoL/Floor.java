package createLDFundamentalUoL;



import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermNumber;


public class Floor implements Calculate {

    public Term call(List args) {
        TermNumber term = (TermNumber) args.getHead();
        return new TermNumber(Math.floor(term.getNumber()));
    }

}

