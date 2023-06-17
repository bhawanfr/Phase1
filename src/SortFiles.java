import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

class sortComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
public class SortFiles {
    public static File directoryPath;
    public SortFiles(String path)
    {
        directoryPath = new File(path);
    }
    public static void printSortedFile()
    {
        String[] contents = directoryPath.list();
        Arrays.sort(contents, new sortComparator());
        for (int i = 0; i < contents.length; i++) {
            System.out.println(" " + (i+1) +". " + contents[i]);
        }
        System.out.println();
    }
}
