package apiTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	@Test
	public void testHeader() {
			
			given()
			
			.when()
			  .get("https://www.google.com/") 
			
			.then()
			  .header("Content-Type", "text/html; charset=ISO-8859-1") //constant header
			  .and()
			  .header("Content-Encoding", "gzip") //constant header
			  .and()
			  .header("Server", "gws")  //constant header
			  .statusCode(200)
			 // .log().all()   // for all log
			 .log().headers()    //only for header print
			
			;		
		}
	@Test
	public void testHeaders() {
			
	 Response res=given()
			
			.when()
			  .get("https://www.google.com/") ;
//			  String cookies_vaslue = res.getHeader("Content-Type");
//			  System.out.println("headers is : " +cookies_vaslue);
	 
	          Headers allheaders = res.headers();
	          
	          for (Header hd:allheaders) {
	        	  
	        	  System.out.println(hd.getName()+ "    "+hd.getValue());
	        	  
	          }
	          
	}
	
}
