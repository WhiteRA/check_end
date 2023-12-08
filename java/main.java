
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            registry.showMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter animal name: ");
                    String name = scanner.next();
                    System.out.print("Enter animal command: ");
                    String command = scanner.next();
                    System.out.print("Is it a (1) Domestic or (2) Livestock animal? Enter 1 or 2: ");
                    int typeChoice = scanner.nextInt();

                    if (typeChoice == 1) {
                        registry.addAnimal(new Domestic(name, command));
                    } else if (typeChoice == 2) {
                        registry.addAnimal(new Livestock(name, command));
                    } else {
                        System.out.println("Invalid choice. Please choose 1 or 2.");
                    }
                    break;
                case 2:
                    System.out.print("Enter animal name to determine its class: ");
                    String animalName = scanner.next();
                    Animal targetAnimal = null;
                    for (Animal animal : registry.animals) {
                        if (animal.getName().equals(animalName)) {
                            targetAnimal = animal;
                            break;
                        }
                    }
                    if (targetAnimal != null) {
                        System.out.println(targetAnimal.getName() + " is a " + registry.determineClass(targetAnimal)
                                + " animal.");
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter animal name to list its commands: ");
                    String commandAnimalName = scanner.next();
                    Animal commandAnimal = null;
                    for (Animal animal : registry.animals) {
                        if (animal.getName().equals(commandAnimalName)) {
                            commandAnimal = animal;
                            break;
                        }
                    }
                    if (commandAnimal != null) {
                        registry.listCommands(commandAnimal);
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter animal name to teach new commands: ");
                    String teachAnimalName = scanner.next();
                    Animal teachAnimal = null;
                    for (Animal animal : registry.animals) {
                        if (animal.getName().equals(teachAnimalName)) {
                            teachAnimal = animal;
                            break;
                        }
                    }
                    if (teachAnimal != null) {
                        System.out.print("Enter new commands to teach: ");
                        String newCommands = scanner.next();
                        registry.teachCommands(teachAnimal, newCommands);
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Animal Registry. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 5.");
            }
        }
    }
}
