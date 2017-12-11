public class QueueCountable_C extends QueueCountable {

    private int count = 0;

    @Override
    public void enqueue(Object o) {
        count++;
        Node toEnqueue = new Node(o, null);
        if(isEmpty()) {  // 0 Elements in Queue
            head = toEnqueue;
        }
        else {  // Not 0 Elements in Queue
            tail.setNextNode(toEnqueue);            
        }
        tail = toEnqueue;
    }
    
    @Override
    public Object dequeue() {
        count--;
        Object o = head.getObject();
        head = head.getNextNode();
        return o;
    }

    @Override
    public int getElementCount() {
        return count;
    }
}