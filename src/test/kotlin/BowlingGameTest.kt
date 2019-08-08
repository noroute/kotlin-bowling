import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

class BowlingGameTest{

    @Test
    fun emptyGamesShouldBeInvalid() {
        assertThat(BowlingGame("").isValid()).isFalse()
    }

    @Test
    fun gameWithFiveFramesShouldNotBeValid() {
        assertThat(BowlingGame("11,22,33,44,55").isValid()).isFalse()
    }

    @Test
    fun gameWithTenFramesShouldBeValid() {
        assertThat(BowlingGame("11,22,33,44,55,66,77,88,99,10").isValid()).isTrue()
    }

    @Test
    fun incompleteGamesShouldBeWorthZeroPoints(){
        assertThat(BowlingGame("1").score()).isEqualTo(0)
        assertThat(BowlingGame("12,3").score()).isEqualTo(0)
    }
}