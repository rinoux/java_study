package cc.rinoux.algorithms.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rinoux on 2017/5/31.
 */
public class BallShootGame {

    private int basketSum;
    private List<Basket> baskets = new ArrayList<>();
    private List<Ball> balls = new ArrayList<>();

    public BallShootGame(int basketSum, int ballSum) {
        this.basketSum = basketSum;
        for (int i = 0; i < basketSum; i++) {
            baskets.add(new Basket(i));
        }

        for (int i = 1; i < ballSum + 1; i++) {
            balls.add(new Ball(i));
        }
    }

    public int shoot(int ballNumber) {
        if (balls.size() > 0 && basketSum > 0) {
            balls.remove(new Ball(ballNumber));

            int targetBasket = ballNumber % basketSum;
            if (targetBasket < basketSum) {
                if (baskets.get(targetBasket).ballIn) {
                    return ballNumber;
                } else {
                    Basket basket = baskets.remove(targetBasket);
                    basket.setBallIn(new Random().nextBoolean());
                    baskets.add(basket);
                    shoot(ballNumber + 1);
                }
            }
        }
        return -1;
    }


    private class Basket {
        int num;
        boolean ballIn = false;

        Basket(int num) {
            this.num = num;
            this.ballIn = false;
        }


        void setBallIn(boolean ballIn) {
            this.ballIn = ballIn;
        }
    }

    private class Ball {
        int num;

        Ball(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {

        System.out.println(new BallShootGame(300, 200).shoot(1));
    }
}
