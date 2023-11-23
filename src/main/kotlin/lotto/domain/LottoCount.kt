package lotto.domain

data class LottoCount(val value: Int) {
    init {
        require(value >= MIN_LOTTO_COUNT) { "로또 수량의 값은 최소 0이어야 합니다. value=$value" }
    }

    operator fun minus(other: LottoCount): LottoCount {
        return LottoCount(value.minus(other.value))
    }

    companion object {
        private const val MIN_LOTTO_COUNT = 0

        fun from(price: Price): LottoCount {
            return LottoCount(price.value / Price.LOTTO_PRICE)
        }
    }
}
