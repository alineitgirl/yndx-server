import fixtures.UserHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class UserUpdateTest : BaseApiTest() {
    @Test
    fun `can update user name`() {
        val newName = "Updated Name"
        token = UserHelper.login(user)

        val response = UserHelper.updateName(token, newName)
            .then()
            .statusCode(200)
            .extract()
        val actualName = response.path<String>("user.name")
        assertEquals(newName, actualName)
    }
} 