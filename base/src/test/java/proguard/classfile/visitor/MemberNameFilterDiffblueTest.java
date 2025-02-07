package proguard.classfile.visitor;

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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.BootstrapMethodsAttributeShrinker;
import proguard.classfile.editor.ConstantPoolShrinker;
import proguard.classfile.util.MethodLinker;
import proguard.util.StringMatcher;

class MemberNameFilterDiffblueTest {
  /**
   * Test {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsConstantPoolEntryAccept() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, new ConstantPoolShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(programField).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(programField).getName(isA(Clazz.class));
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMember#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsGetDescriptor() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    when(programField.getProcessingInfo()).thenReturn("Processing Info");
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programField.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programField).getDescriptor(isA(Clazz.class));
    verify(programField, atLeast(1)).getName(isA(Clazz.class));
    verify(programField, atLeast(1)).getProcessingInfo();
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsGetString() {
    // Arrange
    MemberNameFilter memberNameFilter =
        new MemberNameFilter("Regular Expression", new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    memberNameFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    when(programField.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programField).getName(isA(Clazz.class));
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsConstantPoolEntryAccept() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, new ConstantPoolShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMember#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetDescriptor() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberNameFilter memberNameFilter =
        new MemberNameFilter(regularExpressionMatcher, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberNameFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
    verify(regularExpressionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetString() {
    // Arrange
    MemberNameFilter memberNameFilter =
        new MemberNameFilter("Regular Expression", new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    memberNameFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link MemberNameFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberNameFilter memberNameFilter = new MemberNameFilter("", memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberNameFilter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MemberNameFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberNameFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberNameFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MemberNameFilter memberNameFilter = new MemberNameFilter("", memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberNameFilter.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
