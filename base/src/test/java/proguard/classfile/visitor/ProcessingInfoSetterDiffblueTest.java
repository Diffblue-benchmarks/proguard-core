package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.preverification.DoubleType;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class ProcessingInfoSetterDiffblueTest {
  /**
   * Test {@link ProcessingInfoSetter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then {@link LibraryClass#LibraryClass()} ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then LibraryClass() ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenLibraryClassProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();

    // Act
    processingInfoSetter.visitAnyClass(clazz);

    // Assert
    assertEquals("Processing Info", clazz.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>Then {@link ClassConstant#ClassConstant()} ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyConstant(Clazz, Constant); then ClassConstant() ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant_thenClassConstantProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = new ClassConstant();

    // Act
    processingInfoSetter.visitAnyConstant(clazz, constant);

    // Assert
    assertEquals("Processing Info", constant.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyMember(Clazz, Member)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    processingInfoSetter.visitAnyMember(clazz, member);

    // Assert
    assertEquals("Processing Info", member.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName("Test visitAnyAttribute(Clazz, Attribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testVisitAnyAttribute() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute attribute = new BootstrapMethodsAttribute();

    // Act
    processingInfoSetter.visitAnyAttribute(clazz, attribute);

    // Assert
    assertEquals("Processing Info", attribute.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName("Test visitRecordComponentInfo(Clazz, RecordComponentInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    processingInfoSetter.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    assertEquals("Processing Info", recordComponentInfo.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    processingInfoSetter.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals("Processing Info", innerClassesInfo.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act
    processingInfoSetter.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert
    assertEquals("Processing Info", exceptionInfo.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int,
   * StackMapFrame)}.
   *
   * <ul>
   *   <li>Then {@link FullFrame#FullFrame()} ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyStackMapFrame(Clazz, Method,
   * CodeAttribute, int, StackMapFrame)}
   */
  @Test
  @DisplayName(
      "Test visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame); then FullFrame() ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyStackMapFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.StackMapFrame)"
  })
  void testVisitAnyStackMapFrame_thenFullFrameProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    FullFrame stackMapFrame = new FullFrame();

    // Act
    processingInfoSetter.visitAnyStackMapFrame(clazz, method, codeAttribute, 2, stackMapFrame);

    // Assert
    assertEquals("Processing Info", stackMapFrame.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyVerificationType(Clazz, Method, CodeAttribute, int,
   * VerificationType)}.
   *
   * <ul>
   *   <li>Then createDoubleType ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyVerificationType(Clazz, Method,
   * CodeAttribute, int, VerificationType)}
   */
  @Test
  @DisplayName(
      "Test visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType); then createDoubleType ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyVerificationType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.VerificationType)"
  })
  void testVisitAnyVerificationType_thenCreateDoubleTypeProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    DoubleType verificationType = VerificationTypeFactory.createDoubleType();

    // Act
    processingInfoSetter.visitAnyVerificationType(
        clazz, method, codeAttribute, 2, verificationType);

    // Assert
    assertEquals("Processing Info", verificationType.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act
    processingInfoSetter.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    assertEquals("Processing Info", localVariableInfo.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    processingInfoSetter.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals("Processing Info", localVariableTypeInfo.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName("Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    processingInfoSetter.visitAnnotation(clazz, annotation);

    // Assert
    assertEquals("Processing Info", annotation.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code
   * clazz}, {@code typeAnnotation}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @DisplayName("Test visitTypeAnnotation(Clazz, TypeAnnotation) with 'clazz', 'typeAnnotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzTypeAnnotation() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act
    processingInfoSetter.visitTypeAnnotation(clazz, typeAnnotation);

    // Assert
    assertEquals("Processing Info", typeAnnotation.getProcessingInfo());
  }

  /**
   * Test {@link ProcessingInfoSetter#visitAnyElementValue(Clazz, Annotation, ElementValue)}.
   *
   * <p>Method under test: {@link ProcessingInfoSetter#visitAnyElementValue(Clazz, Annotation,
   * ElementValue)}
   */
  @Test
  @DisplayName("Test visitAnyElementValue(Clazz, Annotation, ElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProcessingInfoSetter.visitAnyElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testVisitAnyElementValue() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue elementValue = new AnnotationElementValue();

    // Act
    processingInfoSetter.visitAnyElementValue(clazz, annotation, elementValue);

    // Assert
    assertEquals("Processing Info", elementValue.getProcessingInfo());
  }
}
