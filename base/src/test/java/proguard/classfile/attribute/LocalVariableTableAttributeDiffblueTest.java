package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LocalVariableTableAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link LocalVariableTableAttribute#LocalVariableTableAttribute()}
   */
  @Test
  public void testNewLocalVariableTableAttribute() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute = new LocalVariableTableAttribute();

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link LocalVariableTableAttribute#LocalVariableTableAttribute(int, int, LocalVariableInfo[])}
   */
  @Test
  public void testNewLocalVariableTableAttribute2() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute = new LocalVariableTableAttribute(1, 3,
        new LocalVariableInfo[]{new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }
}
