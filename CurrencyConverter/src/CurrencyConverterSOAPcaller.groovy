
import groovy.swing.SwingBuilder

import java.awt.BorderLayout

import javax.swing.JFrame

@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*
import javax.swing.*


class CurrencyConverterSOAP {
	static void main(args){
		
	 StringBuilder moneylist = new StringBuilder()
	 moneylist.append("""\
  AFA-Afghanistan Afghani
  ALL-Albanian Lek
  DZD-Algerian Dinar
  ARS-Argentine Peso
  AWG-Aruba Florin
  AUD-Australian Dollar
  BSD-Bahamian Dollar
  BHD-Bahraini Dinar
  BDT-Bangladesh Taka
  BBD-Barbados Dollar
  BZD-Belize Dollar
  BMD-Bermuda Dollar
  BTN-Bhutan Ngultrum
  BOB-Bolivian Boliviano
  BWP-Botswana Pula
  BRL-Brazilian Real
  GBP-British Pound
  BND-Brunei Dollar
  BIF-Burundi Franc
  XOF-CFA Franc (BCEAO)
  XAF-CFA Franc (BEAC)
  KHR-Cambodia Riel
  CAD-Canadian Dollar
  CVE-Cape Verde Escudo
  KYD-Cayman Islands Dollar
  CLP-Chilean Peso
  CNY-Chinese Yuan
  COP-Colombian Peso
  KMF-Comoros Franc
  CRC-Costa Rica Colon
  HRK-Croatian Kuna
  CUP-Cuban Peso
  CYP-Cyprus Pound
  CZK-Czech Koruna
  DKK-Danish Krone
  DJF-Dijibouti Franc
  DOP-Dominican Peso
  XCD-East Caribbean Dollar
  EGP-Egyptian Pound
  SVC-El Salvador Colon
  EEK-Estonian Kroon
  ETB-Ethiopian Birr
  EUR-Euro
  FKP-Falkland Islands Pound
  GMD-Gambian Dalasi
  GHC-Ghanian Cedi
  GIP-Gibraltar Pound
  XAU-Gold Ounces
  GTQ-Guatemala Quetzal
  GNF-Guinea Franc
  GYD-Guyana Dollar
  HTG-Haiti Gourde
  HNL-Honduras Lempira
  HKD-Hong Kong Dollar
  HUF-Hungarian Forint
  ISK-Iceland Krona
  INR-Indian Rupee
  IDR-Indonesian Rupiah
  IQD-Iraqi Dinar
  ILS-Israeli Shekel
  JMD-Jamaican Dollar
  JPY-Japanese Yen
  JOD-Jordanian Dinar
  KZT-Kazakhstan Tenge
  KES-Kenyan Shilling
  KRW-Korean Won
  KWD-Kuwaiti Dinar
  LAK-Lao Kip
  LVL-Latvian Lat
  LBP-Lebanese Pound
  LSL-Lesotho Loti
  LRD-Liberian Dollar
  LYD-Libyan Dinar
  LTL-Lithuanian Lita
  MOP-Macau Pataca
  MKD-Macedonian Denar
  MGF-Malagasy Franc
  MWK-Malawi Kwacha
  MYR-Malaysian Ringgit
  MVR-Maldives Rufiyaa
  MTL-Maltese Lira
  MRO-Mauritania Ougulya
  MUR-Mauritius Rupee
  MXN-Mexican Peso
  MDL-Moldovan Leu
  MNT-Mongolian Tugrik
  MAD-Moroccan Dirham
  MZM-Mozambique Metical
  MMK-Myanmar Kyat
  NAD-Namibian Dollar
  NPR-Nepalese Rupee
  ANG-Neth Antilles Guilder
  NZD-New Zealand Dollar
  NIO-Nicaragua Cordoba
  NGN-Nigerian Naira
  KPW-North Korean Won
  NOK-Norwegian Krone
  OMR-Omani Rial
  XPF-Pacific Franc
  PKR-Pakistani Rupee
  XPD-Palladium Ounces
  PAB-Panama Balboa
  PGK-Papua New Guinea Kina
  PYG-Paraguayan Guarani
  PEN-Peruvian Nuevo Sol
  PHP-Philippine Peso
  XPT-Platinum Ounces
  PLN-Polish Zloty
  QAR-Qatar Rial
  ROL-Romanian Leu
  RUB-Russian Rouble
  WST-Samoa Tala
  STD-Sao Tome Dobra
  SAR-Saudi Arabian Riyal
  SCR-Seychelles Rupee
  SLL-Sierra Leone Leone
  XAG-Silver Ounces
  SGD-Singapore Dollar
  SKK-Slovak Koruna
  SIT-Slovenian Tolar
  SBD-Solomon Islands Dollar
  SOS-Somali Shilling
  ZAR-South African Rand
  LKR-Sri Lanka Rupee
  SHP-St Helena Pound
  SDD-Sudanese Dinar
  SRG-Surinam Guilder
  SZL-Swaziland Lilageni
  SEK-Swedish Krona
  TRY-Turkey Lira
  CHF-Swiss Franc
  SYP-Syrian Pound
  TWD-Taiwan Dollar
  TZS-Tanzanian Shilling
  THB-Thai Baht
  TOP-Tonga Pa'anga
  TTD-Trinidad & Tobago Dollar
  TND-Tunisian Dinar
  TRL-Turkish Lira
  USD-U.S. Dollar
  AED-UAE Dirham
  UGX-Ugandan Shilling
  UAH-Ukraine Hryvnia
  UYU-Uruguayan New Peso
  VUV-Vanuatu Vatu
  VEB-Venezuelan Bolivar
  VND-Vietnam Dong
  YER-Yemen Riyal
  YUM-Yugoslav Dinar
  ZMK-Zambian Kwacha
  ZWD-Zimbabwe Dollar""")
		def moneyarray = moneylist.toString().split(System.properties."line.separator")
	
		def swingBuilder = new SwingBuilder()
		swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
			lookAndFeel 'nimbus'  // Simple change in look and feel.
			frame(id: 'MainFrame',
				title: 'Currency Converter', 
				size: [350, 250],
				show: true, 
				locationRelativeTo: null, 
				defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
				
				borderLayout(vgap: 10)
				
				panel(constraints: BorderLayout.CENTER,
					border: compoundBorder([emptyBorder(5), titledBorder('Convert:')])) {
					tableLayout {
		
						
						tr{
							td{
								label 'From'
							}
							td{
								comboBox( id: 'fromcbx')
								moneyarray.each{ fromcbx.addItem(it) }
							}
						}
						
						tr{
							td{
								label 'To'
							}
							td{
								comboBox( id: 'tocbx')
								moneyarray.each{ tocbx.addItem(it) }
							}
						}
						
						

					}//end tableLayout
				}//end panel
					
					
				panel(constraints: BorderLayout.SOUTH){
					tableLayout {
						
						tr{
							td{
								label 'Input Value'
							}
							td{
								textField id: 'inputField', columns: 20
							}
						}
						
						tr{
							td{
								label 'Answer'
							}
							td{
								textField id: 'AnswerField', columns: 20, text: 'Answer', editable:false
								
							}
						}
	
						tr{
							td{
								def input = new Currency()
								button(text: "Convert", id: 'btn1', actionPerformed: {
									println fromcbx.selectedItem.split("-")[0].trim() + " " + tocbx.selectedItem.split("-")[0].trim()
									AnswerField.text = input.Result(fromcbx.selectedItem.split("-")[0].trim() ,tocbx.selectedItem.split("-")[0].trim(), inputField.text)
									})
							}
						}
					}
					
					
				}//endof panel 2
					
					
						
			}//end frame
		}//end swingbuilder
	}
	
}//end of class






class Currency{

	def client
	def response
	def result
	
	Currency(){ }
	
	def Result(def FromCurr, def ToCurr, def Value){
		if(Value =~ /\d{0,5}/ || Value == '' || Value == null)
		{

			this.client = new SOAPClient('http://www.webservicex.net/CurrencyConvertor.asmx')
			this.response = client.send(SOAPAction: "http://www.webserviceX.NET/ConversionRate")
			{
				body {
					ConversionRate('xmlns':"http://www.webserviceX.NET/") {
						FromCurrency(FromCurr as String)
						ToCurrency(ToCurr as String)
					}
				}
			}

			if( Value == '' || Value == null){
				this.result = response.ConversionRateResponse.ConversionRateResult
			}
			else{
				this.result = (response.ConversionRateResponse.ConversionRateResult.toString() as float) * (Value as float)
			}
		}
		else
		{
			this.result == 'INVALID INPUT'
		}
		return this.result
	}
	
}//end Currency class