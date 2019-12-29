package project.jaylee.dartcrawler.config;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * DartAPIConfig
 * Dart API 호출 클래스에 넘길 파라미터를 정리하는 config를 읽는 클래스
 */
public class DartAPIConfig {
	String configPath = "";
	DartAPIParams daParams = null;
	
	public DartAPIConfig() {
		this.configPath = findConfig();
		this.daParams = new DartAPIParams();
	}

	private String findConfig() {
		return System.getProperty("user.dir");
	}
	public ArrayList<String> readConfig() {
		ArrayList<String> params = new ArrayList<String>();
		
		// 실제로는 config에서 읽어온 값을 저장
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(daParams.AUTH		, "ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6"	);
		map.put(daParams.CRP_CD		, "035420"										);
		map.put(daParams.END_DT		, ""											);
		map.put(daParams.START_DT	, ""											);
		map.put(daParams.FIN_RPT	, ""											);
		map.put(daParams.DSP_TP		, ""											);
		map.put(daParams.BSN_TP		, ""											);
		map.put(daParams.SORT		, ""											);
		map.put(daParams.SERIES		, ""											);
		map.put(daParams.PAGE_NO	, ""											);
		map.put(daParams.PAGE_SET	, ""											);
		map.put(daParams.CALLBACK	, ""											);
		//

		String param = "";
		param = map.get(daParams.AUTH		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.CRP_CD		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.END_DT		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.START_DT	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.FIN_RPT	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.DSP_TP		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.BSN_TP		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.SORT		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.SERIES		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.PAGE_NO	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.PAGE_SET	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(daParams.CALLBACK	);
		if (param != null && !param.equals("")) params.add(param);
		
		return params;
	}
	
	public String getConfigPath() {
		return configPath;
	}
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	
}
