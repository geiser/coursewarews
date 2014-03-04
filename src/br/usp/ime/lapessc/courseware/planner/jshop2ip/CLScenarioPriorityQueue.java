package br.usp.ime.lapessc.courseware.planner.jshop2ip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.UUID;

import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.TermConstant;

public class CLScenarioPriorityQueue extends PriorityQueue<CLScenario> {
    
    private static final long serialVersionUID = 1L;

    public CLScenarioPriorityQueue() {
        super(10, new Comparator<CLScenario>() {
            public int compare(CLScenario scenario1, CLScenario scenario2) {
                int size1 = 0;
                for (CLStrategy strategy : scenario1.strategies.values()) {
                    size1 += strategy.learners.size();
                }
                int size2 = 0;
                for (CLStrategy strategy : scenario2.strategies.values()) {
                    size2 += strategy.learners.size();
                }
                
                if (size1 < size2) {
                    return 1;
                } else if (size1 > size2){
                    return -1;
                }
                return 0;
            }
        });
    }

    public Collection<CLScenario> getBy(String scenarioId, String strategyId, TermConstant comp, TermConstant level) {
        Collection<CLScenario> toReturn = new ArrayList<CLScenario>();
        for (CLScenario scenario : new ArrayList<CLScenario>(this)) {
            if (scenarioId.equals(scenario.name) && comp.equals(scenario.comp)) {
                if (scenario.strategies.containsKey(strategyId) && level.equals(scenario.strategies.get(strategyId).level)) {
                    this.remove(scenario);
                    toReturn.add(scenario);
                } else if (!scenario.strategies.containsKey(strategyId)) {
                    this.remove(scenario);
                    
                    CLStrategy strategy = new CLStrategy();
                    strategy.name = strategyId;
                    strategy.level = level;
                    scenario.strategies.put(strategy.name, strategy);
                    
                    toReturn.add(scenario);
                }
            }
            
        }
        if (toReturn.isEmpty()) {
            CLScenario scenario = new CLScenario();
            scenario.id = UUID.randomUUID().toString();
            scenario.name = scenarioId;
            scenario.comp = comp;
            
            CLStrategy strategy = new CLStrategy();
            strategy.name = strategyId;
            strategy.level = level;
            scenario.strategies.put(strategy.name, strategy);
            
            toReturn.add(scenario);
        }
        return toReturn;
    }

    public boolean containLearner(TermConstant learnerId) {
        boolean toReturn = false;
        Iterator<CLScenario> it = this.iterator();
        while (!toReturn && it.hasNext()) {
            CLScenario scenario = it.next();
            for (CLStrategy strategy : scenario.strategies.values()) {
                List list = strategy.learners.getList();
                while (!toReturn && (list!=null)) {
                    if (learnerId.equals(list.getHead())) {
                        toReturn = true;
                        break;
                    }
                    list = list.getRest();
                }
                if (toReturn) { break; }
            }
        }
        return toReturn;
    }

    
}
