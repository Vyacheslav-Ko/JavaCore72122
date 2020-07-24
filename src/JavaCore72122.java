
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCore72122 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        Stream<String> stringStream = bf.lines();

        stringStream.map(s -> s.toLowerCase().split("[^a-zA-Zа-яА-Я0-9']+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                    .limit(10)
                    .forEach(s -> System.out.println(s.getKey()));
    }
}



