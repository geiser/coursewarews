package br.usp.ime.lapessc.courseware.mediator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;

import br.usp.ime.lapessc.courseware.planner.jshop2ip.JSHOP2Provider;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Predicate;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GetRelated implements Calculate {

    @SuppressWarnings("unchecked")
    public Term call(List args) {
        TermConstant nameTerm = (TermConstant) args.getRest().getHead();

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
            if (((TermConstant) elementList.getHead()).getName().startsWith("ld-") || ((TermConstant) elementList.getHead()).getName().startsWith("play-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("act-") || ((TermConstant) elementList.getHead()).getName().startsWith("rp-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("as-") || ((TermConstant) elementList.getHead()).getName().startsWith("la-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("sa-") || ((TermConstant) elementList.getHead()).getName().startsWith("env-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("group-") || ((TermConstant) elementList.getHead()).getName().startsWith("lo-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("serv-") || ((TermConstant) elementList.getHead()).getName().startsWith("item-") ||
                    ((TermConstant) elementList.getHead()).getName().startsWith("build")) {
                elementList = elementList.getRest();
                continue;
            }
            
            /*if (((TermConstant) elementList.getHead()).getName().equals("ahlhdXRvbWF0ZWQtbGVhcm5pbmctZGVzaWduchALEglBdXhpbGlhcnkYoAIM")) {
                System.out.println("query relation do in jigsaw");
            }*/

            String head = "?_format=xml&function=GetRelated";
            try {
                head += "&elements[0]=" + URLEncoder.encode(((TermConstant) elementList.getHead()).getName(), "UTF-8");
                head += "&name=" + URLEncoder.encode(nameTerm.getName(), "UTF-8");
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
            for (String dest : response) {
                Term destTerm = domain.getTermConstant(domain.addConstant(dest));
                result = new TermList(destTerm, result);
                if (nameTerm.getName().startsWith("inverse")) {
                    String name = nameTerm.getName().substring(7,8).toLowerCase() + nameTerm.getName().substring(8);
                    nameTerm = domain.getTermConstant(domain.addConstant(name));
                    JSHOP2Provider.getJSHOP2().getState().add(new Predicate(domain.addConstant("relation"), 0,
                            new TermList(destTerm,
                                    new TermList(nameTerm,
                                            new TermList(elementList.getHead(), TermList.NIL)))));
                } else {
                    JSHOP2Provider.getJSHOP2().getState().add(new Predicate(domain.addConstant("relation"), 0,
                            new TermList(elementList.getHead(),
                                    new TermList(nameTerm,
                                            new TermList(destTerm, TermList.NIL)))));
                }
            }
            elementList = elementList.getRest();
        }
        return result;
    }

}