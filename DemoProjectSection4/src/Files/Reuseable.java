package Files;

import io.restassured.path.json.JsonPath;

public class Reuseable {

	public static JsonPath rawToJson(String Response)
	{
		JsonPath js= new JsonPath(Response);
		return js;
	}
	public static JsonPath rawToJson1(String validateget)
	{
		JsonPath jd=new JsonPath(validateget);//JsonPath is used to fect the desierd value from the response
		return jd;
	}
	
}