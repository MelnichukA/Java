public class Main {
    public static void main(String[] args)
    {
        Car car = new Car();
        Truck truck = new Truck();
 
        //Car!
        //pasajur
        car.setPTime(25.5);
        car.setPPrice(250);
        car.setPWeight(1050);
 
        //gryzovui
        car.setWTime(34.2);
        car.setWPrice(300);
        car.setWWeight(5000);
        //\Car!

        //Truck!
        //pasajur
        truck.setPTime(45.5);
        truck.setPPrice(250);
        truck.setPWeight(100);
 
        //gryzovui
        truck.setWTime(54.2);
        truck.setWPrice(390);
        truck.setWWeight(207);
        //\Truck!
 
 
        System.out.println("Car: ");
        System.out.println("Pasajur time: " + car.getPTime());
        System.out.println("Pasajur price: " + car.getPPrice());
        System.out.println("Pasajur weight: " + car.getPWeight());
 
        System.out.println("--------------------------------------");
 
        System.out.println("Gryz time: " + car.getWTime());
        System.out.println("Gryz price: " + car.getWPrice());
        System.out.println("Gryz weight: " + car.getWWeight());
 
        System.out.println();
       
        System.out.println("Truck: ");
        System.out.println("Pasajur time: " + truck.getPTime());
        System.out.println("Pasajur price: " + truck.getPPrice());
        System.out.println("Pasajur weight: " + truck.getPWeight());
 
        System.out.println("--------------------------------------");
 
        System.out.println("Gryz time: " + truck.getWTime());
        System.out.println("Gryz price: " + truck.getWPrice());
        System.out.println("Gryz weight: " + truck.getWWeight());
    }
 
}
