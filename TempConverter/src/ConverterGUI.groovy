import groovy.swing.SwingBuilder

import java.awt.event.ActionListener

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane



class ConverterGUI{
	
	def doGui(){
		SwingBuilder sb = new SwingBuilder()
		sb.edt{
			frame = new JFrame(title:'hello',defaultCloseOperation:JFrame.EXIT_ON_CLOSE , size:[300,300] , locationRelativeTo:null, layout:flowLayout())
			
			btn = new JButton('click me')
			btn.addActionListener({
				JOptionPane.showMessageDialog(null , "Error")
			} as ActionListener)
			frame.add(btn)
			frame.show()
			
			
			
			
		}
	}
}
