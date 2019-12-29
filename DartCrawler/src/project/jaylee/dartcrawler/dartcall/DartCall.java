package project.jaylee.dartcrawler.dartcall;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import project.jaylee.dartcrawler.dartapi.DartParser;
import project.jaylee.dartcrawler.dartapi.RequestDart;
import project.jaylee.dartcrawler.dartapi.ResponseDart;

/**
 * DartCall
 * Dart API 호출 및 반환
 */
public class DartCall {
	Calendar cal 			= null;
	String 	 df_start_dt 	= "";
	String 	 df_end_dt 		= "";
	
	public DartCall() {
		this.cal = Calendar.getInstance();
		setDefaultDate();
	}
	
	private void setDefaultDate() {
		this.df_start_dt = "" + this.cal.get(this.cal.YEAR) + this.cal.get(this.cal.MONTH) + this.cal.get(this.cal.DATE);
		if (this.cal.MONTH == 2 && this.cal.DATE == 29) this.cal.add(this.cal.DATE, -1);
		this.cal.add(this.cal.YEAR, -10);
		this.df_end_dt = "" + this.cal.get(this.cal.YEAR) + this.cal.get(this.cal.MONTH) + this.cal.get(this.cal.DATE);
	}
	
	private Calendar getCal() {
		return cal;
	}
	private void setCal(Calendar cal) {
		this.cal = cal;
	}
	private String getDf_start_dt() {
		return df_start_dt;
	}
	private void setDf_start_dt(String df_start_dt) {
		this.df_start_dt = df_start_dt;
	}
	private String getDf_end_dt() {
		return df_end_dt;
	}
	private void setDf_end_dt(String df_end_dt) {
		this.df_end_dt = df_end_dt;
	}

	
	/**
	 * callAPI
	 * 샘플 : 네이버의 10년 사업보고서(최종본만) 날짜순으로 정렬
	 */
	public ResponseDart callAPI() {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		"ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6"	);
					reqDart.setCrp_cd(		"035420"									);
					reqDart.setEnd_dt(		""											);
					reqDart.setStart_dt(	"20090101"									);
					reqDart.setFin_rpt(		"Y"											);
					reqDart.setDsp_tp(		""											);
					reqDart.setBsn_tp(		"A001"										);
					reqDart.setSort(		"date"										);
					reqDart.setSeries(		"desc"										);
					reqDart.setPage_no(		""											);
					reqDart.setPage_set(	""											);
					reqDart.setCallback(	""											);
					
		return new DartParser().parse(reqDart);
	}
	
	/**
	 * callAPI
	 * 특정 기업의 코드만 입력시,
	 * 10년 내의 최종 사업보고서만 출력
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 */
	public ResponseDart callAPI(String auth, String crp_cd) {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		auth										);	// ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6
					reqDart.setCrp_cd(		crp_cd										);	// 035420
					reqDart.setEnd_dt(		getDf_end_dt()								);
					reqDart.setStart_dt(	getDf_start_dt()							);	// 20090101
					reqDart.setFin_rpt(		"Y"											);	// Y
					reqDart.setDsp_tp(		""											);
					reqDart.setBsn_tp(		"A001"										);	// A001
					reqDart.setSort(		""											);
					reqDart.setSeries(		""											);
					reqDart.setPage_no(		""											);
					reqDart.setPage_set(	""											);
					reqDart.setCallback(	""											);
					
		return new DartParser().parse(reqDart);
	}
	
	/**
	 * callAPI
	 * 특정 기업을 특정기간, 상세공시유형으로 출력
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 * start_dt		: 검색 시작 날짜
	 * fin_rpt		: 최종보고만 기재 여부
	 * bsn_tp		: 상세유형
	 */
	public ResponseDart callAPI(String auth, String crp_cd, String start_dt, String fin_rpt, String bsn_tp) {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		auth										);	// ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6
					reqDart.setCrp_cd(		crp_cd										);	// 035420
					reqDart.setEnd_dt(		getDf_end_dt()								);
					reqDart.setStart_dt(	start_dt									);	// 20090101
					reqDart.setFin_rpt(		fin_rpt										);	// Y
					reqDart.setDsp_tp(		""											);
					reqDart.setBsn_tp(		bsn_tp										);	// A001
					reqDart.setSort(		""											);
					reqDart.setSeries(		""											);
					reqDart.setPage_no(		""											);
					reqDart.setPage_set(	""											);
					reqDart.setCallback(	""											);
					
		return new DartParser().parse(reqDart);
	}
	
	/**
	 * callAPI
	 * 전체설정 (공시유형으로)
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 * end_dt		: 검색 종료 날짜
	 * start_dt		: 검색 시작 날짜
	 * fin_rpt		: 최종보고만 기재 여부
	 * dsp_tp		: 공시유형
	 * sort			: 정렬
	 * series		: 정렬방향
	 * page_no		: 페이지번호
	 * page_set		: 페이지크기
	 */
	public ResponseDart callAPI(String auth, String crp_cd, String end_dt, String start_dt, String fin_rpt, String dsp_tp,
								String sort, String series, String page_no, String page_set) {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		auth										);	// ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6
					reqDart.setCrp_cd(		crp_cd										);	// 035420
					reqDart.setEnd_dt(		end_dt										);
					reqDart.setStart_dt(	start_dt									);	// 20090101
					reqDart.setFin_rpt(		fin_rpt										);	// Y, N
					reqDart.setDsp_tp(		dsp_tp										);	// A~J
					reqDart.setBsn_tp(		""											);	// A001~J006
					reqDart.setSort(		sort										);	// date, crp, rtp
					reqDart.setSeries(		series										);	// desc, asc
					reqDart.setPage_no(		page_no										);	// 1, ... , n
					reqDart.setPage_set(	page_set									);	// 10, 1~100
					reqDart.setCallback(	""											);
					
		return new DartParser().parse(reqDart);
	}
	
	/**
	 * callAPI
	 * 전체설정 (공시유형 무시하고 상세유형으로)
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 * end_dt		: 검색 종료 날짜
	 * start_dt		: 검색 시작 날짜
	 * fin_rpt		: 최종보고만 기재 여부
	 * dsp_tp		: 공시유형
	 * bsn_tp		: 상세유형
	 * sort			: 정렬
	 * series		: 정렬방향
	 * page_no		: 페이지번호
	 * page_set		: 페이지크기
	 */
	public ResponseDart callAPI(String auth, String crp_cd, String end_dt, String start_dt, String fin_rpt, String dsp_tp, 
								String bsn_tp, String sort, String series, String page_no, String page_set) {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		auth										);	// ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6
					reqDart.setCrp_cd(		crp_cd										);	// 035420
					reqDart.setEnd_dt(		end_dt										);
					reqDart.setStart_dt(	start_dt									);	// 20090101
					reqDart.setFin_rpt(		fin_rpt										);	// Y, N
					reqDart.setDsp_tp(		""											);	// A~J
					reqDart.setBsn_tp(		bsn_tp										);	// A001~J006
					reqDart.setSort(		sort										);	// date, crp, rtp
					reqDart.setSeries(		series										);	// desc, asc
					reqDart.setPage_no(		page_no										);	// 1, ... , n
					reqDart.setPage_set(	page_set									);	// 10, 1~100
					reqDart.setCallback(	""											);
					
		return new DartParser().parse(reqDart);
	}
	
	
	/**
	 * getUrlList
	 * callAPI() 의 리턴 ResponseDart를 인자로 한다. ResponseDart의 rcp_no는  DART 뷰어 url의 파라미터이다.
	 */
	public ArrayList<String> getUrlList(ResponseDart respDart) {
		ArrayList<String> rcpNoList = respDart.getRcp_no();
		ArrayList<String> urlList = new ArrayList<String>();
		
		int len = rcpNoList.size();
		for (int idx=0; idx<len; idx++) {
			// PC
			urlList.add(	"http://dart.fss.or.kr/dsaf001/main.do?rcpNo=" + rcpNoList.get(idx)		);
			
			// Mobile
			//urlList.add(	"http://m.dart.fss.or.kr/html_mdart/MD1007.html?rcpNo=" + rcpNoList.get(idx)		);
		}
		
		return urlList;
	}


}
