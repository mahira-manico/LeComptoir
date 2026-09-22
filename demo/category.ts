const CATEGORY = {
    DRINKS: "DRINKS",
    FOOD: "FOOD",
    OTHERS: "OTHERS"
} as const;

type category = typeof CATEGORY [keyof  typeof CATEGORY ];