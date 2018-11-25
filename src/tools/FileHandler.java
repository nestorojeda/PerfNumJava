package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Return a list with the content of the file.
     *
     * @param path - path of the file to use
     * @return a list with the content of the file
     * @throws IOException if the file does not exist
     */
    public static ArrayList<Integer> fileToArray(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> res = new ArrayList<>();

        String st;
        while ((st = br.readLine()) != null) {
            res.add(Integer.parseInt(st));
        }

        return res;
    }
}