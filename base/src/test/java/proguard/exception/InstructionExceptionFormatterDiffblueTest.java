package proguard.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.evaluation.TracedStack;
import proguard.evaluation.TracedVariables;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;
import proguard.exception.ProguardCoreException.Builder;
import proguard.util.CircularIntBuffer;

class InstructionExceptionFormatterDiffblueTest {
  /**
   * Test {@link InstructionExceptionFormatter#registerInstructionOffset(int)}.
   *
   * <ul>
   *   <li>Then calls {@link CircularIntBuffer#push(int)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionExceptionFormatter#registerInstructionOffset(int)}
   */
  @Test
  @DisplayName("Test registerInstructionOffset(int); then calls push(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.registerInstructionOffset(int)"
  })
  void testRegisterInstructionOffset_thenCallsPush() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    doNothing().when(offsetBuffer).push(anyInt());
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();

    // Act
    (new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor")))
        .registerInstructionOffset(2);

    // Assert
    verify(offsetBuffer).push(eq(2));
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException)} with {@code
   * exception}.
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException)}
   */
  @Test
  @DisplayName("Test printException(ProguardCoreException) with 'exception'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException)"
  })
  void testPrintExceptionWithException() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            null,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Act
    instructionExceptionFormatter.printException(
        new ProguardCoreException(1, "An error occurred", "Error Parameters"));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException)} with {@code
   * exception}.
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException)}
   */
  @Test
  @DisplayName("Test printException(ProguardCoreException) with 'exception'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException)"
  })
  void testPrintExceptionWithException2() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log, offsetBuffer, code, new LibraryClass(), null);

    // Act
    instructionExceptionFormatter.printException(
        new ProguardCoreException(1, "An error occurred", "Error Parameters"));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            null,
            new LibraryMethod(1, "Name", "Descriptor"));
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    TracedVariables variables = new TracedVariables(3);

    // Act
    instructionExceptionFormatter.printException(exception, variables, new TracedStack(3));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack2() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log, offsetBuffer, code, new LibraryClass(), null);
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    TracedVariables variables = new TracedVariables(3);

    // Act
    instructionExceptionFormatter.printException(exception, variables, new TracedStack(3));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <ul>
   *   <li>Then calls {@link CircularIntBuffer#peek()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'; then calls peek()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack_thenCallsPeek()
      throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    TracedVariables variables = new TracedVariables(3);

    // Act
    instructionExceptionFormatter.printException(exception, variables, new TracedStack(3));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'; then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack_thenThrowProguardCoreException()
      throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(offsetBuffer.peek(anyInt())).thenThrow(buildResult);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    TracedVariables variables = new TracedVariables(3);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            instructionExceptionFormatter.printException(exception, variables, new TracedStack(3)));
    verify(offsetBuffer).peek();
    verify(offsetBuffer).peek(eq(2));
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link CircularIntBuffer#peek()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'; when 'null'; then calls peek()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack_whenNull_thenCallsPeek()
      throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    // Act
    instructionExceptionFormatter.printException(exception, null, new TracedStack(3));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException,
   * TracedVariables, TracedStack)} with {@code exception}, {@code variables}, {@code stack}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link CircularIntBuffer#peek()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException, TracedVariables,
   * TracedStack)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException, TracedVariables, TracedStack) with 'exception', 'variables', 'stack'; when 'null'; then calls peek()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack)"
  })
  void testPrintExceptionWithExceptionVariablesStack_whenNull_thenCallsPeek2()
      throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));
    ProguardCoreException exception =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    // Act
    instructionExceptionFormatter.printException(exception, new TracedVariables(3), null);

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException)} with {@code
   * exception}.
   *
   * <ul>
   *   <li>Then calls {@link CircularIntBuffer#peek()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException)}
   */
  @Test
  @DisplayName("Test printException(ProguardCoreException) with 'exception'; then calls peek()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException)"
  })
  void testPrintExceptionWithException_thenCallsPeek() throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);
    when(offsetBuffer.peek(anyInt())).thenReturn(2);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Act
    instructionExceptionFormatter.printException(
        new ProguardCoreException(1, "An error occurred", "Error Parameters"));

    // Assert
    verify(offsetBuffer, atLeast(1)).peek();
    verify(offsetBuffer, atLeast(1)).peek(anyInt());
    verify(offsetBuffer).size();
  }

  /**
   * Test {@link InstructionExceptionFormatter#printException(ProguardCoreException)} with {@code
   * exception}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionExceptionFormatter#printException(ProguardCoreException)}
   */
  @Test
  @DisplayName(
      "Test printException(ProguardCoreException) with 'exception'; then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.exception.InstructionExceptionFormatter.printException(proguard.exception.ProguardCoreException)"
  })
  void testPrintExceptionWithException_thenThrowProguardCoreException()
      throws UnsupportedEncodingException {
    // Arrange
    CircularIntBuffer offsetBuffer = mock(CircularIntBuffer.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(offsetBuffer.peek(anyInt())).thenThrow(buildResult);
    when(offsetBuffer.peek()).thenReturn(2);
    when(offsetBuffer.size()).thenReturn(3);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");
    LibraryClass clazz = new LibraryClass();
    InstructionExceptionFormatter instructionExceptionFormatter =
        new InstructionExceptionFormatter(
            ReflectiveModel.log,
            offsetBuffer,
            code,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            instructionExceptionFormatter.printException(
                new ProguardCoreException(1, "An error occurred", "Error Parameters")));
    verify(offsetBuffer).peek();
    verify(offsetBuffer).peek(eq(2));
    verify(offsetBuffer).size();
  }
}
