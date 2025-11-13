package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExternalTypeEnumerationDiffblueTest {
  /**
   * Test {@link ExternalTypeEnumeration#ExternalTypeEnumeration(String)}.
   *
   * <p>Method under test: {@link ExternalTypeEnumeration#ExternalTypeEnumeration(String)}
   */
  @Test
  @DisplayName("Test new ExternalTypeEnumeration(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExternalTypeEnumeration.<init>(String)"})
  void testNewExternalTypeEnumeration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ExternalTypeEnumeration("Descriptor"));
  }

  /**
   * Test {@link ExternalTypeEnumeration#setDescriptor(String)}.
   *
   * <ul>
   *   <li>Given {@link ExternalTypeEnumeration#ExternalTypeEnumeration()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalTypeEnumeration#setDescriptor(String)}
   */
  @Test
  @DisplayName(
      "Test setDescriptor(String); given ExternalTypeEnumeration(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExternalTypeEnumeration.setDescriptor(String)"})
  void testSetDescriptor_givenExternalTypeEnumeration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ExternalTypeEnumeration().setDescriptor("Descriptor"));
  }
}
