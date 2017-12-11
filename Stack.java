public class Stack {
	private Node topNode;

	public void put(Object _o) {
		topNode = new Node(_o, topNode);
	}

	public Object pop() {
		Object save = topNode.getObject();
		topNode = topNode.getNextNode(); //Can NullPointException
		return save;
	}

	public Object peek() {
		return topNode.getObject(); //Can NullPointException
	}

	public boolean isEmpty() {
		return topNode == null;
	}
}