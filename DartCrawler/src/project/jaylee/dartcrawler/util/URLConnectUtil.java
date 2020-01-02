package project.jaylee.dartcrawler.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectUtil {
	
	/**
	 * getHtmlDocument
	 * @param url
	 * @param parameters
	 * @return
	 */
	public static String getHtmlDocument(String url, String parameters) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection uc = null;
		try {
			URL servletUrl = new URL(url);
			uc = (HttpURLConnection) servletUrl.openConnection();
			uc.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			uc.setRequestMethod("POST");
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setUseCaches(false);
			uc.setDefaultUseCaches(false);
			uc.setConnectTimeout(2000);
			uc.setReadTimeout(2000);
			DataOutputStream dos = new DataOutputStream (uc.getOutputStream());
			dos.write(parameters.getBytes());
			dos.flush();
			dos.close();
			
			int errorCode = 0;
			if (uc.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String line = "";
                BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
                while ((line = in.readLine()) != null) {
                	sb.append(line).append("\r\n");
                }
                in.close();
            } else {
                  errorCode = uc.getResponseCode();
                  return sb.toString();
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			uc.disconnect();
		}
		return sb.toString();
	}
	
}
