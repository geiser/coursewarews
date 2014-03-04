package createLDFundamentalUoL;



import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;

public class GetIndGoal implements Calculate {
	
    public Term call(List args) {
        //System.out.println("args:" + args);
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
		String initStage = ((TermConstant) args.getHead()).getName();
		String goalStage = ((TermConstant) args.getRest().getHead()).getName();
        //-- get numerical values in individual goals
        int csl = Integer.parseInt(initStage.substring(1, 2));
        int ckl = Integer.parseInt(initStage.substring(3, 4));
        int gsl = Integer.parseInt(goalStage.substring(1, 2));
        int gkl = Integer.parseInt(goalStage.substring(3, 4));
        //-- upgrade goal stage
        if (csl > gsl) { gsl = csl; }
        if (ckl > gkl) { gkl = ckl; }
        goalStage = "s" + gsl + "k" + gkl;
		//-- 
        //System.out.println("result: " + initStage+goalStage);
		return domain.getTermConstant(domain.addConstant(initStage + goalStage));
    }
}

