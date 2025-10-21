package proguard.classfile.util;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExternalTypeEnumerationDiffblueTest {
  /**
   * Test {@link ExternalTypeEnumeration#ExternalTypeEnumeration(String)}.
   *
   * <p>Method under test: {@link ExternalTypeEnumeration#ExternalTypeEnumeration(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExternalTypeEnumeration.<init>(String)"})
  public void testNewExternalTypeEnumeration() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExternalTypeEnumeration.setDescriptor(String)"})
  public void testSetDescriptor_givenExternalTypeEnumeration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new ExternalTypeEnumeration()).setDescriptor("Descriptor"));
  }
}
