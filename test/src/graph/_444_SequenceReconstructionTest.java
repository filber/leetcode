package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _444_SequenceReconstructionTest {

    _444_SequenceReconstruction target = null;

    @Before
    public void before() throws Exception {
        target = new _444_SequenceReconstruction();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSequenceReconstruction1() throws Exception {
        int[] org = {1, 2, 3};
        int[][] seqs = {
                {1, 2},
                {1, 3}
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertFalse(valid);
    }

    @Test
    public void testSequenceReconstruction2() throws Exception {
        int[] org = {1, 2, 3};
        int[][] seqs = {
                {1, 2},
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertFalse(valid);
    }

    @Test
    public void testSequenceReconstruction3() throws Exception {
        int[] org = {1, 2, 3};
        int[][] seqs = {
                {1, 2},
                {2, 3},
                {1, 3}
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertTrue(valid);
    }

    @Test
    public void testSequenceReconstruction4() throws Exception {
        int[] org = {4, 1, 5, 2, 6, 3};
        int[][] seqs = {
                {5, 2, 6, 3},
                {4, 1, 5, 2}
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertTrue(valid);
    }

    @Test
    public void testSequenceReconstruction5() throws Exception {
        int[] org = {1, 2, 3, 4};
        int[][] seqs = {
                {1, 2, 3, 4},
                {4, 2}
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertFalse(valid);
    }

    @Test
    public void testSequenceReconstruction6() throws Exception {
        int[] org = {1, 2, 3, 4};
        int[][] seqs = {
                {1, 2},
                {2, 3},
                {3, 4},
        };
        boolean valid = target.sequenceReconstruction(org, seqs);
        assertTrue(valid);
    }
}
