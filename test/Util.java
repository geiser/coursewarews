
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class Util {

    public class Parameter {
        private String predicate;
        private Set<String> objects = new HashSet<String>();

        public Parameter setPredicate(String predicate) {
            this.predicate = predicate;
            return this;
        }

        public String getPredicate() {
            return this.predicate;
        }

        public Parameter setObjects(Set<String> objects) {
            this.objects = objects;
            return this;
        }

        public Parameter setObjects(String[] objects) {
            this.objects = new HashSet<String>(Arrays.asList(objects));
            return this;
        }

        public Parameter addObject(String object) {
            this.objects.add(object);
            return this;
        }

        public Set<String> getObjects() {
            return this.objects;
        }

        public String toSQL() {
            String result = "WHERE predicate = '" + this.predicate + "' AND object IN (";
            int count = 0;
            for (String object : this.objects) {
                result += (count != 0 ? ", " : "") + "'" + object + "'";
                count++;
            }
            result += ")";
            return result;
        }

    }

    public static String termToString(Term term) {
        String result = "";
        if (term instanceof TermConstant) {
            result = ((TermConstant) term).getName();
        } else if (term instanceof TermNumber) {
            result = new Double(((TermNumber) term).getNumber()).intValue() + "";
        } else if (term instanceof TermList) {
            List list = ((TermList) term).getList();
            String s = "";
            while (list != null) {
                s += " " + termToString(list.getHead());
                list = list.getRest();
            }
            if (s != null && !s.isEmpty()) {
                result += "(" + s.substring(1) + ")";
            }
        }
        return result;
    }

    public static Parameter listToParameter(List list) {
        Parameter result = new Util().new Parameter();
        result.setPredicate(termToString(list.getHead()));
        //-- List list = [?relation|?property] ?destOrValues
        if (list.getRest() != null && list.getRest().getRest() == null) {
            Term destOrValueTerm = list.getRest().getHead();
            if (destOrValueTerm instanceof TermConstant || destOrValueTerm instanceof TermNumber) {
                result.addObject(termToString(destOrValueTerm));
            } else if (destOrValueTerm instanceof TermList) {
                List destOrValueList = ((TermList) destOrValueTerm).getList();
                while (destOrValueList != null) { 
                    result.addObject(termToString(destOrValueList.getHead()));
                    destOrValueList = destOrValueList.getRest();
                }
            }
        } else if (list.getRest() != null && list.getRest().getRest() != null) { //-- List list = [?relation|?property] ?dest ?values
            String destination = ((TermConstant) list.getRest().getHead()).getName();
            Term valueTerm = list.getRest().getRest().getHead();
            if (valueTerm instanceof TermConstant || valueTerm instanceof TermNumber) {
                result.addObject(destination + termToString(valueTerm));
            } else if (valueTerm instanceof TermList) {
                List valueList = ((TermList) valueTerm).getList();
                while (valueList != null) { 
                    result.addObject(destination + termToString(valueList.getHead()));
                    valueList = valueList.getRest();
                }
            }
        }
        return result;
    }

}
