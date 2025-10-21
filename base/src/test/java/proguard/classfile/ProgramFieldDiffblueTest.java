package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class ProgramFieldDiffblueTest {
  /**
   * Test {@link ProgramField#ProgramField(int, int, int, Clazz)}.
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramField.<init>(int, int, int, Clazz)"})
  public void testNewProgramField() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, new LibraryClass());

    // Assert
    assertTrue(actualProgramField.referencedClass instanceof LibraryClass);
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getProcessingFlags());
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, Clazz, int, Object)}.
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, Clazz, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramField.<init>(int, int, int, Clazz, int, Object)"})
  public void testNewProgramField2() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(1, 1, 1, new LibraryClass(), 1, "Processing Info");

    // Assert
    assertTrue(actualProgramField.referencedClass instanceof LibraryClass);
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
  }

  /**
   * Test {@link ProgramField#ProgramField()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramField.<init>()",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz)",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz, int, Object)"
  })
  public void testNewProgramField_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField();

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getAccessFlags());
    assertEquals(0, actualProgramField.getProcessingFlags());
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramField.<init>()",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz)",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz, int, Object)"
  })
  public void testNewProgramField_whenOne_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(
            1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass());

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.getAccessFlags());
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz, int, Object)}.
   *
   * <ul>
   *   <li>When {@code Processing Info}.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz,
   * int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramField.<init>()",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz)",
    "void ProgramField.<init>(int, int, int, int, Attribute[], Clazz, int, Object)"
  })
  public void testNewProgramField_whenProcessingInfo_thenReturnProcessingInfo() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new LibraryClass(),
            1,
            "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
  }
}
