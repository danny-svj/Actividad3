# 💻 Implementación de Algoritmos de Backtracking y Recursividad

¡proyecto! **Algoritmos de Backtracking y Recursividad**! Este es un sistema desarrollado en Java para demostrar la aplicación práctica de algoritmos complejos como la Serie de Fibonacci, la Suma de Subconjuntos y la resolución de Sudoku mediante backtracking.

## 📄 Tabla de Contenidos
- [Descripción](#descripción)
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Ejemplo de Interacción](#ejemplo-de-interacción)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Reflexión Final](#reflexión-final)
- [Autor](#autor)

## Descripción
El sistema es una aplicación de consola en Java que utiliza algoritmos para resolver y demostrar problemas de lógica y computación. La aplicación ofrece un menú interactivo que permite al usuario explorar el funcionamiento de cada algoritmo de forma independiente y visualizar su lógica.

El código está estructurado en clases modulares, lo que facilita su lectura y mantenimiento. Cada algoritmo incluye una salida detallada para ilustrar su proceso de toma de decisiones.

---

## 🚀 Características
- **Fibonacci Eficiente**: Implementación iterativa para evitar problemas de rendimiento y desbordamiento de pila en números grandes.
- **Suma de Subconjuntos con Traza**: Un algoritmo recursivo que muestra, paso a paso, el proceso de decisión para encontrar una solución.
- **Sudoku Dinámico y Educativo**: Un solucionador de Sudoku que genera un nuevo tablero aleatorio en cada ejecución y ofrece un modo rápido y uno interactivo para visualizar el proceso de backtracking.
- **Interfaz de consola interactiva**: Menús claros para interactuar con el sistema y entender los algoritmos.

---

## ⚙️ Requisitos
Para ejecutar este proyecto, necesitas lo siguiente:

| Requisito | Versión | Instalación |
|-----------|---------|----------------------------------------------------------------------------------|
| Java (JDK)| 8 o superior | [Descarga Java](https://www.oracle.com/java/technologies/javase-downloads.html) o `sudo apt install openjdk-11-jdk` (Linux) |
| Git | Última | [Descarga Git](https://git-scm.com/downloads) o `sudo apt install git` (Linux) |

---

## 🖥️ Instalación y Ejecución
Sigue estos pasos para configurar el proyecto en tu máquina:

1.  **Clonar el repositorio**:
    ```bash
    git clone [https://github.com/tu-usuario/Actividad-3.git](https://github.com/tu-usuario/Actividad-3.git)
    ```
    
2.  **Navegar al directorio del proyecto**:
    ```bash
    cd Actividad-3
    ```

3.  **Compilar y ejecutar**:
    ```bash
    javac *.java
    java ActividadPrincipal
    ```
    💡 **Consejo:** Asegúrate de estar en el directorio que contiene los archivos `.java` al compilar y ejecutar.

---

## 📋 Uso
Una vez que ejecutes el programa, aparecerá un menú interactivo en la consola con las siguientes opciones:

### 1. Opción: Serie de Fibonacci
* **Acción en la consola:** Presiona `1` y `Enter`. Luego, ingresa un número entero y presiona `Enter` de nuevo.
* **Resultado esperado:** El programa calculará el valor en la serie de Fibonacci y lo mostrará de manera clara.

### 2. Opción: Suma de Subconjuntos
* **Acción en la consola:** Presiona `2` y `Enter`.
* **Resultado esperado:** El programa mostrará un ejemplo automático. Después, te preguntará si deseas probar tus propios números. Responde `si` o `no`. Si respondes `si`, podrás ingresar tu propio conjunto de números y un valor objetivo.

### 3. Opción: Sudoku
* **Acción en la consola:** Presiona `3` y `Enter`.
* **Resultado esperado:** Verás un nuevo menú con dos opciones:
    * **Modo Rápido (1):** Presiona `1` y `Enter`. El programa resolverá el Sudoku al instante, mostrando el tablero inicial y el final.
    * **Modo Interactivo (2):** Presiona `2` y `Enter`. El programa avanzará paso a paso. Deberás presionar `Enter` en cada paso para observar la lógica de prueba y error del algoritmo.

### 4. Opción: Salir
* **Acción en la consola:** Presiona `4` y `Enter`.
* **Resultado esperado:** El programa terminará su ejecución.

---

## ✍️ Ejemplo de Interacción
```bash
Selecciona una actividad para ejecutar:
1. Serie de Fibonacci recursiva
2. Suma de subconjuntos (Subset Sum)
3. Algoritmo de backtracking para Sudoku
4. Salir del programa
Opción: 1

--- Serie de Fibonacci Recursiva ---
Introduce un número para calcular su valor en la serie de Fibonacci: 34
El 34-ésimo número de Fibonacci es: 5702887

--- SISTEMA DE ALGORITMOS ---
Selecciona una actividad para ejecutar:
1. Serie de Fibonacci recursiva
2. Suma de subconjuntos (Subset Sum)
3. Algoritmo de backtracking para Sudoku
4. Salir del programa
Opción: 2

Probando con tus propios números? (si/no): si
--- Modo Interactivo ---
Introduce los números del conjunto, uno por uno.
Cuando termines, escribe 'listo'.
Introduce un número o 'listo': 2
Introduce un número o 'listo': 4
Introduce un número o 'listo': 6
Introduce un número o 'listo': 8
Introduce un número o 'listo': listo
Introduce el valor objetivo para la suma: 12

Iniciando la búsqueda...
----------------------------
Resultado final: ¿Existe un subconjunto que sume 12? Sí

--- SISTEMA DE ALGORITMOS ---
Selecciona una actividad para ejecutar:
1. Serie de Fibonacci recursiva
2. Suma de subconjuntos (Subset Sum)
3. Algoritmo de backtracking para Sudoku
4. Salir del programa
Opción: 3

--- Algoritmo de Backtracking para Sudoku ---
Creando un nuevo Sudoku aleatorio...

Selecciona un modo de ejecución:
1. Resolver Sudoku (modo rápido)
2. Resolver Sudoku (modo interactivo, paso a paso)
Opción: 1

Tablero inicial:
+-------+-------+-------+
| . 2 3 | 4 5 . | . . . |
| . . . | 7 8 . | . 2 . |
| . . . | . 2 3 | 4 5 6 |
+-------+-------+-------+
| . . . | . 6 5 | . . . |
| 3 . 5 | 8 . . | 2 . 7 |
| 8 . 7 | 2 . 4 | . . . |
+-------+-------+-------+
| 5 3 1 | . . . | . 7 . |
| 6 . . | . . 1 | 6 4 2 |
| 9 7 8 | . . . | 5 3 1 |
+-------+-------+-------+

Resolviendo el Sudoku en modo rápido...

Sudoku resuelto:
+-------+-------+-------+
| 1 2 3 | 4 5 6 | 7 8 9 |
| 4 5 6 | 7 8 9 | 1 2 3 |
| 7 8 9 | 1 2 3 | 4 5 6 |
+-------+-------+-------+
| 2 1 4 | 3 6 5 | 8 9 7 |
| 3 6 5 | 8 9 7 | 2 1 4 |
| 8 9 7 | 2 1 4 | 3 6 5 |
+-------+-------+-------+
| 5 3 1 | 6 4 2 | 9 7 8 |
| 6 4 2 | 9 7 8 | 5 3 1 |
| 9 7 8 | 5 1 3 | 6 4 2 |
+-------+-------+-------+
```
## 📂 Estructura del Proyecto
El proyecto está organizado de la siguiente manera:
```

├── ActividadPrincipal.java
├── FibonacciSolver.java
├── SubsetSumSolver.java
├── SudokuSolver.java
└── README.md
```
# Reflexión Final
Este proyecto demostró que la recursividad y el backtracking no son solo conceptos teóricos, sino herramientas prácticas para resolver problemas complejos. La capacidad de un algoritmo de dividirse a sí mismo en partes más pequeñas (Divide y Vencerás) o de retroceder de un error (Backtracking) es lo que permite que una computadora encuentre la solución a problemas que serían casi imposibles de resolver manualmente. Es fundamental para el desarrollo de soluciones algorítmicas robustas.

