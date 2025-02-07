package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.VariableInstruction;

class VariableSizeUpdaterDiffblueTest {
  /**
   * Test {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <p>Method under test: {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableSizeUpdater.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert
    assertEquals(4, codeAttribute.u2maxLocals);
  }

  /**
   * Test {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <p>Method under test: {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableSizeUpdater.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction2() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 1));

    // Assert
    assertEquals(1, codeAttribute.u2maxLocals);
  }

  /**
   * Test {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <p>Method under test: {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableSizeUpdater.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction3() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction(Byte.MAX_VALUE));

    // Assert
    assertEquals(2, codeAttribute.u2maxLocals);
  }

  /**
   * Test {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <p>Method under test: {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableSizeUpdater.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction4() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    variableSizeUpdater.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 1));

    // Assert that nothing has changed
    assertEquals(3, codeAttribute.u2maxLocals);
  }
}
