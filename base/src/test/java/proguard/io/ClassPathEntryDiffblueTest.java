package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassPathEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Feature Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassPathEntry#ClassPathEntry(File, boolean, String)}
   *   <li>{@link ClassPathEntry#setFeatureName(String)}
   *   <li>{@link ClassPathEntry#setOutput(boolean)}
   *   <li>{@link ClassPathEntry#getAabFilter()}
   *   <li>{@link ClassPathEntry#getAarFilter()}
   *   <li>{@link ClassPathEntry#getApkFilter()}
   *   <li>{@link ClassPathEntry#getEarFilter()}
   *   <li>{@link ClassPathEntry#getFeatureName()}
   *   <li>{@link ClassPathEntry#getFile()}
   *   <li>{@link ClassPathEntry#getFilter()}
   *   <li>{@link ClassPathEntry#getJarFilter()}
   *   <li>{@link ClassPathEntry#getJmodFilter()}
   *   <li>{@link ClassPathEntry#getWarFilter()}
   *   <li>{@link ClassPathEntry#getZipFilter()}
   *   <li>{@link ClassPathEntry#isOutput()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Feature Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClassPathEntry.<init>(File, boolean)",
    "void ClassPathEntry.<init>(File, boolean, String)",
    "List ClassPathEntry.getAabFilter()",
    "List ClassPathEntry.getAarFilter()",
    "List ClassPathEntry.getApkFilter()",
    "List ClassPathEntry.getEarFilter()",
    "String ClassPathEntry.getFeatureName()",
    "File ClassPathEntry.getFile()",
    "List ClassPathEntry.getFilter()",
    "List ClassPathEntry.getJarFilter()",
    "List ClassPathEntry.getJmodFilter()",
    "List ClassPathEntry.getWarFilter()",
    "List ClassPathEntry.getZipFilter()",
    "boolean ClassPathEntry.isOutput()",
    "void ClassPathEntry.setFeatureName(String)",
    "void ClassPathEntry.setOutput(boolean)"
  })
  void testGettersAndSetters_whenFeatureName() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    ClassPathEntry actualClassPathEntry = new ClassPathEntry(file, true, "Feature Name");
    actualClassPathEntry.setFeatureName("Feature Name");
    actualClassPathEntry.setOutput(true);
    List<String> actualAabFilter = actualClassPathEntry.getAabFilter();
    List<String> actualAarFilter = actualClassPathEntry.getAarFilter();
    List<String> actualApkFilter = actualClassPathEntry.getApkFilter();
    List<String> actualEarFilter = actualClassPathEntry.getEarFilter();
    String actualFeatureName = actualClassPathEntry.getFeatureName();
    File actualFile = actualClassPathEntry.getFile();
    List<String> actualFilter = actualClassPathEntry.getFilter();
    List<String> actualJarFilter = actualClassPathEntry.getJarFilter();
    List<String> actualJmodFilter = actualClassPathEntry.getJmodFilter();
    List<String> actualWarFilter = actualClassPathEntry.getWarFilter();
    List<String> actualZipFilter = actualClassPathEntry.getZipFilter();

    // Assert
    assertEquals("Feature Name", actualFeatureName);
    assertNull(actualAabFilter);
    assertNull(actualAarFilter);
    assertNull(actualApkFilter);
    assertNull(actualEarFilter);
    assertNull(actualFilter);
    assertNull(actualJarFilter);
    assertNull(actualJmodFilter);
    assertNull(actualWarFilter);
    assertNull(actualZipFilter);
    assertTrue(actualClassPathEntry.isOutput());
    assertSame(file, actualFile);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassPathEntry#ClassPathEntry(File, boolean)}
   *   <li>{@link ClassPathEntry#setFeatureName(String)}
   *   <li>{@link ClassPathEntry#setOutput(boolean)}
   *   <li>{@link ClassPathEntry#getAabFilter()}
   *   <li>{@link ClassPathEntry#getAarFilter()}
   *   <li>{@link ClassPathEntry#getApkFilter()}
   *   <li>{@link ClassPathEntry#getEarFilter()}
   *   <li>{@link ClassPathEntry#getFeatureName()}
   *   <li>{@link ClassPathEntry#getFile()}
   *   <li>{@link ClassPathEntry#getFilter()}
   *   <li>{@link ClassPathEntry#getJarFilter()}
   *   <li>{@link ClassPathEntry#getJmodFilter()}
   *   <li>{@link ClassPathEntry#getWarFilter()}
   *   <li>{@link ClassPathEntry#getZipFilter()}
   *   <li>{@link ClassPathEntry#isOutput()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClassPathEntry.<init>(File, boolean)",
    "void ClassPathEntry.<init>(File, boolean, String)",
    "List ClassPathEntry.getAabFilter()",
    "List ClassPathEntry.getAarFilter()",
    "List ClassPathEntry.getApkFilter()",
    "List ClassPathEntry.getEarFilter()",
    "String ClassPathEntry.getFeatureName()",
    "File ClassPathEntry.getFile()",
    "List ClassPathEntry.getFilter()",
    "List ClassPathEntry.getJarFilter()",
    "List ClassPathEntry.getJmodFilter()",
    "List ClassPathEntry.getWarFilter()",
    "List ClassPathEntry.getZipFilter()",
    "boolean ClassPathEntry.isOutput()",
    "void ClassPathEntry.setFeatureName(String)",
    "void ClassPathEntry.setOutput(boolean)"
  })
  void testGettersAndSetters_whenPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    ClassPathEntry actualClassPathEntry = new ClassPathEntry(file, true);
    actualClassPathEntry.setFeatureName("Feature Name");
    actualClassPathEntry.setOutput(true);
    List<String> actualAabFilter = actualClassPathEntry.getAabFilter();
    List<String> actualAarFilter = actualClassPathEntry.getAarFilter();
    List<String> actualApkFilter = actualClassPathEntry.getApkFilter();
    List<String> actualEarFilter = actualClassPathEntry.getEarFilter();
    String actualFeatureName = actualClassPathEntry.getFeatureName();
    File actualFile = actualClassPathEntry.getFile();
    List<String> actualFilter = actualClassPathEntry.getFilter();
    List<String> actualJarFilter = actualClassPathEntry.getJarFilter();
    List<String> actualJmodFilter = actualClassPathEntry.getJmodFilter();
    List<String> actualWarFilter = actualClassPathEntry.getWarFilter();
    List<String> actualZipFilter = actualClassPathEntry.getZipFilter();

    // Assert
    assertEquals("Feature Name", actualFeatureName);
    assertNull(actualAabFilter);
    assertNull(actualAarFilter);
    assertNull(actualApkFilter);
    assertNull(actualEarFilter);
    assertNull(actualFilter);
    assertNull(actualJarFilter);
    assertNull(actualJmodFilter);
    assertNull(actualWarFilter);
    assertNull(actualZipFilter);
    assertTrue(actualClassPathEntry.isOutput());
    assertSame(file, actualFile);
  }

  /**
   * Test {@link ClassPathEntry#getName()}.
   *
   * <p>Method under test: {@link ClassPathEntry#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .getName());
  }

  /**
   * Test {@link ClassPathEntry#setFile(File)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setFile(File)}
   */
  @Test
  @DisplayName("Test setFile(File)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setFile(File)"})
  void testSetFile() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    classPathEntry.setFile(file);

    // Assert
    assertSame(file, classPathEntry.getFile());
  }

  /**
   * Test {@link ClassPathEntry#isDex()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isDex()}
   */
  @Test
  @DisplayName("Test isDex(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isDex()"})
  void testIsDex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isDex());
  }

  /**
   * Test {@link ClassPathEntry#isDex()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isDex()}
   */
  @Test
  @DisplayName("Test isDex(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isDex()"})
  void testIsDex_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true)
            .isDex());
  }

  /**
   * Test {@link ClassPathEntry#isApk()}.
   *
   * <p>Method under test: {@link ClassPathEntry#isApk()}
   */
  @Test
  @DisplayName("Test isApk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isApk()"})
  void testIsApk() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true)
            .isApk());
  }

  /**
   * Test {@link ClassPathEntry#isApk()}.
   *
   * <p>Method under test: {@link ClassPathEntry#isApk()}
   */
  @Test
  @DisplayName("Test isApk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isApk()"})
  void testIsApk2() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".ap_").toFile(), true)
            .isApk());
  }

  /**
   * Test {@link ClassPathEntry#isApk()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isApk()}
   */
  @Test
  @DisplayName("Test isApk(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isApk()"})
  void testIsApk_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isApk());
  }

  /**
   * Test {@link ClassPathEntry#isAab()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isAab()}
   */
  @Test
  @DisplayName("Test isAab(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isAab()"})
  void testIsAab_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isAab());
  }

  /**
   * Test {@link ClassPathEntry#isAab()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isAab()}
   */
  @Test
  @DisplayName("Test isAab(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isAab()"})
  void testIsAab_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true)
            .isAab());
  }

  /**
   * Test {@link ClassPathEntry#isJar()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isJar()}
   */
  @Test
  @DisplayName("Test isJar(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isJar()"})
  void testIsJar_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isJar());
  }

  /**
   * Test {@link ClassPathEntry#isJar()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isJar()}
   */
  @Test
  @DisplayName("Test isJar(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isJar()"})
  void testIsJar_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true)
            .isJar());
  }

  /**
   * Test {@link ClassPathEntry#isAar()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isAar()}
   */
  @Test
  @DisplayName("Test isAar(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isAar()"})
  void testIsAar_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isAar());
  }

  /**
   * Test {@link ClassPathEntry#isAar()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isAar()}
   */
  @Test
  @DisplayName("Test isAar(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isAar()"})
  void testIsAar_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true)
            .isAar());
  }

  /**
   * Test {@link ClassPathEntry#isWar()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isWar()}
   */
  @Test
  @DisplayName("Test isWar(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isWar()"})
  void testIsWar_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isWar());
  }

  /**
   * Test {@link ClassPathEntry#isWar()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isWar()}
   */
  @Test
  @DisplayName("Test isWar(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isWar()"})
  void testIsWar_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true)
            .isWar());
  }

  /**
   * Test {@link ClassPathEntry#isEar()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isEar()}
   */
  @Test
  @DisplayName("Test isEar(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isEar()"})
  void testIsEar_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isEar());
  }

  /**
   * Test {@link ClassPathEntry#isEar()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isEar()}
   */
  @Test
  @DisplayName("Test isEar(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isEar()"})
  void testIsEar_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true)
            .isEar());
  }

  /**
   * Test {@link ClassPathEntry#isJmod()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isJmod()}
   */
  @Test
  @DisplayName("Test isJmod(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isJmod()"})
  void testIsJmod_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isJmod());
  }

  /**
   * Test {@link ClassPathEntry#isJmod()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isJmod()}
   */
  @Test
  @DisplayName("Test isJmod(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isJmod()"})
  void testIsJmod_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true)
            .isJmod());
  }

  /**
   * Test {@link ClassPathEntry#isZip()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isZip()}
   */
  @Test
  @DisplayName("Test isZip(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isZip()"})
  void testIsZip_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isZip());
  }

  /**
   * Test {@link ClassPathEntry#isZip()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isZip()}
   */
  @Test
  @DisplayName("Test isZip(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isZip()"})
  void testIsZip_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true)
            .isZip());
  }

  /**
   * Test {@link ClassPathEntry#isFiltered()}.
   *
   * <p>Method under test: {@link ClassPathEntry#isFiltered()}
   */
  @Test
  @DisplayName("Test isFiltered()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isFiltered()"})
  void testIsFiltered() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act and Assert
    assertTrue(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#isFiltered()}.
   *
   * <p>Method under test: {@link ClassPathEntry#isFiltered()}
   */
  @Test
  @DisplayName("Test isFiltered()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isFiltered()"})
  void testIsFiltered2() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setApkFilter(filter);

    // Act and Assert
    assertTrue(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#isFiltered()}.
   *
   * <p>Method under test: {@link ClassPathEntry#isFiltered()}
   */
  @Test
  @DisplayName("Test isFiltered()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isFiltered()"})
  void testIsFiltered3() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setAabFilter(filter);

    // Act and Assert
    assertTrue(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#isFiltered()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#isFiltered()}
   */
  @Test
  @DisplayName("Test isFiltered(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPathEntry.isFiltered()"})
  void testIsFiltered_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  @DisplayName("Test setFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setFilter(List)"})
  void testSetFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getFilter());
  }

  /**
   * Test {@link ClassPathEntry#setFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  @DisplayName("Test setFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setFilter(List)"})
  void testSetFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getFilter());
  }

  /**
   * Test {@link ClassPathEntry#setFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  @DisplayName("Test setFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setFilter(List)"})
  void testSetFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  @DisplayName("Test setFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setFilter(List)"})
  void testSetFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setApkFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  @DisplayName("Test setApkFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setApkFilter(List)"})
  void testSetApkFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setApkFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getApkFilter());
  }

  /**
   * Test {@link ClassPathEntry#setApkFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  @DisplayName("Test setApkFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setApkFilter(List)"})
  void testSetApkFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setApkFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getApkFilter());
  }

  /**
   * Test {@link ClassPathEntry#setApkFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  @DisplayName("Test setApkFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setApkFilter(List)"})
  void testSetApkFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setApkFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setApkFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  @DisplayName("Test setApkFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setApkFilter(List)"})
  void testSetApkFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setApkFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setAabFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  @DisplayName("Test setAabFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAabFilter(List)"})
  void testSetAabFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setAabFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getAabFilter());
  }

  /**
   * Test {@link ClassPathEntry#setAabFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  @DisplayName("Test setAabFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAabFilter(List)"})
  void testSetAabFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setAabFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getAabFilter());
  }

  /**
   * Test {@link ClassPathEntry#setAabFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  @DisplayName("Test setAabFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAabFilter(List)"})
  void testSetAabFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAabFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setAabFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  @DisplayName("Test setAabFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAabFilter(List)"})
  void testSetAabFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAabFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setJarFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  @DisplayName("Test setJarFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJarFilter(List)"})
  void testSetJarFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setJarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getJarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setJarFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  @DisplayName("Test setJarFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJarFilter(List)"})
  void testSetJarFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setJarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getJarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setJarFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  @DisplayName("Test setJarFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJarFilter(List)"})
  void testSetJarFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJarFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setJarFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  @DisplayName("Test setJarFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJarFilter(List)"})
  void testSetJarFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJarFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setAarFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  @DisplayName("Test setAarFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAarFilter(List)"})
  void testSetAarFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setAarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getAarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setAarFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  @DisplayName("Test setAarFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAarFilter(List)"})
  void testSetAarFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setAarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getAarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setAarFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  @DisplayName("Test setAarFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAarFilter(List)"})
  void testSetAarFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAarFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setAarFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  @DisplayName("Test setAarFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setAarFilter(List)"})
  void testSetAarFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAarFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setWarFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  @DisplayName("Test setWarFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setWarFilter(List)"})
  void testSetWarFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setWarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getWarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setWarFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  @DisplayName("Test setWarFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setWarFilter(List)"})
  void testSetWarFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setWarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getWarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setWarFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  @DisplayName("Test setWarFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setWarFilter(List)"})
  void testSetWarFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setWarFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setWarFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  @DisplayName("Test setWarFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setWarFilter(List)"})
  void testSetWarFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setWarFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setEarFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  @DisplayName("Test setEarFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setEarFilter(List)"})
  void testSetEarFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setEarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getEarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setEarFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  @DisplayName("Test setEarFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setEarFilter(List)"})
  void testSetEarFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setEarFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getEarFilter());
  }

  /**
   * Test {@link ClassPathEntry#setEarFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  @DisplayName("Test setEarFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setEarFilter(List)"})
  void testSetEarFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setEarFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setEarFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  @DisplayName("Test setEarFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setEarFilter(List)"})
  void testSetEarFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setEarFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setJmodFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  @DisplayName("Test setJmodFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJmodFilter(List)"})
  void testSetJmodFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setJmodFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getJmodFilter());
  }

  /**
   * Test {@link ClassPathEntry#setJmodFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  @DisplayName("Test setJmodFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJmodFilter(List)"})
  void testSetJmodFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setJmodFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getJmodFilter());
  }

  /**
   * Test {@link ClassPathEntry#setJmodFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  @DisplayName("Test setJmodFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJmodFilter(List)"})
  void testSetJmodFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJmodFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setJmodFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  @DisplayName("Test setJmodFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setJmodFilter(List)"})
  void testSetJmodFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJmodFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setZipFilter(List)}.
   *
   * <p>Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  @DisplayName("Test setZipFilter(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setZipFilter(List)"})
  void testSetZipFilter() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    // Act
    classPathEntry.setZipFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getZipFilter());
  }

  /**
   * Test {@link ClassPathEntry#setZipFilter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  @DisplayName("Test setZipFilter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setZipFilter(List)"})
  void testSetZipFilter_given42_whenArrayListAdd42() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ArrayList<String> filter = new ArrayList<>();
    filter.add("42");
    filter.add("foo");

    // Act
    classPathEntry.setZipFilter(filter);

    // Assert
    assertTrue(classPathEntry.isFiltered());
    assertSame(filter, classPathEntry.getZipFilter());
  }

  /**
   * Test {@link ClassPathEntry#setZipFilter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  @DisplayName("Test setZipFilter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setZipFilter(List)"})
  void testSetZipFilter_whenArrayList() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setZipFilter(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#setZipFilter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  @DisplayName("Test setZipFilter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPathEntry.setZipFilter(List)"})
  void testSetZipFilter_whenNull() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setZipFilter(null);

    // Assert that nothing has changed
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;;foo)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString2() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add(";");
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;;';',foo)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString3() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add(")");
    filter.add(";");
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;;')',';',foo)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString4() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("(");
    filter.add(")");
    filter.add(";");
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;;'(',')',';',foo)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString5() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;;'')");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString6() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setApkFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;foo;;;;;;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString7() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setAabFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;foo;;;;;;;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString8() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setJarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;;foo;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString9() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setAarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(foo;;;;;;;;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString10() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setWarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;;foo;;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString11() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setEarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "(;;;;;foo;;;)");
    assertEquals(expectedToStringResult, actualToStringResult);
  }

  /**
   * Test {@link ClassPathEntry#toString()}.
   *
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir} is array of {@link String} with {@code
   *       test.txt} toString.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return Property is 'java.io.tmpdir' is array of String with 'test.txt' toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPathEntry.toString()"})
  void testToString_thenReturnPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToString() {
    // Arrange, Act and Assert
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .toString());
  }
}
