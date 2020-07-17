import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 10));
        System.out.println(generateNum(numbers));
    }

    public static String generateNum(List<Integer> numbers) {
        if (numbers.isEmpty() || numbers.get(0) > 1) {
            return "001";
        }
        int fileNum = IntStream.range(1, numbers.size())
                .filter(i -> numbers.get(i) - numbers.get(i - 1) > 1)
                .map(i -> numbers.get(i - 1) + 1)
                .findFirst()
                .orElse(numbers.get(numbers.size() - 1) + 1);
        if (fileNum > 999) {
            throw new RuntimeException("Превышен максимальный номер дела!");
        }
        StringBuilder result = new StringBuilder(String.valueOf(fileNum));
        switch (result.length()) {
            case 3:
                break;
            case 2:
                result.insert(0, "0");
                break;
            case 1:
                result.insert(0, "00");
                break;
        }
        return result.toString();
    }
}
