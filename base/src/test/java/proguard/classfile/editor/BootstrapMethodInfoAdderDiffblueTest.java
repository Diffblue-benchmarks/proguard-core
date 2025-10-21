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
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodInfoAdderDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.<init>(ProgramClass, BootstrapMethodsAttribute)"
  })
  public void testNewBootstrapMethodInfoAdder_givenTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.<init>(ProgramClass, BootstrapMethodsAttribute)"
  })
  public void testNewBootstrapMethodInfoAdder_whenProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BootstrapMethodInfoAdder.getBootstrapMethodIndex()"})
  public void testGetBootstrapMethodIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodInfoAdder.visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)"
  })
  public void testVisitBootstrapMethodInfo() {
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
