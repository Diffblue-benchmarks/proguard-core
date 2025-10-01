package proguard.classfile.util.inject.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.util.inject.location.InjectStrategy.InjectLocation;

class InjectStrategyDiffblueTest {
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
  @DisplayName("Test InjectLocation getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InjectLocation.<init>(int, boolean)",
    "int InjectLocation.getOffset()",
    "boolean InjectLocation.shouldInjectBefore()"
  })
  void testInjectLocationGettersAndSetters() {
    // Arrange and Act
    InjectLocation actualInjectLocation = new InjectLocation(2, true);
    int actualOffset = actualInjectLocation.getOffset();

    // Assert
    assertEquals(2, actualOffset);
    assertTrue(actualInjectLocation.shouldInjectBefore());
  }
}
