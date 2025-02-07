package proguard.classfile.editor;

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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.MemberVisitor;

class MemberReferenceFixerDiffblueTest {
  /**
   * Test {@link MemberReferenceFixer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    memberReferenceFixer.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code (}.
   *   <li>Then calls {@link Member#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given '('; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenLeftParenthesis_thenCallsGetDescriptor() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("(");
    Member referencedMember = mock(Member.class);
    when(referencedMember.getDescriptor(Mockito.<Clazz>any())).thenReturn("(");

    // Act
    memberReferenceFixer.visitStringConstant(
        clazz, new StringConstant(1, new LibraryClass(), referencedMember));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
    verify(referencedMember).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given 'Name'; when LibraryClass getString(int) return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenName_whenLibraryClassGetStringReturnName() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("Name");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    memberReferenceFixer.visitStringConstant(
        clazz, new StringConstant(1, referencedClass, new LibraryField(1, "Name", "Descriptor")));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given 'String'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenString_thenThrowUnsupportedOperationException() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            memberReferenceFixer.visitStringConstant(
                clazz, new StringConstant(1, referencedClass, new ProgramField())));
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link LibraryClass#getName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given 'Descriptor'; then calls getName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenDescriptor_thenCallsGetName() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Descriptor");
    when(clazz.getName(anyInt())).thenReturn("Name");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    memberReferenceFixer.visitFieldrefConstant(
        clazz,
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")));

    // Assert
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            memberReferenceFixer.visitFieldrefConstant(
                clazz, new FieldrefConstant(1, 1, referencedClass, new ProgramField())));
  }

  /**
   * Test {@link MemberReferenceFixer#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    when(clazz.getType(anyInt())).thenReturn("Descriptor");
    when(clazz.getName(anyInt())).thenReturn("Name");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    memberReferenceFixer.visitInterfaceMethodrefConstant(
        clazz,
        new InterfaceMethodrefConstant(
            1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            memberReferenceFixer.visitInterfaceMethodrefConstant(
                clazz, new InterfaceMethodrefConstant(1, 1, referencedClass, new ProgramMethod())));
  }

  /**
   * Test {@link MemberReferenceFixer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Descriptor'; then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenDescriptor_thenCallsConstantPoolEntryAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    when(clazz.getType(anyInt())).thenReturn("Descriptor");
    when(clazz.getName(anyInt())).thenReturn("Name");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    memberReferenceFixer.visitMethodrefConstant(
        clazz,
        new MethodrefConstant(1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            memberReferenceFixer.visitMethodrefConstant(
                clazz, new MethodrefConstant(1, 1, referencedClass, new ProgramMethod())));
  }

  /**
   * Test {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    memberReferenceFixer.visitClassConstant(clazz, new ClassConstant(1, new LibraryClass()));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenEmptyString() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("");

    // Act
    memberReferenceFixer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    memberReferenceFixer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; when LibraryClass getString(int) return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_whenLibraryClassGetStringReturnString() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    memberReferenceFixer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link MemberReferenceFixer#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    memberReferenceFixer.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAttributesAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .attributesAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    memberReferenceFixer.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    memberReferenceFixer.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    memberReferenceFixer.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    memberReferenceFixer.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    memberReferenceFixer.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    memberReferenceFixer.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link MemberReferenceFixer#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayElementValue#elementValuesAccept(Clazz, Annotation,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberReferenceFixer#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then calls elementValuesAccept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberReferenceFixer.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenCallsElementValuesAccept() {
    // Arrange
    MemberReferenceFixer memberReferenceFixer = new MemberReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = mock(ArrayElementValue.class);
    doNothing()
        .when(arrayElementValue)
        .elementValuesAccept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());

    // Act
    memberReferenceFixer.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    verify(arrayElementValue)
        .elementValuesAccept(
            isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }
}
