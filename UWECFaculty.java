
public class UWECFaculty extends UWECAcademic implements UWECEmployee{
	private double yearlySalary;

	public UWECFaculty(int uwecId, String firstName, String lastName, int numTotalCredits) {
		super(uwecId, firstName, lastName);
		this.yearlySalary = getYearlySalary();
		setNumTotalCredits(numTotalCredits);
		if (getNumTotalCredits() < 48) {
			setTitle("Adjunct Professor");
		} else if (getNumTotalCredits() >= 48 && getNumTotalCredits() <= 119) {
			setTitle("Assistant Professor");
		} else if (super.getNumTotalCredits() >= 120 && getNumTotalCredits() <= 239) {
			setTitle("Associate Professor");
		} else if (super.getNumTotalCredits() > 239) {
			setTitle("Professor");
		}
	}

	public void setNumTotalCredits(int numTotalCredits) {
		super.setNumTotalCredits(numTotalCredits);
		if (getNumTotalCredits() < 48) {
			setTitle("Adjunct Professor");
		} else if (getNumTotalCredits() >= 48 && getNumTotalCredits() <= 119) {
			setTitle("Assistant Professor");
		} else if (super.getNumTotalCredits() >= 120 && getNumTotalCredits() <= 239) {
			setTitle("Associate Professor");
		} else if (super.getNumTotalCredits() > 239) {
			setTitle("Professor");
		}
	}

	public final double getYearlySalary() {
		return this.yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public double computePaycheck() {
		return getYearlySalary() / 26;
	}

	public String toString() {
		return "UWECFaculty = uwecId: " + this.getUwecId() + ", name: " + this.getFirstName() + " " + this.getLastName()
				+ ", title: " + this.getTitle() + ", credits: " + this.getNumTotalCredits() + ", yearlySalary: "
				+ this.getYearlySalary();
	}
	
	public boolean equals(Object other) {
		if (other instanceof UWECFaculty) {
			UWECFaculty johnDoe = (UWECFaculty) other;
			if (johnDoe.getFirstName().equals(super.getFirstName()) && johnDoe.getLastName().equals(super.getLastName())
					&& johnDoe.getUwecId() == super.getUwecId() && johnDoe.getYearlySalary() == this.getYearlySalary() 
					&& johnDoe.getNumTotalCredits() == this.getNumTotalCredits()) {
				return true;
			}
		}
		return false;
	}
}
