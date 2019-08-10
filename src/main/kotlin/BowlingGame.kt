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
        return if (isComplete) rolls.mapIndexed(::scoreForIndex).sum() else
            throw IllegalStateException("Incomplete game")
    }

    private fun scoreForIndex(index: Int, char: Char): Int {
        val value = valueForIndex(index, char) + bonusForIndex(index)
        println("Value for $index:$char = $value")
        return value
    }

    private fun valueForIndex(index: Int, char: Char): Int {
        when {
            char.isDigit() -> return Character.getNumericValue(char)
            char == SPARE -> return 10 - valueForIndex(index - 1, rolls[index - 1])
            char == STRIKE -> return 10
        }
        throw java.lang.IllegalStateException("Illegal roll found")
    }

    private fun bonusForIndex(index: Int): Int {
        return bonusFromPreviousRoll(index) + bonusFromTwoRollsBefore(index)
    }

    private fun bonusFromPreviousRoll(index: Int): Int {
        if (index == 0) {
            return 0
        }
        if (previousRoll(index) in listOf(STRIKE, SPARE)) {
            return valueForIndex(index, rolls[index])
        }
        return 0
    }

    private fun bonusFromTwoRollsBefore(index: Int): Int {
        if (index < 2) {
            return 0
        }

        if (twoRollsBefore(index) == STRIKE) {
            return valueForIndex(index, rolls[index])
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
