package br.usp.ime.lapessc.courseware.mediator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;

import br.usp.ime.lapessc.courseware.planner.jshop2ip.JSHOP2Provider;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GetElements implements Calculate {

    @SuppressWarnings("unchecked")
    public Term call(List args) {
        
//        Metadata meta = new Metadata();
        List conditions = ((TermList) args.getHead()).getList();
//        Collection<Metadata> metadatas = new ArrayList<Metadata>();
//        while (conditions != null) {
//            List cond = ((TermList) conditions.getHead()).getList();
//            String pred = ((TermConstant) cond.getHead()).getName().toLowerCase();
//            
//            conditions = conditions.getRest();
//        }
//        metadatas.add(meta);
        
        int tcount = 0;
        int pcount = 0;
        int rcount = 0;
        //-- set parameters
        String head = "?_format=xml&function=GetElements";
        
        try {
            while (conditions != null) {
                List cond = ((TermList) conditions.getHead()).getList();
                String pred = ((TermConstant) cond.getHead()).getName().toLowerCase();
                if ("class".equals(pred)) {
                    String type = cond.getRest().getHead().toString();
                    if ("CurrentLDElement".equals(type) ||
                        "SessionDescription".equals(type) ||
                        "ILEventDescription".equals(type) ||
                        "Level".equals(type)) {
                        return TermList.NIL;
                    }
                    head += "&types[" + tcount + "]=" + URLEncoder.encode(type, "UTF-8");
                    tcount++;
                } else if ("property".equals(pred)) {
                    String value = "";
                    if (cond.getRest().getRest() != null && cond.getRest().getRest().getRest() != null) {
                        String dest =  cond.getRest().getRest().getHead().toString();
                        value = cond.getRest().getRest().getRest().getHead().toString();
                        value = dest + "|" + value;
                    } else {
                        value = cond.getRest().getRest().getHead().toString();
                    }
                    head += "&properties[" + pcount + "].name=" + URLEncoder.encode(cond.getRest().getHead().toString(), "UTF-8");
                    head += "&properties[" + pcount + "].value=" + URLEncoder.encode(value, "UTF-8");
                    pcount++;
                } else if ("relation".equals(pred)) {
                    String dest = cond.getRest().getRest().getHead().toString();
                    head += "&relations[" + rcount + "].name=" + URLEncoder.encode(cond.getRest().getHead().toString(), "UTF-8");
                    head += "&relations[" + rcount + "].dest=" + URLEncoder.encode(dest, "UTF-8");
                    rcount++;
                }
                conditions = conditions.getRest();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //-- read from xml
        URL url = null;
        XStream xstream = new XStream(new DomDriver());
        Collection<String> response = null;
        try {
            url = new URL(JSHOP2Provider.getMediatorURL() + head);
            response = (Collection<String>) xstream.fromXML(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-- set values
        Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
        TermList result = TermList.NIL;
        for (String resp : response) {
            result = new TermList(domain.getTermConstant(domain.addConstant(resp)), result);
            //            if (args.getHead() instanceof TermConstant) {
            //                if (args.getRest().getRest() != null) {
            //                    valueTerm = new TermList(args.getRest().getRest().getHead(), valueTerm);
            //                }
            //                JSHOP2Provider.getJSHOP2().getState().add(new Predicate(domain.addConstant("property"), 0,
            //                        new TermList(args.getHead(),
            //                        new TermList(args.getRest().getHead(), // name
            //                        new TermList(valueTerm, TermList.NIL)))));
            //            }
        }
        return result;
    }

}
