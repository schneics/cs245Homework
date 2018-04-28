public class UWECStaff extends UWECPerson implements UWECEmployee {
	private double hourlyPay;
	private double hoursPerWeek;

	public UWECStaff(int uwecId, String firstName, String lastName, String title) {
		super(uwecId, firstName, lastName);
		setTitle(title);
	}

	public final double getHourlyPay() {
		return this.hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public final double getHoursPerWeek() {
		return this.hoursPerWeek;
	}

	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	public double computePaycheck() {
		return 2 * getHoursPerWeek() * getHourlyPay();
	}

	public String toString() {
		return "UWECStaff = uwecId: " + this.getUwecId() + ", name: " + this.getFirstName() + " " + this.getLastName()
				+ ", title: " + this.getTitle() + ", hourly pay: " + this.getHourlyPay() + ", hours/week: "
				+ this.getHoursPerWeek();
	}

	public boolean equals(Object other) {
		if (other instanceof UWECStaff) {
			UWECStaff johnDoe = (UWECStaff) other;
			if (johnDoe.getFirstName().equals(this.getFirstName()) && johnDoe.getLastName().equals(this.getLastName())
				&& johnDoe.getUwecId() == this.getUwecId() && johnDoe.getTitle().equals(this.getTitle())
				&& johnDoe.hourlyPay == this.hourlyPay && johnDoe.getHoursPerWeek() == this.hoursPerWeek) {
				return true;
			}
		}
		return false;
	}

}

