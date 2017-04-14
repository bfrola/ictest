package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Class Item implements a container that can either hold a single value or a list of other Item objects.
 * @param <T> Type of data hold by Item.
 */
public class Item<T> {
    private final Optional<Item<T>[]> nestedList;
    private final Optional<T> value;

    // Make class not directly instantiable
    private Item() {
        nestedList = Optional.empty();
        value = Optional.empty();
    }

    private Item(T value) {
        this.value = Optional.of(value);
        nestedList = Optional.empty();
    }

    private Item(Item<T>... list) {
        nestedList = Optional.of(list);
        value = Optional.empty();
    }

    /**
     * @return All values in this item or and all items in nested list of items.
     * Note that streams and flatMap method were deliberately not used as specified in problem statement.
     */
    public List<T> getAll() {
        if (value.isPresent()) {
            return Arrays.asList(value.get());
        }
        else if (nestedList.isPresent()) {
            List<T> result = new ArrayList<>();
            for(Item item : nestedList.get()) {
                result.addAll(item.getAll());
            }
            return result;
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return value.map(v -> v.toString())
                .orElse(nestedList.map(l -> l.toString())
                        .orElse("Empty Item"));
    }

    public static <T> Item<T> newInstance(T value) {
        return new Item<>(value);
    }

    public static <T> Item<T> newInstance(Item<T> item) {
        return new Item<>(new Item[] { item });
    }

    public static <T> Item<T> newInstance(Item<T>... list) {
        return new Item<>(list);
    }
}
