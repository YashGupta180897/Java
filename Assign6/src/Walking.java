/**
 * Created by yash.gupta on 7/13/2019.
 */
public class Walking implements Exercise {
    @Override
    public double calorieCalculator(double duration) {
        return duration*5;
    }
}
