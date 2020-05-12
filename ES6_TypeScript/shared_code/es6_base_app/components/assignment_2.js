
let fibonacci = {
    [Symbol.iterator]() {
        let pre = 0;
        let cur = 1;
        return {
            next() {
                [pre, cur] = [cur, pre + cur];
                return {done: false, value: cur};
            }
        }
    }

}
const preAttr = Symbol('pre');
const curAttr = Symbol('cur');
class Fibonacci {
    constructor(pre, cur) {
        this[preAttr] = pre;
        this[curAttr] = cur;
    }
    next() {
        [this[preAttr], this[curAttr]] = [this[curAttr], this[preAttr] + this[curAttr]];
        return {done: false, value: this[curAttr]};
    }
}
export function testFibo() {
    let fibo = new Fibonacci(0, 1);
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
    console.log("fibo no: ", fibo.next());
}

class Armstrong {
    constructor(lastArmstrongNumber) {
        this.lastArmstrongNumber = lastArmstrongNumber;
    }
    getNextArmstrong() {
        for(let i=this.lastArmstrongNumber + 1;i<1000;i++) {
            if(this.isArmstrong(i) == true) {
                this.lastArmstrongNumber =  i;
                return {done: false, value: this.lastArmstrongNumber};
            }
        }
        return {done: true, message: 'Can find armstrong number < 1000 only'};
    }
    isArmstrong(num)
	{
		let flag, remainder, addition = 0;
		flag = num;
		while(num > 0)
		{
			remainder = num%10;
			addition = addition + remainder*remainder*remainder;
			num = parseInt(num/10);
		}
		if(addition == flag)
		{
			return true;
		}
		else
		{
			return false;
		}
	}    
}

export function testArmstrong() {
    let armstrongObj = new Armstrong(0);
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
    console.log("Armstrong: ", armstrongObj.getNextArmstrong());
}

export function * armstrongGenerator() {
    let reset = false;
    for(let i=0;i<1000;i++) {
        if(reset == true) {
            i = 0;
        }
        if(isArmstrong(i) == true) {
            if(i > 370) {
                throw('Armstrong no cannot be > 370');
            }
            reset = yield(i);
        }
    }
}
export function testArmstrongGenerator() {
    let armGen = armstrongGenerator();
    console.log('Gen armstrong: ', armGen.next().value);
    console.log('Gen armstrong: ', armGen.next().value);
    console.log('Gen armstrong: ', armGen.next().value);
    console.log('Gen armstrong: ', armGen.next(true).value);
    console.log('Gen armstrong: ', armGen.next().value);
    console.log('Gen armstrong: ', armGen.next().value);
    console.log('Gen armstrong: ', armGen.next().value);
    
}
function isArmstrong(num)
{
    let flag, remainder, addition = 0;
    flag = num;
    while(num > 0)
    {
        remainder = num%10;
        addition = addition + remainder*remainder*remainder;
        num = parseInt(num/10);
    }
    if(addition == flag)
    {
        return true;
    }
    else
    {
        return false;
    }
}    

