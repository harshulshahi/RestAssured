package BasicSection4onwards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;// we need this for given when then
import static org.hamcrest.Matchers.*;// this is for the equalTo which we used to compare stautus="APP" in body
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import Files.Reuseable;
import Files.payload;

public class AddPlaceAndUpdateWithReusableclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//validate if addplace is working as expected
//given- all the input details(quearyparamenter, header, body)
//when- submit the ApI(resources, http method)
//Then-Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";//this the the base URL
		
		String Response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlaceBody()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		//we also need to have the Server response in the header to make sure its coming from the correct server.
		//you are just asserting the values here and are not directly storing it in any variable
		//.extract().response().asString() THIS HELPS us store the response.
		
		System.out.println(Response);
		//Add place->Update the place with new address->get Place to Validate if new address is present
		
		JsonPath js1=Reuseable.rawToJson(Response);// parsing json since our API is in json
		String placeID=js1.get("place_id");// in order to get the path we travel from parent to child with dot ex- parent.child.child
		System.out.println(placeID);
		
//Update Place- since the place id keeps on changing make sure you get the place id from the placeID
		String newUpdatedAddress= "70 Summer walk, USA";//Stored the new addredd in a string 
		
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\n" + 
				"\"place_id\":\""+placeID+"\",\n" + 
				"\"address\":\""+newUpdatedAddress+"\",\n" + 
				"\"key\":\"qaclick123\"\n" + 
				"}").when().put("maps/api/place/update/json")//put the reource here and we used put since the method req. is put
				.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
// up till here you have updated the address but you haven't verified all we did is logged it in the console 
// but thats not enough we have to use GET api to validate it.
		String validateget=given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeID )
				.when().get("maps/api/place/get/json")
				.then().assertThat().statusCode(200).body("address", equalTo("70 Summer walk, USA"))
				.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(validateget);
		
		JsonPath jd1=Reuseable.rawToJson1(validateget);
		String ActualAddress=jd1.getString("address");
		System.out.println(newUpdatedAddress);
		System.out.println(ActualAddress);
		Assert.assertEquals(newUpdatedAddress, ActualAddress);
	}
	
}
