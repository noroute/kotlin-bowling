data class BowlingGame(val rolls: String) {

    fun score() : Int{
        return rolls.map(Character::getNumericValue).sum()
    }
}
