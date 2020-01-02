package project.jaylee.dartcrawler.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.jaylee.dartcrawler.config.DartAPIConfig;
import project.jaylee.dartcrawler.config.DartAPIProperty;
import project.jaylee.dartcrawler.config.UnitTest;
import project.jaylee.dartcrawler.dartapi.ResponseDart;
import project.jaylee.dartcrawler.dartcall.DartCall;
import project.jaylee.dartcrawler.util.StringUtil;
import project.jaylee.dartcrawler.util.URLConnectUtil;

/**
 * DartBridge
 * config를 읽어 적절한 DartCall을 호출하고 url list를 받은 후 각 url의 html에서 상세페이지를 크롤링하여 파라미터와 url을 가져온다. 
 */
public class DartBridge {
	
	//viewDoc('20190401004489', '6615080', '2', '5542', '414', 'dart3.xsd');
	static String REGEX_VIEWDOC_FRONT	=	"viewDoc\\((\\s*|\\t*)'";
	static String REGEX_VIEWDOC_BEHIND	=	"'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'dart3.xsd'(\\s*|\\t*)\\)(\\s*|\\t*);";
	static String REGEX_VIEWDOC_PARAM	=	"'.+?'";
	
	DartAPIConfig daConfig = null;
	
	public DartBridge () {
		daConfig = new DartAPIConfig();
	}
	
	
	public ArrayList<String> job() {
		System.out.println("[JOB] bridge job started...");
		ArrayList<String> params 	= daConfig.readConfig();
									  daConfig.print(daConfig.getDaConfigMap());
		
		DartCall 	 	  dc 		= new DartCall();
		ResponseDart 	  respDart	= dc.callAPI(params);
		ArrayList<String> urlList 	= dc.getUrlList(respDart);
		
		System.out.println("[JOB] URL LIST SIZE : " + urlList.size());
		
		ArrayList<String> htmlDocuments = new ArrayList<String>();
		System.out.println("[JOB]         >>>>> start convert html url to frame url");
		for (String fullUrl : urlList) {
			System.out.println("[JOB]               target report url : " + fullUrl);
			
			String url 				= fullUrl.split("\\?")[0];
			String parameter 		= fullUrl.split("\\?")[1];
			String rcpNoValue		= parameter.split("=")[1];
			
			String htmlDocument 	= URLConnectUtil.getHtmlDocument(url, parameter);
			System.out.println("[JOB]               target report url String length : " + htmlDocument.length());
			ArrayList<String> viewerURLList = getViewerURL(htmlDocument, rcpNoValue);
			
			for (String frameURL : viewerURLList) {
				System.out.println("[JOB]               target report frame url : " + frameURL);
				String viewerFrameContents  = URLConnectUtil.getHtmlDocument(frameURL.split("\\?")[0], frameURL.split("\\?")[1]);
				//System.out.println("[JOB]               target report viewer frame : " + viewerFrameContents);
				if (viewerFrameContents == null || viewerFrameContents.equals("")) continue;
				viewerFrameContents = StringUtil.removeHtml(viewerFrameContents);
				viewerFrameContents = StringUtil.removeSeveralCLRF(viewerFrameContents);
				htmlDocuments.add(viewerFrameContents);
			}

		}
		
		System.out.println("[JOB]         >>>>> convert html url to frame url end");
		System.out.println("[JOB] bridge job end.");
		return htmlDocuments;
	}
	
	/**
	 * getViewerURL
	 * 파싱한 html문서에서 viewDoc() 사용을 찾고 url 파라미터로 만들어 리스트 리턴
	 * @param htmlDocument
	 * @return
	 */
	private ArrayList<String> getViewerURL(String htmlDocument, String rcpNoValue) {
		ArrayList<String> frameUrlList = new ArrayList<String>();
		System.out.println("[JOB]               getViewerURL");
		
		// viewer frame url
		// parameters : rcpNo, dcmNo, eleId, offset, length, dtd
		
		System.out.println("[JOB]               pattern : " + REGEX_VIEWDOC_FRONT + rcpNoValue + REGEX_VIEWDOC_BEHIND);
		
		Matcher matcher = Pattern.compile(REGEX_VIEWDOC_FRONT + rcpNoValue + REGEX_VIEWDOC_BEHIND).matcher(htmlDocument);
		ArrayList<String> matchStrList = new ArrayList<String>();
		while (matcher.find()) {
			String matcherGroup = matcher.group();
			System.out.println("[JOB]               matcherGroup : " + matcherGroup);
			matchStrList.add(matcherGroup);
		}
		
		for (int idx=0; idx<matchStrList.size(); idx++) {
			matcher = Pattern.compile(REGEX_VIEWDOC_PARAM).matcher(matchStrList.get(idx));
			ArrayList<String> matchParamList = new ArrayList<String>();
			while (matcher.find()) {
				// list(parameters) : 'rcpNo', 'dcmNo', 'eleId', 'offset', 'length', 'dtd' 이 모두 있는게 아니라면 continue
				String val = matcher.group().replaceAll("'", "");
				matchParamList.add(val);
			}
			if (matchParamList.size()<6) continue;	 
			String rcpNo 	= matchParamList.get(0);
			if (!rcpNo.equals(rcpNoValue)) continue;
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
			
			frameUrlList.add(frameURL);
			System.out.println("[JOB]               frame url " + (idx+1) + " : " + frameURL);
		}
		
		return frameUrlList;
	}
	
	
	
	public static void main(String[] args) {

		DartBridge dBridge = new DartBridge();
		ArrayList<String> allDocuments = dBridge.job();
		
		System.out.println("====== size " + allDocuments.size());
		
		for (int idx=0; idx<allDocuments.size(); idx++) {
			System.out.println("\n\n\n");
			String doc = allDocuments.get(idx);
			if (doc.length() < 30) {
				System.out.println(idx + " ] " + allDocuments.get(idx).substring(0, 30));				
			} else {
				System.out.println(idx + " ] " + allDocuments.get(idx).substring(0, 30));
			}
		}
	}
}
