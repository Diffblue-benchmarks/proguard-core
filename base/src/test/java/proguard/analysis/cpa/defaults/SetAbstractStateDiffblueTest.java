package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class SetAbstractStateDiffblueTest {
  /**
   * Method under test: {@link SetAbstractState#SetAbstractState(Collection)}
   */
  @Test
  public void testNewSetAbstractState() {
    // Arrange and Act
    SetAbstractState<Object> actualObjectSet = new SetAbstractState<>(new ArrayList<>());

    // Assert
    assertTrue(actualObjectSet.isEmpty());
  }

  /**
   * Method under test: {@link SetAbstractState#SetAbstractState(Object[])}
   */
  @Test
  public void testNewSetAbstractState2() {
    // Arrange and Act
    SetAbstractState<Object> actualObjectSet = new SetAbstractState<>("Items");

    // Assert
    assertEquals(1, actualObjectSet.size());
  }
}
