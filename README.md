# Análisis de Complejidad Temporal

## Enunciado

Analiza la complejidad temporal, en el peor caso $Big O$, de cada uno de los algoritmos.
Realiza una tabla y describe línea por línea la cantidad de veces que se ejecuta
cada una de ellas.

### a) Tabla de Costos por Algoritmo

A continuación, se presentan las tablas de costos para cada algoritmo, donde se describe línea por línea la cantidad de veces que se ejecuta cada una de ellas. Posteriormente, se realiza el análisis de la cota superior asintótica.

---

## **Algoritmo 1 (Búsqueda de Números Repetidos)**

```java
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
        for (int i = 1; i < n; i++) { // Se ejecuta n veces
            if (list.get(i).equals(list.get(i - 1))) { // Se ejecuta n - 1 veces
                result.add(list.get(i));
            }
        }
        return result;
    }
}
```

### Tabla de Costos:

| Línea | Código | Veces que se ejecuta |
|--------|--------|----------------------|
| 1 | `Scanner rd = new Scanner(System.in);` | 1 |
| 2 | `String input = rd.nextLine();` | 1 |
| 3 | `String[] inputArray = input.split(",");` | 1 |
| 4 | `List<Integer> numbers = new ArrayList<>();` | 1 |
| 5 | `for (String s : inputArray)` | n |
| 6 | `numbers.add(Integer.parseInt(s.trim()));` | n - 1 |
| 7 | `Set<Integer> result = new HashSet<>();` | 1 |
| 8 | `for (int i = 1; i < n; i++)` | n |
| 9 | `if (list.get(i).equals(list.get(i - 1)))` | n - 1 |
| 10 | `result.add(list.get(i));` | n - 1 |
| 11 | `return result;` | 1 |

### Cálculo de $T(n)$

$ T(n) = 1 + 1 + 1 + 1 + n + (n-1) + 1 + n + (n-1) + (n-1) + 1 $

$ T(n) = 4 + 3n - 2 + 3n - 3 = 6n - 1 $

Por lo tanto, $T(n) = O(n)$.

---

## **Algoritmo 2 (Verificación de Palíndromo)**

```java
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra:");
        String word=sc.nextLine();
        int contador=0;
        for (int h = 0; h<word.length(); h++){ // Se ejecuta n veces
            if (word.charAt(h) == word.charAt((word.length()-1)-h)){ // Se ejecuta n - 1 veces
                contador+=1;
            } else {
                contador +=2;
            }
        }
        if (contador==word.length()){
            System.out.println("Palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }
}
```

### Tabla de Costos:

| Línea | Código | Veces que se ejecuta |
|--------|--------|----------------------|
| 1 | `Scanner sc = new Scanner(System.in);` | 1 |
| 2 | `System.out.println("Digite la palabra:");` | 1 |
| 3 | `String word=sc.nextLine();` | 1 |
| 4 | `int contador=0;` | 1 |
| 5 | `for (int h = 0; h<word.length(); h++)` | n |
| 6 | `if (word.charAt(h) == word.charAt((word.length()-1)-h))` | n - 1 |
| 7 | `contador+=1;` / `contador +=2;` | n - 1 |
| 8 | `System.out.println("Palindromo");` / `System.out.println("No es palindromo");` | 1 |

Por lo tanto, $T(n) = O(n)$.

---

## **Algoritmo 3 (Contador de Bits)**

```java
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String bitString = rd.nextLine();
        System.out.println(bitCounter(bitString));
    }
    public static int bitCounter(String bits) {
        int bitcounter = 0;
        for (int i = 0; i < bits.length(); i++) { // Se ejecuta n veces
            if (bits.charAt(i)=='1') { // Se ejecuta n - 1 veces
                bitcounter++;
            }
        }
        return bitcounter;
    }
}
```

### Tabla de Costos:

| Línea | Código | Veces que se ejecuta |
|--------|--------|----------------------|
| 1 | `Scanner rd = new Scanner(System.in);` | 1 |
| 2 | `String bitString = rd.nextLine();` | 1 |
| 3 | `System.out.println(bitCounter(bitString));` | 1 |
| 4 | `int bitcounter = 0;` | 1 |
| 5 | `for (int i = 0; i < bits.length(); i++)` | n |
| 6 | `if (bits.charAt(i)=='1')` | n - 1 |
| 7 | `bitcounter++;` | n - 1 |
| 8 | `return bitcounter;` | 1 |

Por lo tanto, $T(n) = O(n)$.

---

# Análisis de Complejidad Temporal y Espacial

## Enunciado

Analiza la complejidad temporal y espacial, en el peor caso, de cada uno de los algoritmos.
Al final, realiza la suma de las líneas para hallar la complejidad del algoritmo
y concluye cuál es la cota superior. Una manera formal de encontrar la cota es
mediante una constante $c$ que permita acotar por arriba la función encontrada.

### b)

A continuación, se presenta el análisis de la complejidad temporal, así como la cota superior asintótica.

---
## **Algoritmo 1 (Búsqueda de Números Repetidos)**

### Cálculo de $T(n)$

$T(n) = 1 + 1 + 1 + 1 + n + (n-1) + 1 + n + (n-1) + (n-1) + 1$

$T(n) = 4 + 3n - 2 + 3n - 3 = 6n - 1$

Queremos probar que:

$6n - 1 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$6n - 1 \leq c \cdot n, \forall n \geq n_0$

Dividimos por $n$:

$6 - \frac{1}{n} \leq c$

Para $n \geq 1$, tomamos $c = 6$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

---

## **Algoritmo 2 (Verificación de Palíndromo)**

### Cálculo de $T(n)$

$T(n) = 1 + 1 + 1 + 1 + n + (n-1) + (n-1) + (n-1) + 1 + 1 + 1$

$T(n) = 6 + 4n - 3 = 4n + 3$

Queremos probar que:

$4n + 3 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$4n + 3 \leq c \cdot n, \forall n \geq n_0$

Dividimos por $n$:

$4 + \frac{3}{n} \leq c$

Para $n \geq 1$, tomamos $c = 5$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

---

## **Algoritmo 3 (Contador de Bits)**

### Cálculo de $T(n)$

$T(n) = 1 + 1 + 1 + n + (n-1) + (n-1) + 1$

$T(n) = 4 + 3n - 2 = 3n + 2$

Queremos probar que:

$3n + 2 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$3n + 2 \leq c \cdot n, \forall n \geq n_0$

Dividimos por $n$:

$3 + \frac{2}{n} \leq c$

Para $n \geq 1$, tomamos $c = 4$, $n_0 = 1$, por lo que:

$T(n) = O(n)$





