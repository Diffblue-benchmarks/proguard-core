package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SourceFileAttributeDiffblueTest {
  /**
   * Method under test: {@link SourceFileAttribute#SourceFileAttribute()}
   */
  @Test
  public void testNewSourceFileAttribute() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute();

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link SourceFileAttribute#SourceFileAttribute(int, int)}
   */
  @Test
  public void testNewSourceFileAttribute2() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute(1, 1);

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }
}
