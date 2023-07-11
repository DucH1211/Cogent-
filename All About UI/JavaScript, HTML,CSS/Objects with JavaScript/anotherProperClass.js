let person = require('./ProperClass');
class Employee extends person{
    salary = 100000.0;
    constructor(salary,_id,_name,_age)
    {
        super();
        this.salary=salary;
        console.log("Inside Employee Constructor.");
    }
    display()
    {
        super.display();
        console.log(this.salary);
    }
}
const e1 = new Employee(6548,23,'Chandrakant',45);
e1.display();
