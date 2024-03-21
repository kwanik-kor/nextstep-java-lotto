package lotto.view;

import utils.Splitter;
import utils.StringUtils;

import java.util.Scanner;

import static lotto.view.MyPrinter.printLine;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int purchasePrice() {
        printLine(Announcements.PURCHASE_PRICE);
        return nextIntAndRemoveLineChange();
    }

    public static String[] lastWeekWinningNumbers() {
        printLine(Announcements.LAST_WEEK_WINNING_NUMBERS);
        String lastWeekNumbers = SCANNER.nextLine();
        return Splitter.byComma(StringUtils.removeSpace(lastWeekNumbers));
    }

    private static int nextIntAndRemoveLineChange() {
        final int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }

    private abstract static class Announcements {
        static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
        static final String LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    }
}
