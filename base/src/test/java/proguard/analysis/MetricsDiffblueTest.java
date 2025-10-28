package proguard.analysis;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MetricsDiffblueTest {
  /**
   * Method under test: {@link Metrics#flush()}
   */
  @Test
  public void testFlush() {
    // Arrange, Act and Assert
    assertEquals("Metrics:\n", Metrics.flush());
  }
}
