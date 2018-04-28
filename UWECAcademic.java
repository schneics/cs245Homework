
public abstract class UWECAcademic extends UWECPerson {
	private int numTotalCredits;
	
	public UWECAcademic(int uwecId, String firstName, String lastName) {
		super(uwecId, firstName, lastName);
		setTitle(getTitle());
		setNumTotalCredits(getNumTotalCredits());
	}
	
	public final int getNumTotalCredits() {
		return this.numTotalCredits;
	}
	
	public void setNumTotalCredits(int numTotalCredits) {
		this.numTotalCredits = numTotalCredits;
	}
	
	public abstract String toString(); 
		
	public boolean equals(Object other) {
		if (other instanceof UWECAcademic) {
			UWECAcademic johnDoe = (UWECAcademic) other;
			if (johnDoe.getFirstName().equals(this.getFirstName()) && johnDoe.getLastName().equals(this.getLastName())
					&& johnDoe.getUwecId() == this.getUwecId() && johnDoe.getNumTotalCredits() == this.getNumTotalCredits()) {
				return true;
			}
		}
		return false;
	}
}
