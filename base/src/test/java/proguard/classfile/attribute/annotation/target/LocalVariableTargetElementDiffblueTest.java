package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalVariableTargetElementDiffblueTest {
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
  @DisplayName("Test new LocalVariableTargetElement(); then return u2index is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetElement.<init>()",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetElement.<init>(int, int, int)"
  })
  void testNewLocalVariableTargetElement_thenReturnU2indexIsZero() {
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
  @DisplayName(
      "Test new LocalVariableTargetElement(int, int, int); when one; then return u2index is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetElement.<init>()",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetElement.<init>(int, int, int)"
  })
  void testNewLocalVariableTargetElement_whenOne_thenReturnU2indexIsOne() {
    // Arrange and Act
    LocalVariableTargetElement actualLocalVariableTargetElement =
        new LocalVariableTargetElement(1, 3, 1);

    // Assert
    assertEquals(1, actualLocalVariableTargetElement.u2index);
    assertEquals(1, actualLocalVariableTargetElement.u2startPC);
    assertEquals(3, actualLocalVariableTargetElement.u2length);
  }
}
