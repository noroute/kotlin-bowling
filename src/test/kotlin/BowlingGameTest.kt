import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import org.junit.jupiter.api.Test

class BowlingGameTest{

    @Test
    fun emptyGamesShouldBeInvalid() {
        assertThat(BowlingGame("").isValid()).isFalse()
    }

    @Test
    fun incompleteGameNumbersOnly(){
        assertThat(BowlingGame("1").score()).isEqualTo(1)
        assertThat(BowlingGame("123").score()).isEqualTo(6)
    }
}