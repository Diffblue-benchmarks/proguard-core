package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.Member;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.ClassVisitor;

class ClassRenamerDiffblueTest {
  /**
   * Test {@link ClassRenamer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    when(classNameFunction.apply(Mockito.<Clazz>any())).thenReturn("Apply");
    ClassVisitor extraClassVisitor = mock(ClassVisitor.class);
    doNothing().when(extraClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassRenamer classRenamer =
        new ClassRenamer(classNameFunction, extraClassVisitor, new AttributeSorter());
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classRenamer.visitLibraryClass(libraryClass);

    // Assert
    verify(classNameFunction).apply(isA(Clazz.class));
    verify(extraClassVisitor).visitLibraryClass(isA(LibraryClass.class));
    assertEquals("Apply", libraryClass.getName());
  }

  /**
   * Test {@link ClassRenamer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with
   *       {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); given UnsupportedOperationException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenUnsupportedOperationExceptionWithFoo() {
    // Arrange
    new UnsupportedOperationException("foo");
    Function<Clazz, String> classNameFunction = mock(Function.class);
    when(classNameFunction.apply(Mockito.<Clazz>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    ClassRenamer classRenamer = new ClassRenamer(classNameFunction);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classRenamer.visitLibraryClass(new LibraryClass()));
    verify(classNameFunction).apply(isA(Clazz.class));
  }

  /**
   * Test {@link ClassRenamer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    when(classNameFunction.apply(Mockito.<Clazz>any())).thenReturn("Apply");
    ClassVisitor extraClassVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(extraClassVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());
    ClassRenamer classRenamer =
        new ClassRenamer(classNameFunction, extraClassVisitor, new AttributeSorter());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classRenamer.visitLibraryClass(new LibraryClass()));
    verify(classNameFunction).apply(isA(Clazz.class));
    verify(extraClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    ClassRenamer classRenamer = new ClassRenamer(mock(Function.class), memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    classRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Apply", libraryMember.name);
  }

  /**
   * Test {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember2() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    ClassVisitor extraClassVisitor = mock(ClassVisitor.class);
    ClassRenamer classRenamer =
        new ClassRenamer(classNameFunction, extraClassVisitor, new AttributeSorter());
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    classRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    assertEquals("Name", libraryMember.name);
  }

  /**
   * Test {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); given BiFunction apply(Object, Object) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember_givenBiFunctionApplyReturnNull() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn(null);
    ClassRenamer classRenamer = new ClassRenamer(mock(Function.class), memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    classRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Name", libraryMember.name);
  }

  /**
   * Test {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Given {@link ClassRenamer#ClassRenamer(Function)} with classNameFunction is {@link
   *       Function}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); given ClassRenamer(Function) with classNameFunction is Function")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember_givenClassRenamerWithClassNameFunctionIsFunction() {
    // Arrange
    ClassRenamer classRenamer = new ClassRenamer(mock(Function.class));
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    classRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    assertEquals("Name", libraryMember.name);
  }

  /**
   * Test {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember_thenThrowUnsupportedOperationException() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    ClassRenamer classRenamer = new ClassRenamer(mock(Function.class), memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classRenamer.visitLibraryMember(
                libraryClass, new LibraryField(1, "Name", "Descriptor")));
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
  }

  /**
   * Test {@link ClassRenamer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code null}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassRenamer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given Function apply(Object) return 'null'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassRenamer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenFunctionApplyReturnNull_thenCallsApply() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    when(classNameFunction.apply(Mockito.<Clazz>any())).thenReturn(null);
    ClassRenamer classRenamer = new ClassRenamer(classNameFunction);
    LibraryClass clazz = new LibraryClass();

    // Act
    classRenamer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(classNameFunction).apply(isA(Clazz.class));
  }
}
