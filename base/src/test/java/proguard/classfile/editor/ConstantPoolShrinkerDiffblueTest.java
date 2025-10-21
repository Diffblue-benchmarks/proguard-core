package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.RequiresInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;

public class ConstantPoolShrinkerDiffblueTest {
  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    FloatConstant floatConstant = new FloatConstant(10.0f);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, floatConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass4() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    IntegerConstant integerConstant = new IntegerConstant(42);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, integerConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass5() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {classConstant, new DoubleConstant(10.0d)}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass6() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant(), null}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertNull(constantArray[2]);
    assertEquals(3, constantArray.length);
    assertEquals(3, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link InterfaceMethodrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenSecondElementInterfaceMethodrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {doubleConstant, interfaceMethodrefConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  public void testVisitNameAndTypeConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  public void testVisitNameAndTypeConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"
  })
  public void testVisitNameAndTypeConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceFileAttribute(Clazz, SourceFileAttribute)"
  })
  public void testVisitSourceFileAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  public void testVisitSourceDirAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  public void testVisitSourceDirAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSourceDirAttribute(Clazz, SourceDirAttribute)"
  })
  public void testVisitSourceDirAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)"
  })
  public void testVisitEnclosingMethodAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitNestHostAttribute(Clazz, NestHostAttribute)"})
  public void testVisitNestHostAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)"
  })
  public void testVisitModuleMainClassAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitSignatureAttribute(Clazz, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzSignatureAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitInnerClassesInfo(Clazz, InnerClassesInfo)"})
  public void testVisitInnerClassesInfo_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolShrinker.visitRequiresInfo(Clazz, RequiresInfo)"})
  public void testVisitRequiresInfo_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)"
  })
  public void testVisitEnumConstantElementValue_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPoolShrinker.visitClassElementValue(Clazz, Annotation, ClassElementValue)"
  })
  public void testVisitClassElementValue_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }
}
