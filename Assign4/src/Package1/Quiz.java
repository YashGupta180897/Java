package Package1;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.*;


public class Quiz {

	private int correct=0;
	public static int incorrect=0;
	
	
	private void taketest(Questions[] questions)
	{
		Random r=new Random();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int i=0;
		int index=0;
		int flag=0;
		
		Set<Integer> random_num = new LinkedHashSet<Integer>();
		while(random_num.size()!=10)
		{
			random_num.add(r.nextInt(questions.length));
		}
		Iterator<Integer> itr =  random_num.iterator();
		int x=0;
		
		while(itr.hasNext())
		{
			if(flag==0)
			{
				index = itr.next();
				
			}
			System.out.println("Question "+(i+1)+" : "+questions[index].ques);
			String ans=sc.nextLine();
			if(!(ans.equals("a")) && !(ans.equals("b")) && !(ans.equals("c")) )
			{
				System.out.println("Enter Valid input!!");
				System.out.println();
				flag=1;
				continue;
			}
			flag=0;
			if(ans.equals(questions[index].answer))
			{
				correct++;
			}
			else
				incorrect++;
			
			if(incorrect==4)
			{
				System.out.println("You have 4 incorrect answers.");
				System.out.println("You have Failed.");
				return;
			}
			System.out.println();
			i++;
		}
		System.out.println("Total score = "+correct+" out of "+10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] q=new String[25];
		q[0] = "Who has Most runs in ODI cricket?\n(a)Sachin Tendulkar\n(b)Brian lara\n(c)Virat kohli";
		q[1] = "Who has Most wickets in Test Cricket?\n(a)Shane Warne\n(b)Muthiah Muralitharan\n(c)Anil Kumble";
		q[2] = "Who has scored most runs in one ODI match?\n(a)Chris Gayle\n(b)Rohit Sharma\n(c)Martin Guptill";
		q[3] = "For how many days is a Test match scheduled?\n(a)Four days\n(b)100 overs\n(c)5 days";
		q[4] = "How many Union Territories (UT) are there in India?\n(a)7\n(b)9\n(c)6";
		q[5] = "Which is faster in the air?\n(a)Speed of sound\n(b)Speed of light\n(c)Speed of Cheetah";
		q[6] = "Who invented the telescope?\n(a)Isaac newton\n(b)Gallelli Galileo\n(c)James Watt";
		q[7] = "Largest lake in the world is?\n(a)Caspian Sea\n(b)Lake Victoria\n(c)Lake Baikal";
		q[8] = "Find the H.C.F. of 80, 120 and 150?\n(a)10\n(b)20\n(c)15";
		q[9] = "How many players are there in a cricket team?\n(a)11\n(b)10\n(c)9";
		q[10] = "How many islands are there in Lakshadweep?\n(a)17\n(b)27\n(c)36";
		q[11] = "I.S.R.O. stands for?\n(a)Indian Scientific Research Organisation\n(b)International Satellite Research Organisation\n(c)Indian Space Research Organisation";
		q[12] = "What comes in place of the question mark(s) in the given sequence- 9, 18, ?, 36, 45\r\n(a)20\n(b)27\n(c)30";
		q[13] = "Dalhousie hill station is in which state?\n(a)West Bengal\n(b)Himachal Pradesh\n(c)Jammu and Kashmir";
		q[14] = "Female Anopheles mosquito causes:\n(a)Malaria\n(b)Dengue\n(c)Yellow fever";
		q[15] = "First woman President of India is?\n(a)Pratibha Patil\n(b)Indira Ghandhi\n(c)Sarojini Naidu";
		q[16] = "Longest River in the world is?\n(a)Nile\n(b)Ganga\n(c)Amazon";
		q[17] = "First Indian to win Gold at Olympics is?\n(a)Leander Peas\n(b)Sania Mirza\n(c)Abhinav Bindra";
		q[18] = "Capital of United States of America (USA) is:\n(a)Washington DC\n(b)New York\n(c)Las Vegas";
		q[19] = "2022 FIFA world cup will be held in which country\n(a)France\n(b)Qatar\n(c)Italy";
		q[20] = "0 degree is equivalent to?\n(a)273\n(b)263\n(c)283";
		q[21] = "2016 Olympic Games was held in which country?\n(a)USA\n(b)Australia\n(c)Brasil";
		q[22] = "Who has won the most Wimbledon titles\n(a)Roger Federer\n(b)Serena Williams\n(c)Pete Sampras";
		q[23] = "Novak Djokovic belongs to which country\n(a)Italy\n(b)Switzerland\n(c)Serbia";
		q[24] = "Which country has won the most cricket world cups\n(a)India\n(b)Australia\n(c)Pakistan";
		

		Questions[] questions= {new Questions(q[0],"a"),new Questions(q[1],"b")
				,new Questions(q[2],"b"),new Questions(q[3],"c")
				,new Questions(q[4],"a"),new Questions(q[5],"b")
				,new Questions(q[6],"b"),new Questions(q[7],"a")
				,new Questions(q[8],"a"),new Questions(q[9],"a")
				,new Questions(q[10],"c"),new Questions(q[11],"c")
				,new Questions(q[12],"b"),new Questions(q[13],"b")
				,new Questions(q[14],"a"),new Questions(q[15],"a")
				,new Questions(q[16],"b"),new Questions(q[17],"c")
				,new Questions(q[18],"a"),new Questions(q[19],"b")
				,new Questions(q[20],"a"),new Questions(q[21],"c")
				,new Questions(q[22],"a"),new Questions(q[23],"c")
				,new Questions(q[24],"b")};
		Quiz qz=new Quiz();
		qz.taketest(questions);
		
	}
	

}
