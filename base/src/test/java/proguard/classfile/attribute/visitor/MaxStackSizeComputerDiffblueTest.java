package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer.StackSizeConsumer;
import proguard.classfile.exception.NegativeStackSizeException;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.exception.ProguardCoreException;
import proguard.exception.ProguardCoreException.Builder;

class MaxStackSizeComputerDiffblueTest {
  /**
   * Test {@link MaxStackSizeComputer#MaxStackSizeComputer()}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#MaxStackSizeComputer()}
   */
  @Test
  @DisplayName("Test new MaxStackSizeComputer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.attribute.visitor.MaxStackSizeComputer.<init>()"})
  void testNewMaxStackSizeComputer() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer = new MaxStackSizeComputer();

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    assertEquals(8096, actualMaxStackSizeComputer.evaluated.length);
  }

  /**
   * Test {@link MaxStackSizeComputer#MaxStackSizeComputer(StackSizeConsumer)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#MaxStackSizeComputer(StackSizeConsumer)}
   */
  @Test
  @DisplayName("Test new MaxStackSizeComputer(StackSizeConsumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.<init>(proguard.classfile.attribute.visitor.MaxStackSizeComputer$StackSizeConsumer)"
  })
  void testNewMaxStackSizeComputer2() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer =
        new MaxStackSizeComputer(mock(StackSizeConsumer.class));

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    assertEquals(8096, actualMaxStackSizeComputer.evaluated.length);
  }

  /**
   * Test {@link MaxStackSizeComputer#isReachable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#isReachable(int)}
   */
  @Test
  @DisplayName("Test isReachable(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.visitor.MaxStackSizeComputer.isReachable(int)"
  })
  void testIsReachable_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MaxStackSizeComputer()).isReachable(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaxStackSizeComputer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link MaxStackSizeComputer#getMaxStackSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.visitor.MaxStackSizeComputer.getMaxStackSize()",
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testGettersAndSetters() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();

    // Act
    maxStackSizeComputer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, maxStackSizeComputer.getMaxStackSize());
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-60, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute5() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-124, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Error Parameters}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given array of Object with 'Error Parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenArrayOfObjectWithErrorParameters() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    doThrow(buildResult).when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1})));
    verify(stackSizeConsumer).accept(eq(0), eq(0), eq(1));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link StackSizeConsumer} {@link StackSizeConsumer#accept(int, int, int)} does
   *       nothing.
   *   <li>Then calls {@link StackSizeConsumer#accept(int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given StackSizeConsumer accept(int, int, int) does nothing; then calls accept(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenStackSizeConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1})));
    verify(stackSizeConsumer, atLeast(1)).accept(anyInt(), anyInt(), anyInt());
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link StackSizeConsumer#accept(int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then calls accept(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenCallsAccept() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
    verify(stackSizeConsumer).accept(eq(3), eq(0), eq(1));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link StackSizeConsumer#accept(int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then calls accept(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenCallsAccept2() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 0, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
    verify(stackSizeConsumer).accept(eq(3), eq(0), eq(0));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link StackSizeConsumer#accept(int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then calls accept(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenCallsAccept3() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', -124, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
    verify(stackSizeConsumer).accept(eq(3), eq(0), eq(0));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowNegativeStackSizeException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowNegativeStackSizeException2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer =
        new MaxStackSizeComputer(mock(StackSizeConsumer.class));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', -60, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowProguardCoreException() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    doThrow(buildResult).when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
    verify(stackSizeConsumer).accept(eq(3), eq(0), eq(1));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction2() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAAAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); when 'A'; then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); when 'A'; then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', -60, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); when 'A'; then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer =
        new MaxStackSizeComputer(mock(StackSizeConsumer.class));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -60, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo2() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -124, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
    verify(stackSizeConsumer).accept(eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Given {@link StackSizeConsumer} {@link StackSizeConsumer#accept(int, int, int)} does
   *       nothing.
   *   <li>Then calls {@link StackSizeConsumer#accept(int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); given StackSizeConsumer accept(int, int, int) does nothing; then calls accept(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_givenStackSizeConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);
    doNothing().when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
    verify(stackSizeConsumer, atLeast(1)).accept(anyInt(), anyInt(), anyInt());
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then throw NegativeStackSizeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenThrowNegativeStackSizeException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MaxStackSizeComputer.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenThrowProguardCoreException() {
    // Arrange
    StackSizeConsumer stackSizeConsumer = mock(StackSizeConsumer.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    doThrow(buildResult).when(stackSizeConsumer).accept(anyInt(), anyInt(), anyInt());
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer(stackSizeConsumer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
    verify(stackSizeConsumer).accept(eq(1), eq(1), eq(2));
  }
}
