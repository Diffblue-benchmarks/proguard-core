package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SwitchInstructionDiffblueTest {
  /**
   * Test {@link SwitchInstruction#copy(SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   *   <li>Then return {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#copy(SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SwitchInstruction SwitchInstruction.copy(SwitchInstruction)"})
  public void testCopy_whenLookUpSwitchInstruction_thenReturnLookUpSwitchInstruction() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(
        lookUpSwitchInstruction,
        lookUpSwitchInstruction.copy((SwitchInstruction) new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link SwitchInstruction#toString(int)} with {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 (4 offsets, default=255) (target=257)}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#toString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SwitchInstruction.toString(int)"})
  public void testToStringWithOffset_thenReturn2Lstore24OffsetsDefault255Target257() {
    // Arrange, Act and Assert
    assertEquals(
        "[2] lstore_2 (4 offsets, default=255) (target=257)",
        (new LookUpSwitchInstruction(
                (byte) 'A', 255, new int[] {255, 1, 255, 1}, new int[] {255, 1, 255, 1}))
            .toString(2));
  }

  /**
   * Test {@link SwitchInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2 (4 offsets, default=255)}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SwitchInstruction.toString()"})
  public void testToString_thenReturnLstore24OffsetsDefault255() {
    // Arrange, Act and Assert
    assertEquals(
        "lstore_2 (4 offsets, default=255)",
        (new LookUpSwitchInstruction(
                (byte) 'A', 255, new int[] {255, 1, 255, 1}, new int[] {255, 1, 255, 1}))
            .toString());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}, and {@link SwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();
    LookUpSwitchInstruction lookUpSwitchInstruction2 = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction2);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction2.hashCode());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}, and {@link SwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction.hashCode());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction(
            Instruction.OP_NOP, 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction(
            Instruction.OP_NOP, 0, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), null);
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), "Different type to SwitchInstruction");
  }
}
