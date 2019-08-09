import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yash.gupta on 7/13/2019.
 */
public class User {

    private static Scanner sc=new Scanner(System.in);
    private static HashMap<String,Handler> hashmap=new HashMap<>();

    public static void main(String... args)
    {
        User U=new User();
        int ch;
        do {
            System.out.println("1.Add User \n2.Aggregated display \n3.Detailed display\n4.Log out of application");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    U.addUsers();
                    break;
                case 2:
                    U.aggregatedDisplay();
                    break;
                case 3:
                    U.detailedDisplay();
                    break;
                case 4:
                    System.out.println("Thankyou!");
                    break;
                default:
                    System.out.println("Wrong choice entered.");
            }

        }while(ch!=4);

    }

    private void addUsers() {

        String tempName;
        String ans;
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Handler h=new Handler();

        System.out.print("Name:");
        tempName = sc.next();
        h.attributes.setName(tempName);

        int previousDateLen = 1;

        for (HashMap.Entry<String, Handler> entry : hashmap.entrySet())
        {
            if(entry.getKey().equalsIgnoreCase(tempName))
            {
                h= entry.getValue();
                previousDateLen=h.attributes.date.size();
            }
        }

        do {
            System.out.print("Exercise type: 1.Walking 2.Running 3.Cycling ");
            int x=sc.nextInt();
            if(x==1) {
                h.attributes.exType.add("Walking");
            }
            else if(x==2)
            {
                h.attributes.exType.add("Running");
            }
            else if(x==3)
            {
                h.attributes.exType.add("Cycling");
            }

            System.out.print("Duration:");
            double tempDuration=sc.nextDouble();
            h.attributes.duration.add(tempDuration);

            System.out.print("Date(dd/mm/yyyy):");
            String temp = sc.next();
            h.attributes.date.add(LocalDate.parse(temp, formatter));

            h.processCalories(tempDuration, x);

            System.out.println("Do you want to add more exercise for " + tempName + "? (Y/N) ");
            ans = sc.next();

        } while (ans.equalsIgnoreCase("Y"));

        h.aggregation(previousDateLen);
        h.aggregateDisplay();
        hashmap.put(tempName,h);

    }

    private void aggregatedDisplay()
    {
        System.out.println("Name:");
        String nm=sc.next();

        for (HashMap.Entry<String, Handler> entry : hashmap.entrySet())
            {
                if (nm.equalsIgnoreCase(entry.getKey())) {
                    Handler h1 = entry.getValue();
                    h1.aggregateDisplay();
                }
            }
    }

    private void detailedDisplay(){

        System.out.println("1.Detailed View of all users \n2.Detailed View by name");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                for (HashMap.Entry<String, Handler> entry : hashmap.entrySet())
                {
                    Handler h1 = entry.getValue();
                    h1.detailDisplay();
                }
                break;
            case 2:
                System.out.println("Name:");
                String nm=sc.next();
                for (HashMap.Entry<String, Handler> entry : hashmap.entrySet())
                {
                    if (nm.equalsIgnoreCase(entry.getKey())) {
                        Handler h1 = entry.getValue();
                        h1.detailDisplay();
                    }
                }
                break;
            default:
                System.out.println("Enter right choice!");
        }
    }
}
