package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SyntheticAttributeDiffblueTest {
  /**
   * Method under test: {@link SyntheticAttribute#SyntheticAttribute()}
   */
  @Test
  public void testNewSyntheticAttribute() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute();

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link SyntheticAttribute#SyntheticAttribute(int)}
   */
  @Test
  public void testNewSyntheticAttribute2() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute(1);

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }
}
