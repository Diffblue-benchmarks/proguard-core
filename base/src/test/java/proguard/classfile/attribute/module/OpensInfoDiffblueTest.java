package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpensInfoDiffblueTest {
  /**
   * Test {@link OpensInfo#OpensInfo()}.
   *
   * <p>Method under test: {@link OpensInfo#OpensInfo()}
   */
  @Test
  @DisplayName("Test new OpensInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.OpensInfo.<init>()",
    "void proguard.classfile.attribute.module.OpensInfo.<init>(int, int, int, int[])"
  })
  void testNewOpensInfo() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo();

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }

  /**
   * Test {@link OpensInfo#OpensInfo(int, int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link OpensInfo#OpensInfo(int, int, int, int[])}
   */
  @Test
  @DisplayName("Test new OpensInfo(int, int, int, int[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.OpensInfo.<init>()",
    "void proguard.classfile.attribute.module.OpensInfo.<init>(int, int, int, int[])"
  })
  void testNewOpensInfo_whenOne() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }
}
