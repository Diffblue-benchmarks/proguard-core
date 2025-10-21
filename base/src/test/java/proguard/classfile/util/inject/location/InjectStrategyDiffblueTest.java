package proguard.classfile.util.inject.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.util.inject.location.InjectStrategy.InjectLocation;

public class InjectStrategyDiffblueTest {
  /**
   * Test InjectLocation getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InjectLocation#InjectLocation(int, boolean)}
   *   <li>{@link InjectLocation#getOffset()}
   *   <li>{@link InjectLocation#shouldInjectBefore()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InjectLocation.<init>(int, boolean)",
    "int InjectLocation.getOffset()",
    "boolean InjectLocation.shouldInjectBefore()"
  })
  public void testInjectLocationGettersAndSetters() {
    // Arrange and Act
    InjectLocation actualInjectLocation = new InjectLocation(2, true);
    int actualOffset = actualInjectLocation.getOffset();

    // Assert
    assertEquals(2, actualOffset);
    assertTrue(actualInjectLocation.shouldInjectBefore());
  }
}
