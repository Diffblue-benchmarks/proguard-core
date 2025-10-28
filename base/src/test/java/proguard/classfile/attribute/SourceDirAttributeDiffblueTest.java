package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SourceDirAttributeDiffblueTest {
  /**
   * Method under test: {@link SourceDirAttribute#SourceDirAttribute()}
   */
  @Test
  public void testNewSourceDirAttribute() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute();

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link SourceDirAttribute#SourceDirAttribute(int, int)}
   */
  @Test
  public void testNewSourceDirAttribute2() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute(1, 1);

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }
}
