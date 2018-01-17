
public class ListTomTest extends ListTests {

	@Override
	public void init() {
		l = new ListTom();
	}

	@Override
	protected ListBaseClass getNewObjectInstanceOfCurrentList() {
		return new ListTom();
	}

}
