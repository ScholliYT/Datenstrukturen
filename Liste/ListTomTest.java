import static org.junit.Assert.*;

import org.junit.Test;

public class ListTomTest extends ListTests {

	@Override
	public void init() {
		l = new ListTom();
	}

	@Override
	protected ListBaseClass getNewObjectInstanceOfCurrentList() {
		return new ListTom();
	}
	
	@Test
	public void sizeTest() {
		assertEquals(0, ((ListTom)l).size());
		l.append("A");
		assertEquals(1, ((ListTom)l).size());
		l.append("B");
		assertEquals(2, ((ListTom)l).size());
		l.toFirst();
		l.remove();
		assertEquals(1, ((ListTom)l).size());
	}
	
	@SuppressWarnings("deprecation") //TODO: Fix this
	@Test
	public void toArrayTest() {
		assertEquals(new Object[] {}, ((ListTom)l).toArray());
		l.append("A");
		assertEquals(new Object[] {"A"}, ((ListTom)l).toArray());
		l.append("B");
		assertEquals(new Object[] {"A", "B"}, ((ListTom)l).toArray());
		l.toFirst();
		l.remove();
		assertEquals(new Object[] {"B"}, ((ListTom)l).toArray());
	}
	
	@Test
	public void clearTest() {
		assertEquals(false, l.hasAccess());
		l.append("A");
		l.append("B");
		l.append("C");
		l.append("D");
		l.toFirst();
		assertEquals(true, l.hasAccess());
		((ListTom)l).clear();
		assertEquals(false, l.hasAccess());
		assertEquals(true, l.isEmpty());
	}
	
	@Test
	public void deleteDublicatesTest() {
		l.append("A");
		l.append("B");
		l.append("A"); // should be deleted
		l.append("C");
		l.append("D");
		((ListTom)l).deleteDublicates();
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("B", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals("D", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
		
		
	}
	
	@Test
	public void deleteDublicatesTestLastIsDuplicate() {
		l.append("A");
		l.append("B");
		l.append("C");
		l.append("D");
		l.append("D"); //last is duplicate
		
		((ListTom)l).deleteDublicates();
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("B", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals("D", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	@Test
	public void deleteDublicatesTestDoubleDuplicate() {
		l.append("A");
		l.append("B");
		l.append("A"); // should be deleted
		l.append("A"); //double duplicates
		l.append("C");
		l.append("D");
			
		((ListTom)l).deleteDublicates();
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("B", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals("D", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	@Test
	public void deleteDublicatesTestManyDuplicates() {
		l.append("A");
		l.append("B");
		l.append("C");
		l.append("D");
		l.append("D"); //many duplicates
		l.append("D");
		l.append("D");
		l.append("C");
		l.append("A");
		
		((ListTom)l).deleteDublicates();
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("B", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals("D", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());

	}
	
	@Test
	public void deleteDuplicatesTestCurrentDuplicate() {
		l.append("A");
		l.append("B");
		l.append("A"); // should be deleted
		l.append("C");
		l.append("D");
		l.toFirst();
		l.next();
		l.next();
		((ListTom)l).deleteDublicates();
		assertEquals(false, l.hasAccess());
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("B", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals("D", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	@Test
	public void cointainsTest() {
		fillList("A", "B", "C");
		assertEquals(true, ((ListTom)l).contains("B"));
		assertEquals(false, ((ListTom)l).contains("Z"));
	}
	
	@Test
	public void getFirstTest() {
		fillList("A", "B", "C");
		assertEquals("A", ((ListTom)l).getFirst());
	}
	
	@Test
	public void getLastTest() {
		fillList("A", "B", "C");
		assertEquals("C", ((ListTom)l).getLast());
	}
	
	@Test
	public void deleteTest() {
		fillList("A", "B", "C");
		l.toFirst();
		((ListTom)l).delete("B");
		assertEquals("A", l.getObject());
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	@Test
	public void deleteTestCurrent() {
		fillList("A", "B", "C");
		l.toFirst();
		l.next();
		((ListTom)l).delete("B");
		assertEquals(false, l.hasAccess());
		l.toFirst();
		assertEquals("A", l.getObject());
		l.next();
		assertEquals("C", l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	@Test
	public void indexOfTest() {
		fillList("A", "B", "C");
		assertEquals(1, ((ListTom)l).indexOf("B"));
		l.toFirst();
		l.next();
		assertEquals(0, ((ListTom)l).indexOf("A"));
		assertEquals(-1, ((ListTom)l).indexOf("Z"));
	}
	
	@Test
	public void deleteKindTest() {
		l.append("A");
		l.append(1);
		l.append("B");
		l.append(2);
		l.append(true);
		((ListTom)l).deleteKind("");
		l.toFirst();
		assertEquals(1, l.getObject());
		l.next();
		assertEquals(2, l.getObject());
		l.next();
		assertEquals(true, l.getObject());
		((ListTom)l).deleteKind(false);
		l.toFirst();
		assertEquals(1, l.getObject());
		l.next();
		assertEquals(2, l.getObject());
		l.next();
		assertEquals(false, l.hasAccess());
	}
	
	private void fillList(String...strings) {
		for(String s : strings) {
			l.append(s);
		}
	}
}
