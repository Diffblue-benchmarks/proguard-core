package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.TypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.annotation.visitor.TypeAnnotationVisitor;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.BootstrapMethodInfoVisitor;
import proguard.classfile.attribute.visitor.InnerClassesInfoVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class ClassCleanerDiffblueTest {
  /**
   * Test {@link ClassCleaner#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> classCleaner.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassCleaner#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
    verify(programClass).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    KotlinClassKindMetadata kotlinMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());

    // Act
    classCleaner.visitLibraryClass(
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata));

    // Assert
    verify(kotlinMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link ClassCleaner#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#fieldsAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then calls fieldsAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsFieldsAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(libraryClass).methodsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitLibraryClass(libraryClass);

    // Assert
    verify(libraryClass).fieldsAccept(isA(MemberVisitor.class));
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(libraryClass).methodsAccept(isA(MemberVisitor.class));
    verify(libraryClass).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntriesAccept(Clazz,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntriesAccept(Clazz, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntriesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfoVisitor>any());
    doNothing().when(bootstrapMethodsAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(isA(Clazz.class), isA(BootstrapMethodInfoVisitor.class));
    verify(bootstrapMethodsAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());
    doNothing().when(recordAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
    verify(recordAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InnerClassesAttribute#innerClassEntriesAccept(Clazz,
   *       InnerClassesInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls innerClassEntriesAccept(Clazz, InnerClassesInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsInnerClassEntriesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    doNothing()
        .when(innerClassesAttribute)
        .innerClassEntriesAccept(Mockito.<Clazz>any(), Mockito.<InnerClassesInfoVisitor>any());
    doNothing().when(innerClassesAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(innerClassesAttribute)
        .innerClassEntriesAccept(isA(Clazz.class), isA(InnerClassesInfoVisitor.class));
    verify(innerClassesAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());
    doNothing().when(annotationsAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
    verify(annotationsAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitAnyTypeAnnotationsAttribute(Clazz, TypeAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotationsAttribute#typeAnnotationsAccept(Clazz,
   *       TypeAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyTypeAnnotationsAttribute(Clazz, TypeAnnotationsAttribute); then calls typeAnnotationsAccept(Clazz, TypeAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnyTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotationsAttribute)"
  })
  void testVisitAnyTypeAnnotationsAttribute_thenCallsTypeAnnotationsAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotationsAttribute typeAnnotationsAttribute = mock(TypeAnnotationsAttribute.class);
    doNothing()
        .when(typeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());
    doNothing().when(typeAnnotationsAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitAnyTypeAnnotationsAttribute(clazz, typeAnnotationsAttribute);

    // Assert
    verify(typeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
    verify(typeAnnotationsAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());
    doNothing().when(annotationDefaultAttribute).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());
    doNothing().when(recordComponentInfo).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
    verify(recordComponentInfo).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}.
   *
   * <ul>
   *   <li>Then calls {@link SameOneFrame#stackItemAccept(Clazz, Method, CodeAttribute, int,
   *       VerificationTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); then calls stackItemAccept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_thenCallsStackItemAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = mock(SameOneFrame.class);
    doNothing()
        .when(sameOneFrame)
        .stackItemAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());
    doNothing().when(sameOneFrame).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    verify(sameOneFrame)
        .stackItemAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
    verify(sameOneFrame).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());
    doNothing().when(annotation).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotation).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code clazz}, {@code
   * typeAnnotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, TypeAnnotation) with 'clazz', 'typeAnnotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzTypeAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = mock(TypeAnnotation.class);
    doNothing()
        .when(typeAnnotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());
    doNothing().when(typeAnnotation).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitTypeAnnotation(clazz, typeAnnotation);

    // Assert
    verify(typeAnnotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(typeAnnotation).setProcessingInfo(isNull());
  }

  /**
   * Test {@link ClassCleaner#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassCleaner#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCleaner.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());
    doNothing().when(annotationElementValue).setProcessingInfo(Mockito.<Object>any());

    // Act
    classCleaner.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
    verify(annotationElementValue).setProcessingInfo(isNull());
  }
}
