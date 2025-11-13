package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodDescriptor.<init>(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodDescriptor.isIncomplete()"})
  void testIsIncomplete_thenReturnFalse() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertFalse(methodDescriptor.isIncomplete());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodDescriptor.isIncomplete()"})
  void testIsIncomplete_thenReturnTrue() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertTrue(methodDescriptor.isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNull() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullResult =
        MethodDescriptor.matchesIgnoreNull(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullResult);
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNull(MethodDescriptor, MethodDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNull2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor(null, new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullResult =
        MethodDescriptor.matchesIgnoreNull(descriptor, wildcard);

    // Assert
    assertTrue(actualMatchesIgnoreNullResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNull_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullResult =
        MethodDescriptor.matchesIgnoreNull(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNull_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullResult =
        MethodDescriptor.matchesIgnoreNull(descriptor, wildcard);

    // Assert
    assertTrue(actualMatchesIgnoreNullResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNull_whenNull_thenReturnFalse() {
    // Arrange
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullResult = MethodDescriptor.matchesIgnoreNull(null, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("", new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName("Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor(null, new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertTrue(actualMatchesIgnoreNullAndDollarResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    ArrayList<String> argumentTypes2 = new ArrayList<>();
    argumentTypes2.add("42");
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", argumentTypes2);

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor); given empty string; when ArrayList() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("");
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    ArrayList<String> argumentTypes2 = new ArrayList<>();
    argumentTypes2.add("");
    argumentTypes2.add("42");
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", argumentTypes2);

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, wildcard);

    // Assert
    assertTrue(actualMatchesIgnoreNullAndDollarResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  void testMatchesIgnoreNullAndDollar_whenNull_thenReturnFalse() {
    // Arrange
    MethodDescriptor wildcard = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    boolean actualMatchesIgnoreNullAndDollarResult =
        MethodDescriptor.matchesIgnoreNullAndDollar(null, wildcard);

    // Assert
    assertFalse(actualMatchesIgnoreNullAndDollarResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodDescriptor.getPrettyReturnType()"})
  void testGetPrettyReturnType_thenReturnQuestionMark() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertEquals("?", methodDescriptor.getPrettyReturnType());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodDescriptor.getPrettyArgumentTypes()"})
  void testGetPrettyArgumentTypes_thenReturnEmptyString() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertEquals("", methodDescriptor.getPrettyArgumentTypes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  void testToString_givenArrayListAddFoo_thenReturnFooReturnType() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor methodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertEquals("(foo)Return Type", methodDescriptor.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  void testToString_thenReturnLeftParenthesisRightParenthesisQuestionMark() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertEquals("()?", methodDescriptor.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  void testToString_thenReturnReturnType() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertEquals("()Return Type", methodDescriptor.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodDescriptor.equals(Object)", "int MethodDescriptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodDescriptor methodDescriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertNotEquals(methodDescriptor, "42");
  }
}
