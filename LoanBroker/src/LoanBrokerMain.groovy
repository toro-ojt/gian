
class LoanBrokerMain {
	
	static void main(args){

		def x
		println x =  new LoanSoap().getCreditScoring("gian", "ge", "9000")
		print new LoanSoap().getBankQuote(x.creditScoring , x.loan_amount , 2)//.bankName//.rate
		
	}

	
	
}
