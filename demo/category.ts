const CATEGORY = {
    DRINKS: "DRINKS",
    FOOD: "FOOD",
    OTHERS: "OTHERS"
} as const;

export type category = typeof CATEGORY [keyof  typeof CATEGORY ];