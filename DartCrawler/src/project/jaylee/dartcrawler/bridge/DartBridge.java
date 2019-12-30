package project.jaylee.dartcrawler.bridge;

import java.util.ArrayList;
import java.util.HashMap;

import project.jaylee.dartcrawler.config.DartAPIConfig;
import project.jaylee.dartcrawler.config.DartAPIProperty;
import project.jaylee.dartcrawler.dartapi.ResponseDart;
import project.jaylee.dartcrawler.dartcall.DartCall;
import project.jaylee.dartcrawler.util.URLConnectUtil;

/**
 * DartBridge
 * config를 읽어 적절한 DartCall을 호출하고 url list를 받은 후 각 url의 html에서 상세페이지에 대한 파라미터를 크롤링한다.
 */
public class DartBridge {
	
	DartAPIConfig daConfig = null;
	
	public DartBridge () {
		daConfig = new DartAPIConfig();
	}
	
	
	public void job() {
		ArrayList<String> params = daConfig.readConfig();
		
		DartCall 	 dc 			= new DartCall();
		ResponseDart respDart		= dc.callAPI(params);
		ArrayList<String> urlList 	= dc.getUrlList(respDart);
		
		ArrayList<String> htmlDocuments = new ArrayList<String>();
		for (String fullUrl : urlList) {
			String url 			= fullUrl.split("?")[0];
			String parameters 	= fullUrl.split("?")[1];
			
			String htmlDocument = URLConnectUtil.getHtmlDocument(url, parameters);
			String viewerURL = getViewerURL(htmlDocument); 
			htmlDocuments.add(viewerURL);
		}

	}
	
	/**
	 * getViewerURL
	 * 파싱한 html문서에서 viewer에 사용할 파라미터를 추출하여 url로 만든 후 리턴 
	 * @param htmlDocument
	 * @return
	 */
	private String getViewerURL(String htmlDocument) {
		
		
		
		return null;
	}
}
