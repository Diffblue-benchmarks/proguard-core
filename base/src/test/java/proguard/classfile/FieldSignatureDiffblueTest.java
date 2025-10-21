package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldSignatureDiffblueTest {
  /**
   * Test {@link FieldSignature#FieldSignature(String, String, String)}.
   *
   * <p>Method under test: {@link FieldSignature#FieldSignature(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldSignature.<init>(String, String, String)"})
  public void testNewFieldSignature() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldSignature.<init>(Clazz, Field)"})
  public void testNewFieldSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    FieldSignature actualFieldSignature =
        new FieldSignature(clazz, new LibraryField(1, "Name", "Descriptor"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertTrue((new FieldSignature(null, "Member Name", "Descriptor")).isIncomplete());
  }

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  public void testIsIncomplete2() {
    // Arrange, Act and Assert
    assertTrue((new FieldSignature("Clazz Name", null, "Descriptor")).isIncomplete());
  }

  /**
   * Test {@link FieldSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link FieldSignature#isIncomplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  public void testIsIncomplete3() {
    // Arrange, Act and Assert
    assertTrue((new FieldSignature("Clazz Name", "Member Name", null)).isIncomplete());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.isIncomplete()"})
  public void testIsIncomplete_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldSignature("Clazz Name", "Member Name", "Descriptor")).isIncomplete());
  }

  /**
   * Test {@link FieldSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link FieldSignature#calculateFqn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldSignature.calculateFqn()"})
  public void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals(
        "LClazz Name;Member Name",
        (new FieldSignature("Clazz Name", "Member Name", "Descriptor")).calculateFqn());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldSignature.calculatePrettyFqn()"})
  public void testCalculatePrettyFqn_thenReturnNullClazzNameMemberName() {
    // Arrange, Act and Assert
    assertEquals(
        "null Clazz Name.Member Name",
        (new FieldSignature("Clazz Name", "Member Name", null)).calculatePrettyFqn());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldSignature.calculatePrettyFqn()"})
  public void testCalculatePrettyFqn_thenReturnNullMemberName() {
    // Arrange, Act and Assert
    assertEquals(
        "null ?.Member Name", (new FieldSignature(null, "Member Name", null)).calculatePrettyFqn());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldSignature FieldSignature.computeIfAbsent(Clazz, Field)"})
  public void testComputeIfAbsentWithClazzField_thenReturnExternalPackageNameIsQuestionMark() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    FieldSignature actualComputeIfAbsentResult =
        FieldSignature.computeIfAbsent(clazz, (Field) new LibraryField(1, "Name", "Descriptor"));

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
   * Test {@link FieldSignature#equals(Object)}, and {@link Signature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
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
   * Test {@link FieldSignature#equals(Object)}, and {@link Signature#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldSignature#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldSignature.equals(Object)"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FieldSignature("Clazz Name", "Member Name", "Descriptor"),
        "Different type to FieldSignature");
  }
}
