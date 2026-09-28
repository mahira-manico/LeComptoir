import type { Product } from "./product";
import type { CartLine } from "./cartLine";
import type { Cart } from "./cart";

//create cart with product, the line and a full cart
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
    fidelityPoints:0,
    lines:[cocaLine]
};


// @ts-ignore, fetch method to send a json body cart to backend java
export async function sendCartToBackend(fidelityPoints:number): Promise<void> {
    const response = await fetch(`http://localhost:8080/checkout?points=${cart.fidelityPoints}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(cart),
    });

    if (!response.ok) {
        console.error("Error, cannot send cart");
    } else {
        console.log("Cart sent to backend!");
    }
}

sendCartToBackend(0).then(r => Promise<string>);