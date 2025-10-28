package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StateTrackerDiffblueTest {
  /**
   * Method under test: {@link StateTracker#getLastCodeAttribute()}
   */
  @Test
  public void testGetLastCodeAttribute() {
    // Arrange, Act and Assert
    assertNull((new StateTracker()).getLastCodeAttribute());
  }

  /**
   * Method under test: {@link StateTracker#toJson()}
   */
  @Test
  public void testToJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new StateTracker()).toJson());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StateTracker}
   *   <li>{@link StateTracker#getCodeAttributes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new StateTracker()).getCodeAttributes().isEmpty());
  }
}
