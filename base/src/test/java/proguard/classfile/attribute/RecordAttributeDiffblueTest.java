package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RecordAttributeDiffblueTest {
  /**
   * Test {@link RecordAttribute#RecordAttribute()}.
   *
   * <p>Method under test: {@link RecordAttribute#RecordAttribute()}
   */
  @Test
  @DisplayName("Test new RecordAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.RecordAttribute.<init>()",
    "void proguard.classfile.attribute.RecordAttribute.<init>(int, int, proguard.classfile.attribute.RecordComponentInfo[])"
  })
  void testNewRecordAttribute() {
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
  @DisplayName("Test new RecordAttribute(int, int, RecordComponentInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.RecordAttribute.<init>()",
    "void proguard.classfile.attribute.RecordAttribute.<init>(int, int, proguard.classfile.attribute.RecordComponentInfo[])"
  })
  void testNewRecordAttribute_whenOne() {
    // Arrange and Act
    RecordAttribute actualRecordAttribute =
        new RecordAttribute(1, 3, new RecordComponentInfo[] {new RecordComponentInfo()});

    // Assert
    assertNull(actualRecordAttribute.getProcessingInfo());
    assertEquals(0, actualRecordAttribute.getProcessingFlags());
  }
}
