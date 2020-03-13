package People;

public interface PersonNode {

	//Getters
	public abstract String getName();
	public abstract String getDescriptor();
	public abstract String toString();

	//Setters
	public abstract boolean setName(String name);
	public abstract boolean setDescriptor(String descriptor);
	
}
