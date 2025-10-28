package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ArrayElementValueDiffblueTest {
  /**
   * Method under test: {@link ArrayElementValue#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ARRAY, (new ArrayElementValue()).getTag());
  }

  /**
   * Method under test: {@link ArrayElementValue#ArrayElementValue()}
   */
  @Test
  public void testNewArrayElementValue() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue = new ArrayElementValue();

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ArrayElementValue#ArrayElementValue(int, int, ElementValue[])}
   */
  @Test
  public void testNewArrayElementValue2() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue = new ArrayElementValue(1, 3,
        new ElementValue[]{new AnnotationElementValue()});

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }
}
