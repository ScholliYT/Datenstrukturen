public class Node {
	private Object o;
	private Node n;
	public Node(Object _o, Node _n) {
		o = _o;
		n = _n;
	}

	public Object getObject() {
		return o;
	}

	public void setObject(Object _o) {
		o = _o;
	}

	public Node getNextNode() {
		return n;
	}

	public void setNextNode(Node _n) {
		n = _n;
	}

}