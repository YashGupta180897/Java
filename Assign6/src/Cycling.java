/**
 * Created by yash.gupta on 7/13/2019.
 */
public class Cycling implements Exercise {
    @Override
    public double calorieCalculator(double duration) {
        return duration*15;
    }
}
