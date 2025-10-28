package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;

public class InstructionDiffblueTest {
  /**
   * Method under test: {@link Instruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals(Instruction.OP_NOP, (new LookUpSwitchInstruction()).canonicalOpcode());
  }

  /**
   * Method under test: {@link Instruction#actualOpcode()}
   */
  @Test
  public void testActualOpcode() {
    // Arrange, Act and Assert
    assertEquals('A', (new BranchInstruction((byte) 'A', 1)).actualOpcode());
  }

  /**
   * Method under test: {@link Instruction#write(CodeAttribute, int)}
   */
  @Test
  public void testWrite() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', Instruction.OP_ICONST_M1, 'A',
        Instruction.OP_ICONST_M1, 'A', Instruction.OP_ICONST_M1, 'A', Instruction.OP_ICONST_M1});

    // Act
    branchInstruction.write(codeAttribute, 2);

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals(8, byteArray.length);
    assertEquals(Instruction.OP_ACONST_NULL, byteArray[4]);
    assertEquals(Instruction.OP_ICONST_M1, byteArray[5]);
    assertEquals(Instruction.OP_NOP, byteArray[3]);
    assertEquals('A', byteArray[2]);
    assertEquals('A', byteArray[6]);
  }

  /**
   * Method under test: {@link Instruction#write(CodeAttribute, int)}
   */
  @Test
  public void testWrite2() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, 1);
    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', Instruction.OP_ICONST_M1, 'A',
        Instruction.OP_ICONST_M1, 'A', Instruction.OP_ICONST_M1, 'A', Instruction.OP_ICONST_M1});

    // Act
    branchInstruction.write(codeAttribute, 2);

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals(8, byteArray.length);
    assertEquals(Instruction.OP_ACONST_NULL, byteArray[6]);
    assertEquals(Instruction.OP_GOTO_W, byteArray[2]);
    assertEquals(Instruction.OP_NOP, byteArray[3]);
    assertEquals(Instruction.OP_NOP, byteArray[4]);
    assertEquals(Instruction.OP_NOP, byteArray[5]);
  }

  /**
   * Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  public void testWrite3() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    branchInstruction.write(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[4]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals('A', code[2]);
    assertEquals('A', code[6]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link Instruction#write(byte[], int)}
   */
  @Test
  public void testWrite4() throws UnsupportedEncodingException {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction(Instruction.OP_GOTO_W, 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    branchInstruction.write(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[6]);
    assertEquals(Instruction.OP_GOTO_W, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
  }

  /**
   * Method under test: {@link Instruction#isWide()}
   */
  @Test
  public void testIsWide() {
    // Arrange, Act and Assert
    assertFalse((new BranchInstruction((byte) 'A', 1)).isWide());
  }

  /**
   * Method under test: {@link Instruction#toString(Clazz, int)}
   */
  @Test
  public void testToString() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals("[2] lstore_2 +1 (target=3)", branchInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link Instruction#toString(int)}
   */
  @Test
  public void testToString2() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 #1", (new ConstantInstruction((byte) 'A', 1)).toString(2));
  }

  /**
   * Method under test: {@link Instruction#toString(int)}
   */
  @Test
  public void testToString3() {
    // Arrange, Act and Assert
    assertEquals("[2] lstore_2 +1 (target=3)", (new BranchInstruction((byte) 'A', 1)).toString(2));
  }

  /**
   * Method under test: {@link Instruction#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("lstore_2", (new BranchInstruction((byte) 'A', 1)).getName());
  }

  /**
   * Method under test: {@link Instruction#mayThrowExceptions()}
   */
  @Test
  public void testMayThrowExceptions() {
    // Arrange, Act and Assert
    assertFalse((new BranchInstruction((byte) 'A', 1)).mayThrowExceptions());
  }

  /**
   * Method under test: {@link Instruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  public void testMayInstanceThrowExceptions() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertFalse(branchInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Method under test: {@link Instruction#isCategory2()}
   */
  @Test
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertTrue((new BranchInstruction((byte) 'A', 1)).isCategory2());
    assertFalse((new BranchInstruction(Instruction.ARRAY_T_DOUBLE, 1)).isCategory2());
  }

  /**
   * Method under test: {@link Instruction#stackPopCount(Clazz)}
   */
  @Test
  public void testStackPopCount() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(2, branchInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link Instruction#stackPushCount(Clazz)}
   */
  @Test
  public void testStackPushCount() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(0, branchInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link Instruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  public void testStackEntryIndexBefore() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(-1, branchInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Method under test: {@link Instruction#readByte(byte[], int)}
   */
  @Test
  public void testReadByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, Instruction.readByte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link Instruction#readShort(byte[], int)}
   */
  @Test
  public void testReadShort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, Instruction.readShort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link Instruction#readInt(byte[], int)}
   */
  @Test
  public void testReadInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, Instruction.readInt("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link Instruction#readValue(byte[], int, int)}
   */
  @Test
  public void testReadValue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Instruction.readValue("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertEquals(0, Instruction.readValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0));
    assertEquals(65, Instruction.readValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
    assertEquals(16728, Instruction.readValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 2));
    assertEquals(1096302936, Instruction.readValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4));
  }

  /**
   * Method under test: {@link Instruction#readSignedByte(byte[], int)}
   */
  @Test
  public void testReadSignedByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, Instruction.readSignedByte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link Instruction#readSignedShort(byte[], int)}
   */
  @Test
  public void testReadSignedShort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, Instruction.readSignedShort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link Instruction#readSignedValue(byte[], int, int)}
   */
  @Test
  public void testReadSignedValue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Instruction.readSignedValue("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertEquals(0, Instruction.readSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0));
    assertEquals(65, Instruction.readSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
    assertEquals(16728, Instruction.readSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 2));
    assertEquals(1096302936, Instruction.readSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4));
  }

  /**
   * Method under test: {@link Instruction#writeByte(byte[], int, int)}
   */
  @Test
  public void testWriteByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeByte(code, 2, 42);

    // Assert
    assertEquals(8, code.length);
    assertEquals('*', code[2]);
  }

  /**
   * Method under test: {@link Instruction#writeByte(byte[], int, int)}
   */
  @Test
  public void testWriteByte2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeByte(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 256));
  }

  /**
   * Method under test: {@link Instruction#writeShort(byte[], int, int)}
   */
  @Test
  public void testWriteShort() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeShort(code, 2, 42);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals('*', code[3]);
  }

  /**
   * Method under test: {@link Instruction#writeShort(byte[], int, int)}
   */
  @Test
  public void testWriteShort2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeShort(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 65536));
  }

  /**
   * Method under test: {@link Instruction#writeInt(byte[], int, int)}
   */
  @Test
  public void testWriteInt() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeInt(code, 2, 42);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals('*', code[5]);
  }

  /**
   * Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteValue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Instruction.writeValue("AXAXAXAX".getBytes("UTF-8"), 2, 42, 3));
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 65535, 1));
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 65536, 2));
  }

  /**
   * Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteValue2() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 65535, 0);

    // Assert that nothing has changed
    assertEquals(8, code.length);
    assertEquals('A', code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[3]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteValue3() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 65535, 2);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals((byte) -1, code[3]);
    assertEquals(8, code.length);
    assertEquals('A', code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteValue4() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 65535, 4);

    // Assert
    assertEquals((byte) -1, code[4]);
    assertEquals((byte) -1, code[5]);
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
  }

  /**
   * Method under test: {@link Instruction#writeValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteValue5() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeValue(code, 2, 255, 1);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals(8, code.length);
    assertEquals('A', code[4]);
    assertEquals('X', code[3]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link Instruction#writeSignedByte(byte[], int, int)}
   */
  @Test
  public void testWriteSignedByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeSignedByte(code, 2, 42);

    // Assert
    assertEquals(8, code.length);
    assertEquals('*', code[2]);
  }

  /**
   * Method under test: {@link Instruction#writeSignedByte(byte[], int, int)}
   */
  @Test
  public void testWriteSignedByte2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeSignedByte("AXAXAXAX".getBytes("UTF-8"), 2, 19088743));
  }

  /**
   * Method under test: {@link Instruction#writeSignedShort(byte[], int, int)}
   */
  @Test
  public void testWriteSignedShort() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Instruction.writeSignedShort(code, 2, 42);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals('*', code[3]);
  }

  /**
   * Method under test: {@link Instruction#writeSignedShort(byte[], int, int)}
   */
  @Test
  public void testWriteSignedShort2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeSignedShort("AXAXAXAX".getBytes("UTF-8"), 2, 19088743));
  }

  /**
   * Method under test:
   * {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteSignedValue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeSignedValue("AXAXAXAX".getBytes("UTF-8"), 2, 42, 3));
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 19088743, 1));
    assertThrows(IllegalArgumentException.class,
        () -> Instruction.writeSignedValue(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 19088743, 2));
  }

  /**
   * Method under test:
   * {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteSignedValue2() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 0);

    // Assert that nothing has changed
    assertEquals(8, code.length);
    assertEquals('A', code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[3]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test:
   * {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteSignedValue3() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 1);

    // Assert
    assertEquals(8, code.length);
    assertEquals('*', code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[3]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test:
   * {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteSignedValue4() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals('*', code[3]);
    assertEquals('A', code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test:
   * {@link Instruction#writeSignedValue(byte[], int, int, int)}
   */
  @Test
  public void testWriteSignedValue5() {
    // Arrange
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Instruction.writeSignedValue(code, 2, 42, 4);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals('*', code[5]);
  }
}
