// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// GoodsBogey Class
class GoodsBogey {

    private String shape;      // Rectangular or Cylindrical
    private String cargoType;  // Assigned cargo

    public GoodsBogey(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {

        try {
            System.out.println("\nAttempting to assign cargo: " + cargo + " to " + shape + " bogie");

            // 🚨 Safety validation
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Cargo Assignment: Petroleum cannot be loaded in Rectangular bogie!"
                );
            }

            // ✅ Safe assignment
            this.cargoType = cargo;
            System.out.println("Cargo assigned successfully.");

        } catch (CargoSafetyException e) {

            // ❌ Handle exception gracefully
            System.out.println("ERROR: " + e.getMessage());

        } finally {

            // 🔁 Always executes
            System.out.println("Cargo assignment process completed.");
        }
    }

    public void displayDetails() {
        System.out.println("Bogie Shape: " + shape);
        System.out.println("Cargo: " + (cargoType != null ? cargoType : "None"));
    }
}

// Main Class (Entry Point)
public class Main {

    public static void main(String[] args) {

        // 🚂 Create bogies
        GoodsBogey bogie1 = new GoodsBogey("Cylindrical");
        GoodsBogey bogie2 = new GoodsBogey("Rectangular");

        // ✅ Safe assignment
        bogie1.assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled safely)
        bogie2.assignCargo("Petroleum");

        // ✅ Program continues after exception
        bogie2.assignCargo("Coal");

        // 📊 Display final status
        System.out.println("\nFinal Bogie Status:");
        bogie1.displayDetails();
        bogie2.displayDetails();

        System.out.println("\nProgram continues without crashing.");
    }
}