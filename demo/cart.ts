import type { CartLine } from "./cartLine";

export interface Cart {
    fidelityPoints: number;
    lines: CartLine[];
}