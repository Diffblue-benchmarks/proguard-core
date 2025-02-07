package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassSignatureDiffblueTest {
  /**
   * Test {@link ClassSignature#ClassSignature(String)}.
   *
   * <p>Method under test: {@link ClassSignature#ClassSignature(String)}
   */
  @Test
  @DisplayName("Test new ClassSignature(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassSignature.<init>(java.lang.String)"})
  void testNewClassSignature() {
    // Arrange and Act
    ClassSignature actualClassSignature = new ClassSignature("Class Name");

    // Assert
    assertEquals("", actualClassSignature.getExternalPackageName());
    assertEquals("", actualClassSignature.getPackageName());
    assertEquals("Class Name", actualClassSignature.getClassName());
    assertEquals("Class Name", actualClassSignature.getFqn());
    assertEquals("Class Name", actualClassSignature.getPrettyFqn());
    assertEquals("Class Name", actualClassSignature.fqn);
    assertEquals("Class Name", actualClassSignature.prettyFqn);
    assertNull(actualClassSignature.getReferencedClass());
    assertEquals(1643854963, actualClassSignature.hashCode);
    assertFalse(actualClassSignature.isIncomplete());
  }

  /**
   * Test {@link ClassSignature#ClassSignature(Clazz)}.
   *
   * <ul>
   *   <li>Then return ExternalPackageName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassSignature#ClassSignature(Clazz)}
   */
  @Test
  @DisplayName("Test new ClassSignature(Clazz); then return ExternalPackageName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ClassSignature.<init>(proguard.classfile.Clazz)"})
  void testNewClassSignature_thenReturnExternalPackageNameIsEmptyString() {
    // Arrange and Act
    ClassSignature actualClassSignature =
        new ClassSignature(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals("", actualClassSignature.getExternalPackageName());
    assertEquals("", actualClassSignature.getPackageName());
    assertEquals("This Class Name", actualClassSignature.getClassName());
    assertEquals("This Class Name", actualClassSignature.getFqn());
    assertEquals("This Class Name", actualClassSignature.getPrettyFqn());
    assertEquals("This Class Name", actualClassSignature.fqn);
    assertEquals("This Class Name", actualClassSignature.prettyFqn);
    assertNull(actualClassSignature.getReferencedClass());
    assertEquals(-2060103915, actualClassSignature.hashCode);
    assertFalse(actualClassSignature.isIncomplete());
  }

  /**
   * Test {@link ClassSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link ClassSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ClassSignature.isIncomplete()"})
  void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse((new ClassSignature("Class Name")).isIncomplete());
  }

  /**
   * Test {@link ClassSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculateFqn()}
   */
  @Test
  @DisplayName("Test calculateFqn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ClassSignature.calculateFqn()"})
  void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculateFqn());
  }

  /**
   * Test {@link ClassSignature#calculatePrettyFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ClassSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculatePrettyFqn());
  }

  /**
   * Test {@link ClassSignature#computeIfAbsent(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Then return ExternalPackageName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassSignature#computeIfAbsent(Clazz)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(Clazz) with 'clazz'; then return ExternalPackageName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassSignature proguard.classfile.ClassSignature.computeIfAbsent(proguard.classfile.Clazz)"
  })
  void testComputeIfAbsentWithClazz_thenReturnExternalPackageNameIsEmptyString() {
    // Arrange and Act
    ClassSignature actualComputeIfAbsentResult =
        ClassSignature.computeIfAbsent(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals("", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("", actualComputeIfAbsentResult.getPackageName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getClassName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("This Class Name", actualComputeIfAbsentResult.fqn);
    assertEquals("This Class Name", actualComputeIfAbsentResult.prettyFqn);
    assertNull(actualComputeIfAbsentResult.getReferencedClass());
    assertEquals(-2060103915, actualComputeIfAbsentResult.hashCode);
    assertFalse(actualComputeIfAbsentResult.isIncomplete());
  }
}
