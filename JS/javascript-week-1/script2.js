const productName = "wireless keyboard";
const price = 1500;
const quantity = 2;

const subTotal = quantity * price;
const discount = subTotal * 0.10 ;

const taxableAmount = subTotal - discount;
const gst = taxableAmount * 0.18;

const finalAmount = taxableAmount + gst;

console.log("Product: ", productName);
console.log("Price: ", price);
console.log("Quantity:", quantity);
console.log("Sub-total:", subTotal);
console.log("Discount:", discount);
console.log("TaxableAmount :", taxableAmount);
console.log("GST:", gst);
console.log("final AMount :", finalAmount);

