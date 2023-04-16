public class Car {
    protected double speed ;
    protected double price ;
    protected String color ;
    protected String name ;
    protected String brand ;

    public Car(double speed, double price, String color, String name, String brand) {
        this.speed = speed;
        this.price = price;
        this.color = color;
        this.name = name;
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String showInfo() {
        return "Car {" +
                "speed=" + speed +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

}
