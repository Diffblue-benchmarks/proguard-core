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
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;

class BootstrapMethodInfoAdderDiffblueTest {
  /**
   * Test {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName("Test new BootstrapMethodInfoAdder(ProgramClass, BootstrapMethodsAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.<init>(ProgramClass, BootstrapMethodsAttribute)"
  })
  void testNewBootstrapMethodInfoAdder() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);

    // Act
    BootstrapMethodInfoAdder actualBootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, actualBootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test new BootstrapMethodInfoAdder(ProgramClass, BootstrapMethodsAttribute); when ProgramClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.<init>(ProgramClass, BootstrapMethodsAttribute)"
  })
  void testNewBootstrapMethodInfoAdder_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    BootstrapMethodInfoAdder actualBootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, actualBootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#getBootstrapMethodIndex()}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#getBootstrapMethodIndex()}
   */
  @Test
  @DisplayName("Test getBootstrapMethodIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BootstrapMethodInfoAdder.getBootstrapMethodIndex()"})
  void testGetBootstrapMethodIndex() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute());

    // Act and Assert
    assertEquals(0, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(
            targetClass, new BootstrapMethodsAttribute(1, 3, bootstrapMethods));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodInfoAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(3, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(
            targetClass, new BootstrapMethodsAttribute(1, 3, bootstrapMethods));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodInfoAdder.visitBootstrapMethodInfo(
        clazz, new BootstrapMethodInfo(1, 3, new int[] {1, 0, 1, 0}));

    // Assert
    assertEquals(3, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(6, 1, constantPool, 6, 6, 6);
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(
            targetClass, new BootstrapMethodsAttribute(1, 3, bootstrapMethods));
    Constant[] constantPool2 = new Constant[] {new DoubleConstant()};
    ProgramClass clazz = new ProgramClass(1, 3, constantPool2, 1, 1, 1);

    // Act
    bootstrapMethodInfoAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(3, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }
}
