package program.practise.examples;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.input.SwappedDataInputStream;
import org.apache.poi.util.TempFile;

public class CollectionsProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> colorsList = new ArrayList<String>();
		colorsList.add("RED");
		colorsList.add("PINK");
		colorsList.add("White");
		colorsList.add("Yellow");
		colorsList.add("Green");

		ListIterator<String> listIterator = colorsList.listIterator();

		System.out.println("*****************Array List Iterator Elements***************");
		while (listIterator.hasNext())
			System.out.println(listIterator.next());


		String[] colorsArrayStrings = new String[colorsList.size()];

		System.out.println("\n*****************Array List converted to String array***************");
		colorsList.toArray(colorsArrayStrings);
		for(String colorString : colorsArrayStrings)
			System.out.println(colorString);


		HashSet<Integer> multiplesOfTen = new HashSet<Integer>();
		multiplesOfTen.add(10);
		multiplesOfTen.add(70);
		multiplesOfTen.add(20);
		multiplesOfTen.add(90);
		multiplesOfTen.add(30);

		Iterator<Integer> multiplesOfTenIterator = multiplesOfTen.iterator();
		System.out.println("\n*****************HashSet multiplesOfTenIterator - Iterator***************");
		while(multiplesOfTenIterator.hasNext())
			System.out.println(multiplesOfTenIterator.next());

		System.out.println("\n*****************HashSet multiplesOfTenIterator - with foe loop without Iterator***************");
		for(Integer multiplesOfTenInteger : multiplesOfTen)
			System.out.println(multiplesOfTenInteger);


		//find Elements in Set and in List 
		System.out.println("\n*****************Find Elements***************");
		String findColor = "RED";
		if(colorsList.contains(findColor))
			System.out.println("\""+findColor+"\" Found in the ColorsList\n");
		else
			System.out.println(findColor+" Not found in the ColorsList");

		int findMultipleOfTen = 1000;
		if(multiplesOfTen.contains(findMultipleOfTen))
			System.out.println(findMultipleOfTen+" Found in the SET");
		else
			System.out.println(findMultipleOfTen+" Not found in the SET");


		//Convert array to arrayList
		System.out.println("\n*****************Convert array to arrayList***************");
		List<String> newColorsList = Arrays.asList(colorsArrayStrings);

		System.out.println(newColorsList);      

		//HashMap sort using Key
				System.out.println("\n*****************Original HashMap***************");
		HashMap<Integer,String> sportsMap = new HashMap<Integer,String>();
		sportsMap.put(5,"Cricket");
		sportsMap.put(6,"Hockey");
		sportsMap.put(4,"Football");
		sportsMap.put(7,"Chess");
		sportsMap.put(8,"Carrom");
		
		System.out.println(sportsMap);
		
		System.out.println("\n*****************HashMap sort Tree Map***************");
		TreeMap<Integer,String> sportsTreeMap = new TreeMap<Integer,String>();
		sportsTreeMap.putAll(sportsMap);
		System.out.println(sportsTreeMap);
		
		System.out.println("\n*****************HashMap sort using Key***************");
		Set<Integer> myKeyIntegers =sportsMap.keySet();
		
		Integer[] keyarray = new Integer[myKeyIntegers.size()];
		
		myKeyIntegers.toArray(keyarray);
		int swap;
		for(Integer number:keyarray )
			System.out.println(number);
		//sort the keyarray
		for(int i=0;i<keyarray.length;i++)
		{
			for(int j=1;j<keyarray.length;j++)
			{
				if(keyarray[i]>keyarray[j])
				{
					swap=keyarray[i];
					keyarray[i]=keyarray[j];
					keyarray[j]=swap;
				
				}
			}
		}
		
		HashMap<Integer,String> newHashMap = new HashMap<Integer,String>();
		
		for(Integer number:keyarray)
		{
			newHashMap.put(number, sportsMap.get(number));
		}
		
		System.out.println(newHashMap);

	}

}
