package racinggame.car;

import nextstep.utils.Randoms;
import racinggame.Constant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
    private int getRandomValue() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }
}