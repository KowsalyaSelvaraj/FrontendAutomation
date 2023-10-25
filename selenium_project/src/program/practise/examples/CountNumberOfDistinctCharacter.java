package program.practise.examples;


import java.util.HashMap;

public class CountNumberOfDistinctCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "geekforgeeks";
		int value=0;
		HashMap<Character,Integer> countDistinctCharacters = new HashMap<Character,Integer>();

		for(int i=0;i<string.length();i++)
		{
			if(!countDistinctCharacters.containsKey(string.charAt(i)))
			{
				countDistinctCharacters.put(string.charAt(i), 1);
			}
			else {
				value = 1 +  countDistinctCharacters.get(string.charAt(i));
				countDistinctCharacters.put(string.charAt(i),value);
			}
		}
		//Collections.sort(countDistinctCharacters.values());

		System.out.println(countDistinctCharacters);


	}

}
