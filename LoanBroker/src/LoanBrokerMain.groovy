import static javax.swing.JFrame.EXIT_ON_CLOSE
import groovy.swing.SwingBuilder

import java.awt.*
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

import javax.swing.JFrame
import javax.swing.JOptionPane


//class Loaner {
	def name
	def loanamount
	def LoanAmount
	def creditscoring
	def dateee
	def returner
	def socialsn
	
//}

//def loanbumbs = new Loaner()

def swingBuilder = new SwingBuilder()
swingBuilder.edt {
	lookAndFeel 'nimbus'
	frame(title: 'Loan Banker', size: [400,550], show:true, locationRelativeTo: null, defaultCloseOperation:EXIT_ON_CLOSE) {
		borderLayout(vgap: 5)
		
		
		
		panel(constraints: BorderLayout.CENTER){
			tableLayout {
				tr{
										
					td{
						label 'Name of Borrower:' 
					}
					
					td{
					
						textField id: 'Name', columns: 20 
						
						
					}
					
				}
				
				tr{
					
					td{
						label 'Amount of Money:'
					}

					td{
						
						textField id: 'Amount', columns: 20
						Amount.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent e) {
							  char c = e.getKeyChar();
							  if (!(Character.isDigit(c) ||
								 (c == KeyEvent.VK_BACK_SPACE) ||
								 (c == KeyEvent.VK_DELETE))) {
								   e.consume();
								 }
							}
						  })
//						loanamount = Amount.text
					}

				}	
				
				tr{
					
					td{
						label 'Social Security Number:'
					}

					td{
						
						textField id: 'ssn', columns: 20
						ssn.addKeyListener(new KeyAdapter() {
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
				
				tr{
					
					td{
						label 'Months to Pay:'
					}

					td{
						
						textField id: 'term', columns: 20
						term.addKeyListener(new KeyAdapter() {
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
				tr{
					td{
						button text: 'Print Borrow Slip', actionPerformed: {
							if (term.text == "" || Name.text == '' || Amount.text == '' || ssn.text == ''){
								JOptionPane.showMessageDialog(null , "Please Complete all Details")
							}
							
							else {
								
								name = Name.text
								loanamount = Amount.text
								socialsn = ssn.text
								months = term.text
								
								//print term.text
								
								def x
								x =  new LoanSoap().getCreditScoring("$name", "$socialsn", "$loanamount")
								
								creditscoring = x.creditScoring
								LoanAmount = x.loan_amount
								
								def y
								y = new LoanSoap().getBankQuote(x.creditScoring, x.loan_amount, "$months")
								
								def montths = months.toDouble()
								
								def commission = new lakwentsalgo().getCommission(x.loan_amount.toDouble(), y.rate.toDouble())
								def interestrate = new lakwentsalgo().getInterest(y.rate.toDouble(), x.loan_amount.toDouble(), montths)
								def loanstatus = new lakwentsalgo().Status(x.loan_amount.toDouble(), montths, y.bankName.toString())
								
							//	println montths
								
								
								liste.text = "Credit Scoring: ${x.creditScoring}\nLender Name: ${x.lender_name}\nLoan Amount: ${x.loan_amount}\nBank Name: ${y.bankName}\nRate: ${y.rate}\nBank Commission: $commission\nInterest Rate: $interestrate\nLoan Status: $loanstatus"
								
								
							}
							
							
						}
					}
					
				}
			}
	
			
		}
		
		
		//start of panel 2
		panel(constraints: BorderLayout.AFTER_LAST_LINE, border: compoundBorder([titledBorder('LoanBank:')]))
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
