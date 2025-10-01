package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StateTrackerDiffblueTest {
  /**
   * Test {@link StateTracker#getLastCodeAttribute()}.
   *
   * <p>Method under test: {@link StateTracker#getLastCodeAttribute()}
   */
  @Test
  @DisplayName("Test getLastCodeAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.evaluation.util.jsonprinter.CodeAttributeRecord StateTracker.getLastCodeAttribute()"
  })
  void testGetLastCodeAttribute() {
    // Arrange, Act and Assert
    assertNull(new StateTracker().getLastCodeAttribute());
  }

  /**
   * Test {@link StateTracker#toJson()}.
   *
   * <p>Method under test: {@link StateTracker#toJson()}
   */
  @Test
  @DisplayName("Test toJson()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String StateTracker.toJson()"})
  void testToJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", new StateTracker().toJson());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StateTracker}
   *   <li>{@link StateTracker#getCodeAttributes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StateTracker.<init>()",
    "java.util.List StateTracker.getCodeAttributes()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new StateTracker().getCodeAttributes().isEmpty());
  }
}
