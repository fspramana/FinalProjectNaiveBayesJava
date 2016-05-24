package naive_bayes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainNB {

    public static void main(String[] args) {
        try {
            Classifier cl = new Classifier();
            cl.train("E:\\Dataset\\car.data");

            BufferedReader file = new BufferedReader(new FileReader("E:\\Dataset\\carTesting.data"));
            String fileRead;
            while ((fileRead = file.readLine()) != null) {
                HashMap res = cl.classify(fileRead);
                System.out.println(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainNB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
