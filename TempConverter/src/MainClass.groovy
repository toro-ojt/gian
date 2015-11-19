import wslite.soap.*

class Main
{
	//main 
	static void main(String...args){
			//def c = new ConverterGUI()
			//c.doGui()
		
			BufferedReader tagabasa = new BufferedReader (new InputStreamReader (System.in));
	
			println 'Accepted Commands: '
			println 'f to c (fahrenheit to celsius)'
			println 'c to f (celsius to fahrenheit)'
			
			here:
	def input = tagabasa.readLine();
	
	switch(input)
	{
		case 'f to c':
			println 'Fahrenheit to Celsius'
			def temp2 = tagabasa.readLine();
			print new converter().convertFahrenheitToCelsius(temp2)

		
			break;
		
		case 'help':
			new othercodes().help()
			break;
		case 'c to f':
			println 'Celsius to Fahrenheit'
			def temp = tagabasa.readLine()
			print new converter().convertCelsiusToFahrenheit(temp)

		break;
		
	}
	
	continue here
	//print  new converter().convertCelsiusToFahrenheit(input)
	

	}
	
	

}

class othercodes{
	def help()
	{
		println 'Accepted Commands: '
		println 'f to c (fahrenheit to celsius)'
		println 'c to f (celsius to fahrenheit'
	
	}
}


class converter
{	

	//celsius to fahrenheit method
	def convertCelsiusToFahrenheit(def userInput){
		def client = new SOAPClient('http://www.w3schools.com/webservices/tempconvert.asmx')
		def response = client.send(SOAPAction:'http://www.w3schools.com/webservices/CelsiusToFahrenheit'){
			body{
				CelsiusToFahrenheit(xmlns:'http://www.w3schools.com/webservices/'){Celsius(userInput)}
			}
		}
		
		response.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult
	}
	
	//fahrenheit to celsius method
	def convertFahrenheitToCelsius(def userInput2){
		def client = new SOAPClient('http://www.w3schools.com/webservices/tempconvert.asmx')
		//call for method
		def response = client.send(SOAPAction:'http://www.w3schools.com/webservices/FahrenheitToCelsius'){
			body{
				FahrenheitToCelsius(xmlns:'http://www.w3schools.com/webservices/'){Fahrenheit(userInput2)}
			}
		}
		//call for result
		response.FahrenheitToCelsiusResponse.FahrenheitToCelsiusResult
	}
	

	
	//print  "$userInput"
} 

