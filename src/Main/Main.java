package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import Tools.FileHandler;
import Tools.Iterator;
import Tools.PerfNum;


public class Main {

    /**
     *
     * @param args - arg[0] recive the path of the file and arg[1] the number of elements to iterate with
     * @throws IOException if the file does not exist
     */
    public static void main(String[] args) throws IOException{
        String path = args[0];
        int n = Integer.parseInt(args[1]);
        ArrayList<Integer> list = FileHandler.fileToArray(path);
        long startTime = System.nanoTime();

        if (n <= list.size()) {
            Iterator iterator = new Iterator(list.size(), n);
            while (iterator.hasNext()) {
                int sum = 0;
                int[] pos = new int[n];
                int count = 0;
                boolean[] index = iterator.next();
                for (int i = 0; i < index.length; i++) {
                    if (index[i]) {
                        pos[count] = i;
                        count++;
                        sum += list.get(i);
                    }
                }

                if (PerfNum.isPerfect(sum)) {
                    System.out.println("La combinacion de las posiciones: " + Arrays.toString(pos) +
                            " genera el numero perfecto: " + sum);
                }

            }
        } else {
            System.out.println("No puede haber más valores a permutar que valores en la lista");
        }
        long endTime = System.nanoTime();
        System.out.println("Ejecución terminada en " + (endTime - startTime) + " ns");
    }
}