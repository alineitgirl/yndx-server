import data.User
import fixtures.UserHelper
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll
import java.util.*

open class BaseApiTest {
    companion object {
        lateinit var user: User
        lateinit var token: String

        @JvmStatic
        @BeforeAll
        fun setup() {
            RestAssured.baseURI = "http://localhost"
            RestAssured.port = 3000

            user = User(
                email = "user_${UUID.randomUUID()}@test.com",
                name = "Test User",
                age = 25,
                password = "secret123"
            )
            token = UserHelper.register(user)
        }
    }
} 