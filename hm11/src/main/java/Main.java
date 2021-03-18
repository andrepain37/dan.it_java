import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static FamilyController familyController = new FamilyController();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws ParseException {

        String userCommand = "";

        FamilyController familyController = new FamilyController();

        do {

            printCommands();


            userCommand = printUser();


            switch (userCommand){
                case "1": {
                    setTest();
                    break;
                }
                case "2": {
                    displayAllFamilies();
                    break;
                }
                case "3": {
                    getFamiliesBiggerThan();
                    break;
                }
                case "4": {
                    getFamiliesLessThan();
                    break;
                }
                case "5": {
                    countFamiliesWithMemberNumber();
                    break;
                }
                case "6": {
                    createFamily();
                    break;
                }
                case "7": {
                    deleteFamily();
                    break;
                }
                case "8": {
                    editFamily();
                    break;
                }
                case "9": {
                    deleteAllChildrenOlderThen();
                    break;
                }
                default: {
                    System.out.println("Sorry, I don't understand you, please try again.");
                    break;
                }
            }


        }while(true);

    }

    private static void setTest() {
        Man father = new Man("Josh", "Johnson", 1999);
        Woman mother = new Woman("Andre", "Johnson", 1999);
        familyController.createNewFamily(father, mother);
    }

    private static void displayAllFamilies(){
        familyController.displayAllFamilies();
    }

    private static void getFamiliesBiggerThan(){
        printNumber();
        String userCommand = printUser();

        int realNumber = checkNumber(userCommand);
        System.out.println(familyController.getFamiliesBiggerThan(realNumber));
    }

    private static void getFamiliesLessThan(){
        printNumber();
        String userCommand = printUser();

        int realNumber = checkNumber(userCommand);
        System.out.println(familyController.getFamiliesLessThan(realNumber));
    }

    private static void countFamiliesWithMemberNumber(){
        printNumber();
        String userCommand = printUser();

        int realNumber = checkNumber(userCommand);
        System.out.println(familyController.countFamiliesWithMemberNumber(realNumber));
    }

    private static void createFamily(){
        Man father = new Man("test", "test", 1);
        Woman mother = new Woman("test", "test", 1);

        setHuman("отца", father);
        setHuman("матери", mother);

        familyController.createNewFamily(father, mother);

    }

    private static void deleteFamily(){
        printIndexFamily();
        String userCommand = printUser();

        int realIndex = checkNumber(userCommand);
        familyController.deleteFamily(realIndex);
    }

    private static void editFamily(){

        printCommandsForEditFamily();
        String userCommand = printUser();
        switch (userCommand){
            case "1": {
                bornChild();
                break;
            }
            case "2": {
                adoptChild();
                break;
            }
            case "3": {
                return;
            }
            default: {
                System.out.println("Такой команды нету!");
                editFamily();
                break;
            }
        }

    }

    public static void deleteAllChildrenOlderThen(){
        System.out.println("Введите интересующий возраст");
        int userCommand = checkNumber(printUser());
        familyController.deleteAllChildrenOlderThen(userCommand);
    }

    public static void bornChild(){
        printIndexFamily();
        Family family = familyController.getFamilyByIndex(checkNumber(printUser())).get();

        System.out.println("Введите имя, если будет мальчик");
        String bName = printUser();

        System.out.println("Введите имя, если будет девочка");
        String gName = printUser();

        familyController.bornChild(family, bName, gName);
    }

    public static void adoptChild(){
        printIndexFamily();
        Family family = familyController.getFamilyByIndex(checkNumber(printUser())).get();

        System.out.println("- 1. Девочка" +
                "-2. Мальчик");
        String userCommand = printUser();
        Human child = null;
        switch (userCommand){
            case "1": {
                child = new Woman("c1", "c2", 213);
                break;
            }
            case "2": {
                child = new Man("c1", "c2", 213);
                break;
            }
            default: {
                System.out.println("Такой команды нету!");
                adoptChild();
                break;
            }
        }

        setHuman("ребенка", child);

        familyController.adoptChild(family, child);
    }


    private static int checkMonth(String month){
        int realMonth = checkNumber(month);
        if (realMonth > 12 || realMonth < 1) {
            throw new FamilyOverflowException("Введите корректное число месяца");
        }
        return realMonth;
    }

    private static int checkDay(String month){
        int realDay = checkNumber(month);
        if (realDay > 31 || realDay < 1) {
            throw new FamilyOverflowException("Введите корректное число дня месяца");
        }
        return realDay;
    }

    private static int checkNumber(String userCommand){
        if (!userCommand.matches("[+]?\\d+")) {
            throw new FamilyOverflowException("Введите корректное число");
        }
        return Integer.parseInt(userCommand);
    }

    private static void printIndexFamily(){
        System.out.println("Введите порядковый номер семьи (ID)");
    }

    private static void printNumber(){
        System.out.println("Введите интересующее число");
    }

    private static void setHuman(String endPrint, Human human){
        System.out.printf("Введите имя %s", endPrint);
        human.setName(printUser());
        System.out.printf("Введите фамилию %s", endPrint);
        human.setSurname(printUser());
        System.out.printf("Введите год рождения %s", endPrint);
        int year = checkNumber(printUser());
        System.out.printf("Введите месяц рождения %s", endPrint);
        int month = checkMonth(printUser());
        System.out.printf("Введите день рождения %s", endPrint);
        int day = checkDay(printUser());
        human.setYear(String.format("%02d/%02d/%d", day, month, year));
        System.out.printf("Введите iq %s", endPrint);
        human.setIq((byte) checkNumber(printUser()));
    }

    private static void printCommands(){

        String commands = "- 1. Заполнить тестовыми данными (автоматом создать несколько семей и сохранить их в базе)\n" +
                "- 2. Отобразить весь список семей (отображает список всех семей с индексацией, начинающейся с 1)\n" +
                "- 3. Отобразить список семей, где количество людей больше заданного\n" +
                "- 4. Отобразить список семей, где количество людей меньше заданного\n" +
                "- 5. Подсчитать количество семей, где количество членов равно\n" +
                "- 6. Создать новую семью\n" +
                "- 7. Удалить семью по индексу семьи в общем списке\n" +
                "- 8. Редактировать семью по индексу семьи в общем списке \n" +
                "- 9. Удалить всех детей старше возраста (во всех семьях удаляются дети старше указанного возраста - будем считать, что они выросли)\n";

        System.out.println(commands);
    }

    private static void printCommandsForEditFamily(){

        String commands = " - 1. Родить ребенка\n" +
                "  - 2. Усыновить ребенка\n" +
                "  - 3. Вернуться в главное меню ";

        System.out.println(commands);
    }



    private static String printUser(){
        String userCommand = scanner.nextLine().trim();
        if (userCommand.equalsIgnoreCase("exit")) {
            System.exit(1);
        }
        return userCommand;
    }

}
