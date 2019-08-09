import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yash.gupta on 7/13/2019.
 */
public class HandlerAttributes {

    private String name;
    public List<String> exType = new ArrayList<>();
    public List<Double> duration = new ArrayList<>();
    public List<LocalDate> date =new ArrayList<>();
    public List<Double> calories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
