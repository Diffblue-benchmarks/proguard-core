package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RecordComponentInfoDiffblueTest {
  /**
   * Test {@link RecordComponentInfo#RecordComponentInfo()}.
   *
   * <p>Method under test: {@link RecordComponentInfo#RecordComponentInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RecordComponentInfo.<init>()",
    "void RecordComponentInfo.<init>(int, int, int, Attribute[])"
  })
  public void testNewRecordComponentInfo() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo = new RecordComponentInfo();

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }

  /**
   * Test {@link RecordComponentInfo#RecordComponentInfo(int, int, int, Attribute[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link RecordComponentInfo#RecordComponentInfo(int, int, int,
   * Attribute[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RecordComponentInfo.<init>()",
    "void RecordComponentInfo.<init>(int, int, int, Attribute[])"
  })
  public void testNewRecordComponentInfo_whenOne() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo =
        new RecordComponentInfo(1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()});

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }
}
