import java.util.ArrayList;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) {


        String[][] schedule = new String[1][2];

        schedule[0][0] = DayOfWeek.FRIDAY.name();
        schedule[0][1] = "write code";

        Human h1 = new Human();
        h1.setSchedule(schedule);

        System.out.println(h1.toString());





    }
}
