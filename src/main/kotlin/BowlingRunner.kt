import java.io.File
import kotlin.system.exitProcess

object BowlingRunner {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 1) {
            usage()
        }
        File(args[0]).forEachLine { game: String ->
            println("Score for game ${game} is ${BowlingGame(game).score()}.")
        }
    }

    fun usage() {
        println("Usage: ./gradlew run <filename> # one game per line")
        exitProcess(2)
    }
}