package baseball;

import baseball.core.Computer;
import baseball.core.Core;
import baseball.core.Player;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.MessageConstant.*;

public class Baseball {
    private final Core core = new Core();
    private final Player player = new Player();
    private final Computer computer = new Computer();
    private List<Integer> computerNumber;

    public void startBaseball() {
        System.out.println(START_BASEBALL_MSG);
        computerNumber = computer.getComputerNumber();
        boolean startFlag = true;

        while(startFlag) {
            System.out.print(PLEASE_INPUT_MSG);
            List<Integer> playerNumber = player.getPlayerNumber();
            int strikeCount = core.countStrike(computerNumber, playerNumber);
            int ballCount = core.countBall(computerNumber, playerNumber);
            core.printBaseballResult(strikeCount, ballCount);
            startFlag = checkBaseballEnd(strikeCount);
        }

    }

    public boolean checkBaseballEnd(int strike) {
        if(strike == MAX_STRIKE) {
            System.out.println(END_BASEBALL_MSG);
            System.out.println(RESTART_OR_EXIT_MSG);
            return isRestartOrExit();
        }
        return true;
    }

    public boolean isRestartOrExit() {
        int choice = player.getRestartOrExitNumber();

        if (choice == RESTART_NUM) {
            computerNumber = computer.getComputerNumber();
            return true;
        }

        return false;
    }

}