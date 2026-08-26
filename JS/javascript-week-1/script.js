const employeeId = 101;
const employeeName = "John";
const department = "IT";
const basicSalary = 60000;
const experience = 4;
const active = true;

const hra = basicSalary * 0.20;
const da = basicSalary * 0.10;

const grossSalary = basicSalary + hra + da;

const bonusEligible =
    experience >= 3 && active === true;

console.log("Employee ID:", employeeId);
console.log("Employee Name:", employeeName);
console.log("Department:", department);
console.log("Basic Salary:", basicSalary);
console.log("HRA:", hra);
console.log("DA:", da);
console.log("Gross Salary:", grossSalary);
console.log("Bonus Eligible:", bonusEligible);
