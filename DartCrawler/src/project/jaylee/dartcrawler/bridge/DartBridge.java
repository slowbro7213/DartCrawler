package project.jaylee.dartcrawler.bridge;

import java.util.ArrayList;

import project.jaylee.dartcrawler.config.DartAPIConfig;
import project.jaylee.dartcrawler.config.DartAPIParams;
import project.jaylee.dartcrawler.dartapi.ResponseDart;
import project.jaylee.dartcrawler.dartcall.DartCall;

/**
 * DartBridge
 * config를 읽어 적절한 DartCall을 호출하고 url list를 받은 후 각 url의 html에서 상세페이지에 대한 파라미터를 크롤링한다.
 */
public class DartBridge {
	
	DartAPIConfig daConfig = null;
	DartAPIParams daParams = null;
	
	public DartBridge () {
		daConfig = new DartAPIConfig();
		daParams = new DartAPIParams();
	}
	
	
	public void job() {
		ArrayList<String> params = daConfig.readConfig();
		int paramSize = params.size();
		
		DartCall 	 dc 		= new DartCall();
		ResponseDart respDart	= dc.callAPI();
		//paramSize == 2, 5, 10, 11
		if (paramSize == 2) respDart = dc.callAPI(params.get(0), params.get(1));
		if (paramSize == 5) respDart = dc.callAPI(params.get(0), params.get(1));
		if (paramSize == 10) respDart = dc.callAPI(params.get(0), params.get(1));
		if (paramSize == 11) respDart = dc.callAPI(params.get(0), params.get(1));
		
		
		
	}
}
