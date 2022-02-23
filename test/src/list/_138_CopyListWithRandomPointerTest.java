package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import list._138_CopyListWithRandomPointer.Node;

import static org.junit.Assert.*;

public class _138_CopyListWithRandomPointerTest {

    _138_CopyListWithRandomPointer target = null;

    @Before
    public void before() throws Exception {
        target = new _138_CopyListWithRandomPointer();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCopyRandomList1() throws Exception {
        Node one = new Node(7);
        Node two = new Node(13);
        Node three = new Node(11);
        Node four = new Node(10);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        two.random = one;
        three.next = four;
        three.random = five;
        four.next = five;
        four.random = three;
        five.random = one;

        Node cNode = target.copyRandomList(one);
        assertEquals(7, cNode.val);
        assertEquals(13, cNode.next.val);
        assertNull(cNode.random);
    }


    @Test
    public void testCopyRandomList2() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        one.next = two;
        one.random = two;
        two.random = two;

        Node cNode = target.copyRandomList(one);
        assertEquals(1, cNode.val);
        assertEquals(2, cNode.next.val);
        assertEquals(2, cNode.random.val);
        assertEquals(2, cNode.random.random.val);
        assertNull(cNode.random.next);
    }

    @Test
    public void testCopyRandomList3() throws Exception {
        Node one = new Node(3);
        Node two = new Node(3);
        Node three = new Node(3);
        one.next = two;
        two.next = three;
        two.random = one;

        Node cNode = target.copyRandomList(one);
        assertEquals(3, cNode.val);
    }
}
