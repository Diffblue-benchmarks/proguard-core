package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.Utf8Constant;

public class ConstantAdderDiffblueTest {
  /**
   * Method under test: {@link ConstantAdder#addConstant(Clazz, int)}
   */
  @Test
  public void testAddConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(new ProgramClass());

    // Act and Assert
    assertEquals(0, constantAdder.addConstant(new LibraryClass(), 1));
  }

  /**
   * Method under test: {@link ConstantAdder#getConstantIndex()}
   */
  @Test
  public void testGetConstantIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantAdder(new ProgramClass())).getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(3, 1, new Constant[]{new ClassConstant()}, 3, 3, 3));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(3, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 3, 3, 3));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  public void testVisitLongConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(5, 1, new Constant[]{new ClassConstant()}, 5, 5, 5));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  public void testVisitLongConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(5, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 5, 5, 5));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  public void testVisitFloatConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(4, 1, new Constant[]{new ClassConstant()}, 4, 4, 4));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  public void testVisitFloatConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(4, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 4, 4, 4));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  public void testVisitDoubleConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(6, 1, new Constant[]{new ClassConstant()}, 6, 6, 6));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  public void testVisitDoubleConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(6, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 6, 6, 6));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   */
  @Test
  public void testVisitPrimitiveArrayConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(99, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 99, 99, 99));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  public void testVisitUtf8Constant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitUtf8Constant(clazz, new Utf8Constant("String"));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  public void testVisitUtf8Constant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitUtf8Constant(clazz, new Utf8Constant("String"));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(15, 1, new Constant[]{new ClassConstant()}, 15, 15, 15));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Method under test:
   * {@link ConstantAdder#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder = new ConstantAdder(
        new ProgramClass(15, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 15, 15, 15));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Method under test: {@link ConstantAdder#ConstantAdder(ProgramClass)}
   */
  @Test
  public void testNewConstantAdder() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantAdder(new ProgramClass())).getConstantIndex());
  }

  /**
   * Method under test: {@link ConstantAdder#ConstantAdder(ProgramClass)}
   */
  @Test
  public void testNewConstantAdder2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertEquals(0, (new ConstantAdder(targetClass)).getConstantIndex());
  }
}
