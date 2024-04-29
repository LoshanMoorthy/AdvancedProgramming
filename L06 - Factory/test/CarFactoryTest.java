import org.junit.jupiter.api.Test;
import simplefactory.*;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void test_createCar_ReturnCorrectType() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car sedan,convertibel,pickup;


        //ACT
        sedan = carFactory.createCar(CarFactory.CarType.Sedan,0,0);
        convertibel = carFactory.createCar(CarFactory.CarType.Convertible,0,0);
        pickup = carFactory.createCar(CarFactory.CarType.Pickup,0,0);


        //ASSERT
        assertEquals(0,sedan.getSeats());
        assertEquals(0,convertibel.getSeats());
        assertInstanceOf(Sedan.class, sedan);
        assertInstanceOf(Convertible.class, convertibel);
        assertInstanceOf(Pickup.class, pickup);


    }

    @Test
    void test_createCar_ReturnCorrect_SeatsAndDors() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car sedan,convertibel,pickup;


        //ACT
        sedan = carFactory.createCar(CarFactory.CarType.Sedan,0,0);
        convertibel = carFactory.createCar(CarFactory.CarType.Convertible,2,2);
        pickup = carFactory.createCar(CarFactory.CarType.Pickup,4,4);


        //ASSERT
        assertInstanceOf(Sedan.class, sedan);
        assertInstanceOf(Convertible.class, convertibel);
        assertInstanceOf(Pickup.class, pickup);
    }

    @Test
    void test_createCar_ReturnFuelType() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car car;


        //Act & Assert
        car = carFactory.createCar(CarFactory.CarType.Sedan, CarFactory.FuelType.Gasoline,0,0);
        assertInstanceOf(Gasoline.class, car.getFuel());
        car = carFactory.createCar(CarFactory.CarType.Sedan, CarFactory.FuelType.Electricity,0,0);
        assertInstanceOf(Electricity.class, car.getFuel());
        car = carFactory.createCar(CarFactory.CarType.Sedan, CarFactory.FuelType.Hybrid,0,0);
        assertInstanceOf(Hybrid.class, car.getFuel());
    }
}