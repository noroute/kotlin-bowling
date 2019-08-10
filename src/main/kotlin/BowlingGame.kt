import kotlin.math.max

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

    fun score(): Int {
        return if (isComplete) rolls.mapIndexed { i, _ -> scoreForRoll(i) }.sum() else
            throw IllegalStateException("Incomplete game")
    }

    private fun scoreForRoll(index: Int): Int {
        return valueForRoll(index) + bonusForRoll(index)
    }

    private fun valueForRoll(index: Int): Int =
        when (rolls[index]) {
            in '0'..'9' -> Character.getNumericValue(rolls[index])
            SPARE -> 10 - valueForRoll(index - 1)
            STRIKE -> 10
            else -> throw java.lang.IllegalStateException("Illegal roll found")
        }

    private fun bonusForRoll(index: Int): Int {
        return bonusFromPreviousRoll(index) + bonusFromTwoRollsBefore(index)
    }

    private fun bonusFromPreviousRoll(index: Int): Int {
        if (index == 0) {
            return 0
        }
        if (previousRoll(index) in listOf(STRIKE, SPARE)) {
            return valueForRoll(index)
        }
        return 0
    }

    private fun bonusFromTwoRollsBefore(index: Int): Int {
        if (index < 2) {
            return 0
        }

        if (twoRollsBefore(index) == STRIKE) {
            return valueForRoll(index)
        }
        return 0
    }

    private fun previousRoll(currentIndex: Int): Char {
        return rolls[max(0, currentIndex - 1)]
    }

    private fun twoRollsBefore(currentIndex: Int): Char {
        return rolls[max(0, currentIndex - 2)]
    }
}
