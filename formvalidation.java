package java_training;
import java.util.Scanner;
import java.util.regex.Pattern;
public class formvalidation {
	public static boolean validateName(String name) {
		String nameregex="^[a-zA-Z0-9]+$";
		return Pattern.matches(nameregex, name);
	}
	public static boolean validateEmail(String email) {
		String emailRegex="^[a-zA-Z0-9!#$%'*+/=?^_{}()|-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return Pattern.matches(emailRegex, email);
	}
	public static boolean validateDob(String dob) {
		String dobRegex="^\\d{2}/\\d{2}/\\d{4}$";
		if(!Pattern.matches(dobRegex, dob)) {
			return false;
		}
		String[] parts=dob.split("/");
		int day=Integer.parseInt(parts[0]);
		int month=Integer.parseInt(parts[1]);
		int year=Integer.parseInt(parts[2]);
		if(month<1 || month>12) return false;
		if(day<1 || day>31) return false;
		if(month==2) {
			boolean isLeapYear=(year%4==0 && year%100!=0)||(year%400==0);
			if(isLeapYear) {
				return day<=29;
			} else {
				return day<=28;
			}
		} else if(month==4 || month==6|| month==9|| month==11) {
			return day<=30;
		}
		return true;		
	}
	
	public static String getvalidateName(Scanner scanner) {
		String name;
		while(true) {
			System.out.println("Enter the Name: ");
			name=scanner.nextLine();
			if(validateName(name)) {
				break;
			}
			System.out.println("Invalid name");
		}
		return name;
	}
	
	public static String getvalidateEmail(Scanner scanner) {
		String email;
		while(true) {
			System.out.println("Enter the Email: ");
			email=scanner.nextLine();
			if(validateEmail(email)) {
				break;
			}
			System.out.println("Invalid Email,Enter the correct Email");
		}
		return email;
	}
	
	public static String getvalidateDob(Scanner scanner) {
		String dob;
		while(true) {
			System.out.println("Enter the Date of Birth :");
			dob=scanner.nextLine();
			if(validateDob(dob)) {
				break;
			}
			System.out.println("Invalid Dob");
		}
		return dob;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String name=getvalidateName(scanner);
		String email=getvalidateEmail(scanner);
		String dob=getvalidateDob(scanner);
		System.out.println("Form Submitted Succesfully!");
		
	}

}
