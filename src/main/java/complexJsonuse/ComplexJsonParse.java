package complexJsonuse;

import files.Jsonpayload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(Jsonpayload.CoursePrice());
		
		//print no of courses returned by API
		
int count = 	js.getInt("courses.size()");     //size is a method used in json path, size can applied only on arrays
	System.out.println(count);
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		//print title of the first course
		
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//print all course title and their respective titles
		
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitles);
			
		}
		
		System.out.println("print no of copies");
		

		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copiescount = js.get("courses["+i+"].copies");
				System.out.println(copiescount);
				break;
			}
		}
		
		
		
	}

}
