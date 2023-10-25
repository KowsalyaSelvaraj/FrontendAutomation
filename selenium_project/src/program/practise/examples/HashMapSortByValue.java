package program.practise.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import org.bouncycastle.jce.provider.CertStoreCollectionSpi;

public class HashMapSortByValue {

	public static void main(String[] args) {
				
		HashMap<Integer,String> sportsMap = new HashMap<Integer,String>();
		sportsMap.put(5,"Cricket");
		sportsMap.put(6,"Hockey");
		sportsMap.put(4,"Football");
		sportsMap.put(7,"Chess");
		sportsMap.put(8,"Carrom");
		
		System.out.println("*****Hash Map*****");
		System.out.println(sportsMap);
		
		Set<Integer> keyIntegers = sportsMap.keySet();
		
		System.out.println("\n*****to count the number of key-value (size) mappings in a map*****");
		System.out.println(keyIntegers.size());
		
		System.out.println("\n*****to copy all of the mappings from the specified map to another map*****");
		HashMap<Integer,String> sportsMap2 = new HashMap<Integer,String>(sportsMap);
		System.out.println(sportsMap2);
		
		System.out.println("\n*****to remove all of the mappings from a map*****");
		sportsMap2.clear();
		System.out.println(sportsMap2);
		
		System.out.println("\n*****to get a shallow copy of a HashMap instance*****");
		HashMap<Integer,String> sportsMap3=  (HashMap<Integer, String>) sportsMap.clone();
		System.out.println(sportsMap3);
		
		System.out.println("\n*****to test if a map contains a mapping for the specified key.*****");
		int searchForKey = 7;
		if(sportsMap.containsKey(searchForKey))
			System.out.println(searchForKey+" contains Key");
		else
			System.out.println(searchForKey+" not contains Key");
		
		
		System.out.println("\n*****to test if a map contains a mapping for the specified value*****");
		String searchForValue = "Chess";
		if(sportsMap.containsValue(searchForValue))
			System.out.println(searchForValue+" contains Key");
		else
			System.out.println(searchForValue+" not contains Value");
		
		
		System.out.println("\n*****Values and Keys*****");
		System.out.println(sportsMap.keySet()+"\n"+sportsMap.values());
		
		ArrayList<String> sortMapValueArrayList = new ArrayList<String>(sportsMap.values());	
		Collections.sort(sortMapValueArrayList);
		System.out.println(sortMapValueArrayList);
				
		ArrayList<Integer> sortMapKeyArrayList = new ArrayList<Integer>(sportsMap.keySet());	
		Collections.sort(sortMapKeyArrayList);
		System.out.println(sortMapKeyArrayList);
		
		for(Integer num :sortMapKeyArrayList )
		{
			System.out.println(sportsMap.get(num));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
