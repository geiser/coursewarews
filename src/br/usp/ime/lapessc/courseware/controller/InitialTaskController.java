package br.usp.ime.lapessc.courseware.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.usp.ime.lapessc.courseware.model.Goal;
import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.PublicTask;
import br.usp.ime.lapessc.courseware.model.UserInfo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class InitialTaskController {
	
	private final Result result;
	private final UserInfo userInfo;
	
	public InitialTaskController(Result result, UserInfo userInfo) {
		this.result = result;
		this.userInfo = userInfo;
	}
	
	@Get
	@Path(value = "/initialtask")
	@SuppressWarnings("unchecked")
	public void show(String id, String callback) {
		//-- get compIds
		String head = "?_format=xml&function=GetElements";
		try {
			head += "&types[0]=" + URLEncoder.encode("Competency", "UTF-8");
			head += "&types[1]=" + URLEncoder.encode("ForFundamental", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		URL url = null; //-- read from xml
		XStream xstream = new XStream(new DomDriver());
		Collection<String> compIds = null;
		try {
			url = new URL(this.userInfo.getMediatorURL() + head);
			compIds = (Collection<String>) xstream.fromXML(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-- get learnerIds
		head = "?_format=xml&function=GetElements";
		try {
			head += "&types[0]=" + URLEncoder.encode("Learner", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		url = null; //-- read from xml
		xstream = new XStream(new DomDriver());
		Collection<String> learnerIds = null;
		try {
			url = new URL(this.userInfo.getMediatorURL() + head);
			learnerIds = (Collection<String>) xstream.fromXML(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-- get skillIds
		head = "?_format=xml&function=GetElements";
		try {
			head += "&types[0]=" + URLEncoder.encode("IndependentSkill", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		url = null; //-- read from xml
		xstream = new XStream(new DomDriver());
		Collection<String> skillIds = null;
		try {
			url = new URL(this.userInfo.getMediatorURL() + head);
			skillIds = (Collection<String>) xstream.fromXML(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-- get attitudeIds
		head = "?_format=xml&function=GetElements";
		try {
			head += "&types[0]=" + URLEncoder.encode("Attitude", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		url = null; //-- read from xml
		xstream = new XStream(new DomDriver());
		Collection<String> attitudeIds = null;
		try {
			url = new URL(this.userInfo.getMediatorURL() + head);
			attitudeIds = (Collection<String>) xstream.fromXML(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}


		//-- recover competences
		//Map<String, Map<Map<String, String>, List<Map<String, String>>>> tasks = new HashMap<String, Map<Map<String,String>,List<Map<String,String>>>>();
		Collection<PublicTask> tasks = new ArrayList<PublicTask>();

		//--createLDFundamental
		PublicTask fundTask = new PublicTask();
		fundTask.setIdentifier("createLDFundamentalUoL");

		Set<Metadata> learners = new HashSet<Metadata>();
		for (String learnerId : learnerIds) {//-- get group
			head = "?_format=xml&function=GetPropertyValue";
			URL learnerURL = null;
			try {
				head += "&elements[0]=" + URLEncoder.encode(learnerId, "UTF-8");
				head += "&name=" + URLEncoder.encode("hasTitle", "UTF-8");
				learnerURL = new URL(this.userInfo.getMediatorURL() + head);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			XStream xstreamMetadata = new XStream(new DomDriver());
			Metadata learner = new Metadata(learnerId);
			try {
				for (String title : (Collection<String>) xstreamMetadata.fromXML(learnerURL.openStream())) {
					learner.addProperty(new Property().setName("hasTitle").setValue(title));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			learners.add(learner);
		}

		
		Map<Goal, Set<Metadata>> goals = new HashMap<Goal, Set<Metadata>>();
		for (String compId : compIds) { //-- get goals
			head = "?_format=xml&function=GetPropertyValue";
			URL metadataURL = null;
			try {
				head += "&elements[0]=" + URLEncoder.encode(compId, "UTF-8");
				head += "&name=" + URLEncoder.encode("hasTitle", "UTF-8");
				metadataURL = new URL(this.userInfo.getMediatorURL() + head);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			XStream xstreamMetadata = new XStream(new DomDriver());
			Metadata comp = new Metadata(compId);
			try {
				for (String title : (Collection<String>) xstreamMetadata.fromXML(metadataURL.openStream())) {
					comp.addProperty(new Property().setName("hasTitle").setValue(title));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int sl = 0; sl <= 4; sl++) {
				for (int kl = 0; kl <= 3; kl++) {
					if (sl==0 && kl==0) { continue; }
					goals.put(new Goal().setComp(comp).setLevel("s"+sl+"k"+kl), learners);
				}
			}
		} 
		fundTask.setGoals(goals); // set goals and groups
		
		for (String skillId : skillIds) {
			head = "?_format=xml&function=GetPropertyValue";
			URL metadataURL = null;
			try {
				head += "&elements[0]=" + URLEncoder.encode(skillId, "UTF-8");
				head += "&name=" + URLEncoder.encode("hasTitle", "UTF-8");
				metadataURL = new URL(this.userInfo.getMediatorURL() + head);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			XStream xstreamMetadata = new XStream(new DomDriver());
			Metadata skill = new Metadata(skillId);
			try {
				for (String title : (Collection<String>) xstreamMetadata.fromXML(metadataURL.openStream())) {
					skill.addProperty(new Property().setName("hasTitle").setValue(title));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			fundTask.addSkill(skill);
		}
		for (String attitudeId : attitudeIds) {
			head = "?_format=xml&function=GetPropertyValue";
			URL metadataURL = null;
			try {
				head += "&elements[0]=" + URLEncoder.encode(attitudeId, "UTF-8");
				head += "&name=" + URLEncoder.encode("hasTitle", "UTF-8");
				metadataURL = new URL(this.userInfo.getMediatorURL() + head);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			XStream xstreamMetadata = new XStream(new DomDriver());
			Metadata attitude = new Metadata(attitudeId);
			try {
				for (String title : (Collection<String>) xstreamMetadata.fromXML(metadataURL.openStream())) {
					attitude.addProperty(new Property().setName("hasTitle").setValue(title));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			fundTask.addAttitude(attitude);
		}
		tasks.add(fundTask);
		
		this.result.include("callback", callback);
		this.result.include("tasks", tasks);
	}
	
}