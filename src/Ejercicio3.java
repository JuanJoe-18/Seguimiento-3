import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String bitString = rd.nextLine();
        System.out.println(bitCounter(bitString));
    }
    public static int bitCounter(String bits) {
        int bitcounter = 0;
        for (int i = 0; i < bits.length(); i++) { //no usé el for each porque necesito el índice para analizar la complejidad
            if (bits.charAt(i)=='1') {
                bitcounter++;
            }
        }
        return bitcounter;
    }
}