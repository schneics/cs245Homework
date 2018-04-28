
public class UWECStudent extends UWECAcademic {
	private double gpa;

	public UWECStudent(int uwecId, String firstName, String lastName, double gpa) {
		super(uwecId, firstName, lastName);
		this.gpa = gpa;
		setNumTotalCredits(getNumTotalCredits());
		setTitle(getTitle());
	}

	public void setNumTotalCredits(int numTotalCredits) {
		super.setNumTotalCredits(numTotalCredits);
		if (getNumTotalCredits() < 24) {
			setTitle("Freshman");
		} else if (getNumTotalCredits() >= 24 && getNumTotalCredits() <= 57) {
			setTitle("Sophomore");
		} else if (getNumTotalCredits() >= 58 && getNumTotalCredits() <= 85) {
			setTitle("Junior");
		} else if (getNumTotalCredits() > 85) {
			setTitle("Senior");
		}
	}

	public final double getGpa() {
		return this.gpa;
	}

	public String toString() {
		return "UWECStudent = uwecId: " + getUwecId() + ", name: " + getFirstName() + " " + getLastName()
				+ ", title: " + getTitle() + ", credits: " + getNumTotalCredits() + ", gpa: " + this.gpa;

	}

	public boolean equals(Object other) {
		if (other instanceof UWECStudent) {
			UWECStudent johnDoe = (UWECStudent) other;
			if (johnDoe.getFirstName().equals(super.getFirstName()) && johnDoe.getLastName().equals(super.getLastName())
					&& johnDoe.getUwecId() == super.getUwecId() && johnDoe.gpa == this.gpa
					&& johnDoe.getNumTotalCredits() == this.getNumTotalCredits()) {
				return true;
			}
		}
		return false;
	}
}
