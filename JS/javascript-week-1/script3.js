function calculateFinalPrice(price, quantity, discount) {
    const originalPrice = price * quantity;
    const discountAmount = originalPrice * (discount * 0.01);
    const finalPrice = originalPrice - discountAmount;

    // Multiply by (1 - discount percentage) to get the remaining price
    return {
        originalPrice: originalPrice,
        discountAmount: discountAmount,
        finalprice: finalPrice
    }
}

// Testing with 500 * 3 = 1500 minus a 10% discount (150)
console.log(calculateFinalPrice(500, 3, 10)); // Output: 1350
