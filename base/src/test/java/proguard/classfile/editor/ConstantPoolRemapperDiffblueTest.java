package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
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
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProgramClass(new ProgramClass()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenThrowIllegalArgumentException2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitProgramClass(
                new ProgramClass(
                    1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2superClass} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_whenProgramClass_thenProgramClassU2superClassIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then {@link StringConstant#StringConstant()} {@link StringConstant#u2stringIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitStringConstant(Clazz, StringConstant)"})
  public void testVisitStringConstant_thenStringConstantU2stringIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();

    // Act
    constantPoolRemapper.visitStringConstant(clazz, stringConstant);

    // Assert
    assertEquals(1, stringConstant.u2stringIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitStringConstant(Clazz, StringConstant)"})
  public void testVisitStringConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitStringConstant(clazz, new StringConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then {@link DynamicConstant#DynamicConstant()} NameAndTypeIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenDynamicConstantNameAndTypeIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    constantPoolRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(1, dynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then {@link InvokeDynamicConstant#InvokeDynamicConstant()} NameAndTypeIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant_thenInvokeDynamicConstantNameAndTypeIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    constantPoolRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(1, invokeDynamicConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act
    constantPoolRemapper.visitMethodHandleConstant(clazz, methodHandleConstant);

    // Assert
    assertEquals(0, methodHandleConstant.getReferenceIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then {@link ModuleConstant#ModuleConstant(int)} with u2nameIndex is one {@link
   *       ModuleConstant#u2nameIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenModuleConstantWithU2nameIndexIsOneU2nameIndexIsZero() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act
    constantPoolRemapper.visitModuleConstant(clazz, moduleConstant);

    // Assert
    assertEquals(0, moduleConstant.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleConstant(clazz, new ModuleConstant(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PackageConstant packageConstant = new PackageConstant(1);

    // Act
    constantPoolRemapper.visitPackageConstant(clazz, packageConstant);

    // Assert
    assertEquals(0, packageConstant.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitPackageConstant(clazz, new PackageConstant(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then {@link FieldrefConstant#FieldrefConstant()} ClassIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  public void testVisitFieldrefConstant_thenFieldrefConstantClassIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act
    constantPoolRemapper.visitFieldrefConstant(clazz, fieldrefConstant);

    // Assert
    assertEquals(1, fieldrefConstant.getClassIndex());
    assertEquals(1, fieldrefConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  public void testVisitFieldrefConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitFieldrefConstant(clazz, new FieldrefConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  public void testVisitInterfaceMethodrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();

    // Act
    constantPoolRemapper.visitInterfaceMethodrefConstant(clazz, interfaceMethodrefConstant);

    // Assert
    assertEquals(1, interfaceMethodrefConstant.getClassIndex());
    assertEquals(1, interfaceMethodrefConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  public void testVisitInterfaceMethodrefConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitInterfaceMethodrefConstant(
                clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then {@link MethodrefConstant#MethodrefConstant()} ClassIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  public void testVisitMethodrefConstant_thenMethodrefConstantClassIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodrefConstant methodrefConstant = new MethodrefConstant();

    // Act
    constantPoolRemapper.visitMethodrefConstant(clazz, methodrefConstant);

    // Assert
    assertEquals(1, methodrefConstant.getClassIndex());
    assertEquals(1, methodrefConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  public void testVisitMethodrefConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodrefConstant(clazz, new MethodrefConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then {@link ClassConstant#ClassConstant()} {@link ClassConstant#u2nameIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant_thenClassConstantU2nameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    constantPoolRemapper.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(1, classConstant.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitClassConstant(clazz, new ClassConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then {@link MethodTypeConstant#MethodTypeConstant()} DescriptorIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  public void testVisitMethodTypeConstant_thenMethodTypeConstantDescriptorIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act
    constantPoolRemapper.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    assertEquals(1, methodTypeConstant.getDescriptorIndex());
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  public void testVisitMethodTypeConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitMethodTypeConstant(clazz, new MethodTypeConstant()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  public void testVisitNameAndTypeConstant_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  public void testVisitProgramField() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    NamedField programField = new NamedField("Field Name", "Field Descriptor");

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.u2descriptorIndex);
    assertEquals(1, programField.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  public void testVisitProgramField_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProgramField(programClass, new ProgramField()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>When {@link ProgramField#ProgramField()}.
   *   <li>Then {@link ProgramField#ProgramField()} {@link ProgramMember#u2descriptorIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  public void testVisitProgramField_whenProgramField_thenProgramFieldU2descriptorIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.u2descriptorIndex);
    assertEquals(1, programField.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    NamedMember programMethod = new NamedMember("Member Name", "Descriptor");

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.u2descriptorIndex);
    assertEquals(1, programMethod.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProgramMethod(programClass, new ProgramMethod()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramMethod#ProgramMethod()}.
   *   <li>Then {@link ProgramMethod#ProgramMethod()} {@link ProgramMember#u2descriptorIndex} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod_whenProgramMethod_thenProgramMethodU2descriptorIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.u2descriptorIndex);
    assertEquals(1, programMethod.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitUnknownAttribute(Clazz, UnknownAttribute)"})
  public void testVisitUnknownAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);

    // Act
    constantPoolRemapper.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    assertEquals(0, unknownAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitUnknownAttribute(Clazz, UnknownAttribute)"})
  public void testVisitUnknownAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  public void testVisitBootstrapMethodsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Act
    constantPoolRemapper.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    assertEquals(1, bootstrapMethodsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  public void testVisitBootstrapMethodsAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitBootstrapMethodsAttribute(
                clazz, new BootstrapMethodsAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  public void testVisitBootstrapMethodsAttribute_thenThrowIllegalArgumentException2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitBootstrapMethodsAttribute(
                clazz,
                new BootstrapMethodsAttribute(
                    1, 3, new BootstrapMethodInfo[] {new BootstrapMethodInfo()})));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceFileAttribute sourceFileAttribute = new SourceFileAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    assertEquals(0, sourceFileAttribute.u2attributeNameIndex);
    assertEquals(0, sourceFileAttribute.u2sourceFileIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  public void testVisitSourceDirAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceDirAttribute sourceDirAttribute = new SourceDirAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    assertEquals(0, sourceDirAttribute.u2attributeNameIndex);
    assertEquals(0, sourceDirAttribute.u2sourceDirIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  public void testVisitSourceDirAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)"
  })
  public void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute();

    // Act
    constantPoolRemapper.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    assertEquals(1, sourceDebugExtensionAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)"
  })
  public void testVisitSourceDebugExtensionAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitSourceDebugExtensionAttribute(
                clazz, new SourceDebugExtensionAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then {@link RecordAttribute#RecordAttribute()} {@link Attribute#u2attributeNameIndex} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRecordAttribute(Clazz, RecordAttribute)"})
  public void testVisitRecordAttribute_thenRecordAttributeU2attributeNameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = new RecordAttribute();

    // Act
    constantPoolRemapper.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    assertEquals(1, recordAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRecordAttribute(Clazz, RecordAttribute)"})
  public void testVisitRecordAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRecordAttribute(clazz, new RecordAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRecordAttribute(Clazz, RecordAttribute)"})
  public void testVisitRecordAttribute_thenThrowIllegalArgumentException2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitRecordAttribute(
                clazz,
                new RecordAttribute(1, 3, new RecordComponentInfo[] {new RecordComponentInfo()})));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  public void testVisitInnerClassesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute();

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(1, innerClassesAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  public void testVisitInnerClassesAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInnerClassesAttribute(clazz, new InnerClassesAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitEnclosingMethodAttribute(
                clazz, new EnclosingMethodAttribute(1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestHostAttribute nestHostAttribute = new NestHostAttribute(1, 1);

    // Act
    constantPoolRemapper.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    assertEquals(0, nestHostAttribute.u2attributeNameIndex);
    assertEquals(0, nestHostAttribute.u2hostClassIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNestMembersAttribute(Clazz, NestMembersAttribute)"
  })
  public void testVisitNestMembersAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestMembersAttribute nestMembersAttribute =
        new NestMembersAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    assertEquals(0, nestMembersAttribute.u2attributeNameIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, nestMembersAttribute.u2classes);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then {@link NestMembersAttribute#NestMembersAttribute()} {@link
   *       NestMembersAttribute#u2classes} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNestMembersAttribute(Clazz, NestMembersAttribute)"
  })
  public void testVisitNestMembersAttribute_thenNestMembersAttributeU2classesIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    NestMembersAttribute nestMembersAttribute = new NestMembersAttribute();

    // Act
    constantPoolRemapper.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    assertNull(nestMembersAttribute.u2classes);
    assertEquals(1, nestMembersAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNestMembersAttribute(Clazz, NestMembersAttribute)"
  })
  public void testVisitNestMembersAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitNestMembersAttribute(clazz, new NestMembersAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)"
  })
  public void testVisitPermittedSubclassesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PermittedSubclassesAttribute permittedSubclassesAttribute = new PermittedSubclassesAttribute();

    // Act
    constantPoolRemapper.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    assertNull(permittedSubclassesAttribute.u2classes);
    assertEquals(1, permittedSubclassesAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)"
  })
  public void testVisitPermittedSubclassesAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    PermittedSubclassesAttribute permittedSubclassesAttribute =
        new PermittedSubclassesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    assertEquals(0, permittedSubclassesAttribute.u2attributeNameIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, permittedSubclassesAttribute.u2classes);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)"
  })
  public void testVisitPermittedSubclassesAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitPermittedSubclassesAttribute(
                clazz, new PermittedSubclassesAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then {@link ModuleAttribute#ModuleAttribute()} {@link Attribute#u2attributeNameIndex} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleAttribute(Clazz, ModuleAttribute)"})
  public void testVisitModuleAttribute_thenModuleAttributeU2attributeNameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleAttribute moduleAttribute = new ModuleAttribute();

    // Act
    constantPoolRemapper.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    assertEquals(1, moduleAttribute.u2attributeNameIndex);
    assertEquals(1, moduleAttribute.u2moduleNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleAttribute(Clazz, ModuleAttribute)"})
  public void testVisitModuleAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleAttribute(clazz, new ModuleAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Act
    constantPoolRemapper.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    assertEquals(0, moduleMainClassAttribute.u2attributeNameIndex);
    assertEquals(0, moduleMainClassAttribute.u2mainClass);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitModuleMainClassAttribute(
                clazz, new ModuleMainClassAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)"
  })
  public void testVisitModulePackagesAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModulePackagesAttribute modulePackagesAttribute =
        new ModulePackagesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    assertEquals(0, modulePackagesAttribute.u2attributeNameIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, modulePackagesAttribute.u2packages);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then {@link ModulePackagesAttribute#ModulePackagesAttribute()} {@link
   *       ModulePackagesAttribute#u2packages} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)"
  })
  public void testVisitModulePackagesAttribute_thenModulePackagesAttributeU2packagesIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModulePackagesAttribute modulePackagesAttribute = new ModulePackagesAttribute();

    // Act
    constantPoolRemapper.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    assertNull(modulePackagesAttribute.u2packages);
    assertEquals(1, modulePackagesAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)"
  })
  public void testVisitModulePackagesAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitModulePackagesAttribute(
                clazz, new ModulePackagesAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitDeprecatedAttribute(Clazz, DeprecatedAttribute)"
  })
  public void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    constantPoolRemapper.visitDeprecatedAttribute(clazz, deprecatedAttribute);

    // Assert
    assertEquals(0, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitDeprecatedAttribute(Clazz, DeprecatedAttribute)"
  })
  public void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with
   * {@code clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSyntheticAttribute(Clazz, SyntheticAttribute)"
  })
  public void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    constantPoolRemapper.visitSyntheticAttribute(clazz, syntheticAttribute);

    // Assert
    assertEquals(0, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with
   * {@code clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSyntheticAttribute(Clazz, SyntheticAttribute)"
  })
  public void testVisitSyntheticAttributeWithClazzSyntheticAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSyntheticAttribute(clazz, new SyntheticAttribute(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    constantPoolRemapper.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)"
  })
  public void testVisitConstantValueAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)"
  })
  public void testVisitConstantValueAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitConstantValueAttribute(
                clazz, field, new ConstantValueAttribute(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)"
  })
  public void testVisitMethodParametersAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = new MethodParametersAttribute();

    // Act
    constantPoolRemapper.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    assertEquals(1, methodParametersAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)"
  })
  public void testVisitMethodParametersAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitMethodParametersAttribute(
                clazz, method, new MethodParametersAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then {@link ExceptionsAttribute#ExceptionsAttribute()} {@link
   *       Attribute#u2attributeNameIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)"
  })
  public void testVisitExceptionsAttribute_thenExceptionsAttributeU2attributeNameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute();

    // Act
    constantPoolRemapper.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    assertEquals(1, exceptionsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)"
  })
  public void testVisitExceptionsAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitExceptionsAttribute(
                clazz, method, new ExceptionsAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute2() throws UnsupportedEncodingException {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {-96, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {-60, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -60, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertEquals(0, codeAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitCodeAttribute(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then {@link StackMapAttribute#StackMapAttribute()} {@link Attribute#u2attributeNameIndex}
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_thenStackMapAttributeU2attributeNameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  public void testVisitStackMapAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitStackMapAttribute(
                clazz, method, codeAttribute, new StackMapAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  public void testVisitStackMapTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute();

    // Act
    constantPoolRemapper.visitStackMapTableAttribute(
        clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    assertEquals(1, stackMapTableAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  public void testVisitStackMapTableAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitStackMapTableAttribute(
                clazz, method, codeAttribute, new StackMapTableAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)"
  })
  public void testVisitLineNumberTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute();

    // Act
    constantPoolRemapper.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    assertEquals(1, lineNumberTableAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)"
  })
  public void testVisitLineNumberTableAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLineNumberTableAttribute(
                clazz, method, codeAttribute, new LineNumberTableAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)"
  })
  public void testVisitLocalVariableTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute();

    // Act
    constantPoolRemapper.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    assertEquals(1, localVariableTableAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)"
  })
  public void testVisitLocalVariableTableAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableTableAttribute(
                clazz, method, codeAttribute, new LocalVariableTableAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)"
  })
  public void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();

    // Act
    constantPoolRemapper.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    assertEquals(1, localVariableTypeTableAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)"
  })
  public void testVisitLocalVariableTypeTableAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableTypeTableAttribute(
                clazz, method, codeAttribute, new LocalVariableTypeTableAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)"
  })
  public void testVisitAnyAnnotationsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    constantPoolRemapper.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    assertEquals(1, annotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)"
  })
  public void testVisitAnyAnnotationsAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitAnyAnnotationsAttribute(
                clazz, new RuntimeInvisibleAnnotationsAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)"
  })
  public void testVisitAnyParameterAnnotationsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    constantPoolRemapper.visitAnyParameterAnnotationsAttribute(
        clazz, method, parameterAnnotationsAttribute);

    // Assert
    assertEquals(1, parameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)"
  })
  public void testVisitAnyParameterAnnotationsAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitAnyParameterAnnotationsAttribute(
                clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new AnnotationElementValue(1, new Annotation()));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, ((AnnotationElementValue) elementValue).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue());

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(1, ((ArrayElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ClassElementValue(1, 1));

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
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ConstantElementValue('\u0001'));

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
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new EnumConstantElementValue(1, 1, 1));

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
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  public void testVisitAnnotationDefaultAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitAnnotationDefaultAttribute(
                clazz,
                method,
                new AnnotationDefaultAttribute(
                    1, new AnnotationElementValue(1, new Annotation()))));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo(1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    assertEquals(0, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then {@link BootstrapMethodInfo#BootstrapMethodInfo()} {@link
   *       BootstrapMethodInfo#u2methodArguments} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo_thenBootstrapMethodInfoU2methodArgumentsIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();

    // Act
    constantPoolRemapper.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    assertNull(bootstrapMethodInfo.u2methodArguments);
    assertEquals(1, bootstrapMethodInfo.u2methodHandleIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then {@link RecordComponentInfo#RecordComponentInfo()} {@link
   *       RecordComponentInfo#u2descriptorIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitRecordComponentInfo(Clazz, RecordComponentInfo)"
  })
  public void testVisitRecordComponentInfo_thenRecordComponentInfoU2descriptorIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    constantPoolRemapper.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    assertEquals(1, recordComponentInfo.u2descriptorIndex);
    assertEquals(1, recordComponentInfo.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitRecordComponentInfo(Clazz, RecordComponentInfo)"
  })
  public void testVisitRecordComponentInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRecordComponentInfo(clazz, new RecordComponentInfo()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo_givenZero() {
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
   * Test {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo_givenZero() {
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
   * Test {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)"
  })
  public void testVisitConstantInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitConstantInstruction(
                clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitSameOneFrame(
                clazz,
                method,
                codeAttribute,
                2,
                new SameOneFrame(VerificationTypeFactory.createObjectType(1))));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute, int,
   * ObjectType)}.
   *
   * <ul>
   *   <li>Then createObjectType one {@link ObjectType#u2classIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute,
   * int, ObjectType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)"
  })
  public void testVisitObjectType_thenCreateObjectTypeOneU2classIndexIsZero() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute, int,
   * ObjectType)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitObjectType(Clazz, Method, CodeAttribute,
   * int, ObjectType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)"
  })
  public void testVisitObjectType_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitObjectType(
                clazz, method, codeAttribute, 2, VerificationTypeFactory.createObjectType(1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitParameterInfo(Clazz, Method, int, ParameterInfo)"
  })
  public void testVisitParameterInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ParameterInfo parameterInfo = new ParameterInfo(1, 1);

    // Act
    constantPoolRemapper.visitParameterInfo(clazz, method, 1, parameterInfo);

    // Assert
    assertEquals(0, parameterInfo.u2nameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitParameterInfo(Clazz, Method, int, ParameterInfo)"
  })
  public void testVisitParameterInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  public void testVisitLocalVariableInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  public void testVisitLocalVariableInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableInfo(
                clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  public void testVisitLocalVariableTypeInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    constantPoolRemapper.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals(0, localVariableTypeInfo.u2nameIndex);
    assertEquals(0, localVariableTypeInfo.u2signatureIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  public void testVisitLocalVariableTypeInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableTypeInfo(
                clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RequiresInfo requiresInfo = new RequiresInfo(1, 1, 1);

    // Act
    constantPoolRemapper.visitRequiresInfo(clazz, requiresInfo);

    // Assert
    assertEquals(0, requiresInfo.u2requiresIndex);
    assertEquals(0, requiresInfo.u2requiresVersionIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitExportsInfo(Clazz, ExportsInfo)"})
  public void testVisitExportsInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ExportsInfo exportsInfo = new ExportsInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitExportsInfo(clazz, exportsInfo);

    // Assert
    assertEquals(0, exportsInfo.u2exportsIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, exportsInfo.u2exportsToIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <ul>
   *   <li>Then {@link ExportsInfo#ExportsInfo()} {@link ExportsInfo#u2exportsToIndex} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitExportsInfo(Clazz, ExportsInfo)"})
  public void testVisitExportsInfo_thenExportsInfoU2exportsToIndexIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ExportsInfo exportsInfo = new ExportsInfo();

    // Act
    constantPoolRemapper.visitExportsInfo(clazz, exportsInfo);

    // Assert
    assertNull(exportsInfo.u2exportsToIndex);
    assertEquals(1, exportsInfo.u2exportsIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitExportsInfo(Clazz, ExportsInfo)"})
  public void testVisitExportsInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitExportsInfo(clazz, new ExportsInfo()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitOpensInfo(Clazz, OpensInfo)"})
  public void testVisitOpensInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    OpensInfo opensInfo = new OpensInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitOpensInfo(clazz, opensInfo);

    // Assert
    assertEquals(0, opensInfo.u2opensIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, opensInfo.u2opensToIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <ul>
   *   <li>Then {@link OpensInfo#OpensInfo()} {@link OpensInfo#u2opensToIndex} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitOpensInfo(Clazz, OpensInfo)"})
  public void testVisitOpensInfo_thenOpensInfoU2opensToIndexIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    OpensInfo opensInfo = new OpensInfo();

    // Act
    constantPoolRemapper.visitOpensInfo(clazz, opensInfo);

    // Assert
    assertNull(opensInfo.u2opensToIndex);
    assertEquals(1, opensInfo.u2opensIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitOpensInfo(Clazz, OpensInfo)"})
  public void testVisitOpensInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitOpensInfo(clazz, new OpensInfo()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProvidesInfo(Clazz, ProvidesInfo)"})
  public void testVisitProvidesInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ProvidesInfo providesInfo = new ProvidesInfo(1, 1, new int[] {1, 2, 1, 2});

    // Act
    constantPoolRemapper.visitProvidesInfo(clazz, providesInfo);

    // Assert
    assertEquals(0, providesInfo.u2providesIndex);
    assertArrayEquals(new int[] {0, 2, 1, 2}, providesInfo.u2providesWithIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <ul>
   *   <li>Then {@link ProvidesInfo#ProvidesInfo()} {@link ProvidesInfo#u2providesWithIndex} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProvidesInfo(Clazz, ProvidesInfo)"})
  public void testVisitProvidesInfo_thenProvidesInfoU2providesWithIndexIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ProvidesInfo providesInfo = new ProvidesInfo();

    // Act
    constantPoolRemapper.visitProvidesInfo(clazz, providesInfo);

    // Assert
    assertNull(providesInfo.u2providesWithIndex);
    assertEquals(1, providesInfo.u2providesIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProvidesInfo(Clazz, ProvidesInfo)"})
  public void testVisitProvidesInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitProvidesInfo(clazz, new ProvidesInfo()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then {@link Annotation#Annotation()} {@link Annotation#u2typeIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation_thenAnnotationU2typeIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantElementValue(Clazz, Annotation, ConstantElementValue)"
  })
  public void testVisitConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantElementValue(Clazz, Annotation, ConstantElementValue)"
  })
  public void testVisitConstantElementValue_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitConstantElementValue(
                clazz, annotation, new ConstantElementValue('A')));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitEnumConstantElementValue(
                clazz, annotation, new EnumConstantElementValue(1, 1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitClassElementValue(
                clazz, annotation, new ClassElementValue(1, 1)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  public void testVisitAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
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
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  public void testVisitAnnotationElementValue_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitAnnotationElementValue(
                clazz, annotation, new AnnotationElementValue(1, new Annotation())));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then {@link ArrayElementValue#ArrayElementValue()} {@link
   *       ElementValue#u2elementNameIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  public void testVisitArrayElementValue_thenArrayElementValueU2elementNameIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = new ArrayElementValue();

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    assertEquals(1, arrayElementValue.u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  public void testVisitArrayElementValue_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitArrayElementValue(
                clazz, annotation, new ArrayElementValue()));
  }
}
