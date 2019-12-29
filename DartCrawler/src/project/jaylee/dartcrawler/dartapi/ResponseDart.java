package project.jaylee.dartcrawler.dartapi;

import java.util.ArrayList;

/**
 * ResponseDart
 * Dart API 응답 결과
 * 
 * err_code		에러코드
 * err_msg		에러메시지
 * 				000	정상
 * 				010	등록되지 않은 키입니다.
 * 				011	사용할 수 없는 키입니다. 오픈API에 등록되었으나, 일시적으로 사용 중지된 키를 통하여 검색하는 경우 발생합니다.
 * 				020	요청 제한을 초과하였습니다. 일반적으로는 10,000건 이상의 요청에 대하여 이 에러 메시지가 발생되나, 요청 제한이 다르게 설정된 경우에는 이에 준하여 발생됩니다.
 * 				100	필드의 부적절한 값입니다. 필드 설명에 없는 값을 사용한 경우에 발생하는 메시지입니다.
 * 				800	원활한 공시서비스를 위하여 오픈API 서비스가 중지 중입니다.
 * 				900	정의되지 않은 오류가 발생하였습니다.
 * 
 * page_no		페이지 번호
 * page_set		페이지당 건수
 * total_count	총 건수
 * total_page	총 페이지 수
 * crp_cls		법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
 * 
 * crp_nm	공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
 * crp_cd	공시대상회사의 종목코드(6자리) 또는 고유번호(8자리)
 * rpt_nm	공시구분+보고서명+기타정보
 * 			[기재정정] : 본 보고서명으로 이미 제출된 보고서의 기재내용이 변경되어 제출된 것임
 * 			[첨부정정] : 본 보고서명으로 이미 제출된 보고서의 첨부내용이 변경되어 제출된 것임
 * 			[첨부추가] : 본 보고서명으로 이미 제출된 보고서의 첨부서류가 추가되어 제출된 것임
 * 			[변경등록] : 본 보고서명으로 이미 제출된 보고서의 유동화계획이 변경되어 제출된 것임
 * 			[연장결정] : 본 보고서명으로 이미 제출된 보고서의 신탁계약이 연장되어 제출된 것임
 * 			[발행조건확정] : 본 보고서명으로 이미 제출된 보고서의 유가증권 발행조건이 확정되어 제출된 것임
 * 			[정정명령부과] : 본 보고서에 대하여 금융감독원이 정정명령을 부과한 것임
 * 			[정정제출요구] : 본 보고서에 대하여 금융감독원이 정정제출요구을 부과한 것임
 * rcp_no	접수번호(공시뷰어 연결에 이용)
 * 			- PC용 : http://dart.fss.or.kr/dsaf001/main.do?rcpNo=접수번호
 * 			- 모바일용 : http://m.dart.fss.or.kr/html_mdart/MD1007.html?rcpNo=접수번호
 * flr_nm	공시 제출인명
 * rcp_dt	공시 접수일자(YYYYMMDD)
 * rmk	조합된 문자로 각각은 아래와 같은 의미가 있음
 * 		유 : 본 공시사항은 한국거래소 유가증권시장본부 소관임
 * 		코 : 본 공시사항은 한국거래소 코스닥시장본부 소관임
 * 		채 : 본 문서는 한국거래소 채권상장법인 공시사항임
 * 		넥 : 본 문서는 한국거래소 코넥스시장 소관임
 * 		공 : 본 공시사항은 공정거래위원회 소관임
 * 		연 : 본 보고서는 연결부분을 포함한 것임
 * 		정 : 본 보고서 제출 후 정정신고가 있으니 관련 보고서를 참조하시기 바람
 * 		철 : 본 보고서는 철회(간주)되었으니 관련 철회신고서(철회간주안내)를 참고하시기 바람
 */
public class ResponseDart {
	String err_code					= "";
	String err_msg					= "";
	int page_no						= 0;
	int page_set					= 0;
	int total_count					= 0;
	int total_page					= 0;
	ArrayList<String> crp_cls		= null;
	ArrayList<String> crp_nm		= null;
	ArrayList<String> crp_cd		= null;
	ArrayList<String> rpt_nm		= null;
	ArrayList<String> rcp_no		= null;
	ArrayList<String> flr_nm		= null;
	ArrayList<String> rcp_dt		= null;
	ArrayList<String> rmk			= null;
	
	
	public void print() {
		System.out.println("\n\n");
		System.out.println("  err_code    : " + getErr_code()		);
		System.out.println("  err_msg     : " + getErr_msg()		);
		System.out.println("  page_no     : " + getPage_no()		);
		System.out.println("  page_set    : " + getPage_set()		);
		System.out.println("  total_count : " + getTotal_count()	);
		System.out.println("  total_page  : " + getTotal_page()		);
		System.out.println("  crp_cls     :");
			for (int idx=0; idx<crp_cls.size(); idx++) System.out.println("             " + idx + "  " + crp_cls.get(idx)	);
		System.out.println("  crp_nm      :");
			for (int idx=0; idx<crp_nm.size();  idx++) System.out.println("             " + idx + "  " + crp_nm.get(idx)	);
		System.out.println("  crp_cd      :");
			for (int idx=0; idx<crp_cd.size(); 	idx++) System.out.println("             " + idx + "  " + crp_cd.get(idx)	);
		System.out.println("  rpt_nm      :");
			for (int idx=0; idx<rpt_nm.size(); 	idx++) System.out.println("             " + idx + "  " + rpt_nm.get(idx)	);
		System.out.println("  rcp_no      :");
			for (int idx=0; idx<rcp_no.size(); 	idx++) System.out.println("             " + idx + "  " + rcp_no.get(idx)	);
		System.out.println("  flr_nm      :");
			for (int idx=0; idx<flr_nm.size(); 	idx++) System.out.println("             " + idx + "  " + flr_nm.get(idx)	);
		System.out.println("  rcp_dt      :");
			for (int idx=0; idx<rcp_dt.size(); 	idx++) System.out.println("             " + idx + "  " + rcp_dt.get(idx)	);
		System.out.println("  rmk         :");
			for (int idx=0; idx<rmk.size(); 	idx++) System.out.println("             " + idx + "  " + rmk.get(idx)		);
	}
	
	
	public boolean checkErrCode() {
		if (getErr_code().equals("000")) return true;
		return false;
	}
	
	
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_msg() {
		return err_msg;
	}
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	public int getPage_set() {
		return page_set;
	}
	public void setPage_set(int page_set) {
		this.page_set = page_set;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	public ArrayList<String> getCrp_cls() {
		return crp_cls;
	}
	public void setCrp_cls(ArrayList<String> crp_cls) {
		this.crp_cls = crp_cls;
	}
	public ArrayList<String> getCrp_nm() {
		return crp_nm;
	}
	public void setCrp_nm(ArrayList<String> crp_nm) {
		this.crp_nm = crp_nm;
	}
	public ArrayList<String> getCrp_cd() {
		return crp_cd;
	}
	public void setCrp_cd(ArrayList<String> crp_cd) {
		this.crp_cd = crp_cd;
	}
	public ArrayList<String> getRpt_nm() {
		return rpt_nm;
	}
	public void setRpt_nm(ArrayList<String> rpt_nm) {
		this.rpt_nm = rpt_nm;
	}
	public ArrayList<String> getRcp_no() {
		return rcp_no;
	}
	public void setRcp_no(ArrayList<String> rcp_no) {
		this.rcp_no = rcp_no;
	}
	public ArrayList<String> getFlr_nm() {
		return flr_nm;
	}
	public void setFlr_nm(ArrayList<String> flr_nm) {
		this.flr_nm = flr_nm;
	}
	public ArrayList<String> getRcp_dt() {
		return rcp_dt;
	}
	public void setRcp_dt(ArrayList<String> rcp_dt) {
		this.rcp_dt = rcp_dt;
	}
	public ArrayList<String> getRmk() {
		return rmk;
	}
	public void setRmk(ArrayList<String> rmk) {
		this.rmk = rmk;
	}
	
	
}
