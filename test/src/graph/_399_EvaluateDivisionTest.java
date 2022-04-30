package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _399_EvaluateDivisionTest {

    _399_EvaluateDivision target = null;

    @Before
    public void before() throws Exception {
        target = new _399_EvaluateDivision();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCalcEquation1() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] ans = target.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, ans, 0.005);
    }

    @Test
    public void testCalcEquation2() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));

        double[] values = new double[]{1.5, 2.5, 5.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));

        double[] ans = target.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{3.75, 0.4, 5.0, 0.2}, ans, 0.005);
    }

    @Test
    public void testCalcEquation3() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));

        double[] values = new double[]{0.5};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("x", "y"));

        double[] ans = target.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{0.5, 2.0, -1.0, -1.0}, ans, 0.005);
    }

    @Test
    public void testCalcEquation4() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));

        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));

        double[] ans = target.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{360.0, 0.008333, 20.0, 1.0, -1.0, -1.0}, ans, 0.005);
    }
}
