package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MethodDescriptorDiffblueTest {
  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @DisplayName("Test new MethodDescriptor(String, List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.MethodDescriptor.<init>(java.lang.String, java.util.List)"
  })
  void testNewMethodDescriptor_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("42");
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, actualMethodDescriptor.getArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ArgumentTypes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test new MethodDescriptor(String, List); given 'foo'; then return ArgumentTypes is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.MethodDescriptor.<init>(java.lang.String, java.util.List)"
  })
  void testNewMethodDescriptor_givenFoo_thenReturnArgumentTypesIsArrayList() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, actualMethodDescriptor.getArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PrettyArgumentTypes is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test new MethodDescriptor(String, List); when ArrayList(); then return PrettyArgumentTypes is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.MethodDescriptor.<init>(java.lang.String, java.util.List)"
  })
  void testNewMethodDescriptor_whenArrayList_thenReturnPrettyArgumentTypesIsEmptyString() {
    // Arrange and Act
    MethodDescriptor actualMethodDescriptor =
        new MethodDescriptor("Return Type", new ArrayList<>());

    // Assert
    assertEquals("", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertTrue(actualMethodDescriptor.getArgumentTypes().isEmpty());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return PrettyArgumentTypes is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String)}
   */
  @Test
  @DisplayName(
      "Test new MethodDescriptor(String); when 'null'; then return PrettyArgumentTypes is '?'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.MethodDescriptor.<init>(java.lang.String)"})
  void testNewMethodDescriptor_whenNull_thenReturnPrettyArgumentTypesIsQuestionMark() {
    // Arrange and Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor(null);

    // Assert
    assertEquals("?", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("?", actualMethodDescriptor.getPrettyReturnType());
    assertNull(actualMethodDescriptor.getReturnType());
    assertNull(actualMethodDescriptor.getArgumentTypes());
    assertTrue(actualMethodDescriptor.isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#isIncomplete()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.MethodDescriptor.isIncomplete()"})
  void testIsIncomplete_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MethodDescriptor("Return Type", new ArrayList<>())).isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#isIncomplete()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.MethodDescriptor.isIncomplete()"})
  void testIsIncomplete_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MethodDescriptor(null, new ArrayList<>())).isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor); given 'foo'; when ArrayList() add 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNull(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNull_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNull(null, null));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("", new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    ArrayList<String> argumentTypes2 = new ArrayList<>();
    argumentTypes2.add("42");

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", argumentTypes2)));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); given 'foo'; when ArrayList() add 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.matchesIgnoreNullAndDollar(proguard.classfile.MethodDescriptor, proguard.classfile.MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNullAndDollar(null, null));
  }

  /**
   * Test {@link MethodDescriptor#getPrettyReturnType()}.
   *
   * <ul>
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#getPrettyReturnType()}
   */
  @Test
  @DisplayName("Test getPrettyReturnType(); then return '?'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.MethodDescriptor.getPrettyReturnType()"})
  void testGetPrettyReturnType_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", (new MethodDescriptor(null, new ArrayList<>())).getPrettyReturnType());
  }

  /**
   * Test {@link MethodDescriptor#getPrettyArgumentTypes()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#getPrettyArgumentTypes()}
   */
  @Test
  @DisplayName("Test getPrettyArgumentTypes(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.MethodDescriptor.getPrettyArgumentTypes()"
  })
  void testGetPrettyArgumentTypes_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", (new MethodDescriptor("Return Type", new ArrayList<>())).getPrettyArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code (foo)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @DisplayName("Test toString(); given ArrayList() add 'foo'; then return '(foo)Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.MethodDescriptor.toString()"})
  void testToString_givenArrayListAddFoo_thenReturnFooReturnType() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act and Assert
    assertEquals(
        "(foo)Return Type", (new MethodDescriptor("Return Type", argumentTypes)).toString());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ()?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '()?'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.MethodDescriptor.toString()"})
  void testToString_thenReturnLeftParenthesisRightParenthesisQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("()?", (new MethodDescriptor(null, new ArrayList<>())).toString());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ()Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '()Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.MethodDescriptor.toString()"})
  void testToString_thenReturnReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "()Return Type", (new MethodDescriptor("Return Type", new ArrayList<>())).toString());
  }

  /**
   * Test {@link MethodDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.MethodDescriptor.equals(java.lang.Object)",
    "int proguard.classfile.MethodDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodDescriptor("Return Type", new ArrayList<>()), "42");
  }
}
