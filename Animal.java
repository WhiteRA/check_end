public class Animal {
    private String name;
    private String command;
    private String birthDate;

    public Animal(String name, String command, String birthDate) {
        this.name = name;
        this.command = command;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
