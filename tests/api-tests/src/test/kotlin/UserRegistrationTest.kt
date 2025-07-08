import data.User
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

class UserRegistrationTest : BaseApiTest() {
    @Test
    fun `can register a new user`() {
        val newUser = User(
            email = "user_${UUID.randomUUID()}@test.com",
            name = "Register Test",
            age = 30,
            password = "register123"
        )
        val response = RestAssured
            .given()
            .contentType("application/json")
            .body(mapOf(
                "email" to newUser.email,
                "name" to newUser.name,
                "age" to newUser.age,
                "password" to newUser.password
            ))
            .post("/auth/register")
            .then()
            .statusCode(200)
            .extract()

        val returnedEmail = response.path<String>("user.email")
        val returnedName = response.path<String>("user.name")
        val returnedAge = response.path<Int>("user.age")
        assertEquals(newUser.email, returnedEmail)
        assertEquals("Neko", returnedName)
        assertEquals(newUser.age, returnedAge)
    }
} 