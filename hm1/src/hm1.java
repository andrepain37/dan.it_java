
import java.util.Arrays;
import java.util.Scanner;


public class hm1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your name:");
        String playerName = scanner.next();
        int playerNum = 0;
        int[] playersNums = new int[0];
        Boolean isNotCorrect = true;





        int correctNum = generateRandom(0, 100);

        System.out.println("Let the game begin!");

        do{

            System.out.println("Write a number in the range from 0 to 100:");

            playerNum = scanner.nextInt();

            if(playerNum > 100 || playerNum < 0){
                System.out.println("you have to enter a number in the range from 0 to 100!!!");
                continue;
            }

            String message = checkNum(playerNum, correctNum, playerName);
            
            System.out.println(message);

            playersNums = addToArray(playersNums, playerNum);


            if (playerNum == correctNum){
                isNotCorrect = false;
                sort(playersNums);
                System.out.println(Arrays.toString(playersNums));
            }
            
            

            System.out.println("-------------------");

        }
        while(isNotCorrect);

    }

    public static int generateRandom(int min, int max) {
        int i = (int)(Math.random() * (max - min + 1) + min);

        return i;
    }

    public static int[] addToArray(int[] arr, int el) {
        int[] result = Arrays.copyOf(arr, arr.length +1);
        result[arr.length] = el;
        return result;
    }

    public static void sort(int[] arr){

        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static String checkNum(int num, int trueNum, String name) {
        String answer = null;
        if(num == trueNum) answer = "Congratulations " + name + "!";// if correct
        if(num > trueNum) answer = "Your number is too big. Please, try again"; // if more than trueNum
        if(num < trueNum) answer = "Your number is too small. Please, try again."; // if less than trueNum
        return answer;
    }
}
