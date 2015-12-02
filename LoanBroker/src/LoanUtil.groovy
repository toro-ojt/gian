class lakwentsalgo {
	//def a = new LoanSoap()

String LoanStatus

double getCommission(double amount, double rate)
{
def commission = amount * (rate/100)

//commission

}//end of commission

def getInterest(double rate , double amount, double time)
{
	
	return ((amount * (rate/100)) * time)

}

def Status(double amount, double time, String bankName) {
	
	switch(bankName)
	{
	case 'Bronze Bank 1':
		
		if (amount >= 10000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		
		break;
	case 'Bronze Bank 2':
		if (amount >= 10000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Bronze Bank 3':
		if (amount >= 10000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Bronze Bank 4':
		if (amount >= 18000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Bronze Bank 5':
		if (amount >= 15000 && time <= (amount/6000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Bronze Bank 6':
		if (amount >= 15000 && time <= (amount/5000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Bronze Bank 7':
		if (amount >= 18000 && time <= (amount/4000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 1':
		if (amount >= 20000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 2':
		if (amount >= 20000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 3':
		if (amount >= 30000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 4':
		if (amount >= 30000 && time <= (amount/9000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 5':
		if (amount >= 30000 && time <= (amount/8000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Silver Bank 6':
		if (amount >= 30000 && time <= (amount/7000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
		
	case 'Silver Bank 7':
		if (amount >= 35000 && time <= (amount/6000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
		
	case 'Gold Bank 1':
		if (amount >= 35000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 2':
		if (amount >= 35000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 3':
		if (amount >= 35000 && time <= (amount/10000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 4':
		if (amount >= 40000 && time <= (amount/9000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 5':
		if (amount >= 40000 && time <= (amount/8000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 6':
		if (amount >= 40000 && time <= (amount/7000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
	case 'Gold Bank 7':
		if (amount >= 40000 && time <= (amount/6000)){
			LoanStatus = 'Approved'
		}
		else {
			LoanStatus = 'Rejected'
		}
		break;
		
	}

	
	
}


}