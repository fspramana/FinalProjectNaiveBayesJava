package naive_bayes;

public class Car {

    private String buying, maint, doors, persons, lugBoot, safety, category;

    public Car(String buying, String maint, String doors, String persons, String lugBoot, String safety) {
        this.buying = buying;
        this.maint = maint;
        this.doors = doors;
        this.persons = persons;
        this.lugBoot = lugBoot;
        this.safety = safety;
    }

    public Car(String buying, String maint, String doors, String persons, String lugBoot, String safety, String cl) {
        this.buying = buying;
        this.maint = maint;
        this.doors = doors;
        this.persons = persons;
        this.lugBoot = lugBoot;
        this.safety = safety;
        this.category = cl;
    }

    public String getBuying() {
        return buying;
    }

    public void setBuying(String buying) {
        this.buying = buying;
    }

    public String getMaint() {
        return maint;
    }

    public void setMaint(String maint) {
        this.maint = maint;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getLugBoot() {
        return lugBoot;
    }

    public void setLugBoot(String lugBoot) {
        this.lugBoot = lugBoot;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
