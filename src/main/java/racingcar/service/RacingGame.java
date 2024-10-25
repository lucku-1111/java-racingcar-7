package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter((car) -> {
                    return car.getPosition() == maxPosition;
                })
                .toList();
    }
}
