import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class BowlingGameTest{

    @Test
    fun trivial(){
        assertThat(BowlingGame("1").score()).isEqualTo(2)
    }
}