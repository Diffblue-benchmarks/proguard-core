package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SuperTypeTargetInfoDiffblueTest {
  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo()}.
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  public void testNewSuperTypeTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new SuperTypeTargetInfo()).getTargetType());
  }

  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  public void testNewSuperTypeTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new SuperTypeTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  public void testNewSuperTypeTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new SuperTypeTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
