import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CRUDOperation {
    public static File directoryPath;
    public static String rootPath;
    public CRUDOperation(String path)
    {
        directoryPath = new File(path);
        rootPath = path;
    }
    private static boolean binarySearch(int start, int end, String[] contents, String fileName)
    {
        if(start <= end)
        {
            int mid = start + (end - start) / 2;
            int res = fileName.compareTo(contents[mid]);
            if(res == 0)
            {
                return true;
            }
            else if(res > 0)
            {
                return binarySearch(mid + 1, end, contents, fileName);
            }
            else
            {
                return binarySearch(start, mid - 1, contents, fileName);
            }
        }
        else
        {
            return false;
        }
    }
    public static void addFile()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(" Please Enter Name of File : ");
        String fileName = sc.nextLine();
        try {
            File temp = new File(rootPath + fileName + ".txt");
            if(temp.createNewFile())
            {
                System.out.println(" Successfully Created file");
            }
            else
            {
                System.out.println(" File Already Exists");
            }
        }
        catch (IOException e)
        {
            System.out.println(" Error has Occurred Try Again");
        }
    }
    public static void deleteFile()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(" Please Enter Name of File : ");
        String fileName = sc.nextLine();
        try {
            File temp = new File(rootPath + fileName);
            if(temp.delete())
            {
                System.out.println(" Successfully Deleted file");
            }
            else
            {
                System.out.println(" Failed to Delete file");
            }
        }
        catch (Exception e)
        {
            System.out.println(" Error has Occurred Try Again");
        }
    }
    public static boolean searchFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(" Please Enter Name of File : ");
        String fileName = sc.nextLine();
        String[] contents = directoryPath.list();
        Arrays.sort(contents);
        boolean search = binarySearch(0, contents.length - 1, contents, fileName);
        return search;
    }
}
