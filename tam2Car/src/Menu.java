import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
   private ArrayList<Car> carList = new ArrayList<>();
    Scanner mySc = new Scanner(System.in) ;

    public static void main(String[] args) {
        ///////////////////////
        System.out.println("hi");
        System.out.println("hi again");
        ///////////////////////

        Menu menu = new Menu();

        Scanner mySc = new Scanner(System.in) ;
        int choice ;
        do {
            System.out.println("-----Menu-----");
            System.out.println("""
                    1)Add a new vehicle
                    2)show all the vehicles
                    3)Show Car/Truck info
                    4)show Car/Truck price
                    5)Truck price + load price
                    6)Exit""");
            System.out.print("choose an option : ");
             choice = mySc.nextInt();

            switch (choice) {
                case 1:
                    menu.addCar();
                    break;

                case 2:
                    if (menu.carList.isEmpty())
                        System.out.println("Your car list is empty ! ");
                    else {
                        System.out.println("-----My car list-----\n__________________________ ");
                        for (Car i : menu.carList) {
                            System.out.println(i.showInfo());
                            System.out.println("________________________________");
                        }
                    }
                    break;

                case 3:
                    System.out.println(menu.findVehicle().showInfo());
                    break;

                case 4:
                    System.out.println("price is: "+ menu.findVehicle().getPrice()) ;
                    break;

                case 5 :
                    Truck truck = (Truck) menu.findVehicle();
                    System.out.println(truck.calPrice());
                    break;

                case 6:
                    System.out.println("bye bye!");
                    break;

                default:
                    System.out.println("**invalid option**");

            }
        }while (choice != 6) ;

    }

    private boolean nameFound(String name) {
        for (Car i : carList) {
            if (i.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addCar() {

        System.out.print("1)add a new Car\n2)add a new Truck\nchoose: ");
        int choice2 = mySc.nextInt();
        while (choice2 !=1 && choice2!=2 ) {
            System.out.print("invalid option try again : ");
            choice2 = mySc.nextInt();}

        System.out.print("Enter brand : ");
        mySc.nextLine();
        String newBrand = mySc.nextLine();
        System.out.print("Enter speed : ");
        double newSpeed = mySc.nextDouble();
        System.out.print("Enter price : ");
        double newPrice = mySc.nextDouble();
        System.out.print("Enter color : ");
        mySc.nextLine();
        String newColor = mySc.nextLine();
        System.out.print("Enter name(it should be unique) : ");
        String newName = mySc.nextLine() ;

        while (nameFound(newName)) {
            System.out.print("there is already a vehicle with this name\nEnter again : ");
            newName = mySc.nextLine();}

        if(choice2 == 1) { //car
            Car newCar = new Car(newSpeed, newPrice, newColor, newName, newBrand);
            carList.add(newCar);
            System.out.println("Car added to your list");}

        else { //truck
            System.out.print("for Truck -> Enter weight : ");
            double newWeight = mySc.nextDouble() ;
            System.out.print("for Truck -> Enter load name : ");
            mySc.nextLine();
            String newLoadName = mySc.nextLine();
            System.out.print("for Truck -> Enter load price per weight : ");
            double newLPPW = mySc.nextDouble();

            Truck newTruck = new Truck(newSpeed, newPrice, newColor, newName, newBrand,
                    newWeight, newLoadName, newLPPW) ;
            carList.add(newTruck) ;
            System.out.println("Truck added to your list");}
    }

    public Car findVehicle() {
        Car result = null ;
        System.out.print("Enter the name of vehicle : ");
        String name = mySc.nextLine();
        while (! nameFound(name)) {
            System.out.print("there is no vehicle with this name\ntry again : ");
            name = mySc.nextLine();
        }
        for (Car vehicle: carList) {
            if(vehicle.getName().equals(name))
                result = vehicle ;
        }
        return result ;
    }

}
