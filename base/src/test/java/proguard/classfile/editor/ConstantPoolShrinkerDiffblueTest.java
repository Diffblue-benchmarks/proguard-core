package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
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
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;

public class ConstantPoolShrinkerDiffblueTest {
  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{doubleConstant, classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    FloatConstant floatConstant = new FloatConstant(10.0f);
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, floatConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass4() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    IntegerConstant integerConstant = new IntegerConstant(42);
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, integerConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass5() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{doubleConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass6() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{doubleConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass7() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{doubleConstant, interfaceMethodrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
    assertSame(interfaceMethodrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass8() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant, null}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(3, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  public void testVisitNameAndTypeConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  public void testVisitNameAndTypeConstant2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  public void testVisitNameAndTypeConstant3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  public void testVisitSourceFileAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  public void testVisitSourceDirAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}
   */
  @Test
  public void testVisitEnclosingMethodAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  public void testVisitNestHostAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}
   */
  @Test
  public void testVisitModuleMainClassAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)}
   */
  @Test
  public void testVisitAnnotationDefaultAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{new InvokeDynamicConstant()}, 1, 1, 1);

    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(StackOverflowError.class,
        () -> constantPoolShrinker.visitAnnotationDefaultAttribute(clazz, method, new AnnotationDefaultAttribute()));
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  public void testVisitRequiresInfo3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)}
   */
  @Test
  public void testVisitEnumConstantElementValue3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, classConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(2, constantArray.length);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, dynamicConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
    assertSame(dynamicConstant, constant);
  }

  /**
   * Method under test:
   * {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}
   */
  @Test
  public void testVisitClassElementValue3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{doubleConstant, fieldrefConstant}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
    assertSame(fieldrefConstant, constant);
  }
}
