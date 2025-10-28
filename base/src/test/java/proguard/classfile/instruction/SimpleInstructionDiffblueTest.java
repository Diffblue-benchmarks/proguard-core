package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class SimpleInstructionDiffblueTest {
  /**
   * Method under test: {@link SimpleInstruction#copy(SimpleInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertSame(simpleInstruction, simpleInstruction.copy(new SimpleInstruction((byte) 'A')));
  }

  /**
   * Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals('A', (new SimpleInstruction((byte) 'A')).canonicalOpcode());
  }

  /**
   * Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act and Assert
    assertEquals(Instruction.OP_ICONST_0, simpleInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\t';

    // Act and Assert
    assertEquals('\t', simpleInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_LONG;

    // Act and Assert
    assertEquals(Instruction.ARRAY_T_LONG, simpleInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_DCONST_0;

    // Act and Assert
    assertEquals(Instruction.OP_DCONST_0, simpleInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("lstore_2", simpleInstruction.getName());
    assertTrue(simpleInstruction.isCategory2());
    assertEquals('A', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = -2;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("bipush", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = 6;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("bipush", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\t';
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("iconst_5", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals('\b', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink6() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_LONG;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("lconst_1", simpleInstruction.getName());
    assertTrue(simpleInstruction.isCategory2());
    assertEquals('\n', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink7() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_DCONST_0;
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("fconst_2", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals('\r', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  public void testShrink8() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;
    simpleInstruction.constant = Integer.MIN_VALUE;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertFalse(simpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    simpleInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(-1, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo6() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(1, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo7() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_CHAR;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(2, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo8() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(3, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo9() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_DOUBLE;

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(4, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo10() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\b';

    // Act
    simpleInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(5, simpleInstruction.constant);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertEquals(8, code.length);
    assertEquals('A', code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = -1;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals(8, code.length);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = -2;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertEquals((byte) -2, code[2]);
    assertEquals(8, code.length);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = 6;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.ARRAY_T_FLOAT, code[2]);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;
    simpleInstruction.constant = -1;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals(8, code.length);
    assertEquals('X', code[3]);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo6() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;
    simpleInstruction.constant = -1;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals((byte) -1, code[3]);
    assertEquals(8, code.length);
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo7() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', Short.SIZE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo8() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR, Short.SIZE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo9() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, Short.SIZE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo10() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo11() throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', 255);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo12() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;
    simpleInstruction.constant = Integer.MIN_VALUE;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo13() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo14() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;
    simpleInstruction.constant = 6;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(1, (new SimpleInstruction((byte) 'A')).length(2));
  }

  /**
   * Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  public void testLength2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act and Assert
    assertEquals(2, simpleInstruction.length(2));
  }

  /**
   * Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  public void testLength3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act and Assert
    assertEquals(2, simpleInstruction.length(2));
  }

  /**
   * Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  public void testLength4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act and Assert
    assertEquals(3, simpleInstruction.length(2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Y';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Z';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) 'Z';

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '[';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore6() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '[';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore7() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\\';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore8() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '\\';

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore9() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) ']';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore10() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) ']';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore11() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '^';

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore12() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '^';

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 4));
  }

  /**
   * Method under test:
   * {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore13() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.opcode = (byte) '_';

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("lstore_2", (new SimpleInstruction((byte) 'A')).toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_BIPUSH;

    // Act and Assert
    assertEquals("bipush 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_NEWARRAY;

    // Act and Assert
    assertEquals("newarray 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_SIPUSH;

    // Act and Assert
    assertEquals("sipush 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.OP_ICONST_M1;

    // Act and Assert
    assertEquals("iconst_m1 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString6() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_BOOLEAN;

    // Act and Assert
    assertEquals("iconst_1 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString7() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_CHAR;

    // Act and Assert
    assertEquals("iconst_2 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString8() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_FLOAT;

    // Act and Assert
    assertEquals("iconst_3 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString9() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = Instruction.ARRAY_T_DOUBLE;

    // Act and Assert
    assertEquals("iconst_4 5", simpleInstruction.toString());
  }

  /**
   * Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  public void testToString10() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    simpleInstruction.constant = 5;
    simpleInstruction.opcode = (byte) '\b';

    // Act and Assert
    assertEquals("iconst_5", simpleInstruction.toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(simpleInstruction, simpleInstruction);
    int expectedHashCodeResult = simpleInstruction.hashCode();
    assertEquals(expectedHashCodeResult, simpleInstruction.hashCode());
  }

  /**
   * Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ACONST_NULL);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), null);
  }

  /**
   * Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), "Different type to SimpleInstruction");
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction()}
   */
  @Test
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
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction2() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction3() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction4() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);

    // Assert
    assertEquals("iconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_BOOLEAN, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction5() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);

    // Assert
    assertEquals("iconst_2", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_CHAR, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction6() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);

    // Assert
    assertEquals("iconst_3", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_FLOAT, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction7() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);

    // Assert
    assertEquals("iconst_4", actualSimpleInstruction.getName());
    assertEquals(4, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_DOUBLE, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  public void testNewSimpleInstruction8() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\b');

    // Assert
    assertEquals("iconst_5", actualSimpleInstruction.getName());
    assertEquals(5, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals('\b', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction9() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction10() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction11() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -2);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction12() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, 6);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(6, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction13() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 1);

    // Assert
    assertEquals("lconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\n', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction14() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 1);

    // Assert
    assertEquals("fconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals('\f', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction15() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 1);

    // Assert
    assertEquals("dconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_1, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction16() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 2);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction17() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 0);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction18() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 3);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction19() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, -68);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(-68, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction20() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 2);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }

  /**
   * Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  public void testNewSimpleInstruction21() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 0);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isWide());
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }
}
