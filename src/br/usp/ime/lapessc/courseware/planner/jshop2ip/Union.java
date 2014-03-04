package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;

public class Union implements Calculate {

    public Term call(List args) {
	TermList result = TermList.NIL;
	Set<Term> set = new HashSet<Term>();
	List listOfList = ((TermList) args.getHead()).getList();
	while (listOfList != null) {
	    List list = ((TermList) listOfList.getHead()).getList();
	    while (list != null) {
	        Term head = list.getHead();
		if (!set.contains(head)) {
		    result = new TermList(head, result);
		    set.add(head);
		}
                list = list.getRest();
	    }
	    listOfList = listOfList.getRest();
	}
	return result;
    }
}

