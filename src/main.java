import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("IMPORTANTE: EL ARCHIVO DEBE TENER UN SOLO NUMERO ENTERO POR CADA LINEA");
        System.out.println("Introduce la ruta del archivo: ");
        Scanner myScanner = new Scanner(System.in);
        String path = myScanner.next();
        long startTime = System.nanoTime();
        ArrayList<Integer> list = FileHandler.fileToArray(path);
        Iterator iterator = new Iterator(list);
        while (iterator.hasNext()) {
            int[] index = iterator.next();
            int sum = list.get(index[0]) + list.get(index[1]);
            if(PerfNum.isPerfect(sum)){
                System.out.println("La combinacion de las posiciones: " + Arrays.toString(index) + " genera el numero perfecto: " + sum);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Ejecución terminada en " +(endTime - startTime) + " ns");
    }
}

