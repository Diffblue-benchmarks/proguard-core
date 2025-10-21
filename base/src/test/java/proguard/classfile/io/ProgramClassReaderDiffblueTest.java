package proguard.classfile.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link ProgramClassReader#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <ul>
   *   <li>Then {@link IntegerConstant#IntegerConstant(int)} with value is forty-two Value is {@code
   *       1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant_thenIntegerConstantWithValueIsFortyTwoValueIs1096302936()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act
    programClassReader.visitIntegerConstant(clazz, integerConstant);

    // Assert
    assertEquals(1096302936, integerConstant.getValue());
  }

  /**
   * Test {@link ProgramClassReader#visitLongConstant(Clazz, LongConstant)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitLongConstant(Clazz, LongConstant)"})
  public void testVisitLongConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LongConstant longConstant = new LongConstant(42L);

    // Act
    programClassReader.visitLongConstant(clazz, longConstant);

    // Assert
    assertEquals(4708585257725083992L, longConstant.getValue());
  }

  /**
   * Test {@link ProgramClassReader#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <ul>
   *   <li>Then {@link FloatConstant#FloatConstant(float)} with value is ten Value is {@code
   *       13.515953}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant_thenFloatConstantWithValueIsTenValueIs13515953()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    FloatConstant floatConstant = new FloatConstant(10.0f);

    // Act
    programClassReader.visitFloatConstant(clazz, floatConstant);

    // Assert
    assertEquals(13.515953f, floatConstant.getValue(), 0.0f);
  }

  /**
   * Test {@link ProgramClassReader#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <ul>
   *   <li>Then {@link DoubleConstant#DoubleConstant(double)} with value is ten Value is {@code
   *       6358369.021011673}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitDoubleConstant(Clazz, DoubleConstant)"})
  public void testVisitDoubleConstant_thenDoubleConstantWithValueIsTenValueIs6358369021011673()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);

    // Act
    programClassReader.visitDoubleConstant(clazz, doubleConstant);

    // Assert
    assertEquals(6358369.021011673d, doubleConstant.getValue(), 0.0);
  }

  /**
   * Test {@link ProgramClassReader#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then {@link StringConstant#StringConstant()} {@link StringConstant#u2stringIndex} is
   *       {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitStringConstant(Clazz, StringConstant)"})
  public void testVisitStringConstant_thenStringConstantU2stringIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();

    // Act
    programClassReader.visitStringConstant(clazz, stringConstant);

    // Assert
    assertEquals(16728, stringConstant.u2stringIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then {@link DynamicConstant#DynamicConstant()} BootstrapMethodAttributeIndex is {@code
   *       16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenDynamicConstantBootstrapMethodAttributeIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then {@link ModuleConstant#ModuleConstant(int)} with u2nameIndex is one {@link
   *       ModuleConstant#u2nameIndex} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenModuleConstantWithU2nameIndexIsOneU2nameIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act
    programClassReader.visitModuleConstant(clazz, moduleConstant);

    // Assert
    assertEquals(16728, moduleConstant.u2nameIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    PackageConstant packageConstant = new PackageConstant(1);

    // Act
    programClassReader.visitPackageConstant(clazz, packageConstant);

    // Assert
    assertEquals(16728, packageConstant.u2nameIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitAnyRefConstant(Clazz, RefConstant)}.
   *
   * <ul>
   *   <li>Then {@link FieldrefConstant#FieldrefConstant()} ClassIndex is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitAnyRefConstant(Clazz, RefConstant)"})
  public void testVisitAnyRefConstant_thenFieldrefConstantClassIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then {@link ClassConstant#ClassConstant()} {@link ClassConstant#u2nameIndex} is {@code
   *       16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant_thenClassConstantU2nameIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    programClassReader.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(16728, classConstant.u2nameIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then {@link MethodTypeConstant#MethodTypeConstant()} DescriptorIndex is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitMethodTypeConstant(Clazz, MethodTypeConstant)"})
  public void testVisitMethodTypeConstant_thenMethodTypeConstantDescriptorIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act
    programClassReader.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    assertEquals(16728, methodTypeConstant.getDescriptorIndex());
  }

  /**
   * Test {@link ProgramClassReader#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitUnknownAttribute(Clazz, UnknownAttribute)"})
  public void testVisitUnknownAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);

    // Act
    programClassReader.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), unknownAttribute.info);
  }

  /**
   * Test {@link ProgramClassReader#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceFileAttribute sourceFileAttribute = new SourceFileAttribute(1, 1);

    // Act
    programClassReader.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    assertEquals(16728, sourceFileAttribute.u2sourceFileIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitSourceDirAttribute(Clazz, SourceDirAttribute)"})
  public void testVisitSourceDirAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceDirAttribute sourceDirAttribute = new SourceDirAttribute(1, 1);

    // Act
    programClassReader.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    assertEquals(16728, sourceDirAttribute.u2sourceDirIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)"
  })
  public void testVisitSourceDebugExtensionAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute();

    // Act
    programClassReader.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    assertArrayEquals(new byte[] {}, sourceDebugExtensionAttribute.info);
  }

  /**
   * Test {@link ProgramClassReader#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);

    // Act
    programClassReader.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    assertEquals(16728, nestHostAttribute.u2hostClassIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Act
    programClassReader.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    assertEquals(16728, moduleMainClassAttribute.u2mainClass);
  }

  /**
   * Test {@link ProgramClassReader#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitSignatureAttribute(Clazz, SignatureAttribute)"})
  public void testVisitSignatureAttributeWithClazzSignatureAttribute()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    programClassReader.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    assertEquals(16728, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)"
  })
  public void testVisitConstantValueAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 1, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException2() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 2, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException3() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 3, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException4() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 4, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException5() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException6() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 5, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenA_thenThrowRuntimeException7() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 6, 'X'})));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  public void testVisitStackMapTableAttribute_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitStackMapTableAttribute(
                clazz, method, codeAttribute, new StackMapTableAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("@XAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            programClassReader.visitAnnotationDefaultAttribute(
                clazz, method, new AnnotationDefaultAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute2() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            programClassReader.visitAnnotationDefaultAttribute(
                clazz, method, new AnnotationDefaultAttribute()));
  }

  /**
   * Test {@link ProgramClassReader#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method, CodeAttribute, int,
   * SameZeroFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameZeroFrame#SameZeroFrame(int)} with tag is one OffsetDelta is {@code
   *       16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method,
   * CodeAttribute, int, SameZeroFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)"
  })
  public void testVisitSameZeroFrame_thenSameZeroFrameWithTagIsOneOffsetDeltaIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method, CodeAttribute, int,
   * SameZeroFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameZeroFrame#SameZeroFrame(int)} with tag is one OffsetDelta is one.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameZeroFrame(Clazz, Method,
   * CodeAttribute, int, SameZeroFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)"
  })
  public void testVisitSameZeroFrame_thenSameZeroFrameWithTagIsOneOffsetDeltaIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link DoubleType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemDoubleType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link FloatType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemFloatType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link IntegerType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemIntegerType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link LongType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemLongType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link NullType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemNullType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {5, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link TopType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemTopType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one {@link
   *       SameOneFrame#stackItem} {@link UninitializedThisType}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneStackItemUninitializedThisType() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitSameOneFrame(
                clazz, method, codeAttribute, 2, new SameOneFrame(1)));
  }

  /**
   * Test {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>When {@link SameOneFrame#SameOneFrame(int)} with tag is two hundred forty-seven.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitSameOneFrame(Clazz, Method, CodeAttribute,
   * int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_whenSameOneFrameWithTagIsTwoHundredFortySeven()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitSameOneFrame(
                clazz, method, codeAttribute, 2, new SameOneFrame(247)));
  }

  /**
   * Test {@link ProgramClassReader#visitLessZeroFrame(Clazz, Method, CodeAttribute, int,
   * LessZeroFrame)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLessZeroFrame(Clazz, Method,
   * CodeAttribute, int, LessZeroFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitLessZeroFrame(Clazz, Method, CodeAttribute, int, LessZeroFrame)"
  })
  public void testVisitLessZeroFrame() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)"
  })
  public void testVisitMoreZeroFrame_givenOne_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    moreZeroFrame.additionalVariablesCount = 1;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            programClassReader.visitMoreZeroFrame(clazz, method, codeAttribute, 2, moreZeroFrame));
  }

  /**
   * Test {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)"
  })
  public void testVisitMoreZeroFrame_givenZero_thenArrayLengthIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)"
  })
  public void testVisitFullFrame_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> programClassReader.visitFullFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Test {@link ProgramClassReader#visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)}.
   *
   * <ul>
   *   <li>Then createObjectType one {@link ObjectType#u2classIndex} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitObjectType(Clazz, Method, CodeAttribute,
   * int, ObjectType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)"
  })
  public void testVisitObjectType_thenCreateObjectTypeOneU2classIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitUninitializedType(Clazz, Method, CodeAttribute, int,
   * UninitializedType)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitUninitializedType(Clazz, Method,
   * CodeAttribute, int, UninitializedType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)"
  })
  public void testVisitUninitializedType() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)"
  })
  public void testVisitLineNumberInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitParameterInfo(Clazz, Method, int, ParameterInfo)"
  })
  public void testVisitParameterInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  public void testVisitLocalVariableInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  public void testVisitLocalVariableTypeInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAXAXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    programClassReader.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals(16728, localVariableTypeInfo.u2index);
    assertEquals(16728, localVariableTypeInfo.u2length);
    assertEquals(16728, localVariableTypeInfo.u2nameIndex);
    assertEquals(16728, localVariableTypeInfo.u2signatureIndex);
    assertEquals(16728, localVariableTypeInfo.u2startPC);
  }

  /**
   * Test {@link ProgramClassReader#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> programClassReader.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Test {@link ProgramClassReader#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code clazz},
   * {@code typeAnnotation}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClassReader.visitTypeAnnotation(Clazz, TypeAnnotation)"})
  public void testVisitTypeAnnotationWithClazzTypeAnnotation_thenThrowRuntimeException() {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(
                new ByteArrayInputStream(new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> programClassReader.visitTypeAnnotation(clazz, new TypeAnnotation()));
  }

  /**
   * Test {@link ProgramClassReader#visitTypeParameterTargetInfo(Clazz, TypeAnnotation,
   * TypeParameterTargetInfo)} with {@code clazz}, {@code typeAnnotation}, {@code
   * typeParameterTargetInfo}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitTypeParameterTargetInfo(Clazz,
   * TypeAnnotation, TypeParameterTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitTypeParameterTargetInfo(Clazz, TypeAnnotation, TypeParameterTargetInfo)"
  })
  public void testVisitTypeParameterTargetInfoWithClazzTypeAnnotationTypeParameterTargetInfo()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitSuperTypeTargetInfo(Clazz, TypeAnnotation,
   * SuperTypeTargetInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitSuperTypeTargetInfo(Clazz, TypeAnnotation,
   * SuperTypeTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitSuperTypeTargetInfo(Clazz, TypeAnnotation, SuperTypeTargetInfo)"
  })
  public void testVisitSuperTypeTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitTypeParameterBoundTargetInfo(Clazz, TypeAnnotation,
   * TypeParameterBoundTargetInfo)} with {@code clazz}, {@code typeAnnotation}, {@code
   * typeParameterBoundTargetInfo}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitTypeParameterBoundTargetInfo(Clazz,
   * TypeAnnotation, TypeParameterBoundTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitTypeParameterBoundTargetInfo(Clazz, TypeAnnotation, TypeParameterBoundTargetInfo)"
  })
  public void
      testVisitTypeParameterBoundTargetInfoWithClazzTypeAnnotationTypeParameterBoundTargetInfo()
          throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypeParameterBoundTargetInfo typeParameterBoundTargetInfo =
        new TypeParameterBoundTargetInfo((byte) 'A');

    // Act
    programClassReader.visitTypeParameterBoundTargetInfo(
        clazz, typeAnnotation, typeParameterBoundTargetInfo);

    // Assert
    assertEquals(65, typeParameterBoundTargetInfo.u1typeParameterIndex);
    assertEquals(88, typeParameterBoundTargetInfo.u1boundIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitFormalParameterTargetInfo(Clazz, Method, TypeAnnotation,
   * FormalParameterTargetInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitFormalParameterTargetInfo(Clazz, Method,
   * TypeAnnotation, FormalParameterTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitFormalParameterTargetInfo(Clazz, Method, TypeAnnotation, FormalParameterTargetInfo)"
  })
  public void testVisitFormalParameterTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    FormalParameterTargetInfo formalParameterTargetInfo = new FormalParameterTargetInfo((byte) 'A');

    // Act
    programClassReader.visitFormalParameterTargetInfo(
        clazz, method, typeAnnotation, formalParameterTargetInfo);

    // Assert
    assertEquals(65, formalParameterTargetInfo.u1formalParameterIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitThrowsTargetInfo(Clazz, Method, TypeAnnotation,
   * ThrowsTargetInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitThrowsTargetInfo(Clazz, Method,
   * TypeAnnotation, ThrowsTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitThrowsTargetInfo(Clazz, Method, TypeAnnotation, ThrowsTargetInfo)"
  })
  public void testVisitThrowsTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitCatchTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, CatchTargetInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitCatchTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, CatchTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitCatchTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, CatchTargetInfo)"
  })
  public void testVisitCatchTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');

    // Act
    programClassReader.visitCatchTargetInfo(
        clazz, method, codeAttribute, typeAnnotation, catchTargetInfo);

    // Assert
    assertEquals(16728, catchTargetInfo.u2exceptionTableIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitOffsetTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, OffsetTargetInfo)}.
   *
   * <ul>
   *   <li>Then {@link OffsetTargetInfo#OffsetTargetInfo(byte)} with u1targetType is {@code A}
   *       {@link OffsetTargetInfo#u2offset} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitOffsetTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)"
  })
  public void testVisitOffsetTargetInfo_thenOffsetTargetInfoWithU1targetTypeIsAU2offsetIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    OffsetTargetInfo offsetTargetInfo = new OffsetTargetInfo((byte) 'A');

    // Act
    programClassReader.visitOffsetTargetInfo(
        clazz, method, codeAttribute, typeAnnotation, offsetTargetInfo);

    // Assert
    assertEquals(16728, offsetTargetInfo.u2offset);
  }

  /**
   * Test {@link ProgramClassReader#visitTypeArgumentTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, TypeArgumentTargetInfo)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitTypeArgumentTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, TypeArgumentTargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitTypeArgumentTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, TypeArgumentTargetInfo)"
  })
  public void testVisitTypeArgumentTargetInfo() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TypeArgumentTargetInfo typeArgumentTargetInfo = new TypeArgumentTargetInfo((byte) 'A');

    // Act
    programClassReader.visitTypeArgumentTargetInfo(
        clazz, method, codeAttribute, typeAnnotation, typeArgumentTargetInfo);

    // Assert
    assertEquals(16728, typeArgumentTargetInfo.u2offset);
    assertEquals(65, typeArgumentTargetInfo.u1typeArgumentIndex);
  }

  /**
   * Test {@link ProgramClassReader#visitTypePathInfo(Clazz, TypeAnnotation, TypePathInfo)} with
   * {@code clazz}, {@code typeAnnotation}, {@code typePathInfo}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitTypePathInfo(Clazz, TypeAnnotation,
   * TypePathInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitTypePathInfo(Clazz, TypeAnnotation, TypePathInfo)"
  })
  public void testVisitTypePathInfoWithClazzTypeAnnotationTypePathInfo()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)"
  })
  public void testVisitLocalVariableTargetElement() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');
    LocalVariableTargetElement localVariableTargetElement = new LocalVariableTargetElement(1, 3, 1);

    // Act
    programClassReader.visitLocalVariableTargetElement(
        clazz,
        method,
        codeAttribute,
        typeAnnotation,
        localVariableTargetInfo,
        localVariableTargetElement);

    // Assert
    assertEquals(16728, localVariableTargetElement.u2index);
    assertEquals(16728, localVariableTargetElement.u2length);
    assertEquals(16728, localVariableTargetElement.u2startPC);
  }

  /**
   * Test {@link ProgramClassReader#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitConstantElementValue(Clazz, Annotation, ConstantElementValue)"
  })
  public void testVisitConstantElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <p>Method under test: {@link ProgramClassReader#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
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
   * Test {@link ProgramClassReader#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  public void testVisitAnnotationElementValue_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            programClassReader.visitAnnotationElementValue(
                clazz, annotation, new AnnotationElementValue()));
  }

  /**
   * Test {@link ProgramClassReader#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassReader#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClassReader.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  public void testVisitArrayElementValue_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramClassReader programClassReader =
        new ProgramClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            programClassReader.visitArrayElementValue(clazz, annotation, new ArrayElementValue()));
  }
}
