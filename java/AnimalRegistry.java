import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    List<Animal> animals = new ArrayList<>();
    private Counter counter = new Counter();

    public void addAnimal(Animal animal) {
        try (Counter c = new Counter()) {
            c.openResource();
            counter.add(); // Увеличиваем счетчик при добавлении нового животного
            animals.add(animal);
            System.out.println("New animal added: " + animal.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        System.out.println(animal.getName() + " has learned new commands: " + newCommands);
    }

    public void showMenu() {
        System.out.println("\n===== Animal Registry Menu =====");
        System.out.println("1. Add new animal");
        System.out.println("2. Determine animal class");
        System.out.println("3. List commands for an animal");
        System.out.println("4. Teach new commands to an animal");
        System.out.println("5. Exit");
        System.out.println("===============================\n");
    }
}
