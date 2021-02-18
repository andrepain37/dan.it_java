import java.util.Arrays;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userCommand = "";

        String[][] scedule = new String[7][2];

        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";

        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";

        scedule[2][0] = "Tuesday";
        scedule[2][1] = "buy a TV";

        scedule[3][0] = "Wednesday";
        scedule[3][1] = "work";

        scedule[4][0] = "Thursday";
        scedule[4][1] = "to work a lot";

        scedule[5][0] = "Friday";
        scedule[5][1] = "read a book";

        scedule[6][0] = "Saturday";
        scedule[6][1] = "go to museum;";

        do {

            System.out.println("Please, input the day of the week:");

            userCommand = scanner.nextLine().trim();
            boolean isNotCorrect = true;
            boolean isChange = false;
            String[] splitCommand = userCommand.split(" ");

            if (checkWordsWithIgnoreCase(userCommand, "exit")){
                break;
            }


            if (splitCommand.length > 1 && checkWordsWithIgnoreCase(splitCommand[0], "change")){
                userCommand = splitCommand[1];
                isChange = true;
            }


            for (int i = 0; i < scedule.length; i++){

                if (checkWordsWithIgnoreCase(userCommand, scedule[i][0])){
                    if (isChange){
                        System.out.printf("What tasks will you have on %s:\n", scedule[i][0]);
                        String userCommandTasks = scanner.nextLine().trim();
                        scedule[i][1] = userCommandTasks;
                    }else{
                        System.out.printf("Your tasks for %s: %s\n", scedule[i][0], scedule[i][1]);
                    }
                    isNotCorrect = false;
                }

            }

            if (isNotCorrect){
                System.out.println("Sorry, I don't understand you, please try again.");
            }


        }while(true);
    }



    public static boolean checkWordsWithIgnoreCase(String firstWord, String secondWord) {
        return firstWord.equalsIgnoreCase(secondWord);
    }
}
