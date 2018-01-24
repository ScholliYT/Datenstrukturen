import java.util.*;

public class ListeExtended extends ListBittner implements Iterable<Object> {
	public int size() {
		if (!this.isEmpty()) {
			Knoten temp = this.anfang;
			int anzahl = 0;
			while (temp != null) {
				temp = temp.getZeiger();
				anzahl++;
			}
			return anzahl;
		}
		return 0;
	}

	public boolean contains(Object pObject) {
		Knoten laufi = anfang;
		while (laufi != null) {
			if (laufi.getInhalt().equals(pObject))
				return true;

			laufi = laufi.getZeiger();
		}
		return false;
	}

	public void clear() {
		anfang = null;
		ende = null;
		aktuell = null;
	}

	public void deleteDublicates() {
		Knoten oldCurrent = aktuell;
		toFirst();
		HashSet<Object> hashi = new HashSet<>();
		while (hasAccess()) {
			Object obj = aktuell.getInhalt();
			if (hashi.contains(obj)) {
				if (aktuell == oldCurrent) { // oldCurrent points on a duplicate object that needs to be deleted, yeah!
					oldCurrent = null;
				}
				remove();
			} else {
				hashi.add(obj);
				aktuell = aktuell.getZeiger();
			}
		}
		aktuell = oldCurrent; // Put pointer back to his old position
	}

	public void delete(Object pObject) {
		Knoten old = aktuell;
		this.toFirst();
		while (hasAccess()) {
			if (this.getObject().equals(pObject)) {
				if (aktuell == old) {
					old = null;
				}
				this.remove();
			}
			this.next();
		}
		aktuell = old;
	}

	public Object[] toArray() {
		Object[] array = new Object[size()];
		aktuell = anfang;
		int i = 0;
		while (i < size()) {
			array[i] = aktuell.getInhalt();
			next();
			i++;
		}
		return array;

	}

	public int indexOf(Object pObject) {
		int index = 1;
		while (anfang != null) { // anfang ungleich null
			if (anfang.getInhalt() == pObject) { // Prüfung auf das gleiche Objekt
				return index;
			}
			anfang = anfang.getZeiger(); // N�chster durchlauf
			index++;
		}
		return -1; // Objekt nicht vorhanden R�ckgabe -1
	}

	public void deleteKind(Object kindToDelete) {
		toFirst();
		while (aktuell != null) {
			if (aktuell.getInhalt().getClass().equals(kindToDelete.getClass())) {
				remove();
			} else {
				next();
			}
		}
		aktuell = null;
	}

	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			private Knoten currentNode = ListeExtended.this.anfang;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public Object next() {
				if (hasNext()) {
					Object next = currentNode.getInhalt();
					currentNode = currentNode.getZeiger();
					return next;
				} else {
					throw new NoSuchElementException("hasNext() returned false!");
				}
			}

			@Override
			public void remove() {
				Knoten temp = ListeExtended.this.aktuell;
				Knoten toRemove = findPreviousNode(currentNode);
				if (temp == toRemove) {
					ListeExtended.this.remove();
				} else {
					ListeExtended.this.aktuell = toRemove;
					ListeExtended.this.remove();
					ListeExtended.this.aktuell = temp;
				}
			}
		};
	}

	protected Knoten findPreviousNode(Knoten node) {
		if (node == anfang)
			return null;

		Knoten prevNode = anfang;

		while (prevNode.getZeiger() != node) {
			prevNode = prevNode.getZeiger();
		}
		return prevNode;
	}

}