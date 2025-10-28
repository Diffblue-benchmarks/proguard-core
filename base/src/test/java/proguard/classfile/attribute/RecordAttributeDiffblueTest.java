package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RecordAttributeDiffblueTest {
  /**
   * Method under test: {@link RecordAttribute#RecordAttribute()}
   */
  @Test
  public void testNewRecordAttribute() {
    // Arrange and Act
    RecordAttribute actualRecordAttribute = new RecordAttribute();

    // Assert
    assertNull(actualRecordAttribute.getProcessingInfo());
    assertEquals(0, actualRecordAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RecordAttribute#RecordAttribute(int, int, RecordComponentInfo[])}
   */
  @Test
  public void testNewRecordAttribute2() {
    // Arrange and Act
    RecordAttribute actualRecordAttribute = new RecordAttribute(1, 3,
        new RecordComponentInfo[]{new RecordComponentInfo()});

    // Assert
    assertNull(actualRecordAttribute.getProcessingInfo());
    assertEquals(0, actualRecordAttribute.getProcessingFlags());
  }
}
