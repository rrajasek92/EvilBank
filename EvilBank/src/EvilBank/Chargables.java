package EvilBank;
public class Chargables {
	private String id="";//could be a check or debit card iD
	private String acctNo="",type="";
	private double chargeAmt=0.0;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getChargeAmt() {
		return chargeAmt;
	}
	public void setChargeAmt(double chargeAmt) {
		this.chargeAmt = chargeAmt;
	}


}
