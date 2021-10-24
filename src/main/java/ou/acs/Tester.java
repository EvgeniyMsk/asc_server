package ou.acs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        File fileDir = new File("C:/Users/User/Desktop/skmk/");
        for (File file : fileDir.listFiles())
            result.add(file.getName().substring(0, file.getName().indexOf(".")));
        System.out.println(result);
    }
}
