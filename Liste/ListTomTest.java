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
	
}
