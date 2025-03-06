package day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Demo {
	
@Test	
public void gtetUsersvalid() {
		
		
		given()
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
@Test
public void gtetUsersInvalid() {
	
	
	given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	
	.then()
	.statusCode(202)
	.body("page",equalTo(2))
	.log().all();
}


}
