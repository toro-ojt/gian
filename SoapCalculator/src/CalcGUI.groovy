import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

import javax.swing.JFrame

import wslite.soap.*


class CalcGUI {

	static void main(args)
	{
		def calcAPI = new CalcSoap()
			
		def holder1
		def holder2
		def operation
		
		def swingBuilder = new SwingBuilder()
		swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
			lookAndFeel 'nimbus'  // Simple change in look and feel.
			frame(title: 'Geo IP', size: [300, 200],
			show: true, locationRelativeTo: null, id: 'MainFrame', defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
				borderLayout(vgap: 5)
				
				panel(constraints: BorderLayout.CENTER,
					border: compoundBorder([emptyBorder(10)])) {
					tableLayout {
						tr
						{
							td
							{
								textField id: 'inputfield', columns: 20
								
								inputfield.addKeyListener(new KeyAdapter() {
									public void keyTyped(KeyEvent e) {
									  char c = e.getKeyChar();
									  if (!(Character.isDigit(c) ||
										 (c == KeyEvent.VK_BACK_SPACE) ||
										 (c == KeyEvent.VK_DELETE))) {
										   e.consume();
										 }
									}
								  })
								
							}
						}
						
						tr
						{
							td
							{
								button id: 'add', text: '+', actionPerformed: {
									holder1  = inputfield.text 
									inputfield.text = ""
									operation = 'add' 
								}
							}
							
							
							
							
							
							td
							{
								button id: 'divide', text: '÷', actionPerformed: {
									holder1  = inputfield.text
									inputfield.text = ""
									operation = 'divide'
								}
							}
							
						}
						
						tr{
							td
							{
								button id: 'subtract', text: '-', actionPerformed: {
									holder1  = inputfield.text
									inputfield.text = ""
									operation = 'subtract'
								}
							}
							
							td
							{
								button id: 'multiply', text: 'x', actionPerformed: {
									holder1  = inputfield.text
									inputfield.text = ""
									operation = 'multiply'
								}
							}
						}
						
						
						
					}//end tbllayout
				}//end of panel1
					
				panel(constraints:BorderLayout.AFTER_LAST_LINE)	{
					tableLayout{
						tr
						{
							td
							{
								button id: 'equalss', text: '=', actionPerformed: 
								{
									holder2 = inputfield.text
									
									if (operation == 'add'){
										def answerer = calcAPI.addTwoNumber(holder1 , holder2)
										
									//	holder1 = answerer
										
										answerfield.text = "$answerer"
									}	
									
									else if (operation == 'subtract'){
										def answerer = calcAPI.subtractTwoNumber(holder1 , holder2)
										
									//	holder1 = answerer
										
										answerfield.text = "$answerer"
									}	
									
									else if (operation == 'multiply'){
										def answerer = calcAPI.mulitplytTwoNumber(holder1 , holder2)
										
									//	holder1 = answerer
										
										answerfield.text = "$answerer"
									}
									
									else if (operation == 'divide'){
										def answerer = calcAPI.mulitplytTwoNumber(holder1 , holder2)
										
									//	holder1 = answerer
										
										answerfield.text = "$answerer"
									}
									
									
								}
							}
						}
						
						tr
						{
							td
							{
								textField id: 'answerfield', columns: 20, editable: false
							}
						}
					}
				}
				
					
			}//end frame
		}//end swing builder
	}//end main
	
}
