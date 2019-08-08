data class BowlingGame(val rolls: String) {

    fun isValid() : Boolean {
        return false
    }

    fun score() : Int{
        return rolls.map(Character::getNumericValue).sum()
    }
}
