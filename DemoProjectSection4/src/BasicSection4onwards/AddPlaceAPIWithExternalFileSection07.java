package BasicSection4onwards;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;// we need this for given when then
import static org.hamcrest.Matchers.*;// this is for the equalTo which we used to compare stautus="APP" in body

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Files.payload;

public class AddPlaceAPIWithExternalFileSection07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//validate if addplace is working as expected
//given- all the input details(quearyparamenter, header, body)
//when- submit the ApI(resources, http method)
//Then-Validate the response
		
//content of the file to string->content of the file can convert into Byte->byte data into String
		
		RestAssured.baseURI="https://rahulshettyacademy.com";//this the the base URL
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("//Users//harshul//PostManWorkSpace//DemoProjectSection4//src//BasicSection7onwards//addplace.json"))))
		//readAllBytes(Path path):byte[]  
		//AND YOU HAVE TO PUT .body(new String(Files.readAllBytes(Paths.get(FILE LOCATION IN QUOTATION))))
		// this is only if you have to get data from external file.
		.when()
		.post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)");
		//we also need to have the Server response in the header to make sure its coming from the coprrect server.
	//you are just asserting the values here and are not directly storing it in any variable
	}
//Add place->Update the place with new address->get Place to Validate if new address is presnt
}
