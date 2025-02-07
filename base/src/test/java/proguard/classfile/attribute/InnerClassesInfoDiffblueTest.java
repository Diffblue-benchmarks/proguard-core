package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InnerClassesInfoDiffblueTest {
  /**
   * Test {@link InnerClassesInfo#InnerClassesInfo()}.
   *
   * <p>Method under test: {@link InnerClassesInfo#InnerClassesInfo()}
   */
  @Test
  @DisplayName("Test new InnerClassesInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.InnerClassesInfo.<init>()",
    "void proguard.classfile.attribute.InnerClassesInfo.<init>(int, int, int, int)"
  })
  void testNewInnerClassesInfo() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo();

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }

  /**
   * Test {@link InnerClassesInfo#InnerClassesInfo(int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesInfo#InnerClassesInfo(int, int, int, int)}
   */
  @Test
  @DisplayName("Test new InnerClassesInfo(int, int, int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.InnerClassesInfo.<init>()",
    "void proguard.classfile.attribute.InnerClassesInfo.<init>(int, int, int, int)"
  })
  void testNewInnerClassesInfo_whenOne() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }
}
