
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
			success:cityweather.Success,
			responseText:cityweather.ResponseText,
			state:cityweather.State,
			city:cityweather.City,
			weatherStationCity:cityweather.WeatherStationCity,
			weatherId:cityweather.WeatherID,
			description:cityweather.Description,
			temperature:cityweather.Temperature,
			relativeHumidity:cityweather.RelativeHumidity,
			wind:cityweather.Wind,
			pressure:cityweather.Pressure,
			visibility:cityweather.Visibility,
			windChill:cityweather.WindChill,
			remarks:cityweather.Remarks
			 
			 
			 
		)
	}
	//end of CityWeatherValues
	
	def WeatherInformation()
	{
		def weatherinformation = this.getWeatherInformation().WeatherDescription
		new WeatherInformationValues
		(
			weatherId:weatherinformation.WeatherID,
			description:weatherinformation.Description
			
			
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