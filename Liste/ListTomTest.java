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

}
