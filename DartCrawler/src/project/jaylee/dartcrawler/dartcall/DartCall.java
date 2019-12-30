package project.jaylee.dartcrawler.dartcall;

import java.util.ArrayList;
import java.util.Calendar;

import project.jaylee.dartcrawler.config.DartAPIProperty;
import project.jaylee.dartcrawler.dartapi.DartParser;
import project.jaylee.dartcrawler.dartapi.RequestDart;
import project.jaylee.dartcrawler.dartapi.ResponseDart;

/**
 * DartCall
 * Dart API 호출 및 반환
 */
public class DartCall {
	Calendar cal 			= null;
	String	 df_tp 			= "";
	String 	 df_start_dt 	= "";
	String 	 df_end_dt 		= "";
	
	public DartCall() {
		this.cal 	= Calendar.getInstance();
		this.df_tp 	= "A001";
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
	private String getDf_tp() {
		return df_tp;
	}
	private void setDf_tp(String df_tp) {
		this.df_tp = df_tp;
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
	 * 파라미터를 list로 받은 경우
	 */
	public ResponseDart callAPI(ArrayList<String> params) {
		int paramSize = params.size();
		
		if (paramSize == 2) {
			return callAPI(
							params.get(0), params.get(1)
						  );
		} else if (paramSize == 5) {
			return callAPI(
							params.get(0), params.get(1),
							params.get(2), params.get(3),
							params.get(4)
						  );
		} else if (paramSize == 10) {
			return callAPI(
							params.get(0), params.get(1),
							params.get(2), params.get(3),
							params.get(4), params.get(5),
							params.get(6), params.get(7),
							params.get(8), params.get(9)
						  );
		} else if (paramSize >= 12) {
			return callAPI(
							params.get(0), params.get(1),
							params.get(2), params.get(3),
							params.get(4), params.get(5),
							params.get(6), params.get(7),
							params.get(8), params.get(9),
							params.get(10), params.get(11)
						  );
		}
		return callAPI();

	}
	
	/**
	 * callAPI
	 * (샘플)네이버의 10년 사업보고서(최종본만) 날짜순으로 정렬
	 * 
	 * parameter size 0
	 */
	public ResponseDart callAPI() {	
		return callAPI("ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6",
						"035420", getDf_end_dt(), getDf_start_dt(), "Y", "", "A001", "date", "desc", "", "", "");
	}
	
	/**
	 * callAPI
	 * 특정 기업의 코드만 입력시,
	 * 10년 내의 최종 사업보고서만 출력
	 * 
	 * parameter size 2
	 * 
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 */
	public ResponseDart callAPI(String auth, String crp_cd) {
		return callAPI(auth, crp_cd, getDf_end_dt(), getDf_start_dt(), "Y", "", "A001", "", "", "", "", "");
	}
	
	/**
	 * callAPI
	 * 특정 기업을 특정기간, 상세공시유형으로 출력
	 * 
	 * parameter size 5
	 * 
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 * start_dt		: 검색 시작 날짜
	 * fin_rpt		: 최종보고만 기재 여부
	 * bsn_tp		: 상세유형
	 */
	public ResponseDart callAPI(String auth, String crp_cd, String start_dt, String fin_rpt, String bsn_tp) {
		return callAPI(auth, crp_cd, "", start_dt, fin_rpt, "", bsn_tp, "", "", "", "", "");
	}
	
	/**
	 * callAPI
	 * 전체설정 (공시유형으로)
	 * 
	 * parameter size 10
	 * 
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
		return callAPI(auth, crp_cd, end_dt, start_dt, fin_rpt, dsp_tp, "", sort, series, page_no, page_set, "");
	}
	
	/**
	 * callAPI
	 * 전체설정 (공시유형, 상세유형 모두 존재할 경우 공시유형 제거)
	 * 
	 * parameter size 12
	 * 
	 * auth			: 인증키
	 * crp_cd		: 종목코드(6자리) or 고유번호(8자리)
	 * end_dt		: 검색 종료 날짜
	 * start_dt		: 검색 시작 날짜
	 * fin_rpt		: 최종보고만 기재 여부
	 * dsp_tp		: 공시유형
	 * bsn_tp		: 상세유형 (공시유형, 상세유형 둘 다 존재하는 경우 상세유형만 적용한다)
	 * sort			: 정렬
	 * series		: 정렬방향
	 * page_no		: 페이지번호
	 * page_set		: 페이지크기
	 * callback		: jsonp 사용 시 콜백함수
	 */
	public ResponseDart callAPI(String auth, String crp_cd, String end_dt, String start_dt, String fin_rpt, String dsp_tp, 
								String bsn_tp, String sort, String series, String page_no, String page_set, String callback) {
		
		// parameter default set :: start
		if (end_dt == null || end_dt.equals("")) 	 	end_dt 		= getDf_end_dt();
		if (start_dt == null || start_dt.equals("")) 	start_dt 	= getDf_start_dt();
		
		if (fin_rpt == null || fin_rpt.equals(""))	 	fin_rpt 	= "Y";
		
		boolean hasDsp_tp = false;
		boolean hasBsn_tp = false;
		if (dsp_tp != null && !dsp_tp.equals(""))	 	hasDsp_tp 	= true;
		if (bsn_tp != null && !bsn_tp.equals(""))	 	hasBsn_tp 	= true;
		if (hasDsp_tp && hasBsn_tp) {
			dsp_tp = "";
		} else if (!hasDsp_tp && !hasBsn_tp) {
			bsn_tp = getDf_tp();
		}
		
		if (sort == null || !sort.equals(""))		 	sort 		= "date";
		if (series == null || !series.equals(""))	 	series		= "desc";
		if (page_no == null || !page_no.equals(""))	 	page_no		= "1";
		if (page_set == null || !page_set.equals(""))	page_set	= "10";
		// parameter default set :: end
		
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth(		auth				);	// ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6
					reqDart.setCrp_cd(		crp_cd				);	// 035420
					reqDart.setEnd_dt(		end_dt				);	// yyyyMMdd
					reqDart.setStart_dt(	start_dt			);	// yyyyMMdd
					reqDart.setFin_rpt(		fin_rpt				);	// Y, N
					reqDart.setDsp_tp(		dsp_tp				);	// A~J
					reqDart.setBsn_tp(		bsn_tp				);	// A001~J006
					reqDart.setSort(		sort				);	// date, crp, rtp
					reqDart.setSeries(		series				);	// desc, asc
					reqDart.setPage_no(		page_no				);	// 1, ... , n
					reqDart.setPage_set(	page_set			);	// 10, 1~100
					reqDart.setCallback(	callback			);
					
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
			urlList.add(	DartAPIProperty.DART_VIEWER_PC_URL + "?" + DartAPIProperty.RCP_NO + "=" + rcpNoList.get(idx)	);
			
			// Mobile
			//urlList.add(	DartAPIProperty.DART_VIEWER_MB_URL + "?" + DartAPIProperty.RCP_NO + "=" + rcpNoList.get(idx)	);
		}
		
		return urlList;
	}


}
