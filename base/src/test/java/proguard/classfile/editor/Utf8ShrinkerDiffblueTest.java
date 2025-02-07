package proguard.classfile.editor;

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
import proguard.classfile.Field;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.DeprecatedAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionsAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LineNumberTableAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;
import proguard.classfile.attribute.MethodParametersAttribute;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.NestMembersAttribute;
import proguard.classfile.attribute.ParameterInfo;
import proguard.classfile.attribute.PermittedSubclassesAttribute;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDebugExtensionAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.SyntheticAttribute;
import proguard.classfile.attribute.UnknownAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.ConstantElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.module.ModuleAttribute;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.ModulePackagesAttribute;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.InnerClassesInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableTypeInfoVisitor;
import proguard.classfile.attribute.visitor.ParameterInfoVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.StringConstant;

class Utf8ShrinkerDiffblueTest {
  /**
   * Test {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitProgramMember(programClass, new ProgramField());

    // Assert
    verify(programClass, atLeast(1)).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>When {@link ProgramMethod#ProgramMethod()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); given ClassConstant(); when ProgramMethod(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_givenClassConstant_whenProgramMethod_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitProgramMember(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMember#attributesAccept(ProgramClass, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then calls attributesAccept(ProgramClass, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenCallsAttributesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getConstant(anyInt())).thenReturn(new ClassConstant());
    ProgramMember programMember = mock(ProgramMember.class);
    doNothing()
        .when(programMember)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());

    // Act
    utf8Shrinker.visitProgramMember(programClass, programMember);

    // Assert
    verify(programClass, atLeast(1)).getConstant(eq(0));
    verify(programMember).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitSourceDebugExtensionAttribute(clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitRecordAttribute(clazz, new RecordAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    utf8Shrinker.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InnerClassesAttribute#innerClassEntriesAccept(Clazz,
   *       InnerClassesInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls innerClassEntriesAccept(Clazz, InnerClassesInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsInnerClassEntriesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    doNothing()
        .when(innerClassesAttribute)
        .innerClassEntriesAccept(Mockito.<Clazz>any(), Mockito.<InnerClassesInfoVisitor>any());

    // Act
    utf8Shrinker.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(innerClassesAttribute)
        .innerClassEntriesAccept(isA(Clazz.class), isA(InnerClassesInfoVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitPermittedSubclassesAttribute(clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with {@code
   * clazz}, {@code deprecatedAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'; then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'; then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitMethodParametersAttribute(clazz, method, new MethodParametersAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodParametersAttribute#parametersAccept(Clazz, Method,
   *       ParameterInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls parametersAccept(Clazz, Method, ParameterInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsParametersAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = mock(MethodParametersAttribute.class);
    doNothing()
        .when(methodParametersAttribute)
        .parametersAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ParameterInfoVisitor>any());

    // Act
    utf8Shrinker.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(methodParametersAttribute)
        .parametersAccept(isA(Clazz.class), isA(Method.class), isA(ParameterInfoVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAttributesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .attributesAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    utf8Shrinker.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        mock(LocalVariableTableAttribute.class);
    doNothing()
        .when(localVariableTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableInfoVisitor>any());

    // Act
    utf8Shrinker.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(localVariableTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableInfoVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTypeTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableTypeInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableTypeInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        mock(LocalVariableTypeTableAttribute.class);
    doNothing()
        .when(localVariableTypeTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeInfoVisitor>any());

    // Act
    utf8Shrinker.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(localVariableTypeTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeInfoVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitAnyAnnotationsAttribute(clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    AnnotationsAttribute annotationsAttribute = mock(AnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    utf8Shrinker.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ParameterAnnotationsAttribute#annotationsAccept(Clazz, Method,
   *       AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute); then calls annotationsAccept(Clazz, Method, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnyParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ParameterAnnotationsAttribute parameterAnnotationsAttribute =
        mock(ParameterAnnotationsAttribute.class);
    doNothing()
        .when(parameterAnnotationsAttribute)
        .annotationsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationVisitor>any());

    // Act
    utf8Shrinker.visitAnyParameterAnnotationsAttribute(
        clazz, method, parameterAnnotationsAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(parameterAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(Method.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnyParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitAnyParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    utf8Shrinker.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitRecordComponentInfo(clazz, new RecordComponentInfo());

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    utf8Shrinker.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(0));
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName(
      "Test visitParameterInfo(Clazz, Method, int, ParameterInfo); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    utf8Shrinker.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    utf8Shrinker.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    utf8Shrinker.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    utf8Shrinker.visitAnnotation(clazz, annotation);

    // Assert
    verify(clazz).getConstant(eq(0));
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();

    // Act
    utf8Shrinker.visitConstantElementValue(clazz, annotation, new ConstantElementValue('s'));

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link Utf8Shrinker#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();

    // Act
    utf8Shrinker.visitConstantElementValue(clazz, annotation, new ConstantElementValue('s', 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();

    // Act
    utf8Shrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();

    // Act
    utf8Shrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getConstant(eq(1));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();

    // Act
    utf8Shrinker.visitAnnotationElementValue(
        clazz, annotation, new AnnotationElementValue(1, new Annotation()));

    // Assert
    verify(clazz, atLeast(1)).getConstant(anyInt());
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsElementValuesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    Annotation annotation = new Annotation();
    Annotation annotationValue = mock(Annotation.class);
    doNothing()
        .when(annotationValue)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    utf8Shrinker.visitAnnotationElementValue(
        clazz, annotation, new AnnotationElementValue(1, annotationValue));

    // Assert
    verify(clazz, atLeast(1)).getConstant(anyInt());
    verify(annotationValue).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); when ProgramClass; then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_whenProgramClass_thenCallsAnnotationAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    utf8Shrinker.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link Utf8Shrinker#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ArrayElementValue#elementValuesAccept(Clazz, Annotation,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Shrinker#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); when ProgramClass; then calls elementValuesAccept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.Utf8Shrinker.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_whenProgramClass_thenCallsElementValuesAccept() {
    // Arrange
    Utf8Shrinker utf8Shrinker = new Utf8Shrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = mock(ArrayElementValue.class);
    doNothing()
        .when(arrayElementValue)
        .elementValuesAccept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());

    // Act
    utf8Shrinker.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    verify(arrayElementValue)
        .elementValuesAccept(
            isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }
}
