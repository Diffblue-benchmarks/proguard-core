package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ClassUtilDiffblueTest {
  /**
   * Test {@link ClassUtil#checkMagicNumber(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#checkMagicNumber(int)}
   */
  @Test
  @DisplayName("Test checkMagicNumber(int); when ten; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.util.ClassUtil.checkMagicNumber(int)"})
  void testCheckMagicNumber_whenTen_thenThrowUnsupportedOperationException()
      throws UnsupportedOperationException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkMagicNumber(10));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 5}.
   *   <li>Then return {@code 3211264}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '5'; then return '3211264'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when5_thenReturn3211264() {
    // Arrange, Act and Assert
    assertEquals(3211264, ClassUtil.internalClassVersion("5"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 6}.
   *   <li>Then return {@code 3276800}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '6'; then return '3276800'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when6_thenReturn3276800() {
    // Arrange, Act and Assert
    assertEquals(3276800, ClassUtil.internalClassVersion("6"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 7}.
   *   <li>Then return {@code 3342336}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '7'; then return '3342336'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when7_thenReturn3342336() {
    // Arrange, Act and Assert
    assertEquals(3342336, ClassUtil.internalClassVersion("7"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 8}.
   *   <li>Then return {@code 3407872}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '8'; then return '3407872'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when8_thenReturn3407872() {
    // Arrange, Act and Assert
    assertEquals(3407872, ClassUtil.internalClassVersion("8"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 9}.
   *   <li>Then return {@code 3473408}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '9'; then return '3473408'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when9_thenReturn3473408() {
    // Arrange, Act and Assert
    assertEquals(3473408, ClassUtil.internalClassVersion("9"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.0}.
   *   <li>Then return {@code 2949123}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.0'; then return '2949123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when10_thenReturn2949123() {
    // Arrange, Act and Assert
    assertEquals(2949123, ClassUtil.internalClassVersion("1.0"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 10}.
   *   <li>Then return {@code 3538944}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '10'; then return '3538944'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when10_thenReturn3538944() {
    // Arrange, Act and Assert
    assertEquals(3538944, ClassUtil.internalClassVersion("10"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.1}.
   *   <li>Then return {@code 2949123}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.1'; then return '2949123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when11_thenReturn2949123() {
    // Arrange, Act and Assert
    assertEquals(2949123, ClassUtil.internalClassVersion("1.1"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 11}.
   *   <li>Then return {@code 3604480}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '11'; then return '3604480'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when11_thenReturn3604480() {
    // Arrange, Act and Assert
    assertEquals(3604480, ClassUtil.internalClassVersion("11"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.2}.
   *   <li>Then return {@code 3014656}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.2'; then return '3014656'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when12_thenReturn3014656() {
    // Arrange, Act and Assert
    assertEquals(3014656, ClassUtil.internalClassVersion("1.2"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 12}.
   *   <li>Then return {@code 3670016}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '12'; then return '3670016'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when12_thenReturn3670016() {
    // Arrange, Act and Assert
    assertEquals(3670016, ClassUtil.internalClassVersion("12"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.3}.
   *   <li>Then return {@code 3080192}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.3'; then return '3080192'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when13_thenReturn3080192() {
    // Arrange, Act and Assert
    assertEquals(3080192, ClassUtil.internalClassVersion("1.3"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 13}.
   *   <li>Then return {@code 3735552}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '13'; then return '3735552'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when13_thenReturn3735552() {
    // Arrange, Act and Assert
    assertEquals(3735552, ClassUtil.internalClassVersion("13"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.4}.
   *   <li>Then return {@code 3145728}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.4'; then return '3145728'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when14_thenReturn3145728() {
    // Arrange, Act and Assert
    assertEquals(3145728, ClassUtil.internalClassVersion("1.4"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 14}.
   *   <li>Then return {@code 3801088}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '14'; then return '3801088'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when14_thenReturn3801088() {
    // Arrange, Act and Assert
    assertEquals(3801088, ClassUtil.internalClassVersion("14"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.5}.
   *   <li>Then return {@code 3211264}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.5'; then return '3211264'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when15_thenReturn3211264() {
    // Arrange, Act and Assert
    assertEquals(3211264, ClassUtil.internalClassVersion("1.5"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 15}.
   *   <li>Then return {@code 3866624}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '15'; then return '3866624'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when15_thenReturn3866624() {
    // Arrange, Act and Assert
    assertEquals(3866624, ClassUtil.internalClassVersion("15"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.6}.
   *   <li>Then return {@code 3276800}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.6'; then return '3276800'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when16_thenReturn3276800() {
    // Arrange, Act and Assert
    assertEquals(3276800, ClassUtil.internalClassVersion("1.6"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 16}.
   *   <li>Then return {@code 3932160}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '16'; then return '3932160'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when16_thenReturn3932160() {
    // Arrange, Act and Assert
    assertEquals(3932160, ClassUtil.internalClassVersion("16"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.7}.
   *   <li>Then return {@code 3342336}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.7'; then return '3342336'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when17_thenReturn3342336() {
    // Arrange, Act and Assert
    assertEquals(3342336, ClassUtil.internalClassVersion("1.7"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 17}.
   *   <li>Then return {@code 3997696}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '17'; then return '3997696'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when17_thenReturn3997696() {
    // Arrange, Act and Assert
    assertEquals(3997696, ClassUtil.internalClassVersion("17"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.8}.
   *   <li>Then return {@code 3407872}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.8'; then return '3407872'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when18_thenReturn3407872() {
    // Arrange, Act and Assert
    assertEquals(3407872, ClassUtil.internalClassVersion("1.8"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 18}.
   *   <li>Then return {@code 4063232}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '18'; then return '4063232'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when18_thenReturn4063232() {
    // Arrange, Act and Assert
    assertEquals(4063232, ClassUtil.internalClassVersion("18"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.9}.
   *   <li>Then return {@code 3473408}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.9'; then return '3473408'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when19_thenReturn3473408() {
    // Arrange, Act and Assert
    assertEquals(3473408, ClassUtil.internalClassVersion("1.9"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 19}.
   *   <li>Then return {@code 4128768}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '19'; then return '4128768'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when19_thenReturn4128768() {
    // Arrange, Act and Assert
    assertEquals(4128768, ClassUtil.internalClassVersion("19"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 20}.
   *   <li>Then return {@code 4194304}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '20'; then return '4194304'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when20_thenReturn4194304() {
    // Arrange, Act and Assert
    assertEquals(4194304, ClassUtil.internalClassVersion("20"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 21}.
   *   <li>Then return {@code 4259840}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '21'; then return '4259840'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when21_thenReturn4259840() {
    // Arrange, Act and Assert
    assertEquals(4259840, ClassUtil.internalClassVersion("21"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 22}.
   *   <li>Then return {@code 4325376}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '22'; then return '4325376'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when22_thenReturn4325376() {
    // Arrange, Act and Assert
    assertEquals(4325376, ClassUtil.internalClassVersion("22"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 23}.
   *   <li>Then return {@code 4390912}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '23'; then return '4390912'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when23_thenReturn4390912() {
    // Arrange, Act and Assert
    assertEquals(4390912, ClassUtil.internalClassVersion("23"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(String)} with {@code externalClassVersion}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(String) with 'externalClassVersion'; when '1.0.2'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalClassVersion(java.lang.String)"
  })
  void testInternalClassVersionWithExternalClassVersion_when102_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalClassVersion("1.0.2"));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(int, int)} with {@code majorVersion}, {@code
   * minorVersion}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 65537}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(int, int)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(int, int) with 'majorVersion', 'minorVersion'; when one; then return '65537'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalClassVersion(int, int)"})
  void testInternalClassVersionWithMajorVersionMinorVersion_whenOne_thenReturn65537() {
    // Arrange, Act and Assert
    assertEquals(65537, ClassUtil.internalClassVersion(1, 1));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(int, int)} with {@code majorVersion}, {@code
   * minorVersion}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 1048577}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(int, int)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(int, int) with 'majorVersion', 'minorVersion'; when SIZE; then return '1048577'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalClassVersion(int, int)"})
  void testInternalClassVersionWithMajorVersionMinorVersion_whenSize_thenReturn1048577() {
    // Arrange, Act and Assert
    assertEquals(1048577, ClassUtil.internalClassVersion(Short.SIZE, 1));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(int, int)} with {@code majorVersion}, {@code
   * minorVersion}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 196609}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(int, int)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(int, int) with 'majorVersion', 'minorVersion'; when three; then return '196609'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalClassVersion(int, int)"})
  void testInternalClassVersionWithMajorVersionMinorVersion_whenThree_thenReturn196609() {
    // Arrange, Act and Assert
    assertEquals(196609, ClassUtil.internalClassVersion(3, 1));
  }

  /**
   * Test {@link ClassUtil#internalClassVersion(int, int)} with {@code majorVersion}, {@code
   * minorVersion}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassVersion(int, int)}
   */
  @Test
  @DisplayName(
      "Test internalClassVersion(int, int) with 'majorVersion', 'minorVersion'; when zero; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalClassVersion(int, int)"})
  void testInternalClassVersionWithMajorVersionMinorVersion_whenZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalClassVersion(0, 1));
  }

  /**
   * Test {@link ClassUtil#internalMajorClassVersion(int)}.
   *
   * <p>Method under test: {@link ClassUtil#internalMajorClassVersion(int)}
   */
  @Test
  @DisplayName("Test internalMajorClassVersion(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalMajorClassVersion(int)"})
  void testInternalMajorClassVersion() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalMajorClassVersion(1));
  }

  /**
   * Test {@link ClassUtil#internalMinorClassVersion(int)}.
   *
   * <p>Method under test: {@link ClassUtil#internalMinorClassVersion(int)}
   */
  @Test
  @DisplayName("Test internalMinorClassVersion(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalMinorClassVersion(int)"})
  void testInternalMinorClassVersion() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMinorClassVersion(1));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 2949123}.
   *   <li>Then return {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '2949123'; then return '1.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when2949123_thenReturn10() {
    // Arrange, Act and Assert
    assertEquals("1.0", ClassUtil.externalClassVersion(2949123));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3014656}.
   *   <li>Then return {@code 1.2}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3014656'; then return '1.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3014656_thenReturn12() {
    // Arrange, Act and Assert
    assertEquals("1.2", ClassUtil.externalClassVersion(3014656));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3080192}.
   *   <li>Then return {@code 1.3}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3080192'; then return '1.3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3080192_thenReturn13() {
    // Arrange, Act and Assert
    assertEquals("1.3", ClassUtil.externalClassVersion(3080192));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3145728}.
   *   <li>Then return {@code 1.4}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3145728'; then return '1.4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3145728_thenReturn14() {
    // Arrange, Act and Assert
    assertEquals("1.4", ClassUtil.externalClassVersion(3145728));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3211264}.
   *   <li>Then return {@code 1.5}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3211264'; then return '1.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3211264_thenReturn15() {
    // Arrange, Act and Assert
    assertEquals("1.5", ClassUtil.externalClassVersion(3211264));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3276800}.
   *   <li>Then return {@code 1.6}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3276800'; then return '1.6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3276800_thenReturn16() {
    // Arrange, Act and Assert
    assertEquals("1.6", ClassUtil.externalClassVersion(3276800));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3342336}.
   *   <li>Then return {@code 1.7}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3342336'; then return '1.7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3342336_thenReturn17() {
    // Arrange, Act and Assert
    assertEquals("1.7", ClassUtil.externalClassVersion(3342336));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3407872}.
   *   <li>Then return {@code 1.8}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3407872'; then return '1.8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3407872_thenReturn18() {
    // Arrange, Act and Assert
    assertEquals("1.8", ClassUtil.externalClassVersion(3407872));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3473408}.
   *   <li>Then return {@code 1.9}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3473408'; then return '1.9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3473408_thenReturn19() {
    // Arrange, Act and Assert
    assertEquals("1.9", ClassUtil.externalClassVersion(3473408));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3538944}.
   *   <li>Then return {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3538944'; then return '10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3538944_thenReturn10() {
    // Arrange, Act and Assert
    assertEquals("10", ClassUtil.externalClassVersion(3538944));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3604480}.
   *   <li>Then return {@code 11}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3604480'; then return '11'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3604480_thenReturn11() {
    // Arrange, Act and Assert
    assertEquals("11", ClassUtil.externalClassVersion(3604480));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3670016}.
   *   <li>Then return {@code 12}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3670016'; then return '12'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3670016_thenReturn12() {
    // Arrange, Act and Assert
    assertEquals("12", ClassUtil.externalClassVersion(3670016));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3735552}.
   *   <li>Then return {@code 13}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3735552'; then return '13'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3735552_thenReturn13() {
    // Arrange, Act and Assert
    assertEquals("13", ClassUtil.externalClassVersion(3735552));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3801088}.
   *   <li>Then return {@code 14}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3801088'; then return '14'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3801088_thenReturn14() {
    // Arrange, Act and Assert
    assertEquals("14", ClassUtil.externalClassVersion(3801088));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3866624}.
   *   <li>Then return {@code 15}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3866624'; then return '15'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3866624_thenReturn15() {
    // Arrange, Act and Assert
    assertEquals("15", ClassUtil.externalClassVersion(3866624));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3932160}.
   *   <li>Then return {@code 16}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3932160'; then return '16'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3932160_thenReturn16() {
    // Arrange, Act and Assert
    assertEquals("16", ClassUtil.externalClassVersion(3932160));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 3997696}.
   *   <li>Then return {@code 17}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '3997696'; then return '17'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when3997696_thenReturn17() {
    // Arrange, Act and Assert
    assertEquals("17", ClassUtil.externalClassVersion(3997696));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4063232}.
   *   <li>Then return {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4063232'; then return '18'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4063232_thenReturn18() {
    // Arrange, Act and Assert
    assertEquals("18", ClassUtil.externalClassVersion(4063232));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4128768}.
   *   <li>Then return {@code 19}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4128768'; then return '19'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4128768_thenReturn19() {
    // Arrange, Act and Assert
    assertEquals("19", ClassUtil.externalClassVersion(4128768));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4194304}.
   *   <li>Then return {@code 20}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4194304'; then return '20'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4194304_thenReturn20() {
    // Arrange, Act and Assert
    assertEquals("20", ClassUtil.externalClassVersion(4194304));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4259840}.
   *   <li>Then return {@code 21}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4259840'; then return '21'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4259840_thenReturn21() {
    // Arrange, Act and Assert
    assertEquals("21", ClassUtil.externalClassVersion(4259840));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4325376}.
   *   <li>Then return {@code 22}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4325376'; then return '22'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4325376_thenReturn22() {
    // Arrange, Act and Assert
    assertEquals("22", ClassUtil.externalClassVersion(4325376));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When {@code 4390912}.
   *   <li>Then return {@code 23}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when '4390912'; then return '23'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_when4390912_thenReturn23() {
    // Arrange, Act and Assert
    assertEquals("23", ClassUtil.externalClassVersion(4390912));
  }

  /**
   * Test {@link ClassUtil#externalClassVersion(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  @DisplayName("Test externalClassVersion(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassVersion(int)"
  })
  void testExternalClassVersion_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ClassUtil.externalClassVersion(1));
  }

  /**
   * Test {@link ClassUtil#checkVersionNumbers(int)}.
   *
   * <ul>
   *   <li>When {@code 4456448}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#checkVersionNumbers(int)}
   */
  @Test
  @DisplayName(
      "Test checkVersionNumbers(int); when '4456448'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.util.ClassUtil.checkVersionNumbers(int)"})
  void testCheckVersionNumbers_when4456448_thenThrowUnsupportedOperationException()
      throws UnsupportedOperationException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkVersionNumbers(4456448));
  }

  /**
   * Test {@link ClassUtil#checkVersionNumbers(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#checkVersionNumbers(int)}
   */
  @Test
  @DisplayName("Test checkVersionNumbers(int); when one; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.util.ClassUtil.checkVersionNumbers(int)"})
  void testCheckVersionNumbers_whenOne_thenThrowUnsupportedOperationException()
      throws UnsupportedOperationException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkVersionNumbers(1));
  }

  /**
   * Test {@link ClassUtil#internalClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalClassName(String)}
   */
  @Test
  @DisplayName("Test internalClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassName(java.lang.String)"
  })
  void testInternalClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.internalClassName("External Class Name"));
  }

  /**
   * Test {@link ClassUtil#canonicalClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#canonicalClassName(String)}
   */
  @Test
  @DisplayName("Test canonicalClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.canonicalClassName(java.lang.String)"
  })
  void testCanonicalClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.canonicalClassName("External Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName("Test externalFullClassDescription(int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription() {
    // Arrange, Act and Assert
    assertEquals(
        "private protected static final @interface Internal Class Name",
        ClassUtil.externalFullClassDescription(-889275714, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>Then return {@code private final Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); then return 'private final Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_thenReturnPrivateFinalInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "private final Internal Class Name",
        ClassUtil.externalFullClassDescription(50, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When {@code 1024}.
   *   <li>Then return {@code abstract Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when '1024'; then return 'abstract Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_when1024_thenReturnAbstractInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "abstract Internal Class Name",
        ClassUtil.externalFullClassDescription(1024, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when '4096'; then return 'synthetic Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_when4096_thenReturnSyntheticInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "synthetic Internal Class Name",
        ClassUtil.externalFullClassDescription(4096, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When {@code 16384}.
   *   <li>Then return {@code enum Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when '16384'; then return 'enum Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_when16384_thenReturnEnumInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "enum Internal Class Name",
        ClassUtil.externalFullClassDescription(16384, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code module Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when '32768'; then return 'module Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_when32768_thenReturnModuleInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "module Internal Class Name",
        ClassUtil.externalFullClassDescription(32768, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code static Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when eight; then return 'static Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_whenEight_thenReturnStaticInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "static Internal Class Name",
        ClassUtil.externalFullClassDescription(8, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code protected Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when four; then return 'protected Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_whenFour_thenReturnProtectedInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "protected Internal Class Name",
        ClassUtil.externalFullClassDescription(4, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code public Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when one; then return 'public Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_whenOne_thenReturnPublicInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "public Internal Class Name",
        ClassUtil.externalFullClassDescription(1, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalFullClassDescription(int, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code Internal Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullClassDescription(int, String); when zero; then return 'Internal Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullClassDescription(int, java.lang.String)"
  })
  void testExternalFullClassDescription_whenZero_thenReturnInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "Internal Class Name", ClassUtil.externalFullClassDescription(0, "Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#externalClassName(String)}
   */
  @Test
  @DisplayName("Test externalClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassName(java.lang.String)"
  })
  void testExternalClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.externalClassName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalBaseType(String)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalBaseType(String)}
   */
  @Test
  @DisplayName("Test externalBaseType(String); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalBaseType(java.lang.String)"
  })
  void testExternalBaseType_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalBaseType("[]"));
  }

  /**
   * Test {@link ClassUtil#externalBaseType(String)}.
   *
   * <ul>
   *   <li>When {@code External Array Type}.
   *   <li>Then return {@code External Array Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalBaseType(String)}
   */
  @Test
  @DisplayName(
      "Test externalBaseType(String); when 'External Array Type'; then return 'External Array Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalBaseType(java.lang.String)"
  })
  void testExternalBaseType_whenExternalArrayType_thenReturnExternalArrayType() {
    // Arrange, Act and Assert
    assertEquals("External Array Type", ClassUtil.externalBaseType("External Array Type"));
  }

  /**
   * Test {@link ClassUtil#externalShortClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#externalShortClassName(String)}
   */
  @Test
  @DisplayName("Test externalShortClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalShortClassName(java.lang.String)"
  })
  void testExternalShortClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.externalShortClassName("External Class Name"));
  }

  /**
   * Test {@link ClassUtil#internalShortClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalShortClassName(String)}
   */
  @Test
  @DisplayName("Test internalShortClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalShortClassName(java.lang.String)"
  })
  void testInternalShortClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.internalShortClassName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayType(String)}
   */
  @Test
  @DisplayName("Test isInternalArrayType(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayType(java.lang.String)"
  })
  void testIsInternalArrayType_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalArrayType(""));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayType(String)}
   */
  @Test
  @DisplayName("Test isInternalArrayType(String); when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayType(java.lang.String)"
  })
  void testIsInternalArrayType_whenInternalType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalArrayType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#internalArrayTypeDimensionCount(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalArrayTypeDimensionCount(String)}
   */
  @Test
  @DisplayName("Test internalArrayTypeDimensionCount(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalArrayTypeDimensionCount(java.lang.String)"
  })
  void testInternalArrayTypeDimensionCount_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalArrayTypeDimensionCount(""));
  }

  /**
   * Test {@link ClassUtil#internalArrayTypeDimensionCount(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalArrayTypeDimensionCount(String)}
   */
  @Test
  @DisplayName("Test internalArrayTypeDimensionCount(String); when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalArrayTypeDimensionCount(java.lang.String)"
  })
  void testInternalArrayTypeDimensionCount_whenInternalType() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalArrayTypeDimensionCount("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayInterfaceName(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Class Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayInterfaceName(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalArrayInterfaceName(String); when 'Internal Class Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayInterfaceName(java.lang.String)"
  })
  void testIsInternalArrayInterfaceName_whenInternalClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalArrayInterfaceName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayInterfaceName(String)}.
   *
   * <ul>
   *   <li>When {@code java/io/Serializable}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayInterfaceName(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalArrayInterfaceName(String); when 'java/io/Serializable'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayInterfaceName(java.lang.String)"
  })
  void testIsInternalArrayInterfaceName_whenJavaIoSerializable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/io/Serializable"));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayInterfaceName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Cloneable}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayInterfaceName(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalArrayInterfaceName(String); when 'java/lang/Cloneable'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayInterfaceName(java.lang.String)"
  })
  void testIsInternalArrayInterfaceName_whenJavaLangCloneable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/lang/Cloneable"));
  }

  /**
   * Test {@link ClassUtil#isInternalArrayInterfaceName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalArrayInterfaceName(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalArrayInterfaceName(String); when 'java/lang/Object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalArrayInterfaceName(java.lang.String)"
  })
  void testIsInternalArrayInterfaceName_whenJavaLangObject_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/lang/Object"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveType('A'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'B'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenB_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('B'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'C'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenC_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('C'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'D'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenD_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('D'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'F'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenF_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('F'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'I'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenI_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('I'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'J'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenJ_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('J'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'S'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenS_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('S'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(char)} with {@code char}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(char) with 'char'; when 'Z'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(char)"})
  void testIsInternalPrimitiveTypeWithChar_whenZ_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType('Z'));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(String)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveType(String) with 'String'; when '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(java.lang.String)"
  })
  void testIsInternalPrimitiveTypeWithString_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveType("42"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveType(String) with 'String'; when 'Internal Type'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveType(java.lang.String)"
  })
  void testIsInternalPrimitiveTypeWithString_whenInternalType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Internal Type'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenInternalType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveBoxingType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Boolean;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Boolean;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangBoolean_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Boolean;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Byte;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Byte;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Byte;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Character;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Character;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangCharacter_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Character;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Double;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Double;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangDouble_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Double;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Float;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Float;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangFloat_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Float;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Integer;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Integer;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangInteger_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Integer;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Long;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Long;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangLong_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Long;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Short;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveBoxingType(String); when 'Ljava/lang/Short;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveBoxingType(java.lang.String)"
  })
  void testIsInternalPrimitiveBoxingType_whenLjavaLangShort_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Short;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeFromPrimitiveBoxingType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Type"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>Then return {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeFromPrimitiveBoxingType(String); then return 'C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_thenReturnC() {
    // Arrange, Act and Assert
    assertEquals(
        'C', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Character;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeFromPrimitiveBoxingType(String); then return 'I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals(
        'I', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Integer;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>Then return {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeFromPrimitiveBoxingType(String); then return 'Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals(
        'Z', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Boolean;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Byte;}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromPrimitiveBoxingType(String); when 'Ljava/lang/Byte;'; then return 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_whenLjavaLangByte_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals('B', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Byte;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Double;}.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromPrimitiveBoxingType(String); when 'Ljava/lang/Double;'; then return 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_whenLjavaLangDouble_thenReturnD() {
    // Arrange, Act and Assert
    assertEquals('D', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Double;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Float;}.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromPrimitiveBoxingType(String); when 'Ljava/lang/Float;'; then return 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_whenLjavaLangFloat_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals('F', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Float;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Long;}.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromPrimitiveBoxingType(String); when 'Ljava/lang/Long;'; then return 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_whenLjavaLangLong_thenReturnJ() {
    // Arrange, Act and Assert
    assertEquals('J', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Long;"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Short;}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromPrimitiveBoxingType(String); when 'Ljava/lang/Short;'; then return 'S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromPrimitiveBoxingType_whenLjavaLangShort_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Short;"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}
   */
  @Test
  @DisplayName("Test isInternalPrimitiveTypeOrString(String); when '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveTypeOrString(java.lang.String)"
  })
  void testIsInternalPrimitiveTypeOrString_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveTypeOrString("42"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveTypeOrString(String); when 'Internal Type'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveTypeOrString(java.lang.String)"
  })
  void testIsInternalPrimitiveTypeOrString_whenInternalType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveTypeOrString("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/String;}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalPrimitiveTypeOrString(String); when 'Ljava/lang/String;'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalPrimitiveTypeOrString(java.lang.String)"
  })
  void testIsInternalPrimitiveTypeOrString_whenLjavaLangString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveTypeOrString("Ljava/lang/String;"));
  }

  /**
   * Test {@link ClassUtil#isInternalCategory2Type(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalCategory2Type(String)}
   */
  @Test
  @DisplayName("Test isInternalCategory2Type(String); when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalCategory2Type(java.lang.String)"
  })
  void testIsInternalCategory2Type_whenInternalType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalCategory2Type("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalCategory2Type(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalCategory2Type(String)}
   */
  @Test
  @DisplayName("Test isInternalCategory2Type(String); when '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalCategory2Type(java.lang.String)"
  })
  void testIsInternalCategory2Type_whenPercentSign() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalCategory2Type("%"));
  }

  /**
   * Test {@link ClassUtil#isInternalClassType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalClassType(String)}
   */
  @Test
  @DisplayName("Test isInternalClassType(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalClassType(java.lang.String)"
  })
  void testIsInternalClassType_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalClassType(""));
  }

  /**
   * Test {@link ClassUtil#isInternalClassType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalClassType(String)}
   */
  @Test
  @DisplayName("Test isInternalClassType(String); when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalClassType(java.lang.String)"
  })
  void testIsInternalClassType_whenInternalType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalClassType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalType(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalType(String)}
   */
  @Test
  @DisplayName("Test isInternalType(String); when '%'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalType(java.lang.String)"})
  void testIsInternalType_whenPercentSign_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalType("%"));
  }

  /**
   * Test {@link ClassUtil#isInternalType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalType(String)}
   */
  @Test
  @DisplayName("Test isInternalType(String); when 'Type'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInternalType(java.lang.String)"})
  void testIsInternalType_whenType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalType("Type"));
  }

  /**
   * Test {@link ClassUtil#internalTypeFromClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalTypeFromClassName(String)}
   */
  @Test
  @DisplayName("Test internalTypeFromClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalTypeFromClassName(java.lang.String)"
  })
  void testInternalTypeFromClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "LInternal Class Name;", ClassUtil.internalTypeFromClassName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#internalArrayTypeFromClassName(String, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code [[[LInternal Class Name;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalArrayTypeFromClassName(String, int)}
   */
  @Test
  @DisplayName(
      "Test internalArrayTypeFromClassName(String, int); when three; then return '[[[LInternal Class Name;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalArrayTypeFromClassName(java.lang.String, int)"
  })
  void testInternalArrayTypeFromClassName_whenThree_thenReturnLInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "[[[LInternal Class Name;",
        ClassUtil.internalArrayTypeFromClassName("Internal Class Name", 3));
  }

  /**
   * Test {@link ClassUtil#internalArrayTypeFromType(String, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code [[Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalArrayTypeFromType(String, int)}
   */
  @Test
  @DisplayName(
      "Test internalArrayTypeFromType(String, int); when two; then return '[[Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalArrayTypeFromType(java.lang.String, int)"
  })
  void testInternalArrayTypeFromType_whenTwo_thenReturnInternalType() {
    // Arrange, Act and Assert
    assertEquals("[[Internal Type", ClassUtil.internalArrayTypeFromType("Internal Type", 2));
  }

  /**
   * Test {@link ClassUtil#internalTypeFromArrayType(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalTypeFromArrayType(String)}
   */
  @Test
  @DisplayName("Test internalTypeFromArrayType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalTypeFromArrayType(java.lang.String)"
  })
  void testInternalTypeFromArrayType() {
    // Arrange, Act and Assert
    assertEquals("Internal Array Type", ClassUtil.internalTypeFromArrayType("Internal Array Type"));
  }

  /**
   * Test {@link ClassUtil#internalClassTypeFromType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassTypeFromType(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassTypeFromType(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassTypeFromType(java.lang.String)"
  })
  void testInternalClassTypeFromType_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalClassTypeFromType(""));
  }

  /**
   * Test {@link ClassUtil#internalClassTypeFromType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassTypeFromType(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassTypeFromType(String); when 'Internal Type'; then return 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassTypeFromType(java.lang.String)"
  })
  void testInternalClassTypeFromType_whenInternalType_thenReturnInternalType() {
    // Arrange, Act and Assert
    assertEquals("Internal Type", ClassUtil.internalClassTypeFromType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#internalTypeFromClassType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code L;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalTypeFromClassType(String)}
   */
  @Test
  @DisplayName("Test internalTypeFromClassType(String); when empty string; then return 'L;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalTypeFromClassType(java.lang.String)"
  })
  void testInternalTypeFromClassType_whenEmptyString_thenReturnL() {
    // Arrange, Act and Assert
    assertEquals("L;", ClassUtil.internalTypeFromClassType(""));
  }

  /**
   * Test {@link ClassUtil#internalTypeFromClassType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code LInternal Type;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalTypeFromClassType(String)}
   */
  @Test
  @DisplayName(
      "Test internalTypeFromClassType(String); when 'Internal Type'; then return 'LInternal Type;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalTypeFromClassType(java.lang.String)"
  })
  void testInternalTypeFromClassType_whenInternalType_thenReturnLInternalType() {
    // Arrange, Act and Assert
    assertEquals("LInternal Type;", ClassUtil.internalTypeFromClassType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromClassType(String)}.
   *
   * <ul>
   *   <li>Then return {@code Internal Class Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromClassType(String)}
   */
  @Test
  @DisplayName("Test internalClassNameFromClassType(String); then return 'Internal Class Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromClassType(java.lang.String)"
  })
  void testInternalClassNameFromClassType_thenReturnInternalClassType() {
    // Arrange, Act and Assert
    assertEquals(
        "Internal Class Type", ClassUtil.internalClassNameFromClassType("Internal Class Type"));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromClassType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromClassType(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassNameFromClassType(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromClassType(java.lang.String)"
  })
  void testInternalClassNameFromClassType_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalClassNameFromClassType(""));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromClassSignature(String)}.
   *
   * <ul>
   *   <li>Then return {@code Class Signature}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromClassSignature(String)}
   */
  @Test
  @DisplayName("Test internalClassNameFromClassSignature(String); then return 'Class Signature'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromClassSignature(java.lang.String)"
  })
  void testInternalClassNameFromClassSignature_thenReturnClassSignature() {
    // Arrange, Act and Assert
    assertEquals(
        "Class Signature", ClassUtil.internalClassNameFromClassSignature("Class Signature"));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromClassSignature(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromClassSignature(String)}
   */
  @Test
  @DisplayName(
      "Test internalClassNameFromClassSignature(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromClassSignature(java.lang.String)"
  })
  void testInternalClassNameFromClassSignature_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalClassNameFromClassSignature(""));
  }

  /**
   * Test {@link ClassUtil#removeGenericTypes(String)}.
   *
   * <p>Method under test: {@link ClassUtil#removeGenericTypes(String)}
   */
  @Test
  @DisplayName("Test removeGenericTypes(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.removeGenericTypes(java.lang.String)"
  })
  void testRemoveGenericTypes() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassUtil.removeGenericTypes("Descriptor"));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromType(String)}
   */
  @Test
  @DisplayName("Test internalClassNameFromType(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromType(java.lang.String)"
  })
  void testInternalClassNameFromType_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(ClassUtil.internalClassNameFromType(""));
  }

  /**
   * Test {@link ClassUtil#internalClassNameFromType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Class Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalClassNameFromType(String)}
   */
  @Test
  @DisplayName("Test internalClassNameFromType(String); when 'Internal Class Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalClassNameFromType(java.lang.String)"
  })
  void testInternalClassNameFromType_whenInternalClassType() {
    // Arrange, Act and Assert
    assertNull(ClassUtil.internalClassNameFromType("Internal Class Type"));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>Then return {@code java/lang/reflect/Array}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); then return 'java/lang/reflect/Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_thenReturnJavaLangReflectArray() {
    // Arrange, Act and Assert
    assertEquals(
        "java/lang/reflect/Array", ClassUtil.internalNumericClassNameFromPrimitiveType('['));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.internalNumericClassNameFromPrimitiveType('A'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return {@code java/lang/Byte}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'B'; then return 'java/lang/Byte'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenB_thenReturnJavaLangByte() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Byte", ClassUtil.internalNumericClassNameFromPrimitiveType('B'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return {@code java/lang/Character}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'C'; then return 'java/lang/Character'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenC_thenReturnJavaLangCharacter() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Character", ClassUtil.internalNumericClassNameFromPrimitiveType('C'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return {@code java/lang/Double}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'D'; then return 'java/lang/Double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenD_thenReturnJavaLangDouble() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Double", ClassUtil.internalNumericClassNameFromPrimitiveType('D'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return {@code java/lang/Float}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'F'; then return 'java/lang/Float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenF_thenReturnJavaLangFloat() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Float", ClassUtil.internalNumericClassNameFromPrimitiveType('F'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return {@code java/lang/Integer}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'I'; then return 'java/lang/Integer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenI_thenReturnJavaLangInteger() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Integer", ClassUtil.internalNumericClassNameFromPrimitiveType('I'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return {@code java/lang/Long}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'J'; then return 'java/lang/Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenJ_thenReturnJavaLangLong() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Long", ClassUtil.internalNumericClassNameFromPrimitiveType('J'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then return {@code java/lang/Short}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'S'; then return 'java/lang/Short'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenS_thenReturnJavaLangShort() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Short", ClassUtil.internalNumericClassNameFromPrimitiveType('S'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code V}.
   *   <li>Then return {@code java/lang/Void}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'V'; then return 'java/lang/Void'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenV_thenReturnJavaLangVoid() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Void", ClassUtil.internalNumericClassNameFromPrimitiveType('V'));
  }

  /**
   * Test {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return {@code java/lang/Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test internalNumericClassNameFromPrimitiveType(char); when 'Z'; then return 'java/lang/Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalNumericClassNameFromPrimitiveType(char)"
  })
  void testInternalNumericClassNameFromPrimitiveType_whenZ_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Boolean", ClassUtil.internalNumericClassNameFromPrimitiveType('Z'));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>Then return {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeFromNumericClassName(String); then return '['")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_thenReturnLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals(
        '[', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/reflect/Array"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.internalPrimitiveTypeFromNumericClassName("Internal Primitive Class Name"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Boolean}.
   *   <li>Then return {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Boolean'; then return 'Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangBoolean_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals('Z', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Boolean"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Byte}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Byte'; then return 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangByte_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals('B', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Byte"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Character}.
   *   <li>Then return {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Character'; then return 'C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangCharacter_thenReturnC() {
    // Arrange, Act and Assert
    assertEquals('C', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Character"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Double}.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Double'; then return 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangDouble_thenReturnD() {
    // Arrange, Act and Assert
    assertEquals('D', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Double"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Float}.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Float'; then return 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangFloat_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals('F', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Float"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Integer}.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Integer'; then return 'I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangInteger_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals('I', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Integer"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Long}.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Long'; then return 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangLong_thenReturnJ() {
    // Arrange, Act and Assert
    assertEquals('J', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Long"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Short}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Short'; then return 'S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangShort_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Short"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Void}.
   *   <li>Then return {@code V}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  @DisplayName(
      "Test internalPrimitiveTypeFromNumericClassName(String); when 'java/lang/Void'; then return 'V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.util.ClassUtil.internalPrimitiveTypeFromNumericClassName(java.lang.String)"
  })
  void testInternalPrimitiveTypeFromNumericClassName_whenJavaLangVoid_thenReturnV() {
    // Arrange, Act and Assert
    assertEquals('V', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Void"));
  }

  /**
   * Test {@link ClassUtil#internalSimpleClassName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalSimpleClassName(String)}
   */
  @Test
  @DisplayName("Test internalSimpleClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalSimpleClassName(java.lang.String)"
  })
  void testInternalSimpleClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.internalSimpleClassName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>Then return {@link BranchTargetFinder#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); then return UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(
        BranchTargetFinder.UNKNOWN,
        ClassUtil.internalPrimitiveTypeToComputationalType("Internal Primitive Type"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); when 'D'; then return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_whenD_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, ClassUtil.internalPrimitiveTypeToComputationalType("D"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); when 'F'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_whenF_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, ClassUtil.internalPrimitiveTypeToComputationalType("F"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); when 'I'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_whenI_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalPrimitiveTypeToComputationalType("I"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); when 'J'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_whenJ_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ClassUtil.internalPrimitiveTypeToComputationalType("J"));
  }

  /**
   * Test {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  @DisplayName("Test internalPrimitiveTypeToComputationalType(String); when 'Z'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalPrimitiveTypeToComputationalType(java.lang.String)"
  })
  void testInternalPrimitiveTypeToComputationalType_whenZ_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalPrimitiveTypeToComputationalType("Z"));
  }

  /**
   * Test {@link ClassUtil#isInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code <clinit>}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInitializer(String)}
   */
  @Test
  @DisplayName("Test isInitializer(String); when '<clinit>'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInitializer(java.lang.String)"})
  void testIsInitializer_whenClinit_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInitializer("<clinit>"));
  }

  /**
   * Test {@link ClassUtil#isInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code <init>}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInitializer(String)}
   */
  @Test
  @DisplayName("Test isInitializer(String); when '<init>'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInitializer(java.lang.String)"})
  void testIsInitializer_whenInit_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInitializer("<init>"));
  }

  /**
   * Test {@link ClassUtil#isInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Method Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInitializer(String)}
   */
  @Test
  @DisplayName("Test isInitializer(String); when 'Internal Method Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.ClassUtil.isInitializer(java.lang.String)"})
  void testIsInitializer_whenInternalMethodName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInitializer("Internal Method Name"));
  }

  /**
   * Test {@link ClassUtil#isClassInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code <clinit>}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isClassInitializer(String)}
   */
  @Test
  @DisplayName("Test isClassInitializer(String); when '<clinit>'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isClassInitializer(java.lang.String)"
  })
  void testIsClassInitializer_whenClinit_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isClassInitializer("<clinit>"));
  }

  /**
   * Test {@link ClassUtil#isClassInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Method Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isClassInitializer(String)}
   */
  @Test
  @DisplayName("Test isClassInitializer(String); when 'Internal Method Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isClassInitializer(java.lang.String)"
  })
  void testIsClassInitializer_whenInternalMethodName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isClassInitializer("Internal Method Name"));
  }

  /**
   * Test {@link ClassUtil#isInstanceInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code <init>}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInstanceInitializer(String)}
   */
  @Test
  @DisplayName("Test isInstanceInitializer(String); when '<init>'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInstanceInitializer(java.lang.String)"
  })
  void testIsInstanceInitializer_whenInit_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInstanceInitializer("<init>"));
  }

  /**
   * Test {@link ClassUtil#isInstanceInitializer(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Method Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInstanceInitializer(String)}
   */
  @Test
  @DisplayName(
      "Test isInstanceInitializer(String); when 'Internal Method Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInstanceInitializer(java.lang.String)"
  })
  void testIsInstanceInitializer_whenInternalMethodName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInstanceInitializer("Internal Method Name"));
  }

  /**
   * Test {@link ClassUtil#internalMethodReturnType(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodReturnType(String)}
   */
  @Test
  @DisplayName("Test internalMethodReturnType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodReturnType(java.lang.String)"
  })
  void testInternalMethodReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "Internal Method Descriptor",
        ClassUtil.internalMethodReturnType("Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterCount(String)} with {@code
   * internalMethodDescriptor}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterCount(String)}
   */
  @Test
  @DisplayName("Test internalMethodParameterCount(String) with 'internalMethodDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterCount(java.lang.String)"
  })
  void testInternalMethodParameterCountWithInternalMethodDescriptor() {
    // Arrange, Act and Assert
    assertEquals(25, ClassUtil.internalMethodParameterCount("Internal Method Descriptor)"));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterSize(String)} with {@code
   * internalMethodDescriptor}.
   *
   * <ul>
   *   <li>Then return twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterSize(String)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterSize(String) with 'internalMethodDescriptor'; then return twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterSize(java.lang.String)"
  })
  void testInternalMethodParameterSizeWithInternalMethodDescriptor_thenReturnTwentySix() {
    // Arrange, Act and Assert
    assertEquals(26, ClassUtil.internalMethodParameterSize("Internal Method Descriptor)"));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, int, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorAccessFlagsVariableIndex() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 1));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, int, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorAccessFlagsVariableIndex2() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 0));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, int, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorAccessFlagsVariableIndex3() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 8, 1));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, int, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorAccessFlagsVariableIndex4() {
    // Arrange, Act and Assert
    assertEquals(
        BranchTargetFinder.UNKNOWN,
        ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 60));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, boolean, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorIsStaticVariableIndex() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", true, 1));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, boolean, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorIsStaticVariableIndex2() {
    // Arrange, Act and Assert
    assertEquals(
        0, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 0));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, boolean, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorIsStaticVariableIndex3() {
    // Arrange, Act and Assert
    assertEquals(
        1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 1));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code variableIndex}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterNumber(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterNumber(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'variableIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodParameterNumber(java.lang.String, boolean, int)"
  })
  void testInternalMethodParameterNumberWithInternalMethodDescriptorIsStaticVariableIndex4() {
    // Arrange, Act and Assert
    assertEquals(
        BranchTargetFinder.UNKNOWN,
        ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 18));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, int, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorAccessFlagsParameterNumber() {
    // Arrange, Act and Assert
    assertEquals(11, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 1, 10));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, int, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorAccessFlagsParameterNumber2() {
    // Arrange, Act and Assert
    assertEquals(19, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 1, 17));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, int, int)} with {@code
   * internalMethodDescriptor}, {@code accessFlags}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, int, int) with 'internalMethodDescriptor', 'accessFlags', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, int, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorAccessFlagsParameterNumber3() {
    // Arrange, Act and Assert
    assertEquals(10, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 8, 10));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, boolean, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorIsStaticParameterNumber() {
    // Arrange, Act and Assert
    assertEquals(10, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", true, 10));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, boolean, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorIsStaticParameterNumber2() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", false, 0));
  }

  /**
   * Test {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)} with {@code
   * internalMethodDescriptor}, {@code isStatic}, {@code parameterNumber}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodVariableIndex(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodVariableIndex(String, boolean, int) with 'internalMethodDescriptor', 'isStatic', 'parameterNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.internalMethodVariableIndex(java.lang.String, boolean, int)"
  })
  void testInternalMethodVariableIndexWithInternalMethodDescriptorIsStaticParameterNumber3() {
    // Arrange, Act and Assert
    assertEquals(
        19, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", false, 17));
  }

  /**
   * Test {@link ClassUtil#internalMethodParameterType(String, int)}.
   *
   * <ul>
   *   <li>When {@code Internal Method Descriptor}.
   *   <li>Then return {@code n}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodParameterType(String, int)}
   */
  @Test
  @DisplayName(
      "Test internalMethodParameterType(String, int); when 'Internal Method Descriptor'; then return 'n'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodParameterType(java.lang.String, int)"
  })
  void testInternalMethodParameterType_whenInternalMethodDescriptor_thenReturnN() {
    // Arrange, Act and Assert
    assertEquals("n", ClassUtil.internalMethodParameterType("Internal Method Descriptor", 1));
  }

  /**
   * Test {@link ClassUtil#internalTypeSize(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalTypeSize(String)}
   */
  @Test
  @DisplayName("Test internalTypeSize(String); when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalTypeSize(java.lang.String)"})
  void testInternalTypeSize_whenInternalType() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalTypeSize("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#internalTypeSize(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalTypeSize(String)}
   */
  @Test
  @DisplayName("Test internalTypeSize(String); when '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.ClassUtil.internalTypeSize(java.lang.String)"})
  void testInternalTypeSize_whenPercentSign() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalTypeSize("%"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code boolean}.
   *   <li>Then return {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'boolean'; then return 'Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenBoolean_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals("Z", ClassUtil.internalType("boolean"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code byte}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'byte'; then return 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenByte_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("B", ClassUtil.internalType("byte"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code char}.
   *   <li>Then return {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'char'; then return 'C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenChar_thenReturnC() {
    // Arrange, Act and Assert
    assertEquals("C", ClassUtil.internalType("char"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code double}.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'double'; then return 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenDouble_thenReturnD() {
    // Arrange, Act and Assert
    assertEquals("D", ClassUtil.internalType("double"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code External Type}.
   *   <li>Then return {@code LExternal Type;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'External Type'; then return 'LExternal Type;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenExternalType_thenReturnLExternalType() {
    // Arrange, Act and Assert
    assertEquals("LExternal Type;", ClassUtil.internalType("External Type"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code float}.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'float'; then return 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenFloat_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals("F", ClassUtil.internalType("float"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code int}.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'int'; then return 'I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenInt_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("I", ClassUtil.internalType("int"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   *   <li>Then return {@code [L;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when '[]'; then return '[L;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenLeftSquareBracketRightSquareBracket_thenReturnL() {
    // Arrange, Act and Assert
    assertEquals("[L;", ClassUtil.internalType("[]"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code long}.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'long'; then return 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenLong_thenReturnJ() {
    // Arrange, Act and Assert
    assertEquals("J", ClassUtil.internalType("long"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when '%'; then return '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenPercentSign_thenReturnPercentSign() {
    // Arrange, Act and Assert
    assertEquals("%", ClassUtil.internalType("%"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code short}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'short'; then return 'S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenShort_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("S", ClassUtil.internalType("short"));
  }

  /**
   * Test {@link ClassUtil#internalType(String)}.
   *
   * <ul>
   *   <li>When {@code void}.
   *   <li>Then return {@code V}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  @DisplayName("Test internalType(String); when 'void'; then return 'V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalType(java.lang.String)"
  })
  void testInternalType_whenVoid_thenReturnV() {
    // Arrange, Act and Assert
    assertEquals("V", ClassUtil.internalType("void"));
  }

  /**
   * Test {@link ClassUtil#externalArrayTypeDimensionCount(String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalArrayTypeDimensionCount(String)}
   */
  @Test
  @DisplayName("Test externalArrayTypeDimensionCount(String); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.externalArrayTypeDimensionCount(java.lang.String)"
  })
  void testExternalArrayTypeDimensionCount_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.externalArrayTypeDimensionCount("[]"));
  }

  /**
   * Test {@link ClassUtil#externalArrayTypeDimensionCount(String)}.
   *
   * <ul>
   *   <li>When {@code External Type}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalArrayTypeDimensionCount(String)}
   */
  @Test
  @DisplayName(
      "Test externalArrayTypeDimensionCount(String); when 'External Type'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.util.ClassUtil.externalArrayTypeDimensionCount(java.lang.String)"
  })
  void testExternalArrayTypeDimensionCount_whenExternalType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.externalArrayTypeDimensionCount("External Type"));
  }

  /**
   * Test {@link ClassUtil#externalType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  @DisplayName("Test externalType(String); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalType(java.lang.String)"
  })
  void testExternalType_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType(""));
  }

  /**
   * Test {@link ClassUtil#externalType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  @DisplayName(
      "Test externalType(String); when 'Internal Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalType(java.lang.String)"
  })
  void testExternalType_whenInternalType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#externalType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  @DisplayName("Test externalType(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalType(java.lang.String)"
  })
  void testExternalType_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType(null));
  }

  /**
   * Test {@link ClassUtil#externalType(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  @DisplayName("Test externalType(String); when '%'; then return '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalType(java.lang.String)"
  })
  void testExternalType_whenPercentSign_thenReturnPercentSign() {
    // Arrange, Act and Assert
    assertEquals("%", ClassUtil.externalType("%"));
  }

  /**
   * Test {@link ClassUtil#externalType(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  @DisplayName("Test externalType(String); when ']'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalType(java.lang.String)"
  })
  void testExternalType_whenRightSquareBracket_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType("]"));
  }

  /**
   * Test {@link ClassUtil#externalClassForNameType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassForNameType(String)}
   */
  @Test
  @DisplayName("Test externalClassForNameType(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassForNameType(java.lang.String)"
  })
  void testExternalClassForNameType_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalClassForNameType(""));
  }

  /**
   * Test {@link ClassUtil#externalClassForNameType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   *   <li>Then return {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassForNameType(String)}
   */
  @Test
  @DisplayName(
      "Test externalClassForNameType(String); when 'Internal Type'; then return 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassForNameType(java.lang.String)"
  })
  void testExternalClassForNameType_whenInternalType_thenReturnInternalType() {
    // Arrange, Act and Assert
    assertEquals("Internal Type", ClassUtil.externalClassForNameType("Internal Type"));
  }

  /**
   * Test {@link ClassUtil#isInternalMethodDescriptor(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Descriptor}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isInternalMethodDescriptor(String)}
   */
  @Test
  @DisplayName(
      "Test isInternalMethodDescriptor(String); when 'Internal Descriptor'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isInternalMethodDescriptor(java.lang.String)"
  })
  void testIsInternalMethodDescriptor_whenInternalDescriptor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalMethodDescriptor("Internal Descriptor"));
  }

  /**
   * Test {@link ClassUtil#isExternalMethodNameAndArguments(String)}.
   *
   * <p>Method under test: {@link ClassUtil#isExternalMethodNameAndArguments(String)}
   */
  @Test
  @DisplayName("Test isExternalMethodNameAndArguments(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isExternalMethodNameAndArguments(java.lang.String)"
  })
  void testIsExternalMethodNameAndArguments() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isExternalMethodNameAndArguments("External Member Name And Arguments"));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments() {
    // Arrange, Act and Assert
    assertEquals(
        "()LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments2() {
    // Arrange, Act and Assert
    assertEquals("()%", ClassUtil.internalMethodDescriptor("%", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments3() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("[]");

    // Act and Assert
    assertEquals(
        "([L;)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments4() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("void");
    externalArguments.add("[]");

    // Act and Assert
    assertEquals(
        "(V[L;)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments5() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("long");

    // Act and Assert
    assertEquals(
        "(J)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments6() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("double");

    // Act and Assert
    assertEquals(
        "(D)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()B}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("()B", ClassUtil.internalMethodDescriptor("byte", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()C}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnC() {
    // Arrange, Act and Assert
    assertEquals("()C", ClassUtil.internalMethodDescriptor("char", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()F}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals("()F", ClassUtil.internalMethodDescriptor("float", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("()I", ClassUtil.internalMethodDescriptor("int", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()[L;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()[L;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnL() {
    // Arrange, Act and Assert
    assertEquals("()[L;", ClassUtil.internalMethodDescriptor("[]", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()S}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("()S", ClassUtil.internalMethodDescriptor("short", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()V}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnV() {
    // Arrange, Act and Assert
    assertEquals("()V", ClassUtil.internalMethodDescriptor("void", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptor(String, List)} with {@code externalReturnType},
   * {@code externalArguments}.
   *
   * <ul>
   *   <li>Then return {@code ()Z}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptor(String, List) with 'externalReturnType', 'externalArguments'; then return '()Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptor(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorWithExternalReturnTypeExternalArguments_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals("()Z", ClassUtil.internalMethodDescriptor("boolean", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}.
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  @DisplayName("Test internalMethodDescriptorFromInternalTypes(String, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptorFromInternalTypes(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorFromInternalTypes() {
    // Arrange
    ArrayList<String> internalArguments = new ArrayList<>();
    internalArguments.add("Internal Arguments");

    // Act and Assert
    assertEquals(
        "(Internal Arguments)Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes(
            "Internal Return Type", internalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}.
   *
   * <ul>
   *   <li>Then return {@code (42foo)Internal Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptorFromInternalTypes(String, List); then return '(42foo)Internal Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptorFromInternalTypes(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorFromInternalTypes_thenReturn42fooInternalReturnType() {
    // Arrange
    ArrayList<String> internalArguments = new ArrayList<>();
    internalArguments.add("42");
    internalArguments.add("foo");

    // Act and Assert
    assertEquals(
        "(42foo)Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes(
            "Internal Return Type", internalArguments));
  }

  /**
   * Test {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}.
   *
   * <ul>
   *   <li>Then return {@code ()Internal Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  @DisplayName(
      "Test internalMethodDescriptorFromInternalTypes(String, List); then return '()Internal Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalMethodDescriptorFromInternalTypes(java.lang.String, java.util.List)"
  })
  void testInternalMethodDescriptorFromInternalTypes_thenReturnInternalReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "()Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes(
            "Internal Return Type", new ArrayList<>()));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When {@code -889275714}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when '-889275714'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_when889275714_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullFieldDescription(
                -889275714, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when eight; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenEight_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(8, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName("Test externalFullFieldDescription(int, String, String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(1, "Field Name", ""));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when fifty; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenFifty_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullFieldDescription(50, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when four; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(4, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(1, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code public % Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when '%'; then return 'public % Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenPercentSign_thenReturnPublicFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "public % Field Name", ClassUtil.externalFullFieldDescription(1, "Field Name", "%"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When {@code public}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when 'public'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenPublic_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(1, "Field Name", "public"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When {@link BranchTargetFinder#UNKNOWN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when UNKNOWN; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenUnknown_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullFieldDescription(
                BranchTargetFinder.UNKNOWN, "Field Name", "Internal Field Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullFieldDescription(int, String, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test externalFullFieldDescription(int, String, String); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullFieldDescription(int, java.lang.String, java.lang.String)"
  })
  void testExternalFullFieldDescription_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(0, "Field Name", null));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code public % Internal Method Name(%)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); then return 'public % Internal Method Name(%)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_thenReturnPublicInternalMethodName() {
    // Arrange, Act and Assert
    assertEquals(
        "public % Internal Method Name(%)",
        ClassUtil.externalFullMethodDescription(
            "Internal Class Name", 1, "Internal Method Name", "%"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code -889275714}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName("Test externalFullMethodDescription(String, int, String, String); when '-889275714'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_when889275714() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name",
                -889275714,
                "Internal Method Name",
                "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when eight; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenEight_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 8, "Internal Method Name", "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName("Test externalFullMethodDescription(String, int, String, String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 1, "Internal Method Name", ""));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when fifty; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenFifty_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 50, "Internal Method Name", "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when four; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 4, "Internal Method Name", "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code <init>}.
   *   <li>Then return {@code public Internal Class Name()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when '<init>'; then return 'public Internal Class Name()'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenInit_thenReturnPublicInternalClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "public Internal Class Name()",
        ClassUtil.externalFullMethodDescription("Internal Class Name", 1, "<init>", "<init>"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 1, "Internal Method Name", "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When {@link BranchTargetFinder#UNKNOWN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when UNKNOWN; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenUnknown_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name",
                BranchTargetFinder.UNKNOWN,
                "Internal Method Name",
                "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFullMethodDescription(String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test externalFullMethodDescription(String, int, String, String); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFullMethodDescription(java.lang.String, int, java.lang.String, java.lang.String)"
  })
  void testExternalFullMethodDescription_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ClassUtil.externalFullMethodDescription(
                "Internal Class Name", 0, "<init>", "Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName("Test externalClassAccessFlags(int) with 'accessFlags'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(
        "private protected static final @interface ",
        ClassUtil.externalClassAccessFlags(-889275714));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName("Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix() {
    // Arrange, Act and Assert
    assertEquals("Prefixprivate Prefixfinal ", ClassUtil.externalClassAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName("Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix2() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefix@Prefixinterface ",
        ClassUtil.externalClassAccessFlags(-889275714, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixabstract}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixabstract'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixabstract() {
    // Arrange, Act and Assert
    assertEquals("Prefixabstract ", ClassUtil.externalClassAccessFlags(1024, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmodule}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmodule'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmodule() {
    // Arrange, Act and Assert
    assertEquals("Prefixmodule ", ClassUtil.externalClassAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixprotected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixprotected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixprotected() {
    // Arrange, Act and Assert
    assertEquals("Prefixprotected ", ClassUtil.externalClassAccessFlags(4, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixstatic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixstatic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixstatic() {
    // Arrange, Act and Assert
    assertEquals("Prefixstatic ", ClassUtil.externalClassAccessFlags(8, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalClassAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When {@code 16384}.
   *   <li>Then return {@code Prefixenum}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; when '16384'; then return 'Prefixenum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_when16384_thenReturnPrefixenum() {
    // Arrange, Act and Assert
    assertEquals("Prefixenum ", ClassUtil.externalClassAccessFlags(16384, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Prefixpublic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; when one; then return 'Prefixpublic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_whenOne_thenReturnPrefixpublic() {
    // Arrange, Act and Assert
    assertEquals("Prefixpublic ", ClassUtil.externalClassAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int, java.lang.String)"
  })
  void testExternalClassAccessFlagsWithAccessFlagsPrefix_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalClassAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 1024}.
   *   <li>Then return {@code abstract}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when '1024'; then return 'abstract'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_when1024_thenReturnAbstract() {
    // Arrange, Act and Assert
    assertEquals("abstract ", ClassUtil.externalClassAccessFlags(1024));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalClassAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 16384}.
   *   <li>Then return {@code enum}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when '16384'; then return 'enum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_when16384_thenReturnEnum() {
    // Arrange, Act and Assert
    assertEquals("enum ", ClassUtil.externalClassAccessFlags(16384));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code module}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when '32768'; then return 'module'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_when32768_thenReturnModule() {
    // Arrange, Act and Assert
    assertEquals("module ", ClassUtil.externalClassAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code static}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when eight; then return 'static'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_whenEight_thenReturnStatic() {
    // Arrange, Act and Assert
    assertEquals("static ", ClassUtil.externalClassAccessFlags(8));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then return {@code private final}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when fifty; then return 'private final'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_whenFifty_thenReturnPrivateFinal() {
    // Arrange, Act and Assert
    assertEquals("private final ", ClassUtil.externalClassAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code protected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when four; then return 'protected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_whenFour_thenReturnProtected() {
    // Arrange, Act and Assert
    assertEquals("protected ", ClassUtil.externalClassAccessFlags(4));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code public}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when one; then return 'public'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_whenOne_thenReturnPublic() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalClassAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalClassAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalClassAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalClassAccessFlags(int)"
  })
  void testExternalClassAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalClassAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName("Test externalFieldAccessFlags(int) with 'accessFlags'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(
        "private protected static final transient synthetic ",
        ClassUtil.externalFieldAccessFlags(-889275714));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName("Test externalFieldAccessFlags(int) with 'accessFlags'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags2() {
    // Arrange, Act and Assert
    assertEquals(
        "public private protected static final volatile transient synthetic ",
        ClassUtil.externalFieldAccessFlags(BranchTargetFinder.UNKNOWN));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName("Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix() {
    // Arrange, Act and Assert
    assertEquals("Prefixprivate Prefixfinal ", ClassUtil.externalFieldAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName("Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix2() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixtransient Prefixsynthetic ",
        ClassUtil.externalFieldAccessFlags(-889275714, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixprotected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixprotected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixprotected() {
    // Arrange, Act and Assert
    assertEquals("Prefixprotected ", ClassUtil.externalFieldAccessFlags(4, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixstatic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixstatic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixstatic() {
    // Arrange, Act and Assert
    assertEquals("Prefixstatic ", ClassUtil.externalFieldAccessFlags(8, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Prefixpublic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'; when one; then return 'Prefixpublic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix_whenOne_thenReturnPrefixpublic() {
    // Arrange, Act and Assert
    assertEquals("Prefixpublic ", ClassUtil.externalFieldAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When {@link BranchTargetFinder#UNKNOWN}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'; when UNKNOWN; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix_whenUnknown_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixpublic Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixvolatile Prefixtransient"
            + " Prefixsynthetic ",
        ClassUtil.externalFieldAccessFlags(BranchTargetFinder.UNKNOWN, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int, java.lang.String)"
  })
  void testExternalFieldAccessFlagsWithAccessFlagsPrefix_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalFieldAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code static}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int) with 'accessFlags'; when eight; then return 'static'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags_whenEight_thenReturnStatic() {
    // Arrange, Act and Assert
    assertEquals("static ", ClassUtil.externalFieldAccessFlags(8));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then return {@code private final}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int) with 'accessFlags'; when fifty; then return 'private final'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags_whenFifty_thenReturnPrivateFinal() {
    // Arrange, Act and Assert
    assertEquals("private final ", ClassUtil.externalFieldAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code protected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int) with 'accessFlags'; when four; then return 'protected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags_whenFour_thenReturnProtected() {
    // Arrange, Act and Assert
    assertEquals("protected ", ClassUtil.externalFieldAccessFlags(4));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code public}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int) with 'accessFlags'; when one; then return 'public'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags_whenOne_thenReturnPublic() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalFieldAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalFieldAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalFieldAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalFieldAccessFlags(int)"
  })
  void testExternalFieldAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalFieldAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName("Test externalMethodAccessFlags(int) with 'accessFlags'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(
        "private protected static final synchronized varargs strictfp synthetic ",
        ClassUtil.externalMethodAccessFlags(-889275714));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName("Test externalMethodAccessFlags(int) with 'accessFlags'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags2() {
    // Arrange, Act and Assert
    assertEquals(
        "public private protected static final synchronized bridge varargs native abstract strictfp"
            + " synthetic ",
        ClassUtil.externalMethodAccessFlags(BranchTargetFinder.UNKNOWN));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName("Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixprivate Prefixfinal Prefixsynchronized ",
        ClassUtil.externalMethodAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalMethodAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixprotected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixprotected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixprotected() {
    // Arrange, Act and Assert
    assertEquals("Prefixprotected ", ClassUtil.externalMethodAccessFlags(4, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixpublic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixpublic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixpublic() {
    // Arrange, Act and Assert
    assertEquals("Prefixpublic ", ClassUtil.externalMethodAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixstatic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixstatic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixstatic() {
    // Arrange, Act and Assert
    assertEquals("Prefixstatic ", ClassUtil.externalMethodAccessFlags(8, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When {@code -889275714}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; when '-889275714'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_when889275714() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixsynchronized Prefixvarargs Prefixstrictfp"
            + " Prefixsynthetic ",
        ClassUtil.externalMethodAccessFlags(-889275714, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When {@link BranchTargetFinder#UNKNOWN}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int, String) with 'accessFlags', 'prefix'; when UNKNOWN; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int, java.lang.String)"
  })
  void testExternalMethodAccessFlagsWithAccessFlagsPrefix_whenUnknown_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixpublic Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixsynchronized Prefixbridge"
            + " Prefixvarargs Prefixnative Prefixabstract Prefixstrictfp Prefixsynthetic ",
        ClassUtil.externalMethodAccessFlags(BranchTargetFinder.UNKNOWN, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>Then return {@code private final synchronized}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int) with 'accessFlags'; then return 'private final synchronized'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags_thenReturnPrivateFinalSynchronized() {
    // Arrange, Act and Assert
    assertEquals("private final synchronized ", ClassUtil.externalMethodAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code static}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int) with 'accessFlags'; when eight; then return 'static'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags_whenEight_thenReturnStatic() {
    // Arrange, Act and Assert
    assertEquals("static ", ClassUtil.externalMethodAccessFlags(8));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code protected}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int) with 'accessFlags'; when four; then return 'protected'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags_whenFour_thenReturnProtected() {
    // Arrange, Act and Assert
    assertEquals("protected ", ClassUtil.externalMethodAccessFlags(4));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code public}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int) with 'accessFlags'; when one; then return 'public'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags_whenOne_thenReturnPublic() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalMethodAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalMethodAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalMethodAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodAccessFlags(int)"
  })
  void testExternalMethodAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalMethodAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixfinal}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixfinal'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int, java.lang.String)"
  })
  void testExternalParameterAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixfinal() {
    // Arrange, Act and Assert
    assertEquals("Prefixfinal ", ClassUtil.externalParameterAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int, java.lang.String)"
  })
  void testExternalParameterAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmandated() {
    // Arrange, Act and Assert
    assertEquals("Prefixmandated ", ClassUtil.externalParameterAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int, java.lang.String)"
  })
  void testExternalParameterAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalParameterAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int, String) with 'accessFlags', 'prefix'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int, java.lang.String)"
  })
  void testExternalParameterAccessFlagsWithAccessFlagsPrefix_whenOne() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalParameterAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int, java.lang.String)"
  })
  void testExternalParameterAccessFlagsWithAccessFlagsPrefix_whenZero() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalParameterAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int)"
  })
  void testExternalParameterAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalParameterAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code mandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int) with 'accessFlags'; when '32768'; then return 'mandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int)"
  })
  void testExternalParameterAccessFlagsWithAccessFlags_when32768_thenReturnMandated() {
    // Arrange, Act and Assert
    assertEquals("mandated ", ClassUtil.externalParameterAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then return {@code final}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int) with 'accessFlags'; when fifty; then return 'final'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int)"
  })
  void testExternalParameterAccessFlagsWithAccessFlags_whenFifty_thenReturnFinal() {
    // Arrange, Act and Assert
    assertEquals("final ", ClassUtil.externalParameterAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int) with 'accessFlags'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int)"
  })
  void testExternalParameterAccessFlagsWithAccessFlags_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalParameterAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalParameterAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalParameterAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalParameterAccessFlags(int)"
  })
  void testExternalParameterAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalParameterAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalMethodReturnType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodReturnType(String)}
   */
  @Test
  @DisplayName(
      "Test externalMethodReturnType(String); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodReturnType(java.lang.String)"
  })
  void testExternalMethodReturnType_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalMethodReturnType(""));
  }

  /**
   * Test {@link ClassUtil#externalMethodReturnType(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Method Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodReturnType(String)}
   */
  @Test
  @DisplayName("Test externalMethodReturnType(String); when 'Internal Method Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodReturnType(java.lang.String)"
  })
  void testExternalMethodReturnType_whenInternalMethodDescriptor() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalMethodReturnType("Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalMethodReturnType(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodReturnType(String)}
   */
  @Test
  @DisplayName("Test externalMethodReturnType(String); when '%'; then return '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodReturnType(java.lang.String)"
  })
  void testExternalMethodReturnType_whenPercentSign_thenReturnPercentSign() {
    // Arrange, Act and Assert
    assertEquals("%", ClassUtil.externalMethodReturnType("%"));
  }

  /**
   * Test {@link ClassUtil#externalMethodReturnType(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodReturnType(String)}
   */
  @Test
  @DisplayName("Test externalMethodReturnType(String); when ']'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodReturnType(java.lang.String)"
  })
  void testExternalMethodReturnType_whenRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalMethodReturnType("]"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int, java.lang.String)"
  })
  void testExternalModuleAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmandated() {
    // Arrange, Act and Assert
    assertEquals("Prefixmandated ", ClassUtil.externalModuleAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixopen}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixopen'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int, java.lang.String)"
  })
  void testExternalModuleAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixopen() {
    // Arrange, Act and Assert
    assertEquals("Prefixopen ", ClassUtil.externalModuleAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int, java.lang.String)"
  })
  void testExternalModuleAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalModuleAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int, String) with 'accessFlags', 'prefix'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int, java.lang.String)"
  })
  void testExternalModuleAccessFlagsWithAccessFlagsPrefix_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalModuleAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int, java.lang.String)"
  })
  void testExternalModuleAccessFlagsWithAccessFlagsPrefix_whenZero() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalModuleAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int)"
  })
  void testExternalModuleAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalModuleAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code mandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int) with 'accessFlags'; when '32768'; then return 'mandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int)"
  })
  void testExternalModuleAccessFlagsWithAccessFlags_when32768_thenReturnMandated() {
    // Arrange, Act and Assert
    assertEquals("mandated ", ClassUtil.externalModuleAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then return {@code open}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int) with 'accessFlags'; when fifty; then return 'open'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int)"
  })
  void testExternalModuleAccessFlagsWithAccessFlags_whenFifty_thenReturnOpen() {
    // Arrange, Act and Assert
    assertEquals("open ", ClassUtil.externalModuleAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int) with 'accessFlags'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int)"
  })
  void testExternalModuleAccessFlagsWithAccessFlags_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalModuleAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalModuleAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalModuleAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalModuleAccessFlags(int)"
  })
  void testExternalModuleAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalModuleAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmandated() {
    // Arrange, Act and Assert
    assertEquals("Prefixmandated ", ClassUtil.externalRequiresAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixstatic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixstatic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixstatic() {
    // Arrange, Act and Assert
    assertEquals("Prefixstatic ", ClassUtil.externalRequiresAccessFlags(Double.SIZE, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalRequiresAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixtransitive}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixtransitive'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixtransitive() {
    // Arrange, Act and Assert
    assertEquals("Prefixtransitive ", ClassUtil.externalRequiresAccessFlags(50, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_whenOne() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalRequiresAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int, String)} with {@code accessFlags},
   * {@code prefix}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int, java.lang.String)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlagsPrefix_whenZero() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalRequiresAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalRequiresAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code mandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when '32768'; then return 'mandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_when32768_thenReturnMandated() {
    // Arrange, Act and Assert
    assertEquals("mandated ", ClassUtil.externalRequiresAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When fifty.
   *   <li>Then return {@code transitive}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when fifty; then return 'transitive'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_whenFifty_thenReturnTransitive() {
    // Arrange, Act and Assert
    assertEquals("transitive ", ClassUtil.externalRequiresAccessFlags(50));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalRequiresAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@link Double#SIZE}.
   *   <li>Then return {@code static}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when SIZE; then return 'static'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_whenSize_thenReturnStatic() {
    // Arrange, Act and Assert
    assertEquals("static ", ClassUtil.externalRequiresAccessFlags(Double.SIZE));
  }

  /**
   * Test {@link ClassUtil#externalRequiresAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalRequiresAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalRequiresAccessFlags(int)"
  })
  void testExternalRequiresAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalRequiresAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int, java.lang.String)"
  })
  void testExternalExportsAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmandated() {
    // Arrange, Act and Assert
    assertEquals("Prefixmandated ", ClassUtil.externalExportsAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int, java.lang.String)"
  })
  void testExternalExportsAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalExportsAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int, String) with 'accessFlags', 'prefix'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int, java.lang.String)"
  })
  void testExternalExportsAccessFlagsWithAccessFlagsPrefix_whenOne() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalExportsAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int, java.lang.String)"
  })
  void testExternalExportsAccessFlagsWithAccessFlagsPrefix_whenZero() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalExportsAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int)"
  })
  void testExternalExportsAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalExportsAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code mandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int) with 'accessFlags'; when '32768'; then return 'mandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int)"
  })
  void testExternalExportsAccessFlagsWithAccessFlags_when32768_thenReturnMandated() {
    // Arrange, Act and Assert
    assertEquals("mandated ", ClassUtil.externalExportsAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int) with 'accessFlags'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int)"
  })
  void testExternalExportsAccessFlagsWithAccessFlags_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalExportsAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalExportsAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalExportsAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalExportsAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalExportsAccessFlags(int)"
  })
  void testExternalExportsAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalExportsAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixmandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixmandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int, java.lang.String)"
  })
  void testExternalOpensAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixmandated() {
    // Arrange, Act and Assert
    assertEquals("Prefixmandated ", ClassUtil.externalOpensAccessFlags(32768, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>Then return {@code Prefixsynthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int, String) with 'accessFlags', 'prefix'; then return 'Prefixsynthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int, java.lang.String)"
  })
  void testExternalOpensAccessFlagsWithAccessFlagsPrefix_thenReturnPrefixsynthetic() {
    // Arrange, Act and Assert
    assertEquals("Prefixsynthetic ", ClassUtil.externalOpensAccessFlags(4096, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int, String) with 'accessFlags', 'prefix'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int, java.lang.String)"
  })
  void testExternalOpensAccessFlagsWithAccessFlagsPrefix_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalOpensAccessFlags(1, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int, String)} with {@code accessFlags}, {@code
   * prefix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int, String)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int, String) with 'accessFlags', 'prefix'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int, java.lang.String)"
  })
  void testExternalOpensAccessFlagsWithAccessFlagsPrefix_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalOpensAccessFlags(0, "Prefix"));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code synthetic}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int) with 'accessFlags'; when '4096'; then return 'synthetic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int)"
  })
  void testExternalOpensAccessFlagsWithAccessFlags_when4096_thenReturnSynthetic() {
    // Arrange, Act and Assert
    assertEquals("synthetic ", ClassUtil.externalOpensAccessFlags(4096));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code mandated}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int) with 'accessFlags'; when '32768'; then return 'mandated'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int)"
  })
  void testExternalOpensAccessFlagsWithAccessFlags_when32768_thenReturnMandated() {
    // Arrange, Act and Assert
    assertEquals("mandated ", ClassUtil.externalOpensAccessFlags(32768));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int) with 'accessFlags'; when one; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int)"
  })
  void testExternalOpensAccessFlagsWithAccessFlags_whenOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalOpensAccessFlags(1));
  }

  /**
   * Test {@link ClassUtil#externalOpensAccessFlags(int)} with {@code accessFlags}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalOpensAccessFlags(int)}
   */
  @Test
  @DisplayName(
      "Test externalOpensAccessFlags(int) with 'accessFlags'; when zero; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalOpensAccessFlags(int)"
  })
  void testExternalOpensAccessFlagsWithAccessFlags_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalOpensAccessFlags(0));
  }

  /**
   * Test {@link ClassUtil#externalMethodArguments(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodArguments(String)}
   */
  @Test
  @DisplayName("Test externalMethodArguments(String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodArguments(java.lang.String)"
  })
  void testExternalMethodArguments_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ClassUtil.externalMethodArguments("Internal Method Descriptor"));
  }

  /**
   * Test {@link ClassUtil#externalMethodArguments(String)}.
   *
   * <ul>
   *   <li>When {@code %}.
   *   <li>Then return {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalMethodArguments(String)}
   */
  @Test
  @DisplayName("Test externalMethodArguments(String); when '%'; then return '%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalMethodArguments(java.lang.String)"
  })
  void testExternalMethodArguments_whenPercentSign_thenReturnPercentSign() {
    // Arrange, Act and Assert
    assertEquals("%", ClassUtil.externalMethodArguments("%"));
  }

  /**
   * Test {@link ClassUtil#internalPackageName(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalPackageName(String)}
   */
  @Test
  @DisplayName("Test internalPackageName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalPackageName(java.lang.String)"
  })
  void testInternalPackageName() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalPackageName("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#internalPackagePrefix(String)}.
   *
   * <p>Method under test: {@link ClassUtil#internalPackagePrefix(String)}
   */
  @Test
  @DisplayName("Test internalPackagePrefix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.internalPackagePrefix(java.lang.String)"
  })
  void testInternalPackagePrefix() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalPackagePrefix("Internal Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalPackageName(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0}.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalPackageName(String)}
   */
  @Test
  @DisplayName("Test externalPackageName(String); when '1.0'; then return '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalPackageName(java.lang.String)"
  })
  void testExternalPackageName_when10_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", ClassUtil.externalPackageName("1.0"));
  }

  /**
   * Test {@link ClassUtil#externalPackageName(String)}.
   *
   * <ul>
   *   <li>When {@code External Class Name}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#externalPackageName(String)}
   */
  @Test
  @DisplayName(
      "Test externalPackageName(String); when 'External Class Name'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalPackageName(java.lang.String)"
  })
  void testExternalPackageName_whenExternalClassName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalPackageName("External Class Name"));
  }

  /**
   * Test {@link ClassUtil#externalPackagePrefix(String)}.
   *
   * <p>Method under test: {@link ClassUtil#externalPackagePrefix(String)}
   */
  @Test
  @DisplayName("Test externalPackagePrefix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.ClassUtil.externalPackagePrefix(java.lang.String)"
  })
  void testExternalPackagePrefix() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalPackagePrefix("External Class Name"));
  }

  /**
   * Test {@link ClassUtil#isExtendable(Clazz)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isExtendable(Clazz)}
   */
  @Test
  @DisplayName("Test isExtendable(Clazz); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isExtendable(proguard.classfile.Clazz)"
  })
  void testIsExtendable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ClassUtil.isExtendable(
            new LibraryClass(Short.SIZE, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link ClassUtil#isExtendable(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isExtendable(Clazz)}
   */
  @Test
  @DisplayName("Test isExtendable(Clazz); when LibraryClass(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isExtendable(proguard.classfile.Clazz)"
  })
  void testIsExtendable_whenLibraryClass_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isExtendable(new LibraryClass()));
  }

  /**
   * Test {@link ClassUtil#isExtendable(Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassUtil#isExtendable(Clazz)}
   */
  @Test
  @DisplayName("Test isExtendable(Clazz); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.ClassUtil.isExtendable(proguard.classfile.Clazz)"
  })
  void testIsExtendable_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isExtendable(null));
  }
}
