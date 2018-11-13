import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class PerfNumJava {
    public static void main(String[] args) throws IOException {
        String path = "/home/nestorojedag/IdeaProjects/PerfNumJava/src/datafile";
        ArrayList<Integer> list = FileHandler.fileToArray(path);



        Iterator iterator = new Iterator(list);
        while (true) {
            int[] index = iterator.next();

            int sum = 0;
            for (int anIndex : index) {
                sum += anIndex;
            }

            if(PerfNum.isPerfect(sum)){
                System.out.println("La combinacion: " + Arrays.toString(index) + "genera el numero perfecto: " + sum);
            }

        }
    }
}

