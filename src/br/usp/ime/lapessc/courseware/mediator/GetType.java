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

public class GetType implements Calculate {

    @SuppressWarnings("unchecked")
    public Term call(List args) {

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
            if (elementTerm.getName().startsWith("ld-") || elementTerm.getName().startsWith("play-") ||
                    elementTerm.getName().startsWith("act-") || elementTerm.getName().startsWith("rp-") ||
                    elementTerm.getName().startsWith("as-") || elementTerm.getName().startsWith("la-") ||
                    elementTerm.getName().startsWith("sa-") || elementTerm.getName().startsWith("env-") ||
                    elementTerm.getName().startsWith("group-") || elementTerm.getName().startsWith("lo-") ||
                    elementTerm.getName().startsWith("serv-") || elementTerm.getName().startsWith("item-") ||
                    elementTerm.getName().startsWith("role-") || elementTerm.getName().startsWith("build")) {
                elementList = elementList.getRest();
                continue;
            } else if (LDResources.LEVELS.containsKey(elementTerm.getName()) ||
                    LDResources.SESSION_DESCRIPTIONS.containsKey(elementTerm.getName()) ||
                    LDResources.ILEVENT_DESCRIPTIONS.containsKey(elementTerm.getName())) {
                elementList = elementList.getRest();
                continue;
            }
            
            

            String head = "?_format=xml&function=GetType";
            try {
                head += "&elements[0]=" + URLEncoder.encode(elementTerm.getName(), "UTF-8");
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
            for (String type : response) {
                Term typeTerm = domain.getTermConstant(domain.addConstant(type));
                result = new TermList(typeTerm, result);
                JSHOP2Provider.getJSHOP2().getState().add(new Predicate(domain.addConstant("class"), 0,
                        new TermList(typeTerm,
                        new TermList(elementTerm, TermList.NIL))));
            }
            elementList = elementList.getRest();
        }
        return result;
    }

}