import ArrayListImplementation.ArrayListImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayListImplementationTests {
    private ArrayListImplementation<String> list;

    @Before
    public void setUp() {
        list = new ArrayListImplementation<String>();
    }

    @Test
    public void test_add() {
        Assertions.assertEquals(0, list.size());

        list.add("chicken");

        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("chicken", list.get(0));
    }

    @Test
    public void test_removeByIndex() {
        list.add("chicken");
        Assertions.assertEquals(1, list.size());

        list.remove(0);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void test_removeByItem() {
        list.add("chicken");
        Assertions.assertEquals(1, list.size());

        list.remove("chicken");
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void test_listSize() {
        Assertions.assertEquals(0, list.size());

        list.add("chicken");

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void test_getByIndex() {
        list.add("chicken");
        list.add("dog");
        list.add("wolf");
        list.add("bird");

        Assertions.assertEquals("chicken", list.get(0));
        Assertions.assertEquals("dog", list.get(1));
        Assertions.assertEquals("wolf", list.get(2));
        Assertions.assertEquals("bird", list.get(3));
    }

    @Test
    public void test_get_invalidIndex_shouldThrowException() {
        list.add("chicken");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

    @Test
    public void test_resizeBeyondInitialCapacity() {
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }

        Assertions.assertEquals(20, list.size());
        Assertions.assertEquals("item0", list.get(0));
        Assertions.assertEquals("item19", list.get(19));
    }

    @Test
    public void test_iterator() {
        list.add("a");
        list.add("b");
        list.add("c");

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        Assertions.assertEquals("abc", sb.toString());
    }
}
