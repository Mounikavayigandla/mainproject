package Count.Bean;

public class Count {

	private String UserId;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	private int RBC;
	private int WBC;
	private int Platelet;
	public int getRBC() {
		return RBC;
	}
	public void setRBC(int rBC) {
		RBC = rBC;
	}
	public int getWBC() {
		return WBC;
	}
	public void setWBC(int wBC) {
		WBC = wBC;
	}
	public int getPlatelet() {
		return Platelet;
	}
	public void setPlatelet(int platelet) {
		Platelet = platelet;
	}
	
}
