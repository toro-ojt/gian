import static javax.swing.JFrame.EXIT_ON_CLOSE
import groovy.beans.Bindable
import groovy.swing.SwingBuilder

import java.awt.*
 
@Bindable
class Address {
	String street, number, city
	String toString() { "address[street=$street,number=$number,city=$city]" }
}
  
def address = new Address(street: 'Evergreen Teace', number: '742', city: 'Springfield')
  
def swingBuilder = new SwingBuilder()
swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
	lookAndFeel 'nimbus'  // Simple change in look and feel.
	frame(title: 'Address', size: [500, 550],
			show: true, locationRelativeTo: null,
			defaultCloseOperation: EXIT_ON_CLOSE) {
		borderLayout(vgap: 3)
		
		panel(constraints: BorderLayout.NORTH,
				border: compoundBorder([emptyBorder(10), titledBorder('Enter your address:')])) {
			tableLayout {
				tr {
					td {
						label 'Street:'  // text property is default, so it is implicit.
					}
					td {
						textField address.street, id: 'streetField', columns: 20
					}
				}
				tr {
					td {
						label 'Number:'
					}
					td {
						textField id: 'numberField', columns: 5, text: address.number
					}
				}
				tr {
					td {
						label 'City:'
					}
					td {
						textField id: 'cityField', columns: 20, address.city
					}
				}
			}
			
		}
		
		panel(constraints: BorderLayout.CENTER) {
			button text: 'Save', actionPerformed: {
				liste.text = address
			}
		}
		
		panel(constraints: BorderLayout.SOUTH) {
			 textArea(id:'liste', columns: 33, rows: 20, editable:false)
		}
		
		// Binding of textfield's to address object.
		bean address,
			street: bind { streetField.text },
			number: bind { numberField.text },
			city: bind { cityField.text }
	}
}