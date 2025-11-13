package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
import proguard.classfile.attribute.preverification.DoubleType;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.LessZeroFrame;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.ObjectType;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.SameZeroFrame;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
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

class ConstantPoolRemapperDiffblueTest {
  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    FloatConstant floatConstant = new FloatConstant(10.0f);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, floatConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    IntegerConstant integerConstant = new IntegerConstant(42);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, integerConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element ClassConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, classConstant3}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
    assertSame(classConstant3, constantArray[2]);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element DynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertNull(programClass.getSuperName());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((DynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element FieldrefConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof FieldrefConstant);
    assertNull(programClass.getSuperClass());
    assertEquals(1, ((FieldrefConstant) constant2).getClassIndex());
    assertEquals(1, ((FieldrefConstant) constant2).getNameAndTypeIndex());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link InterfaceMethodrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then second element InterfaceMethodrefConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementInterfaceMethodrefConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, interfaceMethodrefConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof InterfaceMethodrefConstant);
    assertNull(programClass.getSuperClass());
    assertEquals(1, ((InterfaceMethodrefConstant) constant2).getClassIndex());
    assertEquals(1, ((InterfaceMethodrefConstant) constant2).getNameAndTypeIndex());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link InvokeDynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element InvokeDynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementInvokeDynamicConstant() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ClassConstant classConstant = new ClassConstant();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, invokeDynamicConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    constantPoolRemapper.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof InvokeDynamicConstant);
    assertNull(programClass.getSuperName());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, ((InvokeDynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(3, constantArray.length);
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
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass(); then ProgramClass() u2superClass is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_whenProgramClass_thenProgramClassU2superClassIsOne() {
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
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then StringConstant() u2stringIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitStringConstant(Clazz, StringConstant)"})
  void testVisitStringConstant_thenStringConstantU2stringIndexIsOne() {
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
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitStringConstant(Clazz, StringConstant)"})
  void testVisitStringConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then DynamicConstant() NameAndTypeIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenDynamicConstantNameAndTypeIndexIsOne() {
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
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then InvokeDynamicConstant() NameAndTypeIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenInvokeDynamicConstantNameAndTypeIndexIsOne() {
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
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant() {
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
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then ModuleConstant(int) with u2nameIndex is one u2nameIndex is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleConstant(Clazz, ModuleConstant)"})
  void testVisitModuleConstant_thenModuleConstantWithU2nameIndexIsOneU2nameIndexIsZero() {
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
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleConstant(Clazz, ModuleConstant)"})
  void testVisitModuleConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitPackageConstant(Clazz, PackageConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitPackageConstant(Clazz, PackageConstant)"})
  void testVisitPackageConstant() {
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
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitPackageConstant(Clazz, PackageConstant)"})
  void testVisitPackageConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then FieldrefConstant() ClassIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  void testVisitFieldrefConstant_thenFieldrefConstantClassIndexIsOne() {
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
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  void testVisitFieldrefConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant() {
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
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then MethodrefConstant() ClassIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  void testVisitMethodrefConstant_thenMethodrefConstantClassIndexIsOne() {
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
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  void testVisitMethodrefConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then ClassConstant() u2nameIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitClassConstant(Clazz, ClassConstant)"})
  void testVisitClassConstant_thenClassConstantU2nameIndexIsOne() {
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
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitClassConstant(Clazz, ClassConstant)"})
  void testVisitClassConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then MethodTypeConstant() DescriptorIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenMethodTypeConstantDescriptorIndexIsOne() {
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
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenThrowIllegalArgumentException() {
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
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName("Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenDoesNotThrow() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertDoesNotThrow(
        () -> constantPoolRemapper.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
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
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField() {
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
   *   <li>Then first element {@link ConstantValueAttribute}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then first element ConstantValueAttribute")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_thenFirstElementConstantValueAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    Attribute[] attributes = new Attribute[] {new ConstantValueAttribute(1, 1)};
    ProgramField programField = new ProgramField(1, 1, 1, 1, attributes, new LibraryClass());

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    Attribute[] attributeArray = programField.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof ConstantValueAttribute);
    assertEquals(0, programField.u2descriptorIndex);
    assertEquals(0, programField.u2nameIndex);
    assertEquals(0, ((ConstantValueAttribute) attribute).u2attributeNameIndex);
    assertEquals(0, ((ConstantValueAttribute) attribute).u2constantValueIndex);
    assertEquals(1, attributeArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then first element {@link DeprecatedAttribute}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then first element DeprecatedAttribute")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_thenFirstElementDeprecatedAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    Attribute[] attributes = new Attribute[] {new DeprecatedAttribute(1)};
    ProgramField programField = new ProgramField(1, 1, 1, 1, attributes, new LibraryClass());

    // Act
    constantPoolRemapper.visitProgramField(programClass, programField);

    // Assert
    Attribute[] attributeArray = programField.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof DeprecatedAttribute);
    assertEquals(0, programField.u2descriptorIndex);
    assertEquals(0, programField.u2nameIndex);
    assertEquals(0, ((DeprecatedAttribute) attribute).u2attributeNameIndex);
    assertEquals(1, attributeArray.length);
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
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); when ProgramField(); then ProgramField() u2descriptorIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_whenProgramField_thenProgramFieldU2descriptorIndexIsOne() {
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
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    Attribute[] attributes = new Attribute[] {new CodeAttribute(1)};
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, 1, attributes, referencedClasses);

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    Attribute[] attributeArray = programMethod.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof CodeAttribute);
    assertEquals(0, programMethod.u2descriptorIndex);
    assertEquals(0, programMethod.u2nameIndex);
    assertEquals(0, ((CodeAttribute) attribute).u2attributeNameIndex);
    assertEquals(1, attributeArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    Attribute[] attributes = new Attribute[] {codeAttribute};
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, 1, attributes, referencedClasses);

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    Attribute[] attributeArray = programMethod.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof CodeAttribute);
    assertEquals(0, programMethod.u2descriptorIndex);
    assertEquals(0, programMethod.u2nameIndex);
    assertEquals(0, ((CodeAttribute) attribute).u2attributeNameIndex);
    assertEquals(1, attributeArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then first element {@link AnnotationDefaultAttribute}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then first element AnnotationDefaultAttribute")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_thenFirstElementAnnotationDefaultAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    AnnotationElementValue defaultValue = new AnnotationElementValue(1, new Annotation());
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, defaultValue);
    Attribute[] attributes = new Attribute[] {annotationDefaultAttribute};
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, 1, attributes, referencedClasses);

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    Attribute[] attributeArray = programMethod.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof AnnotationDefaultAttribute);
    ElementValue elementValue = ((AnnotationDefaultAttribute) attribute).defaultValue;
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, programMethod.u2descriptorIndex);
    assertEquals(0, programMethod.u2nameIndex);
    assertEquals(0, ((AnnotationDefaultAttribute) attribute).u2attributeNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, attributeArray.length);
    assertEquals(1, ((AnnotationElementValue) elementValue).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then first element {@link DeprecatedAttribute}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then first element DeprecatedAttribute")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_thenFirstElementDeprecatedAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    ProgramClass programClass = new ProgramClass();
    Attribute[] attributes = new Attribute[] {new DeprecatedAttribute(1)};
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, 1, attributes, referencedClasses);

    // Act
    constantPoolRemapper.visitProgramMethod(programClass, programMethod);

    // Assert
    Attribute[] attributeArray = programMethod.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof DeprecatedAttribute);
    assertEquals(0, programMethod.u2descriptorIndex);
    assertEquals(0, programMethod.u2nameIndex);
    assertEquals(0, ((DeprecatedAttribute) attribute).u2attributeNameIndex);
    assertEquals(1, attributeArray.length);
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
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramMethod(); then ProgramMethod() u2descriptorIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_whenProgramMethod_thenProgramMethodU2descriptorIndexIsOne() {
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
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitUnknownAttribute(Clazz, UnknownAttribute)"})
  void testVisitUnknownAttribute() {
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
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitUnknownAttribute(Clazz, UnknownAttribute)"})
  void testVisitUnknownAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo[] bootstrapMethods =
        new BootstrapMethodInfo[] {new BootstrapMethodInfo(1, 3, new int[] {1, 0, 1, 0})};
    BootstrapMethodsAttribute bootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 1, bootstrapMethods);

    // Act
    constantPoolRemapper.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    assertEquals(0, bootstrapMethodsAttribute.u2attributeNameIndex);
    BootstrapMethodInfo[] bootstrapMethodInfoArray = bootstrapMethodsAttribute.bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertEquals(0, bootstrapMethodInfo.u2methodHandleIndex);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertArrayEquals(new int[] {0, 1, 0, 0}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link BootstrapMethodInfo#u2methodArguments} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then first element u2methodArguments is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenFirstElementU2methodArgumentsIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodsAttribute bootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 1, bootstrapMethods);

    // Act
    constantPoolRemapper.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    BootstrapMethodInfo[] bootstrapMethodInfoArray = bootstrapMethodsAttribute.bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.u2methodArguments);
    assertEquals(0, bootstrapMethodsAttribute.u2attributeNameIndex);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, bootstrapMethodInfo.u2methodHandleIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute() {
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
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute() {
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
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute() {
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
  @DisplayName(
      "Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute_thenThrowIllegalArgumentException() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName("Test visitRecordAttribute(Clazz, RecordAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRecordAttribute(Clazz, RecordAttribute)"})
  void testVisitRecordAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo[] components = new RecordComponentInfo[] {new RecordComponentInfo()};
    RecordAttribute recordAttribute = new RecordAttribute(1, 1, components);

    // Act
    constantPoolRemapper.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    assertEquals(0, recordAttribute.u2attributeNameIndex);
    RecordComponentInfo[] recordComponentInfoArray = recordAttribute.components;
    assertEquals(1, recordComponentInfoArray.length);
    RecordComponentInfo recordComponentInfo = recordComponentInfoArray[0];
    assertEquals(1, recordComponentInfo.u2descriptorIndex);
    assertEquals(1, recordComponentInfo.u2nameIndex);
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
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then RecordAttribute() u2attributeNameIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRecordAttribute(Clazz, RecordAttribute)"})
  void testVisitRecordAttribute_thenRecordAttributeU2attributeNameIndexIsOne() {
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
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(1, 1, classes);

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(0, innerClassesAttribute.u2attributeNameIndex);
    InnerClassesInfo[] innerClassesInfoArray = innerClassesAttribute.classes;
    InnerClassesInfo innerClassesInfo2 = innerClassesInfoArray[0];
    assertEquals(0, innerClassesInfo2.u2innerClassIndex);
    assertEquals(0, innerClassesInfo2.u2innerNameIndex);
    assertEquals(0, innerClassesInfo2.u2outerClassIndex);
    assertEquals(1, innerClassesInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(0, 1, 1, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(1, 1, classes);

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(0, innerClassesAttribute.u2attributeNameIndex);
    InnerClassesInfo[] innerClassesInfoArray = innerClassesAttribute.classes;
    InnerClassesInfo innerClassesInfo2 = innerClassesInfoArray[0];
    assertEquals(0, innerClassesInfo2.u2innerClassIndex);
    assertEquals(0, innerClassesInfo2.u2innerNameIndex);
    assertEquals(0, innerClassesInfo2.u2outerClassIndex);
    assertEquals(1, innerClassesInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 0, 1, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(1, 1, classes);

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(0, innerClassesAttribute.u2attributeNameIndex);
    InnerClassesInfo[] innerClassesInfoArray = innerClassesAttribute.classes;
    InnerClassesInfo innerClassesInfo2 = innerClassesInfoArray[0];
    assertEquals(0, innerClassesInfo2.u2innerClassIndex);
    assertEquals(0, innerClassesInfo2.u2innerNameIndex);
    assertEquals(0, innerClassesInfo2.u2outerClassIndex);
    assertEquals(1, innerClassesInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitInnerClassesAttribute(Clazz, InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 0, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(1, 1, classes);

    // Act
    constantPoolRemapper.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    assertEquals(0, innerClassesAttribute.u2attributeNameIndex);
    InnerClassesInfo[] innerClassesInfoArray = innerClassesAttribute.classes;
    InnerClassesInfo innerClassesInfo2 = innerClassesInfoArray[0];
    assertEquals(0, innerClassesInfo2.u2innerClassIndex);
    assertEquals(0, innerClassesInfo2.u2innerNameIndex);
    assertEquals(0, innerClassesInfo2.u2outerClassIndex);
    assertEquals(1, innerClassesInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute() {
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
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  void testVisitNestHostAttribute() {
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
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  void testVisitNestHostAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNestMembersAttribute(Clazz, NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute() {
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
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then NestMembersAttribute() u2classes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitNestMembersAttribute(Clazz, NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenNestMembersAttributeU2classesIsNull() {
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
   * Test {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName("Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute() {
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
  @DisplayName("Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute2() {
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
   * Test {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleAttribute(Clazz, ModuleAttribute)"})
  void testVisitModuleAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    RequiresInfo[] resultRequires = new RequiresInfo[] {new RequiresInfo(1, 1, 1)};
    ExportsInfo[] resultExports = new ExportsInfo[] {new ExportsInfo()};
    OpensInfo[] resultOpens = new OpensInfo[] {new OpensInfo()};
    ProvidesInfo[] resultProvides = new ProvidesInfo[] {new ProvidesInfo()};

    ModuleAttribute moduleAttribute =
        new ModuleAttribute(
            1,
            1,
            1,
            1,
            1,
            resultRequires,
            1,
            resultExports,
            1,
            resultOpens,
            3,
            new int[] {1, 0, 1, 0},
            1,
            resultProvides);

    // Act
    constantPoolRemapper.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    assertEquals(0, moduleAttribute.u2attributeNameIndex);
    assertEquals(0, moduleAttribute.u2moduleNameIndex);
    assertEquals(0, moduleAttribute.u2moduleVersionIndex);
    RequiresInfo[] requiresInfoArray = moduleAttribute.requires;
    RequiresInfo requiresInfo = requiresInfoArray[0];
    assertEquals(0, requiresInfo.u2requiresIndex);
    assertEquals(0, requiresInfo.u2requiresVersionIndex);
    ExportsInfo[] exportsInfoArray = moduleAttribute.exports;
    assertEquals(1, exportsInfoArray.length);
    OpensInfo[] opensInfoArray = moduleAttribute.opens;
    assertEquals(1, opensInfoArray.length);
    ProvidesInfo[] providesInfoArray = moduleAttribute.provides;
    assertEquals(1, providesInfoArray.length);
    assertEquals(1, requiresInfoArray.length);
    assertEquals(1, exportsInfoArray[0].u2exportsIndex);
    assertEquals(1, opensInfoArray[0].u2opensIndex);
    assertEquals(1, providesInfoArray[0].u2providesIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, moduleAttribute.u2uses);
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
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleAttribute(Clazz, ModuleAttribute)"})
  void testVisitModuleAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, -1, 1, -1, 1, -1});
    LibraryClass clazz = new LibraryClass();
    RequiresInfo[] resultRequires = new RequiresInfo[] {new RequiresInfo(1, 1, 1)};
    ExportsInfo[] resultExports = new ExportsInfo[] {new ExportsInfo()};
    OpensInfo[] resultOpens = new OpensInfo[] {new OpensInfo()};
    ProvidesInfo[] resultProvides = new ProvidesInfo[] {new ProvidesInfo()};

    ModuleAttribute moduleAttribute =
        new ModuleAttribute(
            1,
            1,
            1,
            -1,
            3,
            resultRequires,
            3,
            resultExports,
            3,
            resultOpens,
            3,
            new int[] {1, 0, 1, 0},
            1,
            resultProvides);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitModuleAttribute(clazz, moduleAttribute));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>When {@link ModuleAttribute#ModuleAttribute()}.
   *   <li>Then {@link ModuleAttribute#ModuleAttribute()} {@link ModuleAttribute#u2uses} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); when ModuleAttribute(); then ModuleAttribute() u2uses is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitModuleAttribute(Clazz, ModuleAttribute)"})
  void testVisitModuleAttribute_whenModuleAttribute_thenModuleAttributeU2usesIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ModuleAttribute moduleAttribute = new ModuleAttribute();

    // Act
    constantPoolRemapper.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    assertNull(moduleAttribute.u2uses);
    assertEquals(0, moduleAttribute.u2moduleVersionIndex);
    assertEquals(1, moduleAttribute.u2attributeNameIndex);
    assertEquals(1, moduleAttribute.u2moduleNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute() {
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
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute() {
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
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then ModulePackagesAttribute() u2packages is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenModulePackagesAttributeU2packagesIsNull() {
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
   * Test {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitDeprecatedAttribute(Clazz, DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
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
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitDeprecatedAttribute(Clazz, DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute2() {
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
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSyntheticAttribute(Clazz, SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
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
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSyntheticAttribute(Clazz, SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute2() {
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
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
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
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
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
  @DisplayName("Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute() {
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
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName("Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ParameterInfo[] parameters = new ParameterInfo[] {new ParameterInfo(1, 1)};
    MethodParametersAttribute methodParametersAttribute =
        new MethodParametersAttribute(1, 1, parameters);

    // Act
    constantPoolRemapper.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    assertEquals(0, methodParametersAttribute.u2attributeNameIndex);
    ParameterInfo[] parameterInfoArray = methodParametersAttribute.parameters;
    assertEquals(0, parameterInfoArray[0].u2nameIndex);
    assertEquals(1, parameterInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName("Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Act
    constantPoolRemapper.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    assertEquals(0, exceptionsAttribute.u2attributeNameIndex);
    assertArrayEquals(new int[] {0, 1, 0, 0}, exceptionsAttribute.u2exceptionIndexTable);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then {@link ExceptionsAttribute#ExceptionsAttribute()} {@link
   *       ExceptionsAttribute#u2exceptionIndexTable} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then ExceptionsAttribute() u2exceptionIndexTable is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenExceptionsAttributeU2exceptionIndexTableIsNull() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute();

    // Act
    constantPoolRemapper.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    assertNull(exceptionsAttribute.u2exceptionIndexTable);
    assertEquals(1, exceptionsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute() {
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
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute2() throws UnsupportedEncodingException {
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
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute =
        new CodeAttribute(
            1,
            3,
            3,
            3,
            new byte[] {
              'A', -96, 'A', -96, 'A', -96, 'A', -96, 'A', -96, 'A', -96, 'A', -96, 'A', -96
            });

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
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, -1, 1, -1, 1, -1});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, -1, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitCodeAttribute(clazz, method, codeAttribute));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName("Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  void testVisitStackMapAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    FullFrame[] stackMapFrames = new FullFrame[] {new FullFrame()};
    StackMapAttribute stackMapAttribute = new StackMapAttribute(stackMapFrames);

    // Act
    constantPoolRemapper.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    assertEquals(1, stackMapAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName("Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  void testVisitStackMapAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    VerificationType[] variables =
        new VerificationType[] {VerificationTypeFactory.createDoubleType()};
    VerificationType[] stack = new VerificationType[] {VerificationTypeFactory.createDoubleType()};

    FullFrame fullFrame = new FullFrame(2, variables, stack);
    FullFrame[] stackMapFrames = new FullFrame[] {fullFrame};
    StackMapAttribute stackMapAttribute = new StackMapAttribute(stackMapFrames);

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
   *   <li>Then {@link StackMapAttribute#StackMapAttribute()} {@link Attribute#u2attributeNameIndex}
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then StackMapAttribute() u2attributeNameIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenStackMapAttributeU2attributeNameIndexIsOne() {
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
   * Test {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {new FullFrame()};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    VerificationType[] variables =
        new VerificationType[] {VerificationTypeFactory.createDoubleType()};
    VerificationType[] stack = new VerificationType[] {VerificationTypeFactory.createDoubleType()};

    FullFrame fullFrame = new FullFrame(2, variables, stack);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {fullFrame};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {new LessZeroFrame((byte) 'A')};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {new MoreZeroFrame(1)};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute6() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    VerificationType[] additionalVariables =
        new VerificationType[] {VerificationTypeFactory.createDoubleType()};
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(additionalVariables);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {moreZeroFrame};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute7() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {new SameZeroFrame(1)};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute8() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapFrame[] stackMapFrames =
        new StackMapFrame[] {new SameOneFrame(VerificationTypeFactory.createDoubleType())};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute9() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    FullFrame fullFrame = new FullFrame();
    StackMapTableAttribute stackMapTableAttribute =
        new StackMapTableAttribute(new StackMapFrame[] {fullFrame, new FullFrame()});

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute10() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    DoubleType createDoubleTypeResult = VerificationTypeFactory.createDoubleType();
    MoreZeroFrame moreZeroFrame =
        new MoreZeroFrame(
            new VerificationType[] {
              createDoubleTypeResult, VerificationTypeFactory.createDoubleType()
            });
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {moreZeroFrame};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

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
   *   <li>Then first element {@link SameOneFrame#stackItem} {@link ObjectType}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then first element stackItem ObjectType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenFirstElementStackItemObjectType() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    ObjectType stackItem = VerificationTypeFactory.createObjectType(1);
    StackMapFrame[] stackMapFrames = new StackMapFrame[] {new SameOneFrame(stackItem)};
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute(stackMapFrames);

    // Act
    constantPoolRemapper.visitStackMapTableAttribute(
        clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    StackMapFrame[] stackMapFrameArray = stackMapTableAttribute.stackMapFrames;
    StackMapFrame stackMapFrame = stackMapFrameArray[0];
    VerificationType verificationType = ((SameOneFrame) stackMapFrame).stackItem;
    assertTrue(verificationType instanceof ObjectType);
    assertTrue(stackMapFrame instanceof SameOneFrame);
    assertEquals(0, ((ObjectType) verificationType).u2classIndex);
    assertEquals(1, stackMapFrameArray.length);
    assertEquals(1, stackMapTableAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute() {
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
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);
    LocalVariableInfo[] localVariableTable = new LocalVariableInfo[] {localVariableInfo};
    LocalVariableTableAttribute localVariableTableAttribute =
        new LocalVariableTableAttribute(1, 1, localVariableTable);

    // Act
    constantPoolRemapper.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    assertEquals(0, localVariableTableAttribute.u2attributeNameIndex);
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    LocalVariableInfo localVariableInfo2 = localVariableInfoArray[0];
    assertEquals(0, localVariableInfo2.u2descriptorIndex);
    assertEquals(0, localVariableInfo2.u2nameIndex);
    assertEquals(1, localVariableInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    LocalVariableTypeInfo[] localVariableTypeTable =
        new LocalVariableTypeInfo[] {localVariableTypeInfo};
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(1, 1, localVariableTypeTable);

    // Act
    constantPoolRemapper.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    assertEquals(0, localVariableTypeTableAttribute.u2attributeNameIndex);
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        localVariableTypeTableAttribute.localVariableTypeTable;
    LocalVariableTypeInfo localVariableTypeInfo2 = localVariableTypeInfoArray[0];
    assertEquals(0, localVariableTypeInfo2.u2nameIndex);
    assertEquals(0, localVariableTypeInfo2.u2signatureIndex);
    assertEquals(1, localVariableTypeInfoArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName("Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName("Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation[] annotations = new Annotation[] {new Annotation()};
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute(1, 1, annotations);

    // Act
    constantPoolRemapper.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    assertEquals(0, annotationsAttribute.u2attributeNameIndex);
    Annotation[] annotationArray = annotationsAttribute.annotations;
    assertEquals(1, annotationArray.length);
    assertEquals(1, annotationArray[0].u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute() {
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
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    Annotation annotation = new Annotation();
    Annotation annotation2 = new Annotation();
    Annotation[][] parameterAnnotations =
        new Annotation[][] {new Annotation[] {annotation, annotation2, new Annotation()}};
    RuntimeInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute(
            1, 1, new int[] {3, 1, 3, 1}, parameterAnnotations);

    // Act
    constantPoolRemapper.visitAnyParameterAnnotationsAttribute(
        clazz, method, parameterAnnotationsAttribute);

    // Assert
    assertEquals(0, parameterAnnotationsAttribute.u2attributeNameIndex);
    Annotation[][] annotationArray = parameterAnnotationsAttribute.parameterAnnotations;
    assertEquals(1, annotationArray.length);
    Annotation[] annotationArray2 = annotationArray[0];
    assertEquals(1, annotationArray2[0].u2typeIndex);
    assertEquals(1, annotationArray2[1].u2typeIndex);
    assertEquals(1, annotationArray2[2].u2typeIndex);
    assertEquals(3, annotationArray2.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    AnnotationElementValue defaultValue = new AnnotationElementValue(1, new Annotation());
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, defaultValue);

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
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute2() {
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
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute3() {
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
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute4() {
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
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute5() {
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
   *   <li>Then first element {@link AnnotationElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then first element AnnotationElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenFirstElementAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    AnnotationElementValue annotationElementValue = new AnnotationElementValue(1, new Annotation());
    ElementValue[] elementValues = new ElementValue[] {annotationElementValue};
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    ElementValue[] elementValueArray = ((ArrayElementValue) elementValue).elementValues;
    ElementValue elementValue2 = elementValueArray[0];
    assertTrue(elementValue2 instanceof AnnotationElementValue);
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue2).u2elementNameIndex);
    assertEquals(0, ((ArrayElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((AnnotationElementValue) elementValue2).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link ArrayElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then first element ArrayElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenFirstElementArrayElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ElementValue[] elementValues = new ElementValue[] {new ArrayElementValue()};
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    ElementValue[] elementValueArray = ((ArrayElementValue) elementValue).elementValues;
    ElementValue elementValue2 = elementValueArray[0];
    assertTrue(elementValue2 instanceof ArrayElementValue);
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((ArrayElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ArrayElementValue) elementValue2).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link ClassElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then first element ClassElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenFirstElementClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ElementValue[] elementValues = new ElementValue[] {new ClassElementValue(1, 1)};
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ArrayElementValue);
    ElementValue[] elementValueArray = ((ArrayElementValue) elementValue).elementValues;
    ElementValue elementValue2 = elementValueArray[0];
    assertTrue(elementValue2 instanceof ClassElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((ClassElementValue) elementValue2).u2classInfoIndex);
    assertEquals(0, ((ArrayElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((ClassElementValue) elementValue2).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then first element ConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenFirstElementConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ElementValue[] elementValues = new ElementValue[] {new ConstantElementValue('\u0003')};
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ArrayElementValue);
    ElementValue[] elementValueArray = ((ArrayElementValue) elementValue).elementValues;
    ElementValue elementValue2 = elementValueArray[0];
    assertTrue(elementValue2 instanceof ConstantElementValue);
    assertEquals(0, annotationDefaultAttribute.u2attributeNameIndex);
    assertEquals(0, ((ArrayElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ConstantElementValue) elementValue2).u2constantValueIndex);
    assertEquals(1, ((ConstantElementValue) elementValue2).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link EnumConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then first element EnumConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenFirstElementEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    ElementValue[] elementValues = new ElementValue[] {new EnumConstantElementValue(1, 1, 1)};
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new ArrayElementValue(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    ElementValue elementValue = annotationDefaultAttribute.defaultValue;
    assertTrue(elementValue instanceof ArrayElementValue);
    ElementValue[] elementValueArray = ((ArrayElementValue) elementValue).elementValues;
    ElementValue elementValue2 = elementValueArray[0];
    assertTrue(elementValue2 instanceof EnumConstantElementValue);
    assertEquals(0, ((ArrayElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue2).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue2).u2constantNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue2).u2typeNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
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
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); then BootstrapMethodInfo() u2methodArguments is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_thenBootstrapMethodInfoU2methodArgumentsIsNull() {
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
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then RecordComponentInfo() u2descriptorIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitRecordComponentInfo(Clazz, RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenRecordComponentInfoU2descriptorIndexIsOne() {
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
   * Test {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  void testVisitInnerClassesInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(0, 0, 0, 1);

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
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  void testVisitInnerClassesInfo2() {
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
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  void testVisitInnerClassesInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, -1, 1, -1, 1, -1});
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, -1, 1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitInnerClassesInfo(clazz, innerClassesInfo));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 0);

    // Act
    constantPoolRemapper.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert that nothing has changed
    assertEquals(0, exceptionInfo.u2catchType);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  void testVisitExceptionInfo2() {
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
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantPoolRemapper.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenDoesNotThrow() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            constantPoolRemapper.visitConstantInstruction(
                clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1)));
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
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  void testVisitSameOneFrame() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    ObjectType stackItem = VerificationTypeFactory.createObjectType(1);
    SameOneFrame sameOneFrame = new SameOneFrame(stackItem);

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
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  void testVisitSameOneFrame_thenDoesNotThrow() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            constantPoolRemapper.visitSameOneFrame(
                clazz,
                method,
                codeAttribute,
                2,
                new SameOneFrame(VerificationTypeFactory.createDoubleType())));
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
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  void testVisitSameOneFrame_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    ObjectType stackItem = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitSameOneFrame(
                clazz, method, codeAttribute, 2, new SameOneFrame(stackItem)));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>Then first element {@link ObjectType}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); then first element ObjectType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)"
  })
  void testVisitFullFrame_thenFirstElementObjectType() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    VerificationType[] variables =
        new VerificationType[] {VerificationTypeFactory.createDoubleType()};
    VerificationType[] stack = new VerificationType[] {VerificationTypeFactory.createObjectType(1)};

    FullFrame fullFrame = new FullFrame(2, variables, stack);
    fullFrame.variablesCount = 0;
    fullFrame.stackCount = 1;

    // Act
    constantPoolRemapper.visitFullFrame(clazz, method, codeAttribute, 2, fullFrame);

    // Assert
    VerificationType[] verificationTypeArray = fullFrame.stack;
    VerificationType verificationType = verificationTypeArray[0];
    assertTrue(verificationType instanceof ObjectType);
    assertEquals(0, ((ObjectType) verificationType).u2classIndex);
    assertEquals(1, verificationTypeArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>Then first element {@link ObjectType}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); then first element ObjectType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)"
  })
  void testVisitFullFrame_thenFirstElementObjectType2() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    VerificationType[] variables =
        new VerificationType[] {VerificationTypeFactory.createObjectType(1)};
    VerificationType[] stack = new VerificationType[] {VerificationTypeFactory.createDoubleType()};

    FullFrame fullFrame = new FullFrame(2, variables, stack);
    fullFrame.variablesCount = 1;
    fullFrame.stackCount = 0;

    // Act
    constantPoolRemapper.visitFullFrame(clazz, method, codeAttribute, 2, fullFrame);

    // Assert
    VerificationType[] verificationTypeArray = fullFrame.variables;
    VerificationType verificationType = verificationTypeArray[0];
    assertTrue(verificationType instanceof ObjectType);
    assertEquals(0, ((ObjectType) verificationType).u2classIndex);
    assertEquals(1, verificationTypeArray.length);
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
  @DisplayName(
      "Test visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType); then createObjectType one u2classIndex is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)"
  })
  void testVisitObjectType_thenCreateObjectTypeOneU2classIndexIsZero() {
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
  @DisplayName(
      "Test visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)"
  })
  void testVisitObjectType_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitParameterInfo(Clazz, Method, int, ParameterInfo)"
  })
  void testVisitParameterInfo() {
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
  @DisplayName(
      "Test visitParameterInfo(Clazz, Method, int, ParameterInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitParameterInfo(Clazz, Method, int, ParameterInfo)"
  })
  void testVisitParameterInfo_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo() {
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
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableInfo(
                clazz, method, codeAttribute, localVariableInfo));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo() {
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
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, -1, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            constantPoolRemapper.visitLocalVariableTypeInfo(
                clazz, method, codeAttribute, localVariableTypeInfo));
  }

  /**
   * Test {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRequiresInfo(Clazz, RequiresInfo)"})
  void testVisitRequiresInfo() {
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
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitRequiresInfo(Clazz, RequiresInfo)"})
  void testVisitRequiresInfo_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitExportsInfo(Clazz, ExportsInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitExportsInfo(Clazz, ExportsInfo)"})
  void testVisitExportsInfo() {
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
   *   <li>When {@link ExportsInfo#ExportsInfo()}.
   *   <li>Then {@link ExportsInfo#ExportsInfo()} {@link ExportsInfo#u2exportsToIndex} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExportsInfo(Clazz, ExportsInfo); when ExportsInfo(); then ExportsInfo() u2exportsToIndex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitExportsInfo(Clazz, ExportsInfo)"})
  void testVisitExportsInfo_whenExportsInfo_thenExportsInfoU2exportsToIndexIsNull() {
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
   * Test {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName("Test visitOpensInfo(Clazz, OpensInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitOpensInfo(Clazz, OpensInfo)"})
  void testVisitOpensInfo() {
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
   *   <li>When {@link OpensInfo#OpensInfo()}.
   *   <li>Then {@link OpensInfo#OpensInfo()} {@link OpensInfo#u2opensToIndex} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOpensInfo(Clazz, OpensInfo); when OpensInfo(); then OpensInfo() u2opensToIndex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitOpensInfo(Clazz, OpensInfo)"})
  void testVisitOpensInfo_whenOpensInfo_thenOpensInfoU2opensToIndexIsNull() {
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
   * Test {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName("Test visitProvidesInfo(Clazz, ProvidesInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProvidesInfo(Clazz, ProvidesInfo)"})
  void testVisitProvidesInfo() {
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
   *   <li>When {@link ProvidesInfo#ProvidesInfo()}.
   *   <li>Then {@link ProvidesInfo#ProvidesInfo()} {@link ProvidesInfo#u2providesWithIndex} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitProvidesInfo(Clazz, ProvidesInfo); when ProvidesInfo(); then ProvidesInfo() u2providesWithIndex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitProvidesInfo(Clazz, ProvidesInfo)"})
  void testVisitProvidesInfo_whenProvidesInfo_thenProvidesInfoU2providesWithIndexIsNull() {
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
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then Annotation() u2typeIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenAnnotationU2typeIndexIsOne() {
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
   *   <li>Then first element {@link AnnotationElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then first element AnnotationElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenFirstElementAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    AnnotationElementValue annotationElementValue = new AnnotationElementValue(1, new Annotation());
    ElementValue[] elementValues = new ElementValue[] {annotationElementValue};
    Annotation annotation = new Annotation(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    ElementValue[] elementValueArray = annotation.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, annotation.u2typeIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((AnnotationElementValue) elementValue).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then first element {@link ArrayElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then first element ArrayElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenFirstElementArrayElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ElementValue[] elementValues = new ElementValue[] {new ArrayElementValue()};
    Annotation annotation = new Annotation(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    ElementValue[] elementValueArray = annotation.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotation.u2typeIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ArrayElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then first element {@link ClassElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then first element ClassElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenFirstElementClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ElementValue[] elementValues = new ElementValue[] {new ClassElementValue(1, 1)};
    Annotation annotation = new Annotation(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    ElementValue[] elementValueArray = annotation.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ClassElementValue);
    assertEquals(0, annotation.u2typeIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2classInfoIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then first element ConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenFirstElementConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ElementValue[] elementValues = new ElementValue[] {new ConstantElementValue('\u0003')};
    Annotation annotation = new Annotation(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    ElementValue[] elementValueArray = annotation.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ConstantElementValue);
    assertEquals(0, annotation.u2typeIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ConstantElementValue) elementValue).u2constantValueIndex);
    assertEquals(1, ((ConstantElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then first element {@link EnumConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then first element EnumConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolRemapper.visitAnnotation(Clazz, Annotation)"})
  void testVisitAnnotationWithClazzAnnotation_thenFirstElementEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    ElementValue[] elementValues = new ElementValue[] {new EnumConstantElementValue(1, 1, 1)};
    Annotation annotation = new Annotation(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitAnnotation(clazz, annotation);

    // Assert
    ElementValue[] elementValueArray = annotation.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof EnumConstantElementValue);
    assertEquals(0, annotation.u2typeIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2constantNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2typeNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName("Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantElementValue(Clazz, Annotation, ConstantElementValue)"
  })
  void testVisitConstantElementValue() {
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
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitConstantElementValue(Clazz, Annotation, ConstantElementValue)"
  })
  void testVisitConstantElementValue_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue() {
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
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitClassElementValue(Clazz, Annotation, ClassElementValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  void testVisitClassElementValue() {
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
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  void testVisitClassElementValue_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue() {
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
   *   <li>Then first element {@link AnnotationElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then first element AnnotationElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenFirstElementAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = new AnnotationElementValue(1, new Annotation());
    ElementValue[] elementValues = new ElementValue[] {annotationElementValue};
    AnnotationElementValue annotationElementValue2 =
        new AnnotationElementValue(1, new Annotation(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue2);

    // Assert
    Annotation annotation2 = annotationElementValue2.annotationValue;
    ElementValue[] elementValueArray = annotation2.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, annotation2.u2typeIndex);
    assertEquals(0, annotationElementValue2.u2elementNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((AnnotationElementValue) elementValue).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ArrayElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then first element ArrayElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenFirstElementArrayElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ArrayElementValue()};
    AnnotationElementValue annotationElementValue =
        new AnnotationElementValue(1, new Annotation(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    Annotation annotation2 = annotationElementValue.annotationValue;
    ElementValue[] elementValueArray = annotation2.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, annotation2.u2typeIndex);
    assertEquals(0, annotationElementValue.u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ArrayElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ClassElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then first element ClassElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenFirstElementClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ClassElementValue(1, 1)};
    AnnotationElementValue annotationElementValue =
        new AnnotationElementValue(1, new Annotation(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    Annotation annotation2 = annotationElementValue.annotationValue;
    ElementValue[] elementValueArray = annotation2.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ClassElementValue);
    assertEquals(0, annotation2.u2typeIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2classInfoIndex);
    assertEquals(0, annotationElementValue.u2elementNameIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then first element ConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenFirstElementConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ConstantElementValue('\u0003')};
    AnnotationElementValue annotationElementValue =
        new AnnotationElementValue(1, new Annotation(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    Annotation annotation2 = annotationElementValue.annotationValue;
    ElementValue[] elementValueArray = annotation2.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ConstantElementValue);
    assertEquals(0, annotation2.u2typeIndex);
    assertEquals(0, annotationElementValue.u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ConstantElementValue) elementValue).u2constantValueIndex);
    assertEquals(1, ((ConstantElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link EnumConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then first element EnumConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenFirstElementEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new EnumConstantElementValue(1, 1, 1)};
    AnnotationElementValue annotationElementValue =
        new AnnotationElementValue(1, new Annotation(1, 1, elementValues));

    // Act
    constantPoolRemapper.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    Annotation annotation2 = annotationElementValue.annotationValue;
    ElementValue[] elementValueArray = annotation2.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof EnumConstantElementValue);
    assertEquals(0, annotation2.u2typeIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2constantNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2typeNameIndex);
    assertEquals(1, elementValueArray.length);
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
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then ArrayElementValue() u2elementNameIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenArrayElementValueU2elementNameIndexIsOne() {
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
   *   <li>Then first element {@link AnnotationElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then first element AnnotationElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenFirstElementAnnotationElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = new AnnotationElementValue(1, new Annotation());
    ElementValue[] elementValues = new ElementValue[] {annotationElementValue};
    ArrayElementValue arrayElementValue = new ArrayElementValue(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    ElementValue[] elementValueArray = arrayElementValue.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof AnnotationElementValue);
    assertEquals(0, arrayElementValue.u2elementNameIndex);
    assertEquals(0, ((AnnotationElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((AnnotationElementValue) elementValue).annotationValue.u2typeIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ArrayElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then first element ArrayElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenFirstElementArrayElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ArrayElementValue()};
    ArrayElementValue arrayElementValue = new ArrayElementValue(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    ElementValue[] elementValueArray = arrayElementValue.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ArrayElementValue);
    assertEquals(0, arrayElementValue.u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ArrayElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ClassElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then first element ClassElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenFirstElementClassElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ClassElementValue(1, 1)};
    ArrayElementValue arrayElementValue = new ArrayElementValue(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    ElementValue[] elementValueArray = arrayElementValue.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ClassElementValue);
    assertEquals(0, ((ClassElementValue) elementValue).u2classInfoIndex);
    assertEquals(0, arrayElementValue.u2elementNameIndex);
    assertEquals(0, ((ClassElementValue) elementValue).u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then first element ConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenFirstElementConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new ConstantElementValue('\u0003')};
    ArrayElementValue arrayElementValue = new ArrayElementValue(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    ElementValue[] elementValueArray = arrayElementValue.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof ConstantElementValue);
    assertEquals(0, arrayElementValue.u2elementNameIndex);
    assertEquals(1, elementValueArray.length);
    assertEquals(1, ((ConstantElementValue) elementValue).u2constantValueIndex);
    assertEquals(1, ((ConstantElementValue) elementValue).u2elementNameIndex);
  }

  /**
   * Test {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then first element {@link EnumConstantElementValue}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolRemapper#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then first element EnumConstantElementValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantPoolRemapper.visitArrayElementValue(Clazz, Annotation, ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenFirstElementEnumConstantElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ElementValue[] elementValues = new ElementValue[] {new EnumConstantElementValue(1, 1, 1)};
    ArrayElementValue arrayElementValue = new ArrayElementValue(1, 1, elementValues);

    // Act
    constantPoolRemapper.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    ElementValue[] elementValueArray = arrayElementValue.elementValues;
    ElementValue elementValue = elementValueArray[0];
    assertTrue(elementValue instanceof EnumConstantElementValue);
    assertEquals(0, arrayElementValue.u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2elementNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2constantNameIndex);
    assertEquals(0, ((EnumConstantElementValue) elementValue).u2typeNameIndex);
    assertEquals(1, elementValueArray.length);
  }
}
