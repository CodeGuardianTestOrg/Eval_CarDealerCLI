public class Car {
    public String brand;
    public String model;
    public int year;
    public double price;
    public int ownerId;

    public Car(String b, String m, int y, double p, int o) {
        this.brand = b;
        this.model = m;
        this.year = y;
        this.price = p;
        this.ownerId = o;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public void setModel(String m) {
        this.model = m;
    }

    public void setYear(int y) {
        this.year = y;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public void setOwnerId(int o) {
        this.ownerId = o;
    }
}