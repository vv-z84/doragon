import com.skubawa.doragon.watcher.ArgParser
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class ArgParserTest {
    private val argParser: ArgParser = ArgParser()

    @Test
    fun `test required argument --path`() {
        val emptyArgs: Array<String> = arrayOf("")

        assertThrows<IllegalArgumentException> {
            argParser.parse(emptyArgs)
        }

        val emptyPathArgument: Array<String> = arrayOf("--path")

        assertThrows<IllegalArgumentException> {
            argParser.parse(emptyPathArgument)
        }
    }
}