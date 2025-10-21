package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OffsetTargetInfoDiffblueTest {
  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo()}.
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  public void testNewOffsetTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new OffsetTargetInfo()).getTargetType());
  }

  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  public void testNewOffsetTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new OffsetTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  public void testNewOffsetTargetInfo_whenTwo_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new OffsetTargetInfo((byte) 'A', 2)).getTargetType());
  }
}
