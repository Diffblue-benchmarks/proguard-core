package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableTargetInfoDiffblueTest {
  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo()}.
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTargetInfo.<init>()",
    "void LocalVariableTargetInfo.<init>(byte)",
    "void LocalVariableTargetInfo.<init>(byte, int, LocalVariableTargetElement[])"
  })
  public void testNewLocalVariableTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new LocalVariableTargetInfo()).getTargetType());
  }

  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTargetInfo.<init>()",
    "void LocalVariableTargetInfo.<init>(byte)",
    "void LocalVariableTargetInfo.<init>(byte, int, LocalVariableTargetElement[])"
  })
  public void testNewLocalVariableTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new LocalVariableTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte, int,
   * LocalVariableTargetElement[])}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte, int,
   * LocalVariableTargetElement[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTargetInfo.<init>()",
    "void LocalVariableTargetInfo.<init>(byte)",
    "void LocalVariableTargetInfo.<init>(byte, int, LocalVariableTargetElement[])"
  })
  public void testNewLocalVariableTargetInfo_whenThree_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals(
        'A',
        (new LocalVariableTargetInfo(
                (byte) 'A',
                3,
                new LocalVariableTargetElement[] {new LocalVariableTargetElement(1, 3, 1)}))
            .getTargetType());
  }
}
