package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LocalVariableTypeTableAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute()}
   */
  @Test
  public void testNewLocalVariableTypeTableAttribute() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute = new LocalVariableTypeTableAttribute();

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute(int, int, LocalVariableTypeInfo[])}
   */
  @Test
  public void testNewLocalVariableTypeTableAttribute2() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(1, 3,
        new LocalVariableTypeInfo[]{new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }
}
