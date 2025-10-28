package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test: {@link ConstantVisitor#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  public void testVisitAnyConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitAnyConstant(clazz, new ClassConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitIntegerConstant(clazz, new IntegerConstant(42)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  public void testVisitLongConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitLongConstant(clazz, new LongConstant(42L)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  public void testVisitFloatConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitFloatConstant(clazz, new FloatConstant(10.0f)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  public void testVisitDoubleConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitDoubleConstant(clazz, new DoubleConstant(10.0d)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   */
  @Test
  public void testVisitPrimitiveArrayConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  public void testVisitStringConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitStringConstant(clazz, new StringConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  public void testVisitUtf8Constant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitUtf8Constant(clazz, new Utf8Constant("String")));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  public void testVisitModuleConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitModuleConstant(clazz, new ModuleConstant(1)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  public void testVisitPackageConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitPackageConstant(clazz, new PackageConstant(1)));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  public void testVisitAnyRefConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitAnyRefConstant(clazz, new FieldrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
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
   * Method under test:
   * {@link ConstantVisitor#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}
   */
  @Test
  public void testVisitAnyMethodrefConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)}
   */
  @Test
  public void testVisitInterfaceMethodrefConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitInterfaceMethodrefConstant(clazz, new InterfaceMethodrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  public void testVisitMethodrefConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitMethodrefConstant(clazz, new MethodrefConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
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
   * Method under test:
   * {@link ConstantVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitMethodTypeConstant(clazz, new MethodTypeConstant()));
  }

  /**
   * Method under test:
   * {@link ConstantVisitor#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  public void testVisitNameAndTypeConstant() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantLookupVisitor.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1)));
  }
}
