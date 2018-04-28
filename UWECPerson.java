public abstract class UWECPerson {
	private int uwecId;
	private String firstName;
	private String lastName;
	private String title;

	public UWECPerson(int uwecId, String firstName, String lastName) {
		this.uwecId = uwecId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public final int getUwecId() {
		return this.uwecId;
	}

	public void setUwecId(int uwecId) {
		this.uwecId = uwecId;
	}

	public final String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract String toString();

	public boolean equals(Object other) {
		if (other instanceof UWECPerson) {
			UWECPerson johnDoe = (UWECPerson) other;
			if (johnDoe.firstName.equals(this.firstName) && johnDoe.lastName.equals(this.lastName)
					&& johnDoe.uwecId == this.uwecId) {
				return true;
			}
		}
		return false;
	}
}
