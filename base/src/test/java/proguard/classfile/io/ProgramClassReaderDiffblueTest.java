package proguard.classfile.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LineNumberInfo;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.ParameterInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDebugExtensionAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.UnknownAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.ConstantElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.TypePathInfo;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.FormalParameterTargetInfo;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetElement;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;
import proguard.classfile.attribute.annotation.target.OffsetTargetInfo;
import proguard.classfile.attribute.annotation.target.SuperTypeTargetInfo;
import proguard.classfile.attribute.annotation.target.ThrowsTargetInfo;
import proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo;
import proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo;
import proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.RequiresInfo;
import proguard.classfile.attribute.preverification.DoubleType;
import proguard.classfile.attribute.preverification.FloatType;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.IntegerType;
import proguard.classfile.attribute.preverification.LessZeroFrame;
import proguard.classfile.attribute.preverification.LongType;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.NullType;
import proguard.classfile.attribute.preverification.ObjectType;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.SameZeroFrame;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.attribute.preverification.TopType;
import proguard.classfile.attribute.preverification.UninitializedThisType;
import proguard.classfile.attribute.preverification.UninitializedType;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;

public class ProgramClassReaderDiffblueTest {
  /**
   * Method under test:
   * {@link ProgramClassReader#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act
    programClassReader.visitIntegerConstant(clazz, integerConstant);

    // Assert
    assertEquals(1096302936, integerConstant.getValue());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  public void testVisitLongConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LongConstant longConstant = new LongConstant(42L);

    // Act
    programClassReader.visitLongConstant(clazz, longConstant);

    // Assert
    assertEquals(4708585257725083992L, longConstant.getValue());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  public void testVisitFloatConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    FloatConstant floatConstant = new FloatConstant(10.0f);

    // Act
    programClassReader.visitFloatConstant(clazz, floatConstant);

    // Assert
    assertEquals(13.515953f, floatConstant.getValue(), 0.0f);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  public void testVisitDoubleConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);

    // Act
    programClassReader.visitDoubleConstant(clazz, doubleConstant);

    // Assert
    assertEquals(6358369.021011673d, doubleConstant.getValue(), 0.0);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  public void testVisitStringConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();

    // Act
    programClassReader.visitStringConstant(clazz, stringConstant);

    // Assert
    assertEquals(16728, stringConstant.u2stringIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    programClassReader.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(16728, dynamicConstant.getBootstrapMethodAttributeIndex());
    assertEquals(16728, dynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    programClassReader.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(16728, invokeDynamicConstant.getBootstrapMethodAttributeIndex());
    assertEquals(16728, invokeDynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act
    programClassReader.visitMethodHandleConstant(clazz, methodHandleConstant);

    // Assert
    assertEquals(22593, methodHandleConstant.getReferenceIndex());
    assertEquals(65, methodHandleConstant.getReferenceKind());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act
    programClassReader.visitModuleConstant(clazz, moduleConstant);

    // Assert
    assertEquals(16728, moduleConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    PackageConstant packageConstant = new PackageConstant(1);

    // Act
    programClassReader.visitPackageConstant(clazz, packageConstant);

    // Assert
    assertEquals(16728, packageConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  public void testVisitAnyRefConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    FieldrefConstant refConstant = new FieldrefConstant();

    // Act
    programClassReader.visitAnyRefConstant(clazz, refConstant);

    // Assert
    assertEquals(16728, refConstant.getClassIndex());
    assertEquals(16728, refConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  public void testVisitClassConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    programClassReader.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(16728, classConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act
    programClassReader.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    assertEquals(16728, methodTypeConstant.getDescriptorIndex());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  public void testVisitUnknownAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);

    // Act
    programClassReader.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), unknownAttribute.info);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceFileAttribute sourceFileAttribute = new SourceFileAttribute(1, 1);

    // Act
    programClassReader.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    assertEquals(16728, sourceFileAttribute.u2sourceFileIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceDirAttribute sourceDirAttribute = new SourceDirAttribute(1, 1);

    // Act
    programClassReader.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    assertEquals(16728, sourceDirAttribute.u2sourceDirIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)}
   */
  @Test
  public void testVisitSourceDebugExtensionAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute = new SourceDebugExtensionAttribute();

    // Act
    programClassReader.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    assertEquals(0, sourceDebugExtensionAttribute.info.length);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    programClassReader.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    assertEquals(16728, enclosingMethodAttribute.u2classIndex);
    assertEquals(16728, enclosingMethodAttribute.u2nameAndTypeIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);

    // Act
    programClassReader.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    assertEquals(16728, nestHostAttribute.u2hostClassIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Act
    programClassReader.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    assertEquals(16728, moduleMainClassAttribute.u2mainClass);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    programClassReader.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    assertEquals(16728, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}
   */
  @Test
  public void testVisitConstantValueAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ConstantValueAttribute constantValueAttribute = new ConstantValueAttribute(1, 1);

    // Act
    programClassReader.visitConstantValueAttribute(clazz, field, constantValueAttribute);

    // Assert
    assertEquals(16728, constantValueAttribute.u2constantValueIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute2() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 1, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute3() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 2, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute4() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 3, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute5() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 4, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute6() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute7() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 5, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute8() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 6, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  public void testVisitStackMapTableAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> programClassReader.visitStackMapTableAttribute(clazz, method,
        codeAttribute, new StackMapTableAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> programClassReader.visitAnnotationDefaultAttribute(clazz, method, new AnnotationDefaultAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute2() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("@XAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> programClassReader.visitAnnotationDefaultAttribute(clazz, method, new AnnotationDefaultAttribute()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute3() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("BXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute();

    // Act
    programClassReader.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ConstantElementValue);
    assertEquals('B', elementValue.getTag());
    assertNull(elementValue.getProcessingInfo());
    assertNull(((ConstantElementValue) elementValue).referencedClass);
    assertNull(((ConstantElementValue) elementValue).referencedMethod);
    assertEquals(0, elementValue.getProcessingFlags());
    assertEquals(0, ((ConstantElementValue) elementValue).u2elementNameIndex);
    assertEquals(22593, ((ConstantElementValue) elementValue).u2constantValueIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    programClassReader.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(16728, innerClassesInfo.u2innerClassAccessFlags);
    assertEquals(16728, innerClassesInfo.u2innerClassIndex);
    assertEquals(16728, innerClassesInfo.u2innerNameIndex);
    assertEquals(16728, innerClassesInfo.u2outerClassIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act
    programClassReader.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert
    assertEquals(16728, exceptionInfo.u2catchType);
    assertEquals(16728, exceptionInfo.u2endPC);
    assertEquals(16728, exceptionInfo.u2handlerPC);
    assertEquals(16728, exceptionInfo.u2startPC);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)}
   */
  @Test
  public void testVisitSameZeroFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);

    // Act
    programClassReader.visitSameZeroFrame(clazz, method, codeAttribute, 2, sameZeroFrame);

    // Assert that nothing has changed
    assertEquals(1, sameZeroFrame.getOffsetDelta());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)}
   */
  @Test
  public void testVisitSameZeroFrame2() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);
    sameZeroFrame.u2offsetDelta = Double.SIZE;

    // Act
    programClassReader.visitSameZeroFrame(clazz, method, codeAttribute, 2, sameZeroFrame);

    // Assert
    assertEquals(16728, sameZeroFrame.getOffsetDelta());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, new SameOneFrame(1)));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame2() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof IntegerType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(1, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame3() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof FloatType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(2, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame4() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof TopType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getTag());
    assertEquals(0, verificationType.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame5() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof DoubleType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(3, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame6() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof LongType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(4, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame7() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{5, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof NullType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(5, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame8() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, new SameOneFrame(247)));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame9() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    programClassReader.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof UninitializedThisType);
    assertNull(verificationType.getProcessingInfo());
    assertEquals(0, verificationType.getProcessingFlags());
    assertEquals(6, verificationType.getTag());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLessZeroFrame(Clazz, Method, CodeAttribute, int, LessZeroFrame)}
   */
  @Test
  public void testVisitLessZeroFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LessZeroFrame lessZeroFrame = new LessZeroFrame((byte) 'A');

    // Act
    programClassReader.visitLessZeroFrame(clazz, method, codeAttribute, 2, lessZeroFrame);

    // Assert
    assertEquals(16728, lessZeroFrame.getOffsetDelta());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  public void testVisitMoreZeroFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    moreZeroFrame.additionalVariablesCount = 0;

    // Act
    programClassReader.visitMoreZeroFrame(clazz, method, codeAttribute, 2, moreZeroFrame);

    // Assert
    assertEquals(0, moreZeroFrame.additionalVariables.length);
    assertEquals(16728, moreZeroFrame.getOffsetDelta());
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  public void testVisitMoreZeroFrame2() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    moreZeroFrame.additionalVariablesCount = 1;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitMoreZeroFrame(clazz, method, codeAttribute, 2, moreZeroFrame));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}
   */
  @Test
  public void testVisitFullFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> programClassReader.visitFullFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)}
   */
  @Test
  public void testVisitObjectType() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ObjectType objectType = VerificationTypeFactory.createObjectType(1);

    // Act
    programClassReader.visitObjectType(clazz, method, codeAttribute, 2, objectType);

    // Assert
    assertEquals(16728, objectType.u2classIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)}
   */
  @Test
  public void testVisitUninitializedType() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    UninitializedType uninitializedType = VerificationTypeFactory.createUninitializedType(1);

    // Act
    programClassReader.visitUninitializedType(clazz, method, codeAttribute, 2, uninitializedType);

    // Assert
    assertEquals(16728, uninitializedType.u2newInstructionOffset);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    // Act
    programClassReader.visitLineNumberInfo(clazz, method, codeAttribute, lineNumberInfo);

    // Assert
    assertEquals(16728, lineNumberInfo.u2lineNumber);
    assertEquals(16728, lineNumberInfo.u2startPC);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitParameterInfo(Clazz, Method, int, ParameterInfo)}
   */
  @Test
  public void testVisitParameterInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ParameterInfo parameterInfo = new ParameterInfo(1, 1);

    // Act
    programClassReader.visitParameterInfo(clazz, method, 1, parameterInfo);

    // Assert
    assertEquals(16728, parameterInfo.u2accessFlags);
    assertEquals(16728, parameterInfo.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAXAXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act
    programClassReader.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    assertEquals(16728, localVariableInfo.u2descriptorIndex);
    assertEquals(16728, localVariableInfo.u2index);
    assertEquals(16728, localVariableInfo.u2length);
    assertEquals(16728, localVariableInfo.u2nameIndex);
    assertEquals(16728, localVariableInfo.u2startPC);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAXAXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    programClassReader.visitLocalVariableTypeInfo(clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals(16728, localVariableTypeInfo.u2index);
    assertEquals(16728, localVariableTypeInfo.u2length);
    assertEquals(16728, localVariableTypeInfo.u2nameIndex);
    assertEquals(16728, localVariableTypeInfo.u2signatureIndex);
    assertEquals(16728, localVariableTypeInfo.u2startPC);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    RequiresInfo requiresInfo = new RequiresInfo(1, 1, 1);

    // Act
    programClassReader.visitRequiresInfo(clazz, requiresInfo);

    // Assert
    assertEquals(16728, requiresInfo.u2requiresFlags);
    assertEquals(16728, requiresInfo.u2requiresIndex);
    assertEquals(16728, requiresInfo.u2requiresVersionIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> programClassReader.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  public void testVisitTypeAnnotation() {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> programClassReader.visitTypeAnnotation(clazz, new TypeAnnotation()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitTypeParameterTargetInfo(Clazz, TypeAnnotation, TypeParameterTargetInfo)}
   */
  @Test
  public void testVisitTypeParameterTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypeParameterTargetInfo typeParameterTargetInfo = new TypeParameterTargetInfo((byte) 'A');

    // Act
    programClassReader.visitTypeParameterTargetInfo(clazz, typeAnnotation, typeParameterTargetInfo);

    // Assert
    assertEquals(65, typeParameterTargetInfo.u1typeParameterIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitSuperTypeTargetInfo(Clazz, TypeAnnotation, SuperTypeTargetInfo)}
   */
  @Test
  public void testVisitSuperTypeTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    SuperTypeTargetInfo superTypeTargetInfo = new SuperTypeTargetInfo((byte) 'A');

    // Act
    programClassReader.visitSuperTypeTargetInfo(clazz, typeAnnotation, superTypeTargetInfo);

    // Assert
    assertEquals(16728, superTypeTargetInfo.u2superTypeIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitTypeParameterBoundTargetInfo(Clazz, TypeAnnotation, TypeParameterBoundTargetInfo)}
   */
  @Test
  public void testVisitTypeParameterBoundTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypeParameterBoundTargetInfo typeParameterBoundTargetInfo = new TypeParameterBoundTargetInfo((byte) 'A');

    // Act
    programClassReader.visitTypeParameterBoundTargetInfo(clazz, typeAnnotation, typeParameterBoundTargetInfo);

    // Assert
    assertEquals(65, typeParameterBoundTargetInfo.u1typeParameterIndex);
    assertEquals(88, typeParameterBoundTargetInfo.u1boundIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitFormalParameterTargetInfo(Clazz, Method, TypeAnnotation, FormalParameterTargetInfo)}
   */
  @Test
  public void testVisitFormalParameterTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    FormalParameterTargetInfo formalParameterTargetInfo = new FormalParameterTargetInfo((byte) 'A');

    // Act
    programClassReader.visitFormalParameterTargetInfo(clazz, method, typeAnnotation, formalParameterTargetInfo);

    // Assert
    assertEquals(65, formalParameterTargetInfo.u1formalParameterIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitThrowsTargetInfo(Clazz, Method, TypeAnnotation, ThrowsTargetInfo)}
   */
  @Test
  public void testVisitThrowsTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    ThrowsTargetInfo throwsTargetInfo = new ThrowsTargetInfo((byte) 'A');

    // Act
    programClassReader.visitThrowsTargetInfo(clazz, method, typeAnnotation, throwsTargetInfo);

    // Assert
    assertEquals(16728, throwsTargetInfo.u2throwsTypeIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitCatchTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, CatchTargetInfo)}
   */
  @Test
  public void testVisitCatchTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');

    // Act
    programClassReader.visitCatchTargetInfo(clazz, method, codeAttribute, typeAnnotation, catchTargetInfo);

    // Assert
    assertEquals(16728, catchTargetInfo.u2exceptionTableIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  public void testVisitOffsetTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    OffsetTargetInfo offsetTargetInfo = new OffsetTargetInfo((byte) 'A');

    // Act
    programClassReader.visitOffsetTargetInfo(clazz, method, codeAttribute, typeAnnotation, offsetTargetInfo);

    // Assert
    assertEquals(16728, offsetTargetInfo.u2offset);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitTypeArgumentTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, TypeArgumentTargetInfo)}
   */
  @Test
  public void testVisitTypeArgumentTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypeArgumentTargetInfo typeArgumentTargetInfo = new TypeArgumentTargetInfo((byte) 'A');

    // Act
    programClassReader.visitTypeArgumentTargetInfo(clazz, method, codeAttribute, typeAnnotation,
        typeArgumentTargetInfo);

    // Assert
    assertEquals(16728, typeArgumentTargetInfo.u2offset);
    assertEquals(65, typeArgumentTargetInfo.u1typeArgumentIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitTypePathInfo(Clazz, TypeAnnotation, TypePathInfo)}
   */
  @Test
  public void testVisitTypePathInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypePathInfo typePathInfo = new TypePathInfo(1, 1);

    // Act
    programClassReader.visitTypePathInfo(clazz, typeAnnotation, typePathInfo);

    // Assert
    assertEquals(65, typePathInfo.u1typePathKind);
    assertEquals(88, typePathInfo.u1typeArgumentIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  public void testVisitLocalVariableTargetElement() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');
    LocalVariableTargetElement localVariableTargetElement = new LocalVariableTargetElement(1, 3, 1);

    // Act
    programClassReader.visitLocalVariableTargetElement(clazz, method, codeAttribute, typeAnnotation,
        localVariableTargetInfo, localVariableTargetElement);

    // Assert
    assertEquals(16728, localVariableTargetElement.u2index);
    assertEquals(16728, localVariableTargetElement.u2length);
    assertEquals(16728, localVariableTargetElement.u2startPC);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}
   */
  @Test
  public void testVisitConstantElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ConstantElementValue constantElementValue = new ConstantElementValue('A');

    // Act
    programClassReader.visitConstantElementValue(clazz, annotation, constantElementValue);

    // Assert
    assertEquals(16728, constantElementValue.u2constantValueIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    // Act
    programClassReader.visitEnumConstantElementValue(clazz, annotation, enumConstantElementValue);

    // Assert
    assertEquals(16728, enumConstantElementValue.u2constantNameIndex);
    assertEquals(16728, enumConstantElementValue.u2typeNameIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = new ClassElementValue(1, 1);

    // Act
    programClassReader.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    assertEquals(16728, classElementValue.u2classInfoIndex);
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)}
   */
  @Test
  public void testVisitAnnotationElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> programClassReader.visitAnnotationElementValue(clazz, annotation, new AnnotationElementValue()));
  }

  /**
   * Method under test:
   * {@link ProgramClassReader#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}
   */
  @Test
  public void testVisitArrayElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader = new ProgramClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> programClassReader.visitArrayElementValue(clazz, annotation, new ArrayElementValue()));
  }
}
