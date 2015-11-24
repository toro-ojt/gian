package geoIP
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*


class geoIPsoap {
	
	def input1
	def input2
	def answer
	
	def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
	def response = client.send('')

}
