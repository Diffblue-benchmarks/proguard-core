package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassPathDiffblueTest {
  /**
   * Test {@link ClassPath#ClassPath(ClassPathEntry[])}.
   *
   * <p>Method under test: {@link ClassPath#ClassPath(ClassPathEntry[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPath.<init>(ClassPathEntry[])"})
  public void testNewClassPath() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.hasOutput()"})
  public void testHasOutput_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.hasOutput()"})
  public void testHasOutput_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ClassPath.getClassPathEntries()"})
  public void testGetClassPathEntries() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPath.clear()"})
  public void testClear() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.add(ClassPathEntry)"})
  public void testAddWithClassPathEntry() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPath.add(int, ClassPathEntry)"})
  public void testAddWithIndexClassPathEntry() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.addAll(ClassPath)"})
  public void testAddAll_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.addAll(ClassPath)"})
  public void testAddAll_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassPathEntry ClassPath.get(int)"})
  public void testGet() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassPathEntry ClassPath.remove(int)"})
  public void testRemove() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.isEmpty()"})
  public void testIsEmpty_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPath.isEmpty()"})
  public void testIsEmpty_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ClassPath.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)))
            .size());
  }
}
