package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ParameterInfoDiffblueTest {
  /**
   * Test {@link ParameterInfo#ParameterInfo()}.
   *
   * <p>Method under test: {@link ParameterInfo#ParameterInfo()}
   */
  @Test
  @DisplayName("Test new ParameterInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ParameterInfo.<init>()",
    "void proguard.classfile.attribute.ParameterInfo.<init>(int, int)"
  })
  void testNewParameterInfo() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo();

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }

  /**
   * Test {@link ParameterInfo#ParameterInfo(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ParameterInfo#ParameterInfo(int, int)}
   */
  @Test
  @DisplayName("Test new ParameterInfo(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ParameterInfo.<init>()",
    "void proguard.classfile.attribute.ParameterInfo.<init>(int, int)"
  })
  void testNewParameterInfo_whenOne() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo(1, 1);

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }

  /**
   * Test {@link ParameterInfo#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterInfo#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.ParameterInfo.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    ParameterInfo parameterInfo = new ParameterInfo(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = parameterInfo.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }
}
