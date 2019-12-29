package project.jaylee.dartcrawler.dartapi;

import java.util.ArrayList;

/**
 * ResponseDart
 * Dart API ���� ���
 * 
 * err_code		�����ڵ�
 * err_msg		�����޽���
 * 				000	����
 * 				010	��ϵ��� ���� Ű�Դϴ�.
 * 				011	����� �� ���� Ű�Դϴ�. ����API�� ��ϵǾ�����, �Ͻ������� ��� ������ Ű�� ���Ͽ� �˻��ϴ� ��� �߻��մϴ�.
 * 				020	��û ������ �ʰ��Ͽ����ϴ�. �Ϲ������δ� 10,000�� �̻��� ��û�� ���Ͽ� �� ���� �޽����� �߻��ǳ�, ��û ������ �ٸ��� ������ ��쿡�� �̿� ���Ͽ� �߻��˴ϴ�.
 * 				100	�ʵ��� �������� ���Դϴ�. �ʵ� ���� ���� ���� ����� ��쿡 �߻��ϴ� �޽����Դϴ�.
 * 				800	��Ȱ�� ���ü��񽺸� ���Ͽ� ����API ���񽺰� ���� ���Դϴ�.
 * 				900	���ǵ��� ���� ������ �߻��Ͽ����ϴ�.
 * 
 * page_no		������ ��ȣ
 * page_set		�������� �Ǽ�
 * total_count	�� �Ǽ�
 * total_page	�� ������ ��
 * crp_cls		���α��� : Y(����), K(�ڽ���), N(�ڳؽ�), E(��Ÿ)
 * 
 * crp_nm	���ô��ȸ���� �����(�����) �Ǵ� ���θ�(��Ÿ����)
 * crp_cd	���ô��ȸ���� �����ڵ�(6�ڸ�) �Ǵ� ������ȣ(8�ڸ�)
 * rpt_nm	���ñ���+������+��Ÿ����
 * 			[��������] : �� ���������� �̹� ����� ������ ���系���� ����Ǿ� ����� ����
 * 			[÷������] : �� ���������� �̹� ����� ������ ÷�γ����� ����Ǿ� ����� ����
 * 			[÷���߰�] : �� ���������� �̹� ����� ������ ÷�μ����� �߰��Ǿ� ����� ����
 * 			[������] : �� ���������� �̹� ����� ������ ����ȭ��ȹ�� ����Ǿ� ����� ����
 * 			[�������] : �� ���������� �̹� ����� ������ ��Ź����� ����Ǿ� ����� ����
 * 			[��������Ȯ��] : �� ���������� �̹� ����� ������ �������� ���������� Ȯ���Ǿ� ����� ����
 * 			[������ɺΰ�] : �� ������ ���Ͽ� ������������ ��������� �ΰ��� ����
 * 			[��������䱸] : �� ������ ���Ͽ� ������������ ��������䱸�� �ΰ��� ����
 * rcp_no	������ȣ(���ú�� ���ῡ �̿�)
 * 			- PC�� : http://dart.fss.or.kr/dsaf001/main.do?rcpNo=������ȣ
 * 			- ����Ͽ� : http://m.dart.fss.or.kr/html_mdart/MD1007.html?rcpNo=������ȣ
 * flr_nm	���� �����θ�
 * rcp_dt	���� ��������(YYYYMMDD)
 * rmk	���յ� ���ڷ� ������ �Ʒ��� ���� �ǹ̰� ����
 * 		�� : �� ���û����� �ѱ��ŷ��� �������ǽ��庻�� �Ұ���
 * 		�� : �� ���û����� �ѱ��ŷ��� �ڽ��ڽ��庻�� �Ұ���
 * 		ä : �� ������ �ѱ��ŷ��� ä�ǻ������ ���û�����
 * 		�� : �� ������ �ѱ��ŷ��� �ڳؽ����� �Ұ���
 * 		�� : �� ���û����� �����ŷ�����ȸ �Ұ���
 * 		�� : �� ������ ����κ��� ������ ����
 * 		�� : �� ���� ���� �� �����Ű� ������ ���� ������ �����Ͻñ� �ٶ�
 * 		ö : �� ������ öȸ(����)�Ǿ����� ���� öȸ�Ű�(öȸ���־ȳ�)�� �����Ͻñ� �ٶ�
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
