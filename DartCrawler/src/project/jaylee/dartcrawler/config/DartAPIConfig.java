package project.jaylee.dartcrawler.config;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * DartAPIConfig
 * Dart API 호출 클래스에 넘길 파라미터를 정리하는 config를 읽는 클래스
 */
public class DartAPIConfig {
	String configPath = "";
	HashMap<String,String> daConfigMap = null;
	
	public DartAPIConfig() {
		this.configPath = findConfig();
		daConfigMap = new HashMap<String,String>();
	}

	private String findConfig() {
		return System.getProperty("user.dir");
	}
	public ArrayList<String> readConfig() {
		ArrayList<String> params = new ArrayList<String>();
		
		// 실제로는 config에서 읽어온 값을 저장
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(DartAPIProperty.AUTH		, "ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6"	);
		map.put(DartAPIProperty.CRP_CD		, "035420"										);
		map.put(DartAPIProperty.END_DT		, ""											);
		map.put(DartAPIProperty.START_DT	, ""											);
		map.put(DartAPIProperty.FIN_RPT		, ""											);
		map.put(DartAPIProperty.DSP_TP		, ""											);
		map.put(DartAPIProperty.BSN_TP		, ""											);
		map.put(DartAPIProperty.SORT		, ""											);
		map.put(DartAPIProperty.SERIES		, ""											);
		map.put(DartAPIProperty.PAGE_NO		, ""											);
		map.put(DartAPIProperty.PAGE_SET	, ""											);
		map.put(DartAPIProperty.CALLBACK	, ""											);
		//

		setDaConfigMap(map);
		
		String param = "";
		param = map.get(DartAPIProperty.AUTH		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.CRP_CD		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.END_DT		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.START_DT	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.FIN_RPT	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.DSP_TP		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.BSN_TP		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.SORT		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.SERIES		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.PAGE_NO		);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.PAGE_SET	);
		if (param != null && !param.equals("")) params.add(param);
		param = map.get(DartAPIProperty.CALLBACK	);
		if (param != null && !param.equals("")) params.add(param);
		
		return params;
	}
	
	public void print(HashMap<String,String> map) {
		System.out.println("\n\n");
		System.out.println("[DartAPIConfig] Config parameters setting...");
		System.out.println("        auth     : " + map.get(DartAPIProperty.AUTH		)	);
		System.out.println("        crp_cd   : " + map.get(DartAPIProperty.CRP_CD	)	);
		System.out.println("        end_dt   : " + map.get(DartAPIProperty.END_DT	)	);
		System.out.println("        start_dt : " + map.get(DartAPIProperty.START_DT	)	);
		System.out.println("        fin_rpt  : " + map.get(DartAPIProperty.FIN_RPT	)	);
		System.out.println("        dsp_tp   : " + map.get(DartAPIProperty.DSP_TP	)	);
		System.out.println("        bsn_tp   : " + map.get(DartAPIProperty.BSN_TP	)	);
		System.out.println("        sort     : " + map.get(DartAPIProperty.SORT		)	);
		System.out.println("        series   : " + map.get(DartAPIProperty.SERIES	)	);
		System.out.println("        page_no  : " + map.get(DartAPIProperty.PAGE_NO	)	);
		System.out.println("        page_set : " + map.get(DartAPIProperty.PAGE_SET	)	);
		System.out.println("        callback : " + map.get(DartAPIProperty.CALLBACK	)	);
		System.out.println("\n\n");
	}
	
	
	public String getConfigPath() {
		return configPath;
	}
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
	public HashMap<String, String> getDaConfigMap() {
		return daConfigMap;
	}
	public void setDaConfigMap(HashMap<String, String> daConfigMap) {
		this.daConfigMap = daConfigMap;
	}

	
}
