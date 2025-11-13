package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.evaluation.value.BasicValueFactory;

class MapAbstractStateDiffblueTest {
  /**
   * Test {@link MapAbstractState#join(MapAbstractState)} with {@code MapAbstractState}.
   *
   * <ul>
   *   <li>Then return {@link HashMapAbstractState#HashMapAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link MapAbstractState#join(MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(MapAbstractState) with 'MapAbstractState'; then return HashMapAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapAbstractState MapAbstractState.join(MapAbstractState)"})
  void testJoinWithMapAbstractState_thenReturnHashMapAbstractState() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Act
    MapAbstractState<Object, ValueAbstractState> actualJoinResult =
        objectValueAbstractStateMap.join(new HashMapAbstractState<>());

    // Assert
    assertSame(objectValueAbstractStateMap, actualJoinResult);
  }

  /**
   * Test {@link MapAbstractState#isLessOrEqual(MapAbstractState)} with {@code MapAbstractState}.
   *
   * <p>Method under test: {@link MapAbstractState#isLessOrEqual(MapAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(MapAbstractState) with 'MapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapAbstractState.isLessOrEqual(MapAbstractState)"})
  void testIsLessOrEqualWithMapAbstractState() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();
    objectValueAbstractStateMap.put("Key", ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> abstractState = new HashMapAbstractState<>();
    abstractState.put("Key", new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertFalse(objectValueAbstractStateMap.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link MapAbstractState#isLessOrEqual(MapAbstractState)} with {@code MapAbstractState}.
   *
   * <ul>
   *   <li>Given {@link HashMapAbstractState#HashMapAbstractState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapAbstractState#isLessOrEqual(MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(MapAbstractState) with 'MapAbstractState'; given HashMapAbstractState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapAbstractState.isLessOrEqual(MapAbstractState)"})
  void testIsLessOrEqualWithMapAbstractState_givenHashMapAbstractState_thenReturnTrue() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Act and Assert
    assertTrue(objectValueAbstractStateMap.isLessOrEqual(new HashMapAbstractState<>()));
  }

  /**
   * Test {@link MapAbstractState#isLessOrEqual(MapAbstractState)} with {@code MapAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapAbstractState#isLessOrEqual(MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(MapAbstractState) with 'MapAbstractState'; given UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapAbstractState.isLessOrEqual(MapAbstractState)"})
  void testIsLessOrEqualWithMapAbstractState_givenUnknown_thenReturnTrue() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();
    objectValueAbstractStateMap.put("Key", ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> abstractState = new HashMapAbstractState<>();
    abstractState.put("Key", ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(objectValueAbstractStateMap.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link MapAbstractState#isLessOrEqual(MapAbstractState)} with {@code MapAbstractState}.
   *
   * <ul>
   *   <li>When {@link HashMapAbstractState#HashMapAbstractState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapAbstractState#isLessOrEqual(MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(MapAbstractState) with 'MapAbstractState'; when HashMapAbstractState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapAbstractState.isLessOrEqual(MapAbstractState)"})
  void testIsLessOrEqualWithMapAbstractState_whenHashMapAbstractState_thenReturnFalse() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();
    objectValueAbstractStateMap.put("Key", ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertFalse(objectValueAbstractStateMap.isLessOrEqual(new HashMapAbstractState<>()));
  }
}
