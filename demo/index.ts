import type { Product } from "./product";
import type { CartLine } from "./cartLine";
import type { Cart } from "./cart";


const coca: Product = {
    reference: "P001",
    label: "Coca",
    price: 2.50,
    category: "DRINKS"
};
const pizza: Product = {
    reference: "P002",
    label: "Pizza",
    price: 8.00,
    category: "FOOD"
};

const cocaLine: CartLine = {
    product: coca,
    quantity: 2
};
const pizzaLine: CartLine = {
    product: pizza,
    quantity: 1
};

const cart: Cart = {
    lines: [cocaLine]
};
const cart2: Cart = {
    lines: [pizzaLine]
};

const cart3: Cart = {
    lines: [cocaLine, pizzaLine]
};

function calculateTotal(cart: Cart): number {
    let total = 0;

    for (const line of cart.lines) {
        total += line.product.price * line.quantity;
    }

    return total;
}

console.log(calculateTotal(cart));


function displayReceipt(cart: Cart): void {
    console.log(" _________ RECEIPT ___________ ");
    for ( const line of cart.lines){
        const lineTotal = line.product.price * line.quantity

        console.log(
           line.product.label +
           " x" +
           line.quantity +
           " : " +
           lineTotal +
           " €"

        );
    }


    console.log("TOTAL :" + calculateTotal(cart) +" €");
    console.log("-----------------------");
}
displayReceipt(cart);
displayReceipt(cart2);
displayReceipt(cart3);