package program.practise.examples;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string ="aabaa";
		int flag=0;
		for(int i=0,j=(string.length()-1);i<(string.length()/2) && j>=(string.length()/2);i++,j--)
		{
			if(!(string.charAt(i)==string.charAt(j)))
			{
				System.out.println("not palindrome");
				flag=1;
				break;
			}
			else {
				continue;
			}
		}
		if (flag==0)
			System.out.println("Palindrome");
	}

}
