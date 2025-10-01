package proguard.io.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  void testHasAabInput() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(classPath));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName("Test hasAabInput(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  void testHasAabInput2() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath()));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  void testHasAabInput_thenReturnTrue() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false));

    // Act and Assert
    assertTrue(ClassPathUtil.hasAabInput(classPath));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])} with entries is {@link
   *       ClassPathEntry#ClassPathEntry(File, boolean)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @DisplayName(
      "Test hasAabInput(ClassPath); when ClassPath(ClassPathEntry[]) with entries is ClassPathEntry(File, boolean); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  void testHasAabInput_whenClassPathWithEntriesIsClassPathEntry_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath(classPathEntry)));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid2() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isAndroid(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid3() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isAndroid(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid4() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isAndroid(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName("Test isAndroid(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid5() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isAndroid(classPath));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
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
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])} with entries is {@link
   *       ClassPathEntry#ClassPathEntry(File, boolean)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @DisplayName(
      "Test isAndroid(ClassPath); when ClassPath(ClassPathEntry[]) with entries is ClassPathEntry(File, boolean); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  void testIsAndroid_whenClassPathWithEntriesIsClassPathEntry_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(new ClassPath(classPathEntry)));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  void testIsDalvik() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  void testIsDalvik2() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isDalvik(classPath));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName("Test isDalvik(ClassPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  void testIsDalvik3() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        1,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));

    // Act and Assert
    assertTrue(ClassPathUtil.isDalvik(classPath));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
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
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])} with entries is {@link
   *       ClassPathEntry#ClassPathEntry(File, boolean)}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @DisplayName(
      "Test isDalvik(ClassPath); when ClassPath(ClassPathEntry[]) with entries is ClassPathEntry(File, boolean); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  void testIsDalvik_whenClassPathWithEntriesIsClassPathEntry_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(new ClassPath(classPathEntry)));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.util.StringMatcher ClassPathUtil.determineCompressionMethod(ClassPath)"
  })
  void testDetermineCompressionMethodWithClassPath() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertNull(ClassPathUtil.determineCompressionMethod(new ClassPath(classPathEntry)));
  }

  /**
   * Test {@link ClassPathUtil#determineCompressionMethod(ClassPath)} with {@code classPath}.
   *
   * <p>Method under test: {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  @DisplayName("Test determineCompressionMethod(ClassPath) with 'classPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.util.StringMatcher ClassPathUtil.determineCompressionMethod(ClassPath)"
  })
  void testDetermineCompressionMethodWithClassPath2() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));

    // Act and Assert
    assertNull(ClassPathUtil.determineCompressionMethod(classPath));
  }
}
