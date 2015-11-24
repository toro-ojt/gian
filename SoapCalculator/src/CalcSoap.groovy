
import wslite.soap.*


class CalcSoap {
//	
//	def static input1
//	def static input2
	//def answer
	
	def addTwoNumber(def num1 , def num2){
			def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
			def response = client.send(SOAPAction:'http://tempuri.org/Add'){
				
				body
				{
					Add(xmlns:'http://tempuri.org/'){
						intA(num1)
						intB(num2)
						
					}
					
				}
				
			}
			
		 return response.AddResponse.AddResult
		
	}
	
	def subtractTwoNumber(def num1 , def num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Subtract'){
			
			body
			{
				Subtract(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
					
				}
				
			}
			
		}
		
	 return response.SubtractResponse.SubtractResult
	
}
	
	def mulitplytTwoNumber(def num1 , def num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Multiply'){
			
			body
			{
				Multiply(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
					
				}
				
			}
			
		}
		
	 return response.MultiplyResponse.MultiplyResult
	
}
	
	def dividetTwoNumber(def num1 , def num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Divide'){
			
			body
			{
				Divide(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
					
				}
				
			}
			
		}
		
	 return response.DivideResponse.DivideResult
	
}


}
