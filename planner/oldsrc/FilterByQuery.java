
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.gamalocus.jshop2rt.*;


public class FilterByQuery implements Calculate {

	@Override
	public Term call(List l) {
		return (TermList) l.getHead();
	}

}
