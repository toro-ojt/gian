import wslite.soap.*

class CustomerServiceSOAP{
	static void main(String...args){
		
	def id = ''
	def firstname = ''
	def lastname = ''
	
	def client = new SOAPClient('http://192.168.22.10:8080/services/CustomerService/')
	def response = client.send(SOAPAction:'http://www.torocommerce.com/customerservice/listCustomer'){
	body{
				ListCustomerRequest('xmlns':"http://www.torocommerce.com/customerservice/"){
				
					  customerIdList(id)
					     customerSearch{
						 firstName(firstname)
						 lastName(lastname)
					}

					
				}
			}
		}
		
		def result =  response.ListCustomerResponse.status.message
		def firstName = response.ListCustomerResponse.customerList.firstName
		def lastName = response.ListCustomerResponse.customerList.lastName
		    println "$result \n$firstName \n$lastName"
		//print "$result"
		
	}
	

}
