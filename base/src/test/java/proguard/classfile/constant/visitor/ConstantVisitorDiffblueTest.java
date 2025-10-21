package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class ConstantVisitorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitAnyConstant(Clazz, Constant)"})
  public void testVisitAnyConstant_whenClassConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitLongConstant(Clazz, LongConstant)"})
  public void testVisitLongConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitDoubleConstant(Clazz, DoubleConstant)"})
  public void testVisitDoubleConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantVisitor.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  public void testVisitPrimitiveArrayConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitStringConstant(Clazz, StringConstant)"})
  public void testVisitStringConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitUtf8Constant(Clazz, Utf8Constant)"})
  public void testVisitUtf8Constant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantVisitor.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitMethodHandleConstant(Clazz, MethodHandleConstant)"})
  public void testVisitMethodHandleConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitModuleConstant(Clazz, ModuleConstant)"})
  public void testVisitModuleConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitPackageConstant(Clazz, PackageConstant)"})
  public void testVisitPackageConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitAnyRefConstant(Clazz, RefConstant)"})
  public void testVisitAnyRefConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitFieldrefConstant(Clazz, FieldrefConstant)"})
  public void testVisitFieldrefConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)"})
  public void testVisitAnyMethodrefConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantVisitor.visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)"
  })
  public void testVisitInterfaceMethodrefConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitMethodrefConstant(Clazz, MethodrefConstant)"})
  public void testVisitMethodrefConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitMethodTypeConstant(Clazz, MethodTypeConstant)"})
  public void testVisitMethodTypeConstant_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantVisitor.visitNameAndTypeConstant(Clazz, NameAndTypeConstant)"})
  public void testVisitNameAndTypeConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
  }
}
