package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThrowsTargetInfoDiffblueTest {
  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo()}.
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ThrowsTargetInfo.<init>()",
    "void ThrowsTargetInfo.<init>(byte)",
    "void ThrowsTargetInfo.<init>(byte, int)"
  })
  public void testNewThrowsTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new ThrowsTargetInfo()).getTargetType());
  }

  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ThrowsTargetInfo.<init>()",
    "void ThrowsTargetInfo.<init>(byte)",
    "void ThrowsTargetInfo.<init>(byte, int)"
  })
  public void testNewThrowsTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ThrowsTargetInfo.<init>()",
    "void ThrowsTargetInfo.<init>(byte)",
    "void ThrowsTargetInfo.<init>(byte, int)"
  })
  public void testNewThrowsTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
