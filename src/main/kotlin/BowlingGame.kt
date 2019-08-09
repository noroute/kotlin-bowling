import java.lang.IllegalStateException

data class BowlingGame(private val frameString: String) {

    private val FRAMES_PER_GAME = 10

    private val rolls : String
    private val isComplete : Boolean

    init {
        isComplete = frameString.split(",").size == FRAMES_PER_GAME
        rolls = frameString.filter { c -> c != ','}
    }

    fun score() : Int {
        return if (isComplete) rolls.map(Character::getNumericValue).sum() else
            throw IllegalStateException("Incomplete game")
    }
}
