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
        for (int i = 1; i < n; i++) { 
            if (list.get(i).equals(list.get(i - 1))) { 
                result.add(list.get(i));
            }
        }
        return result;
    }
}
```

### Tabla de Costos:

| Línea | Código                                        | Veces que se ejecuta |
| ------ | ---------------------------------------------- | -------------------- |
| 1      | `Scanner rd = new Scanner(System.in);`       | 1                    |
| 2      | `String input = rd.nextLine();`              | 1                    |
| 3      | `String[] inputArray = input.split(",");`    | 1                    |
| 4      | `List<Integer> numbers = new ArrayList<>();` | 1                    |
| 5      | `for (String s : inputArray)`                | n + 1                |
| 6      | `numbers.add(Integer.parseInt(s.trim()));`   | n                    |
| 7      | `Set<Integer> result = new HashSet<>();`     | 1                    |
| 8      | `for (int i = 1; i < n; i++)`                | n + 1                |
| 9      | `if (list.get(i).equals(list.get(i - 1)))`   | n                    |
| 10     | `result.add(list.get(i));`                   | n                    |
| 11     | `return result;`                             | 1                    |

### Cálculo de $T(n)$

$ T(n) = 1 + 1 + 1 + 1 + (n+1) + n + 1 + (n+1) + n + n + 1 $

$ T(n) =5n+8 $

---

## **Algoritmo 2 (Verificación de Palíndromo)**

```java
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra:");
        String word=sc.nextLine();
        int contador=0;
        for (int h = 0; h<word.length(); h++){ 
            if (word.charAt(h) == word.charAt((word.length()-1)-h)){ 
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

| Línea | Código                                                                             | Veces que se ejecuta |
| ------ | ----------------------------------------------------------------------------------- | -------------------- |
| 1      | `Scanner sc = new Scanner(System.in);`                                            | 1                    |
| 2      | `System.out.println("Digite la palabra:");`                                       | 1                    |
| 3      | `String word=sc.nextLine();`                                                      | 1                    |
| 4      | `int contador=0;`                                                                 | 1                    |
| 5      | `for (int h = 0; h<word.length(); h++)`                                           | n + 1                |
| 6      | `if (word.charAt(h) == word.charAt((word.length()-1)-h))`                         | n                    |
| 7      | `contador+=1;` / `contador +=2;`                                                | n                    |
| 8      | `if (contador==word.length())`                                                    | 1                    |
| 9      | `System.out.println("Palindromo");` / `System.out.println("No es palindromo");` | 1                    |

$T(n)= 1 + 1 + 1 + 1 + (n+1) + n + n + 1 + 1 $

$T(n)= 3n+7 $

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
        for (int i = 0; i < bits.length(); i++) { 
            if (bits.charAt(i)=='1') { 
                bitcounter++;
            }
        }
        return bitcounter;
    }
}
```

### Tabla de Costos:

| Línea | Código                                        | Veces que se ejecuta |
| ------ | ---------------------------------------------- | -------------------- |
| 1      | `Scanner rd = new Scanner(System.in);`       | 1                    |
| 2      | `String bitString = rd.nextLine();`          | 1                    |
| 3      | `System.out.println(bitCounter(bitString));` | 1                    |
| 4      | `int bitcounter = 0;`                        | 1                    |
| 5      | `for (int i = 0; i < bits.length(); i++)`    | n + 1                |
| 6      | `if (bits.charAt(i)=='1')`                   | n                    |
| 7      | `bitcounter++;`                              | n                    |
| 8      | `return bitcounter;`                         | 1                    |

$T(n)= 1 + 1 + 1 + 1 + (n+1) + n + n + 1 $

$T(n)= 3n+6 $

---

# Análisis de Complejidad Temporal

## Enunciado

Analiza la complejidad temporal y espacial, en el peor caso, de cada uno de los algoritmos.
Al final, realiza la suma de las líneas para hallar la complejidad del algoritmo
y concluye cuál es la cota superior. Una manera formal de encontrar la cota es
mediante una constante $c$ que permita acotar por arriba la función encontrada.

### b)

A continuación, se presenta el análisis de la complejidad temporal, así como la cota superior asintótica.

---

## **Algoritmo 1 (Búsqueda de Números Repetidos)**

### Sabemos que:

$ T_1(n) = 5n + 8$

##### Queremos probar que:

$5n + 8 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$5n+8 \leq c \cdot n,\quad \forall n \geq n_0$

Dividimos por $n$:

$5 + \frac{8}{n} \leq c$

Para $n \geq 1$, tomamos $c = 13$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

---

## **Algoritmo 2 (Verificación de Palíndromo)**

### **Sabemos que:**

$T_2(n) = 3n + 7$

##### Queremos probar que:

$3n + 7 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$3n + 7 \leq c \cdot n, \forall n \geq n_0$

Dividimos por $n$:

$3 + \frac{7}{n} \leq c$

Para $n \geq 1$, tomamos $c = 10$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

---

## **Algoritmo 3 (Contador de Bits)**

### **Sabemos que:**

$T_3(n) = 3n + 6 $

##### Queremos probar que:

$3n + 6 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$3n + 6 \leq c \cdot n, \forall n \geq n_0$

Dividimos por $n$:

$3 + \frac{6}{n} \leq c$

Para $n \geq 1$, tomamos $c = 9$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

---

Análisis de la complejidad espacial.

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
        for (int i = 1; i < n; i++) { 
            if (list.get(i).equals(list.get(i - 1))) { 
                result.add(list.get(i));
            }
        }
        return result;
    }
}
```

| Variable / Estructura                | Cantidad de valores atómicos | Tamaño de 1 valor atómico |
| ------------------------------------ | ----------------------------- | --------------------------- |
| String:`input`                     | n                             | 16 bits por carácter       |
| String[]:`inputArray`              | n                             | 16 bits por carácter       |
| List`<Integer>`: `numbers`       | n                             | 32 bits por entero          |
| String:`s`                         | 1                             | 16 bits por carácter       |
| Set`<Integer>`:`repeatedNumbers` | n                             | 32 bits por entero          |
| Set`<Integer>`: `result`         | n                             | 32 bits por entero          |
| int:`n`                            | 1                             | 32 bits                     |
| int:`i`                            | 1                             | 32 bits                     |

**Complejidad Espacial Total** = **String** input + **String[]** inputArray + **List`<Integer>`** numbers + **Set`<Integer>`** repeatedNumbers + **int** n + **int** i

$=O(n) + O(n) + O(n) + O(1) + O(n) + O(n) + O(1) + O(1)= O(5n + 3)$
$O(5n + 3)=O(n)$

## **Algoritmo 2 (Verificación de Palíndromo)**

```java
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra:");
        String word=sc.nextLine();
        int contador=0;
        for (int h = 0; h<word.length(); h++){
            if (word.charAt(h) == word.charAt((word.length()-1)-h)){ 
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

| Variable / Estructura | Cantidad de valores atómicos | Tamaño de 1 valor atómico |
| --------------------- | ----------------------------- | --------------------------- |
| String:`word`       | n                             | 16 bits por carácter       |
| int:`contador`      | 1                             | 32 bits                     |
| int:`h`             | 1                             | 32 bits                     |

**Complejidad Espacial Total** = **String** word + **int** contador + **int** h

$=O(n) + O(1) + O(1)= O(2 + n)$
$O(2 + n)=O(n)$

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
        for (int i = 0; i < bits.length(); i++) { 
            if (bits.charAt(i)=='1') { 
                bitcounter++;
            }
        }
        return bitcounter;
    }
}
```

| Variable / Estructura | Cantidad de valores atómicos | Tamaño de 1 valor atómico |
| --------------------- | ----------------------------- | --------------------------- |
| String:`bitString`  | n                             | 16 bits por caracter        |
| int:`bitcounter`    | 1                             | 32 bits                     |
| int:`i`             | 1                             | 32 bits                     |
| String:`bits`       | n                             | 16 bits por caracter        |

**Complejidad Espacial Total** = **String** bitString + **int** bitCounter + **int** i + **String** bits

$=O(n) + O(1) + O(1) + O(n) = O(2n + 2)$
$O(2n + 2) = O(n)$
