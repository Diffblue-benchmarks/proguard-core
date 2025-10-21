package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypePathInfoDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypePathInfo.<init>()", "void TypePathInfo.<init>(int, int)"})
  public void testNewTypePathInfo_thenReturnU1typeArgumentIndexIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypePathInfo.<init>()", "void TypePathInfo.<init>(int, int)"})
  public void testNewTypePathInfo_whenOne_thenReturnU1typeArgumentIndexIsOne() {
    // Arrange and Act
    TypePathInfo actualTypePathInfo = new TypePathInfo(1, 1);

    // Assert
    assertEquals(1, actualTypePathInfo.u1typeArgumentIndex);
    assertEquals(1, actualTypePathInfo.u1typePathKind);
  }
}
