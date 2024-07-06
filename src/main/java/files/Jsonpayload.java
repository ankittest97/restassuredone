package files;

//Body what is defined in postmapdata.java will be used from here

public class Jsonpayload {

	//you can return the complete payload from here
	public static String AddPlace()			//I can call this method static so that I can call this method
											//directly into my test without creating any object for this class.   
	{										//you can call method by classname.methodname
		return "{\r\n" +
				 "\"location\": {\r\n" +
				 "\"lat\": -38.383494,\r\n" +
				 "\"lng\": 33.427362\r\n" +
				 "},\r\n" +
				 "\"accuracy\": 50,\r\n" +
				 "\"name\": \"my test1.4\",\r\n" +
				 "\"phone_number\": \"(+91) 983 893 3937\",\r\n" +
				 "\"address\": \"29, side layout, cohen 09\",\r\n" +
				 "\"types\": [\r\n" +
				 "\"shoe park\",\r\n" +
				 "\"shop\"\r\n" +
				 "],\r\n" +
				 "\"website\": \"http://google.com\",\r\n" +
				 "\"language\": \"French-IN\"\r\n" +
				 "}";   
		
	}
	
		
		public static String CoursePrice()
		{
			return "{\r\n"
					+ "  \"dashboard\":{\r\n"
					+ "    \"purchaseAmount\":910,\r\n"
					+ "    \"website\":\"rahulshettyacademy.com\"\r\n"
					+ "  },\r\n"
					+ "  \"courses\": [\r\n"
					+ "    {\r\n"
					+ "      \"title\":\"Selenium Python\",\r\n"
					+ "      \"price\":50,\r\n"
					+ "      \"copies\":6\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "     \"title\":\"Cypress\",\r\n"
					+ "      \"price\":40,\r\n"
					+ "      \"copies\":4\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "    \"title\":\"RPA\",\r\n"
					+ "      \"price\":55,\r\n"
					+ "      \"copies\":16\r\n"
					+ "    \r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}";
		}
		
	}
		
	
			
