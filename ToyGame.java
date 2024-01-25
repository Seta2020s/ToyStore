import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ToyGame {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Конструктор", 2));
        toyStore.addToy(new Toy(2, "Робот", 3));
        toyStore.addToy(new Toy(3, "Кукла", 6));
        
        try (FileWriter writer = new FileWriter("output.txt")) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                Toy selectedToy = toyStore.getToy();
                if (selectedToy != null) {
                    writer.write("Selected Toy: " + selectedToy.getName() + ", Weight: " + selectedToy.getWeight() + "\n");
                    System.out.println("Selected Toy: " + selectedToy.getName() + ", Weight: " + selectedToy.getWeight());
                } else {
                    System.out.println("В магазине не осталось игрушек");
                    break;
                }

                int randomValue = random.nextInt(100);
                if (randomValue < 20) {
                    toyStore.addToy(new Toy(1, "Конструктор", 1));
                } else if (randomValue < 40) {
                    toyStore.addToy(new Toy(2, "Робот", 2));
                } else {
                    toyStore.addToy(new Toy(3, "Кукла", 3));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}