package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmptyTargetInfoDiffblueTest {
  /**
   * Test {@link EmptyTargetInfo#EmptyTargetInfo()}.
   *
   * <ul>
   *   <li>Then return TargetType is {@link TargetInfo#TARGET_TYPE_PARAMETER_GENERIC_CLASS}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyTargetInfo#EmptyTargetInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EmptyTargetInfo.<init>()", "void EmptyTargetInfo.<init>(byte)"})
  public void testNewEmptyTargetInfo_thenReturnTargetTypeIsTarget_type_parameter_generic_class() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new EmptyTargetInfo()).getTargetType());
  }

  /**
   * Test {@link EmptyTargetInfo#EmptyTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyTargetInfo#EmptyTargetInfo(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EmptyTargetInfo.<init>()", "void EmptyTargetInfo.<init>(byte)"})
  public void testNewEmptyTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new EmptyTargetInfo((byte) 'A')).getTargetType());
  }
}
