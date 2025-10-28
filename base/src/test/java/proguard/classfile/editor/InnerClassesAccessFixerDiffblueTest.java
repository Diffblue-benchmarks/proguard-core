package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;

public class InnerClassesAccessFixerDiffblueTest {
  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo2() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    innerClassesInfo.u2innerClassIndex = 0;

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo3() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo4() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant(1, new LibraryClass())},
        1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo5() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new DoubleConstant(10.0d)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo6() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new DynamicConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo7() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new FieldrefConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo8() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new FloatConstant(10.0f)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo9() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new IntegerConstant(42)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo10() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new InterfaceMethodrefConstant()}, 1, 1,
        1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo11() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new InvokeDynamicConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Method under test:
   * {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  public void testVisitInnerClassesInfo12() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant(1, new ProgramClass())},
        1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(0, innerClassesInfo.u2innerClassAccessFlags);
  }
}
