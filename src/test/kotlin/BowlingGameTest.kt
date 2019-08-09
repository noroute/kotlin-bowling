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
}