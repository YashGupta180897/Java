import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by yash.gupta on 7/13/2019.
 */
public class Handler {

    public HandlerAttributes attributes=new HandlerAttributes();
    private static HashMap<LocalDate,Double> datemap=new HashMap<>();
    private List<String> exerciseType=new ArrayList<>();

    public void processCalories(double duration,int x)
    {
        Exercise e;
        if(x==1){
            e=new Walking();
            attributes.calories.add(e.calorieCalculator(duration));
        }
        else if(x==2){
            e=new Running();
            attributes.calories.add(e.calorieCalculator(duration));
        }
        else if(x==3){
            e=new Cycling();
            attributes.calories.add(e.calorieCalculator(duration));
        }
    }

    public void detailDisplay()
    {
        System.out.println();
        System.out.println("Detailed View");
        System.out.println("Name:" + attributes.getName());

        String leftAlignFormat = "| %-15s | %-16.2f | %-13s | %-21.2f |%n";

        System.out.format("+-----------------+------------------+---------------+-----------------------+%n");
        System.out.format("|  Exercise type  |  Duration(mins)  |     Date      |     Calories burned   |%n");
        System.out.format("+-----------------+------------------+---------------+-----------------------+%n");

        int i=0;
        while(i!=attributes.exType.size())
        {
            System.out.format(leftAlignFormat,attributes.exType.get(i),attributes.duration.get(i),attributes.date.get(i).toString(),attributes.calories.get(i));
            i++;
        }
        System.out.println("+----------------------------------------------------------------------------+");

        Iterator<Double> itr4=attributes.calories.iterator();
        double totalCalories=0;
        while(itr4.hasNext())
        {
            double tempCal=itr4.next();
            totalCalories+=tempCal;

        }
        System.out.println("\n");
        System.out.println("Total Calories Burned:"+totalCalories);
        System.out.println();

    }

    public void aggregation(int previousDateLen)
    {
        if(datemap.isEmpty())
        {
            datemap.put(attributes.date.get(0),attributes.calories.get(0));
            exerciseType.add(attributes.exType.get(0));
        }

        int flag;
        for(int cnt=previousDateLen;cnt<attributes.date.size();cnt++) {
            flag = 0;
            for (HashMap.Entry<LocalDate, Double> entry : datemap.entrySet())
            {   int i=0;
                if (entry.getKey().equals(attributes.date.get(cnt)))
                {
                    entry.setValue(attributes.calories.get(cnt) + entry.getValue());
                    exerciseType.set(i,exerciseType.get(i)+", "+attributes.exType.get(cnt));
                    flag = 1;
                    break;
                }
                else {
                    flag = 0;
                }
                i++;
            }
            if (flag == 0) {
                exerciseType.add(attributes.exType.get(cnt));
                datemap.put(attributes.date.get(cnt), attributes.calories.get(cnt));
            }
        }
    }

    public void aggregateDisplay()
    {
        System.out.println("Name:" + attributes.getName());
        String leftAlignFormat = "| %-11s | %-32s | %-19.2f |%n";
        System.out.format("+-------------+----------------------------------+-----------------------+%n");
        System.out.format("|     Date    |           Exercises              |     Calories burned   |%n");
        System.out.format("+-------------+----------------------------------+-----------------------+%n");

        int i=0;
        for (HashMap.Entry<LocalDate, Double> entry : datemap.entrySet())
        {
            System.out.format(leftAlignFormat,entry.getKey(),exerciseType.get(i),entry.getValue());
            i++;
        }

        System.out.format("+-------------+----------------------------------+-----------------------+%n");

        System.out.println();
    }

}
