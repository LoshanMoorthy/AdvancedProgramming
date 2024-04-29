package simplefactory;

public class CarFactory {
    public enum CarType {
        Sedan, Convertible, Pickup
    }

    public enum FuelType {
        Gasoline, Electricity, Hybrid
    }

    public Car createCar(CarType carType, FuelType fuelType, int seats, int doors) {
        Car newCar = createCar(carType, seats, doors);

        switch (fuelType) {
            case Gasoline -> newCar.setFuel(new Gasoline());
            case Electricity -> newCar.setFuel(new Electricity());
            case Hybrid -> newCar.setFuel(new Hybrid());
            default -> {
                return null;
            }
        }

        return newCar;
    }

    public Car createCar(CarType carType, int seats, int doors) {
        Car newCar;

        switch (carType) {
            case Sedan -> newCar = new Sedan();
            case Convertible -> newCar = new Convertible();
            case Pickup -> newCar = new Pickup();
            default -> {
                return null;
            }
        }

        newCar.setDoors(doors);
        newCar.setSeats(seats);

        return newCar;
    }
}
