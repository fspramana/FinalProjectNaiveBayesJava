package naive_bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CarDao {

    private ArrayList<Car> list;

    public CarDao(String datasetPath) throws Exception {
        list = new ArrayList<>();

        File file = new File(datasetPath);
        BufferedReader rd = new BufferedReader(new FileReader(file));

        String line;
        /*
        buying       v-high, high, med, low
        maint        v-high, high, med, low
        doors        2, 3, 4, 5-more
        persons      2, 4, more
        lug_boot     small, med, big
        safety       low, med, high
         */

        while ((line = rd.readLine()) != null) {
            String[] dataArray = line.split(",");
            Car c = null;
            if (dataArray.length == 7) {
                c = new Car(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6]);
            } else if (dataArray.length == 6) {
                c = new Car(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
            }

            list.add(c);
        }

    }

    public ArrayList<Car> all() {
        return list;
    }

}
