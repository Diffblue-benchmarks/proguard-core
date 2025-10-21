package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeArgumentTargetInfoDiffblueTest {
  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo()}.
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeArgumentTargetInfo.<init>()",
    "void TypeArgumentTargetInfo.<init>(byte)",
    "void TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeArgumentTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeArgumentTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeArgumentTargetInfo.<init>()",
    "void TypeArgumentTargetInfo.<init>(byte)",
    "void TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeArgumentTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeArgumentTargetInfo.<init>()",
    "void TypeArgumentTargetInfo.<init>(byte)",
    "void TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeArgumentTargetInfo_whenTwo_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A', 2, 1)).getTargetType());
  }
}
