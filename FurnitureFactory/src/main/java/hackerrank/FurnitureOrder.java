package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * map of Furniture items to order quantities
     */
    private final HashMap<Furniture, Integer> order;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        order = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer resultCount = furnitureCount;
        if (order.containsKey(type)) {
            Integer existingCount = order.get(type);
            resultCount += existingCount;
        }
        order.put(type, resultCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<>(order);
    }

    public int getTypeCount(Furniture type) {
        if (order.containsKey(type)) {
            return order.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        int typeCount = getTypeCount(type);
        return type.cost() * typeCount;
    }

    public float getTotalOrderCost() {
        return order.entrySet().stream()
                .map(e -> e.getKey().cost() * e.getValue())
                .reduce(0.0f, Float::sum);
    }

    public int getTotalOrderQuantity() {
        return order.values().stream().mapToInt(Integer::intValue).sum();
    }
}