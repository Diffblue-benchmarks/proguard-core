package proguard.io.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.io.ClassPath;
import proguard.io.ClassPathEntry;

class ClassPathUtilDiffblueTest {
  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput2() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput3() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath); when ClassPath(ClassPathEntry[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.hasAabInput(proguard.io.ClassPath)"})
  void testHasAabInput_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(null));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid2() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid3() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid4() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid5() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid6() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.isAndroid(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath); when ClassPath(ClassPathEntry[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isAndroid(proguard.io.ClassPath)"})
  void testIsAndroid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isAndroid(null));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik2() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik3() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik4() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.isDalvik(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath); when ClassPath(ClassPathEntry[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.util.ClassPathUtil.isDalvik(proguard.io.ClassPath)"})
  void testIsDalvik_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isDalvik(null));
  }

  /**
   * Test {@link ClassPathUtil#determineCompressionMethod(ClassPath)} with {@code classPath}.
   *
   * <p>Method under test: {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  @DisplayName("Test determineCompressionMethod(ClassPath) with 'classPath'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.io.util.ClassPathUtil.determineCompressionMethod(proguard.io.ClassPath)"
  })
  void testDetermineCompressionMethodWithClassPath() {
    // Arrange, Act and Assert
    assertNull(
        ClassPathUtil.determineCompressionMethod(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#determineCompressionMethod(ClassPath)} with {@code classPath}.
   *
   * <p>Method under test: {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  @DisplayName("Test determineCompressionMethod(ClassPath) with 'classPath'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.io.util.ClassPathUtil.determineCompressionMethod(proguard.io.ClassPath)"
  })
  void testDetermineCompressionMethodWithClassPath2() {
    // Arrange, Act and Assert
    assertNull(
        ClassPathUtil.determineCompressionMethod(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
  }
}
