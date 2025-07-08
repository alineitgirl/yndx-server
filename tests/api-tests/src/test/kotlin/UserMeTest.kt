import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class UserMeTest : BaseApiTest() {
    @Test
    fun `can get registered user data`() {
        val response = RestAssured
            .given()
            .header("Authorization", "Bearer $token")
            .get("/user/me")
            .then()
            .statusCode(200)
            .extract()

        val returnedName = response.path<String>("user.name")
        assertEquals("Neko", returnedName)
    }
} 