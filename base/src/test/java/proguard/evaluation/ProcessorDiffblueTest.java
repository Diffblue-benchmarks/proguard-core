package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.evaluation.exception.ArrayIndexOutOfBounds;
import proguard.evaluation.value.BasicValueFactory;

class ProcessorDiffblueTest {
  /**
   * Test {@link Processor#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitSimpleInstruction(
                clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A')));
  }

  /**
   * Test {@link Processor#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitConstantInstruction(Clazz, Method, CodeAttribute,
   * int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitConstantInstruction(
                clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link Processor#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) -123;
    variableInstruction.variableIndex = 0;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitVariableInstruction(
                clazz, method, codeAttribute, 2, variableInstruction));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction() {
    // Arrange
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branch(Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt());
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    processor.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -89, 1));

    // Assert
    verify(branchUnit).branch(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(3));
    verify(branchUnit)
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(5), eq(0));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction2() {
    // Arrange
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branch(Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt());
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    processor.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -88, 1));

    // Assert
    verify(branchUnit).branch(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(3));
    verify(branchUnit)
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(5), eq(0));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction3() {
    // Arrange
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branch(Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt());
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    processor.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -56, 1));

    // Assert
    verify(branchUnit).branch(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(3));
    verify(branchUnit)
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(7), eq(0));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link BranchInstruction} {@link BranchInstruction#length(int)} return three.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); given three; when BranchInstruction length(int) return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_givenThree_whenBranchInstructionLengthReturnThree() {
    // Arrange
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    BranchInstruction branchInstruction = mock(BranchInstruction.class);
    when(branchInstruction.length(anyInt())).thenReturn(3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> processor.visitBranchInstruction(clazz, method, codeAttribute, 2, branchInstruction));
    verify(branchInstruction).length(eq(2));
    verify(branchUnit)
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(5), eq(0));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link ArrayIndexOutOfBounds}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw ArrayIndexOutOfBounds")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowArrayIndexOutOfBounds() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    BranchInstruction branchInstruction = mock(BranchInstruction.class);
    when(branchInstruction.length(anyInt())).thenThrow(new ArrayIndexOutOfBounds(1, 5));

    // Act and Assert
    assertThrows(
        ArrayIndexOutOfBounds.class,
        () -> processor.visitBranchInstruction(clazz, method, codeAttribute, 2, branchInstruction));
    verify(branchInstruction).length(eq(2));
  }

  /**
   * Test {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   * int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
    verify(branchUnit)
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), eq(5), eq(0));
  }

  /**
   * Test {@link Processor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * TableSwitchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link BranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitTableSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction); then calls branchConditionally(Clazz, CodeAttribute, int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitTableSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testVisitTableSwitchInstruction_thenCallsBranchConditionally() {
    // Arrange
    Stack stack = mock(Stack.class);
    when(stack.ipop()).thenReturn(BasicValueFactory.INTEGER_VALUE);
    BranchUnit branchUnit = mock(BranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    processor.visitTableSwitchInstruction(
        clazz,
        method,
        codeAttribute,
        2,
        new TableSwitchInstruction((byte) 'A', 5, 5, 5, new int[] {5, 1, 5, 1}));

    // Assert
    verify(branchUnit, atLeast(1))
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), anyInt(), eq(0));
    verify(stack).ipop();
  }

  /**
   * Test {@link Processor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * LookUpSwitchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link BranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitLookUpSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction); then calls branchConditionally(Clazz, CodeAttribute, int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.Processor.visitLookUpSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testVisitLookUpSwitchInstruction_thenCallsBranchConditionally() {
    // Arrange
    Stack stack = mock(Stack.class);
    when(stack.ipop()).thenReturn(BasicValueFactory.INTEGER_VALUE);
    BranchUnit branchUnit = mock(BranchUnit.class);
    doNothing()
        .when(branchUnit)
        .branchConditionally(
            Mockito.<Clazz>any(), Mockito.<CodeAttribute>any(), anyInt(), anyInt(), anyInt());
    Variables variables = new Variables(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    processor.visitLookUpSwitchInstruction(
        clazz,
        method,
        codeAttribute,
        2,
        new LookUpSwitchInstruction((byte) 'A', 5, new int[] {5, 1, 5, 1}, new int[] {5, 1, 5, 1}));

    // Assert
    verify(branchUnit, atLeast(1))
        .branchConditionally(isA(Clazz.class), isA(CodeAttribute.class), eq(2), anyInt(), eq(0));
    verify(stack).ipop();
  }
}
