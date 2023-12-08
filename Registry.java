import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public String determineClass(Animal animal) {
        if (animal instanceof Domestic) {
            return "Domestic";
        } else if (animal instanceof Livestock) {
            return "Livestock";
        } else {
            return "Unknown";
        }
    }

    public void listCommands(Animal animal) {
        System.out.println("List of commands for " + animal.getName() + ": " + animal.getCommand());
    }

    public void teachCommands(Animal animal, String newCommands) {
        String currentCommands = animal.getCommand();
        animal.setCommand(currentCommands + ", " + newCommands);
    }

    // Example Usage
    public static void main(String[] args) {
        Registry registry = new Registry();
        Domestic dog = new Domestic("Buddy", "Sit", "2020-01-01");
        registry.addAnimal(dog);
        System.out.println("Class: " + registry.determineClass(dog));
        registry.listCommands(dog);
        registry.teachCommands(dog, "Lie Down");
        registry.listCommands(dog);
    }
}
