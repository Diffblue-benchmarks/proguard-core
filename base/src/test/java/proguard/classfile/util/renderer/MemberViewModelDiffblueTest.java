package proguard.classfile.util.renderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.util.renderer.MemberViewModel.Pair;

class MemberViewModelDiffblueTest {
  /**
   * Test Pair {@link Pair#Pair(Object, Object)}.
   *
   * <p>Method under test: {@link Pair#Pair(Object, Object)}
   */
  @Test
  @DisplayName("Test Pair new Pair(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pair.<init>(Object, Object)"})
  void testPairNewPair() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("Key", "Value");

    // Assert
    assertEquals("Key", actualPair.key);
    assertEquals("Value", actualPair.value);
  }
}
