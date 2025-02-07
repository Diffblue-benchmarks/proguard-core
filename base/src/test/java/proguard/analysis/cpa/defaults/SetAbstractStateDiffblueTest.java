package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetAbstractStateDiffblueTest {
  /**
   * Test {@link SetAbstractState#SetAbstractState(Collection)}.
   *
   * <p>Method under test: {@link SetAbstractState#SetAbstractState(Collection)}
   */
  @Test
  @DisplayName("Test new SetAbstractState(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.SetAbstractState.<init>(java.util.Collection)"
  })
  void testNewSetAbstractState() {
    // Arrange and Act
    SetAbstractState<Object> actualObjectSet = new SetAbstractState<>(new ArrayList<>());

    // Assert
    assertTrue(actualObjectSet.isEmpty());
  }

  /**
   * Test {@link SetAbstractState#SetAbstractState(Object[])}.
   *
   * <p>Method under test: {@link SetAbstractState#SetAbstractState(Object[])}
   */
  @Test
  @DisplayName("Test new SetAbstractState(Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.SetAbstractState.<init>(java.lang.Object[])"
  })
  void testNewSetAbstractState2() {
    // Arrange and Act
    SetAbstractState<Object> actualObjectSet = new SetAbstractState<>("Items");

    // Assert
    assertEquals(1, actualObjectSet.size());
  }
}
