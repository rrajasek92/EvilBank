package EvilBank;
import java.util.ArrayList;
public class Account {
private String acctNo;
private String acctName;
private double acctBalance, chargeBalance;
private double fee=35.0;

	public Account(String acctNo,String acctName,Double acctBalance){
		this.setAcctNo(acctNo);
		this.setAcctName(acctName);
		this.setAcctBalance(acctBalance);
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String acctNo){
		this.acctNo=acctNo;
	}
	public void Balance(){
		
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public double getAcctBalance() {
		return acctBalance;
	}
	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}
	public double getChargeBalance() {
		return chargeBalance;
	}
	public void setChargeBalance(double chargeBalance) {
		this.chargeBalance = chargeBalance;
	}
	public double accumulateCharge(Double x){
		
		
		return 0;
	}
	@Override
	public String toString(){
		return "  Account:"+acctNo+" Account Name: "+acctName;
	}
	public void processTrans(Transaction trans){
		switch(trans.getType()){
		case "Check": {
			acctBalance-=trans.getChargeAmt();
			if (acctBalance<0.0){
				chargeBalance+=fee;
				acctBalance-=fee;
			}
			
		}break;
		case "Debit":{
			acctBalance-=trans.getChargeAmt();
			if (acctBalance<0.0){
				chargeBalance+=fee;
				acctBalance-=fee;
			}
			
		}break;
		case "Deposit":{
			acctBalance+=trans.getChargeAmt();
		}break;
		case "Withdrawal":{
			if (trans.getChargeAmt()>acctBalance) System.out.println("Insufficient funds!");
			else acctBalance-=trans.getChargeAmt();
		}break;
		
		}
	}
	
}
