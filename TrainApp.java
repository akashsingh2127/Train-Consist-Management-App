import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Grain"));

        boolean isSafe = bogies.stream()
                               .allMatch(b -> 
                                   b.type.equals("Cylindrical") 
                                   ? b.cargo.equals("Petroleum") 
                                   : true
                               );

        if (isSafe) {
            System.out.println("Train is safety compliant.");
        } else {
            System.out.println("Train is NOT safety compliant.");
        }
    }
}