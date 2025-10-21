package proguard.classfile.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[], Instruction[])}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[],
   * Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceMatcher.<init>(Constant[], Instruction[])"})
  public void testNewInstructionSequenceMatcher() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {classConstant}, new Instruction[] {branchInstruction});

    // Assert
    Constant[] constantArray = actualInstructionSequenceMatcher.patternConstants;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ClassConstant);
    Instruction[] instructionArray = actualInstructionSequenceMatcher.patternInstructions;
    Instruction instruction = instructionArray[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertNull(actualInstructionSequenceMatcher.patternConstant);
    assertEquals(1, constantArray.length);
    assertEquals(1, instructionArray.length);
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertFalse(actualInstructionSequenceMatcher.matchingConstant);
    assertSame(classConstant, constant);
    assertSame(branchInstruction, instruction);
  }

  /**
   * Test {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[], Instruction[],
   * boolean)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[],
   * Instruction[], boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceMatcher.<init>(Constant[], Instruction[], boolean)"})
  public void testNewInstructionSequenceMatcher2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {classConstant}, new Instruction[] {branchInstruction}, true);

    // Assert
    Constant[] constantArray = actualInstructionSequenceMatcher.patternConstants;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ClassConstant);
    Instruction[] instructionArray = actualInstructionSequenceMatcher.patternInstructions;
    Instruction instruction = instructionArray[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertNull(actualInstructionSequenceMatcher.patternConstant);
    assertEquals(1, constantArray.length);
    assertEquals(1, instructionArray.length);
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertFalse(actualInstructionSequenceMatcher.matchingConstant);
    assertSame(classConstant, constant);
    assertSame(branchInstruction, instruction);
  }

  /**
   * Test {@link InstructionSequenceMatcher#isMatching()}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#isMatching()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.isMatching()"})
  public void testIsMatching() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#instructionCount()}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#instructionCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.instructionCount()"})
  public void testInstructionCount() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .instructionCount());
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedInstructionOffset(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedInstructionOffset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedInstructionOffset(int)"})
  public void testMatchedInstructionOffset_thenReturnZero() {
    // Arrange
    BranchInstruction branchInstruction = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {branchInstruction, new BranchInstruction((byte) 'A', 1)}))
            .matchedInstructionOffset(1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#wasConstant(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#wasConstant(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.wasConstant(int)"})
  public void testWasConstant() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .wasConstant(1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedArgument(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedArgument(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedArgument(int)"})
  public void testMatchedArgument_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedArgument(1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedArgument(int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedArgument(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedArgument(int)"})
  public void testMatchedArgument_whenX_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedArgument(InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedArguments(int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedArguments(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceMatcher.matchedArguments(int[])"})
  public void testMatchedArguments_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0},
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedArguments(new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedArguments(int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedArguments(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceMatcher.matchedArguments(int[])"})
  public void testMatchedArguments_thenReturnArrayOfIntWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {0, 0, 1, 0},
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedArguments(new int[] {InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedConstantIndex(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedConstantIndex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedConstantIndex(int)"})
  public void testMatchedConstantIndex() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceMatcher(
                new Constant[] {classConstant, new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedConstantIndex(1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedConstantIndex(int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedConstantIndex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedConstantIndex(int)"})
  public void testMatchedConstantIndex_whenX_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedConstantIndex(InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@code -1073741821}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_when1073741821_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)}))
            .matchedBranchOffset(-1073741821, 3));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)}))
            .matchedBranchOffset(3, 3));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenTwo_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)}))
            .matchedBranchOffset(2, 3));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@link BranchTargetFinder#NO_SUBROUTINE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenX_thenReturnNo_subroutine() {
    // Arrange, Act and Assert
    assertEquals(
        BranchTargetFinder.NO_SUBROUTINE,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)}))
            .matchedBranchOffset(2, InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceMatcher.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenX_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)}))
            .matchedBranchOffset(InstructionSequenceMatcher.X, 3));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with {@link BranchTargetFinder#NO_SUBROUTINE} and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedJumpOffsets(int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceMatcher.matchedJumpOffsets(int, int[])"})
  public void testMatchedJumpOffsets_thenReturnArrayOfIntWithNo_subroutineAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {BranchTargetFinder.NO_SUBROUTINE, 0, 1, 0},
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedJumpOffsets(2, new int[] {InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchedJumpOffsets(int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceMatcher.matchedJumpOffsets(int, int[])"})
  public void testMatchedJumpOffsets_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0},
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedJumpOffsets(2, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceMatcher.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceMatcher.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 1, 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert that nothing has changed
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceMatcher.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction3() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 65)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert that nothing has changed
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceMatcher.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction4() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', InstructionSequenceMatcher.X)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingOpcodes(Instruction,
   * Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.matchingOpcodes(Instruction, Instruction)"
  })
  public void testMatchingOpcodes_thenReturnTrue() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    BranchInstruction instruction1 = new BranchInstruction((byte) 'A', 1);

    // Act and Assert
    assertTrue(
        instructionSequenceMatcher.matchingOpcodes(
            instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is one and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingOpcodes(Instruction,
   * Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.matchingOpcodes(Instruction, Instruction)"
  })
  public void testMatchingOpcodes_whenBranchInstructionWithOpcodeIsOneAndBranchOffsetIsOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    BranchInstruction instruction1 = new BranchInstruction((byte) 1, 1);

    // Act and Assert
    assertFalse(
        instructionSequenceMatcher.matchingOpcodes(
            instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}.
   *
   * <ul>
   *   <li>When {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingOpcodes(Instruction,
   * Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.matchingOpcodes(Instruction, Instruction)"
  })
  public void testMatchingOpcodes_whenLookUpSwitchInstruction_thenReturnFalse() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LookUpSwitchInstruction instruction1 = new LookUpSwitchInstruction();

    // Act and Assert
    assertFalse(
        instructionSequenceMatcher.matchingOpcodes(
            instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}.
   *
   * <ul>
   *   <li>When {@link SimpleInstruction#SimpleInstruction()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingOpcodes(Instruction,
   * Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.matchingOpcodes(Instruction, Instruction)"
  })
  public void testMatchingOpcodes_whenSimpleInstruction_thenReturnFalse() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    SimpleInstruction instruction1 = new SimpleInstruction();

    // Act and Assert
    assertFalse(
        instructionSequenceMatcher.matchingOpcodes(
            instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingOpcodes(Instruction, Instruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingOpcodes(Instruction,
   * Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.matchingOpcodes(Instruction, Instruction)"
  })
  public void testMatchingOpcodes_whenVariableInstruction_thenReturnFalse() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    VariableInstruction instruction1 = new VariableInstruction();

    // Act and Assert
    assertFalse(
        instructionSequenceMatcher.matchingOpcodes(
            instruction1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int, int)} with {@code argument1},
   * {@code argument2}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int, int)"})
  public void testMatchingArgumentsWithArgument1Argument2_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(1, 1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int, int)} with {@code argument1},
   * {@code argument2}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int, int)"})
  public void testMatchingArgumentsWithArgument1Argument2_whenX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(InstructionSequenceMatcher.X, 1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int, int)} with {@code argument1},
   * {@code argument2}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int, int)"})
  public void testMatchingArgumentsWithArgument1Argument2_whenX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(1, InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int[], int[])} with {@code
   * arguments1}, {@code arguments2}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int[], int[])"})
  public void testMatchingArgumentsWithArguments1Arguments2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int[], int[])} with {@code
   * arguments1}, {@code arguments2}.
   *
   * <ul>
   *   <li>When array of {@code int} with four and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int[], int[])"})
  public void testMatchingArgumentsWithArguments1Arguments2_whenArrayOfIntWithFourAndZero() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(new int[] {4, 0, 1, 0}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int[], int[])} with {@code
   * arguments1}, {@code arguments2}.
   *
   * <ul>
   *   <li>When array of {@code int} with {@link InstructionSequenceMatcher#X} and zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int[], int[])"})
  public void testMatchingArgumentsWithArguments1Arguments2_whenArrayOfIntWithXAndZero() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(
                new int[] {1, 0, 1, 0}, new int[] {InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingArguments(int[], int[])} with {@code
   * arguments1}, {@code arguments2}.
   *
   * <ul>
   *   <li>When empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingArguments(int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingArguments(int[], int[])"})
  public void testMatchingArgumentsWithArguments1Arguments2_whenEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingArguments(new int[] {}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingConstantIndices(Clazz, int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingConstantIndices(Clazz, int,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingConstantIndices(Clazz, int, int)"})
  public void testMatchingConstantIndices_whenX_thenReturnTrue() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Act and Assert
    assertTrue(
        instructionSequenceMatcher.matchingConstantIndices(
            new LibraryClass(), 1, InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"})
  public void testMatchingBranchOffsets_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingBranchOffsets(2, 1, 1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"})
  public void testMatchingBranchOffsets_whenX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingBranchOffsets(2, InstructionSequenceMatcher.X, 1));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceMatcher#X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingBranchOffsets(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"})
  public void testMatchingBranchOffsets_whenX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingBranchOffsets(2, 1, InstructionSequenceMatcher.X));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}.
   *
   * <ul>
   *   <li>When array of {@code int} with four and zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"})
  public void testMatchingJumpOffsets_whenArrayOfIntWithFourAndZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingJumpOffsets(2, new int[] {4, 0, 1, 0}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"})
  public void testMatchingJumpOffsets_whenArrayOfIntWithOneAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingJumpOffsets(2, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}.
   *
   * <ul>
   *   <li>When array of {@code int} with {@link InstructionSequenceMatcher#X} and zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"})
  public void testMatchingJumpOffsets_whenArrayOfIntWithXAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingJumpOffsets(
                2, new int[] {1, 0, 1, 0}, new int[] {InstructionSequenceMatcher.X, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}.
   *
   * <ul>
   *   <li>When empty array of {@code int}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#matchingJumpOffsets(int, int[], int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"})
  public void testMatchingJumpOffsets_whenEmptyArrayOfInt_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchingJumpOffsets(2, new int[] {}, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#finalMatch(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#finalMatch(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InstructionSequenceMatcher.finalMatch(Clazz, Method, CodeAttribute, int, Instruction)"
  })
  public void testFinalMatch() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertTrue(
        instructionSequenceMatcher.finalMatch(
            clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }
}
