import static javax.swing.JFrame.EXIT_ON_CLOSE
import groovy.beans.Bindable
import groovy.swing.SwingBuilder

import java.awt.*

import javax.swing.JFrame
import javax.swing.JOptionPane
 
//@Bindable
class TemperatureGUI{
	
	def tempdegree
	

}

def temperature = new TemperatureGUI()//celsius: 'Input temperature here')


def swingBuilder = new SwingBuilder()
swingBuilder.edt{  // edt method makes sure UI is build on Event Dispatch Thread
	lookAndFeel 'nimbus'
	frame(title: 'Converter', size: [350, 350], show: true, locationRelativeTo: null, defaultCloseOperation: EXIT_ON_CLOSE) {
		borderLayout(vgap: 5)
		
		panel(constraints: BorderLayout.NORTH) {
			
					// This will work:
			
					myGroup = buttonGroup();
			
				def ctof = radioButton(text:"Celsius to Fahrenheit", id: 'ctof', buttonGroup:myGroup, selected:true);
			
				def ftoc = radioButton(text:"Fahrenheit to Celsius", id: 'ftoc', buttonGroup:myGroup);
			
			
				}
			
		
		panel(constraints: BorderLayout.CENTER,
			border: compoundBorder([emptyBorder(10), titledBorder('Temperature Converter:')]))
		{
			tableLayout {
				tr{
					td {
						label 'Temperature: '
					}
					td {
						textField temperature.tempdegree, id: 'tempdegree2', columns: 20
					}
				}
			}
			
			
			
		}
		
		panel(constraints: BorderLayout.SOUTH) {
			button text: 'CONVERT', actionPerformed: {
			//	  AnswerField.text = input.GetValue(menuInput, DegreeField.text)
//				def trial  = new converter().convertCelsiusToFahrenheit(temperature as int)
			//def trytry = input.GetValue(celsius.text)
				
		//		JOptionPane.showMessageDialog(null , "$temperature")
				 if(ctof.selected == true){
				hihi = new converter().convertCelsiusToFahrenheit(tempdegree2/*id ng textfield toh*/.text)
				 }
				 else
				 {
					 hihi = new converter().convertFahrenheitToCelsius(tempdegree2.text)
				 }
				 
				 hihi.toString()
				JOptionPane.showMessageDialog(null , "Temperature is $hihi")
				//println temperature
			}
		}
		
//		bean temperature,
//		celsius: bind { celsius.text }
	
		
		
	}
}