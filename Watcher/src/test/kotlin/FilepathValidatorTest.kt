import com.skubawa.doragon.watcher.FilepathValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class FilepathValidatorTest {

    private val validator: FilepathValidator = FilepathValidator()

    @Test
    fun `when filepath not exists should throw RuntimeException`() {
        val inexistentFilepath = "/notexists"

        assertThrows<RuntimeException> {
            validator.validate(inexistentFilepath)
        }
    }

    @Test
    fun `when filepath is a relativepath should throw RuntimeException`() {
        val relativePath1 = "../watchme"

        val exception1 = assertThrows<RuntimeException> {
            validator.validate(relativePath1)
        }

        val relativePath2 = "projects"

        val exception2 = assertThrows<RuntimeException> {
            validator.validate(relativePath2)
        }
    }

// TODO: Este teste está falhando no Docker, pois /root é readable. Resolver.
//
//    @Test
//    fun `when filepath is unreadable should throw RuntimeException`() {
//        val unreadableFilepath = "/root"
//
//        assertThrows<RuntimeException> {
//            validator.validate(unreadableFilepath)
//        }
//    }
}