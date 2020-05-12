var account1 = {
		accid: 123,
		accbal: 10000,
		deposit: function(amt) {
			console.log("depo amt");
		}
};

var x = 10;
var obj = { id: 10, depo: function() { }  };

function BankAccount(name, bal) {
	var accname = name;
	var accbal = bal;
	var obj = {
			deposit: function(amt) {
				console.log("deposit amt", amt);
			}
		};
	return obj;
}
function testAccount() {
	obj.id = 44;
	console.log("obj", obj);
	console.log("account1", account1);
	account1.accid = 400;
	account1.deposit(2000);
	console.log("balance", account1.accbal); //12000
	var account = new BankAccount("Anand", 10000);
	console.log("account", account);
	account.deposit(2000);
}


function testForInLoop() {
	var contactObj = {firstName:"Mike", lastName:"Jude", age:21, phone: 23453437};
	for (var prop in contactObj) {
	  console.log("Property name: " + prop + ", value: " + contactObj[prop]);
	}
}

function testForOfLoop() {
	var colors = ['Blue', 'Red', 'Green'];
	for (var color of colors) {
	  console.log(color);
	}	
}

function testWhileLoop() {
	var i = 0;
	while (i<=5) {
	 	   console.log("The number is " + i);
		   i++;
	}	
}

function testDoWhileLoop() {
	var i = 0;
	do {
	 	   console.log("The number is " + i);
		   i++;
	}while (i<=5);	
}



function testComparision() {
	var str = '12';
	console.log("str==12", (str==12));
	console.log("str===12", (str===12));
	
	if(5 > 6) {
		console.log("1");
	}
	else if(5 < 6) {
		console.log("2");
	}
	else {
		console.log("3");
	}
	
	var name = 'Anand';
	switch(name) {
		case 'Xor':
			console.log('Xor');
			break;
		case 'Anand':
			console.log('Anand');
			break;
		default:
			console.log('name not found');
	}

	var i = 0;
	do {
		console.log("do while");
		i += 1;
	}while(false);
}


function test() {
	/*
	var x = 50;
	var x;
	if(5 < 7) {
		var y = 20;
	}
	console.log("x =", x);
	console.log("y =", y);
	
	var a = 5;
	var b = '5';
	console.log("a==b", (a==b));
	console.log("a===b", (a===b));
	*/
	
	var studentObj = {id: 21, name: 'Anand', phone: 222};
	for(var x in studentObj) {
		console.log("studentObj.x = ", studentObj[x]);
	}
	var studentObj_2 = {id: 25, name: 'Tonny', phone: 333};
	
	var students = [studentObj];
	students.push(studentObj_2);
	for(var y in students) {
		console.log("students[y][name] = ", students[y]['name']);
	}
	alert("Hello Anand");
}

function sortNumber(a, b)
{
	//console.log(a, ' - ' , b, ' - ', (a - b));
	return a - b;
}

function testArray() {
	var n = ["10", "5", "40", "25", "100", "1"];
	//document.write(n.sort(sortNumber));
	
	var ary = [21, 78, 3, 42];
	var newAry = ary.map(function foo(no) {
		console.log(no);
		return no * 2;
	});
	console.log(newAry);
	ary.forEach(function foo(no) {
		console.log("forEach:", no);
	});
	
}

function testObjectInitializer_1() {
	var emptyObject = {};
	// create an object with properties
	var strKey = "a property with spaces";
	var obj = {
		stringProperty : "hello",
		integerProperty : 123,
		functionProperty : function() {
			return 0;
		},
		strKey : false,
		subObject : {
			booleanProperty : true
		}
	};
	console.log("obj", obj);
}

function testObjectInitializer_2() {
	// create an empty object
	var emptyObject = new Object();
	// define an object constructor
	function Keg(contains, amount) {
		this.contains = contains;
		this.amount = amount;
		this.getAmount = function() {
			return this.amount;
		}
	}
	// create an object
	var keg = new Keg("Soda", 100.0);
	keg.getAmount = 24;
	console.log("keg.contains", keg.contains);
	console.log("keg.amount", keg.getAmount);
}

function testObjectInitializer_3() {
	// create an empty object
	var emptyObject = Object.create(Object.prototype);

	// define an object with default properties
	var Keg = {
		contains : "Unknown",
		amount : 0.0
	}
	// create an object
	var keg = Object.create(Keg);
	// modify its properties
	keg.contains = "Soda";
	keg.abv = 100.0;
	console.log("keg.contains", keg.contains);
	console.log("keg.abv", keg.abv);
}

function testObject() {
	//empObj = new Object();
	var empObj = {};
	empObj.firstname = "Anand";
	empObj.phone = 43444343;
	empObj.getPhone = function() {
		return this.phone;
	};
	console.log(empObj);
}