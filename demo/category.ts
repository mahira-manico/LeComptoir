const CATEGORY = {
    DRINKS: "DRINKS",
    FOOD: "FOOD",
    OTHERS: "OTHERS"
} as const;

export type Category = typeof CATEGORY [keyof  typeof CATEGORY ];