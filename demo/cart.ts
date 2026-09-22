import type { CartLine } from "./cartLine";

export interface Cart {
    lines: CartLine[];
}

export interface CheckoutPayload {
    cart: Cart;
    fidelityPoints: number;
}