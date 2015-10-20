package EvilBank;

import java.util.Scanner;
import java.util.ArrayList;

public class EvilBankApp {
	public static int index=1;
	protected static ArrayList<Transaction> transHistory=new ArrayList<Transaction>();
	protected static ArrayList<Account> acctList=new ArrayList<Account>();
	
	public static void displayTrans(){
		System.out.println("Transaction History");
		for(Transaction trans:transHistory){
			System.out.println(trans.toString());
		}
	}
	public static void main(String[] args){
		

		boolean loop1=true,loop2=true;
		String acctNum="",fName="",lName="",ssn="",in="";
		float balPass=0;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Welcome to Evil Bank!\nPlease create the user account(s)");
		Account accct = new Account();
		while(loop1){
			loop2=true;
			Account acct= new Account();
			System.out.println("Enter account # or -1 to stop entering accounts: ");
			in=keyboard.next();
			
		if (in.equals("-1")){
			loop1 = false;
		} else {
			acctNum=in;
			int c=0;
			for (Account Acct : EvilBankApp.acctList){
				if (acctNum.equals(Acct.getAcctNo())) {
					accct = Acct;
					c++;
					break;
				}
			}
				if(c!=0) {
					System.out.println("The account already exists."); 
					loop2=false;
					
				}
			
			if (!loop2) continue;
			
			acct.setAcctNo(acctNum);
			System.out.println("Enter the first name for acct # "+acctNum+": ");
			fName=keyboard.next();
			System.out.println("Enter the last name for acct # "+acctNum+": ");
			lName=keyboard.next();
			System.out.println("Enter the SSN for acct # "+acctNum+": ");
			ssn=keyboard.next();
			acct.setAcctName(fName+lName);
			System.out.println("Enter the balance for acct # "+acctNum+": ");
			balPass=keyboard.nextFloat();
			acct.setAcctBalance(balPass);
			accountDB.sendToDatabase(ssn, fName, lName, acctNum, balPass);
			acctList.add(acct);
			}
		}
		
		for (Account oneAcct : EvilBankApp.acctList){
			System.out.println(oneAcct.toString());
}
		
		//looping for transactions
			double transCheck=0.0;
			String ltype="",laccount="",ldate="";
			float lamount=0;
			Account theAcct = new Account();
			while(loop2){
				loop2=true;
				System.out.println("Enter a transaction type(Check, Debit Card, Deposit, or Withdrawal) or -1 to finish: ");
				ltype=keyboard.next();
				if (ltype.equals("-1")) break;
				System.out.println("Enter the account #: ");
				laccount=keyboard.next();
				int c=0;
				for (Account oneAcct : EvilBankApp.acctList){
					if (laccount.equals(oneAcct.getAcctNo())) {
						theAcct = oneAcct;
						c++;
						break;
					}
				}
					if(c==0) {
						System.out.println("The account does not exist."); 
						loop2=false;
						
					}
				
				if (!loop2) continue;
				System.out.println("Enter the amount the check: ");
				lamount=keyboard.nextFloat();
				if (ltype.equals("Withdrawal")&&lamount>theAcct.getAcctBalance()){
					System.out.println("Insufficient funds! Withdrawal declined!");}
				else{
				System.out.println("Enter the date of the check (YYYY-MM-DD): ");
				ldate=keyboard.next();
				Transaction trans=new Transaction(laccount,lamount,ltype,ldate);
				transHistory.add(trans); // grand transaction history, not even in date order
				trans.writeToFile(laccount); // transaction for individual account, not in date order 
				theAcct.processTrans(trans);
				transactionDB.sendToDatabase(acctNum, lamount, ltype, ldate, index);
				index++;
				}
				}
			// sort transHistory by time  -- grand transaction history
			// group time ordered transaction by account number 
			//displayTrans();
			for (Account anAcct : EvilBankApp.acctList) {
				System.out.println("The balance for account "+anAcct.getAcctNo()+" is "+anAcct.getAcctBalance());
			}
			System.out.println("\nTransaction History: \n-----------------------\n");
			Retrieve.retrieveDB();
			System.out.println("\nClosing Program.....");
	}
}
