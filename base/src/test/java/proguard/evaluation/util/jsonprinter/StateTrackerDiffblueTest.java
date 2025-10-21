package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StateTrackerDiffblueTest {
  /**
   * Test {@link StateTracker#getLastCodeAttribute()}.
   *
   * <p>Method under test: {@link StateTracker#getLastCodeAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.util.jsonprinter.CodeAttributeRecord StateTracker.getLastCodeAttribute()"
  })
  public void testGetLastCodeAttribute() {
    // Arrange, Act and Assert
    assertNull((new StateTracker()).getLastCodeAttribute());
  }

  /**
   * Test {@link StateTracker#toJson()}.
   *
   * <p>Method under test: {@link StateTracker#toJson()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String StateTracker.toJson()"})
  public void testToJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new StateTracker()).toJson());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StateTracker.<init>()",
    "java.util.List StateTracker.getCodeAttributes()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new StateTracker()).getCodeAttributes().isEmpty());
  }
}
