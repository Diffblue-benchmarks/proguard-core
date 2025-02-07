package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;

class InstructionWriterDiffblueTest {
  /**
   * Test {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>When {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); when SimpleInstruction(byte) with opcode is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_whenSimpleInstructionWithOpcodeIsA() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A'));

    // Assert that nothing has changed
    assertArrayEquals(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>When {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is minus sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); when SimpleInstruction(byte) with opcode is minus sixty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_whenSimpleInstructionWithOpcodeIsMinusSixtyEight() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) -68));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -68, 0, 'A', 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>When {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is seventeen.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); when SimpleInstruction(byte) with opcode is seventeen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_whenSimpleInstructionWithOpcodeIsSeventeen() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 17));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, 17, 0, 0, 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>When {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is sixteen.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); when SimpleInstruction(byte) with opcode is sixteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_whenSimpleInstructionWithOpcodeIsSixteen() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 16));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, 16, 0, 'A', 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, 'A', 0, 1, 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 18, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, 18, 1, 'A', 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -59, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -59, 0, 1, 0, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction4() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -70, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -70, 0, 1, 0, 0, 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction5() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -71, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -71, 0, 1, 0, 0, 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) -124));

    // Assert
    assertArrayEquals(new byte[] {'A', 3, -124, 0, 0, 3, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); when VariableInstruction(byte) with opcode is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_whenVariableInstructionWithOpcodeIsA() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert that nothing has changed
    assertArrayEquals(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction(byte)} with opcode is three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); when VariableInstruction(byte) with opcode is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_whenVariableInstructionWithOpcodeIsThree() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 3));

    // Assert
    assertArrayEquals(new byte[] {'A', 3, 3, 0, 'A', 3, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction(byte)} with opcode is twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); when VariableInstruction(byte) with opcode is twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_whenVariableInstructionWithOpcodeIsTwentySix() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 26));

    // Assert
    assertArrayEquals(new byte[] {'A', 3, 26, 3, 'A', 3, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); when VariableInstruction(byte) with opcode is 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_whenVariableInstructionWithOpcodeIsX() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'X'));

    // Assert
    assertArrayEquals(new byte[] {'A', 3, 'X', 0, 'A', 3, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); when VariableInstruction(boolean) with wide is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_whenVariableInstructionWithWideIsTrue() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    instructionWriter.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction(true));

    // Assert
    assertArrayEquals(new byte[] {'A', 3, -60, 0, 0, 0, 'A', 3}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, 'A', 0, 1, 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction2() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -56, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -56, 0, 0, 0, 1, 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionWriter#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction3() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    instructionWriter.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -55, 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 2, -55, 0, 0, 0, 1, 2}, codeAttribute.code);
  }

  /**
   * Test {@link InstructionWriter#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link Instruction#write(byte[], int)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionWriter#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); then calls write(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionWriter.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_thenCallsWrite() {
    // Arrange
    InstructionWriter instructionWriter = new InstructionWriter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LookUpSwitchInstruction switchInstruction = mock(LookUpSwitchInstruction.class);
    doNothing().when(switchInstruction).write(Mockito.<byte[]>any(), anyInt());

    // Act
    instructionWriter.visitAnySwitchInstruction(clazz, method, codeAttribute, 2, switchInstruction);

    // Assert
    verify(switchInstruction).write(isA(byte[].class), eq(2));
  }
}
