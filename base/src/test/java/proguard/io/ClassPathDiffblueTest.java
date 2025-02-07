package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassPath.<init>(proguard.io.ClassPathEntry[])"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.hasOutput()"})
  void testHasOutput_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false)))
            .hasOutput());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.hasOutput()"})
  void testHasOutput_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .hasOutput());
  }

  /**
   * Test {@link ClassPath#getClassPathEntries()}.
   *
   * <p>Method under test: {@link ClassPath#getClassPathEntries()}
   */
  @Test
  @DisplayName("Test getClassPathEntries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.io.ClassPath.getClassPathEntries()"})
  void testGetClassPathEntries() {
    // Arrange
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    List<ClassPathEntry> actualClassPathEntries =
        (new ClassPath(classPathEntry)).getClassPathEntries();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassPath.clear()"})
  void testClear() {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.add(proguard.io.ClassPathEntry)"})
  void testAddWithClassPathEntry() {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    boolean actualAddResult = classPath.add(classPathEntry);

    // Assert
    List<ClassPathEntry> classPathEntries = classPath.getClassPathEntries();
    assertEquals(2, classPathEntries.size());
    assertEquals(2, classPath.size());
    assertTrue(actualAddResult);
    assertSame(classPathEntry, classPathEntries.get(1));
  }

  /**
   * Test {@link ClassPath#add(int, ClassPathEntry)} with {@code index}, {@code classPathEntry}.
   *
   * <p>Method under test: {@link ClassPath#add(int, ClassPathEntry)}
   */
  @Test
  @DisplayName("Test add(int, ClassPathEntry) with 'index', 'classPathEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassPath.add(int, proguard.io.ClassPathEntry)"})
  void testAddWithIndexClassPathEntry() {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPath.add(1, classPathEntry);

    // Assert
    List<ClassPathEntry> classPathEntries = classPath.getClassPathEntries();
    assertEquals(2, classPathEntries.size());
    assertEquals(2, classPath.size());
    assertSame(classPathEntry, classPathEntries.get(1));
  }

  /**
   * Test {@link ClassPath#addAll(ClassPath)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#addAll(ClassPath)}
   */
  @Test
  @DisplayName("Test addAll(ClassPath); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.addAll(proguard.io.ClassPath)"})
  void testAddAll_thenReturnFalse() {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(classPath.addAll(new ClassPath()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.addAll(proguard.io.ClassPath)"})
  void testAddAll_thenReturnTrue() {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertTrue(
        classPath.addAll(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPath#get(int)}.
   *
   * <p>Method under test: {@link ClassPath#get(int)}
   */
  @Test
  @DisplayName("Test get(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.ClassPathEntry proguard.io.ClassPath.get(int)"})
  void testGet() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertSame(classPathEntry2, (new ClassPath(classPathEntry, classPathEntry2)).get(1));
  }

  /**
   * Test {@link ClassPath#remove(int)}.
   *
   * <p>Method under test: {@link ClassPath#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.ClassPathEntry proguard.io.ClassPath.remove(int)"})
  void testRemove() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry2 =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry, classPathEntry2);

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
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .isEmpty());
  }

  /**
   * Test {@link ClassPath#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ClassPath.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertTrue((new ClassPath()).isEmpty());
  }

  /**
   * Test {@link ClassPath#size()}.
   *
   * <p>Method under test: {@link ClassPath#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.io.ClassPath.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .size());
  }
}
