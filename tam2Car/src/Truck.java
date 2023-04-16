public class Truck extends Car {
    private double weight ;
    private String loadName ;
    private double loadPricePerWeight ;


    public Truck (double speed, double price, String color, String name, String brand,
                  double weight, String loadName, double loadPricePerWeight) {
        super(speed, price, color, name, brand);
        this.weight = weight ;
        this.loadName = loadName ;
        this.loadPricePerWeight = loadPricePerWeight ;
    }

    public String showInfo() {
        return super.showInfo()+" Truck {" +
                "weight=" + weight +
                ", loadName='" + loadName + '\'' +
                ", loadPricePerWeight=" + loadPricePerWeight +
                '}';
    }

    public double calPrice () {
        return super.price + (weight * loadPricePerWeight );
    }

}
