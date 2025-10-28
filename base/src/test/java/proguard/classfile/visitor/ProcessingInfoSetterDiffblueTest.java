package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
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

public class ProcessingInfoSetterDiffblueTest {
  /**
   * Method under test: {@link ProcessingInfoSetter#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();

    // Act
    processingInfoSetter.visitAnyClass(clazz);

    // Assert
    assertEquals("Processing Info", clazz.getProcessingInfo());
  }

  /**
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  public void testVisitAnyConstant() {
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
   * Method under test: {@link ProcessingInfoSetter#visitAnyMember(Clazz, Member)}
   */
  @Test
  public void testVisitAnyMember() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  public void testVisitAnyAttribute() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  public void testVisitRecordComponentInfo() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)}
   */
  @Test
  public void testVisitAnyStackMapFrame() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)}
   */
  @Test
  public void testVisitAnyVerificationType() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    DoubleType verificationType = VerificationTypeFactory.createDoubleType();

    // Act
    processingInfoSetter.visitAnyVerificationType(clazz, method, codeAttribute, 2, verificationType);

    // Assert
    assertEquals("Processing Info", verificationType.getProcessingInfo());
  }

  /**
   * Method under test:
   * {@link ProcessingInfoSetter#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    processingInfoSetter.visitLocalVariableTypeInfo(clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals("Processing Info", localVariableTypeInfo.getProcessingInfo());
  }

  /**
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  public void testVisitTypeAnnotation() {
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
   * Method under test:
   * {@link ProcessingInfoSetter#visitAnyElementValue(Clazz, Annotation, ElementValue)}
   */
  @Test
  public void testVisitAnyElementValue() {
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
