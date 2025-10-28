package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.Metrics;

public class ObjectUtilDiffblueTest {
  /**
   * Method under test: {@link ObjectUtil#equal(Object, Object)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertFalse(ObjectUtil.equal("Object1", "Object2"));
    assertTrue(ObjectUtil.equal("Object2", "Object2"));
    assertFalse(ObjectUtil.equal(null, "Object2"));
    assertTrue(ObjectUtil.equal(null, null));
  }

  /**
   * Method under test: {@link ObjectUtil#hashCode(Object)}
   */
  @Test
  public void testHashCode() {
    // Arrange, Act and Assert
    assertEquals(-1939501217, ObjectUtil.hashCode("Object"));
    assertEquals(0, ObjectUtil.hashCode(null));
  }

  /**
   * Method under test: {@link ObjectUtil#compare(Comparable, Comparable)}
   */
  @Test
  public void testCompare() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectUtil.compare(Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED,
        Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED));
    assertEquals(0, ObjectUtil.compare(null, null));
    assertEquals(-1, ObjectUtil.compare(null, Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED));
    assertEquals(1, ObjectUtil.compare(Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED, null));
  }
}
