package naive_bayes;

import java.util.ArrayList;
import java.util.HashMap;

public class Classifier {

    private double probUnacc, probAcc, probGood, probVgood;

    int countUnacc = 0;
    int countAcc = 0;
    int countGood = 0;
    int countVgood = 0;

    ArrayList<Car> listCarTraining;

    public void train(String dataTrainingPath) throws Exception {
        CarDao dao = new CarDao(dataTrainingPath);
        listCarTraining = dao.all();

        // count probUnacc
        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase("unacc")) {
                countUnacc++;
            }
        }
        probUnacc = (double)countUnacc / (double)listCarTraining.size();

        // count probAcc
        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase("acc")) {
                countAcc++;
            }
        }
        probAcc = (double)countAcc / (double)listCarTraining.size();

        // count probGood
        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase("good")) {
                countGood++;
            }
        }
        probGood = (double)countGood / (double)listCarTraining.size();

        // count probVgood
        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase("vgood")) {
                countVgood++;
            }
        }
        probVgood = (double)countVgood / (double)listCarTraining.size();

    }

    private double countBuyingLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getBuying().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }

    private double countMaintLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getMaint().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }

    private double countDoorsLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getDoors().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }

    private double countPersonsLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getPersons().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }

    private double countLugBootLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getLugBoot().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }

    private double countSafetyLikelihood(String category, String val) {
        int count = 0;
        int countCategory = 0;

        if (category.equalsIgnoreCase("unacc")) {
            countCategory = countUnacc;
        } else if (category.equalsIgnoreCase("acc")) {
            countCategory = countAcc;
        } else if (category.equalsIgnoreCase("good")) {
            countCategory = countGood;
        } else if (category.equalsIgnoreCase("vgood")) {
            countCategory = countVgood;
        }

        for (Car car : listCarTraining) {
            if (car.getCategory().equalsIgnoreCase(category) && car.getSafety().equalsIgnoreCase(val)) {
                count++;
            }
        }

        return (double)count / (double)countCategory;
    }
    
    public HashMap classify(String data) {
        String[] explData = data.split(",");
        double probUnacc = countBuyingLikelihood("unacc", explData[0]) * 
                countMaintLikelihood("unacc", explData[1]) * 
                countPersonsLikelihood("unacc", explData[3]) * 
                countDoorsLikelihood("unacc", explData[2]) * 
                countSafetyLikelihood("unacc", explData[5]) * 
                countLugBootLikelihood("unacc", explData[4]);
        
        double probAcc = countBuyingLikelihood("acc", explData[0]) * 
                countMaintLikelihood("acc", explData[1]) * 
                countPersonsLikelihood("acc", explData[3]) * 
                countDoorsLikelihood("acc", explData[2]) * 
                countSafetyLikelihood("acc", explData[5]) * 
                countLugBootLikelihood("acc", explData[4]);
        
        double probGood = countBuyingLikelihood("good", explData[0]) * 
                countMaintLikelihood("good", explData[1]) * 
                countPersonsLikelihood("good", explData[3]) * 
                countDoorsLikelihood("good", explData[2]) * 
                countSafetyLikelihood("good", explData[5]) * 
                countLugBootLikelihood("good", explData[4]);
        
        double probVgood = countBuyingLikelihood("vgood", explData[0]) * 
                countMaintLikelihood("vgood", explData[1]) * 
                countPersonsLikelihood("vgood", explData[3]) * 
                countDoorsLikelihood("vgood", explData[2]) * 
                countSafetyLikelihood("vgood", explData[5]) * 
                countLugBootLikelihood("vgood", explData[4]);
        
        double[] probs = {probUnacc, probAcc, probGood, probVgood};
        String[] cats = {"unacc", "acc", "good", "vgood"};
        
        double max = -99999999;
        String cat = null;
        
        HashMap<String, Object> map = new HashMap<>();
        
        for (int i = 0 ; i < probs.length ; i++) {
            if (probs[i] > max) {
                max = probs[i];
                cat = cats[i];
            }
        }
        
        map.put("category", cat);
        map.put("probability", max);
        
        return map;
        
    }

}
