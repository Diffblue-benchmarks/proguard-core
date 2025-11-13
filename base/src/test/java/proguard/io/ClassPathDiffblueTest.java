package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassPathDiffblueTest {
  /**
   * Test {@link ClassPath#ClassPath(ClassPathEntry[])}.
   *
   * <p>Method under test: {@link ClassPath#ClassPath(ClassPathEntry[])}
   */
  @Test
  @DisplayName("Test new ClassPath(ClassPathEntry[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPath.<init>(ClassPathEntry[])"})
  void testNewClassPath() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    ClassPath actualClassPath = new ClassPath(classPathEntry);

    // Assert
    List<ClassPathEntry> classPathEntries = actualClassPath.getClassPathEntries();
    assertEquals(1, classPathEntries.size());
    assertEquals(1, actualClassPath.size());
    assertFalse(actualClassPath.isEmpty());
    assertSame(classPathEntry, classPathEntries.get(0));
  }

  /**
   * Test {@link ClassPath#hasOutput()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#hasOutput()}
   */
  @Test
  @DisplayName("Test hasOutput(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.hasOutput()"})
  void testHasOutput_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false);

    // Act and Assert
    assertFalse(new ClassPath(classPathEntry).hasOutput());
  }

  /**
   * Test {@link ClassPath#hasOutput()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#hasOutput()}
   */
  @Test
  @DisplayName("Test hasOutput(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.hasOutput()"})
  void testHasOutput_thenReturnTrue() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertTrue(new ClassPath(classPathEntry).hasOutput());
  }

  /**
   * Test {@link ClassPath#getClassPathEntries()}.
   *
   * <p>Method under test: {@link ClassPath#getClassPathEntries()}
   */
  @Test
  @DisplayName("Test getClassPathEntries()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassPath.getClassPathEntries()"})
  void testGetClassPathEntries() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    List<ClassPathEntry> actualClassPathEntries =
        new ClassPath(classPathEntry).getClassPathEntries();

    // Assert
    assertEquals(1, actualClassPathEntries.size());
    assertSame(classPathEntry, actualClassPathEntries.get(0));
  }

  /**
   * Test {@link ClassPath#clear()}.
   *
   * <p>Method under test: {@link ClassPath#clear()}
   */
  @Test
  @DisplayName("Test clear()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPath.clear()"})
  void testClear() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);

    // Act
    classPath.clear();

    // Assert
    assertEquals(0, classPath.size());
    assertTrue(classPath.getClassPathEntries().isEmpty());
    assertTrue(classPath.isEmpty());
  }

  /**
   * Test {@link ClassPath#add(ClassPathEntry)} with {@code classPathEntry}.
   *
   * <p>Method under test: {@link ClassPath#add(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test add(ClassPathEntry) with 'classPathEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.add(ClassPathEntry)"})
  void testAddWithClassPathEntry() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);
    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    boolean actualAddResult = classPath.add(classPathEntry2);

    // Assert
    List<ClassPathEntry> classPathEntries = classPath.getClassPathEntries();
    assertEquals(2, classPathEntries.size());
    assertEquals(2, classPath.size());
    assertTrue(actualAddResult);
    assertSame(classPathEntry2, classPathEntries.get(1));
  }

  /**
   * Test {@link ClassPath#add(int, ClassPathEntry)} with {@code index}, {@code classPathEntry}.
   *
   * <p>Method under test: {@link ClassPath#add(int, ClassPathEntry)}
   */
  @Test
  @DisplayName("Test add(int, ClassPathEntry) with 'index', 'classPathEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassPath.add(int, ClassPathEntry)"})
  void testAddWithIndexClassPathEntry() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);
    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPath.add(1, classPathEntry2);

    // Assert
    List<ClassPathEntry> classPathEntries = classPath.getClassPathEntries();
    assertEquals(2, classPathEntries.size());
    assertEquals(2, classPath.size());
    assertSame(classPathEntry2, classPathEntries.get(1));
  }

  /**
   * Test {@link ClassPath#addAll(ClassPath)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#addAll(ClassPath)}
   */
  @Test
  @DisplayName("Test addAll(ClassPath); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.addAll(ClassPath)"})
  void testAddAll_thenReturnTrue() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);
    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    boolean actualAddAllResult = classPath.addAll(new ClassPath(classPathEntry2));

    // Assert
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link ClassPath#addAll(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#addAll(ClassPath)}
   */
  @Test
  @DisplayName("Test addAll(ClassPath); when ClassPath(ClassPathEntry[]); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.addAll(ClassPath)"})
  void testAddAll_whenClassPath_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertFalse(classPath.addAll(new ClassPath()));
  }

  /**
   * Test {@link ClassPath#get(int)}.
   *
   * <p>Method under test: {@link ClassPath#get(int)}
   */
  @Test
  @DisplayName("Test get(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPathEntry ClassPath.get(int)"})
  void testGet() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPath.add(1, classPathEntry2);

    // Act and Assert
    assertSame(classPathEntry2, classPath.get(1));
  }

  /**
   * Test {@link ClassPath#remove(int)}.
   *
   * <ul>
   *   <li>Then {@link ClassPath#ClassPath(ClassPathEntry[])} with entries is {@link
   *       ClassPathEntry#ClassPathEntry(File, boolean)} ClassPathEntries size is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); then ClassPath(ClassPathEntry[]) with entries is ClassPathEntry(File, boolean) ClassPathEntries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPathEntry ClassPath.remove(int)"})
  void testRemove_thenClassPathWithEntriesIsClassPathEntryClassPathEntriesSizeIsOne() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPath.add(1, classPathEntry2);

    // Act
    ClassPathEntry actualRemoveResult = classPath.remove(1);

    // Assert
    assertEquals(1, classPath.getClassPathEntries().size());
    assertEquals(1, classPath.size());
    assertSame(classPathEntry2, actualRemoveResult);
  }

  /**
   * Test {@link ClassPath#isEmpty()}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code
   *       test.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given Property is 'java.io.tmpdir' is array of String with 'test.txt'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.isEmpty()"})
  void testIsEmpty_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxt_thenReturnTrue() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertTrue(new ClassPath().isEmpty());
  }

  /**
   * Test {@link ClassPath#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassPath.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(new ClassPath(classPathEntry).isEmpty());
  }

  /**
   * Test {@link ClassPath#size()}.
   *
   * <p>Method under test: {@link ClassPath#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ClassPath.size()"})
  void testSize() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertEquals(1, new ClassPath(classPathEntry).size());
  }
}
