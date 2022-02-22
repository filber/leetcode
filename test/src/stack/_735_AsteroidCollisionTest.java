package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _735_AsteroidCollisionTest {

    _735_AsteroidCollision target = null;

    @Before
    public void before() throws Exception {
        target = new _735_AsteroidCollision();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testAsteroidCollision1() throws Exception {
        int[] asteroids = target.asteroidCollision(new int[]{5, 10, -5});
        assertArrayEquals(new int[]{5, 10}, asteroids);
    }

    @Test
    public void testAsteroidCollision2() throws Exception {
        int[] asteroids = target.asteroidCollision(new int[]{8, -8});
        assertEquals(0, asteroids.length);
    }

    @Test
    public void testAsteroidCollision3() throws Exception {
        int[] asteroids = target.asteroidCollision(new int[]{10, 2, -5});
        assertArrayEquals(new int[]{10}, asteroids);
    }

    @Test
    public void testAsteroidCollision4() throws Exception {
        int[] asteroids = target.asteroidCollision(new int[]{10, 2, -5, -20, -1});
        assertArrayEquals(new int[]{-20, -1}, asteroids);
    }

    @Test
    public void testAsteroidCollision5() throws Exception {
        int[] asteroids = target.asteroidCollision(new int[]{-2, -1, 1, 2});
        assertArrayEquals(new int[]{-2, -1, 1, 2}, asteroids);
    }
}
