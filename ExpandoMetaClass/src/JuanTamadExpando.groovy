
class JuanTamadExpando {
	String name
	JuanTamadExpando(String name) { this.name = name }
	
	def eat() { "$name can eat." }
	
	public static void main(String[] args) {
		JuanTamadExpando person = new JuanTamadExpando('Juan')
		person.metaClass.run { "$person.name can also run!" }
		person.metaClass.run { "$person.name can also walk!" }
		person.metaClass.crossFit { "$person.name does cross-fitting, too!" }
		person.metaClass.wehdinga {"$person.name is amazing!!!" }
		
		println person.eat()
		println 'But wait, he can do more!'
		println person.run()
		println person.crossFit()
		println person.wehdinga()
		
		
		
		
	}
}
