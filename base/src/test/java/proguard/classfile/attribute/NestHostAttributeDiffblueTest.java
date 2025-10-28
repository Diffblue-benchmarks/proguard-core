package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class NestHostAttributeDiffblueTest {
  /**
   * Method under test: {@link NestHostAttribute#NestHostAttribute()}
   */
  @Test
  public void testNewNestHostAttribute() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute();

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link NestHostAttribute#NestHostAttribute(int, int)}
   */
  @Test
  public void testNewNestHostAttribute2() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute(1, 1);

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }
}
