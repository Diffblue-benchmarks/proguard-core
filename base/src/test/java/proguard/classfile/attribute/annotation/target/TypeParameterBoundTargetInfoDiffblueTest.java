package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeParameterBoundTargetInfoDiffblueTest {
  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo()}.
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterBoundTargetInfo.<init>()",
    "void TypeParameterBoundTargetInfo.<init>(byte)",
    "void TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeParameterBoundTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeParameterBoundTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterBoundTargetInfo.<init>()",
    "void TypeParameterBoundTargetInfo.<init>(byte)",
    "void TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeParameterBoundTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte,
   * int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterBoundTargetInfo.<init>()",
    "void TypeParameterBoundTargetInfo.<init>(byte)",
    "void TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  public void testNewTypeParameterBoundTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A', 1, 1)).getTargetType());
  }
}
