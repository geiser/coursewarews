
import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;

public class GetId implements Calculate {

	@Override
	public Term call(List l) {
		Domain domain = JSHOP2Provider.getJSHOP2().getDomain();

		String name = ((TermConstant) l.getHead()).getName();
		if (JSHOP2Provider.getId(name) == null) {
			return domain.getTermConstant(domain.addConstant(name));
		}
		return domain.getTermConstant(domain.addConstant(JSHOP2Provider.getId(name)));
	}

}
