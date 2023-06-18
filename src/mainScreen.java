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

    public static SortFiles sortFile = new SortFiles(getRootDir());
    public static CRUDOperation crudOperation = new CRUDOperation(getRootDir());
    public static void mainScreenDisplay() {
        System.out.println(" 1. Sort files in ascending order ");
        System.out.println(" 2. CRUD Operations on files ");
        System.out.println(" 3. Exit Application ");
        System.out.println(" Enter Choice : ");
    }
    public static void optionSelect(int choice, Scanner sc)
    {
        switch (choice) {
            case 1 -> {
                sortFile.printSortedFile();
            }
            case 2 -> {
                crudScreen(sc);
            }
            case 3 -> {
                System.exit(0);
            }
        }
    }

    public static void CRUDSelect(int choice)
    {
        switch(choice)
        {
            case 1 -> {
                crudOperation.addFile();
            }
            case 2 -> {
                crudOperation.deleteFile();
            }
            case 3 -> {
                crudOperation.searchFile();
            }
        }
    }

    public static int checkIntegerInput(Scanner sc)
    {
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
            return choice;
        }
        catch (NumberFormatException e)
        {
            System.out.println(" Please Enter Integer Choice");
            System.out.println();
        }
        return -1;
    }

    public static boolean checkRangeInput(int choice, int limit)
    {
        try
        {
            if(choice <= 0 || choice > limit)
            {
                throw new InvalidRangeException(" Please Enter Valid Option");
            }
            return true;
        }
        catch (InvalidRangeException e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return false;
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
            System.out.println(" 4. Back to Main Menu");
            System.out.println(" Enter Choice : ");
            int choice = checkIntegerInput(sc);
            boolean secondCheck = checkRangeInput(choice, 4);
            if(choice > 0)
            {
                secondCheck = checkRangeInput(choice, 4);
            }
            if(choice == 4)
            {
                break;
            }
            if(secondCheck)
            {
                // crudClass
                CRUDSelect(choice);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println();
            System.out.println(" Welcome To " + getAppName());
            System.out.println(" Developed By " + getDevName());
            mainScreenDisplay();
            int choice = checkIntegerInput(sc);
            boolean secondCheck = false;
            if(choice > 0)
            {
                secondCheck = checkRangeInput(choice, 3);
            }
            if(secondCheck)
            {
                optionSelect(choice, sc);
            }
        }
    }
}
