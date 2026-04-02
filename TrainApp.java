import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        List<Bogie> filteredBogies = bogies.stream()
                                           .filter(b -> b.capacity > 60)
                                           .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");

        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " : " + b.capacity);
        }
    }
}