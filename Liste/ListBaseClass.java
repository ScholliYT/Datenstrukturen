
public abstract class ListBaseClass {

	public abstract boolean isEmpty();

	public abstract boolean hasAccess();
	
	public abstract void next();
	
	public abstract void toFirst();
	
	public abstract void toLast();
	
	public abstract Object getObject();
	
	public abstract void setObject(Object o);
	
	public abstract void append(Object o);
	
	public abstract void insert(Object o);
	
	public abstract void concat(ListBaseClass l);
	
	public abstract void remove();
}