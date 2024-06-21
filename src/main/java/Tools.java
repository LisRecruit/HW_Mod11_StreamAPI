import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Tools {

    public static String oddCount(List<String> arr) {
        StringBuilder result = new StringBuilder("");
        int count = 0;
        for (int i = 1; i < arr.size(); i++) {
            count++;
            if (i % 2 == 1) {
                result.append(count);
                result.append(". ");
                result.append(arr.get(i));
                result.append(", ");
            }
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    public static List<String> reverseSortUpCase(List<String> arr) {
        List<String> result = new ArrayList<>();
        arr.forEach(name -> result.add(name.toUpperCase()));
        result.sort((str1, str2) -> str2.compareTo(str1));
        return result;
    }

    public static void stringNumsToIntArray(String[] input) {
        try {
            int arrLength = 0;
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < input.length; i++) {
                String[] strArr = input[i].split(",\\s+");
                for (int j = 0; j < strArr.length; j++) {
                    result.add(Integer.parseInt(strArr[j]));
                }
            }
            Collections.sort(result);
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
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean useFirst = true;
            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }
            @Override
            public T next() {
                if (useFirst) {
                    useFirst = false;
                    return firstIterator.next();
                } else {
                    useFirst = true;
                    return secondIterator.next();
                }
            }
        };
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }


}
