package proguard.classfile.instruction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VariableInstructionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return not Wide.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#VariableInstruction()}
   *   <li>{@link VariableInstruction#isWide()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableInstruction.<init>()",
    "void VariableInstruction.<init>(boolean)",
    "boolean VariableInstruction.isWide()"
  })
  public void testGettersAndSetters_thenReturnNotWide() {
    // Arrange, Act and Assert
    assertFalse((new VariableInstruction()).isWide());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Wide.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#VariableInstruction(boolean)}
   *   <li>{@link VariableInstruction#isWide()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableInstruction.<init>()",
    "void VariableInstruction.<init>(boolean)",
    "boolean VariableInstruction.isWide()"
  })
  public void testGettersAndSetters_whenTrue_thenReturnWide() {
    // Arrange, Act and Assert
    assertTrue((new VariableInstruction(true)).isWide());
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#variableIndex} is minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  public void testNewVariableInstruction_thenReturnVariableIndexIsMinusOneHundredTwentyFour() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#variableIndex} is minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  public void testNewVariableInstruction_thenReturnVariableIndexIsMinusOneHundredTwentyFour2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  public void testNewVariableInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(2, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link VariableInstruction#variableIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  public void testNewVariableInstruction_whenA_thenReturnVariableIndexIsOne() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@link VariableInstruction#constant} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  public void testNewVariableInstruction_whenMin_value_thenReturnConstantIsMin_value() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction =
        new VariableInstruction(Instruction.OP_IINC, 1, Integer.MIN_VALUE);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals(Integer.MIN_VALUE, actualVariableInstruction.constant);
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link VariableInstruction#variableIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  public void testNewVariableInstruction_whenOne_thenReturnVariableIndexIsOne() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  public void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertTrue(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  public void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  public void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc3() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction =
        new VariableInstruction(Instruction.OP_IINC, 1, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ILOAD_1}.
   *   <li>Then return Name is {@code iload_1}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  public void testNewVariableInstruction_whenOp_iload_1_thenReturnNameIsIload1() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_1);

    // Assert
    assertEquals("iload_1", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_ILOAD_1, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ILOAD_3}.
   *   <li>Then return Name is {@code iload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  public void testNewVariableInstruction_whenOp_iload_3_thenReturnNameIsIload3() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_3);

    // Assert
    assertEquals("iload_3", actualVariableInstruction.getName());
    assertEquals(3, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_ILOAD_3, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_LLOAD_0}.
   *   <li>Then return Name is {@code lload_0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  public void testNewVariableInstruction_whenOp_lload_0_thenReturnNameIsLload0() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_LLOAD_0);

    // Assert
    assertEquals("lload_0", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals(Instruction.OP_LLOAD_0, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When sixty-five.
   *   <li>Then return {@link VariableInstruction#variableIndex} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  public void testNewVariableInstruction_whenSixtyFive_thenReturnVariableIndexIsSixtyFive() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When sixty-five.
   *   <li>Then return {@link VariableInstruction#variableIndex} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  public void testNewVariableInstruction_whenSixtyFive_thenReturnVariableIndexIsSixtyFive2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#copy(VariableInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code
   *       A}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#copy(VariableInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VariableInstruction VariableInstruction.copy(VariableInstruction)"})
  public void testCopy_thenReturnVariableInstructionWithOpcodeIsA() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertSame(variableInstruction, variableInstruction.copy(new VariableInstruction((byte) 'A')));
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code 5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  public void testIsStore_givenVariableInstructionWithOpcodeIsAOpcodeIs5_thenReturnFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '5';

    // Act and Assert
    assertFalse(variableInstruction.isStore());
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_IINC}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  public void testIsStore_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_iinc_thenReturnTrue() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertTrue(variableInstruction.isStore());
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  public void testIsStore_givenVariableInstructionWithOpcodeIsA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new VariableInstruction((byte) 'A')).isStore());
  }

  /**
   * Test {@link VariableInstruction#isLoad()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code 5}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableInstruction.isLoad()"})
  public void testIsLoad_givenVariableInstructionWithOpcodeIsAOpcodeIs5_thenReturnTrue() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '5';

    // Act and Assert
    assertTrue(variableInstruction.isLoad());
  }

  /**
   * Test {@link VariableInstruction#isLoad()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableInstruction.isLoad()"})
  public void testIsLoad_givenVariableInstructionWithOpcodeIsA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new VariableInstruction((byte) 'A')).isLoad());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code C}.
   *   <li>Then return {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsAOpcodeIsC_thenReturn8() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'C';

    // Act and Assert
    assertEquals('8', variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code G}.
   *   <li>Then return {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsAOpcodeIsG_thenReturn9() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'G';

    // Act and Assert
    assertEquals('9', variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsA_thenReturn7() {
    // Arrange, Act and Assert
    assertEquals('7', (new VariableInstruction((byte) 'A')).canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturn6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) ';';

    // Act and Assert
    assertEquals('6', variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnColon() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'K';

    // Act and Assert
    assertEquals(':', variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnDot() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '.';

    // Act and Assert
    assertEquals('.', variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ALOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_aload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '*';

    // Act and Assert
    assertEquals(Instruction.OP_ALOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_DLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_dload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '&';

    // Act and Assert
    assertEquals(Instruction.OP_DLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_FLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_fload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '"';

    // Act and Assert
    assertEquals(Instruction.OP_FLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ILOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_iload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act and Assert
    assertEquals(Instruction.OP_ILOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_LLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_lload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_LLOAD_0;

    // Act and Assert
    assertEquals(Instruction.OP_LLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIs6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '6';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("istore_3", variableInstruction.getName());
    assertEquals("istore_3", actualShrinkResult.getName());
    assertEquals('>', variableInstruction.opcode);
    assertEquals('>', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIs8() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '8';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("fstore_3", variableInstruction.getName());
    assertEquals("fstore_3", actualShrinkResult.getName());
    assertEquals('F', variableInstruction.opcode);
    assertEquals('F', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code &}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsAmpersand() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '&';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("dload_3", variableInstruction.getName());
    assertEquals("dload_3", actualShrinkResult.getName());
    assertEquals(')', variableInstruction.opcode);
    assertEquals(')', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsAsterisk() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '*';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("aload_3", variableInstruction.getName());
    assertEquals("aload_3", actualShrinkResult.getName());
    assertEquals('-', variableInstruction.opcode);
    assertEquals('-', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsC() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) 'C';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("fstore_3", variableInstruction.getName());
    assertEquals("fstore_3", actualShrinkResult.getName());
    assertEquals('F', variableInstruction.opcode);
    assertEquals('F', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ALOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_aload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ALOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("aload_3", variableInstruction.getName());
    assertEquals("aload_3", actualShrinkResult.getName());
    assertEquals('-', variableInstruction.opcode);
    assertEquals('-', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_DLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_dload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_DLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("dload_3", variableInstruction.getName());
    assertEquals("dload_3", actualShrinkResult.getName());
    assertEquals(')', variableInstruction.opcode);
    assertEquals(')', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_FLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_fload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_FLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("fload_3", variableInstruction.getName());
    assertEquals("fload_3", actualShrinkResult.getName());
    assertEquals('%', variableInstruction.opcode);
    assertEquals('%', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ILOAD_0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_iload_0() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("iload_3", variableInstruction.getName());
    assertEquals("iload_3", actualShrinkResult.getName());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertEquals(Instruction.OP_ILOAD_3, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_LLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_lload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_LLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("lload_3", variableInstruction.getName());
    assertEquals("lload_3", actualShrinkResult.getName());
    assertEquals('!', variableInstruction.opcode);
    assertEquals('!', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_LLOAD_0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_lload_0() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_LLOAD_0;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("lload_3", variableInstruction.getName());
    assertEquals("lload_3", actualShrinkResult.getName());
    assertEquals('!', variableInstruction.opcode);
    assertEquals('!', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsQuotationMark() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '"';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("fload_3", variableInstruction.getName());
    assertEquals("fload_3", actualShrinkResult.getName());
    assertEquals('%', variableInstruction.opcode);
    assertEquals('%', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_givenVariableInstructionWithOpcodeIsAOpcodeIsSemicolon() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) ';';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("istore_3", variableInstruction.getName());
    assertEquals("istore_3", actualShrinkResult.getName());
    assertEquals('>', variableInstruction.opcode);
    assertEquals('>', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenReturnVariableInstructionWithOpcodeIsOp_iinc() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Act and Assert
    assertSame(variableInstruction, variableInstruction.shrink());
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code aload}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsAload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = -1;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("aload", variableInstruction.getName());
    assertEquals("aload", actualShrinkResult.getName());
    assertEquals(-1, ((VariableInstruction) actualShrinkResult).variableIndex);
    assertTrue(actualShrinkResult.isWide());
    assertTrue(variableInstruction.isWide());
    assertEquals(Instruction.OP_ALOAD, variableInstruction.opcode);
    assertEquals(Instruction.OP_ALOAD, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code astore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsAstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) ':';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("astore_3", variableInstruction.getName());
    assertEquals("astore_3", actualShrinkResult.getName());
    assertEquals('N', variableInstruction.opcode);
    assertEquals('N', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code dstore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsDstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '9';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("dstore_3", variableInstruction.getName());
    assertEquals("dstore_3", actualShrinkResult.getName());
    assertEquals('J', variableInstruction.opcode);
    assertEquals('J', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code iaload}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsIaload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '.';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("iaload", variableInstruction.getName());
    assertEquals("iaload", actualShrinkResult.getName());
    assertEquals('.', variableInstruction.opcode);
    assertEquals('.', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code iload}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsIload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 26;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("iload", variableInstruction.getName());
    assertEquals("iload", actualShrinkResult.getName());
    assertEquals(26, ((VariableInstruction) actualShrinkResult).variableIndex);
    assertEquals(Instruction.OP_ILOAD, variableInstruction.opcode);
    assertEquals(Instruction.OP_ILOAD, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code iload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsIload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("iload_3", variableInstruction.getName());
    assertEquals("iload_3", actualShrinkResult.getName());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertEquals(Instruction.OP_ILOAD_3, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  public void testShrink_thenVariableInstructionWithOpcodeIsANameIsLstore2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("lstore_2", variableInstruction.getName());
    assertEquals("lstore_2", actualShrinkResult.getName());
    assertEquals(2, ((VariableInstruction) actualShrinkResult).variableIndex);
    assertEquals('A', variableInstruction.opcode);
    assertEquals('A', ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsColon() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) ':';
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code O}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsO() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'O';
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ALOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_aload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ALOAD;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#constant} is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenVariableInstructionWithOpcodeIsAConstantIsEightyEight() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, variableInstruction.variableIndex);
    assertEquals(88, variableInstruction.constant);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#variableIndex} is two.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenVariableInstructionWithOpcodeIsAVariableIndexIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert that nothing has changed
    assertEquals(0, variableInstruction.constant);
    assertEquals(2, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#variableIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenVariableInstructionWithOpcodeIsAVariableIndexIsZero() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(0, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}
   *       {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenVariableInstructionWithWideIsTrueConstantIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(true);

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(16728, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code O}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsO() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'O';
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_ICONST_M1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ALOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_aload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ALOAD;
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_ICONST_M1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_IINC}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_iinc() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_ICONST_M1, Instruction.OP_NOP, 'A', 'X', 'A', 'X'},
        code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenVariableInstructionWithOpcodeIsA_thenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(true);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@code O}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsAOpcodeIsO_thenReturnTwo() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = (byte) 'O';

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ALOAD}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_aload_thenReturnTwo() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_ALOAD;

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_IINC}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_iinc_thenReturnThree() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals(3, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link Instruction#opcode} is {@link Instruction#OP_ILOAD_0}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsAOpcodeIsOp_iload_0_thenReturnOne() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act and Assert
    assertEquals(1, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#wide} is {@code true}.
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsAWideIsTrue_thenReturnSix() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = true;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals(6, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithOpcodeIsA_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableInstruction((byte) 'A')).length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  public void testLength_givenVariableInstructionWithWideIsTrue_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, (new VariableInstruction(true)).length(2));
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#wide} is {@code false}.
   *   <li>Then return {@code iinc v2, 0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  public void testToString_givenVariableInstructionWithOpcodeIsAWideIsFalse_thenReturnIincV20() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals("iinc v2, 0", variableInstruction.toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#wide} is {@code true}.
   *   <li>Then return {@code iinc_w v2, 0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  public void testToString_givenVariableInstructionWithOpcodeIsAWideIsTrue_thenReturnIincWV20() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = true;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals("iinc_w v2, 0", variableInstruction.toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code lstore_2 v2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  public void testToString_givenVariableInstructionWithOpcodeIsA_thenReturnLstore2V2() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 v2", (new VariableInstruction((byte) 'A')).toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}.
   *   <li>Then return {@code nop_w v0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  public void testToString_givenVariableInstructionWithWideIsTrue_thenReturnNopWV0() {
    // Arrange, Act and Assert
    assertEquals("nop_w v0", (new VariableInstruction(true)).toString());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}, and {@link VariableInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    VariableInstruction variableInstruction2 = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertEquals(variableInstruction, variableInstruction2);
    int expectedHashCodeResult = variableInstruction.hashCode();
    assertEquals(expectedHashCodeResult, variableInstruction2.hashCode());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}, and {@link VariableInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertEquals(variableInstruction, variableInstruction);
    int expectedHashCodeResult = variableInstruction.hashCode();
    assertEquals(expectedHashCodeResult, variableInstruction.hashCode());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ICONST_M1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', 1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', -124);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), null);
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), "Different type to VariableInstruction");
  }
}
