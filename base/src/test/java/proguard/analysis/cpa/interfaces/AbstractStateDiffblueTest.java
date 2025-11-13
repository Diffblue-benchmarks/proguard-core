package proguard.analysis.cpa.interfaces;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;

class AbstractStateDiffblueTest {
  /**
   * Test {@link AbstractState#getPrecision()}.
   *
   * <p>Method under test: {@link AbstractState#getPrecision()}
   */
  @Test
  @DisplayName("Test getPrecision()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.analysis.cpa.interfaces.Precision AbstractState.getPrecision()"})
  void testGetPrecision() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        new HashMapAbstractState<>();

    // Act and Assert
    assertNull(objectValueAbstractStateMap.getPrecision());
  }
}
