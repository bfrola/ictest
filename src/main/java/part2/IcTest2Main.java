package part2;

public class IcTest2Main {
    /**
     * PROBLEM:
     * Write a function that will flatten an array of arbitrarily nested arrays of integers
     * into a flat array of integers. e.g. [[1,2,[3]],4] → [1,2,3,4]. If the language you're using
     * has a function to flatten arrays, you should pretend it doesn't exist.
     *
     * SOLUTION:
     * Class Item implements a container that can either hold a single value or a list of other Item objects.
     * This makes the Item potentially arbitrarily nested. Method getAll returns a flat list of all values contained.
     * Test for class Item are present in the project test folder.
     */
    public static void main(String[] args) {
        System.out.println("IC test #2");

        System.out.println(Item.newInstance(
                Item.newInstance(Item.newInstance(1), Item.newInstance(2), Item.newInstance(Item.newInstance(3))),
                Item.newInstance(4)).getAll());
    }
}
