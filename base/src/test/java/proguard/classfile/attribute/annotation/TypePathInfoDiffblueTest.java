package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypePathInfoDiffblueTest {
  /**
   * Test {@link TypePathInfo#TypePathInfo()}.
   *
   * <ul>
   *   <li>Then return {@link TypePathInfo#u1typeArgumentIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link TypePathInfo#TypePathInfo()}
   */
  @Test
  @DisplayName("Test new TypePathInfo(); then return u1typeArgumentIndex is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypePathInfo.<init>()", "void TypePathInfo.<init>(int, int)"})
  void testNewTypePathInfo_thenReturnU1typeArgumentIndexIsZero() {
    // Arrange and Act
    TypePathInfo actualTypePathInfo = new TypePathInfo();

    // Assert
    assertEquals(0, actualTypePathInfo.u1typeArgumentIndex);
    assertEquals(0, actualTypePathInfo.u1typePathKind);
  }

  /**
   * Test {@link TypePathInfo#TypePathInfo(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link TypePathInfo#u1typeArgumentIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link TypePathInfo#TypePathInfo(int, int)}
   */
  @Test
  @DisplayName("Test new TypePathInfo(int, int); when one; then return u1typeArgumentIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypePathInfo.<init>()", "void TypePathInfo.<init>(int, int)"})
  void testNewTypePathInfo_whenOne_thenReturnU1typeArgumentIndexIsOne() {
    // Arrange and Act
    TypePathInfo actualTypePathInfo = new TypePathInfo(1, 1);

    // Assert
    assertEquals(1, actualTypePathInfo.u1typeArgumentIndex);
    assertEquals(1, actualTypePathInfo.u1typePathKind);
  }
}
