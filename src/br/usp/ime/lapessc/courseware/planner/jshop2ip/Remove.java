package br.usp.ime.lapessc.courseware.planner.jshop2ip;


import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class Remove implements Calculate {
    
	public Term call(List l) {
        //System.out.println("remove : " + l.toString());
        List list1 = ((TermList) l.getHead()).getList();
        List list2 = ((TermList) l.getRest().getHead()).getList();
        Set<Term> set = new HashSet<Term>();
        while (list1 != null) {
            set.add(list1.getHead());
            list1 = list1.getRest();
        }
        while (list2 != null) {
            set.remove(list2.getHead());
            list2 = list2.getRest();
        }
        TermList result = TermList.NIL;
        for (Term term: set) {
            result = new TermList(term, result);
        }
        return result;
	}
    
}