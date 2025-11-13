package proguard.classfile.constant.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;

class ConstantVisitorDiffblueTest {
  /**
   * Test {@link ConstantVisitor#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>When {@link ClassConstant#ClassConstant()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyConstant(Clazz, Constant); when ClassConstant(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitAnyConstant(Clazz, Constant)"})
  void testVisitAnyConstant_whenClassConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitAnyConstant(clazz, new ClassConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @DisplayName(
      "Test visitIntegerConstant(Clazz, IntegerConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitIntegerConstant(Clazz, IntegerConstant)"})
  void testVisitIntegerConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitIntegerConstant(clazz, new IntegerConstant(42)));
  }

  /**
   * Test {@link ConstantVisitor#visitLongConstant(Clazz, LongConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @DisplayName(
      "Test visitLongConstant(Clazz, LongConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitLongConstant(Clazz, LongConstant)"})
  void testVisitLongConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitLongConstant(clazz, new LongConstant(42L)));
  }

  /**
   * Test {@link ConstantVisitor#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFloatConstant(Clazz, FloatConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitFloatConstant(Clazz, FloatConstant)"})
  void testVisitFloatConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitFloatConstant(clazz, new FloatConstant(10.0f)));
  }

  /**
   * Test {@link ConstantVisitor#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDoubleConstant(Clazz, DoubleConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitDoubleConstant(Clazz, DoubleConstant)"})
  void testVisitDoubleConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitDoubleConstant(clazz, new DoubleConstant(10.0d)));
  }

  /**
   * Test {@link ConstantVisitor#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantVisitor.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantLookupVisitor.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitStringConstant(Clazz, StringConstant)"})
  void testVisitStringConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitStringConstant(clazz, new StringConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @DisplayName(
      "Test visitUtf8Constant(Clazz, Utf8Constant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitUtf8Constant(Clazz, Utf8Constant)"})
  void testVisitUtf8Constant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitUtf8Constant(clazz, new Utf8Constant("String")));
  }

  /**
   * Test {@link ConstantVisitor#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantVisitor.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitMethodHandleConstant(Clazz, MethodHandleConstant)"})
  void testVisitMethodHandleConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantLookupVisitor.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1)));
  }

  /**
   * Test {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitModuleConstant(Clazz, ModuleConstant)"})
  void testVisitModuleConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitModuleConstant(clazz, new ModuleConstant(1)));
  }

  /**
   * Test {@link ConstantVisitor#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitPackageConstant(Clazz, PackageConstant)"})
  void testVisitPackageConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitPackageConstant(clazz, new PackageConstant(1)));
  }

  /**
   * Test {@link ConstantVisitor#visitAnyRefConstant(Clazz, RefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyRefConstant(Clazz, RefConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitAnyRefConstant(Clazz, RefConstant)"})
  void testVisitAnyRefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitAnyRefConstant(clazz, new FieldrefConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <p>Method under test: {@link ConstantVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
  @DisplayName("Test visitFieldrefConstant(Clazz, FieldrefConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  void testVisitFieldrefConstant() {
    // Arrange
    ConstantCounter constantCounter = new ConstantCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    constantCounter.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    assertEquals(1, constantCounter.getCount());
  }

  /**
   * Test {@link ConstantVisitor#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)"})
  void testVisitAnyMethodrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantLookupVisitor.visitAnyMethodrefConstant(
                clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantVisitor.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantLookupVisitor.visitInterfaceMethodrefConstant(
                clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  void testVisitMethodrefConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitMethodrefConstant(clazz, new MethodrefConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitClassConstant(Clazz, ClassConstant)"})
  void testVisitClassConstant() {
    // Arrange
    ConstantCounter constantCounter = new ConstantCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    constantCounter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    assertEquals(1, constantCounter.getCount());
  }

  /**
   * Test {@link ConstantVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitMethodTypeConstant(Clazz, MethodTypeConstant)"})
  void testVisitMethodTypeConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitMethodTypeConstant(clazz, new MethodTypeConstant()));
  }

  /**
   * Test {@link ConstantVisitor#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantVisitor#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantVisitor.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"})
  void testVisitNameAndTypeConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
  }
}
