package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link ConstantAdder#ConstantAdder(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAdder#ConstantAdder(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.<init>(ProgramClass)"})
  public void testNewConstantAdder_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertEquals(0, (new ConstantAdder(targetClass)).getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#ConstantAdder(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return ConstantIndex is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAdder#ConstantAdder(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.<init>(ProgramClass)"})
  public void testNewConstantAdder_whenProgramClass_thenReturnConstantIndexIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantAdder(new ProgramClass())).getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#addConstant(Clazz, int)} with {@code clazz}, {@code constantIndex}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAdder#addConstant(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ConstantAdder.addConstant(Clazz, int)"})
  public void testAddConstantWithClazzConstantIndex_whenLibraryClass_thenReturnZero() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(new ProgramClass());

    // Act and Assert
    assertEquals(0, constantAdder.addConstant(new LibraryClass(), 1));
  }

  /**
   * Test {@link ConstantAdder#getConstantIndex()}.
   *
   * <p>Method under test: {@link ConstantAdder#getConstantIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ConstantAdder.getConstantIndex()"})
  public void testGetConstantIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantAdder(new ProgramClass())).getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant2() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(3, 0, new Constant[] {new ClassConstant()}, 3, 3, 3));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert that nothing has changed
    assertEquals(0, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitLongConstant(Clazz, LongConstant)"})
  public void testVisitLongConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(5, 1, new Constant[] {new ClassConstant()}, 5, 5, 5));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitLongConstant(Clazz, LongConstant)"})
  public void testVisitLongConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                5,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                5,
                5,
                5));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant2() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(4, 0, new Constant[] {new ClassConstant()}, 4, 4, 4));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert that nothing has changed
    assertEquals(0, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitDoubleConstant(Clazz, DoubleConstant)"})
  public void testVisitDoubleConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(6, 1, new Constant[] {new ClassConstant()}, 6, 6, 6));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitDoubleConstant(Clazz, DoubleConstant)"})
  public void testVisitDoubleConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                6,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                6,
                6,
                6));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantAdder.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  public void testVisitPrimitiveArrayConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitUtf8Constant(Clazz, Utf8Constant)"})
  public void testVisitUtf8Constant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitUtf8Constant(clazz, new Utf8Constant("String"));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitUtf8Constant(Clazz, Utf8Constant)"})
  public void testVisitUtf8Constant2() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 0, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitUtf8Constant(clazz, new Utf8Constant("String"));

    // Assert that nothing has changed
    assertEquals(0, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitUtf8Constant(Clazz, Utf8Constant)"})
  public void testVisitUtf8Constant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitUtf8Constant(clazz, new Utf8Constant("String"));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitMethodHandleConstant(Clazz, MethodHandleConstant)"})
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(15, 1, new Constant[] {new ClassConstant()}, 15, 15, 15));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    assertEquals(1, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitMethodHandleConstant(Clazz, MethodHandleConstant)"})
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(15, 0, new Constant[] {new ClassConstant()}, 15, 15, 15));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert that nothing has changed
    assertEquals(0, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantAdder.visitMethodHandleConstant(Clazz, MethodHandleConstant)"})
  public void testVisitMethodHandleConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(
                15,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                15,
                15,
                15));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantAdder.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    assertEquals(3, constantAdder.getConstantIndex());
  }
}
