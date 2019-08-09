import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalStateException

class BowlingGameTest {

    @Test
    fun incompleteGamesAreInIllegalState() {
        assertThrows<IllegalStateException> { BowlingGame("1").score() }
    }

    @Test
    fun completeGamesShouldBeScored() {
        assertThat(BowlingGame("10,00,00,00,00,00,00,00,00,00").score()).isEqualTo(1)
    }

    @Test
    fun scoresTrivialSpareExampleCorrectly() {
        assertThat(BowlingGame("1/,11,00,00,00,00,00,00,00,00").score()).isEqualTo(13)
    }

    @Test
    fun scoresTrivialSpareExampleInLastFrameCorrectly() {
        assertThat(BowlingGame("00,00,00,00,00,00,00,00,00,1/1").score()).isEqualTo(12)
    }

    @Test
    fun scoresTrivialStrikeExampleCorrectly() {
        assertThat(BowlingGame("X,11,00,00,00,00,00,00,00,00").score()).isEqualTo(14)
    }

    @Test
    fun scoresTrivialStrikeExampleInLastFrameCorrectly() {
        assertThat(BowlingGame("00,00,00,00,00,00,00,00,00,X11").score()).isEqualTo(14)
    }

    @Test
    fun scoresCombinedSpareAndStrikeExampleCorrectly() {
        assertThat(BowlingGame("1/,X,11,00,00,00,00,00,00,00").score()).isEqualTo(34)
    }

    @Test
    fun exampleGameShouldBeScoredCorrectly() {
        assertThat(BowlingGame("14,45,6/,5/,X,01,7/,6/,X,2/6").score()).isEqualTo(139)
    }
}