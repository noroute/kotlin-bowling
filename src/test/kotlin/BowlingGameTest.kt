import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

class BowlingGameTest {

    @Test
    fun emptyGamesShouldNotBeComplete() {
        assertThat(BowlingGame("").isComplete()).isFalse()
    }

    @Test
    fun gameWithFiveFramesShouldNotBeComplete() {
        assertThat(BowlingGame("11,22,33,44,55").isComplete()).isFalse()
    }

    @Test
    fun gameWithTenFramesShouldBeComplete() {
        assertThat(BowlingGame("11,22,33,44,55,66,77,88,99,10").isComplete()).isTrue()
    }

    @Test
    fun incompleteGamesShouldBeWorthZeroPoints() {
        assertThat(BowlingGame("1").score()).isEqualTo(0)
        assertThat(BowlingGame("12,3").score()).isEqualTo(0)
    }

    @Test
    fun completeGamesShouldBeScored() {
        assertThat(BowlingGame("10,00,00,00,00,00,00,00,00,00").score()).isEqualTo(1)
    }
}