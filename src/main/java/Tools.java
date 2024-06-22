import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Tools {

    public static String oddCount(List<String> arr) {

        return IntStream.range(0, arr.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + arr.get(i))
                .collect(Collectors.joining(", "));
    }

    public static List<String> reverseSortUpCase(List<String> arr) {
        return arr.stream()
                .map(String::toUpperCase)
                .sorted((str1, str2) -> str2.compareTo(str1))
                .collect(Collectors.toList());
    }

    public static void stringNumsToIntArray(String[] input) {
        try {
            List<Integer> result = Arrays.stream(input)
                    .flatMap(str -> Arrays.stream(str.split(",\\s+")))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(result);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong format, use numbers only!");
        }
    }

    public static Stream<Long> randomNum() {
        final long a = 25214903917L;
        final long c = 11L;
        final long m = (long) Math.pow(2, 48);
        long seed = System.currentTimeMillis();
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        int size = Math.min(firstList.size(), secondList.size());

        return IntStream.range(0, size)
                .mapToObj(i -> Stream.of(firstList.get(i), secondList.get(i)))
                .flatMap(str -> str);

    }


}
