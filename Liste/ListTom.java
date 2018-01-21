import java.util.HashSet;

public class ListTom extends ListBaseClass {
	Node start;
	Node current;
	Node end;
	
	@Override
	public boolean isEmpty() {
		return start == null;
	}
	
	@Override
	public boolean hasAccess() {
		return current != null;
	}

	@Override
	public void next() {
		if(hasAccess()) {
			current = current.getNextNode();
		}
	}

	@Override
	public void toFirst() {
		current = start;
	}

	@Override
	public void toLast() {
		current = end;
	}

	@Override
	public Object getObject() {
		if(hasAccess()) {
			return current.getObject();
		}
		return null;
	}

	@Override
	public void setObject(Object _pObject) {
		if(hasAccess() && _pObject != null) {
			current.setObject(_pObject);
		}
	}

	@Override
	public void append(Object _pObject) {
		if(_pObject != null) {
			Node newNode = new Node(_pObject, null);
			if(isEmpty()) {
				start = newNode;
			} else {
				end.setNextNode(newNode);
			}
			end = newNode;
		}
	}

	@Override
	public void insert(Object _pObject) {
		if(_pObject == null) return;
		if(hasAccess()) {
			Node oldCurrent = new Node(current.getObject(), current.getNextNode());
			current.setObject(_pObject);
			current.setNextNode(oldCurrent);
			current = oldCurrent; // dont change current 
			if(current.getNextNode() == null) {
	        	 end = oldCurrent;	 
	         }
		} else if (isEmpty()) {
			append(_pObject);
		}
	}

	@Override
	public void concat(ListBaseClass _pList) {
		concat((ListTom)_pList);
	}
	
	private void concat(ListTom _pList) {
		if(_pList != null && !_pList.isEmpty()) {
			end.setNextNode(_pList.start);
			end = _pList.end;
			//_pList = new List(); // TODO:
			_pList.start = null;
			_pList.end = null;
			_pList.current = null;
		}
	}

	@Override
	public void remove() {
		if(hasAccess()) {
			if(current == end && current == start) {
				current = null;
				start = null;
				end = null;
			} else if(current != end) {
				current.setObject(current.getNextNode().getObject());
				if(current.getNextNode() == end) { // In case we delete the pre last element.
					end = current;
				} 
				current.setNextNode(current.getNextNode().getNextNode());
				
			} else {
				toFirst();
				while(current.getNextNode() != end) {
					next();
				}
				current.setNextNode(null);
				end = current;
				current = null;
			}
		}
	}
	
	public int size() {
		int size = 0;
		Node c = start;
		while(c != null) {
			size++;
			c = c.getNextNode();
		}
		return size;
	}
	
	public Object[] toArray() {
		Object[] o = new Object[size()];
		Node c = start;
		int i = 0;
		while(c != null) {
			o[i] = c.getObject();
			i++;
			c = c.getNextNode();
		}
		return o;
	}
	
	public void clear() {
		start = null;
		end = null;
		current = null;
	}
	
	/**
	 * deletes all duplicate objects
	 */
	public void deleteDublicates() {
		Node oldCurrent = current;
		toFirst();
		HashSet<Object> hashi = new HashSet<>();
		while(hasAccess()) {
			Object obj = current.getObject();
			if(hashi.contains(obj)) {
				if(current == oldCurrent) { // oldCurrent points on a duplicate object thats needs to deleted
					oldCurrent = null;
				}
				remove();
			} else {
				hashi.add(obj);
				System.out.println("Add to hashset: " + obj.toString());
				current = current.getNextNode();
			}
		}
		current = oldCurrent; //Put pointer back to his old position
	}
	
	public boolean contains(Object obj) {
		Node c = start;
		while(c.getNextNode() != null) {
			if(c.getObject().equals(obj)) {
				return true;
			}
			c = c.getNextNode();
		}
		return false;
	}
	public Object getFirst() {
		return start.getObject();
	}
	public Object getLast() {
		return end.getObject();
	}
}

