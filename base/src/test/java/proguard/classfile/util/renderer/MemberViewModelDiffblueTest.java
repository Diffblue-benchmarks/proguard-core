package proguard.classfile.util.renderer;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.util.renderer.MemberViewModel.Pair;

public class MemberViewModelDiffblueTest {
  /**
   * Test Pair {@link Pair#Pair(Object, Object)}.
   *
   * <p>Method under test: {@link Pair#Pair(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Pair.<init>(Object, Object)"})
  public void testPairNewPair() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("Key", "Value");

    // Assert
    assertEquals("Key", actualPair.key);
    assertEquals("Value", actualPair.value);
  }
}
