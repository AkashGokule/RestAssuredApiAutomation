package chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUser {
	@Test
	public void test_getUser(ITestContext context) {
		
		int id =(int) context.getAttribute("user_id");
		//int id =(int) context.getSuite().getAttribute("user_id");  //suite lavel
		given()
		  .pathParam("id", id)
		.when()
		   .get("https://reqres.in/api/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
