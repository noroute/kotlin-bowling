data class BowlingGame(private val frameString: String) {

    private val FRAMES_PER_GAME = 10
    private val SPARE = '/'
    private val STRIKE = 'X'

    private val rolls: String
    private val isComplete: Boolean

    init {
        isComplete = frameString.split(",").size == FRAMES_PER_GAME
        rolls = frameString.filter { c -> c != ',' }
    }

    fun score() =
        if (isComplete)
            rolls.mapIndexed { i, _ -> scoreForRoll(i) }.sum()
        else
            throw IllegalStateException("Incomplete game")

    private fun scoreForRoll(index: Int) =
        valueForRoll(index) + bonusForRoll(index)

    private fun valueForRoll(index: Int): Int =
        when (rolls[index]) {
            in '0'..'9' -> pinsDown(index)
            SPARE -> pinsLeftFromPreviousSpare(index)
            STRIKE -> 10
            else -> throw java.lang.IllegalStateException("Illegal roll found")
        }

    private fun pinsLeftFromPreviousSpare(index: Int) = 10 - valueForRoll(index - 1)

    private fun pinsDown(index: Int) = Character.getNumericValue(rolls[index])

    private fun bonusForRoll(index: Int) =
        bonusFromPreviousRoll(index) + bonusFromTwoRollsBefore(index)

    private fun bonusFromPreviousRoll(index: Int) =
        if (rolls.previous(index) in listOf(STRIKE, SPARE)) valueForRoll(index) else 0

    private fun bonusFromTwoRollsBefore(index: Int) =
        if (rolls.twoBefore(index) == STRIKE) valueForRoll(index) else 0

    private fun String.previous(currentIndex: Int) =
        if (currentIndex > 0) this[currentIndex - 1] else '0'

    private fun String.twoBefore(currentIndex: Int) =
        if (currentIndex > 1) this[currentIndex - 2] else '0'
}
