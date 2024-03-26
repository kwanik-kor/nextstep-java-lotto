package lotto.domain.rank;

import lotto.domain.purchase.Cash;
import lotto.error.ErrorCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NEXT_CHANCE(0, false, 0L),
    ;

    private final MatchCondition matchCondition;
    private final Cash winnings;

    Rank(int matchCount, boolean needBonusMatch, long winnings) {
        this.matchCondition = new MatchCondition(matchCount, needBonusMatch);
        this.winnings = new Cash(winnings);
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        return valueOf(new LottoMatchCount(matchCount), new BonusMatch(bonusMatch));
    }

    public static Rank valueOf(LottoMatchCount matchCount, BonusMatch bonusMatch) {
        assertMatchCountLessThanFirstPrize(matchCount);

        return Arrays.stream(values())
                .filter(type -> type.match(matchCount, bonusMatch))
                .findFirst()
                .orElse(Rank.NEXT_CHANCE);
    }

    public static List<Rank> winRanks() {
        return Arrays.stream(values())
                .filter(Rank::isWinningsGreaterThanZero)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static void assertMatchCountLessThanFirstPrize(LottoMatchCount matchCount) {
        if (FIRST.matchCondition.smallerMatchCountThan(matchCount)) {
            throw new IllegalArgumentException(ErrorCode.RANK_OVER_MAX_MATCH_COUNT.message());
        }
    }

    private boolean match(LottoMatchCount matchCount, BonusMatch bonusMatch) {
        return this.matchCondition.match(matchCount, bonusMatch);
    }

    private boolean isWinningsGreaterThanZero() {
        return this.winnings.greaterThanZero();
    }

    public int matchCount() {
        return this.matchCondition.matchCount();
    }

    public Cash winnings() {
        return this.winnings;
    }

    public boolean needBonusMatch() {
        return this.matchCondition.needBonusMatch();
    }

}
