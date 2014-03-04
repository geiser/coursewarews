package br.usp.ime.lapessc.courseware.mediator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;

import br.usp.ime.lapessc.courseware.planner.jshop2ip.JSHOP2Provider;
import br.usp.ime.lapessc.courseware.util.LDResources;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GetPropertyValue implements Calculate {

    @SuppressWarnings("unchecked")
    public Term call(List args) {
        TermConstant nameTerm = (TermConstant) args.getRest().getHead();
        if ("hasIndGoal".equals(nameTerm.getName()) || nameTerm.getName().startsWith("hasCLGrouping")) {
            return TermList.NIL;
        }
        TermConstant destTerm = null;
        if (args.getRest().getRest() != null) {
            destTerm = (TermConstant) args.getRest().getRest().getHead();
        }

        List elementList = null;
        if (args.getHead() instanceof TermConstant) {
            elementList = new TermList(args.getHead(), TermList.NIL).getList();
        } else if (args.getHead() instanceof TermList) {
            elementList = ((TermList) args.getHead()).getList();
        } else {
            return TermList.NIL;
        }

        //-- set results
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        TermList result = TermList.NIL;
        while (elementList != null) {
            TermConstant elementTerm = (TermConstant) elementList.getHead();
            if (elementTerm.getName().startsWith("ld-") || elementTerm.getName().startsWith("play-") || elementTerm.getName().startsWith("act-") ||
                    elementTerm.getName().startsWith("rp-") || elementTerm.getName().startsWith("as-") || elementTerm.getName().startsWith("la-") ||
                    elementTerm.getName().startsWith("sa-") || elementTerm.getName().startsWith("env-") || elementTerm.getName().startsWith("group-") ||
                    elementTerm.getName().startsWith("lo-") || elementTerm.getName().startsWith("serv-") || elementTerm.getName().startsWith("item-") ||
                    elementTerm.getName().startsWith("build")) {
                elementList = elementList.getRest();
                continue;
            }

            /*if (elementTerm.getName().equals("ahlhdXRvbWF0ZWQtbGVhcm5pbmctZGVzaWduchALEglBdXhpbGlhcnkYoAIM")) {
                System.out.println("query property do in jigsaw");
            }*/

            //-- find by property - using
            if ("hasGoalStage".equals(nameTerm.getName()) || "hasGoalStage".equals(nameTerm.getName()) || "hasGoalStage".equals(nameTerm.getName())) {
                TermConstant valueTerm = null;
                if ("hasGoalStage".equals(nameTerm.getName())) {
                    valueTerm = domain.getTermConstant(domain.addConstant(elementTerm.getName().substring(4)));;
                } else if ("hasSkillLevel".equals(nameTerm.getName())) {
                    String[] values = new String[] {"nothing", "rough", "explanatory", "associative", "autonomous"};
                    int idx = Integer.parseInt(elementTerm.getName().substring(1, 2));
                    valueTerm = domain.getTermConstant(domain.addConstant(values[idx]));
                } else if ("hasKnowledgeLevel".equals(nameTerm.getName())) {
                    String[] values = new String[] {"nothing", "accretion", "tuning", "restructuring"};
                    int idx = Integer.parseInt(elementTerm.getName().substring(3, 4));
                    valueTerm = domain.getTermConstant(domain.addConstant(values[idx]));
                }
                result = new TermList(valueTerm, result);
                JSHOP2Provider.getJSHOP2().getState().add(
                        new Predicate(domain.addConstant("property"), 0,
                                new TermList(elementTerm,
                                        new TermList(nameTerm,
                                                new TermList(valueTerm, TermList.NIL)))));
                elementList = elementList.getRest();
                continue;
            }

            //-- find by request
            String head = "?_format=xml&function=GetPropertyValue";
            try {
                head += "&elements[0]=" + URLEncoder.encode(elementTerm.getName(), "UTF-8");
                head += "&name=" + URLEncoder.encode(nameTerm.getName(), "UTF-8");
                if (destTerm != null) {
                    head += "&dest=" + URLEncoder.encode(destTerm.getName(), "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //-- read from xml
            URL url = null;
            try {
                url = new URL(JSHOP2Provider.getMediatorURL() + head);
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
                return TermList.NIL;
            }
            XStream xstream = new XStream(new DomDriver());
            Collection<String> response = new ArrayList<String>();
            try {
                response = (Collection<String>) xstream.fromXML(url.openStream());
            } catch (IOException e) {
                e.printStackTrace();
                return TermList.NIL;
            } 
            if (response == null) { response = new ArrayList<String>(); }

            //-- set values in result and state
            for (String value : response) {
                Term valueTerm = domain.getTermConstant(domain.addConstant(value));
                result = new TermList(valueTerm, result);
                if (destTerm != null) {
                    valueTerm = new TermList(destTerm, new TermList(valueTerm, TermList.NIL));
                }
                JSHOP2Provider.getJSHOP2().getState().add(
                        new Predicate(domain.addConstant("property"), 0,
                                new TermList(elementTerm,
                                        new TermList(nameTerm,
                                                new TermList(valueTerm, TermList.NIL)))));
            }
            elementList = elementList.getRest();
        }
        return result;
    }

    public static Collection<String> getValues(String element, String name, String dest) {
        //-- find by request
        String head = "?_format=xml&function=GetPropertyValue";
        try {
            head += "&elements[0]=" + URLEncoder.encode(element, "UTF-8");
            head += "&name=" + URLEncoder.encode(name, "UTF-8");
            if (dest != null) {
                head += "&dest=" + URLEncoder.encode(dest, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //-- read from xml
        URL url = null;
        try {
            if (JSHOP2Provider.getMediatorURL() == null) {
                url  = new URL(LDResources.DEFAULT_MEDIATOR_URL + head);
            } else {
                url = new URL(JSHOP2Provider.getMediatorURL() + head);
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return null;
        }
        XStream xstream = new XStream(new DomDriver());
        Collection<String> response = new ArrayList<String>();
        try {
            response = (Collection<String>) xstream.fromXML(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } 
        if (response == null) { response = new ArrayList<String>(); }
        return response;
    }

}