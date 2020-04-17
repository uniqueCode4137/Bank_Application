package Entities;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Bank_Entities {
	
	public String acct_type;
	public String fullName ;
	public BigInteger acctNo;
	public float amt;
	public String currency;
	
	public Bank_Entities( String acct_type, String fullName, BigInteger acctNo, float amt, String currency ) {
		
		this.acct_type = acct_type;
		this.fullName = fullName;
		this.acctNo = acctNo;
		this.amt = amt;
		this.currency = currency;		
		
	}

//	@Override
//	public String toString() {
//		return "Bank_Entities [acct_type=" + acct_type + ", fullName=" + fullName + ", acctNo=" + acctNo + ", amt="
//				+ amt + ", currency=" + currency + "]";
//	}
//	
	
	
	
}
