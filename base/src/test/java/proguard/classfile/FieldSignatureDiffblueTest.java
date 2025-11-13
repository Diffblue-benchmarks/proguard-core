package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldSignatureDiffblueTest {
  /**
   * Test {@link FieldSignature#FieldSignature(String, String, String)}.
   *
   * <p>Method under test: {@link FieldSignature#FieldSignature(String, String, String)}
   */
  @Test
  @DisplayName("Test new FieldSignature(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldSignature.<init>(String, String, String)"})
  void testNewFieldSignature() {
    // Arrange and Act
    FieldSignature actualFieldSignature =
        new FieldSignature("Clazz Name", "Member Name", "Descriptor");

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
   * Test {@link FieldSignature#FieldSignature(Clazz, Field)}.
   *
   * <p>Method under test: {@link FieldSignature#FieldSignature(Clazz, Field)}
   */
  @Test
  @DisplayName("Test new FieldSignature(Clazz, Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldSignature.<init>(Clazz, Field)"})
  void testNewFieldSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    FieldSignature actualFieldSignature = new FieldSignature(clazz, field);

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

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  void testIsIncomplete() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature(null, "Member Name", "Descriptor");

    // Act and Assert
    assertTrue(fieldSignature.isIncomplete());
  }

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  void testIsIncomplete2() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", null, "Descriptor");

    // Act and Assert
    assertTrue(fieldSignature.isIncomplete());
  }

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  void testIsIncomplete3() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", null);

    // Act and Assert
    assertTrue(fieldSignature.isIncomplete());
  }

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  void testIsIncomplete_thenReturnFalse() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertFalse(fieldSignature.isIncomplete());
  }

  /**
   * Test {@link FieldSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link FieldSignature#calculateFqn()}
   */
  @Test
  @DisplayName("Test calculateFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FieldSignature.calculateFqn()"})
  void testCalculateFqn() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertEquals("LClazz Name;Member Name", fieldSignature.calculateFqn());
  }

  /**
   * Test {@link FieldSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code null Clazz Name.Member Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn(); then return 'null Clazz Name.Member Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FieldSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnNullClazzNameMemberName() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", null);

    // Act and Assert
    assertEquals("null Clazz Name.Member Name", fieldSignature.calculatePrettyFqn());
  }

  /**
   * Test {@link FieldSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code null ?.Member Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn(); then return 'null ?.Member Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FieldSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnNullMemberName() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature(null, "Member Name", null);

    // Act and Assert
    assertEquals("null ?.Member Name", fieldSignature.calculatePrettyFqn());
  }

  /**
   * Test {@link FieldSignature#computeIfAbsent(Clazz, Field)} with {@code clazz}, {@code field}.
   *
   * <ul>
   *   <li>Then return ExternalPackageName is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#computeIfAbsent(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(Clazz, Field) with 'clazz', 'field'; then return ExternalPackageName is '?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldSignature FieldSignature.computeIfAbsent(Clazz, Field)"})
  void testComputeIfAbsentWithClazzField_thenReturnExternalPackageNameIsQuestionMark() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    FieldSignature actualComputeIfAbsentResult =
        FieldSignature.computeIfAbsent(clazz, (Field) field);

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
   * Test {@link FieldSignature#equals(Object)}, and {@link FieldSignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    FieldSignature fieldSignature2 = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertEquals(fieldSignature, fieldSignature2);
    assertEquals(fieldSignature.hashCode(), fieldSignature2.hashCode());
  }

  /**
   * Test {@link FieldSignature#equals(Object)}, and {@link FieldSignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");

    // Act and Assert
    assertEquals(fieldSignature, fieldSignature);
    int expectedHashCodeResult = fieldSignature.hashCode();
    assertEquals(expectedHashCodeResult, fieldSignature.hashCode());
  }

  /**
   * Test {@link FieldSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature(null, "Member Name", "Descriptor");

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Test {@link FieldSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", null, "Descriptor");

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Test {@link FieldSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FieldSignature fieldSignature = new FieldSignature("Clazz Name", "Member Name", null);

    // Act and Assert
    assertNotEquals(fieldSignature, new FieldSignature("Clazz Name", "Member Name", "Descriptor"));
  }

  /**
   * Test {@link FieldSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldSignature("Clazz Name", "Member Name", "Descriptor"), null);
  }

  /**
   * Test {@link FieldSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FieldSignature("Clazz Name", "Member Name", "Descriptor"),
        "Different type to FieldSignature");
  }
}
