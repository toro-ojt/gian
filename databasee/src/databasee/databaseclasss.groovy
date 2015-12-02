package databasee

import groovy.sql.Sql
import groovy.swing.SwingBuilder

import java.awt.BorderLayout

import javax.swing.JFrame

class databaseclasss {

	public static main(args){
		def dbUrl      = "jdbc:postgresql://localhost/sampledb"
		def dbUser     = "gian.oronce"
		def dbPassword = ""
		def dbDriver   = "org.postgresql.Driver"
		def table = "tbldata"

		def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
		
		def swingBuilder = new SwingBuilder()
		swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
			lookAndFeel 'nimbus'  // Simple change in look and feel.
			frame(title: 'Geo IP', size: [900, 500],
			show: true, locationRelativeTo: null, id: 'MainFrame', defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
				borderLayout(vgap: 5)
				
				panel(constraints: BorderLayout.NORTH,
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
						
						
						
											
												
					}//end tbllayout
				}//end of panel1
					
				
					
					panel(constraints: BorderLayout.CENTER,
						border: compoundBorder([emptyBorder(10)])) {
						tableLayout {
							tr{

								td
								{
									button id: 'add', text: 'Add Table', actionPerformed: {
											//insert new row
												def name = dataname.text
												def data1 = data1.text.toInteger()
												def data2 = data2.text.toInteger()
												def status = status.text
												sql.execute("insert into tbldata (data_name, data1, data2, status) values ($name, $data1, $data2, $status)")
										
										
									}
								}
								
								
								td
								{
									button id: 'Show', text: 'Show Table', actionPerformed: {
										
										//select
										sql.eachRow("select * from tbldata")//ouput data from database
										{
											row ->
											def a = "UserID: " + row.id + " Data_name: " + row.data_name + " Data1: " + row.data1 + " Data2: " + row.data2 + " Status: " + row.status               
											
											liste.append("$a\n") 
										}
										
										
										
									}
								}
								
								
								td
								{
									button id: 'count', text: 'Count Table', actionPerformed: {
										txttn = "\nCurrent table: ${table}"
							
										//count the tbldata
										def query = 'select * from ' + "${table}"
										def count = 0
										sql.eachRow query, {
											count ++
										}
										//print how many there are in the table
										liste.text = "\nCurrent table size: ${count}"
									}
								}
								
								
							}
						}
						
						
						
						}//end of panel 2
					
					
				panel(constraints: BorderLayout.AFTER_LAST_LINE,
						border: compoundBorder([emptyBorder(10)])) {
						tableLayout {
							tr{
								
								td(colspan: 2){
											scrollPane(constraints:gbc(gridx:1, gridy:0, insets:[20, 300, 75, 0])) {
				textArea(id:'liste', columns: 33, rows: 20, editable:false)
											}
										
											}
								
								
							}
						}
						
						
						
						}//end of panel 3
				
					
					
					
			}//end frame
		}//end swing builder
		

		
		
		

		
		
		

	
		
		
	}

}
