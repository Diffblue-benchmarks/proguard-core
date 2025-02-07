package proguard.normalize;

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
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;

class LargeStringSplitterDiffblueTest {
  /**
   * Test {@link LargeStringSplitter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link LargeStringSplitter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.normalize.LargeStringSplitter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LargeStringSplitter largeStringSplitter =
        new LargeStringSplitter(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    largeStringSplitter.visitProgramClass(programClass);

    // Assert
    verify(programClass).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link LargeStringSplitter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link LargeStringSplitter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given 'String'; when LibraryClass; then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.normalize.LargeStringSplitter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenString_whenLibraryClass_thenCallsGetString() {
    // Arrange
    LargeStringSplitter largeStringSplitter =
        new LargeStringSplitter(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    largeStringSplitter.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
  }

  /**
   * Test {@link LargeStringSplitter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link LargeStringSplitter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when LibraryClass getString(int) return 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.normalize.LargeStringSplitter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenLibraryClassGetStringReturnString_thenCallsGetString() {
    // Arrange
    LargeStringSplitter largeStringSplitter =
        new LargeStringSplitter(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    largeStringSplitter.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }
}
