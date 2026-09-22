import type { Product } from "./product";
import type { CartLine } from "./cartLine";
import type { CheckoutPayload } from "./cart";

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

const cart3 = {
    lines: [cocaLine, pizzaLine]
};

const payload: CheckoutPayload = {
    cart: cart3,
    fidelityPoints: 500
};

async function checkout(payload: CheckoutPayload): Promise<void> {
    const response = await fetch("http://localhost:8080/checkout", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    });

    const result = await response.json();

    console.log(result);
}

checkout(payload);