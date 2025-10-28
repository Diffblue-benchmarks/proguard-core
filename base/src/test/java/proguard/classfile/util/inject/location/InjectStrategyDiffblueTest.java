package proguard.classfile.util.inject.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InjectStrategyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InjectStrategy.InjectLocation#InjectLocation(int, boolean)}
   *   <li>{@link InjectStrategy.InjectLocation#getOffset()}
   *   <li>{@link InjectStrategy.InjectLocation#shouldInjectBefore()}
   * </ul>
   */
  @Test
  public void testInjectLocationGettersAndSetters() {
    // Arrange and Act
    InjectStrategy.InjectLocation actualInjectLocation = new InjectStrategy.InjectLocation(2, true);
    int actualOffset = actualInjectLocation.getOffset();

    // Assert
    assertEquals(2, actualOffset);
    assertTrue(actualInjectLocation.shouldInjectBefore());
  }
}
