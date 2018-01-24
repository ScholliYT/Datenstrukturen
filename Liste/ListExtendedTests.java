import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListExtendedTests extends ListBittnerTest {
	
	@Override
	public void init() {
		l = new ListeExtended();
	}
	
	@Test
	public void sizeTest() {
		assertEquals(0, ((ListeExtended) l).size());
		l.append("A");
		assertEquals(1, ((ListeExtended) l).size());
		l.append("B");
		assertEquals(2, ((ListeExtended) l).size());
		l.toFirst();
		l.remove();
		assertEquals(1, ((ListeExtended) l).size());
	}
	
	@SuppressWarnings("deprecation") //TODO: Fix this
	@Test
	public void toArrayTest() {
		assertEquals(new Object[] {}, ((ListeExtended)l).toArray());
		l.append("A");
		assertEquals(new Object[] {"A"}, ((ListeExtended)l).toArray());
		l.append("B");
		assertEquals(new Object[] {"A", "B"}, ((ListeExtended)l).toArray());
		l.toFirst();
		l.remove();
		assertEquals(new Object[] {"B"}, ((ListeExtended)l).toArray());
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
		((ListeExtended)l).clear();
		assertEquals(false, l.hasAccess());
		assertEquals(true, l.isEmpty());
	}
	
	@Test
	public void cointainsTest() {
		fillList("A", "B", "C");
		assertEquals(true, ((ListeExtended)l).contains("B"));
		assertEquals(false, ((ListeExtended)l).contains("Z"));
	}
	
	@Test
	public void deleteTest() {
		fillList("A", "B", "C");
		l.toFirst();
		((ListeExtended)l).delete("B");
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
		((ListeExtended)l).delete("B");
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
		assertEquals(1, ((ListeExtended)l).indexOf("B"));
		l.toFirst();
		l.next();
		assertEquals(0, ((ListeExtended)l).indexOf("A"));
		assertEquals(-1, ((ListeExtended)l).indexOf("Z"));
	}
	
	@Test
	public void deleteDublicatesTest() {
		l.append("A");
		l.append("B");
		l.append("A"); // should be deleted
		l.append("C");
		l.append("D");
		((ListeExtended)l).deleteDublicates();
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
		
		((ListeExtended)l).deleteDublicates();
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
			
		((ListeExtended)l).deleteDublicates();
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
		
		((ListeExtended)l).deleteDublicates();
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
		((ListeExtended)l).deleteDublicates();
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
	public void deleteKindTest() {
		l.append("A");
		l.append(1);
		l.append("B");
		l.append(2);
		l.append(true);
		((ListeExtended)l).deleteKind("");
		l.toFirst();
		assertEquals(1, l.getObject());
		l.next();
		assertEquals(2, l.getObject());
		l.next();
		assertEquals(true, l.getObject());
		((ListeExtended)l).deleteKind(false);
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
