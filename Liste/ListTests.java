                                    


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class ListTests {

	protected ListBaseClass l;
	
	@Before
	public abstract void init();
	
    @Test
    public void isEmptyTest() {
        assertEquals(true, l.isEmpty());
        l.append("A");
        assertEquals(false, l.isEmpty());   
    }
    
    @Test
    public void hasAccessTest() {
        assertEquals(false, l.hasAccess());
        
        l.toFirst();
        assertEquals(false, l.hasAccess());
        
        l.append("A");
        l.toFirst();
        assertEquals(true, l.hasAccess());
        
        l.next();
        assertEquals(false, l.hasAccess());
        
        l.toFirst();
        l.remove();
        assertEquals(false, l.hasAccess());
        
    }   
    
    @Test
    public void nextTest() {
        l.next();
        assertEquals(false, l.hasAccess());
        
        l.append("A");
        l.append("B");
        l.toFirst();
        l.next();
        assertEquals("B", l.getObject());
    }
    
    @Test
    public void toFirstTest() {
        l.append("A");
        l.append("B");
        l.toFirst();
        assertEquals("A", l.getObject());
    }
    
    @Test
    public void toLastTest() {
        l.append("A");
        l.append("B");
        l.toLast();
        assertEquals("B", l.getObject());
    }

    @Test
    public void getObjectTest() {
        assertEquals(null, l.getObject());
        l.append("A");
        l.toFirst();
        assertEquals("A", l.getObject());
    }
    
    @Test
    public void setObjectTest() {
        l.append("A");
        l.toFirst();
        l.setObject("AA");
        assertEquals("AA", l.getObject());
    }
    
    @Test
    public void appendTest() {
        l.append(null);
        assertEquals(true, l.isEmpty());
        assertEquals(false, l.hasAccess());
        l.append("A");
        l.toLast();
        assertEquals("A", l.getObject());
        l.append("B");
        l.toLast();
        assertEquals("B", l.getObject());
        
        l.toFirst();
        l.append("C");
        l.toLast();
        assertEquals("C", l.getObject());
        
        l.append(null);
        l.toFirst();
        assertEquals("A", l.getObject());
    }
    
    @Test
    public void insertTest() {
        l.append("A");
        l.append("B");
        l.append("C");
        l.toLast();
        l.insert("zwischen B und C");
        assertEquals("C", l.getObject());
        l.toFirst();
        assertEquals("A", l.getObject());
        l.next();
        assertEquals("B", l.getObject());
        l.next();
        assertEquals("zwischen B und C", l.getObject());
        l.next();
        assertEquals("C", l.getObject());
    }
    
    @Test
    public void insertTestBySara() {
    	l.append("A");
    	l.toFirst();
    	l.insert("B");
    	l.toLast();
    	assertEquals("A", l.getObject());
    }
    
    @Test
    public void concatTest() {
    	l.append("A");
    	l.append("B");
    	ListBaseClass ll = getNewObjectInstanceOfCurrentList();
    	ll.append("C");
    	l.concat(ll);
    	l.toFirst();
    	assertEquals("A", l.getObject());
    	l.next();
    	assertEquals("B", l.getObject());
    	l.next();
    	assertEquals("C", l.getObject());
    	
    	assertEquals(true, ll.isEmpty());
    }
    
    protected abstract ListBaseClass getNewObjectInstanceOfCurrentList();
    
    @Test
    public void removeTest() {
    	l.append("A");
    	l.append("B");
    	l.append("C");
    	l.append("D");
    	l.toFirst(); // {[A], B, C, D}
    	l.remove();  // {[B], C, D}
    	assertEquals("B", l.getObject()); // {[B], C, D}
    	l.next(); // {B, [C], D}
    	l.remove(); // {B, [D]}
    	assertEquals("D", l.getObject()); // {B, [D]}
    	
    	
    	l.toFirst(); // {[B], D}
    	assertEquals("B", l.getObject());
    	l.next(); // {B, [D]}
    	assertEquals("D", l.getObject());
    	l.next();
    	assertEquals(null, l.getObject());
    	assertEquals(false, l.hasAccess());	
    	
    	
    	l.toLast(); // {B, [D]}
    	assertEquals("D", l.getObject());
    	l.remove(); // {B}
    	assertEquals(false, l.hasAccess());	
    }
    
    @Test
    public void remvoeTestOneElement() {
    	l.append("A");
    	l.toFirst();
    	assertEquals("A", l.getObject());
    	l.remove();
    	assertEquals(false, l.hasAccess());
    	
    }
    
}
