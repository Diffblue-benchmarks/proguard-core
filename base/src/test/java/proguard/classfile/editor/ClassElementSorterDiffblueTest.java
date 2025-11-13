package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;

class ClassElementSorterDiffblueTest {
  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass2() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, true);
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass3() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, classConstant2}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(classConstant, constant);
    assertSame(classConstant2, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass4() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(dynamicConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2superClass} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then ProgramClass() u2superClass is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenProgramClassU2superClassIsZero() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(false, false, false, false);
    ProgramClass programClass = new ProgramClass();

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link FloatConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element FloatConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementFloatConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    FloatConstant floatConstant = new FloatConstant(10.0f);
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, floatConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FloatConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertSame(floatConstant, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link IntegerConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element IntegerConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementIntegerConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    IntegerConstant integerConstant = new IntegerConstant(42);
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, integerConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof IntegerConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertSame(integerConstant, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link InterfaceMethodrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then second element InterfaceMethodrefConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementInterfaceMethodrefConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, interfaceMethodrefConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof InterfaceMethodrefConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertSame(interfaceMethodrefConstant, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element is {@link DoubleConstant#DoubleConstant(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then second element is DoubleConstant(double) with value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementIsDoubleConstantWithValueIsTen() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, null, doubleConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(doubleConstant, constantArray[1]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element is {@link DynamicConstant#DynamicConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element is DynamicConstant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementIsDynamicConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};
    DynamicConstant dynamicConstant = new DynamicConstant(1, 1, referencedClasses);
    DynamicConstant dynamicConstant2 = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, dynamicConstant2}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(dynamicConstant2, constantArray[1]);
    assertSame(dynamicConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element ProcessingInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenSecondElementProcessingInfoIsNull() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[2]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element DynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenThirdElementDynamicConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, dynamicConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof DynamicConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(3, constantArray.length);
    assertEquals(classConstant, constant);
    assertSame(classConstant2, constant);
    assertSame(dynamicConstant, constant2);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link FieldrefConstant#FieldrefConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element is FieldrefConstant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenThirdElementIsFieldrefConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(fieldrefConstant, constantArray[2]);
  }
}
