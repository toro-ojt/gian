@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

class CustomerServiceSOAPcaller {
	static void main(String...args){
		def id
		def firstname
		def lastname
		
		def client = new SOAPClient('http://192.168.22.10:8080/services/CustomerService/')
		def response = client.send(SOAPAction:"http://www.torocommerce.com/customerservice/listCustomer"){
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
		
		def result = response.ListCustomerResponse.status.message
		def fname = response.ListCustomerResponse.customerList.firstName
		def lname = response.ListCustomerResponse.customerList.lastName
		
		println "Status: $result\nFirst Name: $fname\nLast Name: $lname"
		
		
		
		
	}

}
