
import wslite.soap.SOAPClient

class LoanSoap {
	static void main(args){
		def x
		println x =  new LoanSoap().getCreditScoring("gian", "ge", "7000")
		//println new LoanSoap().getBankQuote(x.creditScoring , x.loan_amount , 2)
		def y
		
		 y = new LoanSoap().getBankQuote(x.creditScoring, x.loan_amount, "9")
		println y
		
		println new lakwentsalgo().getCommission(x.loan_amount.toDouble(), y.rate.toDouble())//commission
		println ""
		println y.bankName
		println ""
		println y.rate
		println ""
		println x.loan_amount
		println ""
		 
		println new lakwentsalgo().getInterest(y.rate.toDouble(), x.loan_amount.toDouble(), 9)//interest
		println ""
		println new lakwentsalgo().Status(x.loan_amount.toDouble(), 2, y.bankName.toString())
		
		
	//	print y.rate
	}

	def getCreditScoring(customerNameValue , ssnValue , loanAmountValue){
			def client = new SOAPClient('https://dev-esb.toroserver.com/services/CreditAgencyServiceImpl.CreditAgencyServiceImplHttpsSoap11Endpoint/')
			def response = client.send(SOAPAction:'urn:getCreditScoring'){
				body{
					getCreditScoring(xmlns:'http://impl.service.creditagency.toro.com'){
						customerName(customerNameValue)
						ssn(ssnValue)
						loan_amount(loanAmountValue)
					}
				}
			}

			response.getCreditScoringResponse.return
	}

	def getBankQuote(creditScoringValue , loanAmountValue , termValue){
		def client = new SOAPClient('https://dev-esb.toroserver.com/services/LenderAgencyServiceImpl.LenderAgencyServiceImplHttpsSoap11Endpoint/')
		def response = client.send(SOAPAction:'urn:getBankQuote'){
			body{
				getBankQoute(xmlns:'http://impl.service.lenderagency.toro.com'){
					creditScoring(creditScoringValue)
					loanAmount(loanAmountValue)
					term(termValue)
				}
			}
		}

		response.getBankQuoteResponse.return

		
	}
	
	
	

}//end of class1

	

