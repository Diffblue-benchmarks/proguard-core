package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.util.SimpleProcessable;

class InstructionSequenceMatcherDiffblueTest {
  /**
   * Test {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[], Instruction[])}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#InstructionSequenceMatcher(Constant[],
   * Instruction[])}
   */
  @Test
  @DisplayName("Test new InstructionSequenceMatcher(Constant[], Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.<init>(proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[])"
  })
  void testNewInstructionSequenceMatcher() {
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
  @DisplayName("Test new InstructionSequenceMatcher(Constant[], Instruction[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.<init>(proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], boolean)"
  })
  void testNewInstructionSequenceMatcher2() {
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
  @DisplayName("Test isMatching()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.InstructionSequenceMatcher.isMatching()"})
  void testIsMatching() {
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
  @DisplayName("Test instructionCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.InstructionSequenceMatcher.instructionCount()"})
  void testInstructionCount() {
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
  @DisplayName("Test matchedInstructionOffset(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedInstructionOffset(int)"
  })
  void testMatchedInstructionOffset_thenReturnZero() {
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
  @DisplayName("Test wasConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.InstructionSequenceMatcher.wasConstant(int)"})
  void testWasConstant() {
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
  @DisplayName("Test matchedArgument(int); when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.InstructionSequenceMatcher.matchedArgument(int)"})
  void testMatchedArgument_whenOne_thenReturnOne() {
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
  @DisplayName("Test matchedArgument(int); when X; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.InstructionSequenceMatcher.matchedArgument(int)"})
  void testMatchedArgument_whenX_thenReturnZero() {
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
  @DisplayName("Test matchedArguments(int[]); then return array of int with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.util.InstructionSequenceMatcher.matchedArguments(int[])"
  })
  void testMatchedArguments_thenReturnArrayOfIntWithOneAndZero() {
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
  @DisplayName("Test matchedArguments(int[]); then return array of int with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.util.InstructionSequenceMatcher.matchedArguments(int[])"
  })
  void testMatchedArguments_thenReturnArrayOfIntWithZeroAndZero() {
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
  @DisplayName("Test matchedConstantIndex(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedConstantIndex(int)"
  })
  void testMatchedConstantIndex() {
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
  @DisplayName("Test matchedConstantIndex(int); when X; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedConstantIndex(int)"
  })
  void testMatchedConstantIndex_whenX_thenReturnZero() {
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
  @DisplayName("Test matchedBranchOffset(int, int); when '-1073741821'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_when1073741821_thenReturnThree() {
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
  @DisplayName("Test matchedBranchOffset(int, int); when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenThree_thenReturnThree() {
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
  @DisplayName("Test matchedBranchOffset(int, int); when two; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenTwo_thenReturnThree() {
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
  @DisplayName("Test matchedBranchOffset(int, int); when X; then return NO_SUBROUTINE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenX_thenReturnNo_subroutine() {
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
  @DisplayName("Test matchedBranchOffset(int, int); when X; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.InstructionSequenceMatcher.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenX_thenReturnThree() {
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
  @DisplayName(
      "Test matchedJumpOffsets(int, int[]); then return array of int with NO_SUBROUTINE and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.util.InstructionSequenceMatcher.matchedJumpOffsets(int, int[])"
  })
  void testMatchedJumpOffsets_thenReturnArrayOfIntWithNo_subroutineAndZero() {
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
  @DisplayName("Test matchedJumpOffsets(int, int[]); then return array of int with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.util.InstructionSequenceMatcher.matchedJumpOffsets(int, int[])"
  })
  void testMatchedJumpOffsets_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0},
        (new InstructionSequenceMatcher(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)}))
            .matchedJumpOffsets(2, new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName("Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new SimpleInstruction((byte) 'A')});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A'));

    // Assert
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName("Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction2() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new SimpleInstruction()});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A'));

    // Assert that nothing has changed
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName("Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction3() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new SimpleInstruction((byte) 'A', 65)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A'));

    // Assert that nothing has changed
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then calls {@link SimpleInstruction#canonicalOpcode()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); given 'A'; then calls canonicalOpcode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_givenA_thenCallsCanonicalOpcode() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new SimpleInstruction((byte) 'A')});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SimpleInstruction simpleInstruction = mock(SimpleInstruction.class);
    when(simpleInstruction.canonicalOpcode()).thenReturn((byte) 'A');

    // Act
    instructionSequenceMatcher.visitSimpleInstruction(
        clazz, method, codeAttribute, 2, simpleInstruction);

    // Assert
    verify(simpleInstruction).canonicalOpcode();
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new VariableInstruction((byte) 'A')});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertTrue(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction2() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new VariableInstruction()});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert that nothing has changed
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction3() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new VariableInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert that nothing has changed
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction4() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction());

    // Assert that nothing has changed
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction5() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new VariableInstruction((byte) 'A')});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    VariableInstruction variableInstruction = mock(VariableInstruction.class);
    when(variableInstruction.canonicalOpcode()).thenReturn((byte) 'A');

    // Act
    instructionSequenceMatcher.visitVariableInstruction(
        clazz, method, codeAttribute, 2, variableInstruction);

    // Assert that nothing has changed
    verify(variableInstruction).canonicalOpcode();
    verify(constant).addProcessingFlags((int[]) Mockito.any());
    assertFalse(instructionSequenceMatcher.isMatching());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitConstantInstruction(Clazz, Method, CodeAttribute,
   * int, ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link SimpleProcessable#addProcessingFlags(int[])}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then calls addProcessingFlags(int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenCallsAddProcessingFlags() {
    // Arrange
    Constant constant = mock(Constant.class);
    doNothing().when(constant).addProcessingFlags((int[]) Mockito.any());
    constant.addProcessingFlags(2, 65, 2, 65);
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {constant}, new Instruction[] {new ConstantInstruction()});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceMatcher.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    verify(constant).addProcessingFlags((int[]) Mockito.any());
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction2() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction3() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction4() {
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
   * Test {@link InstructionSequenceMatcher#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();

    // Act
    instructionSequenceMatcher.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert that nothing has changed
    assertFalse(instructionSequenceMatcher.matchingConstant);
  }

  /**
   * Test {@link InstructionSequenceMatcher#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link InstructionSequenceMatcher#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InstructionSequenceMatcher.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LibraryClass clazz = new LibraryClass();
    PrimitiveArrayConstant primitiveArrayConstant = mock(PrimitiveArrayConstant.class);
    when(primitiveArrayConstant.contentEquals(Mockito.<PrimitiveArrayConstant>any()))
        .thenReturn(true);

    // Act
    instructionSequenceMatcher.visitPrimitiveArrayConstant(clazz, primitiveArrayConstant);

    // Assert
    verify(primitiveArrayConstant).contentEquals(isNull());
    assertTrue(instructionSequenceMatcher.matchingConstant);
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
  @DisplayName("Test matchingOpcodes(Instruction, Instruction); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingOpcodes(proguard.classfile.instruction.Instruction, proguard.classfile.instruction.Instruction)"
  })
  void testMatchingOpcodes_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingOpcodes(Instruction, Instruction); when BranchInstruction(byte, int) with opcode is one and branchOffset is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingOpcodes(proguard.classfile.instruction.Instruction, proguard.classfile.instruction.Instruction)"
  })
  void testMatchingOpcodes_whenBranchInstructionWithOpcodeIsOneAndBranchOffsetIsOne() {
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
  @DisplayName(
      "Test matchingOpcodes(Instruction, Instruction); when LookUpSwitchInstruction(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingOpcodes(proguard.classfile.instruction.Instruction, proguard.classfile.instruction.Instruction)"
  })
  void testMatchingOpcodes_whenLookUpSwitchInstruction_thenReturnFalse() {
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
  @DisplayName(
      "Test matchingOpcodes(Instruction, Instruction); when SimpleInstruction(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingOpcodes(proguard.classfile.instruction.Instruction, proguard.classfile.instruction.Instruction)"
  })
  void testMatchingOpcodes_whenSimpleInstruction_thenReturnFalse() {
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
  @DisplayName(
      "Test matchingOpcodes(Instruction, Instruction); when VariableInstruction(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingOpcodes(proguard.classfile.instruction.Instruction, proguard.classfile.instruction.Instruction)"
  })
  void testMatchingOpcodes_whenVariableInstruction_thenReturnFalse() {
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
  @DisplayName(
      "Test matchingArguments(int, int) with 'argument1', 'argument2'; when one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int, int)"
  })
  void testMatchingArgumentsWithArgument1Argument2_whenOne_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingArguments(int, int) with 'argument1', 'argument2'; when X; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int, int)"
  })
  void testMatchingArgumentsWithArgument1Argument2_whenX_thenReturnFalse() {
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
  @DisplayName(
      "Test matchingArguments(int, int) with 'argument1', 'argument2'; when X; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int, int)"
  })
  void testMatchingArgumentsWithArgument1Argument2_whenX_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingArguments(int[], int[]) with 'arguments1', 'arguments2'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int[], int[])"
  })
  void testMatchingArgumentsWithArguments1Arguments2_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingArguments(int[], int[]) with 'arguments1', 'arguments2'; when array of int with four and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int[], int[])"
  })
  void testMatchingArgumentsWithArguments1Arguments2_whenArrayOfIntWithFourAndZero() {
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
  @DisplayName(
      "Test matchingArguments(int[], int[]) with 'arguments1', 'arguments2'; when array of int with X and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int[], int[])"
  })
  void testMatchingArgumentsWithArguments1Arguments2_whenArrayOfIntWithXAndZero() {
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
  @DisplayName(
      "Test matchingArguments(int[], int[]) with 'arguments1', 'arguments2'; when empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingArguments(int[], int[])"
  })
  void testMatchingArgumentsWithArguments1Arguments2_whenEmptyArrayOfInt() {
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
  @DisplayName("Test matchingConstantIndices(Clazz, int, int); when X; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingConstantIndices(proguard.classfile.Clazz, int, int)"
  })
  void testMatchingConstantIndices_whenX_thenReturnTrue() {
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
  @DisplayName("Test matchingBranchOffsets(int, int, int); when two; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"
  })
  void testMatchingBranchOffsets_whenTwo_thenReturnTrue() {
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
  @DisplayName("Test matchingBranchOffsets(int, int, int); when X; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"
  })
  void testMatchingBranchOffsets_whenX_thenReturnFalse() {
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
  @DisplayName("Test matchingBranchOffsets(int, int, int); when X; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingBranchOffsets(int, int, int)"
  })
  void testMatchingBranchOffsets_whenX_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingJumpOffsets(int, int[], int[]); when array of int with four and zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"
  })
  void testMatchingJumpOffsets_whenArrayOfIntWithFourAndZero_thenReturnFalse() {
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
  @DisplayName(
      "Test matchingJumpOffsets(int, int[], int[]); when array of int with one and zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"
  })
  void testMatchingJumpOffsets_whenArrayOfIntWithOneAndZero_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingJumpOffsets(int, int[], int[]); when array of int with X and zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"
  })
  void testMatchingJumpOffsets_whenArrayOfIntWithXAndZero_thenReturnTrue() {
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
  @DisplayName(
      "Test matchingJumpOffsets(int, int[], int[]); when empty array of int; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.matchingJumpOffsets(int, int[], int[])"
  })
  void testMatchingJumpOffsets_whenEmptyArrayOfInt_thenReturnFalse() {
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
  @DisplayName("Test finalMatch(Clazz, Method, CodeAttribute, int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.InstructionSequenceMatcher.finalMatch(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testFinalMatch() {
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
