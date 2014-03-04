package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class CLScenarioList extends HashMap<String, CLScenario> {
    
    private static final long serialVersionUID = 1L;

    /**
     * clscenarios by competency and name
     *  - key -> competency : termConstant
     *  - value -> (name, set of scenarios) : map<String, CLScenario>
     */
    //private final Map<TermConstant, Map<String, HashSet<CLScenario>>> clscenariosByCompName = new HashMap<TermConstant, Map<String, HashSet<CLScenario>>>(); // element used to search

    public CLScenarioList add(CLScenario clscenario) {
        if (clscenario.id == null) {
            clscenario.id = UUID.randomUUID().toString();
        }
        
        Set<TermConstant> exist = new HashSet<TermConstant>();
        for (CLStrategy strategy : clscenario.strategies.values()) {
            TermList learnerIds = TermList.NIL;
            List list = strategy.learners.getList();
            while (list != null) {
                if (!exist.contains(list.getHead())) {
                    learnerIds = new TermList((TermConstant) list.getHead(), learnerIds);
                    exist.add((TermConstant) list.getHead());
                }
                list = list.getRest();
            }
            strategy.learners = learnerIds;
            clscenario.strategies.put(strategy.name, strategy);
        }
        
        this.put(clscenario.id, clscenario);
        //-- get clscenarios using competences and name
        /*Map<String, HashSet<CLScenario>> clscenariosByScenarioName = this.clscenariosByCompName.get(compTerm);
        if (clscenariosByScenarioName == null) {
            clscenariosByScenarioName = new HashMap<String, HashSet<CLScenario>>();
        }
        HashSet<CLScenario> clscenariosSet = clscenariosByScenarioName.get(clscenario.name);
        if (clscenariosSet == null) {
            clscenariosSet = new HashSet<CLScenario>();
        }
        //-- put clscenario in array list
        boolean isAdd = clscenariosSet.add(clscenario);
        if (!isAdd) {
            clscenariosSet.remove(clscenario);
            clscenariosSet.add(clscenario);
        }
        // -- put clscenario using goal
        clscenariosByScenarioName.put(clscenario.name, clscenariosSet);
        // -- put clscenario using term comp
        this.clscenariosByCompName.put(compTerm, clscenariosByScenarioName);*/
        return this;
    }

    public CLScenarioList remove(CLScenario clscenario) {
        clscenario = this.remove(clscenario.id);
        //-- get clscenarios using name
        /*Map<String, HashSet<CLScenario>> clscenariosByScenarioName = this.clscenariosByCompName.get(comp);
        if (clscenariosByScenarioName == null) {
            clscenariosByScenarioName = new HashMap<String, HashSet<CLScenario>>();
        }
        HashSet<CLScenario> clscenariosSet = clscenariosByScenarioName.get(clscenario.name);
        if (clscenariosSet == null) {
            clscenariosSet = new HashSet<CLScenario>();
        }

        //-- remove clscenario in set
        clscenariosSet.remove(clscenario);
        // -- put clscenario using goal
        clscenariosByScenarioName.put(clscenario.name, clscenariosSet);
        // -- put clscenario using strategy
        this.clscenariosByCompName.put(comp, clscenariosByScenarioName);*/
        return this;
    }
    /*
    public HashSet<CLScenario> getCLScenarios(TermConstant compTerm, String clscenario) {
        if (this.clscenariosByCompName.containsKey(compTerm)) {
            if (this.clscenariosByCompName.get(compTerm).containsKey(clscenario)) {
                return this.clscenariosByCompName.get(compTerm).get(clscenario);
            }
        }
        return null; 
    }
    
    public CLScenarioList remove(CLScenario clscenario) {
        TermList goalTerm = clscenario.strategies.values().iterator().next().goal;
        return this.remove(clscenario, (TermConstant) goalTerm.getList().getHead());
    }*/

    public Set<CLScenario> getCLScenariosBy(String name, TermConstant comp,
                                            String strategy, TermConstant level) {
        Set<CLScenario> toReturn = new HashSet<CLScenario>();
        for (CLScenario clscenario : this.values()) {
            if (name.equals(clscenario.name) && comp.equals(clscenario.comp)) {
                CLStrategy clstrategy = clscenario.strategies.get(strategy);
                if (clstrategy != null && level.equals(clstrategy.level)) {
                    toReturn.add(clscenario);
                }
            }
        }
        return toReturn;
    }
    
}
