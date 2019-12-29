package project.jaylee.dartcrawler.dartcall;

import java.util.ArrayList;

import project.jaylee.dartcrawler.dartapi.ResponseDart;

public class UnitTest {

	public static void main(String[] args) {
		DartCall dc = new DartCall();
		ResponseDart respDart = dc.callAPI();
		ArrayList<String> list = dc.getUrlList(respDart);
		
		System.out.println(list.toString());
		
	}

}
