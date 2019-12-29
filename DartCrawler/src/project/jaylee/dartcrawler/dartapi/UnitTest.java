package project.jaylee.dartcrawler.dartapi;

public class UnitTest {

	public static void main(String[] args) {
		RequestDart reqDart = new RequestDart();
					reqDart.setAuth("ba03b3604fc296bc4b7bc7d9d4eff52dc40e9af6");
					reqDart.setCrp_cd("035420");
					reqDart.setStart_dt("20090101");
					reqDart.setFin_rpt("Y");
					//reqDart.setDsp_tp("A");
					reqDart.setBsn_tp("A001");
		
		DartParser dartParser = new DartParser();
		
		ResponseDart respDart = dartParser.parse(reqDart);
					 respDart.print();
		
					 
					 System.out.println(respDart.checkErrCode());
	}

}
