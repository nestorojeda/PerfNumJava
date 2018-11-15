import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PerfNumJava {
    public static void main(String[] args) throws IOException {
        System.out.println("IMPORTANTE: EL ARCHIVO DEBE TENER UN SOLO NUMERO ENTERO POR CADA LINEA");
        System.out.println("Introduce la ruta del archivo: ");
        Scanner myScanner = new Scanner(System.in);
        String path = myScanner.next();
        ArrayList<Integer> list = FileHandler.fileToArray(path);
        Iterator iterator = new Iterator(list);
        while (iterator.hasNext()) {
            int[] index = iterator.next();
            int sum = 0;
            for (int anIndex : index) {
                sum += anIndex;
            }
            if(PerfNum.isPerfect(sum)){
                System.out.println("La combinacion de las posiciones: " + Arrays.toString(index) + " genera el numero perfecto: " + sum);
            }
        }
        System.out.println("Ejecución terminada");
    }
}

