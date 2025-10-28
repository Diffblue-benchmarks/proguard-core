package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RecordComponentInfoDiffblueTest {
  /**
   * Method under test: {@link RecordComponentInfo#RecordComponentInfo()}
   */
  @Test
  public void testNewRecordComponentInfo() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo = new RecordComponentInfo();

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RecordComponentInfo#RecordComponentInfo(int, int, int, Attribute[])}
   */
  @Test
  public void testNewRecordComponentInfo2() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo = new RecordComponentInfo(1, 1, 3,
        new Attribute[]{new BootstrapMethodsAttribute()});

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }
}
