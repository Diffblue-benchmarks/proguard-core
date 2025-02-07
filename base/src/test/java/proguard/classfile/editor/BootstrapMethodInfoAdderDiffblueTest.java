package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

class BootstrapMethodInfoAdderDiffblueTest {
  /**
   * Test {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test new BootstrapMethodInfoAdder(ProgramClass, BootstrapMethodsAttribute); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodInfoAdder.<init>(proguard.classfile.ProgramClass, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testNewBootstrapMethodInfoAdder_givenTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertEquals(
        0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute()))
            .getBootstrapMethodIndex());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodInfoAdder.<init>(proguard.classfile.ProgramClass, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testNewBootstrapMethodInfoAdder_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertEquals(
        0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute()))
            .getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#getBootstrapMethodIndex()}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#getBootstrapMethodIndex()}
   */
  @Test
  @DisplayName("Test getBootstrapMethodIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.BootstrapMethodInfoAdder.getBootstrapMethodIndex()"
  })
  void testGetBootstrapMethodIndex() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertEquals(
        0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute()))
            .getBootstrapMethodIndex());
  }

  /**
   * Test {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodInfoAdder.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder =
        new BootstrapMethodInfoAdder(
            targetClass,
            new BootstrapMethodsAttribute(
                1, 3, new BootstrapMethodInfo[] {new BootstrapMethodInfo()}));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodInfoAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(3, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }
}
