import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public static void main(String[] args) throws ParseException {



        String date1 = "09.02.1999";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOne = format.parse(date1);

        Man m1 = new Man("c1", "c1", "09/02/1999", (byte) 100);
        System.out.println(m1.describeAge());
        System.out.println(m1.toString());

    }

}
