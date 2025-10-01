package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantElementValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantElementValue#ConstantElementValue(char)}
   *   <li>{@link ConstantElementValue#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantElementValue.<init>(char)",
    "void ConstantElementValue.<init>(char, int, int)",
    "char ConstantElementValue.getTag()"
  })
  void testGettersAndSetters_whenA() {
    // Arrange and Act
    ConstantElementValue actualConstantElementValue = new ConstantElementValue('A');

    // Assert
    assertEquals('A', actualConstantElementValue.getTag());
    assertNull(actualConstantElementValue.getProcessingInfo());
    assertEquals(0, actualConstantElementValue.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantElementValue#ConstantElementValue(char, int, int)}
   *   <li>{@link ConstantElementValue#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantElementValue.<init>(char)",
    "void ConstantElementValue.<init>(char, int, int)",
    "char ConstantElementValue.getTag()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    ConstantElementValue actualConstantElementValue = new ConstantElementValue('A', 1, 1);

    // Assert
    assertEquals('A', actualConstantElementValue.getTag());
    assertNull(actualConstantElementValue.getProcessingInfo());
    assertEquals(0, actualConstantElementValue.getProcessingFlags());
  }
}
