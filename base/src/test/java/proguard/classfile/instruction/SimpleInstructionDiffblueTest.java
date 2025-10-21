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
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class SimpleInstructionDiffblueTest {
  /**
   * Test {@link SimpleInstruction#SimpleInstruction()}.
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>()"})
  public void testNewSimpleInstruction() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction();

    // Assert
    assertEquals("nop", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenA_thenReturnNameIsLstore22() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_BOOLEAN}.
   *   <li>Then return Name is {@code iconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenArray_t_boolean_thenReturnNameIsIconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);

    // Assert
    assertEquals("iconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_BOOLEAN, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_CHAR}.
   *   <li>Then return Name is {@code iconst_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenArray_t_char_thenReturnNameIsIconst2() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);

    // Assert
    assertEquals("iconst_2", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_CHAR, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_DOUBLE}.
   *   <li>Then return Name is {@code iconst_4}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenArray_t_double_thenReturnNameIsIconst4() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);

    // Assert
    assertEquals("iconst_4", actualSimpleInstruction.getName());
    assertEquals(4, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_DOUBLE, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_FLOAT}.
   *   <li>Then return Name is {@code iconst_3}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenArray_t_float_thenReturnNameIsIconst3() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);

    // Assert
    assertEquals("iconst_3", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_FLOAT, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_LONG}.
   *   <li>Then return Name is {@code fconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenArray_t_long_thenReturnNameIsFconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 1);

    // Assert
    assertEquals("fconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals('\f', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Name is {@code iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenBackspace_thenReturnNameIsIconst5() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\b');

    // Assert
    assertEquals("iconst_5", actualSimpleInstruction.getName());
    assertEquals(5, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals('\b', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenMinusOne_thenReturnConstantIsMinusOne() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus sixty-eight.
   *   <li>Then return {@link SimpleInstruction#constant} is minus sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenMinusSixtyEight_thenReturnConstantIsMinusSixtyEight() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction =
        new SimpleInstruction(Instruction.ARRAY_T_LONG, -68);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(-68, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenMinusTwo_thenReturnConstantIsMinusTwo() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -2);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_DCONST_0}.
   *   <li>Then return Name is {@code dconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenOp_dconst_0_thenReturnNameIsDconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 1);

    // Assert
    assertEquals("dconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ICONST_M1}.
   *   <li>Then return Name is {@code iconst_m1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  public void testNewSimpleInstruction_whenOp_iconst_m1_thenReturnNameIsIconstM1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@link SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenSix_thenReturnConstantIsSix() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, 6);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(6, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When tab.
   *   <li>Then return Name is {@code lconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenTab_thenReturnNameIsLconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 1);

    // Assert
    assertEquals("lconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\n', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link SimpleInstruction#constant} is three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenThree_thenReturnConstantIsThree() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 3);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Name is {@code dconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenTwo_thenReturnNameIsDconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 2);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Name is {@code lconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenTwo_thenReturnNameIsLconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 2);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Name is {@code dconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenZero_thenReturnNameIsDconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 0);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Name is {@code lconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  public void testNewSimpleInstruction_whenZero_thenReturnNameIsLconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 0);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#copy(SimpleInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#copy(SimpleInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleInstruction SimpleInstruction.copy(SimpleInstruction)"})
  public void testCopy_thenReturnSimpleInstructionWithOpcodeIsA() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertSame(simpleInstruction, simpleInstruction.copy(new SimpleInstruction((byte) 'A')));
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is tab.
   *   <li>Then return tab.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_givenSimpleInstructionWithOpcodeIsAOpcodeIsTab_thenReturnTab() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\t';

    // Act and Assert
    assertEquals('\t', simpleInstruction.canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_givenSimpleInstructionWithOpcodeIsA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', (new SimpleInstruction((byte) 'A')).canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#ARRAY_T_LONG}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnArray_t_long() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_LONG;

    // Act and Assert
    assertEquals(Instruction.ARRAY_T_LONG, simpleInstruction.canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_DCONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_dconst_0() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_DCONST_0;

    // Act and Assert
    assertEquals(Instruction.OP_DCONST_0, simpleInstruction.canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ICONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  public void testCanonicalOpcode_thenReturnOp_iconst_0() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act and Assert
    assertEquals(Instruction.OP_ICONST_0, simpleInstruction.canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_givenSimpleInstructionWithOpcodeIsA_thenReturnNameIsLstore2() {
    // Arrange and Act
    Instruction actualShrinkResult = (new SimpleInstruction((byte) 'A')).shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("lstore_2", actualShrinkResult.getName());
    assertEquals(0, ((SimpleInstruction) actualShrinkResult).constant);
    assertTrue(actualShrinkResult.isCategory2());
    assertEquals('A', ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenReturnConstantIsMin_value() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = Integer.MIN_VALUE;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertEquals("iconst_m1", actualShrinkResult.getName());
    assertEquals(Integer.MIN_VALUE, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertEquals(Instruction.OP_ICONST_M1, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenReturnConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = -2;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("bipush", simpleInstruction.getName());
    assertEquals("bipush", actualShrinkResult.getName());
    assertEquals(-2, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertEquals(Instruction.OP_BIPUSH, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenReturnConstantIsSix() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = 6;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("bipush", simpleInstruction.getName());
    assertEquals("bipush", actualShrinkResult.getName());
    assertEquals(6, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertEquals(Instruction.OP_BIPUSH, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code fconst_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenSimpleInstructionWithOpcodeIsANameIsFconst2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_DCONST_0;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("fconst_2", simpleInstruction.getName());
    assertEquals("fconst_2", actualShrinkResult.getName());
    assertEquals('\r', simpleInstruction.opcode);
    assertEquals('\r', ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenSimpleInstructionWithOpcodeIsANameIsIconst5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\t';
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("iconst_5", simpleInstruction.getName());
    assertEquals("iconst_5", actualShrinkResult.getName());
    assertEquals('\b', simpleInstruction.opcode);
    assertEquals('\b', ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code iconst_m1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenSimpleInstructionWithOpcodeIsANameIsIconstM1() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertEquals("iconst_m1", actualShrinkResult.getName());
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertEquals(Instruction.OP_ICONST_M1, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code lconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  public void testShrink_thenSimpleInstructionWithOpcodeIsANameIsLconst1() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_LONG;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("lconst_1", simpleInstruction.getName());
    assertEquals("lconst_1", actualShrinkResult.getName());
    assertTrue(simpleInstruction.isCategory2());
    assertEquals('\n', simpleInstruction.opcode);
    assertEquals('\n', ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_BIPUSH}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_bipush() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_NEWARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_newarray() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIs16728() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is five.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsFive() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\b';

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(5, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is four.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsFour() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_DOUBLE;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(4, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(-1, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsThree() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(3, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_CHAR;

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(2, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  public void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    simpleInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert that nothing has changed
    assertEquals(0, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', 255);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@code A} and
   *       constant is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAAndConstantIsMin_value()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@code A} and
   *       constant is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAAndConstantIsSize()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', Short.SIZE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAConstantIsMin_value() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = Integer.MIN_VALUE;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = -2;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -2, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAConstantIsSix() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = 6;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.ARRAY_T_FLOAT, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#ARRAY_T_BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsArray_t_boolean() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#ARRAY_T_FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsArray_t_float() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;
    simpleInstruction.constant = 6;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_NEWARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_newarray() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_SIPUSH}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_sipush() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, -1, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsA_thenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@link
   *       Instruction#ARRAY_T_CHAR} and constant is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsArray_t_charAndConstantIsSize()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction =
        new SimpleInstruction(Instruction.ARRAY_T_CHAR, Short.SIZE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_ICONST_M1} and constant is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_iconst_m1AndConstantIsSize()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction =
        new SimpleInstruction(Instruction.OP_ICONST_M1, Short.SIZE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_BIPUSH}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  public void testLength_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_bipush_thenReturnTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act and Assert
    assertEquals(2, simpleInstruction.length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_NEWARRAY}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  public void testLength_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_newarray_thenReturnTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act and Assert
    assertEquals(2, simpleInstruction.length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@link Instruction#OP_SIPUSH}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  public void testLength_givenSimpleInstructionWithOpcodeIsAOpcodeIsOp_sipush_thenReturnThree() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act and Assert
    assertEquals(3, simpleInstruction.length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  public void testLength_givenSimpleInstructionWithOpcodeIsA_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new SimpleInstruction((byte) 'A')).length(2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '[';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '[';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) ']';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) ']';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '^';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsAOpcodeIsBackslash() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\\';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsAOpcodeIsUnderscore() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '_';

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsAOpcodeIsY() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Y';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       Instruction#opcode} is {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsAOpcodeIsZ() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Z';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsA_thenReturnMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_thenReturnOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Z';

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_thenReturnOne2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\\';

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  public void testStackEntryIndexBefore_whenFour() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '^';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 4));
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_givenSimpleInstructionWithOpcodeIsA_thenReturnLstore2() {
    // Arrange, Act and Assert
    assertEquals("lstore_2", (new SimpleInstruction((byte) 'A')).toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code bipush 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnBipush5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act and Assert
    assertEquals("bipush 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconst5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = (byte) '\b';

    // Act and Assert
    assertEquals("iconst_5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_1 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconst15() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;

    // Act and Assert
    assertEquals("iconst_1 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_2 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconst25() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_CHAR;

    // Act and Assert
    assertEquals("iconst_2 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_3 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconst35() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;

    // Act and Assert
    assertEquals("iconst_3 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_4 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconst45() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_DOUBLE;

    // Act and Assert
    assertEquals("iconst_4 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_m1 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnIconstM15() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act and Assert
    assertEquals("iconst_m1 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code newarray 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnNewarray5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act and Assert
    assertEquals("newarray 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code sipush 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  public void testToString_thenReturnSipush5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act and Assert
    assertEquals("sipush 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}, and {@link SimpleInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    SimpleInstruction simpleInstruction2 = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(simpleInstruction, simpleInstruction2);
    int expectedHashCodeResult = simpleInstruction.hashCode();
    assertEquals(expectedHashCodeResult, simpleInstruction2.hashCode());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}, and {@link SimpleInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(simpleInstruction, simpleInstruction);
    int expectedHashCodeResult = simpleInstruction.hashCode();
    assertEquals(expectedHashCodeResult, simpleInstruction.hashCode());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ACONST_NULL);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), null);
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), "Different type to SimpleInstruction");
  }
}
