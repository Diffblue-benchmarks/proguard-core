package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;

class LatticeAbstractStateDiffblueTest {
  /**
   * Test {@link LatticeAbstractState#isLess(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link HashMapAbstractState#HashMapAbstractState()} {@code Key} is {@link
   *       ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LatticeAbstractState#isLess(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLess(LatticeAbstractState); given HashMapAbstractState() 'Key' is UNKNOWN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatticeAbstractState.isLess(LatticeAbstractState)"})
  void testIsLess_givenHashMapAbstractStateKeyIsUnknown_thenReturnFalse() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();
    objectValueAbstractStateMap.put("Key", ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertFalse(objectValueAbstractStateMap.isLess(new HashMapAbstractState<>()));
  }

  /**
   * Test {@link LatticeAbstractState#isLess(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link HashMapAbstractState#HashMapAbstractState()}.
   *   <li>When {@link HashMapAbstractState#HashMapAbstractState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LatticeAbstractState#isLess(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLess(LatticeAbstractState); given HashMapAbstractState(); when HashMapAbstractState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatticeAbstractState.isLess(LatticeAbstractState)"})
  void testIsLess_givenHashMapAbstractState_whenHashMapAbstractState_thenReturnFalse() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Act and Assert
    assertFalse(objectValueAbstractStateMap.isLess(new HashMapAbstractState<>()));
  }

  /**
   * Test {@link LatticeAbstractState#isLess(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMapAbstractState#HashMapAbstractState()} {@code Key} is {@link
   *       ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LatticeAbstractState#isLess(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLess(LatticeAbstractState); given 'Key'; when HashMapAbstractState() 'Key' is UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatticeAbstractState.isLess(LatticeAbstractState)"})
  void testIsLess_givenKey_whenHashMapAbstractStateKeyIsUnknown_thenReturnTrue() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap2 =
        new HashMapAbstractState<>();
    objectValueAbstractStateMap2.put("Key", ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(objectValueAbstractStateMap.isLess(objectValueAbstractStateMap2));
  }
}
