data class BowlingGame(val rolls: String) {

    val FRAMES_PER_GAME = 10

    fun isValid() : Boolean {
        return rolls.split(",").size == FRAMES_PER_GAME
    }

    fun score() : Int{
        return rolls.map(Character::getNumericValue).sum()
    }
}
