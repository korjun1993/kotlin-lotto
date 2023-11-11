package lotto.domain

enum class LottoReward(val matchCount: Int, val reward: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        fun valueOf(matchCount: Int): LottoReward? =
            values().find { it.matchCount == matchCount }
    }
}
