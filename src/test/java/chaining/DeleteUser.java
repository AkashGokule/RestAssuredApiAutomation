package chaining;

import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	
	@Test(priority = 4)
	public void deleteUser(ITestContext context) {
		
		int id = (int) context.getAttribute("user_id");
		//int id =(int) context.getSuite().getAttribute("user_id");  //suite lavel
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		
		.then()
		  .statusCode(204)
		  .log().all()
		;
		
	}
}
