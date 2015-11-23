package geoIP
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

class geoIPSoapCaller {

	def getGeoIp(def userInput) {
		def client = new SOAPClient('http://www.webservicex.net/geoipservice.asmx')
		def response = client.send(SOAPAction:'http://www.webservicex.net/GetGeoIP'){
			body{
				getGeoIP
			}
		}
		
	}
	
	
}
