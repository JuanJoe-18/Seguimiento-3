import java.util.*;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String input = rd.nextLine(); // numbers separated by ,
        String[] inputArray = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : inputArray) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        Set<Integer> repeatedNumbers = findRepeatedValues(numbers);
        System.out.println(repeatedNumbers);
    }

    private static Set<Integer> findRepeatedValues(List<Integer> list) {
        Set<Integer> result = new HashSet<>();
        int n = list.size();
        for (int i = 1; i < n; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}