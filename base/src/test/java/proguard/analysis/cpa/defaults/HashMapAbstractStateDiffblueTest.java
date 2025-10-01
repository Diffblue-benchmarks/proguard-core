package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;

class HashMapAbstractStateDiffblueTest {
  /**
   * Test {@link HashMapAbstractState#HashMapAbstractState()}.
   *
   * <p>Method under test: {@link HashMapAbstractState#HashMapAbstractState()}
   */
  @Test
  @DisplayName("Test new HashMapAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HashMapAbstractState.<init>()",
    "void HashMapAbstractState.<init>(int)",
    "void HashMapAbstractState.<init>(Map)"
  })
  void testNewHashMapAbstractState() {
    // Arrange and Act
    HashMapAbstractState<Object, ValueAbstractState> actualObjectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Assert
    assertTrue(actualObjectValueAbstractStateMap.isEmpty());
  }

  /**
   * Test {@link HashMapAbstractState#HashMapAbstractState(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link HashMapAbstractState#HashMapAbstractState(Map)}
   */
  @Test
  @DisplayName("Test new HashMapAbstractState(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HashMapAbstractState.<init>()",
    "void HashMapAbstractState.<init>(int)",
    "void HashMapAbstractState.<init>(Map)"
  })
  void testNewHashMapAbstractState_whenHashMap() {
    // Arrange and Act
    HashMapAbstractState<Object, ValueAbstractState> actualObjectValueAbstractStateMap =
        new HashMapAbstractState<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectValueAbstractStateMap.isEmpty());
  }

  /**
   * Test {@link HashMapAbstractState#HashMapAbstractState(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link HashMapAbstractState#HashMapAbstractState(int)}
   */
  @Test
  @DisplayName("Test new HashMapAbstractState(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HashMapAbstractState.<init>()",
    "void HashMapAbstractState.<init>(int)",
    "void HashMapAbstractState.<init>(Map)"
  })
  void testNewHashMapAbstractState_whenOne() {
    // Arrange and Act
    HashMapAbstractState<Object, ValueAbstractState> actualObjectValueAbstractStateMap =
        new HashMapAbstractState<>(1);

    // Assert
    assertTrue(actualObjectValueAbstractStateMap.isEmpty());
  }

  /**
   * Test {@link HashMapAbstractState#copy()}.
   *
   * <p>Method under test: {@link HashMapAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashMapAbstractState HashMapAbstractState.copy()"})
  void testCopy() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Act
    HashMapAbstractState<Object, ValueAbstractState> actualCopyResult =
        objectValueAbstractStateMap.copy();

    // Assert
    assertEquals(objectValueAbstractStateMap, actualCopyResult);
  }
}
