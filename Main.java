public class Main {
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		testStack();
		System.out.println();
		testQueue();
		System.out.println();
		testQueueCountable(new QueueCountable_A());
		System.out.println();
		testQueueCountable(new QueueCountable_B());
		System.out.println();
		testQueueCountable(new QueueCountable_C());
	}

	private void testStack() {
		Stack s = new Stack();
		s.put("TollerString");
		System.out.println("Top Element Value: " + s.peek().toString());
		s.put("ZweiterString");
		s.put(123);
		System.out.println("Top Element Value: " + s.pop());
		System.out.println("Top Element Value: " + s.peek().toString());
		System.out.println("isEmpty: " + s.isEmpty());
		s.pop();
		s.pop();
		System.out.println("isEmpty: " + s.isEmpty());
	}

	private void testQueue() {
		Queue q = new Queue();
		System.out.println("Expect true: " + q.isEmpty());
		q.enqueue("This is the first String");
		System.out.println("Expect false: " + q.isEmpty());
		System.out.println("Expect This is the first String: " + q.front());
		q.enqueue("2");
		q.enqueue("3");
		System.out.println("Expect This is the first String: " + q.front());
		System.out.println("Expect This is the first String: " + q.dequeue());
		System.out.println("Expect 2: " + q.dequeue());
		System.out.println("Expect 3: " + q.front());
		System.out.println("Expect false: " + q.isEmpty());
		System.out.println("Expect 3: " + q.dequeue());
		System.out.println("Expect true: " + q.isEmpty());
	}

	private void testQueueCountable(QueueCountable q) {
		System.out.println("Count Expect 0: " + q.getElementCount());
		System.out.println("Expect true: " + q.isEmpty());
		q.enqueue("This is the first String");
		System.out.println("Count Expect 1: " + q.getElementCount());
		System.out.println("Expect false: " + q.isEmpty());
		System.out.println("Expect This is the first String: " + q.front());
		q.enqueue("2");
		q.enqueue("3");
		System.out.println("Count Expect 3: " + q.getElementCount());
		System.out.println("Expect This is the first String: " + q.front());
		System.out.println("Expect This is the first String: " + q.dequeue());
		System.out.println("Count Expect 2: " + q.getElementCount());
		System.out.println("Expect 2: " + q.dequeue());
		System.out.println("Expect 3: " + q.front());
		System.out.println("Expect false: " + q.isEmpty());
		System.out.println("Expect 3: " + q.dequeue());
		System.out.println("Expect true: " + q.isEmpty());
	}
}