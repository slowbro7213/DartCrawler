package project.jaylee.dartcrawler.dartapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * DartParser
 * Dart API 파라미터를 세팅한대로 결과 json/xml 을 가져오고 Gson으로 파싱하는 클래스
 */
public class DartParser {
	Gson gson = null;

	public DartParser() {
		gson = new Gson();
	}
	
	
	public String getParameters(RequestDart reqDart) {
		String parameters = "";
		
		String parameter = reqDart.getRequestUrl();
		if (parameter == null || parameter.equals("")) return null;
		
		parameter = reqDart.getAuth();
		if (parameter == null || parameter.equals("")) return null; else parameters += "&auth=" + parameter;
		
		parameter = reqDart.getCrp_cd();
		if (parameter != null && !parameter.equals("")) parameters += "&crp_cd=" + parameter;
		
		parameter = reqDart.getEnd_dt();
		if (parameter != null && !parameter.equals("")) parameters += "&end_dt=" + parameter;
		
		parameter = reqDart.getStart_dt();
		if (parameter != null && !parameter.equals("")) parameters += "&start_dt=" + parameter;
		
		parameter = reqDart.getFin_rpt();
		if (parameter != null && !parameter.equals("")) parameters += "&fin_rpt=" + parameter;
		
		parameter = reqDart.getDsp_tp();
		if (parameter != null && !parameter.equals("")) parameters += "&dsp_tp=" + parameter;
		
		parameter = reqDart.getBsn_tp();
		if (parameter != null && !parameter.equals("")) parameters += "&bsn_tp=" + parameter;
		
		parameter = reqDart.getSort();
		if (parameter != null && !parameter.equals("")) parameters += "&sort=" + parameter;
		
		parameter = reqDart.getSeries();
		if (parameter != null && !parameter.equals("")) parameters += "&series=" + parameter;
		
		parameter = reqDart.getPage_no();
		if (parameter != null && !parameter.equals("")) parameters += "&page_no=" + parameter;
		
		parameter = reqDart.getPage_set();
		if (parameter != null && !parameter.equals("")) parameters += "&page_set=" + parameter;
		
		parameter = reqDart.getCallback();
		if (parameter != null && !parameter.equals("")) parameters += "&callback=" + parameter;
		
		if (parameters.startsWith("&")) parameters = parameters.substring(1, parameters.length());
		
		return parameters;
	}
	
	
	public String getDartJson(String dartApiUrl, String parameters) {
		StringBuffer receiveMsg = new StringBuffer();
		HttpURLConnection uc = null;
		try {
			URL servletUrl = new URL(dartApiUrl + "?" + parameters);
			uc = (HttpURLConnection) servletUrl.openConnection();
			uc.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			uc.setRequestMethod("POST");
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setUseCaches(false);
			uc.setDefaultUseCaches(false);
			DataOutputStream dos = new DataOutputStream (uc.getOutputStream());
			dos.write(parameters.getBytes());
			dos.flush();
			dos.close();
			
			int errorCode = 0;
			if (uc.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String currLine = "";
                BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
                while ((currLine = in.readLine()) != null) {
                	receiveMsg.append(currLine).append("\r\n");
                }
                in.close();
            } else {
                  errorCode = uc.getResponseCode();
                  return receiveMsg.toString();
             }
       } catch(Exception ex) {
            System.out.println(ex);
       } finally {
            uc.disconnect();
       }

		return receiveMsg.toString();
	}
	
	
	public ResponseDart parse(RequestDart reqDart) {
		String json = getDartJson(reqDart.getRequestUrl(), getParameters(reqDart));
		if (json == null || json.equals("")) return null;
		
		JsonElement jsonRoot = new JsonParser().parse(json);
		ResponseDart respDart = new ResponseDart();
					 respDart.setErr_code(		jsonRoot.getAsJsonObject().get("err_code").getAsString()	);
					 respDart.setErr_msg(		jsonRoot.getAsJsonObject().get("err_msg").getAsString()		);
					 respDart.setPage_no(		jsonRoot.getAsJsonObject().get("page_no").getAsInt()		);
					 respDart.setPage_set(		jsonRoot.getAsJsonObject().get("page_set").getAsInt()		);
					 respDart.setTotal_count(	jsonRoot.getAsJsonObject().get("total_count").getAsInt()	);
					 respDart.setTotal_page(	jsonRoot.getAsJsonObject().get("total_page").getAsInt()		);
		
		JsonArray list = jsonRoot.getAsJsonObject().get("list").getAsJsonArray();
		ArrayList<String> temp1 =	new ArrayList<String>();
		ArrayList<String> temp2 =	new ArrayList<String>();
		ArrayList<String> temp3 =	new ArrayList<String>();
		ArrayList<String> temp4 =	new ArrayList<String>();
		ArrayList<String> temp5 =	new ArrayList<String>();
		ArrayList<String> temp6 =	new ArrayList<String>();
		ArrayList<String> temp7 =	new ArrayList<String>();
		ArrayList<String> temp8 =	new ArrayList<String>();
		
		for (int idx=0; idx<list.size(); idx++) {
			JsonElement ele = list.get(idx);
			temp1.add(	ele.getAsJsonObject().get("crp_cls").getAsString()	);
			temp2.add(	ele.getAsJsonObject().get("crp_nm").getAsString()	);
			temp3.add(	ele.getAsJsonObject().get("crp_cd").getAsString()	);
			temp4.add(	ele.getAsJsonObject().get("rpt_nm").getAsString()	);
			temp5.add(	ele.getAsJsonObject().get("rcp_no").getAsString()	);
			temp6.add(	ele.getAsJsonObject().get("flr_nm").getAsString()	);
			temp7.add(	ele.getAsJsonObject().get("rcp_dt").getAsString()	);
			temp8.add(	ele.getAsJsonObject().get("rmk").getAsString()		);
		}
		
					respDart.setCrp_cls(	temp1	);
					respDart.setCrp_nm(		temp2	);
					respDart.setCrp_cd(		temp3	);
					respDart.setRpt_nm(		temp4	);
					respDart.setRcp_no(		temp5	);
					respDart.setFlr_nm(		temp6	);
					respDart.setRcp_dt(		temp7	);
					respDart.setRmk(		temp8	);
		
		return respDart;
	}
	
	
}
