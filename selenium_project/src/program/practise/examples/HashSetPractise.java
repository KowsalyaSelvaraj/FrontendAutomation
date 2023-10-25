package program.practise.examples;

import java.util.HashSet;

public class HashSetPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> multiplesOfTen = new HashSet<Integer>();
		multiplesOfTen.add(10);
		multiplesOfTen.add(70);
		multiplesOfTen.add(20);
		multiplesOfTen.add(90);
		multiplesOfTen.add(30);
		
		HashSet<Integer> multiplesOfFive = new HashSet<Integer>(multiplesOfTen);
		multiplesOfFive.add(25);
		multiplesOfFive.add(35);
		multiplesOfFive.add(45);
		multiplesOfTen.retainAll(multiplesOfFive);
		
		System.out.println(multiplesOfTen+"\n"+multiplesOfFive);
	}

}
