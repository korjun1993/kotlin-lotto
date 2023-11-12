package lotto.domain

enum class LottoReward(val matchCount: Int, val bonusMatch: Boolean, val reward: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        fun valueOf(matchCount: Int, bonusMatch: Boolean): LottoReward? =
            values().find { it.matchCount == matchCount && it.bonusMatch == bonusMatch }
    }
}
