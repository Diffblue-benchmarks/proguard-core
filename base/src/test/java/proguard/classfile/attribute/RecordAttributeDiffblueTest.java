package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RecordAttributeDiffblueTest {
  /**
   * Test {@link RecordAttribute#RecordAttribute()}.
   *
   * <p>Method under test: {@link RecordAttribute#RecordAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RecordAttribute.<init>()",
    "void RecordAttribute.<init>(int, int, RecordComponentInfo[])"
  })
  public void testNewRecordAttribute() {
    // Arrange and Act
    RecordAttribute actualRecordAttribute = new RecordAttribute();

    // Assert
    assertNull(actualRecordAttribute.getProcessingInfo());
    assertEquals(0, actualRecordAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RecordAttribute#RecordAttribute(int, int, RecordComponentInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link RecordAttribute#RecordAttribute(int, int, RecordComponentInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RecordAttribute.<init>()",
    "void RecordAttribute.<init>(int, int, RecordComponentInfo[])"
  })
  public void testNewRecordAttribute_whenOne() {
    // Arrange and Act
    RecordAttribute actualRecordAttribute =
        new RecordAttribute(1, 3, new RecordComponentInfo[] {new RecordComponentInfo()});

    // Assert
    assertNull(actualRecordAttribute.getProcessingInfo());
    assertEquals(0, actualRecordAttribute.getProcessingFlags());
  }
}
