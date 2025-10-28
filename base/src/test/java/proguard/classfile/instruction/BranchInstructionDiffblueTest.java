package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class BranchInstructionDiffblueTest {
  /**
   * Method under test: {@link BranchInstruction#copy(BranchInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertSame(branchInstruction, branchInstruction.copy(new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals('A', (new BranchInstruction((byte) 'A', 1)).canonicalOpcode());
  }

  /**
   * Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act and Assert
    assertEquals(Instruction.OP_GOTO, branchInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act and Assert
    assertEquals(Instruction.OP_JSR, branchInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("lstore_2", branchInstruction.getName());
    assertEquals('A', branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;
    branchInstruction.branchOffset = 0;

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("goto", branchInstruction.getName());
    assertEquals(Instruction.OP_GOTO, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;
    branchInstruction.branchOffset = 0;

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("jsr", branchInstruction.getName());
    assertEquals(Instruction.OP_JSR, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new BranchInstruction((byte) 'A', Integer.MIN_VALUE)).shrink());
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink5() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO, Integer.MIN_VALUE);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("goto_w", branchInstruction.getName());
    assertEquals(Instruction.OP_GOTO_W, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink6() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, Integer.MIN_VALUE);

    // Act and Assert
    assertSame(branchInstruction, branchInstruction.shrink());
  }

  /**
   * Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  public void testShrink7() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_JSR, Integer.MIN_VALUE);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("jsr_w", branchInstruction.getName());
    assertEquals(Instruction.OP_JSR_W, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    branchInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(16728, branchInstruction.branchOffset);
  }

  /**
   * Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act
    branchInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1096302936, branchInstruction.branchOffset);
  }

  /**
   * Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act
    branchInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1096302936, branchInstruction.branchOffset);
  }

  /**
   * Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[3]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = 0;
    branchInstruction.opcode = Instruction.OP_GOTO_W;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
  }

  /**
   * Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = 0;
    branchInstruction.opcode = Instruction.OP_JSR_W;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
  }

  /**
   * Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo4() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> branchInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(3, (new BranchInstruction((byte) 'A', 1)).length(2));
  }

  /**
   * Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  public void testLength2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act and Assert
    assertEquals(5, branchInstruction.length(2));
  }

  /**
   * Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  public void testLength3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act and Assert
    assertEquals(5, branchInstruction.length(2));
  }

  /**
   * Method under test: {@link BranchInstruction#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 +1", (new BranchInstruction((byte) 'A', 1)).toString());
    assertEquals("[2] lstore_2 +1 (target=3)", (new BranchInstruction((byte) 'A', 1)).toString(2));
  }

  /**
   * Method under test: {@link BranchInstruction#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = -1;

    // Act and Assert
    assertEquals("lstore_2 -1", branchInstruction.toString());
  }

  /**
   * Method under test: {@link BranchInstruction#toString(int)}
   */
  @Test
  public void testToString3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = -1;

    // Act and Assert
    assertEquals("[2] lstore_2 -1 (target=1)", branchInstruction.toString(2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BranchInstruction#equals(Object)}
   *   <li>{@link BranchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    BranchInstruction branchInstruction2 = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(branchInstruction, branchInstruction2);
    int expectedHashCodeResult = branchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, branchInstruction2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BranchInstruction#equals(Object)}
   *   <li>{@link BranchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(branchInstruction, branchInstruction);
    int expectedHashCodeResult = branchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, branchInstruction.hashCode());
  }

  /**
   * Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_ACONST_NULL, 1);

    // Act and Assert
    assertNotEquals(branchInstruction, new BranchInstruction((byte) 'A', 1));
  }

  /**
   * Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(branchInstruction, new BranchInstruction((byte) 'A', 1));
  }

  /**
   * Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInstruction((byte) 'A', 1), null);
  }

  /**
   * Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInstruction((byte) 'A', 1), "Different type to BranchInstruction");
  }

  /**
   * Method under test: {@link BranchInstruction#BranchInstruction()}
   */
  @Test
  public void testNewBranchInstruction() {
    // Arrange and Act
    BranchInstruction actualBranchInstruction = new BranchInstruction();

    // Assert
    assertEquals("nop", actualBranchInstruction.getName());
    assertEquals(0, actualBranchInstruction.branchOffset);
    assertFalse(actualBranchInstruction.isCategory2());
    assertFalse(actualBranchInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualBranchInstruction.opcode);
  }

  /**
   * Method under test: {@link BranchInstruction#BranchInstruction(byte, int)}
   */
  @Test
  public void testNewBranchInstruction2() {
    // Arrange and Act
    BranchInstruction actualBranchInstruction = new BranchInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualBranchInstruction.getName());
    assertEquals(1, actualBranchInstruction.branchOffset);
    assertFalse(actualBranchInstruction.isWide());
    assertTrue(actualBranchInstruction.isCategory2());
    assertEquals('A', actualBranchInstruction.opcode);
  }
}
