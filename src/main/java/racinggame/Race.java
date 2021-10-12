package racinggame;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Console;

import racinggame.car.Car;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();
    private int raceNumber;

    public Race() {
        generateCars();
        decideRaceNumber();
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

    private void decideRaceNumber() {
        while (true) {
            System.out.println(Constant.RACE_NUMBER_INPUT_MESSAGE);

            try {
                String number = Console.readLine();

                checkRightNumber(number);
                this.raceNumber = Integer.parseInt(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkRightNumber(String number) {

    }
}