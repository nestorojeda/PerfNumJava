import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class FileHandler {

    static ArrayList<Integer> fileToArray(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> res = new ArrayList<Integer>();

        String st;
        while ((st = br.readLine()) != null){
            res.add(Integer.parseInt(st));
        }

        return res;

    }
}

