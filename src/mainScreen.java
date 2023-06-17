import java.util.Scanner;

public class mainScreen {
    private static final String appName = "LockedMe.com";
    private static final String devName = "Bhawan Gakhar";
    private static final String rootDir = "/Users/bhawangakhar/IdeaProjects/Phase1/Test";
    public static String getAppName() {
        return appName;
    }
    public static String getDevName() {
        return devName;
    }
    public static String getRootDir() {
        return rootDir;
    }
    public static void mainScreen() {
        System.out.println(" 1. Sort files in ascending order ");
        System.out.println(" 2. CRUD Operations on files ");
        System.out.println(" 3. Exit Application ");
        System.out.println(" Enter Choice : ");
    }
    public static void optionSelect(int choice, Scanner sc)
    {
        switch (choice) {
            case 1 -> {
                // sorting class
            }
            case 2 -> {
                crudScreen(sc);
            }
            case 3 -> {
                System.exit(0);
            }
        }
    }

    public static void CRUDSelect(){

    }

    public static int checkInput(Scanner sc, int limit)
    {
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println(" Please Enter Integer Choice");
            System.out.println();
        }
        try
        {
            if(choice <= 0 || choice > limit)
            {
                throw new InvalidRangeException(" Please Enter Valid Option");
            }
            return choice;
        }
        catch (InvalidRangeException e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return -1;
    }
    public static void crudScreen(Scanner sc)
    {
        while(true)
        {
            System.out.println();
            System.out.println(" CRUD Operations ");
            System.out.println(" 1. Add File to Directory");
            System.out.println(" 2. Delete File from Directory");
            System.out.println(" 3. Search File from Directory");
            System.out.println(" Enter Choice : ");
            int choice = checkInput(sc, 4);
            if(choice != -1)
            {
                // crud switch case
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Welcome To " + getAppName());
        System.out.println(" Developed By " + getDevName());
        while(true)
        {
            mainScreen();
            int choice = checkInput(sc, 3);
            if(choice != -1)
            {
                optionSelect(choice, sc);
            }

        }
    }
}
