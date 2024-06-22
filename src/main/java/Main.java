import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("Karl", "Mark", "Vasya", "Ihor", "Zurab", "Daria", "Vera");
        System.out.println(names);

        System.out.println(Tools.oddCount(names));

        System.out.println(Tools.reverseSortUpCase(names));

        String[] strArr = {"1, -2, 0", "4, 5"};
        Tools.stringNumsToIntArray(strArr);

        Tools.randomNum()
                .limit(3)
                .forEach(System.out::println);

        Path file1 = Paths.get("Test1.txt");
        Path file2 = Paths.get("Test2.txt");

        try (
                Stream<String> test1 = Files.lines(file1);
                Stream<String> test2 = Files.lines(file2)

        ) {
            try (Stream<String>test3=Tools.zip(test1, test2)){
                test3.forEach(System.out::println);
            }

        } catch ( IOException ex) {
            ex.printStackTrace();
        }
    }

}

