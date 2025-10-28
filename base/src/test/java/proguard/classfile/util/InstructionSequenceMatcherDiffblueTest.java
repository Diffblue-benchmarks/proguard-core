package proguard.classfile.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class InstructionSequenceMatcherDiffblueTest {
  /**
   * Method under test: {@link InstructionSequenceMatcher#isMatching()}
   */
  @Test
  public void testIsMatching() {
    // Arrange, Act and Assert
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).isMatching());
  }

  /**
   * Method under test: {@link InstructionSequenceMatcher#instructionCount()}
   */
  @Test
  public void testInstructionCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).instructionCount());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchedInstructionOffset(int)}
   */
  @Test
  public void testMatchedInstructionOffset() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(0, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{branchInstruction, new BranchInstruction((byte) 'A', 1)})).matchedInstructionOffset(1));
  }

  /**
   * Method under test: {@link InstructionSequenceMatcher#wasConstant(int)}
   */
  @Test
  public void testWasConstant() {
    // Arrange, Act and Assert
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).wasConstant(1));
  }

  /**
   * Method under test: {@link InstructionSequenceMatcher#matchedArgument(int)}
   */
  @Test
  public void testMatchedArgument() {
    // Arrange, Act and Assert
    assertEquals(1, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedArgument(1));
    assertEquals(0, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedArgument(InstructionSequenceMatcher.X));
  }

  /**
   * Method under test: {@link InstructionSequenceMatcher#matchedArguments(int[])}
   */
  @Test
  public void testMatchedArguments() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{1, 0, 1, 0}, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedArguments(new int[]{1, 0, 1, 0}));
    assertArrayEquals(new int[]{0, 0, 1, 0},
        (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}))
                .matchedArguments(new int[]{InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchedConstantIndex(int)}
   */
  @Test
  public void testMatchedConstantIndex() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(0, (new InstructionSequenceMatcher(new Constant[]{classConstant, new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedConstantIndex(1));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchedConstantIndex(int)}
   */
  @Test
  public void testMatchedConstantIndex2() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}))
                .matchedConstantIndex(InstructionSequenceMatcher.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset() {
    // Arrange, Act and Assert
    assertEquals(3, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 3)})).matchedBranchOffset(2, 3));
    assertEquals(3,
        (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)})).matchedBranchOffset(InstructionSequenceMatcher.X,
                3));
    assertEquals(3, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 3)})).matchedBranchOffset(-1073741821, 3));
    assertEquals(3, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 3)})).matchedBranchOffset(3, 3));
    assertEquals(BranchTargetFinder.NO_SUBROUTINE,
        (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)})).matchedBranchOffset(2,
                InstructionSequenceMatcher.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchedJumpOffsets(int, int[])}
   */
  @Test
  public void testMatchedJumpOffsets() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{1, 0, 1, 0}, (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedJumpOffsets(2, new int[]{1, 0, 1, 0}));
    assertArrayEquals(new int[]{BranchTargetFinder.NO_SUBROUTINE, 0, 1, 0},
        (new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchedJumpOffsets(2,
                new int[]{InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(clazz, method, codeAttribute, 2,
        new BranchInstruction((byte) 'A', 1));

    // Assert
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', InstructionSequenceMatcher.X)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(clazz, method, codeAttribute, 2,
        new BranchInstruction((byte) 'A', 1));

    // Assert
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}
   */
  @Test
  public void testMatchingOpcodes() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    BranchInstruction instruction1 = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertTrue(instructionSequenceMatcher.matchingOpcodes(instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}
   */
  @Test
  public void testMatchingOpcodes2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    BranchInstruction instruction1 = new BranchInstruction((byte) 1, 1);

    // Act and Assert
    assertFalse(instructionSequenceMatcher.matchingOpcodes(instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}
   */
  @Test
  public void testMatchingOpcodes3() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    LookUpSwitchInstruction instruction1 = new LookUpSwitchInstruction();

    // Act and Assert
    assertFalse(instructionSequenceMatcher.matchingOpcodes(instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}
   */
  @Test
  public void testMatchingOpcodes4() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    SimpleInstruction instruction1 = new SimpleInstruction();

    // Act and Assert
    assertFalse(instructionSequenceMatcher.matchingOpcodes(instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}
   */
  @Test
  public void testMatchingOpcodes5() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    VariableInstruction instruction1 = new VariableInstruction();

    // Act and Assert
    assertFalse(instructionSequenceMatcher.matchingOpcodes(instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingArguments(int, int)}
   */
  @Test
  public void testMatchingArguments() {
    // Arrange, Act and Assert
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(1, 1));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(InstructionSequenceMatcher.X, 1));
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(1, InstructionSequenceMatcher.X));
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(new int[]{1, 0, 1, 0},
            new int[]{1, 0, 1, 0}));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(new int[]{4, 0, 1, 0},
            new int[]{1, 0, 1, 0}));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(new int[]{},
            new int[]{1, 0, 1, 0}));
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingArguments(new int[]{1, 0, 1, 0},
            new int[]{InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingConstantIndices(Clazz, int, int)}
   */
  @Test
  public void testMatchingConstantIndices() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Act and Assert
    assertTrue(instructionSequenceMatcher.matchingConstantIndices(new LibraryClass(), 1, InstructionSequenceMatcher.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}
   */
  @Test
  public void testMatchingBranchOffsets() {
    // Arrange, Act and Assert
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingBranchOffsets(2, 1, 1));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingBranchOffsets(2, InstructionSequenceMatcher.X,
            1));
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingBranchOffsets(2, 1,
            InstructionSequenceMatcher.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}
   */
  @Test
  public void testMatchingJumpOffsets() {
    // Arrange, Act and Assert
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingJumpOffsets(2, new int[]{1, 0, 1, 0},
            new int[]{1, 0, 1, 0}));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingJumpOffsets(2, new int[]{4, 0, 1, 0},
            new int[]{1, 0, 1, 0}));
    assertFalse((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingJumpOffsets(2, new int[]{},
            new int[]{1, 0, 1, 0}));
    assertTrue((new InstructionSequenceMatcher(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)})).matchingJumpOffsets(2, new int[]{1, 0, 1, 0},
            new int[]{InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#finalMatch(Clazz, Method, CodeAttribute, int, Instruction)}
   */
  @Test
  public void testFinalMatch() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertTrue(
        instructionSequenceMatcher.finalMatch(clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[], Instruction[])}
   */
  @Test
  public void testNewInstructionSequenceMatcher() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{classConstant}, new Instruction[]{branchInstruction});

    // Assert
    assertNull(actualInstructionSequenceMatcher.patternConstant);
    Constant[] constantArray = actualInstructionSequenceMatcher.patternConstants;
    assertEquals(1, constantArray.length);
    Instruction[] instructionArray = actualInstructionSequenceMatcher.patternInstructions;
    assertEquals(1, instructionArray.length);
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertFalse(actualInstructionSequenceMatcher.matchingConstant);
    assertSame(classConstant, constantArray[0]);
    assertSame(branchInstruction, instructionArray[0]);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[], Instruction[], boolean)}
   */
  @Test
  public void testNewInstructionSequenceMatcher2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{classConstant}, new Instruction[]{branchInstruction}, true);

    // Assert
    assertNull(actualInstructionSequenceMatcher.patternConstant);
    Constant[] constantArray = actualInstructionSequenceMatcher.patternConstants;
    assertEquals(1, constantArray.length);
    Instruction[] instructionArray = actualInstructionSequenceMatcher.patternInstructions;
    assertEquals(1, instructionArray.length);
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertFalse(actualInstructionSequenceMatcher.matchingConstant);
    assertSame(classConstant, constantArray[0]);
    assertSame(branchInstruction, instructionArray[0]);
  }
}
