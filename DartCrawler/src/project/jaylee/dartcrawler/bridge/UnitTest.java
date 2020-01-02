package project.jaylee.dartcrawler.bridge;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitTest {

	static String REGEX_VIEWDOC_FRONT	=	"viewDoc\\((\\s*|\\t*)'";
	static String REGEX_VIEWDOC_BEHIND	=	"'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'dart3.xsd'(\\s*|\\t*)\\)(\\s*|\\t*);";
	static String REGEX_VIEWDOC_PARAM	=	"'.+'";
	
	
	public static void main(String[] args) {
		String htmlDocument = "		// 13\r\n" + 
				"		treeNode1 = new Tree.TreeNode({\r\n" + 
				"			text: \"XI. 그 밖에 투자자 보호를 위하여 필요한 사항\",\r\n" + 
				"			id: \"30\",\r\n" + 
				"			cls: \"text\",\r\n" + 
				"			listeners: {\r\n" + 
				"				click: function() {viewDoc('20190401004489', '6615080', '30', '2688495', '89639', 'dart3.xsd');}\r\n" + 
				"			}\r\n" + 
				"		});\r\n" + 
				"		cnt++;\r\n" + 
				"		\r\n" + 
				"		treeRoot.appendChild(treeNode1);\r\n" + 
				"		\r\n" + 
				"	\r\n" + 
				"		// 14\r\n" + 
				"		treeNode1 = new Tree.TreeNode({\r\n" + 
				"			text: \"【 전문가의 확인 】\",\r\n" + 
				"			id: \"31\",\r\n" + 
				"			cls: \"text\",\r\n" + 
				"			listeners: {\r\n" + 
				"				click: function() {viewDoc('20190401004489', '6615080', '31', '2778138', '359', 'dart3.xsd');}\r\n" + 
				"			}\r\n" + 
				"		});\r\n" + 
				"		cnt++;\r\n" + 
				"		\r\n" + 
				"		treeNode2 = new Tree.TreeNode({\r\n" + 
				"			text: \"1. 전문가의 확인\",\r\n" + 
				"			id: \"32\",\r\n" + 
				"			cls: \"text\",\r\n" + 
				"			listeners: {\r\n" + 
				"				click: function() {viewDoc('20190401004489', '6615080', '32', '2778230', '127', 'dart3.xsd');}\r\n" + 
				"			}\r\n" + 
				"		});\r\n" + 
				"		cnt++;\r\n" + 
				"			\r\n" + 
				"		treeNode1.appendChild(treeNode2);\r\n" + 
				"		\r\n" + 
				"		treeNode2 = new Tree.TreeNode({\r\n" + 
				"			text: \"2. 전문가와의 이해관계\",\r\n" + 
				"			id: \"33\",\r\n" + 
				"			cls: \"text\",\r\n" + 
				"			listeners: {\r\n" + 
				"				click: function() {viewDoc('20190401004489', '6615080', '33', '2778361', '122', 'dart3.xsd');}\r\n" + 
				"			}\r\n" + 
				"		});\r\n" + 
				"		cnt++;";
		
		
		String rcpNoValue = "20190401004489";
		
		Matcher matcher = Pattern.compile(REGEX_VIEWDOC_FRONT + rcpNoValue + REGEX_VIEWDOC_BEHIND).matcher(htmlDocument);
		//Matcher matcher = Pattern.compile("viewDoc\\((\\s*|\\t*)'20190401004489'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'[0-9]+'(\\s*|\\t*),(\\s*|\\t*)'dart3.xsd'(\\s*|\\t*)\\)(\\s*|\\t*);").matcher(htmlDocument);
		ArrayList<String> matchStrList = new ArrayList<String>();
		while (matcher.find()) {
			String matcherGroup = matcher.group();
			System.out.println("[JOB]              matcherGroup : " + matcherGroup);
			matchStrList.add(matcherGroup);
		}
	}

}
