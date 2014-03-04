
import java.util.UUID;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;

public class GetUUID implements Calculate {

	@Override
	public Term call(List args) {
		TermConstant term = (TermConstant) args.getHead();
		UUID id = UUID.randomUUID();
		Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
		return domain.getTermConstant(domain.addConstant(term.getName() + "-" + id));
	}

}

