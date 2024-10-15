import java.util.ArrayList;
import java.util.Scanner;

public class AutoManager {
    ArrayList<Car> cars = new ArrayList();
    ArrayList<Owner> owners = new ArrayList();
    Scanner scan = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1. Auto hinzufügen");
            System.out.println("2. Autos anzeigen");
            System.out.println("3. Auto bearbeiten");
            System.out.println("4. Auto löschen");
            System.out.println("5. Besitzer hinzufügen");
            System.out.println("6. Besitzer anzeigen");
            System.out.println("7. Suchen");
            System.out.println("8. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int option = scan.nextInt();
            if (option == 1) {
                addCar();
            } else if (option == 2) {
                showCars();
            } else if (option == 3) {
                editCar();
            } else if (option == 4) {
                deleteCar();
            } else if (option == 5) {
                addOwner();
            } else if (option == 6) {
                showOwners();
            } else if (option == 7) {
                search();
            } else if (option == 8) {
                break;
            } else {
                System.out.println("Ungültige Option");
            }
        }
    }

    public void addCar() {
        System.out.print("Marke: ");
        String brand = scan.next();
        System.out.print("Modell: ");
        String model = scan.next();
        System.out.print("Baujahr: ");
        int year = scan.nextInt();
        System.out.print("Preis: ");
        double price = scan.nextDouble();
        System.out.print("Besitzer ID: ");
        int ownerId = scan.nextInt();
        Car newCar = new Car(brand, model, year, price, ownerId);
        cars.add(newCar);
    }

    public void showCars() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = (Car) cars.get(i);
            System.out.println("Auto " + i + ": " + car.brand + " " + car.model + ", " + car.year + " Jahre alt, Preis: " + car.price + "€, Besitzer ID: " + car.ownerId);
        }
    }

    public void editCar() {
        System.out.print("Geben Sie die Auto-ID ein: ");
        int id = scan.nextInt();
        if (id < 0 || id >= cars.size()) {
            System.out.println("Ungültige Auto-ID");
            return;
        }
        Car car = (Car) cars.get(id);
        System.out.print("Neue Marke: ");
        String brand = scan.next();
        System.out.print("Neues Modell: ");
        String model = scan.next();
        System.out.print("Neues Baujahr: ");
        int year = scan.nextInt();
        System.out.print("Neuer Preis: ");
        double price = scan.nextDouble();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);
    }

    public void deleteCar() {
        System.out.print("Geben Sie die Auto-ID ein: ");
        int id = scan.nextInt();
        if (id < 0 || id >= cars.size()) {
            System.out.println("Ungültige Auto-ID");
            return;
        }
        cars.remove(id);
        System.out.println("Auto gelöscht.");
    }

    public void addOwner() {
        System.out.print("Name des Besitzers: ");
        String name = scan.next();
        System.out.print("Kontakt: ");
        String contact = scan.next();
        Owner newOwner = new Owner(name, contact);
        owners.add(newOwner);
    }

    public void showOwners() {
        for (int i = 0; i < owners.size(); i++) {
            Owner owner = (Owner) owners.get(i);
            System.out.println("Besitzer " + i + ": " + owner.name + ", Kontakt: " + owner.contact);
        }
    }

    public void search() {
        System.out.print("Suchen nach Marke oder Modell: ");
        String query = scan.next();
        for (int i = 0; i < cars.size(); i++) {
            Car car = (Car) cars.get(i);
            if (car.brand.equalsIgnoreCase(query) || car.model.equalsIgnoreCase(query)) {
                System.out.println("Gefunden: Auto " + i + ": " + car.brand + " " + car.model + ", " + car.year + " Jahre alt, Preis: " + car.price + "€, Besitzer ID: " + car.ownerId);
            }
        }
    }
}