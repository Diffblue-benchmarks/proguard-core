package proguard.classfile.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.editor.CodeAttributeEditor.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.SimpleInstruction;

class NegativeStackSizeExceptionDiffblueTest {
  /**
   * Test {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction,
   * int)}.
   *
   * <p>Method under test: {@link NegativeStackSizeException#NegativeStackSizeException(Clazz,
   * Method, Instruction, int)}
   */
  @Test
  @DisplayName("Test new NegativeStackSizeException(Clazz, Method, Instruction, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.exception.NegativeStackSizeException.<init>(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.instruction.Instruction, int)"
  })
  void testNewNegativeStackSizeException() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Label instruction = new Label(1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException =
        new NegativeStackSizeException(clazz, method, instruction, 1);

    // Assert
    assertTrue(actualNegativeStackSizeException.getClazz() instanceof LibraryClass);
    assertEquals(
        "Stack size becomes negative after instruction [1] label_536870913 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals(
        "Stack size becomes negative after instruction [1] label_536870913 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("[1] label_536870913", errorParameters[0]);
    assertEquals(4, errorParameters.length);
    assertSame(instruction, actualNegativeStackSizeException.getInstruction());
  }

  /**
   * Test {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction,
   * int)}.
   *
   * <ul>
   *   <li>Then Instruction return {@link BranchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link NegativeStackSizeException#NegativeStackSizeException(Clazz,
   * Method, Instruction, int)}
   */
  @Test
  @DisplayName(
      "Test new NegativeStackSizeException(Clazz, Method, Instruction, int); then Instruction return BranchInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.exception.NegativeStackSizeException.<init>(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.instruction.Instruction, int)"
  })
  void testNewNegativeStackSizeException_thenInstructionReturnBranchInstruction() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException =
        new NegativeStackSizeException(clazz, method, instruction, 1);

    // Assert
    assertTrue(actualNegativeStackSizeException.getClazz() instanceof LibraryClass);
    Instruction instruction2 = actualNegativeStackSizeException.getInstruction();
    assertTrue(instruction2 instanceof BranchInstruction);
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 +1 (target=2) in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 +1 (target=2) in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("[1] lstore_2 +1 (target=2)", errorParameters[0]);
    assertEquals(1, ((BranchInstruction) instruction2).branchOffset);
    assertEquals(4, errorParameters.length);
    assertSame(instruction, instruction2);
  }

  /**
   * Test {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction,
   * int)}.
   *
   * <ul>
   *   <li>Then Instruction return {@link ConstantInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link NegativeStackSizeException#NegativeStackSizeException(Clazz,
   * Method, Instruction, int)}
   */
  @Test
  @DisplayName(
      "Test new NegativeStackSizeException(Clazz, Method, Instruction, int); then Instruction return ConstantInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.exception.NegativeStackSizeException.<init>(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.instruction.Instruction, int)"
  })
  void testNewNegativeStackSizeException_thenInstructionReturnConstantInstruction() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ConstantInstruction instruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    NegativeStackSizeException actualNegativeStackSizeException =
        new NegativeStackSizeException(clazz, method, instruction, 1);

    // Assert
    assertTrue(actualNegativeStackSizeException.getClazz() instanceof LibraryClass);
    Instruction instruction2 = actualNegativeStackSizeException.getInstruction();
    assertTrue(instruction2 instanceof ConstantInstruction);
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 #1 =  in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 #1 =  in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("[1] lstore_2 #1 = ", errorParameters[0]);
    assertEquals(1, ((ConstantInstruction) instruction2).constantIndex);
    assertEquals(4, errorParameters.length);
    assertSame(instruction, instruction2);
  }

  /**
   * Test {@link NegativeStackSizeException#NegativeStackSizeException(Clazz, Method, Instruction,
   * int)}.
   *
   * <ul>
   *   <li>Then Instruction return {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link NegativeStackSizeException#NegativeStackSizeException(Clazz,
   * Method, Instruction, int)}
   */
  @Test
  @DisplayName(
      "Test new NegativeStackSizeException(Clazz, Method, Instruction, int); then Instruction return SimpleInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.exception.NegativeStackSizeException.<init>(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.instruction.Instruction, int)"
  })
  void testNewNegativeStackSizeException_thenInstructionReturnSimpleInstruction() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SimpleInstruction instruction = new SimpleInstruction((byte) 'A');

    // Act
    NegativeStackSizeException actualNegativeStackSizeException =
        new NegativeStackSizeException(clazz, method, instruction, 1);

    // Assert
    assertTrue(actualNegativeStackSizeException.getClazz() instanceof LibraryClass);
    Instruction instruction2 = actualNegativeStackSizeException.getInstruction();
    assertTrue(instruction2 instanceof SimpleInstruction);
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getLocalizedMessage());
    assertEquals(
        "Stack size becomes negative after instruction [1] lstore_2 in [null.NameDescriptor]",
        actualNegativeStackSizeException.getMessage());
    Object[] errorParameters = actualNegativeStackSizeException.getErrorParameters();
    assertEquals("[1] lstore_2", errorParameters[0]);
    assertEquals(4, errorParameters.length);
    assertSame(instruction, instruction2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegativeStackSizeException#getClazz()}
   *   <li>{@link NegativeStackSizeException#getInstruction()}
   *   <li>{@link NegativeStackSizeException#getInstructionOffset()}
   *   <li>{@link NegativeStackSizeException#getMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.classfile.exception.NegativeStackSizeException.getClazz()",
    "proguard.classfile.instruction.Instruction proguard.classfile.exception.NegativeStackSizeException.getInstruction()",
    "int proguard.classfile.exception.NegativeStackSizeException.getInstructionOffset()",
    "proguard.classfile.Method proguard.classfile.exception.NegativeStackSizeException.getMethod()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    NegativeStackSizeException negativeStackSizeException =
        new NegativeStackSizeException(clazz, method, instruction, 1);

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
}
