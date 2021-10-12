package racinggame;

import nextstep.utils.Randoms;
import racinggame.Constant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
    int getRandomValue() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }

    void forward(int value) {
        if (value >= Constant.FORWARD_CONDITION) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}