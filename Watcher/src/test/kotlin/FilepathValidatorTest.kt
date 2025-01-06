import com.skubawa.doragon.watcher.FilepathValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertTrue

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

    @Test
    fun `test readable filepath`() {
        val readableFilepath = "/home"
        val result: Boolean = validator.validate(readableFilepath)

        assertTrue(result)
    }
}