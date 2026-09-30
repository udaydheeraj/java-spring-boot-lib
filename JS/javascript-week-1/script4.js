const order = {
    orderId: 101,
    customr : "uday",
    items:[
         { name: "Laptop", price: 60000, quantity: 1 },
        { name: "Mouse", price: 1500, quantity: 2 },
        { name: "Keyboard", price: 2500, quantity: 1 }
    ]
}
 function calculateOrderTotal(order)
{
   let totalPrice = 0; 

    order.items.forEach(element => {
        itemtotal = element.price * element.quantity;
        totalPrice+=itemtotal;
    });

    if(totalPrice > 50000)
    {
        totalPrice=totalPrice - totalPrice * 0.1;
    }

    return totalPrice;
}

const orderTotal = calculateOrderTotal(order)
console.log(orderTotal);