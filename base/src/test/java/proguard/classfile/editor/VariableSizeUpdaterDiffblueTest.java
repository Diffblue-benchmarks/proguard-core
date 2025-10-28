package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.VariableInstruction;

public class VariableSizeUpdaterDiffblueTest {
  /**
   * Method under test:
   * {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert
    assertEquals(4, codeAttribute.u2maxLocals);
  }

  /**
   * Method under test:
   * {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction2() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 1));

    // Assert
    assertEquals(1, codeAttribute.u2maxLocals);
  }

  /**
   * Method under test:
   * {@link VariableSizeUpdater#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction3() {
    // Arrange
    VariableSizeUpdater variableSizeUpdater = new VariableSizeUpdater();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    variableSizeUpdater.visitVariableInstruction(clazz, method, codeAttribute, 2,
        new VariableInstruction(Byte.MAX_VALUE));

    // Assert
    assertEquals(2, codeAttribute.u2maxLocals);
  }
}
