import fixtures.UserHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

class UserExistenceTest : BaseApiTest() {
    @Test
    fun `check if user exists returns true`() {
        assertTrue(UserHelper.checkUserExists(user.email))
    }

    @Test
    fun `check if user exists returns false`() {
        val email = "user_${UUID.randomUUID()}@test.com"
        assertFalse(UserHelper.checkUserExists(email))
    }
} 