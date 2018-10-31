import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Test {

	@SuppressWarnings("deprecation")
	Test(){
		try {
		MongoClient mongoClient = new MongoClient("172.31.41.152", 27017);
		DB database = mongoClient.getDB("testdb");
		mongoClient.getDatabaseNames().forEach(System.out::println);
	}
	catch(Exception exc)
	{
		exc.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		
		new Test();
	}
}
