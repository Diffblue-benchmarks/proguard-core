package proguard.io.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.io.ClassPath;
import proguard.io.ClassPathEntry;

public class ClassPathUtilDiffblueTest {
  /**
   * Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  public void testHasAabInput() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
    assertFalse(ClassPathUtil.hasAabInput(null));
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
    assertTrue(ClassPathUtil.hasAabInput(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false))));
  }

  /**
   * Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  public void testHasAabInput2() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath()));
  }

  /**
   * Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  public void testHasAabInput3() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath(classPathEntry,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  public void testIsAndroid() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isAndroid(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
    assertFalse(ClassPathUtil.isAndroid(null));
    assertTrue(ClassPathUtil.isAndroid(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
    assertTrue(ClassPathUtil.isAndroid(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
    assertTrue(ClassPathUtil.isAndroid(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true))));
    assertTrue(ClassPathUtil.isAndroid(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true))));
  }

  /**
   * Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  public void testIsAndroid2() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(new ClassPath()));
  }

  /**
   * Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  public void testIsAndroid3() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(new ClassPath(classPathEntry,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  public void testIsDalvik() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isDalvik(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
    assertFalse(ClassPathUtil.isDalvik(null));
    assertTrue(ClassPathUtil.isDalvik(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
    assertTrue(ClassPathUtil.isDalvik(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
  }

  /**
   * Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  public void testIsDalvik2() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(new ClassPath()));
  }

  /**
   * Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  public void testIsDalvik3() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(new ClassPath(classPathEntry,
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Method under test:
   * {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  public void testDetermineCompressionMethod() {
    // Arrange, Act and Assert
    assertNull(ClassPathUtil.determineCompressionMethod(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
    assertNull(ClassPathUtil.determineCompressionMethod(new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
  }
}
