package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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

class StackSizeComputerDiffblueTest {
  /**
   * Test new {@link StackSizeComputer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StackSizeComputer}
   */
  @Test
  @DisplayName("Test new StackSizeComputer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.attribute.visitor.StackSizeComputer.<init>()"})
  void testNewStackSizeComputer() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }

  /**
   * Test {@link StackSizeComputer#isReachable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#isReachable(int)}
   */
  @Test
  @DisplayName("Test isReachable(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.visitor.StackSizeComputer.isReachable(int)"
  })
  void testIsReachable_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StackSizeComputer()).isReachable(1));
  }

  /**
   * Test {@link StackSizeComputer#getStackSizeBefore(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#getStackSizeBefore(int)}
   */
  @Test
  @DisplayName("Test getStackSizeBefore(int); when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.visitor.StackSizeComputer.getStackSizeBefore(int)"
  })
  void testGetStackSizeBefore_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeBefore(1));
  }

  /**
   * Test {@link StackSizeComputer#getStackSizeAfter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#getStackSizeAfter(int)}
   */
  @Test
  @DisplayName("Test getStackSizeAfter(int); when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.visitor.StackSizeComputer.getStackSizeAfter(int)"
  })
  void testGetStackSizeAfter_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeAfter(1));
  }

  /**
   * Test {@link StackSizeComputer#getMaxStackSize()}.
   *
   * <p>Method under test: {@link StackSizeComputer#getMaxStackSize()}
   */
  @Test
  @DisplayName("Test getMaxStackSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.visitor.StackSizeComputer.getMaxStackSize()"
  })
  void testGetMaxStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }

  /**
   * Test {@link StackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@link CodeAttribute} {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   *       does nothing.
   *   <li>Then calls {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when CodeAttribute accept(Clazz, Method, AttributeVisitor) does nothing; then calls accept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.StackSizeComputer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenCodeAttributeAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    StackSizeComputer stackSizeComputer = new StackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .accept(Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    stackSizeComputer.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).accept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }
}
