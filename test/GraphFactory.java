
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.usp.ime.lapessc.courseware.model.Metadata;

public class GraphFactory<T extends Metadata, V> {

    private final List<T> nodes;
    private final V value;

    public GraphFactory(Collection<T> nodes, V value) {
        this.nodes = new ArrayList<T>(nodes);
        this.value = value;
    }

    public GraphFactory(List<T> nodes, V value) {
        this.nodes = nodes;
        this.value = value;
    }

    public Graph<T, V> buildAcyclic(int maxOutDegree) {
        maxOutDegree = Math.min(maxOutDegree, nodes.size());
        Graph<T, V> graph = new Graph<T,V>();
        for (T data : this.nodes) {
            graph.addNode(data);
        }
        if (maxOutDegree > 0) {
            for (T fromData : this.nodes) {
                int degree = (int) (Math.random() * maxOutDegree);
                for (int count = 0; count < degree; count++) {
                    int fromIdx = (int) (Math.random() * nodes.size());
                    T toData = this.nodes.get(fromIdx);
                    if (!fromData.equals(toData) && !graph.existPath(toData, fromData)) {
                        graph.addEdge(fromData, toData, this.value);
                    }
                }
            }
        }
        return graph;
    }
    
    public Graph<T, V> buildTree(int maxDepth) {
        Set<Node<T>> marks = new HashSet<Node<T>>();
        Graph<T, V> graph = new Graph<T,V>();
        Graph<T, V> tmpGraph = this.buildAcyclic(maxDepth);
        for (Node<T> nodeFrom : tmpGraph.getNodes()) {
            marks.add(nodeFrom);
            for (Node<T> nodeTo : nodeFrom.getNeighbors()) {
                if (!marks.contains(nodeTo)) {
                    graph.addEdge(nodeFrom.getData(), nodeTo.getData(), this.value);
                    marks.add(nodeTo);
                }
            }
        }
        return graph;
    }

}
