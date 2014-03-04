
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Relation;

public class Graph<T extends Metadata, K> {
    
    final static String endl = System.getProperty("line.separator");

	private final NodeList<T> nodes = new NodeList<T>();

	public NodeList<T> getNodes() {
		return this.nodes;
	}
	
	private Graph<T,K> addNode(GraphNode<T, K> node) {
		this.nodes.add(node);
		return this;
	}
	
	public Graph<T,K> addNode(T data) {
		return this.addNode(new GraphNode<T, K>(data));
	}
	
	@SuppressWarnings("unchecked")
	protected boolean removeNode(GraphNode<T, K> dataNode) {
		for (Node<T> node : this.nodes) {
			if (node.getNeighbors().remove(dataNode)) {
				((GraphNode<T, K>) node).removeValue(dataNode);
			}
		}
		return this.nodes.remove(dataNode);
	}

	@SuppressWarnings("unchecked")
	public boolean removeNode(T data) {
		Node<T> dataNode = this.nodes.find(data);
		if (dataNode != null) {			
			return this.removeNode((GraphNode<T, K>) dataNode);
		}
		return false;
	}

	protected Graph<T, K> addEdge(GraphNode<T, K> from, GraphNode<T, K> to, K value) {
		if (!this.nodes.contains(from)) { this.addNode(from); }
		if (!this.nodes.contains(to)) { this.addNode(to); }
		from.getNeighbors().add(to);
		from.setValue(to, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public Graph<T, K> addEdge(T from, T to, K value) {
		Node<T> nodeTo = this.nodes.find(to);
		Node<T> nodeFrom = this.nodes.find(from);
		if (nodeTo == null) { nodeTo = new GraphNode<T, K>(from); }
		if (nodeFrom == null) { nodeFrom = new GraphNode<T, K>(to); }
		return this.addEdge((GraphNode<T, K>) nodeFrom, (GraphNode<T, K>) nodeTo, value);
	}
	
	public boolean existPath(T from, T to) {
	    return this.existPath(this.nodes.find(from), this.nodes.find(to));
	}
	
	private boolean existPath(Node<T> from, Node<T> to) {
	    if (from.getNeighbors().contains(to)) {
	        return true;
	    } else {
	        boolean result = false;
	        Iterator<Node<T>> it = from.getNeighbors().iterator();
	        while (it.hasNext() && !result) {
	            Node<T> node = it.next();
	            result = existPath(node, to);
	        }
	        return result;
	    }
	}
	
	public String toJSHOP2() {
	    String s = "";
	    for (Node<T> node : this.nodes) {
	        s += node.toJSHOP2() + endl;
	    }
	    return s;
	}

    public String toSQL() {
        String result = "";
        for (Node<T> nodeFrom : this.nodes) {
            GraphNode<T,K> from = (GraphNode<T,K>) nodeFrom;
            for (Node<T> nodeTo : from.getNeighbors()) {
                //result += new Relation().setName(from.getValue(nodeTo.getData()).toString()).setSource(from.getData()).setDest(nodeTo.getData().getId()).toSQL() + endl;
            }
        }
        return result;
    }

    public Collection<Relation> getRelations() {
        Set<Relation> result = new HashSet<Relation>();
        for (Node<T> nodeFrom : this.nodes) {
            GraphNode<T,K> from = (GraphNode<T,K>) nodeFrom;
            for (Node<T> nodeTo : from.getNeighbors()) {
                result.add(new Relation().setName(from.getValue(nodeTo.getData()).toString()).setSource(from.getData()).setDest(nodeTo.getData().getId()));
            }
        }
        return result;
    }
	
}
