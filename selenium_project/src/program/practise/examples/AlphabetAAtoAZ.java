package program.practise.examples;

public class AlphabetAAtoAZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(char ch='a';ch<='z';ch++)
		{
			for(char last='a';last<='z';last++) {
				System.out.print(ch+""+last+" ");
			}
			System.out.print("\n");
		}
		
		
	}

}
