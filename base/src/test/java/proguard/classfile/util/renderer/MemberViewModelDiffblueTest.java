package proguard.classfile.util.renderer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MemberViewModelDiffblueTest {
  /**
   * Method under test: {@link MemberViewModel.Pair#Pair(Object, Object)}
   */
  @Test
  public void testPairNewPair() {
    // Arrange and Act
    MemberViewModel.Pair<Object, Object> actualPair = new MemberViewModel.Pair<>("Key", "Value");

    // Assert
    assertEquals("Key", actualPair.key);
    assertEquals("Value", actualPair.value);
  }
}
