import type { ReceiptLines } from "./receiptLines";

export interface Receipt {
    lines: ReceiptLines[];
    total: number;
}