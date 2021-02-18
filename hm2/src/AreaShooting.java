
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ROWS = 6;
        int COLS = 6;
        int hitsCount = 0;
        int count = 3;


        int[][] corrects = new int[ROWS - 1][COLS - 1];
        generateRandomArray(corrects, count);

        int[][] missing = new int[ROWS][COLS];
        int[][] hits = new int[ROWS][COLS];

        System.out.println(Arrays.toString(corrects[0]));
        System.out.println(Arrays.toString(corrects[1]));
        System.out.println(Arrays.toString(corrects[2]));
        System.out.println(Arrays.toString(corrects[3]));
        System.out.println(Arrays.toString(corrects[4]));


        boolean isWin = false;

        System.out.println("All set. Get ready to rumble!");

        do{


            System.out.println("Enter row:");

            int currentRow = scanner.nextInt();

            if(currentRow <= 0 || currentRow >= ROWS){
                System.out.println("You have to enter a number of row in the range from 1 to 5!!!");
                continue;
            }

            System.out.println("Enter column:");

            int currentCol = scanner.nextInt();

            if(currentCol <= 0 || currentCol >= COLS){
                System.out.println("You have to enter a number of column in the range from 1 to 5!!!");
                continue;
            }

            int[][] a = new int[ROWS][COLS];



            for (int y = 0; y < ROWS; y++) {
                for (int x = 0; x < COLS; x++) {
                    if (y == 0){
                        a[y][x] = x;
                    }else if(x == 0){
                        a[y][x] = y;
                    }else{
                        if (missing[y][x] == 1){
                            a[y][x] = -2;
                        }else if(hits[y][x] == 1) {
                            a[y][x] = -3;
                        }else if(currentRow == y && currentCol == x){
                            if (corrects[currentRow][currentCol] == 1){
                                a[y][x] = -3;
                                hits[y][x] = 1;
                                hitsCount = hitsCount + 1;
                                if (hitsCount == count){
                                    isWin = true;
                                }

                            }else {
                                missing[y][x] = 1;
                                a[y][x] = -2;
                            }
                        }else {
                            a[y][x] = -1;
                        }
                    }
                }
            }




            for (int i = 0; i < ROWS; i++) {
                System.out.println(arrayToStringWithFilter(a[i]));
            }


            if (isWin){
                System.out.println("You have won!");
            }



            System.out.println("-------------------");

        }
        while(!isWin);

    }


    public static String arrayToStringWithFilter(int[] a) {
        StringJoiner sj = new StringJoiner(" | ");

        for (int x: a) {

            sj.add(x >= 0 ? String.format("%d", x) : checkPiece(x));
        }
        return sj.toString();
    }

    public static String checkPiece(int x) {

        String piece = "-";
        if (x == -2){
            piece = "*";
        }else if(x == -3){
            piece = "X";
        }

        return piece;
    }

    public static int[] addToArray(int[] arr, int el) {
        int[] result = Arrays.copyOf(arr, arr.length +1);
        result[arr.length] = el;
        return result;
    }

    public static boolean inArray(int[] arr, int a) {

        for (int el: arr){
            if (el == a){
               return true;
            }
        }
        return false;
    }

    public static int generateRandom(int min, int max) {

        int i = (int)(Math.random() * (max - min + 1) + min);

        return i;
    }

    public static void generateRandomArray(int[][] arr, int count) {

        int correctRow = generateRandom(1, arr.length - 1);
        int correctCol = generateRandom(1, arr[0].length - 1);

        int minus = 1;
        int plus = 1;

        arr[correctRow][correctCol] = 1;

        for (int i = 1; i < count; i++){

            if (correctRow - minus > 0 && correctRow - minus < arr.length){
                arr[correctRow - minus][correctCol] = 1;
                minus++;
            } else if(correctRow + plus < arr.length){
                arr[correctRow + plus][correctCol] = 1;
                plus++;
            }

        }
    }



}
