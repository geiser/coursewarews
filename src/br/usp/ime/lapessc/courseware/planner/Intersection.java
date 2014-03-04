package br.usp.ime.lapessc.courseware.planner;

import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class Intersection implements Calculate {

    public Term call(List args) {
        //System.out.println("args : " + args.toString());
        int count = 0;
        Set<Term> result = new HashSet<Term>();
        // -- iterate over list of list
        List listOfList = ((TermList) args.getHead()).getList();
        while (listOfList != null) {
            Set<Term> set = new HashSet<Term>();
            List list = ((TermList) listOfList.getHead()).getList();
            while (list != null) {
                set.add(list.getHead());
                list = list.getRest();
            }
            if (count == 0) { result = set; } else { result.retainAll(set); }
            listOfList = listOfList.getRest();
            count++;
        }
        //-- iterate over result
        TermList toReturn = TermList.NIL;
        for (Term term : result) {
            toReturn = new TermList(term, toReturn);
        }
        //System.out.println("result : " + toReturn.toString());
        return toReturn;
    }

}