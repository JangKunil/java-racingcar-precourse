package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();
    private int raceNumber;
    private int leadPosition = 0;

    public Race() {
        generateCars();
        decideRaceNumber();
        raceStart();
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

    private void raceStart() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < raceNumber; i++) {
            driveCar();
            printResult();
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

    private void driveCar() {
        for (Car car : allRacingCars) {
            int value = car.getRandomValue();
            car.forward(value);

            updateLeadPosition(car.getPosition());
        }
    }

    private void updateLeadPosition(int position) {
        if (leadPosition < position) {
            this.leadPosition = position;
        }
    }

    private void printResult() {
        for (Car car : allRacingCars) {
            System.out.print(car.getName() + " : ");

            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void checkRightCarName(String[] cars) {
        if (!CarValidation.carNameValidation(cars)) {
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME);
        }
    }

    private void carRegistration(String[] cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            allRacingCars.add(car);
        }
    }

    private void checkRightNumber(String number) {
        if (!CarValidation.raceNumberValidation(number)) {
            throw new IllegalArgumentException(Constant.ERROR_RACE_NUMBER);
        }
    }
}