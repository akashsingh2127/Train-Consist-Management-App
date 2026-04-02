// Custom Exception
class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    String name;
    int capacity;

    PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for bogie: " + name);
        }
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Bogie created: " + b1.name + " - " + b1.capacity);

            PassengerBogie b2 = new PassengerBogie("AC Chair", -10);
            System.out.println("Bogie created: " + b2.name + " - " + b2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }
    }
}