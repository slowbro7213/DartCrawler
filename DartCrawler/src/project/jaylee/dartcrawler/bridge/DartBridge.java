package project.jaylee.dartcrawler.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	//viewDoc('20190401004489', '6615080', '2', '5542', '414', 'dart3.xsd');
	static String REGEX_VIEWDOC_FRONT = "viewDoc(\'";
	static String REGEX_VIEWDOC_BEHIND = "\', \'[0-9]+\', \'[0-9]+\', \'[0-9]+\', \'dart3.xsd\');";
	static String REGEX_VIEWDOC_PARAM = "\'.+\'";
	
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
			String parameter 	= fullUrl.split("?")[1];
			String rcpNoValue	= parameter.split("=")[1];
			
			String htmlDocument = URLConnectUtil.getHtmlDocument(url, parameter);
			String viewerURL = getViewerURL(htmlDocument, rcpNoValue); 
			htmlDocuments.add(viewerURL);
		}

	}
	
	/**
	 * getViewerURL
	 * 파싱한 html문서에서 viewDoc() 사용을 찾고 url 파라미터로 만들어 리스트 리턴
	 * @param htmlDocument
	 * @return
	 */
	private String getViewerURL(String htmlDocument, String rcpNoValue) {
		
		// viewer frame url
		// parameters : rcpNo, dcmNo, eleId, offset, length, dtd
		
		Matcher matcher = Pattern.compile(REGEX_VIEWDOC_FRONT + rcpNoValue + REGEX_VIEWDOC_BEHIND).matcher(htmlDocument);
		ArrayList<String> matchStrList = new ArrayList<String>();
		while (matcher.find()) {
			matchStrList.add(matcher.group());
		}
		
		for (int idx=0; idx<matchStrList.size(); idx++) {
			matcher = Pattern.compile(REGEX_VIEWDOC_PARAM).matcher(matchStrList.get(idx));
			ArrayList<String> matchParamList = new ArrayList<String>();
			while (matcher.find()) {
				matchParamList.add(matcher.group());
			}
			String rcpNo 	= matchParamList.get(0);
			String dcmNo 	= matchParamList.get(1);
			String eleId 	= matchParamList.get(2);
			String offset 	= matchParamList.get(3);
			String length 	= matchParamList.get(4);
			String dtd 		= matchParamList.get(5);
			
			String frameURL = DartAPIProperty.DART_VIEWER_FRAME_URL + "?"
					  + "&" + DartAPIProperty.RCP_NO + "=" + rcpNo
					  + "&" + DartAPIProperty.DCM_NO + "=" + dcmNo
					  + "&" + DartAPIProperty.ELE_ID + "=" + eleId
					  + "&" + DartAPIProperty.OFFSET + "=" + offset
					  + "&" + DartAPIProperty.LENGTH + "=" + length
					  + "&" + DartAPIProperty.DTD	 + "=" + dtd		;
			
			System.out.println("[Frame URL " + (idx+1) + "] " + frameURL);
		}
		
		return null;
	}
}
