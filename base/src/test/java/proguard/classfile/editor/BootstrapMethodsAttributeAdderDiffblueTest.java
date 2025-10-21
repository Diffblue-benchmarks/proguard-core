package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

public class BootstrapMethodsAttributeAdderDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo() {
    // Arrange
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(0, bootstrapMethodsAttributeAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo2() {
    // Arrange
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(
            new ProgramClass(1, 0, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(0, bootstrapMethodsAttributeAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(0, bootstrapMethodsAttributeAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo4() {
    // Arrange
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(
        clazz, new BootstrapMethodInfo(1, 3, new int[] {1, 2, 1, 2}));

    // Assert
    assertEquals(0, bootstrapMethodsAttributeAdder.getBootstrapMethodIndex());
  }
}
