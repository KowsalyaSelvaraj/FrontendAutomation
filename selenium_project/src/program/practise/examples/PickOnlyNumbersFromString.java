package program.practise.examples;

import java.util.Scanner;

import org.apache.poi.ss.format.CellNumberStringMod;

public class PickOnlyNumbersFromString {

	public void toGetNumber(String string)
	{
		String numberString ="";

		for(int i=0;i<string.length();i++)
		{
			if(Character.isDigit((string.charAt(i)))){

				numberString = numberString + string.charAt(i);
			}

		}
// to convert integer to string 
		int  i=10;
		String convertString = Integer.toString(i);
		System.out.println(Integer.parseInt(numberString));

	}

	public void toGetString(String string)
	{
		String numberString ="";

		for(int i=0;i<string.length();i++)
		{
			if(!Character.isDigit((string.charAt(i)))){
				
				numberString = numberString + string.charAt(i);
			}

		}
		System.out.println(numberString);
		//System.out.println(Integer.parseInt(numberString));
	}



	static public  void main(String[] args) {
		// TODO Auto-generated method stub
		PickOnlyNumbersFromString pickOnlyNumbersFromString = new PickOnlyNumbersFromString();
		Scanner  scanner = new Scanner(System.in); 
		System.out.println("Enter the string with number");
		//string = Test123
		String string = scanner.nextLine();

		pickOnlyNumbersFromString.toGetNumber(string.trim()); /// trim removes trailing and leading spaces
		pickOnlyNumbersFromString.toGetString(string.trim());

		System.out.println(string.trim());


	}

}
