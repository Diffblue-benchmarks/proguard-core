package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassSignatureDiffblueTest {
  /**
   * Test {@link ClassSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link ClassSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassSignature.isIncomplete()"})
  void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse(new ClassSignature("Class Name").isIncomplete());
  }

  /**
   * Test {@link ClassSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculateFqn()}
   */
  @Test
  @DisplayName("Test calculateFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ClassSignature.calculateFqn()"})
  void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").calculateFqn());
  }

  /**
   * Test {@link ClassSignature#calculatePrettyFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ClassSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").calculatePrettyFqn());
  }
}
