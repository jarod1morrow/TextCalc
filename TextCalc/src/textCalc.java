import java.util.Scanner;
public class textCalc {
	public static void main(String[] args){
		System.out.println("Welcome to TextCalc\nYou may enter expressions in English, or \"quit\" to quit.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an expression.");
		String x = scan.nextLine();
		while(!x.equals("quit")){
			String Main = x.toLowerCase();
			String Part1 = "";
			String Part2 = "";
			String Operator = "";
			boolean neg = false;
			int count = 0;
			if (Main.contains("plus")){
				Part1 = Main.substring(0,Main.indexOf("plus"));
				Part2 = Main.substring(Main.indexOf("plus"));
				Operator = "+";
			}
			else if (Main.contains("divided by")){
				Part1 = Main.substring(0,Main.indexOf("divided by"));
				Part2 = Main.substring(Main.indexOf("divided by"));
				Operator = "/";
			}
			else if (Main.contains("divide")){
				Part1 = Main.substring(0,Main.indexOf("divide"));
				Part2 = Main.substring(Main.indexOf("divide"));
				Operator = "/";
			}
			else if (Main.contains("multiplied by")){
				Part1 = Main.substring(0,Main.indexOf("multiplied by"));
				Part2 = Main.substring(Main.indexOf("multiplied by"));
				Operator = "*";
			}
			else if (Main.contains("times")){
				Part1 = Main.substring(0,Main.indexOf("times"));
				Part2 = Main.substring(Main.indexOf("times"));
				Operator = "*";
			}
			else if (Main.contains("minus")){
				Part1 = Main.substring(0,Main.indexOf("minus"));
				Part2 = Main.substring(Main.indexOf("minus"));
				Operator = "-";
			}
			if (Part1.contains("negative")){
				count++;
				neg = true;
				Part1 = Part1.replace("negative ","");
			}
			if (Part2.contains("negative")){
				count++;
				if (neg != true){
					neg = true;
				}
				else{
					neg = false;
				}
				Part2 = Part2.replace("negative ","");
			}
			String [] Part1b = Part1.split(" ");
			double [] Part1a = new double[(Part1b.length)];
			for (int i = 0; i<Part1b.length; i++){
				Part1a [i] = toNum (Part1b[i]);
			}
			String [] Part2b = Part2.split(" ");
			double [] Part2a = new double[(Part2b.length)];
			for (int i = 0; i<Part2b.length; i++){
				Part2a [i] = toNum (Part2b[i]);
			}
			double end1 = 0.0;
			double temp;
			for (int i = 0; i < Part1a.length; i++){
				temp = Part1a[i];
				if (temp == 1000.0 || temp == 100.0){
					end1 *= temp;
				}
				else{
				end1 += temp;
				}
			}
			double end2 = 0.0;
			for (int i = 0; i < Part2a.length; i++){
				temp = Part2a[i];
				if (temp == 1000.0 || temp == 100.0){
					end2 *= temp;
				}
				else{
				end2 += temp;
				}
			}
			double total = 0.0;
			if(count == 2){
				switch(Operator){
					case "+":
						total = end1 - end2;
						break;
					case "-":
						total = end1 + end2;
						break;
					case "/":
						total = end1 / end2;
						break;
					case "*":
						total = end1 * end2;
						break;
				}
			}
			else {
				switch(Operator){
					case "+":
						total = end1 + end2;
						break;
					case "-":
						total = end1 - end2;
						break;
					case "/":
						total = end1 / end2;
						break;
					case "*":
						total = end1 * end2;
						break;
				}
			}
			if (neg == true){
				total = total * -1;
			}
			
			String Name = toNam(total);
			if (Name.contains("negative") && total > 0){
				total = total * -1;
			}
			System.out.println("That's " + Name + "\n(" + total + ")");
			System.out.println("Please enter another expression.");
			x = scan.nextLine();
		}
		System.out.println("Okay, bye!!");
		scan.close();
	}

	private static String toNam(double total) {
		String name = "";
		boolean negative = false;
		if (total < 0){
			negative = true;
			total = total * -1;
		}
		if (total == 1000000.0){
			name = "one million";
		}
		else{
			int temp = 0;
			int temp2 = (int) total;
			temp = temp2 / 1000;
			int temp3 = temp2 % 1000;
			String thousands = convert(temp);
			String hundreds = convert(temp3);
			if (thousands.equals("")){
				name = hundreds;
			}
			else{
				name = (thousands + "thousand " + hundreds);
			}
		}
		if (negative == true){
			name = ("negative " + name);
		}
		else {
		}
		return name;
		
	}

	private static String convert(int temp) {
		int hundo = temp / 100;
		int temp2 = temp % 100;
		int tens = temp2 / 10;
		int ones = temp2 % 10;
		String hundo2 = "";
		String tens2 = "";
		String ones2 = "";
		if (hundo != 0){
			hundo2 = (toWord(hundo) + "hundred ");
		}
		else{
			hundo2 = "";
		}
		if (tens != 0){
			if (tens != 1){
				tens2 = toWord(tens * 10);
			}
			else {
				ones = ones + 10;
			}
		}
		else{
			tens2 = "";
		}
		if (ones != 0){
			ones2 = toWord(ones);
		}
		String s = "";
		if (tens2.equals("")){
			s = (hundo2 + "and " + ones2);
		}
		if (tens2.equals("") && hundo2.equals("")){
			s = ones2;
		}
		else{
			s = (hundo2 + tens2 + ones2);
		}
		if (tens2.equals("") && hundo2.equals("") && ones2.equals("")){
			s = "";
		}
		return s;
	}

	private static String toWord(int hundo) {
		String Words = "";
		switch(hundo){
			case (1):
				Words = "one ";
				break;
			case (2):
				Words = "two ";
				break;
			case (3):
				Words = "three ";
				break;
			case (4):
				Words = "four ";
				break;
			case (5):
				Words = "five ";
				break;
			case (6):
				Words = "six ";
				break;
			case (7):
				Words = "seven ";
				break;
			case (8):
				Words = "eight ";
				break;
			case (9):
				Words = "nine ";
				break;
			case (10):
				Words = "ten ";
				break;
			case (11):
				Words = "eleven ";
				break;
			case (12):
				Words = "twelve ";
				break;
			case (13):
				Words = "thirteen ";
				break;
			case (14):
				Words = "fourteen ";
				break;
			case (15):
				Words = "fifteen ";
				break;
			case (16):
				Words = "sixteen ";
				break;
			case (17):
				Words = "seventeen ";
				break;
			case (18):
				Words = "eighteen ";
				break;
			case (19):
				Words = "nineteen ";
				break;
			case (20):
				Words = "twenty ";
				break;
			case (30):
				Words = "thirty ";
				break;
			case (40):
				Words = "forty ";
				break;
			case (50):
				Words = "fifty ";
				break;
			case (60):
				Words = "sixty ";
				break;
			case (70):
				Words = "seventy ";
				break;
			case (80):
				Words = "eighty ";
				break; 
			case (90):
				Words = "ninety ";
				break;
		}
		return Words;
	}

	public static double toNum(String string) {
		switch(string){
			case "one":
				return 1.0;
			case "two":
				return 2.0;
			case "three":
				return 3.0;
			case "four":
				return 4.0;
			case "five":
				return 5.0;
			case "six":
				return 6.0;
			case "seven":
				return 7.0;
			case "eight":
				return 8.0;
			case "nine":
				return 9.0;
			case "ten":
				return 10.0;
			case "eleven":
				return 11.0;
			case "twelve":
				return 12.0;
			case "thirteen":
				return 13.0;
			case "fourteen":
				return 14.0;
			case "fifteen":
				return 15.0;
			case "sixteen":
				return 16.0;
			case "seventeen":
				return 17.0;
			case "eighteen":
				return 18.0;
			case "nineteen":
				return 19.0;
			case "twenty":
				return 20.0;
			case "thirty":
				return 30.0;
			case "forty":
				return 40.0;
			case "fifty":
				return 50.0;
			case "sixty":
				return 60.0;
			case "seventy":
				return 70.0;
			case "eighty":
				return 80.0;
			case "ninety":
				return 90.0;
			case "hundred":
				return 100.0;
			case "thousand":
				return 1000.0;
			default:
				return 0.0;
		}
	}
}
