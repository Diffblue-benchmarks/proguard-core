package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class BootstrapMethodsAttributeAdderDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttributeAdder#getBootstrapMethodIndex()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeAdder#getBootstrapMethodIndex()}
   */
  @Test
  @DisplayName("Test getBootstrapMethodIndex(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BootstrapMethodsAttributeAdder.getBootstrapMethodIndex()"})
  void testGetBootstrapMethodIndex_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Act and Assert
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
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(new ProgramClass(1, 1, constantPool, 1, 1, 1));
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
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(new ProgramClass(1, 0, constantPool, 1, 1, 1));
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
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo3() {
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
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    BootstrapMethodsAttributeAdder bootstrapMethodsAttributeAdder =
        new BootstrapMethodsAttributeAdder(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodsAttributeAdder.visitBootstrapMethodInfo(
        clazz, new BootstrapMethodInfo(1, 3, new int[] {1, 2, 1, 2}));

    // Assert
    assertEquals(0, bootstrapMethodsAttributeAdder.getBootstrapMethodIndex());
  }
}
