package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SetAbstractStateDiffblueTest {
  /**
   * Test {@link SetAbstractState#SetAbstractState(Collection)}.
   *
   * <p>Method under test: {@link SetAbstractState#SetAbstractState(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SetAbstractState.<init>(Collection)"})
  public void testNewSetAbstractState() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SetAbstractState.<init>(Object[])"})
  public void testNewSetAbstractState2() {
    // Arrange and Act
    SetAbstractState<Object> actualObjectSet = new SetAbstractState<>("Items");

    // Assert
    assertEquals(1, actualObjectSet.size());
  }
}
