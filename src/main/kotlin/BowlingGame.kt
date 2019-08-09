data class BowlingGame(val rolls: String) {

    val FRAMES_PER_GAME = 10

    fun isComplete() : Boolean {
        return rolls.split(",").size == FRAMES_PER_GAME
    }

    fun score() : Int {
        return if (isComplete()) rolls.filter { c -> c != ',' }.map(Character::getNumericValue).sum() else 0
    }
}
