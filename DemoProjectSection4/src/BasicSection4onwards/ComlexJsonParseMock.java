
package BasicSection4onwards;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComlexJsonParseMock {
	public static void main(String[] args) {

		JsonPath jdk=new JsonPath(payload.CoursePrice());//this course price response we are not getting from any 
		//developer rather its not ready so we are just dummy the api
		
		//number of coursed returned by the api
		int cousrsesize=jdk.getInt("courses.size()");
		// we know courses are multiple so its an array and .size() will be applied 
		System.out.println(cousrsesize);
		
		//print purchase amount
		int purchaseamount=jdk.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		//print tile of the first course
		String firstcourseTitle=jdk.get("courses.title[0]");
		System.out.println(firstcourseTitle);
		
		//print all the title and thier prices
		for(int i=0;i<cousrsesize;i++)
		{
			String courseTitle=jdk.get("courses["+i+"].title");
			//int courseprice=jdk.get("courses["+i+"].price");
			
			//another way to execute the top line is by just converting it in to string with .toString()
			System.out.println(jdk.get("courses["+i+"].price").toString());
			System.out.println(courseTitle); 
			//System.out.println(courseprice); 
		}
// print copies sold when title is rpa
		for(int j=0;j<cousrsesize;j++)
		{
			String courseTitle1=jdk.get("courses["+j+"].title");
			if(courseTitle1.equalsIgnoreCase("RPA"))
			{
				int copiesSold=jdk.get("courses["+j+"].copies");
				System.out.println("Number of copies sold of Title RPA are= "+copiesSold);
				break;
			}
		}
		
	}
}
