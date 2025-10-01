package proguard.dexfile.reader.node.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DvmFrameDiffblueTest {
  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Types} and {@code java.lang.Object[]}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @DisplayName(
      "Test descriptorLength(String[]); when array of String with 'Types' and 'java.lang.Object[]'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  void testDescriptorLength_whenArrayOfStringWithTypesAndJavaLangObject_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, DvmFrame.descriptorLength(new String[] {"Types", "java.lang.Object[]"}));
  }

  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Types}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @DisplayName(
      "Test descriptorLength(String[]); when array of String with 'Types'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  void testDescriptorLength_whenArrayOfStringWithTypes_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, DvmFrame.descriptorLength(new String[] {"Types"}));
  }

  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @DisplayName("Test descriptorLength(String[]); when empty array of String; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  void testDescriptorLength_whenEmptyArrayOfString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, DvmFrame.descriptorLength(new String[] {}));
  }
}
