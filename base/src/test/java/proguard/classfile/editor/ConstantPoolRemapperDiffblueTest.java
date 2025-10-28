package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.DeprecatedAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionInfo;
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
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.module.ExportsInfo;
import proguard.classfile.attribute.module.ModuleAttribute;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.ModulePackagesAttribute;
import proguard.classfile.attribute.module.OpensInfo;
import proguard.classfile.attribute.module.ProvidesInfo;
import proguard.classfile.attribute.module.RequiresInfo;
import proguard.classfile.attribute.preverification.ObjectType;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.testutils.cpa.NamedField;
import proguard.testutils.cpa.NamedMember;

public class ConstantPoolRemapperDiffblueTest {
  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitProgramClass(new ProgramClass()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper
        .visitProgramClass(new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  public void testVisitStringConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();

    // Act
    constantPoolRemapper.visitStringConstant(clazz, stringConstant);

    // Assert
    assertEquals(1, stringConstant.u2stringIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  public void testVisitStringConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitStringConstant(clazz, new StringConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    constantPoolRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(1, dynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    constantPoolRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(1, invokeDynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act
    constantPoolRemapper.visitMethodHandleConstant(clazz, methodHandleConstant);

    // Assert
    assertEquals(0, methodHandleConstant.getReferenceIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act
    constantPoolRemapper.visitModuleConstant(clazz, moduleConstant);

    // Assert
    assertEquals(0, moduleConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleConstant(clazz, new ModuleConstant(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PackageConstant packageConstant = new PackageConstant(1);

    // Act
    constantPoolRemapper.visitPackageConstant(clazz, packageConstant);

    // Assert
    assertEquals(0, packageConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitPackageConstant(clazz, new PackageConstant(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
  public void testVisitFieldrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act
    constantPoolRemapper.visitFieldrefConstant(clazz, fieldrefConstant);

    // Assert
    assertEquals(1, fieldrefConstant.getClassIndex());
    assertEquals(1, fieldrefConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
  public void testVisitFieldrefConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitFieldrefConstant(clazz, new FieldrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)}
   */
  @Test
  public void testVisitInterfaceMethodrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();

    // Act
    constantPoolRemapper.visitInterfaceMethodrefConstant(clazz, interfaceMethodrefConstant);

    // Assert
    assertEquals(1, interfaceMethodrefConstant.getClassIndex());
    assertEquals(1, interfaceMethodrefConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)}
   */
  @Test
  public void testVisitInterfaceMethodrefConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInterfaceMethodrefConstant(clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  public void testVisitMethodrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodrefConstant methodrefConstant = new MethodrefConstant();

    // Act
    constantPoolRemapper.visitMethodrefConstant(clazz, methodrefConstant);

    // Assert
    assertEquals(1, methodrefConstant.getClassIndex());
    assertEquals(1, methodrefConstant.getNameAndTypeIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  public void testVisitMethodrefConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodrefConstant(clazz, new MethodrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  public void testVisitClassConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    constantPoolRemapper.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(1, classConstant.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  public void testVisitClassConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitClassConstant(clazz, new ClassConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act
    constantPoolRemapper.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    assertEquals(1, methodTypeConstant.getDescriptorIndex());
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodTypeConstant(clazz, new MethodTypeConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  public void testVisitNameAndTypeConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.u2descriptorIndex);
    assertEquals(1, programField.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProgramField(programClass, new ProgramField()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    NamedField programField = new NamedField("Field Name", "Field Descriptor");

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.u2descriptorIndex);
    assertEquals(1, programField.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.u2descriptorIndex);
    assertEquals(1, programMethod.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProgramMethod(programClass, new ProgramMethod()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    NamedMember programMethod = new NamedMember("Member Name", "Descriptor");

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.u2descriptorIndex);
    assertEquals(1, programMethod.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  public void testVisitUnknownAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);

    // Act
    constantPoolRemapper.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    assertEquals(0, unknownAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  public void testVisitUnknownAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  public void testVisitBootstrapMethodsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Act
    constantPoolRemapper.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    assertEquals(1, bootstrapMethodsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  public void testVisitBootstrapMethodsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitBootstrapMethodsAttribute(clazz, new BootstrapMethodsAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  public void testVisitBootstrapMethodsAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitBootstrapMethodsAttribute(clazz,
        new BootstrapMethodsAttribute(1, 3, new BootstrapMethodInfo[]{new BootstrapMethodInfo()})));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceFileAttribute sourceFileAttribute = new SourceFileAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    assertEquals(0, sourceFileAttribute.u2attributeNameIndex);
    assertEquals(0, sourceFileAttribute.u2sourceFileIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceDirAttribute sourceDirAttribute = new SourceDirAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    assertEquals(0, sourceDirAttribute.u2attributeNameIndex);
    assertEquals(0, sourceDirAttribute.u2sourceDirIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)}
   */
  @Test
  public void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute = new SourceDebugExtensionAttribute();

    // Act
    constantPoolRemapper.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    assertEquals(1, sourceDebugExtensionAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)}
   */
  @Test
  public void testVisitSourceDebugExtensionAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSourceDebugExtensionAttribute(clazz, new SourceDebugExtensionAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  public void testVisitRecordAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = new RecordAttribute();

    // Act
    constantPoolRemapper.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    assertEquals(1, recordAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  public void testVisitRecordAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRecordAttribute(clazz, new RecordAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  public void testVisitRecordAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitRecordAttribute(clazz,
        new RecordAttribute(1, 3, new RecordComponentInfo[]{new RecordComponentInfo()})));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}
   */
  @Test
  public void testVisitInnerClassesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute();

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(1, innerClassesAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}
   */
  @Test
  public void testVisitInnerClassesAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInnerClassesAttribute(clazz, new InnerClassesAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    constantPoolRemapper.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    assertEquals(0, enclosingMethodAttribute.u2attributeNameIndex);
    assertEquals(0, enclosingMethodAttribute.u2classIndex);
    assertEquals(0, enclosingMethodAttribute.u2nameAndTypeIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);

    // Act
    constantPoolRemapper.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    assertEquals(0, nestHostAttribute.u2attributeNameIndex);
    assertEquals(0, nestHostAttribute.u2hostClassIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}
   */
  @Test
  public void testVisitNestMembersAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestMembersAttribute nestMembersAttribute = new NestMembersAttribute();

    // Act
    constantPoolRemapper.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    assertEquals(1, nestMembersAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}
   */
  @Test
  public void testVisitNestMembersAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNestMembersAttribute(clazz, new NestMembersAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}
   */
  @Test
  public void testVisitNestMembersAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestMembersAttribute nestMembersAttribute = new NestMembersAttribute(1, 3, new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    int[] intArray = nestMembersAttribute.u2classes;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, nestMembersAttribute.u2attributeNameIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)}
   */
  @Test
  public void testVisitPermittedSubclassesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PermittedSubclassesAttribute permittedSubclassesAttribute = new PermittedSubclassesAttribute();

    // Act
    constantPoolRemapper.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    assertEquals(1, permittedSubclassesAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)}
   */
  @Test
  public void testVisitPermittedSubclassesAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitPermittedSubclassesAttribute(clazz, new PermittedSubclassesAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)}
   */
  @Test
  public void testVisitPermittedSubclassesAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PermittedSubclassesAttribute permittedSubclassesAttribute = new PermittedSubclassesAttribute(1, 3,
        new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    int[] intArray = permittedSubclassesAttribute.u2classes;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, permittedSubclassesAttribute.u2attributeNameIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  public void testVisitModuleAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleAttribute moduleAttribute = new ModuleAttribute();

    // Act
    constantPoolRemapper.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    assertEquals(1, moduleAttribute.u2attributeNameIndex);
    assertEquals(1, moduleAttribute.u2moduleNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  public void testVisitModuleAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleAttribute(clazz, new ModuleAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Act
    constantPoolRemapper.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    assertEquals(0, moduleMainClassAttribute.u2attributeNameIndex);
    assertEquals(0, moduleMainClassAttribute.u2mainClass);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}
   */
  @Test
  public void testVisitModulePackagesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModulePackagesAttribute modulePackagesAttribute = new ModulePackagesAttribute();

    // Act
    constantPoolRemapper.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    assertEquals(1, modulePackagesAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}
   */
  @Test
  public void testVisitModulePackagesAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}
   */
  @Test
  public void testVisitModulePackagesAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModulePackagesAttribute modulePackagesAttribute = new ModulePackagesAttribute(1, 3, new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    int[] intArray = modulePackagesAttribute.u2packages;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, modulePackagesAttribute.u2attributeNameIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)}
   */
  @Test
  public void testVisitDeprecatedAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    constantPoolRemapper.visitDeprecatedAttribute(clazz, deprecatedAttribute);

    // Assert
    assertEquals(0, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)}
   */
  @Test
  public void testVisitDeprecatedAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  public void testVisitSyntheticAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    constantPoolRemapper.visitSyntheticAttribute(clazz, syntheticAttribute);

    // Assert
    assertEquals(0, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  public void testVisitSyntheticAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSyntheticAttribute(clazz, new SyntheticAttribute(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}
   */
  @Test
  public void testVisitConstantValueAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ConstantValueAttribute constantValueAttribute = new ConstantValueAttribute(1, 1);

    // Act
    constantPoolRemapper.visitConstantValueAttribute(clazz, field, constantValueAttribute);

    // Assert
    assertEquals(0, constantValueAttribute.u2attributeNameIndex);
    assertEquals(0, constantValueAttribute.u2constantValueIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}
   */
  @Test
  public void testVisitConstantValueAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)}
   */
  @Test
  public void testVisitMethodParametersAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = new MethodParametersAttribute();

    // Act
    constantPoolRemapper.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    assertEquals(1, methodParametersAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)}
   */
  @Test
  public void testVisitMethodParametersAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodParametersAttribute(clazz, method, new MethodParametersAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}
   */
  @Test
  public void testVisitExceptionsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute();

    // Act
    constantPoolRemapper.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    assertEquals(1, exceptionsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}
   */
  @Test
  public void testVisitExceptionsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitCodeAttribute(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute3() throws UnsupportedEncodingException {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{-96, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{-60, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute6() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -60, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapAttribute stackMapAttribute = new StackMapAttribute();

    // Act
    constantPoolRemapper.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    assertEquals(1, stackMapAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)}
   */
  @Test
  public void testVisitStackMapAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  public void testVisitStackMapTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute();

    // Act
    constantPoolRemapper.visitStackMapTableAttribute(clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    assertEquals(1, stackMapTableAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  public void testVisitStackMapTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitStackMapTableAttribute(clazz, method,
        codeAttribute, new StackMapTableAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  public void testVisitLineNumberTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute();

    // Act
    constantPoolRemapper.visitLineNumberTableAttribute(clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    assertEquals(1, lineNumberTableAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  public void testVisitLineNumberTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitLineNumberTableAttribute(clazz, method,
        codeAttribute, new LineNumberTableAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute();

    // Act
    constantPoolRemapper.visitLocalVariableTableAttribute(clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    assertEquals(1, localVariableTableAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitLocalVariableTableAttribute(clazz,
        method, codeAttribute, new LocalVariableTableAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute();

    // Act
    constantPoolRemapper.visitLocalVariableTypeTableAttribute(clazz, method, codeAttribute,
        localVariableTypeTableAttribute);

    // Assert
    assertEquals(1, localVariableTypeTableAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTypeTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitLocalVariableTypeTableAttribute(clazz,
        method, codeAttribute, new LocalVariableTypeTableAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}
   */
  @Test
  public void testVisitAnyAnnotationsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    constantPoolRemapper.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    assertEquals(1, annotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}
   */
  @Test
  public void testVisitAnyAnnotationsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitAnyAnnotationsAttribute(clazz, new RuntimeInvisibleAnnotationsAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)}
   */
  @Test
  public void testVisitAnyParameterAnnotationsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute = new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    constantPoolRemapper.visitAnyParameterAnnotationsAttribute(clazz, method, parameterAnnotationsAttribute);

    // Assert
    assertEquals(1, parameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)}
   */
  @Test
  public void testVisitAnyParameterAnnotationsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitAnyParameterAnnotationsAttribute(clazz,
        method, new RuntimeInvisibleParameterAnnotationsAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationElementValue defaultValue = new AnnotationElementValue(1, new Annotation());

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute(1, defaultValue);

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    Annotation annotation = ((AnnotationElementValue) elementValue).annotationValue;
    assertEquals(1, annotation.u2typeIndex);
    assertSame(defaultValue.annotationValue, annotation);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute(1, new ArrayElementValue());

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(1, ((ArrayElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute(1,
        new ClassElementValue(1, 1));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ClassElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2classInfoIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute(1,
        new ConstantElementValue('\u0001'));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ConstantElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(1, ((ConstantElementValue) elementValue).u2constantValueIndex);
    assertEquals(1, ((ConstantElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute(1,
        new EnumConstantElementValue(1, 1, 1));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof EnumConstantElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2constantNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2typeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute6() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitAnnotationDefaultAttribute(clazz,
        method, new AnnotationDefaultAttribute(1, new AnnotationElementValue(1, new Annotation()))));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  public void testVisitBootstrapMethodInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();

    // Act
    constantPoolRemapper.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    assertEquals(1, bootstrapMethodInfo.u2methodHandleIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  public void testVisitBootstrapMethodInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  public void testVisitBootstrapMethodInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo(1, 3, new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    int[] intArray = bootstrapMethodInfo.u2methodArguments;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, bootstrapMethodInfo.u2methodHandleIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  public void testVisitRecordComponentInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    constantPoolRemapper.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    assertEquals(1, recordComponentInfo.u2descriptorIndex);
    assertEquals(1, recordComponentInfo.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  public void testVisitRecordComponentInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRecordComponentInfo(clazz, new RecordComponentInfo()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    innerClassesInfo.u2innerClassIndex = 0;
    innerClassesInfo.u2outerClassIndex = 0;
    innerClassesInfo.u2innerNameIndex = 0;

    // Act
    constantPoolRemapper.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(0, innerClassesInfo.u2innerClassIndex);
    assertEquals(0, innerClassesInfo.u2innerNameIndex);
    assertEquals(0, innerClassesInfo.u2outerClassIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    constantPoolRemapper.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(0, innerClassesInfo.u2innerClassIndex);
    assertEquals(0, innerClassesInfo.u2innerNameIndex);
    assertEquals(0, innerClassesInfo.u2outerClassIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    exceptionInfo.u2catchType = 0;

    // Act
    constantPoolRemapper.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert that nothing has changed
    assertEquals(0, exceptionInfo.u2catchType);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act
    constantPoolRemapper.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert
    assertEquals(0, exceptionInfo.u2catchType);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitConstantInstruction(clazz, method,
        codeAttribute, 2, new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(VerificationTypeFactory.createObjectType(1));

    // Act
    constantPoolRemapper.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    VerificationType verificationType = sameOneFrame.stackItem;
    assertTrue(verificationType instanceof ObjectType);
    assertEquals(0, ((ObjectType) verificationType).u2classIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitSameOneFrame(clazz, method,
        codeAttribute, 2, new SameOneFrame(VerificationTypeFactory.createObjectType(1))));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)}
   */
  @Test
  public void testVisitObjectType() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ObjectType objectType = VerificationTypeFactory.createObjectType(1);

    // Act
    constantPoolRemapper.visitObjectType(clazz, method, codeAttribute, 2, objectType);

    // Assert
    assertEquals(0, objectType.u2classIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)}
   */
  @Test
  public void testVisitObjectType2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitObjectType(clazz, method,
        codeAttribute, 2, VerificationTypeFactory.createObjectType(1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int, ParameterInfo)}
   */
  @Test
  public void testVisitParameterInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ParameterInfo parameterInfo = new ParameterInfo(1, 1);

    // Act
    constantPoolRemapper.visitParameterInfo(clazz, method, 1, parameterInfo);

    // Assert
    assertEquals(0, parameterInfo.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int, ParameterInfo)}
   */
  @Test
  public void testVisitParameterInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act
    constantPoolRemapper.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    assertEquals(0, localVariableInfo.u2descriptorIndex);
    assertEquals(0, localVariableInfo.u2nameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitLocalVariableInfo(clazz, method,
        codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    constantPoolRemapper.visitLocalVariableTypeInfo(clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals(0, localVariableTypeInfo.u2nameIndex);
    assertEquals(0, localVariableTypeInfo.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitLocalVariableTypeInfo(clazz, method,
        codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RequiresInfo requiresInfo = new RequiresInfo(1, 1, 1);

    // Act
    constantPoolRemapper.visitRequiresInfo(clazz, requiresInfo);

    // Assert
    assertEquals(0, requiresInfo.u2requiresIndex);
    assertEquals(0, requiresInfo.u2requiresVersionIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  public void testVisitExportsInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ExportsInfo exportsInfo = new ExportsInfo();

    // Act
    constantPoolRemapper.visitExportsInfo(clazz, exportsInfo);

    // Assert
    assertEquals(1, exportsInfo.u2exportsIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  public void testVisitExportsInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitExportsInfo(clazz, new ExportsInfo()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  public void testVisitExportsInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ExportsInfo exportsInfo = new ExportsInfo(1, 1, 3, new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitExportsInfo(clazz, exportsInfo);

    // Assert
    int[] intArray = exportsInfo.u2exportsToIndex;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, exportsInfo.u2exportsIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  public void testVisitOpensInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    OpensInfo opensInfo = new OpensInfo();

    // Act
    constantPoolRemapper.visitOpensInfo(clazz, opensInfo);

    // Assert
    assertEquals(1, opensInfo.u2opensIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  public void testVisitOpensInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitOpensInfo(clazz, new OpensInfo()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  public void testVisitOpensInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    OpensInfo opensInfo = new OpensInfo(1, 1, 3, new int[]{1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitOpensInfo(clazz, opensInfo);

    // Assert
    int[] intArray = opensInfo.u2opensToIndex;
    assertEquals(0, intArray[0]);
    assertEquals(0, intArray[2]);
    assertEquals(0, opensInfo.u2opensIndex);
    assertEquals(1, intArray[1]);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  public void testVisitProvidesInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ProvidesInfo providesInfo = new ProvidesInfo();

    // Act
    constantPoolRemapper.visitProvidesInfo(clazz, providesInfo);

    // Assert
    assertEquals(1, providesInfo.u2providesIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  public void testVisitProvidesInfo2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProvidesInfo(clazz, new ProvidesInfo()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  public void testVisitProvidesInfo3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ProvidesInfo providesInfo = new ProvidesInfo(1, 1, new int[]{1, 2, 1, 2});

    // Act
    constantPoolRemapper.visitProvidesInfo(clazz, providesInfo);

    // Assert
    int[] intArray = providesInfo.u2providesWithIndex;
    assertEquals(0, intArray[0]);
    assertEquals(0, providesInfo.u2providesIndex);
    assertEquals(4, intArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}
   */
  @Test
  public void testVisitConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ConstantElementValue constantElementValue = new ConstantElementValue('A');

    // Act
    constantPoolRemapper.visitConstantElementValue(clazz, annotation, constantElementValue);

    // Assert
    assertEquals(1, constantElementValue.u2constantValueIndex);
    assertEquals(1, constantElementValue.u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}
   */
  @Test
  public void testVisitConstantElementValue2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitConstantElementValue(clazz, annotation, new ConstantElementValue('A')));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    // Act
    constantPoolRemapper.visitEnumConstantElementValue(clazz, annotation, enumConstantElementValue);

    // Assert
    assertEquals(0, enumConstantElementValue.u2elementNameIndex);
    assertEquals(0, enumConstantElementValue.u2constantNameIndex);
    assertEquals(0, enumConstantElementValue.u2typeNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitEnumConstantElementValue(clazz,
        annotation, new EnumConstantElementValue(1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = new ClassElementValue(1, 1);

    // Act
    constantPoolRemapper.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    assertEquals(0, classElementValue.u2classInfoIndex);
    assertEquals(0, classElementValue.u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)}
   */
  @Test
  public void testVisitAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = new AnnotationElementValue(1, new Annotation());

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    assertEquals(0, annotationElementValue.u2elementNameIndex);
    assertEquals(1, annotationElementValue.annotationValue.u2typeIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)}
   */
  @Test
  public void testVisitAnnotationElementValue2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantPoolRemapper.visitAnnotationElementValue(clazz,
        annotation, new AnnotationElementValue(1, new Annotation())));
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}
   */
  @Test
  public void testVisitArrayElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = new ArrayElementValue();

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    assertEquals(1, arrayElementValue.u2elementNameIndex);
  }

  /**
   * Method under test:
   * {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}
   */
  @Test
  public void testVisitArrayElementValue2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> constantPoolRemapper.visitArrayElementValue(clazz, annotation, new ArrayElementValue()));
  }
}
