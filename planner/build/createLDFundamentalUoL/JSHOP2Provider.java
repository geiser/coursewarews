package createLDFundamentalUoL;




import java.util.HashMap;
import java.util.Map;

import com.gamalocus.jshop2rt.JSHOP2;
import com.gamalocus.jshop2rt.Term;

public class JSHOP2Provider {

	private static JSHOP2 jShop2;
	private static String basePath;
	private static Map<String, Term> ids = new HashMap<String, Term>();
	
	private JSHOP2Provider() { }

	public static void setJSHOP2(JSHOP2 jShop2Planner) {
		jShop2 = jShop2Planner;
	}

	public static JSHOP2 getJSHOP2() {
		if (jShop2 == null) {
			throw new Error("Error jShop2 doesnt initialize!!");
		}
		return jShop2;
	}

	public static String getBasePath() {
		if (basePath == null) {
			basePath = "http://localhost:8088/automated-learning-design";
		} 
		return basePath;
	}
	
	public static void setBasePath(String pBasePath) {
		basePath = pBasePath;
	}

	public static void putId(String name, Term value) {
		ids.put(name, value);
	}
	
	public static Term getId(String name) {
		return ids.get(name);
	}
	
}
