package proguard.classfile.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.editor.CodeAttributeEditor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.SimpleInstruction;

public class NegativeStackSizeExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegativeStackSizeException#getClazz()}
   *   <li>{@link NegativeStackSizeException#getInstruction()}
   *   <li>{@link NegativeStackSizeException#getInstructionOffset()}
   *   <li>{@link NegativeStackSizeException#getMethod()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    NegativeStackSizeException negativeStackSizeException = new NegativeStackSizeException(clazz, method, instruction,
        1);

    // Act
    Clazz actualClazz = negativeStackSizeException.getClazz();
    Instruction actualInstruction = negativeStackSizeException.getInstruction();
    int actualInstructionOffset = negativeStackSizeException.getInstructionOffset();

    // Assert
    assertEquals(1, actualInstructionOffset);
    assertSame(clazz, actualClazz);
    assertSame(method, negativeStackSizeException.getMethod());
    assertSame(instruction, actualInstruction);
  }

  /**
   * Method under test:
   * {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction, int)}
   */
  @Test
  public void testNewNegativeStackSizeException() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException = new NegativeStackSizeException(clazz, method,
        instruction, 1);

    // Assert
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("Descriptor", errorParameters[3]);
    assertEquals("Name", errorParameters[2]);
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 +1 (target=2) in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 +1 (target=2) in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    assertEquals("[1] lstore_2 +1 (target=2)", errorParameters[0]);
    assertNull(errorParameters[1]);
    assertNull(actualNegativeStackSizeException.getCause());
    assertEquals(0, actualNegativeStackSizeException.getSuppressed().length);
    assertEquals(1, actualNegativeStackSizeException.getInstructionOffset());
    assertEquals(2000, actualNegativeStackSizeException.getComponentErrorId());
    assertEquals(4, errorParameters.length);
    assertSame(clazz, actualNegativeStackSizeException.getClazz());
    assertSame(method, actualNegativeStackSizeException.getMethod());
    assertSame(instruction, actualNegativeStackSizeException.getInstruction());
  }

  /**
   * Method under test:
   * {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction, int)}
   */
  @Test
  public void testNewNegativeStackSizeException2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ConstantInstruction instruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException = new NegativeStackSizeException(clazz, method,
        instruction, 1);

    // Assert
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("Descriptor", errorParameters[3]);
    assertEquals("Name", errorParameters[2]);
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 #1 =  in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 #1 =  in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    assertEquals("[1] lstore_2 #1 = ", errorParameters[0]);
    assertNull(errorParameters[1]);
    assertNull(actualNegativeStackSizeException.getCause());
    assertEquals(0, actualNegativeStackSizeException.getSuppressed().length);
    assertEquals(1, actualNegativeStackSizeException.getInstructionOffset());
    assertEquals(2000, actualNegativeStackSizeException.getComponentErrorId());
    assertEquals(4, errorParameters.length);
    assertSame(clazz, actualNegativeStackSizeException.getClazz());
    assertSame(method, actualNegativeStackSizeException.getMethod());
    assertSame(instruction, actualNegativeStackSizeException.getInstruction());
  }

  /**
   * Method under test:
   * {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction, int)}
   */
  @Test
  public void testNewNegativeStackSizeException3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SimpleInstruction instruction = new SimpleInstruction((byte) 'A');

    // Act
    NegativeStackSizeException actualNegativeStackSizeException = new NegativeStackSizeException(clazz, method,
        instruction, 1);

    // Assert
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("Descriptor", errorParameters[3]);
    assertEquals("Name", errorParameters[2]);
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals("Stack size becomes negative after instruction [1] lstore_2 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    assertEquals("[1] lstore_2", errorParameters[0]);
    assertNull(errorParameters[1]);
    assertNull(actualNegativeStackSizeException.getCause());
    assertEquals(0, actualNegativeStackSizeException.getSuppressed().length);
    assertEquals(1, actualNegativeStackSizeException.getInstructionOffset());
    assertEquals(2000, actualNegativeStackSizeException.getComponentErrorId());
    assertEquals(4, errorParameters.length);
    assertSame(clazz, actualNegativeStackSizeException.getClazz());
    assertSame(method, actualNegativeStackSizeException.getMethod());
    assertSame(instruction, actualNegativeStackSizeException.getInstruction());
  }

  /**
   * Method under test:
   * {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction, int)}
   */
  @Test
  public void testNewNegativeStackSizeException4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttributeEditor.Label instruction = new CodeAttributeEditor.Label(1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException = new NegativeStackSizeException(clazz, method,
        instruction, 1);

    // Assert
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("Descriptor", errorParameters[3]);
    assertEquals("Name", errorParameters[2]);
    assertEquals("Stack size becomes negative after instruction [1] label_536870913 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals("Stack size becomes negative after instruction [1] label_536870913 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    assertEquals("[1] label_536870913", errorParameters[0]);
    assertNull(errorParameters[1]);
    assertNull(actualNegativeStackSizeException.getCause());
    assertEquals(0, actualNegativeStackSizeException.getSuppressed().length);
    assertEquals(1, actualNegativeStackSizeException.getInstructionOffset());
    assertEquals(2000, actualNegativeStackSizeException.getComponentErrorId());
    assertEquals(4, errorParameters.length);
    assertSame(clazz, actualNegativeStackSizeException.getClazz());
    assertSame(method, actualNegativeStackSizeException.getMethod());
    assertSame(instruction, actualNegativeStackSizeException.getInstruction());
  }
}
