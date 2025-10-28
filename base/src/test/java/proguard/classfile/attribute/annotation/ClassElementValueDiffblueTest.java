package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ClassElementValueDiffblueTest {
  /**
   * Method under test: {@link ClassElementValue#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_CLASS, (new ClassElementValue(1, 1)).getTag());
  }

  /**
   * Method under test: {@link ClassElementValue#ClassElementValue()}
   */
  @Test
  public void testNewClassElementValue() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue();

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }

  /**
   * Method under test: {@link ClassElementValue#ClassElementValue(int, int)}
   */
  @Test
  public void testNewClassElementValue2() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue(1, 1);

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }
}
