


import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class GetPropertyValue implements Calculate {

    public Term call(List args) {

        TermList result = TermList.NIL;
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        
        if (args.getHead() instanceof TermConstant) {
            String e = ((TermConstant) args.getHead()).getName();
            String property = ((TermConstant) args.getRest().getHead()).getName();
            //-- find by property
            if ("hasGoalStage".equals(property)) {
                result = new TermList(domain.getTermConstant(domain.addConstant(e.substring(4))), result);
            } else if ("hasSkillLevel".equals(property)) {
                String[] values = new String[] {"nothing", "rough", "explanatory", "associative", "autonomous"};
                int idx = Integer.parseInt(e.substring(1, 2));
                result = new TermList(domain.getTermConstant(domain.addConstant(values[idx])), result);
                
            } else if ("hasKnowledgeLevel".equals(property)) {
                String[] values = new String[] {"nothing", "accretion", "tuning", "restructuring"};
                int idx = Integer.parseInt(e.substring(3, 4));
                result = new TermList(domain.getTermConstant(domain.addConstant(values[idx])), result);
            }
        }
        return result;
    }

    public Term call2(List args) {
        //System.out.println("args: " + args);

        if (args.getHead() instanceof TermList) {
            return TermList.NIL;
        }

        String e = ((TermConstant) args.getHead()).getName();
        String property = ((TermConstant) args.getRest().getHead()).getName();

        String[] values = new String[]{};
        if ("hasTitle".equals(property)) {
            values = new String[]{"title 1", "title 2", "title 3"};
        } else if ("hasContext".equals(property) || "hasEducationalLevel".equals(property)) {
            values = new String[]{"training", "higher-education", "school", "other"};
        } else if ("hasDifficult".equals(property)){
            //values = new String[]{"very-easy", "easy", "medium", "difficult", "very-difficult"};
            values = new String[]{"difficult", "very-difficult"};
        } else if ("hasPersonality".equals(property)) {
            values = new String[]{"introversion", "extraversion", "ambiversion"};
        } else if ("hasCLExperience".equals(property) || "hasAnxiety".equals(property) || "hasMotivation".equals(property)) {
            values = new String[] {"very-low", "low", "medium", "high", "very-high"};
        } else if ("hasLearningResourceType".equals(property)) {
            if (e.startsWith("aux")) {
                values = new String[]{
                        "explanation", "introduction", "remark",
                        "conclusion", "interactivity", "exercise",
                        "exploration", "invitation", "real-world-problem",
                        "evidence", "proof", "demonstration",
                        "illustration", "counter-example", "example"};
            }
        } else if ("hasLearningObjective".equals(property) || "hasCompetencyLevel".equals(property)) {
            values = new String[]{
                    "s1k1", "s1k1", "s1k2", "s1k3",
                    "s2k1", "s2k1", "s2k2", "s2k3",
                    "s3k1", "s3k1", "s3k2", "s3k3",
                    "s4k1", "s4k1", "s4k2", "s4k3"};
        } else if ("hasSkill".equals(property)) {
            values = new String[] {"skill1", "skill2", "skill3"};
        } else if ("hasKnowledge".equals(property)) {
            if (e.startsWith("auxcomp")) {
                values = new String[] {UUID.uuid(10, "aux1"), UUID.uuid(10, "aux2"), UUID.uuid(10, "aux3")};
            } else if (e.startsWith("fundcomp")) {
                values = new String[] {UUID.uuid(10, "fund1"), UUID.uuid(10, "fund2")};
            }
        }  else if ("hasSkillLevel".equals(property)) {
            values = new String[] {"nothing", "rough", "explanatory", "associative", "autonomous"};
            int idx = Integer.parseInt(e.substring(1, 2));
            values = new String[] { values[idx] };
        } else if ("hasKnowledgeLevel".equals(property)) {
            values = new String[] {"nothing", "accretion", "tuning", "restructuring"};
            int idx = Integer.parseInt(e.substring(3, 4));
            values = new String[] { values[idx] };
        }

        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        //-- set result
        TermList result = TermList.NIL;
        if (values.length != 0) {
            String value = values[(int) (Math.random() * values.length)];
            result = new TermList(domain.getTermConstant(domain.addConstant(value)), result);
        }
        //System.out.println("result: " + result);
        return result;
    }

}
