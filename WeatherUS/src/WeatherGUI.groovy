import static javax.swing.JFrame.EXIT_ON_CLOSE
import groovy.swing.SwingBuilder

import java.awt.*

import javax.swing.JFrame
import javax.swing.JOptionPane
class WeatherGUI2 {
	def testvariable
	
}

class Foreacher {
	def forecastdate// = tryutil.forecast.date[i]
	def weatherID// = tryutil.forecast.weatherId[i]
	def description// = tryutil.forecast.description[i]
	def tempmorninglow// = tryutil.forecast.tempMorningLow[i]
	def tempdaytimehigh// = tryutil.forecast.tempDaytimeHigh[i]
	def probnightime// = tryutil.forecast.probNightTime[i]
	def probdaytime// = tryutil.forecast.probDayTime[i]
	String toString() {
		"\nDATE: $forecastdate\n" +
				"Weather ID: $weatherID\n" +
				"Description: $description\n" +
				"Temperature\n" +
				"\tMorning Low: $tempmorninglow\n" +
				"\tDaytime High: $tempdaytimehigh\n" +
				"Probability of Precipitation\n" +
				"\tNighttime: $probnightime\n" +
				"\tDaytime: $probdaytime\n"
	}
}

class forlooper {
	
	def forecasterr = tryutil.forecast.each{
		forecasts << new Foreacher(
forecastdate: it.Date,
weatherID: it.WeatherID,
description: it.Description,
tempmorninglow: it.Temperatures.MorningLow,
tempdaytimehigh: it.Temperatures.DaytimeHigh,
probnightime: it.ProbabilityOfPrecipiation.Nighttime,
probdaytime: it.ProbabilityOfPrecipiation.Daytime
)
	
		
	}
	
}


def weather = new WeatherGUI2()

def swingBuilder = new SwingBuilder()
swingBuilder.edt {
	lookAndFeel 'nimbus'
	frame(title: 'Weather', size: [400,500], show:true, locationRelativeTo: null, defaultCloseOperation:EXIT_ON_CLOSE) {
		borderLayout(vgap: 5)
		
		//start of panel1
		panel(constraints: BorderLayout.NORTH) 
		{
			comboBox( id: 'cbx', items:['Get City Forecast By ZIP', 'Get City Weather By ZIP', 'Get Weather Information'], actionPerformed:
								{
//									if(cbx.getSelectedIndex() == 1){
//									JOptionPane.showMessageDialog(null , 'Get City Forecast By ZIP')
//										
//									}
//									
//									else if(cbx.getSelectedIndex() == 2)
//									{
//										JOptionPane.showMessageDialog(null , 'Get City Weather By ZIP')
//									}
//									
//									else if(cbx.getSelectedIndex() == 3)
//									{
//										JOptionPane.showMessageDialog(null , 'Weather Info By ZIP')
//									}
								
								}
								
								)//end cbx1
			
			
		}//end of panel1
		
		
		panel(constraints: BorderLayout.CENTER){
			tableLayout {
				tr{
										
					td{
						textField weather.testvariable, id: 'testvariable2', columns: 10
					}
					
					td{
					
						button text: 'SEARCH', actionPerformed: {
							
							
							if(cbx.getSelectedIndex() == 0){
								def zip = testvariable2.text
								def tryutil = new WeatherUtil().CityForecast(zip)
							
								def success =  tryutil.success
								def response = tryutil.responseText
								def state = tryutil.state
								def city = tryutil.city
								def station= tryutil.weatherStationCity
								
								def tryutil5 = new WeatherUtil().CityForecast(zip).forecast.date
								def tryutil6 = new WeatherUtil().CityForecast(zip).forecast.weatherId
//								def tryutil7 = new WeatherUtil().CityForecast(zip).forecast.description
//								def tryutil8 = new WeatherUtil().CityForecast(zip).forecast.tempMorningLow
//								def tryutil9 = new WeatherUtil().CityForecast(zip).forecast.tempDaytimeHigh
//								def tryutil10 = new WeatherUtil().CityForecast(zip).forecast.probNightTime
//								def tryutil11 = new WeatherUtil().CityForecast(zip).forecast.probDayTime

								
								tryutil5.size().times
								{
									liste.text += "\n${tryutil5[it]}\n${tryutil6[it]}"
								}
							
								

//								def weatherID = tryutil.forecast.weatherId[i]
//								def description = tryutil.forecast.weatherId[i]
//								def tempmorning = tryutil.forecast.tempMorningLow[i]
//								def probnightime = tryutil.forecast.probNightTime[i]
//								def probdaytime = tryutil.forecast.probDayTime[i]
							
								
								
								
							
								
								//liste.text = "Success : $success\nResponse : $response\nState: $state\nCity: $city\nStation: $station "//"Success : $success\nResponse : $response\nState: $state\nCity: $city\nStation: $station"

									
								
								
								}
								
								else if(cbx.getSelectedIndex() == 1)
								{
									def zip = testvariable2.text
								def tryutil2 = new WeatherUtil().CityWeather(zip)
							
								def success =  tryutil2.success
								def response = tryutil2.responseText
								def state = tryutil2.state
								def city = tryutil2.city
								def station = tryutil2.weatherStationCity
								def weatherID = tryutil2.weatherId
								def description = tryutil2.description
								def temperature = tryutil2.temperature
								def relativehumidity = tryutil2.relativeHumidity
								def wind = tryutil2.wind
								def pressure = tryutil2.pressure
								def visibility = tryutil2.visibility
								def windchill = tryutil2.windChill
								def remarks = tryutil2.remarks
								
								liste.text = "Success : $success\nResponse : $response\nState: $state\nCity: $city\nStation: $station\nWeatheriD: $weatherID\nDescription: $description\nTemperature: $temperature\nRelative Humidity: $relativehumidity\nWind: $wind\nPressure: $pressure\nVisibility: $visibility\nWind Chill: $windchill\nRemarks: $remarks"
								
								
								}
								
								else if(cbx.getSelectedIndex() == 2)
								{
									def zip = testvariable2.text
									def tryutil3 = new WeatherUtil().WeatherInformation().description
									def tryutil4 = new WeatherUtil().WeatherInformation().weatherId
									
									tryutil3.size().times
									{
										liste.text += "\n${tryutil4[it]}\n${tryutil3[it]}"  
									}
//									def weatherid = tryutil3.weatherId
//									def descript = tryutil3.description
//									
//									liste.text = "$weatherid\nTrial: $descript"
//																
						
									
									
								}

//						liste.text = testvariable2.text
		
						}
					}
					
				}
				
			}
	
			
		}
		
		
		//start of panel 2
		panel(constraints: BorderLayout.AFTER_LAST_LINE, border: compoundBorder([titledBorder('WeatherInfo:')]))
		{
			tableLayout {
				tr{
					
					td(colspan: 2){
								scrollPane(constraints:gbc(gridx:1, gridy:0, insets:[20, 300, 75, 0])) {
    textArea(id:'liste', columns: 33, rows: 20, editable:false)
								}
							
								}
					
					
				}
			}
			
			
		}//end of panel2
		
		
	}
	
	
	
	
}



