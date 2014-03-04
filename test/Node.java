import br.usp.ime.lapessc.courseware.model.Metadata;



public abstract class Node<T extends Metadata> {
    
    final static String endl = System.getProperty("line.separator");

	private T data;
	private final NodeList<T> neighbors = new NodeList<T>();

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public Node<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	public NodeList<T> getNeighbors() {
		return this.neighbors;
	}

    public abstract String toJSHOP2();
	
}