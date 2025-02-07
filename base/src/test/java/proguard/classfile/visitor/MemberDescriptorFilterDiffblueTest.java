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

class MemberDescriptorFilterDiffblueTest {
  /**
   * Test {@link MemberDescriptorFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsConstantPoolEntryAccept() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(regularExpressionMatcher, new ConstantPoolShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(programField).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(programField).getDescriptor(isA(Clazz.class));
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMember#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField); then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsGetName() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(regularExpressionMatcher, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    when(programField.getProcessingInfo()).thenReturn("Processing Info");
    when(programField.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programField, atLeast(1)).getDescriptor(isA(Clazz.class));
    verify(programField).getName(isA(Clazz.class));
    verify(programField, atLeast(1)).getProcessingInfo();
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsGetString() {
    // Arrange
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter("Regular Expression", new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    memberDescriptorFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(regularExpressionMatcher, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramField(programClass, programField);

    // Assert
    verify(programField).getDescriptor(isA(Clazz.class));
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(
            regularExpressionMatcher, new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsConstantPoolEntryAccept() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(regularExpressionMatcher, new ConstantPoolShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMember#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetName() {
    // Arrange
    StringMatcher regularExpressionMatcher = mock(StringMatcher.class);
    when(regularExpressionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter(regularExpressionMatcher, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    memberDescriptorFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod, atLeast(1)).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
    verify(regularExpressionMatcher).matches(eq("Descriptor"));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetString() {
    // Arrange
    MemberDescriptorFilter memberDescriptorFilter =
        new MemberDescriptorFilter("Regular Expression", new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    memberDescriptorFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberDescriptorFilter memberDescriptorFilter = new MemberDescriptorFilter("", memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberDescriptorFilter.visitLibraryField(
        libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MemberDescriptorFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberDescriptorFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberDescriptorFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MemberDescriptorFilter memberDescriptorFilter = new MemberDescriptorFilter("", memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberDescriptorFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
