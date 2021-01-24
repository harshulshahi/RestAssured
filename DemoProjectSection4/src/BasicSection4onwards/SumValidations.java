package BasicSection4onwards;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidations {
	@Test
	public void validate()
	{
		
		JsonPath jdk=new JsonPath(payload.CoursePrice());
		//payload.CoursePrice() is coming from payload class and CoursePrice method
		int count= jdk.getInt("courses.size()");
		
		System.out.println(count);
		int totalvalue=0;
		int price;
		int copies;
		int total;
		for(int i=0;i<count;i++)
		{
			
			price=jdk.get("courses["+i+"].price");
			copies=jdk.get("courses["+i+"].copies");
			total=price*copies;
			System.out.println(total);
			totalvalue=totalvalue+total;
			//System.out.println(total);
		}
		System.out.println(totalvalue);
		int purchaseprice=jdk.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseprice);
		Assert.assertEquals(purchaseprice, totalvalue);
		
	}
	

}
