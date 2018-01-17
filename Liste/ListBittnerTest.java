public class ListBittnerTest extends ListTests {

	@Override
	public void init() {
		l = new ListBittner();
	}

	@Override
	protected ListBaseClass getNewObjectInstanceOfCurrentList() {
		return new ListBittner();
	}

}