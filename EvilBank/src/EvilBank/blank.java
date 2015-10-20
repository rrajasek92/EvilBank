package EvilBank;

public class blank {
	public static void main(String[] args) {
		int a=0, b=0,c=0,i=0;
		String d="2015-25-11";
		System.out.println("drop table Account;\n"+

"create table Account (\n"+ 
"ssn varchar(9) not null,\n"+
"first_name varchar(50) not null,\n"+
"last_name varchar(50) not null,\n"+
"account_no varchar(50) not null PRIMARY KEY,\n"+
"balance FLOAT not null\n"+ 

");\n"+

"drop table Transaction;\n"+

"create table Transaction (\n"+

"account_no varchar(50) not null,\n"+
"transation_amount FLOAT not null,\n"+
"trans_type varchar(50) not null,\n"+
"dates date not null,\n"+
"ROW_NO INTEGER not null PRIMARY KEY\n"+ 
");\n");
	}

}
