package EvilBank;

import java.util.ArrayList;
import java.io.*;


public class Transaction {
	private String date;//	in format: MM/DD/YYYY
	private String acctNo="",type="";
	private float chargeAmt=0;
	public Transaction(){

	
	}
	public Transaction(String acctNo, Float chargeAmt, String type,String date){
		this.acctNo=acctNo;
		this.chargeAmt=chargeAmt;
		this.type=type;
		this.date=date;
	}
	public Transaction(String acctNo){
		this.acctNo=acctNo;
	}
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void Checking(String acct){
		
	}
	
	public float getChargeAmt() {
		return chargeAmt;
	}
	public void setChargeAmt(float chargeAmt) {
		this.chargeAmt = chargeAmt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
@Override
public String toString(){
	return "Transaction type: "+type+"  Account:"+acctNo+"  Charge Amount: "+chargeAmt+"  Date: "+date;
}
	
public void writeToFile(String acctFileName){
	 String filename = (System.getProperty("user.dir") + File.separatorChar +acctFileName+".txt");
	 PrintWriter writer = null;
	 try{
	 writer = new PrintWriter(new FileOutputStream(new File(filename),true));
	 }
	 catch(FileNotFoundException e){
		 System.out.println(e.getMessage());
	 }
	 writer.println(type+"|"+acctNo+"|"+chargeAmt+"|"+date);
	 writer.close();
}
	
}
