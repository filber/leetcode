package graph;

import graph._2092_FindAllPeopleWithSecret;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _2092_FindAllPeopleWithSecretTest {

    _2092_FindAllPeopleWithSecret target;

    @Before
    public void setUp() throws Exception {
        target = new _2092_FindAllPeopleWithSecret();
    }

    @Test
    public void testFindAllPeople1() {
        int n = 6;
        int[][] meetings = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        int firstPerson = 1;
        List<Integer> persons = target.findAllPeople(n, meetings, firstPerson);
        Integer[] res = persons.toArray(new Integer[0]);
        Arrays.sort(res);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 5}, res);
    }

    @Test
    public void testFindAllPeople2() {
        int n = 4;
        int[][] meetings = {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}};
        int firstPerson = 3;
        List<Integer> persons = target.findAllPeople(n, meetings, firstPerson);
        Integer[] res = persons.toArray(new Integer[0]);
        Arrays.sort(res);
        assertArrayEquals(new Integer[]{0, 1, 3}, res);
    }

    @Test
    public void testFindAllPeople3() {
        int n = 5;
        int[][] meetings = {{3, 4, 2}, {1, 2, 1}, {2, 3, 1}};
        int firstPerson = 1;
        List<Integer> persons = target.findAllPeople(n, meetings, firstPerson);
        Integer[] res = persons.toArray(new Integer[0]);
        Arrays.sort(res);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, res);
    }

    @Test
    public void testFindAllPeople4() {
        int n = 6;
        int[][] meetings = {{0, 2, 1}, {1, 3, 1}, {4, 5, 1}};
        int firstPerson = 1;
        List<Integer> persons = target.findAllPeople(n, meetings, firstPerson);
        Integer[] res = persons.toArray(new Integer[0]);
        Arrays.sort(res);
        assertArrayEquals(new Integer[]{0, 1, 2, 3}, res);
    }

    @Test
    public void testFindAllPeople5() {
        int n = 5;
        int[][] meetings = {{1, 4, 3}, {0, 4, 3}};
        int firstPerson = 3;
        List<Integer> persons = target.findAllPeople(n, meetings, firstPerson);
        Integer[] res = persons.toArray(new Integer[0]);
        Arrays.sort(res);
        assertArrayEquals(new Integer[]{0, 1, 3, 4}, res);
    }
}