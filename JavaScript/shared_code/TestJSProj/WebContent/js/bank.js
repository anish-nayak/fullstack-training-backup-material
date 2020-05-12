function BankAccount(accNo, accName, accBalance) {
	this.accNo = accNo;
	this.accName = accName;
	this.accBalance = accBalance;
	this.withdraw = function(amount) {
		this.accBalance = this.accBalance - amount;
	}
}

function withdraw() {
	var accno = document.getElementById('accno').value;
	var accname = document.getElementById('accname').value;
	var accbal = document.getElementById('accbal').value;
	var amount = document.getElementById('amount').value;
	var bankObj = new BankAccount(accno, accname, parseInt(accbal));
	bankObj.withdraw(parseInt(amount));
	document.write("Remaining balance: " + bankObj.accBalance);
}