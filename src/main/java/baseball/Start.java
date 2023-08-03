package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Start {
    static final String end = "1";
    static final String continueQuestion = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public void start() {
        String end = this.end;
        EndError enderr = new EndError();
        while(end.equals(this.end)) {
            Game G = new Game();
            G.play();
            System.out.println(this.continueQuestion);
            end = Console.readLine();
            enderr.err(end);
        }
    }
}
