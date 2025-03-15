import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int contador = 0;
        for (int h = 0; h < word.length(); h++) {
            if (word.charAt(h) == word.charAt((word.length() - 1) - h)) {
                contador += 1;
            } else {
                contador += 2;
            }
        }
        if (contador == word.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
