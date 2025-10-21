package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableTargetElementDiffblueTest {
  /**
   * Test {@link LocalVariableTargetElement#LocalVariableTargetElement()}.
   *
   * <ul>
   *   <li>Then return {@link LocalVariableTargetElement#u2index} is zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetElement#LocalVariableTargetElement()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTargetElement.<init>()",
    "void LocalVariableTargetElement.<init>(int, int, int)"
  })
  public void testNewLocalVariableTargetElement_thenReturnU2indexIsZero() {
    // Arrange and Act
    LocalVariableTargetElement actualLocalVariableTargetElement = new LocalVariableTargetElement();

    // Assert
    assertEquals(0, actualLocalVariableTargetElement.u2index);
    assertEquals(0, actualLocalVariableTargetElement.u2length);
    assertEquals(0, actualLocalVariableTargetElement.u2startPC);
  }

  /**
   * Test {@link LocalVariableTargetElement#LocalVariableTargetElement(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link LocalVariableTargetElement#u2index} is one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetElement#LocalVariableTargetElement(int, int,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTargetElement.<init>()",
    "void LocalVariableTargetElement.<init>(int, int, int)"
  })
  public void testNewLocalVariableTargetElement_whenOne_thenReturnU2indexIsOne() {
    // Arrange and Act
    LocalVariableTargetElement actualLocalVariableTargetElement =
        new LocalVariableTargetElement(1, 3, 1);

    // Assert
    assertEquals(1, actualLocalVariableTargetElement.u2index);
    assertEquals(1, actualLocalVariableTargetElement.u2startPC);
    assertEquals(3, actualLocalVariableTargetElement.u2length);
  }
}
