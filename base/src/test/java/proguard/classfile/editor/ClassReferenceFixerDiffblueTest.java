package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.InnerClassesInfoVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.testutils.cpa.NamedClass;

class ClassReferenceFixerDiffblueTest {
  /**
   * Test {@link ClassReferenceFixer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceFixer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    classReferenceFixer.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#fieldsAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then calls fieldsAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsFieldsAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    classReferenceFixer.visitLibraryClass(libraryClass);

    // Assert
    verify(libraryClass).fieldsAccept(isA(MemberVisitor.class));
    verify(libraryClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitProgramField(
        programClass, new ProgramField(1, 1, 1, new LibraryClass()));

    // Assert
    verify(programClass).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramField#attributesAccept(ProgramClass, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given 'Descriptor'; when ProgramClass; then calls attributesAccept(ProgramClass, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenDescriptor_whenProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceFixer.visitProgramField(programClass, programField);

    // Assert
    verify(programField).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
    verify(programField).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitProgramMethod(
        programClass, new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(programClass).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramMember#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'Descriptor'; when ProgramClass; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenDescriptor_whenProgramClass_thenCallsGetDescriptor() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceFixer.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code Name}.
   *   <li>Then calls {@link Clazz#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when LibraryClass getString(int) return 'Name'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenLibraryClassGetStringReturnName_thenCallsGetName() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("Name");
    Clazz referencedClass = mock(Clazz.class);
    when(referencedClass.getName()).thenReturn("Name");

    // Act
    classReferenceFixer.visitStringConstant(clazz, new StringConstant(1, referencedClass, null));

    // Assert
    verify(referencedClass).getName();
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link DynamicConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); given 'Type'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_givenType_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    DynamicConstant dynamicConstant = mock(DynamicConstant.class);
    when(dynamicConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classReferenceFixer.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    verify(dynamicConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   *   <li>Then calls {@link LibraryClass#getType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); when LibraryClass getType(int) return 'Type'; then calls getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_whenLibraryClassGetTypeReturnType_thenCallsGetType() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    classReferenceFixer.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link InvokeDynamicConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); given 'Type'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_givenType_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    InvokeDynamicConstant invokeDynamicConstant = mock(InvokeDynamicConstant.class);
    when(invokeDynamicConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classReferenceFixer.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    verify(invokeDynamicConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsGetType() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    classReferenceFixer.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("Name");
    ProgramClass referencedClass = mock(ProgramClass.class);
    when(referencedClass.getName()).thenReturn("Name");

    // Act
    classReferenceFixer.visitClassConstant(clazz, new ClassConstant(1, referencedClass));

    // Assert
    verify(clazz).getString(eq(1));
    verify(referencedClass).getName();
  }

  /**
   * Test {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitMethodTypeConstant(
        clazz, new MethodTypeConstant(1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link MethodTypeConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'Type'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenType_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classReferenceFixer.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    classReferenceFixer.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InnerClassesAttribute#innerClassEntriesAccept(Clazz,
   *       InnerClassesInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls innerClassEntriesAccept(Clazz, InnerClassesInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsInnerClassEntriesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    doNothing()
        .when(innerClassesAttribute)
        .innerClassEntriesAccept(Mockito.<Clazz>any(), Mockito.<InnerClassesInfoVisitor>any());

    // Act
    classReferenceFixer.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(innerClassesAttribute)
        .innerClassEntriesAccept(isA(Clazz.class), isA(InnerClassesInfoVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link SignatureAttribute#getSignature(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getSignature(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetSignature() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceFixer.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(signatureAttribute).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classReferenceFixer.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classReferenceFixer.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    classReferenceFixer.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo); then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_thenCallsGetClassName() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceFixer.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    verify(clazz).getClassName(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link LocalVariableInfo#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'Descriptor'; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenDescriptor_thenCallsGetDescriptor() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceFixer.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classReferenceFixer.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code Signature}.
   *   <li>Then calls {@link LocalVariableTypeInfo#getSignature(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'Signature'; then calls getSignature(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenSignature_thenCallsGetSignature() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = mock(LocalVariableTypeInfo.class);
    when(localVariableTypeInfo.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceFixer.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    verify(localVariableTypeInfo).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classReferenceFixer.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceFixer.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceFixer#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given 'Type'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenType_thenCallsElementValuesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classReferenceFixer.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classReferenceFixer.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Type Name}.
   *   <li>Then calls {@link EnumConstantElementValue#getTypeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'Type Name'; then calls getTypeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenTypeName_thenCallsGetTypeName() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = mock(EnumConstantElementValue.class);
    when(enumConstantElementValue.getTypeName(Mockito.<Clazz>any())).thenReturn("Type Name");

    // Act
    classReferenceFixer.visitEnumConstantElementValue(clazz, annotation, enumConstantElementValue);

    // Assert
    verify(enumConstantElementValue).getTypeName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassElementValue#getClassName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'Class Name'; when LibraryClass; then calls getClassName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenClassName_whenLibraryClass_thenCallsGetClassName() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = mock(ClassElementValue.class);
    when(classElementValue.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act
    classReferenceFixer.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    verify(classElementValue).getClassName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classReferenceFixer.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceFixer#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classReferenceFixer.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayElementValue#elementValuesAccept(Clazz, Annotation,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then calls elementValuesAccept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassReferenceFixer.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenCallsElementValuesAccept() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = mock(ArrayElementValue.class);
    doNothing()
        .when(arrayElementValue)
        .elementValuesAccept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classReferenceFixer.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    verify(arrayElementValue)
        .elementValuesAccept(
            isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @DisplayName("Test shortKotlinNestedClassName(String, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.shortKotlinNestedClassName(java.lang.String, java.lang.String, proguard.classfile.Clazz)"
  })
  void testShortKotlinNestedClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", new LibraryClass(91, "$", "$")));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@link NamedClass#NamedClass(String)} with memberName is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @DisplayName(
      "Test shortKotlinNestedClassName(String, String, Clazz); when NamedClass(String) with memberName is '$'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.shortKotlinNestedClassName(java.lang.String, java.lang.String, proguard.classfile.Clazz)"
  })
  void testShortKotlinNestedClassName_whenNamedClassWithMemberNameIsDollarSign() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", new NamedClass("$")));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Short Inner Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @DisplayName(
      "Test shortKotlinNestedClassName(String, String, Clazz); when 'null'; then return 'Short Inner Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.shortKotlinNestedClassName(java.lang.String, java.lang.String, proguard.classfile.Clazz)"
  })
  void testShortKotlinNestedClassName_whenNull_thenReturnShortInnerClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "Short Inner Class Name",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", null));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName("Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses() {
    // Arrange, Act and Assert
    assertEquals(
        "Unexpected error while updating descriptor:",
        ClassReferenceFixer.newDescriptor(
            "Unexpected error while updating descriptor:", new Clazz[] {null}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_thenReturnDescriptor() {
    // Arrange, Act and Assert
    assertEquals(
        "Descriptor",
        ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_thenReturnDescriptor2() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", null));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code LMember Name;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return 'LMember Name;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLMemberName() {
    // Arrange, Act and Assert
    assertEquals(
        "LMember Name;",
        ClassReferenceFixer.newDescriptor(
            "Lkotlin/jvm/JvmName;", new Clazz[] {new NamedClass("Member Name")}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Lkotlin/jvm/JvmName;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return 'Lkotlin/jvm/JvmName;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLkotlinJvmJvmName() {
    // Arrange, Act and Assert
    assertEquals(
        "Lkotlin/jvm/JvmName;",
        ClassReferenceFixer.newDescriptor("Lkotlin/jvm/JvmName;", new Clazz[] {null}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Lnull;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return 'Lnull;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLnull() {
    // Arrange, Act and Assert
    assertEquals(
        "Lnull;",
        ClassReferenceFixer.newDescriptor(
            "Lkotlin/jvm/JvmName;", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>When empty array of {@link Clazz}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test newDescriptor(String, Clazz[]) with 'descriptor', 'referencedClasses'; when empty array of Clazz")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.editor.ClassReferenceFixer.newDescriptor(java.lang.String, proguard.classfile.Clazz[])"
  })
  void testNewDescriptorWithDescriptorReferencedClasses_whenEmptyArrayOfClazz() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[] {}));
  }
}
