import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class UserLoginTest : BaseApiTest() {
    @Test
    fun `can login with registered user`() {
        val response = RestAssured
            .given()
            .contentType("application/json")
            .body(mapOf(
                "email" to user.email,
                "password" to user.password
            ))
            .post("/auth/login")
            .then()
            .statusCode(200)
            .extract()

        val returnedEmail = response.path<String>("user.email")
        val returnedName = response.path<String>("user.name")
        val returnedAge = response.path<Int>("user.age")
        val token = response.path<String>("token")

        assertEquals(user.email, returnedEmail)
        assertEquals(user.age, returnedAge)
        assertNotNull(token)
        assertTrue(token.isNotEmpty())
    }
} 