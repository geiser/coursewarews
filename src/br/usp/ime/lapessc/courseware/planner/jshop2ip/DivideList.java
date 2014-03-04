package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import com.gamalocus.jshop2rt.*;

public class DivideList implements Calculate {

    public Term call(List args) { 
        List list = ((TermList) args.getHead()).getList();
        int nro = (int) ((TermNumber) args.getRest().getHead()).getNumber();

        TermList tmpResult[] = new TermList[nro];
        for (int i = 0; i < nro; i++) {
            tmpResult[i] = TermList.NIL;
        }

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
            result = new TermList(tmpResult[i], result);
        }
        return result;
    }

}
