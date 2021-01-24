package BasicSection7onwards;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Reuseable;
import Files.payload;

import static io.restassured.RestAssured.*;// we need this for given when then

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJsonDelete {
	
	
	//Dynamically build Json payload with external 
	@Test(dataProvider="BooksData")// we are telling the test case to go into dataprovider with name BooksData
								// and grave the values of it and one it found it will run for that many 
							//number of times. we are sening three values so it will run three time 
	
	//NOW THIS IS NOT HARD CODED ANYMORE AND WHEN YOU RUN THE TEST IT WILL RUN 3TIME
	// THIS TEST IS LINKED WITH DATA PROVIDER TO PICK THE VALUES AND MAKE SURE THE RETURN TYPE ARE SAME ELSE IT
	// WILL THROW ERROR
	public void addbook(String ID)// here we are going to provide the the datatype of the array we used
	// in the dataprovider we have used two values in one array so we will provide two values
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("Content-Type","application/json")
		.body(payload.Deletebook(ID))
		.when().delete//it accepts post/delete(URI arg0)
		("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=Reuseable.rawToJson(Response);
		String msg =js.get("msg");
		System.out.println(msg);
		
		
	}
	@DataProvider(name="BooksData")// THIS IS BASICALLY TO SEND VALUES TO THE TESTCASES AS IT LINKS WITH THE TEST CASES
	public Object[][] getData()// this is if you want to add more than one book at a time 
	{
		return new Object[][] {{"FirstBook001"},{"SecondBook002"},{"ThirdBook003"}};
	}

}

