package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.constant.visitor.ConstantVisitor;

class ConstantAdderDiffblueTest {
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
  @DisplayName(
      "Test new ConstantAdder(ProgramClass); given two; when ProgramClass() u2constantPoolCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewConstantAdder_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
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
  @DisplayName(
      "Test new ConstantAdder(ProgramClass); when ProgramClass(); then return ConstantIndex is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewConstantAdder_whenProgramClass_thenReturnConstantIndexIsZero() {
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
  @DisplayName(
      "Test addConstant(Clazz, int) with 'clazz', 'constantIndex'; when LibraryClass(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.ConstantAdder.addConstant(proguard.classfile.Clazz, int)"
  })
  void testAddConstantWithClazzConstantIndex_whenLibraryClass_thenReturnZero() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(new ProgramClass());

    // Act and Assert
    assertEquals(0, constantAdder.addConstant(new LibraryClass(), 1));
  }

  /**
   * Test {@link ConstantAdder#addConstant(Clazz, Constant)} with {@code clazz}, {@code constant}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAdder#addConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName(
      "Test addConstant(Clazz, Constant) with 'clazz', 'constant'; when LibraryClass; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.ConstantAdder.addConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testAddConstantWithClazzConstant_whenLibraryClass_thenReturnZero() {
    // Arrange
    ConstantAdder constantAdder = new ConstantAdder(new ProgramClass());
    LibraryClass clazz = mock(LibraryClass.class);
    Constant constant = mock(Constant.class);
    doNothing().when(constant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    int actualAddConstantResult = constantAdder.addConstant(clazz, constant);

    // Assert
    verify(constant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    assertEquals(0, actualAddConstantResult);
  }

  /**
   * Test {@link ConstantAdder#getConstantIndex()}.
   *
   * <p>Method under test: {@link ConstantAdder#getConstantIndex()}
   */
  @Test
  @DisplayName("Test getConstantIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.ConstantAdder.getConstantIndex()"})
  void testGetConstantIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantAdder(new ProgramClass())).getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @DisplayName("Test visitIntegerConstant(Clazz, IntegerConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)"
  })
  void testVisitIntegerConstant() {
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
  @DisplayName("Test visitIntegerConstant(Clazz, IntegerConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)"
  })
  void testVisitIntegerConstant2() {
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
  @DisplayName("Test visitIntegerConstant(Clazz, IntegerConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)"
  })
  void testVisitIntegerConstant3() {
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
  @DisplayName("Test visitLongConstant(Clazz, LongConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)"
  })
  void testVisitLongConstant() {
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
  @DisplayName("Test visitLongConstant(Clazz, LongConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)"
  })
  void testVisitLongConstant2() {
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
  @DisplayName("Test visitFloatConstant(Clazz, FloatConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)"
  })
  void testVisitFloatConstant() {
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
  @DisplayName("Test visitFloatConstant(Clazz, FloatConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)"
  })
  void testVisitFloatConstant2() {
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
  @DisplayName("Test visitFloatConstant(Clazz, FloatConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)"
  })
  void testVisitFloatConstant3() {
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
  @DisplayName("Test visitDoubleConstant(Clazz, DoubleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)"
  })
  void testVisitDoubleConstant() {
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
  @DisplayName("Test visitDoubleConstant(Clazz, DoubleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)"
  })
  void testVisitDoubleConstant2() {
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
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant() {
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
   * Test {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantAdder.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    assertEquals(2, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantAdder.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));
    LibraryClass clazz2 = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantAdder.visitStringConstant(clazz2, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    assertEquals(5, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @DisplayName("Test visitUtf8Constant(Clazz, Utf8Constant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testVisitUtf8Constant() {
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
  @DisplayName("Test visitUtf8Constant(Clazz, Utf8Constant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testVisitUtf8Constant2() {
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
  @DisplayName("Test visitUtf8Constant(Clazz, Utf8Constant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testVisitUtf8Constant3() {
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
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant() {
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
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant2() {
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
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant3() {
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

  /**
   * Test {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName("Test visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleConstant moduleConstant = mock(ModuleConstant.class);
    when(moduleConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitModuleConstant(clazz, moduleConstant);

    // Assert
    verify(moduleConstant).getName(isA(Clazz.class));
    assertEquals(2, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName("Test visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleConstant moduleConstant = mock(ModuleConstant.class);
    when(moduleConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitModuleConstant(clazz, moduleConstant);

    // Assert
    verify(moduleConstant).getName(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName("Test visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));
    LibraryClass clazz2 = mock(LibraryClass.class);
    ModuleConstant moduleConstant = mock(ModuleConstant.class);
    when(moduleConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitModuleConstant(clazz2, moduleConstant);

    // Assert
    verify(moduleConstant).getName(isA(Clazz.class));
    assertEquals(5, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName("Test visitPackageConstant(Clazz, PackageConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    PackageConstant packageConstant = mock(PackageConstant.class);
    when(packageConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitPackageConstant(clazz, packageConstant);

    // Assert
    verify(packageConstant).getName(isA(Clazz.class));
    assertEquals(2, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName("Test visitPackageConstant(Clazz, PackageConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    PackageConstant packageConstant = mock(PackageConstant.class);
    when(packageConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitPackageConstant(clazz, packageConstant);

    // Assert
    verify(packageConstant).getName(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName("Test visitPackageConstant(Clazz, PackageConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));
    LibraryClass clazz2 = mock(LibraryClass.class);
    PackageConstant packageConstant = mock(PackageConstant.class);
    when(packageConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitPackageConstant(clazz2, packageConstant);

    // Assert
    verify(packageConstant).getName(isA(Clazz.class));
    assertEquals(5, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals(2, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant2 = mock(ClassConstant.class);
    when(classConstant2.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitClassConstant(clazz, classConstant2);

    // Assert
    verify(classConstant2).getName(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant3() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {new ClassConstant(), null}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantAdder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
    assertEquals(2, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    constantAdder.visitLongConstant(clazz, new LongConstant(42L));
    LibraryClass clazz2 = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitMethodTypeConstant(clazz2, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
    assertEquals(5, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName("Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant() {
    // Arrange
    ConstantAdder constantAdder =
        new ConstantAdder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    NameAndTypeConstant nameAndTypeConstant = mock(NameAndTypeConstant.class);
    when(nameAndTypeConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(nameAndTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitNameAndTypeConstant(clazz, nameAndTypeConstant);

    // Assert
    verify(nameAndTypeConstant).getName(isA(Clazz.class));
    verify(nameAndTypeConstant).getType(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantAdder#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName("Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    NameAndTypeConstant nameAndTypeConstant = mock(NameAndTypeConstant.class);
    when(nameAndTypeConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(nameAndTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitNameAndTypeConstant(clazz, nameAndTypeConstant);

    // Assert
    verify(nameAndTypeConstant).getName(isA(Clazz.class));
    verify(nameAndTypeConstant).getType(isA(Clazz.class));
    assertEquals(4, constantAdder.getConstantIndex());
  }

  /**
   * Test {@link ConstantAdder#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>When {@link NameAndTypeConstant} {@link NameAndTypeConstant#getName(Clazz)} return {@code
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAdder#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); when NameAndTypeConstant getName(Clazz) return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantAdder.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_whenNameAndTypeConstantGetNameReturnType() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ConstantAdder constantAdder =
        new ConstantAdder(
            new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    NameAndTypeConstant nameAndTypeConstant = mock(NameAndTypeConstant.class);
    when(nameAndTypeConstant.getName(Mockito.<Clazz>any())).thenReturn("Type");
    when(nameAndTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantAdder.visitNameAndTypeConstant(clazz, nameAndTypeConstant);

    // Assert
    verify(nameAndTypeConstant).getName(isA(Clazz.class));
    verify(nameAndTypeConstant).getType(isA(Clazz.class));
    assertEquals(3, constantAdder.getConstantIndex());
  }
}
