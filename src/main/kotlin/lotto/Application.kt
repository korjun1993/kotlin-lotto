package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val price = Price(readPrice())

    val totalLottoCount = LottoCount.from(price)
    val lottoManualCount = LottoCount(readManualLottoCount())
    val lottoAutoCount = totalLottoCount - lottoManualCount

    val lottoManualList = LottoFactory.generateLottoList(readLottoNumbers(lottoManualCount))
    val lottoAutoList = LottoFactory.generateLottoList(lottoAutoCount)
    val lottoTotalList = lottoManualList + lottoAutoList
    printLottoList(lottoManualList, lottoAutoList)

    val winningNumbers = WinningNumbers(
        LottoNumbers(readWinningNumbers().map { LottoNumber(it) }.toSet()),
        LottoNumber(readBonusNumber())
    )
    val lottoGame = LottoGame(lottoTotalList)
    val lottoGameResult = lottoGame.getResult(winningNumbers)
    printLottoGameResult(lottoGameResult)
}

