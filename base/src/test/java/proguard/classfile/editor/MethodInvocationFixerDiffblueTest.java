package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;

class MethodInvocationFixerDiffblueTest {
  /**
   * Test {@link MethodInvocationFixer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link MethodInvocationFixer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); given 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodInvocationFixer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_givenClassName() {
    // Arrange
    MethodInvocationFixer methodInvocationFixer = new MethodInvocationFixer();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    methodInvocationFixer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(clazz).getClassName(eq(0));
  }

  /**
   * Test {@link MethodInvocationFixer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodInvocationFixer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodInvocationFixer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_givenEmptyString() {
    // Arrange
    MethodInvocationFixer methodInvocationFixer = new MethodInvocationFixer();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    when(clazz.getClassName(anyInt())).thenReturn("");

    // Act
    methodInvocationFixer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(clazz).getClassName(eq(0));
  }
}
