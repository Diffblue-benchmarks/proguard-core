package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class VariableInstructionDiffblueTest {
  /**
   * Method under test: {@link VariableInstruction#copy(VariableInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertSame(variableInstruction, variableInstruction.copy(new VariableInstruction((byte) 'A')));
  }

  /**
   * Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  public void testIsStore() {
    // Arrange, Act and Assert
    assertTrue((new VariableInstruction((byte) 'A')).isStore());
  }

  /**
   * Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  public void testIsStore2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '5';

    // Act and Assert
    assertFalse(variableInstruction.isStore());
  }

  /**
   * Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  public void testIsStore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertTrue(variableInstruction.isStore());
  }

  /**
   * Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  public void testIsLoad() {
    // Arrange, Act and Assert
    assertFalse((new VariableInstruction((byte) 'A')).isLoad());
  }

  /**
   * Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  public void testIsLoad2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '5';

    // Act and Assert
    assertTrue(variableInstruction.isLoad());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals('7', (new VariableInstruction((byte) 'A')).canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act and Assert
    assertEquals(Instruction.OP_ILOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_LLOAD_0;

    // Act and Assert
    assertEquals(Instruction.OP_LLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode4() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '"';

    // Act and Assert
    assertEquals(Instruction.OP_FLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode5() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '&';

    // Act and Assert
    assertEquals(Instruction.OP_DLOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '*';

    // Act and Assert
    assertEquals(Instruction.OP_ALOAD, variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode7() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) '.';

    // Act and Assert
    assertEquals('.', variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode8() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) ';';

    // Act and Assert
    assertEquals('6', variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode9() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'C';

    // Act and Assert
    assertEquals('8', variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode10() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'G';

    // Act and Assert
    assertEquals('9', variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode11() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'K';

    // Act and Assert
    assertEquals(':', variableInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("lstore_2", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('A', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_LLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("lload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('!', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink4() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_FLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('%', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink5() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_DLOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals(')', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ALOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("aload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('-', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink7() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink8() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = Instruction.OP_LLOAD_0;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("lload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('!', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink9() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '"';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('%', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink10() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '&';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals(')', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink11() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '*';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("aload_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('-', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink12() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '.';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iaload", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('.', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink13() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '6';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("istore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('>', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink14() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '8';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fstore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('F', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink15() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) '9';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dstore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('J', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink16() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) ':';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("astore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('N', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink17() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) ';';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("istore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('>', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink18() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 3;
    variableInstruction.opcode = (byte) 'C';

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fstore_3", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals('F', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink19() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Act and Assert
    assertSame(variableInstruction, variableInstruction.shrink());
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink20() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = 26;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iload", variableInstruction.getName());
    assertFalse(variableInstruction.isWide());
    assertEquals(Instruction.OP_ILOAD, variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  public void testShrink21() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.variableIndex = -1;
    variableInstruction.opcode = Instruction.OP_ILOAD;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("aload", variableInstruction.getName());
    assertTrue(variableInstruction.isWide());
    assertEquals(Instruction.OP_ALOAD, variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo() throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(2, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) ':';
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(0, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo4() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ALOAD;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo5() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'O';
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, variableInstruction.variableIndex);
    assertEquals(88, variableInstruction.constant);
  }

  /**
   * Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo7() throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(true);

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(16728, variableInstruction.variableIndex);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertEquals(8, code.length);
    assertEquals('A', code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ILOAD_0;
    variableInstruction.wide = false;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertEquals(8, code.length);
    assertEquals('A', code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_ALOAD;
    variableInstruction.wide = false;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ICONST_M1, code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo4() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) 'O';
    variableInstruction.wide = false;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ICONST_M1, code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo5() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = Instruction.OP_IINC;
    variableInstruction.wide = false;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ICONST_M1, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo6() throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(true);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableInstruction((byte) 'A')).length(2));
    assertEquals(4, (new VariableInstruction(true)).length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_ILOAD_0;

    // Act and Assert
    assertEquals(1, variableInstruction.length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_ALOAD;

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength4() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = (byte) 'O';

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength5() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals(3, variableInstruction.length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  public void testLength6() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = true;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals(6, variableInstruction.length(2));
  }

  /**
   * Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 v2", (new VariableInstruction((byte) 'A')).toString());
    assertEquals("nop_w v0", (new VariableInstruction(true)).toString());
  }

  /**
   * Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = false;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals("iinc v2, 0", variableInstruction.toString());
  }

  /**
   * Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.wide = true;
    variableInstruction.opcode = Instruction.OP_IINC;

    // Act and Assert
    assertEquals("iinc_w v2, 0", variableInstruction.toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertEquals(variableInstruction, variableInstruction);
    int expectedHashCodeResult = variableInstruction.hashCode();
    assertEquals(expectedHashCodeResult, variableInstruction.hashCode());
  }

  /**
   * Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ICONST_M1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', 1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', -124);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), null);
  }

  /**
   * Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), "Different type to VariableInstruction");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableInstruction#VariableInstruction()}
   *   <li>{@link VariableInstruction#isWide()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new VariableInstruction()).isWide());
    assertTrue((new VariableInstruction(true)).isWide());
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  public void testNewVariableInstruction() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(2, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  public void testNewVariableInstruction2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_1);

    // Assert
    assertEquals("iload_1", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_ILOAD_1, actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  public void testNewVariableInstruction3() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_3);

    // Assert
    assertEquals("iload_3", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(3, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_ILOAD_3, actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  public void testNewVariableInstruction4() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_LLOAD_0);

    // Assert
    assertEquals("lload_0", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isStore());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_LLOAD_0, actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  public void testNewVariableInstruction5() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  public void testNewVariableInstruction6() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  public void testNewVariableInstruction7() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  public void testNewVariableInstruction8() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertEquals(0, actualVariableInstruction.constant);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  public void testNewVariableInstruction9() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.constant);
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  public void testNewVariableInstruction10() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.constant);
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  public void testNewVariableInstruction11() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC, 1, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.constant);
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  public void testNewVariableInstruction12() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertEquals(1, actualVariableInstruction.constant);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  public void testNewVariableInstruction13() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.constant);
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isStore());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  public void testNewVariableInstruction14() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC, 1, Integer.MIN_VALUE);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isStore());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals(Integer.MIN_VALUE, actualVariableInstruction.constant);
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }
}
