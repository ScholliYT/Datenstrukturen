public class Queue {
	protected Node head;
	protected Node tail;

	public void enqueue(Object o) {
		Node toEnqueue = new Node(o, null);
		if(isEmpty()) {  // 0 Elements in Queue
			head = toEnqueue;
		}
		else {  // Not 0 Elements in Queue
			tail.setNextNode(toEnqueue);			
		}
		tail = toEnqueue;
	}

	public Object dequeue() {
		Object o = head.getObject();
		head = head.getNextNode();
		return o;
	}

	public Object front() {
		return head.getObject();
	}

	public boolean isEmpty() {
		return head == null;
	}
}