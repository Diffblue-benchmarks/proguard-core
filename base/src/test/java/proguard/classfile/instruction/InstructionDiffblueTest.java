package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;

class InstructionDiffblueTest {
  /**
   * Test {@link Instruction#canonicalOpcode()}.
   *
   * <p>Method under test: {@link Instruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Instruction.canonicalOpcode()"})
  void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals(Instruction.OP_NOP, new LookUpSwitchInstruction().canonicalOpcode());
  }

  /**
   * Test {@link Instruction#actualOpcode()}.
   *
   * <p>Method under test: {@link Instruction#actualOpcode()}
   */
  @Test
  @DisplayName("Test actualOpcode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Instruction.actualOpcode()"})
  void testActualOpcode() {
    // Arrange, Act and Assert
    assertEquals('A', new BranchInstruction((byte) 'A', 1).actualOpcode());
  }

  /**
   * Test {@link Instruction#write(CodeAttribute, int)} with {@code codeAttribute}, {@code offset}.
   *
   * <p>Method under test: {@link Instruction#write(CodeAttribute, int)}
   */
  @Test
  @DisplayName("Test write(CodeAttribute, int) with 'codeAttribute', 'offset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(CodeAttribute, int)"})
  void testWriteWithCodeAttributeOffset() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    CodeAttribute codeAttribute =
        new CodeAttribute(
            1,
            3,
            3,
            3,
            new byte[] {
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1
            });

    // Act
    branchInstruction.write(codeAttribute, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          Instruction.OP_ICONST_M1,
          'A',
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          Instruction.OP_ICONST_M1,
          'A',
          Instruction.OP_ICONST_M1
        },
        codeAttribute.code);
  }

  /**
   * Test {@link Instruction#write(CodeAttribute, int)} with {@code codeAttribute}, {@code offset}.
   *
   * <p>Method under test: {@link Instruction#write(CodeAttribute, int)}
   */
  @Test
  @DisplayName("Test write(CodeAttribute, int) with 'codeAttribute', 'offset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(CodeAttribute, int)"})
  void testWriteWithCodeAttributeOffset2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, 1);
    CodeAttribute codeAttribute =
        new CodeAttribute(
            1,
            3,
            3,
            3,
            new byte[] {
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1,
              'A',
              Instruction.OP_ICONST_M1
            });

    // Act
    branchInstruction.write(codeAttribute, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          Instruction.OP_ICONST_M1,
          Instruction.OP_GOTO_W,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          Instruction.OP_ICONST_M1
        },
        codeAttribute.code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName("Test write(byte[], int) with 'code', 'offset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ICONST_0);
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.write(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_ICONST_0, Instruction.OP_NOP, 'A', 'X', 'A', 'X'},
        code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName("Test write(byte[], int) with 'code', 'offset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ICONST_0);
    variableInstruction.wide = true;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.write(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_WIDE,
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#wide} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int) with 'code', 'offset'; given VariableInstruction(byte) with opcode is 'A' wide is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset_givenVariableInstructionWithOpcodeIsAWideIsTrue() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = true;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.write(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_WIDE, 'A', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC} {@link VariableInstruction#wide} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int) with 'code', 'offset'; given VariableInstruction(byte) with opcode is OP_IINC wide is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset_givenVariableInstructionWithOpcodeIsOp_iincWideIsFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.write(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', Instruction.OP_IINC, Instruction.OP_NOP, Instruction.OP_NOP, 'X', 'A', 'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int) with 'code', 'offset'; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.write(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int) with 'code', 'offset'; then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new BranchInstruction((byte) 'A', 1).write(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', Instruction.OP_NOP, Instruction.OP_ACONST_NULL, 'X', 'A', 'X'},
        code);
  }

  /**
   * Test {@link Instruction#write(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int) with 'code', 'offset'; then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.write(byte[], int)"})
  void testWriteWithCodeOffset_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX2()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new BranchInstruction(Instruction.OP_GOTO_W, 1).write(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_GOTO_W,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#isWide()}.
   *
   * <p>Method under test: {@link Instruction#isWide()}
   */
  @Test
  @DisplayName("Test isWide()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Instruction.isWide()"})
  void testIsWide() {
    // Arrange, Act and Assert
    assertFalse(new BranchInstruction((byte) 'A', 1).isWide());
  }

  /**
   * Test {@link Instruction#toString(Clazz, int)} with {@code clazz}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 +1 (target=3)}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#toString(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test toString(Clazz, int) with 'clazz', 'offset'; then return '[2] lstore_2 +1 (target=3)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Instruction.toString(Clazz, int)"})
  void testToStringWithClazzOffset_thenReturn2Lstore21Target3() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals("[2] lstore_2 +1 (target=3)", branchInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Test {@link Instruction#toString(int)} with {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 #1}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#toString(int)}
   */
  @Test
  @DisplayName("Test toString(int) with 'offset'; then return '[2] lstore_2 #1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Instruction.toString(int)"})
  void testToStringWithOffset_thenReturn2Lstore21() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 #1", new ConstantInstruction((byte) 'A', 1).toString(2));
  }

  /**
   * Test {@link Instruction#getName()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Instruction.getName()"})
  void testGetName_thenReturnLstore2() {
    // Arrange, Act and Assert
    assertEquals("lstore_2", new BranchInstruction((byte) 'A', 1).getName());
  }

  /**
   * Test {@link Instruction#mayThrowExceptions()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#mayThrowExceptions()}
   */
  @Test
  @DisplayName("Test mayThrowExceptions(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Instruction.mayThrowExceptions()"})
  void testMayThrowExceptions_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BranchInstruction((byte) 'A', 1).mayThrowExceptions());
  }

  /**
   * Test {@link Instruction#mayInstanceThrowExceptions(Clazz)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  @DisplayName("Test mayInstanceThrowExceptions(Clazz); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Instruction.mayInstanceThrowExceptions(Clazz)"})
  void testMayInstanceThrowExceptions_thenReturnFalse() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertFalse(branchInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Test {@link Instruction#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Instruction.isCategory2()"})
  void testIsCategory2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BranchInstruction(Instruction.ARRAY_T_DOUBLE, 1).isCategory2());
  }

  /**
   * Test {@link Instruction#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Instruction.isCategory2()"})
  void testIsCategory2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BranchInstruction((byte) 'A', 1).isCategory2());
  }

  /**
   * Test {@link Instruction#stackPopCount(Clazz)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#stackPopCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPopCount(Clazz); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.stackPopCount(Clazz)"})
  void testStackPopCount_thenReturnTwo() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(2, branchInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Test {@link Instruction#stackPushCount(Clazz)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#stackPushCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPushCount(Clazz); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.stackPushCount(Clazz)"})
  void testStackPushCount_thenReturnZero() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(0, branchInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Test {@link Instruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link Instruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName("Test stackEntryIndexBefore(Clazz, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(-1, branchInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link Instruction#readByte(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readByte(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readByte(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readByte(byte[], int)"})
  void testReadByte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, Instruction.readByte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link Instruction#readShort(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readShort(byte[], int)}
   */
  @Test
  @DisplayName("Test readShort(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readShort(byte[], int)"})
  void testReadShort_whenAxaxaxaxBytesIsUtf8_thenReturn16728() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, Instruction.readShort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link Instruction#readInt(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInt(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readInt(byte[], int)"})
  void testReadInt_whenAxaxaxaxBytesIsUtf8_thenReturn1096302936()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, Instruction.readInt("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link Instruction#readValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test readValue(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readValue(byte[], int, int)"})
  void testReadValue_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.readValue("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link Instruction#readValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readValue(byte[], int, int); when four; then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readValue(byte[], int, int)"})
  void testReadValue_whenFour_thenReturn1096302936() {
    // Arrange, Act and Assert
    assertEquals(
        1096302936,
        Instruction.readValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4));
  }

  /**
   * Test {@link Instruction#readValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readValue(byte[], int, int); when one; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readValue(byte[], int, int)"})
  void testReadValue_whenOne_thenReturnSixtyFive() {
    // Arrange, Act and Assert
    assertEquals(
        65, Instruction.readValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Test {@link Instruction#readValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readValue(byte[], int, int); when two; then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readValue(byte[], int, int)"})
  void testReadValue_whenTwo_thenReturn16728() {
    // Arrange, Act and Assert
    assertEquals(
        16728, Instruction.readValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 2));
  }

  /**
   * Test {@link Instruction#readValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readValue(byte[], int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readValue(byte[], int, int)"})
  void testReadValue_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, Instruction.readValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0));
  }

  /**
   * Test {@link Instruction#readSignedByte(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedByte(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readSignedByte(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedByte(byte[], int)"})
  void testReadSignedByte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, Instruction.readSignedByte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link Instruction#readSignedShort(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedShort(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readSignedShort(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedShort(byte[], int)"})
  void testReadSignedShort_whenAxaxaxaxBytesIsUtf8_thenReturn16728()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, Instruction.readSignedShort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link Instruction#readSignedValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test readSignedValue(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedValue(byte[], int, int)"})
  void testReadSignedValue_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.readSignedValue("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link Instruction#readSignedValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readSignedValue(byte[], int, int); when four; then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedValue(byte[], int, int)"})
  void testReadSignedValue_whenFour_thenReturn1096302936() {
    // Arrange, Act and Assert
    assertEquals(
        1096302936,
        Instruction.readSignedValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4));
  }

  /**
   * Test {@link Instruction#readSignedValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readSignedValue(byte[], int, int); when one; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedValue(byte[], int, int)"})
  void testReadSignedValue_whenOne_thenReturnSixtyFive() {
    // Arrange, Act and Assert
    assertEquals(
        65, Instruction.readSignedValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Test {@link Instruction#readSignedValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readSignedValue(byte[], int, int); when two; then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedValue(byte[], int, int)"})
  void testReadSignedValue_whenTwo_thenReturn16728() {
    // Arrange, Act and Assert
    assertEquals(
        16728,
        Instruction.readSignedValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 2));
  }

  /**
   * Test {@link Instruction#readSignedValue(byte[], int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  @DisplayName("Test readSignedValue(byte[], int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Instruction.readSignedValue(byte[], int, int)"})
  void testReadSignedValue_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, Instruction.readSignedValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0));
  }

  /**
   * Test {@link Instruction#writeByte(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AX*XAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeByte(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeByte(byte[], int, int); then 'AXAXAXAX' Bytes is 'UTF-8' is 'AX*XAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeByte(byte[], int, int)"})
  void testWriteByte_thenAxaxaxaxBytesIsUtf8IsAxXaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeByte(code, 2, 42);

    // Assert
    assertArrayEquals("AX*XAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link Instruction#writeByte(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeByte(byte[], int, int)}
   */
  @Test
  @DisplayName("Test writeByte(byte[], int, int); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeByte(byte[], int, int)"})
  void testWriteByte_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.writeByte(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 256));
  }

  /**
   * Test {@link Instruction#writeShort(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeShort(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeShort(byte[], int, int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeShort(byte[], int, int)"})
  void testWriteShort_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeShort(code, 2, 42);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, '*', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#writeShort(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeShort(byte[], int, int)}
   */
  @Test
  @DisplayName("Test writeShort(byte[], int, int); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeShort(byte[], int, int)"})
  void testWriteShort_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Instruction.writeShort(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 65536));
  }

  /**
   * Test {@link Instruction#writeInt(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeInt(byte[], int, int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeInt(byte[], int, int)"})
  void testWriteInt_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeInt(code, 2, 42);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, Instruction.OP_NOP, '*', 'A', 'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When {@code 65536}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when '65536'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_when65536_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Instruction.writeValue(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 65536, 2));
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.writeValue("AXAXAXAX".getBytes("UTF-8"), 2, 42, 3));
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when four; then array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenFour_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 255, 4);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, Instruction.OP_NOP, -1, 'A', 'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when one; then array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenOne_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 255, 1);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When two hundred fifty-five.
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when two hundred fifty-five; then array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenTwoHundredFiftyFive_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 255, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, -1, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When two hundred fifty-six.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when two hundred fifty-six; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenTwoHundredFiftySix_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Instruction.writeValue(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 256, 1));
  }

  /**
   * Test {@link Instruction#writeValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeValue(byte[], int, int, int); when zero; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeValue(byte[], int, int, int)"})
  void testWriteValue_whenZero_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 255, 0);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link Instruction#writeSignedByte(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AX*XAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedByte(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedByte(byte[], int, int); then 'AXAXAXAX' Bytes is 'UTF-8' is 'AX*XAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedByte(byte[], int, int)"})
  void testWriteSignedByte_thenAxaxaxaxBytesIsUtf8IsAxXaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeSignedByte(code, 2, 42);

    // Assert
    assertArrayEquals("AX*XAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link Instruction#writeSignedByte(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedByte(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedByte(byte[], int, int); when '19088743'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedByte(byte[], int, int)"})
  void testWriteSignedByte_when19088743_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.writeSignedByte("AXAXAXAX".getBytes("UTF-8"), 2, 19088743));
  }

  /**
   * Test {@link Instruction#writeSignedShort(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedShort(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedShort(byte[], int, int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedShort(byte[], int, int)"})
  void testWriteSignedShort_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeSignedShort(code, 2, 42);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, '*', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#writeSignedShort(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedShort(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedShort(byte[], int, int); when '19088743'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedShort(byte[], int, int)"})
  void testWriteSignedShort_when19088743_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.writeSignedShort("AXAXAXAX".getBytes("UTF-8"), 2, 19088743));
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when '19088743'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_when19088743_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Instruction.writeSignedValue(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 19088743, 2));
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Instruction.writeSignedValue("AXAXAXAX".getBytes("UTF-8"), 2, 42, 3));
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when four; then array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenFour_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 4);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, Instruction.OP_NOP, '*', 'A', 'X'
        },
        code);
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AX*XAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when one; then array of byte with 'A' and 'X' is 'AX*XAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenOne_thenArrayOfByteWithAAndXIsAxXaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 1);

    // Assert
    assertArrayEquals("AX*XAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Instruction.writeSignedValue(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 19088743, 1));
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when two; then array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenTwo_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, '*', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link Instruction#writeSignedValue(byte[], int, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test writeSignedValue(byte[], int, int, int); when zero; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instruction.writeSignedValue(byte[], int, int, int)"})
  void testWriteSignedValue_whenZero_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 0);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }
}
