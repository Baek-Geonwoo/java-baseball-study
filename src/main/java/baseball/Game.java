package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static final int ballLength = 3;
    static final String space = " ";
    static final String nothing = "낫싱";
    static final String ball = "볼";
    static final String strike = "스트라이크";
    static final String gameStart = "숫자 야구 게임을 시작합니다.";
    static final String enterNumber = "숫자를 입력해주세요 : ";
    static final String gameEnd = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private List<Integer> ans;

    public Game() {
        this.ans = new ArrayList<>();
        while (this.ans.size() < this.ballLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.ans.contains(randomNumber)) {
                this.ans.add(randomNumber);
            }
        }
    }

    public int check(List<Integer> input) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < this.ballLength; i++) {
            boolean flag = true;
            if (input.get(i) == this.ans.get(i)){
                strike++;
                flag = false;
            }
            if (flag && this.ans.contains(input.get(i))) {
                ball++;
            }
        }
        return ball*10 + strike;
    }

    public String stringResult(int result) {
        int ball = result / 10;
        int strike = result % 10;
        if (ball == 0 && strike == 0) {
            return this.nothing;
        }
        if (ball != 0 && strike != 0) {
            return ball + this.ball + this.space + strike + this.strike;
        }
        if (ball != 0) {
            return ball + this.ball;
        }
        return strike + this.strike;
    }

    public void play() {

        NumError numerr = new NumError();
        int ret = 0;
        System.out.println(this.gameStart);
        while (true){
            System.out.println(this.enterNumber);
            String input = Console.readLine();
            numerr.err(input);
            Num ball = new Num(input);
            ret = this.check(ball.getBall());
            System.out.println(this.stringResult(ret));
            if (ret == this.ballLength) {
                System.out.println(this.gameEnd);
                break;
            }
        }
    }
}
