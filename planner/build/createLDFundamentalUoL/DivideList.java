package createLDFundamentalUoL;


import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermNumber;
import com.gamalocus.jshop2rt.TermList;


public class DivideList implements Calculate {
    public Term call(List args) { 
        //System.out.println("args : " + args);
        List list = ((TermList) args.getHead()).getList();
        int nro = (int) ((TermNumber) args.getRest().getHead()).getNumber();

        TermList tmpResult[] = new TermList[nro];
        for (int i = 0; i < nro; i++) { tmpResult[i] = TermList.NIL; }
        
        while (list != null) {
            int i = 0;
            while ((i < nro) && (list != null)) {
                tmpResult[i] = new TermList(list.getHead(), tmpResult[i]);
                list = list.getRest();
                i++;
            }
        }

        TermList result = TermList.NIL;
        for (int i = 0; i < nro; i++) {
            if (!TermList.NIL.equals(tmpResult[i])) {
                result = new TermList(tmpResult[i], result);
            }
        }
        //System.out.println("result : " + result);
        return result;
    }

}

