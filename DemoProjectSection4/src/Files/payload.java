package Files;

public class payload {
	
	public static String AddPlaceBody()
	{
		return "{\n" + 
				"  \"location\": {\n" + 
				"    \"lat\": -38.383494,\n" + 
				"    \"lng\": 33.427362\n" + 
				"  },\n" + 
				"  \"accuracy\": 50,\n" + 
				"  \"name\": \"Welcome I am Here\",\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\n" + 
				"  \"types\": [\n" + 
				"    \"shoe park\",\n" + 
				"    \"shop\"\n" + 
				"  ],\n" + 
				"  \"website\": \"http://google.com\",\n" + 
				"  \"language\": \"French-IN\"\n" + 
				"}"; 
	}
	public static String CoursePrice()
	{
		return "{\n" + 
				"\n" + 
				"\"dashboard\": {\n" + 
				"\n" + 
				"\"purchaseAmount\": 910,\n" + 
				"\n" + 
				"\"website\": \"rahulshettyacademy.com\"\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"\"courses\": [\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"Selenium Python\",\n" + 
				"\n" + 
				"\"price\": 50,\n" + 
				"\n" + 
				"\"copies\": 6\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"Cypress\",\n" + 
				"\n" + 
				"\"price\": 40,\n" + 
				"\n" + 
				"\"copies\": 4\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"RPA\",\n" + 
				"\n" + 
				"\"price\": 45,\n" + 
				"\n" + 
				"\"copies\": 10\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"]\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"";
	}


	public static String Addbook(String isbn, String aisle)// we are using parametized one here because 
	//we can pass the value in the test case as we need different value every time we add new book. old book would pass
	//an error message that book already exists and fail our test case
	{
		String payload= "{\n" + 
				"\n" + 
				"\"name\":\"Learn Mobile Automation with Java\",\n" + 
				"\"isbn\":\""+isbn+"\",\n" + // here we have given these values(String aisle, String isbn)/
				"\"aisle\":\""+aisle+"\",\n" + 
				"\"author\":\"Harshul\"\n" + 
				"}";
		return payload; // we can do it the wy we did it on top or we can do it the way we did here by creatign 
						// a vairable and retuning it after or just return it straight away
	
	}
	public static String Deletebook(String ID)// we are using parametized one here because 
	//we can pass the value in the test case as we need different value every time we add new book. old book would pass
	//an error message that book already exists and fail our test case
	{
		String Deleteload= "{\n" + 
				" \n" + 
				"\"ID\" : \""+ID+"\"\n" + 
				" \n" + 
				"}";
		return Deleteload; // we can do it the wy we did it on top or we can do it the way we did here by creatign 
						// a vairable and retuning it after or just return it straight away
	
	}
	
}
