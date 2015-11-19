
class WeatherMain {
	static void main(String...args){
	def tryutil = new WeatherUtil()
	
	BufferedReader tagabasa = new BufferedReader (new InputStreamReader (System.in));
	def input = tagabasa.readLine();
	
	println tryutil.CityForecast(input).success
	println tryutil.CityForecast(input).responseText
	println tryutil.CityForecast(input).state
	println tryutil.CityForecast(input).city
	println tryutil.CityForecast(input).weatherStationCity
	println tryutil.CityForecast(input).forecast.date[0]
	println tryutil.CityForecast(input).forecast.weatherId[0]
	println tryutil.CityForecast(input).forecast.description[0]
	println tryutil.CityForecast(input).forecast.tempMorningLow[0]
	println tryutil.CityForecast(input).forecast.probNightTime[0]
	println tryutil.CityForecast(input).forecast.probDayTime[0]
	
	
	
//	
//	println tryutil.CityForecast(10005).forecast.date[0]
//	println tryutil.CityForecast(10005).forecast.weatherId[0]
//	println tryutil.CityForecast(10005).forecast.description[0]
//	println tryutil.CityForecast(10005).forecast.tempMorningLow[0]
//	println tryutil.CityForecast(10005).forecast.probNightTime[0]
//	println tryutil.CityForecast(10005).forecast.probDayTime[0]
//	
	
	
	}
}
