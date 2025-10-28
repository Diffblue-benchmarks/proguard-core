package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

public class ClassPathDiffblueTest {
  /**
   * Method under test: {@link ClassPath#hasOutput()}
   */
  @Test
  public void testHasOutput() {
    // Arrange, Act and Assert
    assertTrue(
        (new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .hasOutput());
    assertFalse(
        (new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false)))
            .hasOutput());
  }

  /**
   * Method under test: {@link ClassPath#getClassPathEntries()}
   */
  @Test
  public void testGetClassPathEntries() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    List<ClassPathEntry> actualClassPathEntries = (new ClassPath(classPathEntry)).getClassPathEntries();

    // Assert
    assertEquals(1, actualClassPathEntries.size());
    assertSame(classPathEntry, actualClassPathEntries.get(0));
  }

  /**
   * Method under test: {@link ClassPath#clear()}
   */
  @Test
  public void testClear() {
    // Arrange
    ClassPath classPath = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act
    classPath.clear();

    // Assert
    assertEquals(0, classPath.size());
    assertTrue(classPath.getClassPathEntries().isEmpty());
    assertTrue(classPath.isEmpty());
  }

  /**
   * Method under test: {@link ClassPath#add(int, ClassPathEntry)}
   */
  @Test
  public void testAdd() {
    // Arrange
    ClassPath classPath = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPath#add(ClassPathEntry)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ClassPath classPath = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPath#addAll(ClassPath)}
   */
  @Test
  public void testAddAll() {
    // Arrange
    ClassPath classPath = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertTrue(classPath.addAll(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Method under test: {@link ClassPath#addAll(ClassPath)}
   */
  @Test
  public void testAddAll2() {
    // Arrange
    ClassPath classPath = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(classPath.addAll(new ClassPath()));
  }

  /**
   * Method under test: {@link ClassPath#get(int)}
   */
  @Test
  public void testGet() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry2 = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertSame(classPathEntry2, (new ClassPath(classPathEntry, classPathEntry2)).get(1));
  }

  /**
   * Method under test: {@link ClassPath#remove(int)}
   */
  @Test
  public void testRemove() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry2 = new ClassPathEntry(
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
   * Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .isEmpty());
  }

  /**
   * Method under test: {@link ClassPath#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertTrue((new ClassPath()).isEmpty());
  }

  /**
   * Method under test: {@link ClassPath#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .size());
  }

  /**
   * Method under test: {@link ClassPath#ClassPath(ClassPathEntry[])}
   */
  @Test
  public void testNewClassPath() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
}
