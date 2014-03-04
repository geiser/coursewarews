
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.usp.ime.lapessc.courseware.model.Metadata;

public class GraphNode<T extends Metadata, V> extends Node<T> {

	private final Map<GraphNode<T, V>, V> values = new HashMap<GraphNode<T, V>, V>();

	public GraphNode(T data) {
		super(data);
	}

	public Collection<V> getCollectionValues() {
		return this.values.values();
	}

	private V getValue(GraphNode<T, V> node) {
		return this.values.get(node);
	}

	@SuppressWarnings("unchecked")
	public V getValue(T data) {
		Node<T> node = this.getNeighbors().find(data);
		if (node != null) {
			return this.getValue((GraphNode<T, V>) node);
		}
		return null;
	}

	protected GraphNode<T, V> setValue(GraphNode<T, V> node, V value) {
		this.values.put(node, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public GraphNode<T, V> setValue(T data, V value) {
		Node<T> node = this.getNeighbors().find(data);
		if (node != null) {
			return this.setValue((GraphNode<T, V>) node, value);
		}
		return this;
	}
	
	protected boolean removeValue(GraphNode<T, V> node) {
		if (this.values.remove(node) != null) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean removeValue(T data) {
		Node<T> node = this.getNeighbors().find(data);
		if (node != null) {
			return this.removeValue((GraphNode<T, V>) node);
		}
		return false;
	}

    @Override
    public String toJSHOP2() {
        String s = ""; 
        for (Node<T> node : this.getNeighbors()) {
            @SuppressWarnings("unchecked")
            V value = this.getValue((GraphNode<T, V>) node);
            s += "(relation " + this.getData().getId() + " " + value.toString() + " " + node.getData().getId() + ")" + endl;
        }
        return s;
    }

}
