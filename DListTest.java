package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    void testConstructor() {
        DList<Integer> c= new DList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    public void testAppendAndToStringR() {
        DList<String> ll= new DList<>();
        ll.append("CS2110");
        assertEquals("[CS2110]", ll.toString());
        assertEquals("[CS2110]", ll.toStringR());
        assertEquals(1, ll.size());

        ll.append("CS2800");
        assertEquals("[CS2110, CS2800]", ll.toString());
        assertEquals("[CS2800, CS2110]", ll.toStringR());
        assertEquals(2, ll.size());

        ll.append("MATH 2940");
        assertEquals("[CS2110, CS2800, MATH 2940]", ll.toString());
        assertEquals("[MATH 2940, CS2800, CS2110]", ll.toStringR());
        assertEquals(3, ll.size());
    }

    @Test
    public void testPrepend() {
        DList<String> ll= new DList<>();
        ll.prepend("CS2110");
        assertEquals("[CS2110]", ll.toString());
        assertEquals("[CS2110]", ll.toStringR());
        assertEquals(1, ll.size());

        ll.prepend("CS2800");
        assertEquals("[CS2800, CS2110]", ll.toString());
        assertEquals("[CS2110, CS2800]", ll.toStringR());
        assertEquals(2, ll.size());

        ll.prepend("MATH 2940");
        assertEquals("[MATH 2940, CS2800, CS2110]", ll.toString());
        assertEquals("[CS2110, CS2800, MATH 2940]", ll.toStringR());
        assertEquals(3, ll.size());
    }

    @Test
    public void testGetNode() {
        DList<String> ll= new DList<>();
        String[] list= { "first", "second", "third", "fourth", "fifth", "sixth",
                "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth",
                "thirteenth", "fourteenth", "fifteenth", "sixteenth",
                "seventeenth", "eighteenth", "nineteenth", "twentieth" };
        for (int i= 0; i < 20; i++ ) {
            ll.append(list[i]);
        }

        // Testing assert statements
        assertThrows(IllegalArgumentException.class,
            () -> ll.getNode(-1));
        assertThrows(IllegalArgumentException.class,
            () -> ll.getNode(25));

        // Testing method body
        assertEquals("first", ll.getNode(0).value());
        assertEquals("second", ll.getNode(1).value());
        assertEquals("third", ll.getNode(2).value());
        assertEquals("fourth", ll.getNode(3).value());
        assertEquals("fifth", ll.getNode(4).value());
        assertEquals("sixth", ll.getNode(5).value());
        assertEquals("seventh", ll.getNode(6).value());
        assertEquals("eighth", ll.getNode(7).value());
        assertEquals("ninth", ll.getNode(8).value());
        assertEquals("tenth", ll.getNode(9).value());
        assertEquals("eleventh", ll.getNode(10).value());
        assertEquals("twelfth", ll.getNode(11).value());
        assertEquals("thirteenth", ll.getNode(12).value());
        assertEquals("fourteenth", ll.getNode(13).value());
        assertEquals("fifteenth", ll.getNode(14).value());
        assertEquals("sixteenth", ll.getNode(15).value());
        assertEquals("seventeenth", ll.getNode(16).value());
        assertEquals("eighteenth", ll.getNode(17).value());
        assertEquals("nineteenth", ll.getNode(18).value());
        assertEquals("twentieth", ll.getNode(19).value());
    }

    @Test
    void testDeleteNode() {
        // Tests when n is not the head or the tail
        DList<String> llFirst= new DList<>();
        llFirst.append("first");
        llFirst.append("second");
        llFirst.append("third");
        llFirst.delete(llFirst.getNode(1));
        assertEquals("[first, third]", llFirst.toString());
        assertEquals("[third, first]", llFirst.toStringR());
        assertEquals(2, llFirst.size());

        // Tests when n is the head and not the tail
        DList<String> llSecond= new DList<>();
        llSecond.append("first");
        llSecond.append("second");
        llSecond.append("third");
        llSecond.delete(llSecond.getNode(0));
        assertEquals("[second, third]", llSecond.toString());
        assertEquals("[third, second]", llSecond.toStringR());
        assertEquals(2, llSecond.size());

        // Tests when n is tail and not the head
        DList<String> llThird= new DList<>();
        llThird.append("first");
        llThird.append("second");
        llThird.append("third");
        llThird.delete(llThird.getNode(2));
        assertEquals("[first, second]", llThird.toString());
        assertEquals("[second, first]", llThird.toStringR());
        assertEquals(2, llThird.size());

        // Tests when n is the head and the tail (only element in list)
        DList<String> llFourth= new DList<>();
        llFourth.append("first");
        llFourth.delete(llFourth.getNode(0));
        assertEquals("[]", llFourth.toString());
        assertEquals("[]", llFourth.toStringR());
        assertEquals(0, llFourth.size());
    }

    @Test
    void testInsertAfter() {
        // Tests when n is the tail
        DList<String> llFirst= new DList<>();
        llFirst.append("first");
        llFirst.append("second");
        llFirst.insertAfter("third", llFirst.getNode(1));
        assertEquals("[first, second, third]", llFirst.toString());
        assertEquals("[third, second, first]", llFirst.toStringR());
        assertEquals(3, llFirst.size());

        // Tests when n is not the tail
        DList<String> llSecond= new DList<>();
        llSecond.append("first");
        llSecond.append("third");
        llSecond.insertAfter("second", llSecond.getNode(0));
        assertEquals("[first, second, third]", llSecond.toString());
        assertEquals("[third, second, first]", llSecond.toStringR());
        assertEquals(3, llSecond.size());

        // Tests when n is the head and tail
        DList<String> llThird= new DList<>();
        llThird.append("first");
        llThird.insertAfter("second", llThird.getNode(0));
        assertEquals("[first, second]", llThird.toString());
        assertEquals("[second, first]", llThird.toStringR());
        assertEquals(2, llThird.size());
    }
}
