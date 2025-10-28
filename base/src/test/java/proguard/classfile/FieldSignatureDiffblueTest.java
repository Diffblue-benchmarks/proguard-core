package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FieldSignatureDiffblueTest {
  /**
   * Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse((new FieldSignature("Clazz Name", "Member Name", "Descriptor")).isIncomplete());
    assertTrue((new FieldSignature(null, "Member Name", "Descriptor")).isIncomplete());
    assertTrue((new FieldSignature("Clazz Name", null, "Descriptor")).isIncomplete());
    assertTrue((new FieldSignature("Clazz Name", "Member Name", null)).isIncomplete());
  }

  /**
   * Method under test: {@link FieldSignature#calculateFqn()}
   */
  @Test
  public void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("LClazz Name;Member Name",
        (new FieldSignature("Clazz Name", "Member Name", "Descriptor")).calculateFqn());
  }

  /**
   * Method under test: {@link FieldSignature#calculatePrettyFqn()}
   */
  @Test
  public void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("null Clazz Name.Member Name",
        (new FieldSignature("Clazz Name", "Member Name", null)).calculatePrettyFqn());
    assertEquals("null ?.Member Name", (new FieldSignature(null, "Member Name", null)).calculatePrettyFqn());
  }

  /**
   * Method under test: {@link FieldSignature#computeIfAbsent(Clazz, Field)}
   */
  @Test
  public void testComputeIfAbsent() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    FieldSignature actualComputeIfAbsentResult = FieldSignature.computeIfAbsent(clazz,
        (Field) new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals("?", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("?", actualComputeIfAbsentResult.getPackageName());
    assertEquals("Descriptor", actualComputeIfAbsentResult.descriptor);
    assertEquals("Lnull;Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("Lnull;Name", actualComputeIfAbsentResult.fqn);
    assertEquals("Name", actualComputeIfAbsentResult.memberName);
    assertNull(actualComputeIfAbsentResult.getClassName());
    assertNull(actualComputeIfAbsentResult.prettyFqn);
    assertNull(actualComputeIfAbsentResult.getReferencedClass());
    assertEquals(1320159907, actualComputeIfAbsentResult.hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    FieldSignature fieldSignature2 = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertEquals(fieldSignature, fieldSignature2);
    int expectedHashCodeResult = fieldSignature.hashCode();
    assertEquals(expectedHashCodeResult, fieldSignature2.hashCode());
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertEquals(fieldSignature, fieldSignature);
    int expectedHashCodeResult = fieldSignature.hashCode();
    assertEquals(expectedHashCodeResult, fieldSignature.hashCode());
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature(null, "Member Name", "Descriptor");

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", null, "Descriptor");

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", null);

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldSignature("Clazz Name", "Member Name", "Descriptor"), null);
  }

  /**
   * Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldSignature("Clazz Name", "Member Name", "Descriptor"), "Different type to FieldSignature");
  }

  /**
   * Method under test:
   * {@link FieldSignature#FieldSignature(String, String, String)}
   */
  @Test
  public void testNewFieldSignature() {
    // Arrange and Act
    FieldSignature actualFieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Assert
    assertEquals("", actualFieldSignature.getExternalPackageName());
    assertEquals("", actualFieldSignature.getPackageName());
    assertEquals("Clazz Name", actualFieldSignature.getClassName());
    assertEquals("Descriptor", actualFieldSignature.descriptor);
    assertEquals("LClazz Name;Member Name", actualFieldSignature.getFqn());
    assertEquals("LClazz Name;Member Name", actualFieldSignature.fqn);
    assertEquals("Member Name", actualFieldSignature.memberName);
    assertNull(actualFieldSignature.prettyFqn);
    assertNull(actualFieldSignature.getReferencedClass());
    assertEquals(-1729212272, actualFieldSignature.hashCode);
    assertFalse(actualFieldSignature.isIncomplete());
  }

  /**
   * Method under test: {@link FieldSignature#FieldSignature(Clazz, Field)}
   */
  @Test
  public void testNewFieldSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    FieldSignature actualFieldSignature = new FieldSignature(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals("?", actualFieldSignature.getExternalPackageName());
    assertEquals("?", actualFieldSignature.getPackageName());
    assertEquals("Descriptor", actualFieldSignature.descriptor);
    assertEquals("Lnull;Name", actualFieldSignature.getFqn());
    assertEquals("Lnull;Name", actualFieldSignature.fqn);
    assertEquals("Name", actualFieldSignature.memberName);
    assertNull(actualFieldSignature.getClassName());
    assertNull(actualFieldSignature.prettyFqn);
    assertNull(actualFieldSignature.getReferencedClass());
    assertEquals(1320159907, actualFieldSignature.hashCode);
    assertTrue(actualFieldSignature.isIncomplete());
  }
}
