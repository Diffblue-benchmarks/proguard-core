package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.util.CollectionMatcher;

class ClassConstantClassFilterDiffblueTest {
  /**
   * Test {@link ClassConstantClassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstantClassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls constantPoolEntriesAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassConstantClassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsConstantPoolEntriesAccept() {
    // Arrange
    ClassConstantClassFilter classConstantClassFilter =
        new ClassConstantClassFilter("Regular Expression", mock(ClassVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());

    // Act
    classConstantClassFilter.visitProgramClass(programClass);

    // Assert
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassConstantClassFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ClassConstantClassFilter classConstantClassFilter =
        new ClassConstantClassFilter("", mock(ClassVisitor.class));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classConstantClassFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given CollectionMatcher(Set) with set is HashSet(); then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassConstantClassFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenCollectionMatcherWithSetIsHashSet_thenCallsGetName() {
    // Arrange
    ClassConstantClassFilter classConstantClassFilter =
        new ClassConstantClassFilter(
            new CollectionMatcher(new HashSet<>()), mock(ClassVisitor.class));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classConstantClassFilter.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassConstantClassFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassConstantClassFilter classConstantClassFilter =
        new ClassConstantClassFilter("Regular Expression", mock(ClassVisitor.class));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classConstantClassFilter.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstantClassFilter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassConstantClassFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassConstantClassFilter classConstantClassFilter =
        new ClassConstantClassFilter("Regular Expression", mock(ClassVisitor.class));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classConstantClassFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }
}
