import com.skubawa.doragon.watcher.FilepathValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class FilepathValidatorTest {

    private val validator: FilepathValidator = FilepathValidator()

    @Test
    fun `test inexistent filepath`() {
        val invalidFilepath = "/notexists"

        assertThrows<RuntimeException> {
            validator.validate(invalidFilepath)
        }
    }

    @Test
    fun `test unreadable filepath`() {
        val unreadableFilepath = "/root"

        assertThrows<RuntimeException> {
            validator.validate(unreadableFilepath)
        }
    }
}