package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FormalParameterTargetInfoDiffblueTest {
  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo()}.
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewFormalParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new FormalParameterTargetInfo()).getTargetType());
  }

  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewFormalParameterTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new FormalParameterTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewFormalParameterTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new FormalParameterTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
