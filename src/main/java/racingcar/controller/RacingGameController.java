package racingcar.controller;

import racingcar.domain.InputParser;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RacingGameController {
    public void run() {
        List<String> carNames = InputParser.parseCarNames(InputView.getCarNames());
        int rounds = InputParser.parseRounds(InputView.getRounds());

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < rounds; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
