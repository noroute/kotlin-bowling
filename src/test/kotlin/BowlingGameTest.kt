import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalStateException
import java.util.stream.Stream

class BowlingGameTest {

    companion object {
        @JvmStatic
        fun completeGameExamples(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("trivial game", "10,00,00,00,00,00,00,00,00,00", 1),
                Arguments.of("trivial game with spare", "1/,11,00,00,00,00,00,00,00,00",13),
                Arguments.of("trivial game with spare in last frame", "00,00,00,00,00,00,00,00,00,1/1",12),
                Arguments.of("trivial game with strike", "X,11,00,00,00,00,00,00,00,00",14),
                Arguments.of("trivial game with strike in last frame", "00,00,00,00,00,00,00,00,00,X11", 14),
                Arguments.of("game with strike and spare", "1/,X,11,00,00,00,00,00,00,00", 34),
                Arguments.of("example game", "14,45,6/,5/,X,01,7/,6/,X,2/6", 139),
                Arguments.of("game with max score", "X,X,X,X,X,X,X,X,X,XX", 300)
            )
        }
    }

    @Test
    fun incompleteGamesAreInIllegalState() {
        assertThrows<IllegalStateException> { BowlingGame("1").score() }
    }

    @DisplayName("Complete Games should be scored correctly")
    @ParameterizedTest(name = "\"{0}\" should be scored correctly")
    @MethodSource("completeGameExamples")
    fun gameShouldBeCorrectlyScored(name: String, givenGame: String, expectedScore: Int){
        assertThat(BowlingGame(givenGame).score()).isEqualTo(expectedScore)
    }
}