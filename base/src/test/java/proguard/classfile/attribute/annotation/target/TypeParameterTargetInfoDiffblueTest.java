package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeParameterTargetInfoDiffblueTest {
  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo()}.
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterTargetInfo.<init>()",
    "void TypeParameterTargetInfo.<init>(byte)",
    "void TypeParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewTypeParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeParameterTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterTargetInfo.<init>()",
    "void TypeParameterTargetInfo.<init>(byte)",
    "void TypeParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewTypeParameterTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeParameterTargetInfo.<init>()",
    "void TypeParameterTargetInfo.<init>(byte)",
    "void TypeParameterTargetInfo.<init>(byte, int)"
  })
  public void testNewTypeParameterTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
