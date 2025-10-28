package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class InstructionWriterDiffblueTest {
  /**
   * Method under test:
   * {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  public void testVisitSimpleInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A'));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 2, byteArray[3]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[2]);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  public void testVisitSimpleInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 16));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 16, byteArray[2]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  public void testVisitSimpleInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(clazz, method, codeAttribute, 2, new SimpleInstruction((byte) -68));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -68, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  public void testVisitSimpleInstruction4() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 17));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[4]);
    assertEquals((byte) 17, byteArray[2]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 1, byteArray[4]);
    assertEquals((byte) 2, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[2]);
    assertEquals('A', byteArray[6]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 18, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 18, byteArray[2]);
    assertEquals((byte) 1, byteArray[3]);
    assertEquals((byte) 2, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
    assertEquals('A', byteArray[6]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -59, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -59, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals((byte) 1, byteArray[4]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[6]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction4() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -70, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -70, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals((byte) 0, byteArray[6]);
    assertEquals((byte) 1, byteArray[4]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction5() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -71, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -71, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals((byte) 0, byteArray[6]);
    assertEquals((byte) 1, byteArray[4]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 3, byteArray[3]);
    assertEquals((byte) 3, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[2]);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 3));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 3, byteArray[2]);
    assertEquals((byte) 3, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 26));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 26, byteArray[2]);
    assertEquals((byte) 3, byteArray[3]);
    assertEquals((byte) 3, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction4() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'X'));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 3, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[4]);
    assertEquals('X', byteArray[2]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction5() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) -124));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -124, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[4]);
    assertEquals((byte) 3, byteArray[5]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction6() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction(true));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -60, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[4]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 1, byteArray[4]);
    assertEquals((byte) 2, byteArray[5]);
    assertEquals(8, byteArray.length);
    assertEquals('A', byteArray[2]);
    assertEquals('A', byteArray[6]);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -56, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -56, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[4]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals((byte) 1, byteArray[6]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -55, 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) -55, byteArray[2]);
    assertEquals((byte) 0, byteArray[3]);
    assertEquals((byte) 0, byteArray[4]);
    assertEquals((byte) 0, byteArray[5]);
    assertEquals((byte) 1, byteArray[6]);
    assertEquals(8, byteArray.length);
  }
}
