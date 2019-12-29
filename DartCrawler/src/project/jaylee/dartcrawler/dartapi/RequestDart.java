package project.jaylee.dartcrawler.dartapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * RequestDart
 * Dart API ��û����
 * var					description							format							default
 * 
 * dartApiUrl		:	API ȣ��url(json����)
 * auth				:	����Ű
 * crp_cd			:	����� �����ڵ� or ��Ÿ���� ������ȣ			6�ڸ� or 8�ڸ�
 * end_dt			:	�������� ��								YYYYMMDD						today
 * start_dt			:	�������� ����							YYYYMMDD						end_dt(crp_cd ���ٸ� 3����)
 * fin_rpt			:	�ຸ֠���� �˻�����						Y/N								N
 * dsp_tp			:	����									A(�������)
 * bsn_tp			:	������								A001(�������)
 * sort				:	����									date/crp(ȸ���)/rpt(������)		date
 * series			:	���Ĺ���								asc/desc						desc
 * page_no			:	������ ��ȣ								n								1
 * page_set			:	�������� �Ǽ�							�ִ�100							10
 * callback			:	�ݹ��Լ���(JSONP ����)
 */
public class RequestDart {
	private String requestUrl 		= "";
	private String auth 			= "";
	private String crp_cd 			= "";
	private String end_dt 			= "";
	private String start_dt 		= "";
	private String fin_rpt 			= "";
	private String dsp_tp 			= "";
	private String bsn_tp 			= "";
	private String sort 			= "";
	private String series 			= "";
	private String page_no 			= "";
	private String page_set 		= "";
	private String callback 		= "";
	

	public RequestDart() {
		this.requestUrl = "http://dart.fss.or.kr/api/search.json";
	}
	
	public RequestDart(String url) {
		this.requestUrl = url;
	}
		
	
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getCrp_cd() {
		return crp_cd;
	}
	public void setCrp_cd(String crp_cd) {
		this.crp_cd = crp_cd;
	}
	public String getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getFin_rpt() {
		return fin_rpt;
	}
	public void setFin_rpt(String fin_rpt) {
		this.fin_rpt = fin_rpt;
	}
	public String getDsp_tp() {
		return dsp_tp;
	}
	public void setDsp_tp(String dsp_tp) {
		this.dsp_tp = dsp_tp;
	}
	public String getBsn_tp() {
		return bsn_tp;
	}
	public void setBsn_tp(String bsn_tp) {
		this.bsn_tp = bsn_tp;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getPage_no() {
		return page_no;
	}
	public void setPage_no(String page_no) {
		this.page_no = page_no;
	}
	public String getPage_set() {
		return page_set;
	}
	public void setPage_set(String page_set) {
		this.page_set = page_set;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}

}
