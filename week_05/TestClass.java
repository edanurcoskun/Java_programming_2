package week_05;
// java_homework # 2

abstract class Android {

    private String model;
    private String owner;

    protected Android(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public abstract String move();
}

class HumanAndroid extends Android {

    public HumanAndroid(String model) {
        super(model); 
    }

    @Override
    public String move() {
        String stringOfMove = "THE HUMAN IS WALKING.";
        return stringOfMove;
    }
}

class DogAndroid extends Android implements Cloneable {

    public DogAndroid(String model) {
        super(model); 
    }

    @Override
    public String move() {
        String stringOfMove = "THE DOG IS RUNNING.";
        return stringOfMove;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}

public class TestClass {

    public static void main(String[] args) {
        String human = "MAN";
        String dog = "HUSKY";
        Android[] model = new Android[2];
        model[0] = new DogAndroid(dog);
        model[1] = new HumanAndroid(human);

        
        System.out.println("The " + model[0].getModel() + " dog android model is moving: "
                + model[0].move());
        System.out.println("The " + model[1].getModel() + " human android model is moving: "
                + model[1].move());
    }
}
