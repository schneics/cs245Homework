import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class UWECPeopleDriver {
	public static void main(String[] args) {
		
		try {
			Scanner fileIn = new Scanner(new File("assignment2Input1.txt"));
			ArrayList<UWECPerson> universityPeople = new ArrayList<>();
			PrintWriter fileOut = new PrintWriter(new File("assignment2output.txt"));
			int entry = getMenuChoice(fileIn);
			while (fileIn.hasNext()) {
				fileIn.nextLine();
				if (entry == 1) {
					addStudent(fileIn, universityPeople);
				} else if (entry == 2) {
					addStaff(fileIn, universityPeople);
				} else if (entry == 3) {
					addFaculty(fileIn, universityPeople);
				} else if (entry == 4) {
					computeTotalPayroll(fileOut, universityPeople);
				} else if (entry == 5) {
					printDirectory(fileOut, universityPeople);
				} else if (entry == 6) {
					fileIn.close();
					fileOut.close();
				}
				fileIn.nextLine();
				entry = getMenuChoice(fileIn);
			}
			fileIn.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}

	public static void addStudent(Scanner fileIn, ArrayList<UWECPerson> universityPeople) {
		int id = fileIn.nextInt();
		String firstName = fileIn.next();
		String lastName = fileIn.next();
		int credits = fileIn.nextInt();
		double gpa = fileIn.nextDouble();
		
		UWECStudent student = new UWECStudent(id, firstName, lastName, gpa);
		student.setNumTotalCredits(credits);
		universityPeople.add(student);
		
	}

	public static void addStaff(Scanner fileIn, ArrayList<UWECPerson> universityPeople) {
		int id = fileIn.nextInt();
		String firstName = fileIn.next();
		String lastName = fileIn.next();
		String title = fileIn.next();
		double hourlyPay = fileIn.nextDouble();
		double hoursPerWeek = fileIn.nextDouble();
		
		
		UWECStaff staff1 = new UWECStaff(id, firstName, lastName, title);
		staff1.setHourlyPay(hourlyPay);
		staff1.setHoursPerWeek(hoursPerWeek);
		universityPeople.add(staff1);

	}
	
	public static void addFaculty(Scanner fileIn, ArrayList<UWECPerson> universityPeople) {
		int id = fileIn.nextInt();
		String firstName = fileIn.next();
		String lastName = fileIn.next();
		int numTotalCredits = fileIn.nextInt();
		double yearlySalary = fileIn.nextDouble();
		
		UWECFaculty faculty = new UWECFaculty(id, firstName, lastName, numTotalCredits);
		faculty.setYearlySalary(yearlySalary);
		universityPeople.add(faculty);
	}
	
	public static void printDirectory(PrintWriter fileOut, ArrayList<UWECPerson> universityPeople) {
		if (universityPeople.size() > 0) {
			for(int i = 0; i < universityPeople.size(); i++) {
				String person = universityPeople.get(i).toString();
				fileOut.println(person);
			}
		}
	}
	
	public static void computeTotalPayroll(PrintWriter fileOut, ArrayList<UWECPerson> universityPeople) {
		double payroll = 0;
		for(int i = 0; i < universityPeople.size(); i ++) {
			if (universityPeople.get(i) instanceof UWECFaculty) {
				UWECFaculty faculty = (UWECFaculty) universityPeople.get(i);
				payroll =+ faculty.computePaycheck();
			} else if (universityPeople.get(i) instanceof UWECStaff) {
				UWECStaff staff = (UWECStaff) universityPeople.get(i);
				payroll =+ staff.computePaycheck();
			}
		}
		fileOut.print(payroll);
	}

	public static int getMenuChoice(Scanner fileIn) {
		int choice = fileIn.nextInt();
		return choice;
	}

}
