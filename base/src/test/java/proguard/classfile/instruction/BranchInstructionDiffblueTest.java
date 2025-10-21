package proguard.classfile.instruction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BranchInstructionDiffblueTest {
  /**
   * Test {@link BranchInstruction#BranchInstruction()}.
   *
   * <ul>
   *   <li>Then return Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#BranchInstruction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.<init>()", "void BranchInstruction.<init>(byte, int)"})
  public void testNewBranchInstruction_thenReturnNameIsNop() {
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
   * Test {@link BranchInstruction#BranchInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#BranchInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.<init>()", "void BranchInstruction.<init>(byte, int)"})
  public void testNewBranchInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    BranchInstruction actualBranchInstruction = new BranchInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualBranchInstruction.getName());
    assertEquals(1, actualBranchInstruction.branchOffset);
    assertFalse(actualBranchInstruction.isWide());
    assertTrue(actualBranchInstruction.isCategory2());
    assertEquals('A', actualBranchInstruction.opcode);
  }

  /**
   * Test {@link BranchInstruction#copy(BranchInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code
   *       A} and branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#copy(BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BranchInstruction BranchInstruction.copy(BranchInstruction)"})
  public void testCopy_thenReturnBranchInstructionWithOpcodeIsAAndBranchOffsetIsOne() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertSame(branchInstruction, branchInstruction.copy(new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link BranchInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', (new BranchInstruction((byte) 'A', 1)).canonicalOpcode());
  }

  /**
   * Test {@link BranchInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_GOTO}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_goto() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act and Assert
    assertEquals(Instruction.OP_GOTO, branchInstruction.canonicalOpcode());
  }

  /**
   * Test {@link BranchInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_JSR}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_jsr() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act and Assert
    assertEquals(Instruction.OP_JSR, branchInstruction.canonicalOpcode());
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink() {
    // Arrange
    BranchInstruction branchInstruction =
        new BranchInstruction(Instruction.OP_GOTO, Integer.MIN_VALUE);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("goto_w", branchInstruction.getName());
    assertEquals(Instruction.OP_GOTO_W, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink2() {
    // Arrange
    BranchInstruction branchInstruction =
        new BranchInstruction(Instruction.OP_GOTO_W, Integer.MIN_VALUE);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("goto_w", branchInstruction.getName());
    assertEquals(Instruction.OP_GOTO_W, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink3() {
    // Arrange
    BranchInstruction branchInstruction =
        new BranchInstruction(Instruction.OP_JSR, Integer.MIN_VALUE);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("jsr_w", branchInstruction.getName());
    assertEquals(Instruction.OP_JSR_W, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code A} and
   *       branchOffset is one Name is {@code goto}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink_thenBranchInstructionWithOpcodeIsAAndBranchOffsetIsOneNameIsGoto() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;
    branchInstruction.branchOffset = 0;

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof BranchInstruction);
    assertEquals("goto", branchInstruction.getName());
    assertEquals("goto", actualShrinkResult.getName());
    assertEquals(Instruction.OP_GOTO, branchInstruction.opcode);
    assertEquals(Instruction.OP_GOTO, ((BranchInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code A} and
   *       branchOffset is one Name is {@code jsr}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink_thenBranchInstructionWithOpcodeIsAAndBranchOffsetIsOneNameIsJsr() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;
    branchInstruction.branchOffset = 0;

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof BranchInstruction);
    assertEquals("jsr", branchInstruction.getName());
    assertEquals("jsr", actualShrinkResult.getName());
    assertEquals(Instruction.OP_JSR, branchInstruction.opcode);
    assertEquals(Instruction.OP_JSR, ((BranchInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink_thenReturnNameIsLstore2() {
    // Arrange and Act
    Instruction actualShrinkResult = (new BranchInstruction((byte) 'A', 1)).shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof BranchInstruction);
    assertEquals("lstore_2", actualShrinkResult.getName());
    assertEquals(1, ((BranchInstruction) actualShrinkResult).branchOffset);
    assertTrue(actualShrinkResult.isCategory2());
    assertEquals('A', ((BranchInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  public void testShrink_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new BranchInstruction((byte) 'A', Integer.MIN_VALUE)).shrink());
  }

  /**
   * Test {@link BranchInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  public void testReadInfo() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    branchInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(16728, branchInstruction.branchOffset);
  }

  /**
   * Test {@link BranchInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  public void testReadInfo2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act
    branchInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1096302936, branchInstruction.branchOffset);
  }

  /**
   * Test {@link BranchInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  public void testReadInfo3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act
    branchInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1096302936, branchInstruction.branchOffset);
  }

  /**
   * Test {@link BranchInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = 0;
    branchInstruction.opcode = Instruction.OP_GOTO_W;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link BranchInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = 0;
    branchInstruction.opcode = Instruction.OP_JSR_W;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link BranchInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    branchInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_NOP, Instruction.OP_ACONST_NULL, 'A', 'X', 'A', 'X'},
        code);
  }

  /**
   * Test {@link BranchInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> branchInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link BranchInstruction#length(int)}.
   *
   * <p>Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  public void testLength() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_GOTO_W;

    // Act and Assert
    assertEquals(5, branchInstruction.length(2));
  }

  /**
   * Test {@link BranchInstruction#length(int)}.
   *
   * <p>Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  public void testLength2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.opcode = Instruction.OP_JSR_W;

    // Act and Assert
    assertEquals(5, branchInstruction.length(2));
  }

  /**
   * Test {@link BranchInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  public void testLength_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new BranchInstruction((byte) 'A', 1)).length(2));
  }

  /**
   * Test {@link BranchInstruction#toString(int)} with {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 -1 (target=1)}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#toString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString(int)"})
  public void testToStringWithOffset_thenReturn2Lstore21Target1() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = -1;

    // Act and Assert
    assertEquals("[2] lstore_2 -1 (target=1)", branchInstruction.toString(2));
  }

  /**
   * Test {@link BranchInstruction#toString(int)} with {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 +1 (target=3)}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#toString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString(int)"})
  public void testToStringWithOffset_thenReturn2Lstore21Target3() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 +1 (target=3)", (new BranchInstruction((byte) 'A', 1)).toString(2));
  }

  /**
   * Test {@link BranchInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2 +1}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString()"})
  public void testToString_thenReturnLstore21() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 +1", (new BranchInstruction((byte) 'A', 1)).toString());
  }

  /**
   * Test {@link BranchInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2 -1}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString()"})
  public void testToString_thenReturnLstore212() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    branchInstruction.branchOffset = -1;

    // Act and Assert
    assertEquals("lstore_2 -1", branchInstruction.toString());
  }

  /**
   * Test {@link BranchInstruction#equals(Object)}, and {@link BranchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchInstruction#equals(Object)}
   *   <li>{@link BranchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
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
   * Test {@link BranchInstruction#equals(Object)}, and {@link BranchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchInstruction#equals(Object)}
   *   <li>{@link BranchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(branchInstruction, branchInstruction);
    int expectedHashCodeResult = branchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, branchInstruction.hashCode());
  }

  /**
   * Test {@link BranchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_ACONST_NULL, 1);

    // Act and Assert
    assertNotEquals(branchInstruction, new BranchInstruction((byte) 'A', 1));
  }

  /**
   * Test {@link BranchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(branchInstruction, new BranchInstruction((byte) 'A', 1));
  }

  /**
   * Test {@link BranchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInstruction((byte) 'A', 1), null);
  }

  /**
   * Test {@link BranchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInstruction((byte) 'A', 1), "Different type to BranchInstruction");
  }
}
