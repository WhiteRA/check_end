public class Example {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            // Завести новое животное
            counter.add();
            // Другие операции
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
