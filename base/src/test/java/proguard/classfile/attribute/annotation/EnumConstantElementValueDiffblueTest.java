package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EnumConstantElementValueDiffblueTest {
  /**
   * Method under test: {@link EnumConstantElementValue#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ENUM_CONSTANT, (new EnumConstantElementValue(1, 1, 1)).getTag());
  }

  /**
   * Method under test:
   * {@link EnumConstantElementValue#EnumConstantElementValue()}
   */
  @Test
  public void testNewEnumConstantElementValue() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue();

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link EnumConstantElementValue#EnumConstantElementValue(int, int, int)}
   */
  @Test
  public void testNewEnumConstantElementValue2() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }
}
