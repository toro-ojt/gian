
class WeatherUtil extends WeatherSoapCaller {
	//start of City forecast
	def CityForecast(zip)
	{
		def cityforecast = this.getCityForecast(zip)
		def forecast = new ForecastValues
		(
			// you get ForecastResult.Forecast.(something) because it is inside of the values ForecastResult then Forecast
			date:cityforecast.ForecastResult.Forecast.Date,
			weatherId:cityforecast.ForecastResult.Forecast.WeatherID,
			description:cityforecast.ForecastResult.Forecast.Desciption,
			tempMorningLow:cityforecast.ForecastResult.Forecast.Temperatures.MorningLow,
			tempDayTime:cityforecast.ForecastResult.Forecast.Temperatures.DaytimeHigh,
			probNightTime:cityforecast.ForecastResult.Forecast.ProbabilityOfPrecipiation.Nighttime,
			probDayTime:cityforecast.ForecastResult.Forecast.ProbabilityOfPrecipiation.Daytime
		)
		
		new CityForecastValues
		(
			success:cityforecast.Success,
			responseText:cityforecast.ResponseText,
			state:cityforecast.State,
			city:cityforecast.City,
			weatherStationCity:cityforecast.WeatherStationCity,
			forecast:forecast
			
			
		)
	}
	//end of CityForecast
	
	//start of CityWeatherValues
	def CityWeather(zip)
	{
		 def cityweather = this.getCityWeather(zip)
		 new CityWeatherValues
		 (
			success:cityWeather.Success,
			responseText:cityWeather.ResponseText,
			state:cityWeather.State,
			city:cityWeather.City,
			weatherStationCity:cityWeather.WeatherStationCity,
			weatherId:cityWeather.WeatherID,
			description:cityWeather.Description,
			temperature:cityWeather.Temperature,
			relativeHumidity:cityWeather.RelativeHumidity,
			wind:cityWeather.Wind,
			pressure:cityWeather.Pressure,
			visibility:cityWeather.Visibility,
			windChill:cityWeather.WindChill,
			remarks:cityWeather.Remarks
			 
			 
			 
		)
	}
	//end of CityWeatherValues
	
	def WeatherInformation()
	{
		def weatherinformation = this.getWeatherInformation()
		new WeatherInformationValues
		(
			weatherId:WeatherDescription.WeatherID,
			description:WeatherDescription.Description
			
			
		)
		
	}
	
	

}



class ForecastValues {
	def date
	def weatherId
	def description
	def tempMorningLow
	def tempDayTime
	def probNightTime
	def probDayTime
}

class CityForecastValues {
	
	def success
	def responseText
	def state
	def city
	def weatherStationCity
	def forecast
	
}

class CityWeatherValues {
	
	def success
	def responseText
	def state
	def city
	def weatherStationCity
	def weatherId
	def description
	def temperature
	def relativeHumidity
	def wind
	def pressure
	def visibility
	def windChill
	def remarks
}

class WeatherInformationValues {
	
		def weatherId
		def description
		
	}