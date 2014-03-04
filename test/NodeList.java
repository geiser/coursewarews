
import java.util.HashSet;
import java.util.Iterator;

import br.usp.ime.lapessc.courseware.model.Metadata;

public class NodeList<T extends Metadata> extends HashSet<Node<T>> {

	private static final long serialVersionUID = 5641257850883465596L;

	public Node<T> find(T data) {
		if (data == null) return null;
		Iterator<Node<T>> it = this.iterator();
		while (it.hasNext()) {
			Node<T> node = it.next();
			if (data.equals(node.getData())) return node;
		}
		return null;
	}
	
}