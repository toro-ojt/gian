package databasee

import groovy.sql.Sql
import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

import javax.swing.JFrame

class databaseclasss {

	public static main(args){
		def dbUrl      = "jdbc:postgresql://localhost/sampledb"
		def dbUser     = "gian.oronce"
		def dbPassword = ""
		def dbDriver   = "org.postgresql.Driver"

		def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
		
		def swingBuilder = new SwingBuilder()
		swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
			lookAndFeel 'nimbus'  // Simple change in look and feel.
			frame(title: 'Geo IP', size: [700, 500],
			show: true, locationRelativeTo: null, id: 'MainFrame', defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
				borderLayout(vgap: 5)
				
				panel(constraints: BorderLayout.CENTER,
					border: compoundBorder([emptyBorder(10)])) {
					tableLayout {
						tr
						{
							td
							{
								label 'Data Name: '
																								
							}
							
							
							td
							{
								textField id: 'dataname', columns: 10
								
																
							}
							
							td
							{
								label 'Data 1: '
																								
							}
							
							
							td
							{
								textField id: 'data1', columns: 10
								
																
							}
							
							td
							{
								label 'Data 2: '
																								
							}
							
							
							td
							{
								textField id: 'data2', columns: 10
								
																
							}
							
							td
							{
								label 'Status: '
																								
							}
							
							
							td
							{
								textField id: 'status', columns: 10
								
																
							}

						}
						
						tr
						{
							td
							{
								button id: 'add', text: '+', actionPerformed: {
								
								}
							}
							
							
							
							
							
							td
							{
								button id: 'divide', text: '÷', actionPerformed: {
									
								}
							}
							
						}
						
											
												
					}//end tbllayout
				}//end of panel1
					
				
				
					
			}//end frame
		}//end swing builder
		

		
		
		
//		//select
//		sql.eachRow("select * from tbldata"){ row ->
//			println "UserID: " + row.id + " Data_name: " + row.data_name + " Data1: " + row.data1
//		 }
		
//		//insert new row
//		def name = "test2"
//		def data1 = 1
//		def data2 = 6
//		def status = "in progress"
//		sql.execute("insert into tbldata (data_name, data1, data2, status) values ($name, $data1, $data2, $status)")
//		
		
		

	
		
		
	}

}
