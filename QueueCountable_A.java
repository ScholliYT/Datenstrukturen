public class QueueCountable_A extends QueueCountable {
    @Override
    public int getElementCount() {
        int counter = 0;
        Node _head = head;
        while(1==1) {
            if(_head == null) {
                return counter;
            }
            counter++;
            _head = _head.getNextNode();
        }
    }
}