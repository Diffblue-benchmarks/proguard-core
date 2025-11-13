package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DescriptorClassEnumerationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)}
   *   <li>{@link DescriptorClassEnumeration#isInnerClassName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DescriptorClassEnumeration.<init>(String)",
    "boolean DescriptorClassEnumeration.isInnerClassName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new DescriptorClassEnumeration("Descriptor").isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#classCount()}.
   *
   * <ul>
   *   <li>Given {@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)} with {@code
   *       Descriptor}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#classCount()}
   */
  @Test
  @DisplayName(
      "Test classCount(); given DescriptorClassEnumeration(String) with 'Descriptor'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DescriptorClassEnumeration.classCount()"})
  void testClassCount_givenDescriptorClassEnumerationWithDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DescriptorClassEnumeration("Descriptor").classCount());
  }

  /**
   * Test {@link DescriptorClassEnumeration#hasMoreClassNames()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#hasMoreClassNames()}
   */
  @Test
  @DisplayName("Test hasMoreClassNames(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DescriptorClassEnumeration.hasMoreClassNames()"})
  void testHasMoreClassNames_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DescriptorClassEnumeration("").hasMoreClassNames());
  }

  /**
   * Test {@link DescriptorClassEnumeration#hasMoreClassNames()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#hasMoreClassNames()}
   */
  @Test
  @DisplayName("Test hasMoreClassNames(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DescriptorClassEnumeration.hasMoreClassNames()"})
  void testHasMoreClassNames_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DescriptorClassEnumeration("Descriptor").hasMoreClassNames());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextFluff()}.
   *
   * <ul>
   *   <li>Given {@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)} with {@code
   *       Descriptor}.
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  @DisplayName(
      "Test nextFluff(); given DescriptorClassEnumeration(String) with 'Descriptor'; then return 'Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextFluff()"})
  void testNextFluff_givenDescriptorClassEnumerationWithDescriptor_thenReturnDescriptor() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration =
        new DescriptorClassEnumeration("Descriptor");

    // Act and Assert
    assertEquals("Descriptor", descriptorClassEnumeration.nextFluff());
    assertFalse(descriptorClassEnumeration.hasMoreClassNames());
    assertFalse(descriptorClassEnumeration.isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextFluff()}.
   *
   * <ul>
   *   <li>Then return {@code java.}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  @DisplayName("Test nextFluff(); then return 'java.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextFluff()"})
  void testNextFluff_thenReturnJava() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration =
        new DescriptorClassEnumeration("java.lang.String");

    // Act and Assert
    assertEquals("java.", descriptorClassEnumeration.nextFluff());
    assertTrue(descriptorClassEnumeration.hasMoreClassNames());
    assertTrue(descriptorClassEnumeration.isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextClassName()}.
   *
   * <ul>
   *   <li>Then return {@code java}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextClassName()}
   */
  @Test
  @DisplayName("Test nextClassName(); then return 'java'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextClassName()"})
  void testNextClassName_thenReturnJava() {
    // Arrange, Act and Assert
    assertEquals("java", new DescriptorClassEnumeration("java.lang.String").nextClassName());
  }
}
