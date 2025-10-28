package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ConstantElementValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantElementValue#ConstantElementValue(char)}
   *   <li>{@link ConstantElementValue#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConstantElementValue actualConstantElementValue = new ConstantElementValue('A');

    // Assert
    assertEquals('A', actualConstantElementValue.getTag());
    assertNull(actualConstantElementValue.getProcessingInfo());
    assertEquals(0, actualConstantElementValue.getProcessingFlags());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantElementValue#ConstantElementValue(char, int, int)}
   *   <li>{@link ConstantElementValue#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ConstantElementValue actualConstantElementValue = new ConstantElementValue('A', 1, 1);

    // Assert
    assertEquals('A', actualConstantElementValue.getTag());
    assertNull(actualConstantElementValue.getProcessingInfo());
    assertEquals(0, actualConstantElementValue.getProcessingFlags());
  }
}
