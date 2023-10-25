package program.practise.examples;

import java.io.InputStream;
import java.util.Iterator;
import java.lang.*;

import java.io.*;
import java.util.*;
public class ReverseCharactersInString {

	//Reverse java as well as program 
			//Input java program
			//output avaj margorp
	
	public void ReverseString() {
		String string= "java program";
		String reverseString = "";
		String wordString ="";
		String[] stringArrayStrings = string.split(" ");
		
		
		///Using String CharAt
		for(int i=0;i<stringArrayStrings.length;i++)
		{
			System.out.println(stringArrayStrings[i]);
			for(int j=stringArrayStrings[i].length()-1;j>=0;j--)
			{
				wordString = wordString+stringArrayStrings[i].charAt(j);
			}
			
			reverseString = reverseString + " "+wordString;
			wordString="";
		}
		
		System.out.println("Reverse java as well as program -->"+reverseString);
	}
	
	
	public void reverseStringStringBuffer() {
		
		String string = "java program";
		String revString = "";
		
		StringBuffer buffer  = new StringBuffer();
		
		String[] arrayStrings = string.split(" ");
		
		for(int i=0;i<arrayStrings.length;i++)
		{
			buffer.append(arrayStrings[i]);
			revString = revString +" " +buffer.reverse();
			
			buffer.delete(0, arrayStrings[i].length()-1);
			
		}
		System.out.println("Reversed with String buffer"+revString);
		
		
		
	}
	public static void main(String[] args) {

		ReverseCharactersInString reverseCharactersInString = new ReverseCharactersInString();

		reverseCharactersInString.ReverseString();		
		reverseCharactersInString.reverseStringStringBuffer();
		
	}

}
