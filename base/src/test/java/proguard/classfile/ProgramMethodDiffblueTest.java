package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class ProgramMethodDiffblueTest {
  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[])}.
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramMethod.<init>(int, int, int, Clazz[])"})
  public void testNewProgramMethod() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass});

    // Assert
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof LibraryClass);
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazz);
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[], int, Object)}.
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[], int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramMethod.<init>(int, int, int, Clazz[], int, Object)"})
  public void testNewProgramMethod2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass}, 1, "Processing Info");

    // Assert
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof LibraryClass);
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazz);
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramMethod.<init>()",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[])",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[], int, Object)"
  })
  public void testNewProgramMethod_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    ProgramMethod actualProgramMethod = new ProgramMethod();

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getAccessFlags());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[])}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[],
   * Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramMethod.<init>()",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[])",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[], int, Object)"
  })
  public void testNewProgramMethod_whenOne_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new Clazz[] {new LibraryClass()});

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(1, actualProgramMethod.getAccessFlags());
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[], int,
   * Object)}.
   *
   * <ul>
   *   <li>When {@code Processing Info}.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[],
   * Clazz[], int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramMethod.<init>()",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[])",
    "void ProgramMethod.<init>(int, int, int, int, Attribute[], Clazz[], int, Object)"
  })
  public void testNewProgramMethod_whenProcessingInfo_thenReturnProcessingInfo() {
    // Arrange and Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new Clazz[] {new LibraryClass()},
            1,
            "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
  }
}
