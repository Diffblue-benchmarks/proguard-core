package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class InnerClassesAttributeDiffblueTest {
  /**
   * Method under test: {@link InnerClassesAttribute#InnerClassesAttribute()}
   */
  @Test
  public void testNewInnerClassesAttribute() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute = new InnerClassesAttribute();

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link InnerClassesAttribute#InnerClassesAttribute(int, int, InnerClassesInfo[])}
   */
  @Test
  public void testNewInnerClassesAttribute2() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute = new InnerClassesAttribute(1, 3,
        new InnerClassesInfo[]{new InnerClassesInfo(1, 1, 1, 1)});

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }
}
