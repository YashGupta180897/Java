
public class StringReverse {

	static String str = "I am Learning Java";
	public StringReverse()
	{
		System.out.println("This is the constructor");
	}
	public String reverseString()
	{
		String s1 = "";
		for(int i=str.length()-1;i>=0;)
		{
			s1+=str.charAt(i)+"";
			i--;
		}
		return s1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse s=new StringReverse();
		System.out.println("Reversed String is : "+s.reverseString());

	}

}
