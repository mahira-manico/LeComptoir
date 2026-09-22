import type { Category } from "./category"
export interface Product {
    reference : string ; 
    label : string ;
    price: number ;
    category : Category ;
}