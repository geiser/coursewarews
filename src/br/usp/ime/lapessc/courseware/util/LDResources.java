package br.usp.ime.lapessc.courseware.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.Resource;


public class LDResources {
    
    public static String DEFAULT_MEDIATOR_URL = "http://127.0.0.1:8888/mediator"; 

    @SuppressWarnings("serial")
    public static final Map<String, String> texts = Collections.unmodifiableMap(new HashMap<String, String>() {{
        put("Fundamental.UoL", "Unit of learning for {f0} {f1} {f2} {f3} {f4} {f5}");
        put("Fundamental.Script", "Learning: {f0}");

        put("Discover.Phase", "Discover phase of {f0}");
        put("Discover.GroupActivity", "Activities for discover {f0}");
        put("Discover.Sessions", "Discover of {f0}");

        put("Introduction.Sessions", "Introduction of {f0}");

        put("Motivation.Session", "Motivation of {f0}");
        put("Motivation.Environment", "Motivation environment for {f0}");

        put("ShowProblem.Session", "Show problem of {f0}");

        put("Illustrate.WithExample.Session", "Illustrate {f0} with example");
        put("Illustrate.WithExample.Environment", "Illustrate environment for {f0} with example");

        put("Develop.Session", "Definition of {f0}");
        put("Develop.Environment", "Develop environment for {f0}");

        put("PracticeSession.WithExercise.UoL", "Practice {f0} with exercise");
        put("Practice.GroupActivity", "Practice {f0}");
        put("Practice.WithExercise.Session", "Practice {f0} with exercise");
        put("Practice.WithExercise.Environment", "Practice environment for {f0} with exercise");

        put("FullParticipantLearner.Role.LDLearner", "Fullparticipants");
        put("FullParticipantInstructor.Role.LDLearner", "Fullparticipants");

        //-- ILEvents
        put("ClarifyingProblem.ILEvent", "Clarifying the problem of {f0}");
        put("DemonHowSolveProblem.ILEvent", "Demonstration how solve problem of {f0}");
        put("DiagProblem.ILEvent", "Diagnosing the problem of {f0}");
        put("ElicitPerformance.ILEvent", "Elicit the performance of {f0}");
        put("InstDiscussion.ILEvent", "Instigating of discussion of {f0}");
        put("InstThinking.ILEvent", "Instigating of thinking of {f0}");
        put("KnowlTransmission.ILEvent", "Knowledge transmission of {f0}");
        put("Monitoring.ILEvent", "Monitoring of {f0}");
        put("NotifyHowLearnerIs.ILEvent", "Notifying how learner is on {f0}");
        put("ShowSolution.ILEvent", "Show solution of {f0}");
        put("SetLearningContext.ILEvent", "Setting learning context of {f0}");
        put("ReqProblemDetail.ILEvent", "Request problem details of {f0}");
        
        //-- Interactions
        put("ShowSolution.InstDiscussion.Iteractions", "Show solutions and instigating discussion");
        put("ReqProblemDetail.InstThinking.Iteractions", "Request problem detail and instigating discussion");
        put("ReqProblemDetail.NotifyHowLearnerIs.Iteractions", "Request problem detail and instigating discussion");
        put("ReqProblemDetail.ShowSolution.Iteractions", "Request problem detail and show solutions");
        put("Monitoring.ProblemDetail.Iteractions", "Monitoring and request problem detail");
        put("Monitoring.InstThinking.Iteractions", "Monitoring and instigating thinking");
        put("DemonHowSolveProblem.ProblemDetail.Iteractions", "Demonstrating how solve problem and detail solution of problem");
        put("KnowlTransmission.ProblemDetail.Iteractions", "Knowledge transmission and request problem detail");
        put("MetarecognizeCommunication.WithMonitoring.Iteractions", "Metarecognize communication with monitoring");
        put("MetarecognizeCommunication.WithInstigating.Iteractions", "Metarecognize communication with instigating");
        put("MetarecognizeCommunication.Iteractions", "Metarecognize communication");
        put("MetarecognizeProgress.Iteractions", "Metarecognize progress");
        put("MetadiagElicitPerformance.Iteractions", "Metadiagnosing elicit performance");
        put("Metadiagnosing.Iteractions", "Metadiagnosing");
        put("Monitoring.InstThinking.WithMetademon.Iteractions", "Monitoring and instigating thinking with meta-demonstration");
        

        put("DistCognition.Interactions", "Distributed cognition for {f0}");

        put("Learning.Item", "Learning item for {f0}");
        put("Instructional.Item", "Instructional item for {f0}");


        put("Synchronous.Conference", "Synchronous conference");
        put("LearningObject", "Learning object for {f0}");

        put("LearningObject", "Learning object for {f0}");
        put("Group", "Group {rn}");
        put("Resource", "{s0}");
    }});


    @SuppressWarnings("serial")
    public static final Map<String, Collection<String>> kinds = Collections.unmodifiableMap(new HashMap<String, Collection<String>>() {{
        put("Resource", new ArrayList<String>());
        //-- domain elements
        put("Auxiliary", Arrays.asList(new String[]{"Knowledge"}));
        put("Fundamental", Arrays.asList(new String[]{"Knowledge"}));
        put("Skill", new ArrayList<String>());
        put("Attitude", new ArrayList<String>());
        put("IndependentSkill", Arrays.asList(new String[]{"Skill"}));
        //-- descriptions
        put("SessionDescription", new ArrayList<String>());
        put("ILEventDescription", new ArrayList<String>());
        //-- competences
        put("ForAuxiliary", Arrays.asList(new String[]{"Competency"}));
        put("ForFundamental", Arrays.asList(new String[]{"Competency"}));
        //-- learners
        put("Learner", Arrays.asList(new String[]{"User"}));
    }});

    public static final String baseURL = "http://localhost:8080/coursegenerator";

    //    @SuppressWarnings("serial")
    //    public static final Map<String, String> TEXTS = Collections.unmodifiableMap(new HashMap<String, String>(){{
    //        put("Resource", "{0}");
    //        put("Synchronous.Conference", "Conferencia sincrona para {0}");
    //        put("Asynchronous.Conference", "Conferencia asincrona para {0}");
    //    }});
    //
    //    //-- values for conference
    //
    //    @SuppressWarnings("serial")
    //    public static final Map<String, Metadata> SERVICES = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
    //        put("default-synchronous-conference", new Metadata("default-synchronous-conference").addType("Service")
    //                .addProperty(new Property().setName("hasCommunicationType").setValue("synchronous"))
    //                .setTitle("Synchonous_conference_using_gTalk"));
    //        put("default-asynchronous-conference", new Metadata("default-asynchronous-conference").addType("Service")
    //                .addProperty(new Property().setName("hasCommunicationType").setValue("asynchronous"))
    //                .setTitle("Asynchonous_conference_using_forum_groups_google"));
    //    }});
    //

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> ILEVENT_DESCRIPTIONS = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
        //--
        Resource resource1 = new Resource().setTitle("Identifying the problem");
        resource1.setId(resource1.getUuid());
        resource1.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/identifying-problem.html");

        Metadata description1 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("IdentifyingProblem");
        description1.addProperty(new Property().setName("hasTitle").setValue("Identifying the problem"));
        description1.setResource(resource1);
        this.put(description1.getId(), description1);

        //--
        Resource resource2 = new Resource().setTitle("Externalization of problems");
        resource2.setId(resource2.getUuid());
        resource2.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/externalization-problem.html");

        Metadata description2 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ExternalizationProblem");
        description2.addProperty(new Property().setName("hasTitle").setValue("Externalization of problems"));
        description2.setResource(resource2);
        this.put(description2.getId(), description2);

        //--
        Resource resource3 = new Resource().setTitle("Demonstration");
        resource3.setId(resource3.getUuid());
        resource3.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/demonstration.html");

        Metadata description3 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("Demonstration");
        description3.addProperty(new Property().setName("hasTitle").setValue("Demonstration"));
        description3.setResource(resource3);
        this.put(description3.getId(), description3);

        //--
        Resource resource4 = new Resource().setTitle("Observing demonstration");
        resource4.setId(resource4.getUuid());
        resource4.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/observing-demonstration.html");

        Metadata description4 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ObservingDemonstration");
        description4.addProperty(new Property().setName("hasTitle").setValue("Observing demonstration"));
        description4.setResource(resource4);
        this.put(description4.getId(), description4);

        //--
        Resource resource5 = new Resource().setTitle("Diagnosing");
        resource5.setId(resource5.getUuid());
        resource5.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/diagnosing.html");

        Metadata description5 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("Diagnosis");
        description5.addProperty(new Property().setName("hasTitle").setValue("Diagnosis"));
        description5.setResource(resource5);
        this.put(description5.getId(), description5);

        //--
        Resource resource6 = new Resource().setTitle("Receiving diagnosis");
        resource6.setId(resource6.getUuid());
        resource6.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/receiving-diagnosis.html");

        Metadata description6 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ReceivingDiagnosis");
        description6.addProperty(new Property().setName("hasTitle").setValue("Receiving diagnosis"));
        description6.setResource(resource6);
        this.put(description6.getId(), description6);

        //--
        Resource resource7 = new Resource().setTitle("Giving performance");
        resource7.setId(resource7.getUuid());
        resource7.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/giving-performance.html");

        Metadata description7 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("GivingPerformance");
        description7.addProperty(new Property().setName("hasTitle").setValue("Giving performance"));
        description7.setResource(resource7);
        this.put(description7.getId(), description7);

        //--
        Resource resource8 = new Resource().setTitle("Receiving performance");
        resource8.setId(resource8.getUuid());
        resource8.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/receiving-performance.html");

        Metadata description8 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ReceivingPerformance");
        description8.addProperty(new Property().setName("hasTitle").setValue("Receiving performance"));
        description8.setResource(resource8);
        this.put(description8.getId(), description8);

        //--
        Resource resource9 = new Resource().setTitle("Request opinion");
        resource9.setId(resource9.getUuid());
        resource9.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/request-opinion.html");

        Metadata description9 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("RequestOpinion");
        description9.addProperty(new Property().setName("hasTitle").setValue("Request opinion"));
        description9.setResource(resource9);
        this.put(description9.getId(), description9);

        //--
        Resource resource10 = new Resource().setTitle("Exposing opinion");
        resource10.setId(resource10.getUuid());
        resource10.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/exposing-opinion.html");

        Metadata description10 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ExposingOpinion");
        description10.addProperty(new Property().setName("hasTitle").setValue("Exposing opinion"));
        description10.setResource(resource10);
        this.put(description10.getId(), description10);

        //--
        Resource resource11 = new Resource().setTitle("Argumentation");
        resource11.setId(resource11.getUuid());
        resource11.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/argumentation.html");

        Metadata description11 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("Argumentation");
        description11.addProperty(new Property().setName("hasTitle").setValue("Argumentation"));
        description11.setResource(resource11);
        this.put(description11.getId(), description11);

        //--
        Resource resource12 = new Resource().setTitle("Receiving arguments");
        resource12.setId(resource12.getUuid());
        resource12.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/receiving-arguments.html");

        Metadata description12 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ReceivingArguments");
        description12.addProperty(new Property().setName("hasTitle").setValue("Receiving arguments"));
        description12.setResource(resource12);
        this.put(description12.getId(), description12);

        //--
        Resource resource13 = new Resource().setTitle("Explanation");
        resource13.setId(resource13.getUuid());
        resource13.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/explanation.html");

        Metadata description13 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("Explanation");
        description13.addProperty(new Property().setName("hasTitle").setValue("Explanation"));
        description13.setResource(resource13);
        this.put(description13.getId(), description13);

        //--
        Resource resource14 = new Resource().setTitle("Receiving explanation");
        resource14.setId(resource14.getUuid());
        resource14.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/receiving-explanation.html");

        Metadata description14 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ReceivingExplanation");
        description14.addProperty(new Property().setName("hasTitle").setValue("Receiving explanation"));
        description14.setResource(resource14);
        this.put(description14.getId(), description14);

        //--
        Resource resource15 = new Resource().setTitle("Checking");
        resource15.setId(resource15.getUuid());
        resource15.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/checking.html");

        Metadata description15 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("Checking");
        description15.addProperty(new Property().setName("hasTitle").setValue("Checking"));
        description15.setResource(resource15);
        this.put(description15.getId(), description15);

        //--
        Resource resource16 = new Resource().setTitle("Being checked");
        resource16.setId(resource16.getUuid());
        resource16.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/being-checked.html");

        Metadata description16 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("BeingChecked");
        description16.addProperty(new Property().setName("hasTitle").setValue("Being checked"));
        description16.setResource(resource16);
        this.put(description16.getId(), description16);

        //--
        Resource resource17 = new Resource().setTitle("Giving information");
        resource17.setId(resource17.getUuid());
        resource17.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/giving-information.html");

        Metadata description17 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("GivingInformation");
        description17.addProperty(new Property().setName("hasTitle").setValue("Giving information"));
        description17.setResource(resource17);
        this.put(description17.getId(), description17);

        //--
        Resource resource18 = new Resource().setTitle("Receiving information");
        resource18.setId(resource18.getUuid());
        resource18.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/receiving-information.html");

        Metadata description18 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("ReceivingInformation");
        description18.addProperty(new Property().setName("hasTitle").setValue("Receiving information"));
        description18.setResource(resource18);
        this.put(description18.getId(), description18);

        //--
        Resource resource19 = new Resource().setTitle("Ask problems");
        resource19.setId(resource19.getUuid());
        resource19.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/ask-problems.html");

        Metadata description19 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("AskProblems");
        description19.addProperty(new Property().setName("hasTitle").setValue("Ask problems"));
        description19.setResource(resource19);
        this.put(description19.getId(), description19);

        //--
        Resource resource20 = new Resource().setTitle("Point problems");
        resource20.setId(resource20.getUuid());
        resource20.setHref("http://www.ime.usp.br/~geiser/doc/ilevents/point-problems.html");

        Metadata description20 = new Metadata(UUID.uuid(10, "descr")).addType("ILEventDescription").addType("PointProblems");
        description20.addProperty(new Property().setName("hasTitle").setValue("Point problems"));
        description20.setResource(resource20);
        this.put(description20.getId(), description20);

    }});

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> SESSION_DESCRIPTIONS = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
        //--
        Resource resource1 = new Resource().setTitle("Simulation activity");
        resource1.setId(resource1.getUuid());
        resource1.setHref("http://www.ime.usp.br/~geiser/doc/sessions/simulation.html");

        Metadata description1 = null;
        description1 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("SimulationActivity");
        description1.addProperty(new Property().setName("hasTitle").setValue("Simulation activity"));
        description1.setResource(resource1);
        this.put(description1.getId(), description1);

        //--
        Resource resource2 = new Resource().setTitle("Share activity");
        resource2.setId(resource2.getUuid());
        resource2.setHref("http://www.ime.usp.br/~geiser/doc/sessions/share.html");

        Metadata description2 = null;
        description2 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("ShareActivity");
        description2.addProperty(new Property().setName("hasTitle").setValue("Share activity"));
        description2.setResource(resource2);
        this.put(description2.getId(), description2);

        //--
        Resource resource3 = new Resource().setTitle("Role activity");
        resource3.setId(resource3.getUuid());
        resource3.setHref("http://www.ime.usp.br/~geiser/doc/sessions/role-playing.html");

        Metadata description3 = null;
        description3 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("RoleActivity");
        description3.addProperty(new Property().setName("hasTitle").setValue("Role activity"));
        description3.setResource(resource3);
        this.put(description3.getId(), description3);

        //--
        Resource resource4 = new Resource().setTitle("Pair activity");
        resource4.setId(resource4.getUuid());
        resource4.setHref("http://www.ime.usp.br/~geiser/doc/sessions/pair.html");

        Metadata description4 = null;
        description4 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("PairActivity");
        description4.addProperty(new Property().setName("hasTitle").setValue("Pair activity"));
        description4.setResource(resource4);
        this.put(description4.getId(), description4);

        //--
        Resource resource5 = new Resource().setTitle("Jigsaw activity");
        resource5.setId(resource5.getUuid());
        resource5.setHref("http://www.ime.usp.br/~geiser/doc/sessions/jigsaw.html");

        Metadata description5 = null;
        description5 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("JigsawActivity");
        description5.addProperty(new Property().setName("hasTitle").setValue("Jigsaw activity"));
        description5.setResource(resource5);
        this.put(description5.getId(), description5);

        //--
        Resource resource6 = new Resource().setTitle("Individual activity");
        resource6.setId(resource6.getUuid());
        resource6.setHref("http://www.ime.usp.br/~geiser/doc/sessions/individual.html");

        Metadata description6 = null;
        description6 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("IndividualActivity");
        description6.addProperty(new Property().setName("hasTitle").setValue("Individual activity"));
        description6.setResource(resource6);
        this.put(description6.getId(), description6);

        //--
        Resource resource7 = new Resource().setTitle("Expert activity");
        resource7.setId(resource7.getUuid());
        resource7.setHref("http://www.ime.usp.br/~geiser/doc/sessions/expert.html");

        Metadata description7 = null;
        description7 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("ExpertActivity");
        description7.addProperty(new Property().setName("hasTitle").setValue("Expert activity"));
        description7.setResource(resource7);
        this.put(description7.getId(), description7);

        //--
        Resource resource8 = new Resource().setTitle("Discussion activity");
        resource8.setId(resource8.getUuid());
        resource8.setHref("http://tinyurl.com/c4sojgz");

        Metadata description8 = null;
        description8 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("DiscussionActivity");
        description8.addProperty(new Property().setName("hasTitle").setValue("Discussion activity"));
        description8.setResource(resource8);
        this.put(description8.getId(), description8);

        //--
        Resource fresource1 = new Resource().setTitle("Show proof activity");
        fresource1.setId(fresource1.getUuid());
        fresource1.setHref("http://www.ime.usp.br/~geiser/doc/sessions/show-proof.html");

        Metadata fdescription1 = null;
        fdescription1 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("ShowProofActivity");
        fdescription1.addProperty(new Property().setName("hasTitle").setValue("Show proof activity"));
        fdescription1.setResource(fresource1);
        this.put(fdescription1.getId(), fdescription1);

        //--
        Resource fresource2 = new Resource().setTitle("Show problem activity");
        fresource2.setId(fresource2.getUuid());
        fresource2.setHref("http://www.ime.usp.br/~geiser/doc/sessions/show-problem.html");

        Metadata fdescription2 = null;
        fdescription2 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("ShowProblemActivity");
        fdescription2.addProperty(new Property().setName("hasTitle").setValue("Show problem activity"));
        fdescription2.setResource(fresource2);
        this.put(fdescription2.getId(), fdescription2);

        //--
        Resource fresource3 = new Resource().setTitle("Practice with exercise activity");
        fresource3.setId(fresource3.getUuid());
        fresource3.setHref("http://www.ime.usp.br/~geiser/doc/sessions/practice-exercise.html");

        Metadata fdescription3 = null;
        fdescription3 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("PracticeWithExerciseActivity");
        fdescription3.addProperty(new Property().setName("hasTitle").setValue("Practice with exercise activity"));
        fdescription3.setResource(fresource3);
        this.put(fdescription3.getId(), fdescription3);

        //--
        Resource fresource4 = new Resource().setTitle("Motivation activity");
        fresource4.setId(fresource4.getUuid());
        fresource4.setHref("http://www.ime.usp.br/~geiser/doc/sessions/motivation.html");

        Metadata fdescription4 = null;
        fdescription4 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("MotivationActivity");
        fdescription4.addProperty(new Property().setName("hasTitle").setValue("Motivation activity"));
        fdescription4.setResource(fresource4);
        this.put(fdescription4.getId(), fdescription4);

        //--
        Resource fresource5 = new Resource().setTitle("Illustrate with example activity");
        fresource5.setId(fresource5.getUuid());
        fresource5.setHref("http://www.ime.usp.br/~geiser/doc/sessions/illustrate-example.html");
        
        Metadata fdescription5 = null;
        fdescription5 = new Metadata(UUID.uuid(10, "descr")).addType("SessionDescription").addType("IllustrateWithExampleActivity");
        fdescription5.addProperty(new Property().setName("hasTitle").setValue("Illustrate with example activity"));
        fdescription5.setResource(fresource5);
        this.put(fdescription5.getId(), fdescription5);
    }});

    //    @SuppressWarnings("serial")
    //    public static final Map<String, Metadata> SKILLS = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
    //        Metadata skill = null;
    //        //--
    //        skill = new Metadata("discussion").addType("Skill")
    //                .setTitle("Discussion");
    //        put(skill.getId(), skill);
    //        //--
    //        skill = new Metadata("problem-solving").addType("Skill")
    //                .setTitle("Problem_solving");
    //        put(skill.getId(), skill);
    //        //--
    //        skill = new Metadata("analytical-reasoning").addType("Skill")
    //                .setTitle("Analytical_reasoning");
    //        put(skill.getId(), skill);
    //        //--
    //        skill = new Metadata("long-term-memory").addType("Skill")
    //                .setTitle("Long_term_memory");
    //        put(skill.getId(), skill);
    //    }});
    //
    //    @SuppressWarnings("serial")
    //    public static final Map<String, Metadata> ATTITUDES = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
    //        Metadata attitude = null;
    //        //--
    //        attitude = new Metadata("focus-students-attention").addType("Attitude")
    //                .setTitle("Focus_students_attention");
    //        put(attitude.getId(), attitude);
    //        //--
    //        attitude = new Metadata("positive-interdependence").addType("Attitude")
    //                .setTitle("Positive_interdependence");
    //        put(attitude.getId(), attitude);
    //        //--
    //        attitude = new Metadata("individual-accountability").addType("Attitude")
    //                .setTitle("Individual_accountability");
    //        put(attitude.getId(), attitude);
    //        //--
    //        attitude = new Metadata("sharing-ideas").addType("Attitude")
    //                .setTitle("Sharing_ideas");
    //        put(attitude.getId(), attitude);
    //        //--
    //        attitude = new Metadata("students-confidence").addType("Attitude")
    //                .setTitle("Students_confidence");
    //        put(attitude.getId(), attitude);
    //        //--
    //        attitude = new Metadata("tolerance-and-respect").addType("Attitude")
    //                .setTitle("Tolerance_and_respect");
    //        put(attitude.getId(), attitude);
    //    }});

    public static String[] SLEVELS = {"nothing", "rough", "explanatory", "associative", "autonomous"};
    public static String[] KLEVELS = {"nothing", "accretion", "tuning", "restructuring"};

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> LEVELS = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
        for (int sl = 0; sl <= 4; sl++) {
            for (int kl = 0; kl <= 3; kl++) {
                Metadata level = new Metadata("s"+sl+"k"+kl).addType("Level")
                        .addProperty(new Property().setName("hasSkillLevel").setValue(SLEVELS[sl]))
                        .addProperty(new Property().setName("hasKnowledgeLevel").setValue(KLEVELS[kl]));
                this.put(level.getId(), level);
            }
        }
    }});

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> INDGOALS = Collections.unmodifiableMap(new HashMap<String, Metadata>() {{
        for (int isl = 0; isl <= 4; isl++) {
            for (int ikl = 0; ikl <= 3; ikl++) {
                for (int gsl = isl; gsl <= 4; gsl++) {
                    for (int gkl = ikl; gkl <= 3; gkl++) {
                        if (isl <= gsl && ikl <= gkl) {
                            String id = "s" + isl + "k" + ikl + "s" + gsl + "k" + gkl; 
                            this.put(id, new Metadata(id).addType("IndGoal")
                                    .addProperty(new Property().setName("hasInitStage").setValue("s" + isl + "k" + ikl))
                                    .addProperty(new Property().setName("hasGoalStage").setValue("s" + gsl + "k" + gkl)));
                        }
                    }
                }
            }
        }
    }});

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> CLROLES = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
        //--
        Metadata role = new Metadata("anchor-holder").addType("CLRole").addType("AnchorHolder")
                .addProperty(new Property().setName("hasBehavioral").setValue("presenter"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k1"));
        put(role.getId(), role);
        //--
        role = new Metadata("anchored-instructor").addType("CLRole").addType("AnchoredInstructor")
                .addProperty(new Property().setName("hasBehavioral").setValue("adviser"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k3"));
        put(role.getId(), role);
        //--
        role = new Metadata("apprenticeship").addType("CLRole").addType("Apprenticeship")
                .addProperty(new Property().setName("hasTitle").setValue("apprenticeship title"))
                .addProperty(new Property().setName("hasBehavioral").setValue("imitator"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k3"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k3"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k3"));
        put(role.getId(), role);
        //--
        role = new Metadata("master").addType("CLRole").addType("Master")
                .addProperty(new Property().setName("hasTitle").setValue("master title"))
                .addProperty(new Property().setName("hasBehavioral").setValue("guide"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k3"));
        put(role.getId(), role);
        //--
        role = new Metadata("audience").addType("CLRole").addType("Audience")
                .addProperty(new Property().setName("hasBehavioral").setValue("reviewer"))
                .addProperty(new Property().setName("hasBehavioral").setValue("evaluator"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k2"));
        put(role.getId(), role);
        //--
        role = new Metadata("panelist").addType("CLRole").addType("Panelist")
                .addProperty(new Property().setName("hasBehavioral").setValue("presenter"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k3"));
        put(role.getId(), role);
        //--
        role = new Metadata("full-participant").addType("CLRole").addType("FullPart")
                .addProperty(new Property().setName("hasBehavioral").setValue("problem-solver"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k3"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k2"));
        put(role.getId(), role);
        //--
        role = new Metadata("peripheral-participant").addType("CLRole").addType("Peripheral")
                .addProperty(new Property().setName("hasBehavioral").setValue("problem-solver"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k3"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k2"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k3"));
        put(role.getId(), role);
        //--
        role = new Metadata("peer-tutee").addType("CLRole").addType("PeerTutee")
                .addProperty(new Property().setName("hasBehavioral").setValue("passive-learner"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k0"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k0"));
        put(role.getId(), role);
        //--
        role = new Metadata("peer-tutor").addType("CLRole").addType("PeerTutor")
                .addProperty(new Property().setName("hasBehavioral").setValue("explainer"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s0k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s1k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s2k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s3k1"))
                .addProperty(new Property().setName("hasCompetencyLevel").setValue("s4k1"));
        put(role.getId(), role);
    }});

    @SuppressWarnings("serial")
    public static final Map<String, Metadata> STRATEGIES = Collections.unmodifiableMap(new HashMap<String, Metadata>() {{
        Set<Property> properties = new HashSet<Property>();
        for (int x = 0; x <= 4; x++) {
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k0s" + x + "k1"));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k0s" + x + "k2"));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k1s" + x + "k2"));
        }
        put("learning-by-being-taught-anchor-holder", new Metadata("learning-by-being-taught-anchor-holder").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("anchor-holder")).addProperties(properties));
        // --
        properties = new HashSet<Property>();
        for (int x = 0; x <= 4; x++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k0s" + x + "k1"));
        }
        put("learning-by-being-taught-peer-tutee", new Metadata("learning-by-being-taught-peer-tutee").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("peer-tutee")).addProperties(properties));
        // --
        put("learning-by-diagnosing", new Metadata("learning-by-diagnosing").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("anchored-instructor"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k1s3k1"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s3k1s3k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k1s3k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k1s2k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k2s3k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k1s3k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s2k3s3k3")));
        // --
        properties = new HashSet<Property>();
        for (int y = 0; y <= 3; y++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s0k" + y + "s1k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s1k" + y + "s2k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s2k" + y + "s3k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s0k" + y + "s2k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s0k" + y + "s3k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s1k" + y + "s3k" + y));
        }
        put("learning-by-apprenticeship", new Metadata("learning-by-apprenticeship").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("apprenticeship")).addProperties(properties));
        // --
        properties = new HashSet<Property>();
        for (int y = 0; y <= 3; y++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s3k" + y + "s4k" + y));
        }
        put("learning-by-guiding", new Metadata("learning-by-guiding").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("master")).addProperties(properties));
        // --
        properties = new HashSet<Property>();
        for (int x = 0; x <= 4; x++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k2s" + x + "k3"));
        }
        put("learning-by-reflection", new Metadata("learning-by-reflection").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("audience")).addProperties(properties));
        // --
        properties = new HashSet<Property>();
        for (int y = 0; y <= 3; y++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s2k" + y + "s3k" + y));
        }
        put("learning-by-selfexpression", new Metadata("learning-by-selfexpression").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("panelist")).addProperties(properties));
        // --
        put("learning-by-discussion", new Metadata("learning-by-discussion").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("full-participant"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s3k2s4k2"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s3k3s4k3"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s3k2s3k3"))
                .addProperty(new Property().setName("hasIndividualGoal").setValue("s4k2s4k3")));
        // --
        properties = new HashSet<Property>();
        for (int y = 0; y <= 3; y++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s0k" + y + "s1k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s1k" + y + "s3k" + y));
            properties.add(new Property().setName("hasIndividualGoal").setValue("s0k" + y + "s3k" + y));
        }
        put("learning-by-practice", new Metadata("learning-by-practice").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("peripheral-participant")).addProperties(properties));
        // --
        properties = new HashSet<Property>();
        for (int x = 0; x <= 4; x++){
            properties.add(new Property().setName("hasIndividualGoal").setValue("s" + x + "k1s" + x + "k2"));
        }
        put("learning-by-teaching", new Metadata("learning-by-teaching").addType("LearningStrategy")
                .addProperty(new Property().setName("hasRole").setValue("peer-tutor")).addProperties(properties));
    }});


    @SuppressWarnings("serial")
    public static final Map<String, Metadata> CLSCENARIOS = Collections.unmodifiableMap(new HashMap<String, Metadata>(){{
        put("anchored-instruction", new Metadata("anchored-instruction").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("knowledge-construction"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-being-taught-anchor-holder"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-diagnosing")));
        put("cognitive-apprenticeship", new Metadata("cognitive-apprenticeship").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("spread-skill"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-apprenticeship"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-guiding")));
        put("cognitive-flexibility", new Metadata("cognitive-flexibility").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("knowledge-sharing"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-reflection"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-selfexpression")));
        put("distributed-cognition", new Metadata("distributed-cognition").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("knowledge-sharing"))
                .addProperty(new Property().setName("hasCommonGoal").setValue("creating-solution"))
                .addProperty(new Property().setName("hasCommonGoal").setValue("knowledge-construction"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-discussion")));
        put("lpp", new Metadata("lpp").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("spread-skill"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-practice"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-discussion")));
        put("peer-tutoring", new Metadata("peer-tutoring").addType("CLScenario")
                .addProperty(new Property().setName("hasCommonGoal").setValue("knowledge-construction"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-being-taught-peer-tutee"))
                .addProperty(new Property().setName("hasStrategy").setValue("learning-by-teaching")));
    }});

}