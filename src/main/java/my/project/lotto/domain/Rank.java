package my.project.lotto.domain;

import java.util.Arrays;

/**
 * Created : 2020-11-27 오후 4:34
 * Developer : Seo
 */
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        validate(matchCount);

        if (SECOND.matchCount(matchCount) && matchBonus) {
            return SECOND;
        }
        if (THIRD.matchCount(matchCount) && !matchBonus) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(matchCount))
                .findFirst()
                .orElse(NO_RANK);
    }

    private static void validate(int matchCount) {
        if (matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException(Lotto.LOTTO_NUMBERS_HAVE_SIX);
        }
    }

    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

}