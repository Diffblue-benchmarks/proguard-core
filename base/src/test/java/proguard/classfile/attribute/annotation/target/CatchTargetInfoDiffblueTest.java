package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CatchTargetInfoDiffblueTest {
  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo()}.
   *
   * <ul>
   *   <li>Then return TargetType is {@link TargetInfo#TARGET_TYPE_PARAMETER_GENERIC_CLASS}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CatchTargetInfo.<init>()",
    "void CatchTargetInfo.<init>(byte)",
    "void CatchTargetInfo.<init>(byte, int)"
  })
  public void testNewCatchTargetInfo_thenReturnTargetTypeIsTarget_type_parameter_generic_class() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new CatchTargetInfo()).getTargetType());
  }

  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CatchTargetInfo.<init>()",
    "void CatchTargetInfo.<init>(byte)",
    "void CatchTargetInfo.<init>(byte, int)"
  })
  public void testNewCatchTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CatchTargetInfo.<init>()",
    "void CatchTargetInfo.<init>(byte)",
    "void CatchTargetInfo.<init>(byte, int)"
  })
  public void testNewCatchTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
