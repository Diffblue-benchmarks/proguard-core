package proguard.evaluation.executor.instancehandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class ExecutorMethodInstanceHandlerDiffblueTest {
  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link
   *       CollectionMatcher#CollectionMatcher(Set)} with set is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @DisplayName(
      "Test returnsOwnInstance(String, String); given HashMap() '42' is CollectionMatcher(Set) with set is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExecutorMethodInstanceHandler.returnsOwnInstance(String, String)"})
  void testReturnsOwnInstance_givenHashMap42IsCollectionMatcherWithSetIsHashSet() {
    // Arrange
    HashMap<String, StringMatcher> alwaysReturnsOwnInstance = new HashMap<>();
    alwaysReturnsOwnInstance.put("42", new CollectionMatcher(new HashSet<>()));

    // Act and Assert
    assertFalse(
        new ExecutorMethodInstanceHandler(alwaysReturnsOwnInstance)
            .returnsOwnInstance("42", "Method Name"));
  }

  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link EmptyStringMatcher} (default
   *       constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @DisplayName(
      "Test returnsOwnInstance(String, String); given HashMap() '42' is EmptyStringMatcher (default constructor); when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExecutorMethodInstanceHandler.returnsOwnInstance(String, String)"})
  void testReturnsOwnInstance_givenHashMap42IsEmptyStringMatcher_when42_thenReturnFalse() {
    // Arrange
    HashMap<String, StringMatcher> alwaysReturnsOwnInstance = new HashMap<>();
    alwaysReturnsOwnInstance.put("42", new EmptyStringMatcher());

    // Act and Assert
    assertFalse(
        new ExecutorMethodInstanceHandler(alwaysReturnsOwnInstance)
            .returnsOwnInstance("42", "Method Name"));
  }

  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @DisplayName("Test returnsOwnInstance(String, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExecutorMethodInstanceHandler.returnsOwnInstance(String, String)"})
  void testReturnsOwnInstance_thenReturnTrue() {
    // Arrange
    HashMap<String, StringMatcher> alwaysReturnsOwnInstance = new HashMap<>();
    alwaysReturnsOwnInstance.put("42", new ConstantMatcher(true));

    // Act and Assert
    assertTrue(
        new ExecutorMethodInstanceHandler(alwaysReturnsOwnInstance)
            .returnsOwnInstance("42", "Method Name"));
  }

  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <ul>
   *   <li>When {@code Internal Class Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @DisplayName(
      "Test returnsOwnInstance(String, String); when 'Internal Class Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExecutorMethodInstanceHandler.returnsOwnInstance(String, String)"})
  void testReturnsOwnInstance_whenInternalClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ExecutorMethodInstanceHandler(new HashMap<>())
            .returnsOwnInstance("Internal Class Name", "Method Name"));
  }
}
