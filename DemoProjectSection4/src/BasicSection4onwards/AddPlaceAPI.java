package BasicSection4onwards;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;// we need this for given when then
import static org.hamcrest.Matchers.*;// this is for the equalTo which we used to compare stautus="APP" in body

import Files.payload;

public class AddPlaceAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//validate if addplace is working as expected
//given- all the input details(quearyparamenter, header, body)
//when- submit the ApI(resources, http method)
//Then-Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";//this the the base URL
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlaceBody()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)");
		//we also need to have the Server response in the header to make sure its coming from the coprrect server.
	//you are just asserting the values here and are not directly storing it in any variable
	}
//Add place->Update the place with new address->get Place to Validate if new address is presnt
}
