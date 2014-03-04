package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class GetDefaultValue implements Calculate {

    private boolean timeout = false;
    private final long initTime = System.currentTimeMillis() / 1000L;

    public Term call(List args) {
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        String property = ((TermConstant) args.getHead()).getName();

        if ("hasLearningResourceType".equals(property)) {
            String[] values = {};
            values = new String[]{
                    "explanation", "introduction", "remark",
                    "conclusion", "interactivity", "exercise",
                    "exploration", "invitation", "real-world-problem",
                    "evidence", "proof", "demonstration",
                    "illustration", "counter-example", "example"};

            //-- set result
            TermList result = TermList.NIL;
            if (values.length != 0) {
                String value = values[(int) Math.random() * values.length];
                result = new TermList(domain.getTermConstant(domain.addConstant(value)), result);
            }
            return result;
        } else if ("hasMacroDepth".equals(property)) { //-- 0; -1 false
            Term result = new TermNumber(2.0);
            long diffTime = (System.currentTimeMillis() / 1000L) - this.initTime;
            if (diffTime > 300L) {
                if (!timeout) {
                    System.out.println("...timeout...");
                    this.timeout = true;
                }
                result = new TermNumber(2.0);
            }
            return result;
        } else if ("hasMicroDepth".equals(property)) { //-- 0; -1 false
            Term result = new TermNumber(3.0);
            long diffTime = (System.currentTimeMillis() / 1000L) - this.initTime;
            if (diffTime > 300L) {
                result = new TermNumber(1.0);
            }
            return result;
        }

        return null;
    }

}
