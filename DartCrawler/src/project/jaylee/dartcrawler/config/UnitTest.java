package project.jaylee.dartcrawler.config;

public class UnitTest {

	

	public static void main(String[] args) {
		String str = UnitTest.class.getResource("/").getPath();
		
		System.out.println(str);
		System.out.println(System.getProperty("user.dir"));

	}
	
}
