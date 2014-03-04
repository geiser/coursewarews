

import java.util.HashMap;
import java.util.Map;

import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.JSHOP2;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class JSHOP2Provider {

	private static JSHOP2 jShop2;
	private static String basePath;
	private static Map<String, String> ids = new HashMap<String, String>();
	
	private JSHOP2Provider() { }

	public static void setJSHOP2(JSHOP2 jShop2Planner) {
		JSHOP2Provider.jShop2 = jShop2Planner;
	}

	public static JSHOP2 getJSHOP2() {
		if (JSHOP2Provider.jShop2 == null) {
			throw new Error("Error jShop2 doesnt initialize!!");
		}
		return JSHOP2Provider.jShop2;
	}

	public static String getBasePath() {
		if (JSHOP2Provider.basePath == null) {
			JSHOP2Provider.basePath = "http://localhost:8088/automated-learning-design";
		} 
		return JSHOP2Provider.basePath;
	}
	
	public static void setBasePath(String pBasePath) {
		JSHOP2Provider.basePath = pBasePath;
	}

	public static void putId(String name, String value) {
		JSHOP2Provider.ids.put(name, value);
	}
	
	public static String getId(String name) {
		return JSHOP2Provider.ids.get(name);
	}
	
}