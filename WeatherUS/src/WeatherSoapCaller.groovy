
import wslite.soap.*

class WeatherSoapCaller {
	//call CityForecast from soap
	def getCityForecast(zip){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP'){
			body{
				GetCityForecastByZIP(xmlns:'http://ws.cdyne.com/WeatherWS/'){ZIP(zip)}
			}
		}
		
		response.GetCityForecastByZIPResponse.GetCityForecastByZIPResult
	}
	
	//call CityWeather form soap
	def getCityWeather(zip){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send('http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP'){
			body{
				GetCityWeatherByZIP(xmlns:'http://ws.cdyne.com/WeatherWS/'){ZIP(zip)}
			}
		}
		
		response.GetCityWeatherByZIPResponse.GetCityWeatherByZIPResult
	}
	
	//call WeatherInformation form soap
	def getWeatherInformation(zip){
		def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
		def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetWeatherInformation'){
			body{
				GetWeatherInformation(xmlns:'http://ws.cdyne.com/WeatherWS/'){ZIP(zip)}
			}
		}
		
		response.GetWeatherInformationResponse.GetWeatherInformationResult
	
	}
	
	
}
//	print getWeatherInformation(10005).WeatherDescription.Description[2]
