package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BranchInstructionDiffblueTest {
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
  @DisplayName("Test new BranchInstruction(); then return Name is 'nop'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.<init>()", "void BranchInstruction.<init>(byte, int)"})
  void testNewBranchInstruction_thenReturnNameIsNop() {
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
  @DisplayName("Test new BranchInstruction(byte, int); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.<init>()", "void BranchInstruction.<init>(byte, int)"})
  void testNewBranchInstruction_whenA_thenReturnNameIsLstore2() {
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
  @DisplayName(
      "Test copy(BranchInstruction); then return BranchInstruction(byte, int) with opcode is 'A' and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BranchInstruction BranchInstruction.copy(BranchInstruction)"})
  void testCopy_thenReturnBranchInstructionWithOpcodeIsAAndBranchOffsetIsOne() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    BranchInstruction actualCopyResult =
        branchInstruction.copy(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertSame(branchInstruction, actualCopyResult);
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
  @DisplayName("Test canonicalOpcode(); then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', new BranchInstruction((byte) 'A', 1).canonicalOpcode());
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
  @DisplayName("Test canonicalOpcode(); then return OP_GOTO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_goto() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_GOTO, new BranchInstruction(Instruction.OP_GOTO_W, 1).canonicalOpcode());
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
  @DisplayName("Test canonicalOpcode(); then return OP_JSR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte BranchInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_jsr() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_JSR, new BranchInstruction(Instruction.OP_JSR_W, 1).canonicalOpcode());
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, 0);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("goto", branchInstruction.getName());
    assertEquals(Instruction.OP_GOTO, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_JSR_W, 0);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertEquals("jsr", branchInstruction.getName());
    assertEquals(Instruction.OP_JSR, branchInstruction.opcode);
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink3() {
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
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink4() {
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
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink5() {
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
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_JSR_W, 0);
    branchInstruction.readInfo(
        new byte[] {
          'A',
          Instruction.OP_ACONST_NULL,
          'A',
          Instruction.OP_ACONST_NULL,
          'A',
          Instruction.OP_ACONST_NULL,
          'A',
          Instruction.OP_ACONST_NULL
        },
        2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> branchInstruction.shrink());
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code A} and
   *       branchOffset is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); given BranchInstruction(byte, int) with opcode is 'A' and branchOffset is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink_givenBranchInstructionWithOpcodeIsAAndBranchOffsetIsMin_value() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BranchInstruction((byte) 'A', Integer.MIN_VALUE).shrink());
  }

  /**
   * Test {@link BranchInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code
   *       A} and branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then return BranchInstruction(byte, int) with opcode is 'A' and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction BranchInstruction.shrink()"})
  void testShrink_thenReturnBranchInstructionWithOpcodeIsAAndBranchOffsetIsOne() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    Instruction actualShrinkResult = branchInstruction.shrink();

    // Assert
    assertSame(branchInstruction, actualShrinkResult);
  }

  /**
   * Test {@link BranchInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link BranchInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  void testReadInfo() throws UnsupportedEncodingException {
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
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  void testReadInfo2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, 1);

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
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.readInfo(byte[], int)"})
  void testReadInfo3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_JSR_W, 1);

    // Act
    branchInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1096302936, branchInstruction.branchOffset);
  }

  /**
   * Test {@link BranchInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_GOTO_W} and branchOffset is zero.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given BranchInstruction(byte, int) with opcode is OP_GOTO_W and branchOffset is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenBranchInstructionWithOpcodeIsOp_goto_wAndBranchOffsetIsZero() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    new BranchInstruction(Instruction.OP_GOTO_W, 0).writeInfo(code, 2);

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
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_JSR_W} and branchOffset is zero.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given BranchInstruction(byte, int) with opcode is OP_JSR_W and branchOffset is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenBranchInstructionWithOpcodeIsOp_jsr_wAndBranchOffsetIsZero() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    new BranchInstruction(Instruction.OP_JSR_W, 0).writeInfo(code, 2);

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
  @DisplayName(
      "Test writeInfo(byte[], int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new BranchInstruction((byte) 'A', 1).writeInfo(code, 2);

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
  @DisplayName("Test writeInfo(byte[], int); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BranchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenThrowIllegalArgumentException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new BranchInstruction((byte) 'A', Integer.MIN_VALUE)
                .writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link BranchInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_GOTO_W} and branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given BranchInstruction(byte, int) with opcode is OP_GOTO_W and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  void testLength_givenBranchInstructionWithOpcodeIsOp_goto_wAndBranchOffsetIsOne() {
    // Arrange, Act and Assert
    assertEquals(5, new BranchInstruction(Instruction.OP_GOTO_W, 1).length(2));
  }

  /**
   * Test {@link BranchInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_JSR_W} and branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link BranchInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given BranchInstruction(byte, int) with opcode is OP_JSR_W and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  void testLength_givenBranchInstructionWithOpcodeIsOp_jsr_wAndBranchOffsetIsOne() {
    // Arrange, Act and Assert
    assertEquals(5, new BranchInstruction(Instruction.OP_JSR_W, 1).length(2));
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
  @DisplayName("Test length(int); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BranchInstruction.length(int)"})
  void testLength_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, new BranchInstruction((byte) 'A', 1).length(2));
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
  @DisplayName("Test toString(int) with 'offset'; then return '[2] lstore_2 -1 (target=1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString(int)"})
  void testToStringWithOffset_thenReturn2Lstore21Target1() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 -1 (target=1)", new BranchInstruction((byte) 'A', -1).toString(2));
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
  @DisplayName("Test toString(int) with 'offset'; then return '[2] lstore_2 +1 (target=3)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString(int)"})
  void testToStringWithOffset_thenReturn2Lstore21Target3() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 +1 (target=3)", new BranchInstruction((byte) 'A', 1).toString(2));
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
  @DisplayName("Test toString(); then return 'lstore_2 +1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString()"})
  void testToString_thenReturnLstore21() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 +1", new BranchInstruction((byte) 'A', 1).toString());
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
  @DisplayName("Test toString(); then return 'lstore_2 -1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BranchInstruction.toString()"})
  void testToString_thenReturnLstore212() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 -1", new BranchInstruction((byte) 'A', -1).toString());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    BranchInstruction branchInstruction2 = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(branchInstruction, branchInstruction2);
    assertEquals(branchInstruction.hashCode(), branchInstruction2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BranchInstruction.equals(Object)",
    "int BranchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInstruction((byte) 'A', 1), "Different type to BranchInstruction");
  }
}
