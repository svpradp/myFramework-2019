package database;

public class RetrieveData {
	
	public void getData() throws Exception
	{
		
		ConnectPostGreSQL conn = new ConnectPostGreSQL();
		
		conn.connectDB("zlt15292.vci.att.com", "OWB", "5432", "vs0322", "welcome123");
		
		String pedsql= "select comn_id,wvlngth_req_type,svc_a_clli,svc_z_clli from owb.owb_fsblty_chk where comn_id='WB0000037474'";
		
		
		
	}

}
