public class QueueCountable_B extends QueueCountable {

    @Override
    public int getElementCount() {
        int counter = 0;
        Queue q = new Queue();
        while(!isEmpty()) {
            counter++;
            q.enqueue(dequeue());
        }

        while(!q.isEmpty()) {
            enqueue(q.dequeue());
        }

        return counter;
    }
}