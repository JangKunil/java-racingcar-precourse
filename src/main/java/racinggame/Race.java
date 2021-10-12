package racinggame;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Console;

import racinggame.car.Car;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();

    public Race() {
        generateCars();
    }

    private void generateCars() {
        System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);


        String input = Console.readLine();
        String[] cars = input.split(",");

        for (String carName : cars) {
            Car car = new Car(carName.trim());
            allRacingCars.add(car);
        }
    }
}