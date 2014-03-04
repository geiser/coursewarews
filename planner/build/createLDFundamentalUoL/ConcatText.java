package createLDFundamentalUoL;


import com.gamalocus.jshop2rt.*;

public class ConcatText implements Calculate {

	public Term call(List args) {		
		String concatText = "";
		while (args != null) {
			concatText += args.getHead().toString() + " ";
			args = args.getRest();
		}
		Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
		return domain.getTermConstant(domain.addConstant(concatText.trim()));
	}

}

