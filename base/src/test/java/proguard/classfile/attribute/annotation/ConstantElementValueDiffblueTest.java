package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantElementValueDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantElementValue.<init>(char)",
    "void ConstantElementValue.<init>(char, int, int)",
    "char ConstantElementValue.getTag()"
  })
  public void testGettersAndSetters_whenA() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantElementValue.<init>(char)",
    "void ConstantElementValue.<init>(char, int, int)",
    "char ConstantElementValue.getTag()"
  })
  public void testGettersAndSetters_whenOne() {
    // Arrange and Act
    ConstantElementValue actualConstantElementValue = new ConstantElementValue('A', 1, 1);

    // Assert
    assertEquals('A', actualConstantElementValue.getTag());
    assertNull(actualConstantElementValue.getProcessingInfo());
    assertEquals(0, actualConstantElementValue.getProcessingFlags());
  }
}
