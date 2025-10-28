package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ClassPathEntryDiffblueTest {
  /**
   * Method under test: {@link ClassPathEntry#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange and Act
    String actualName = (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))
        .getName();

    // Assert
    assertEquals(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), actualName);
  }

  /**
   * Method under test: {@link ClassPathEntry#setFile(File)}
   */
  @Test
  public void testSetFile() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    classPathEntry.setFile(file);

    // Assert
    assertSame(file, classPathEntry.getFile());
  }

  /**
   * Method under test: {@link ClassPathEntry#isDex()}
   */
  @Test
  public void testIsDex() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isDex());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true)).isDex());
  }

  /**
   * Method under test: {@link ClassPathEntry#isApk()}
   */
  @Test
  public void testIsApk() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isApk());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true)).isApk());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".ap_").toFile(), true)).isApk());
  }

  /**
   * Method under test: {@link ClassPathEntry#isAab()}
   */
  @Test
  public void testIsAab() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isAab());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true)).isAab());
  }

  /**
   * Method under test: {@link ClassPathEntry#isJar()}
   */
  @Test
  public void testIsJar() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isJar());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true)).isJar());
  }

  /**
   * Method under test: {@link ClassPathEntry#isAar()}
   */
  @Test
  public void testIsAar() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isAar());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true)).isAar());
  }

  /**
   * Method under test: {@link ClassPathEntry#isWar()}
   */
  @Test
  public void testIsWar() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isWar());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true)).isWar());
  }

  /**
   * Method under test: {@link ClassPathEntry#isEar()}
   */
  @Test
  public void testIsEar() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isEar());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true)).isEar());
  }

  /**
   * Method under test: {@link ClassPathEntry#isJmod()}
   */
  @Test
  public void testIsJmod() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isJmod());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true)).isJmod());
  }

  /**
   * Method under test: {@link ClassPathEntry#isZip()}
   */
  @Test
  public void testIsZip() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isZip());
    assertTrue((new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true)).isZip());
  }

  /**
   * Method under test: {@link ClassPathEntry#isFiltered()}
   */
  @Test
  public void testIsFiltered() {
    // Arrange, Act and Assert
    assertFalse(
        (new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  public void testSetFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  public void testSetFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setFilter(null);

    // Assert
    assertNull(classPathEntry.getFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  public void testSetFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setFilter(List)}
   */
  @Test
  public void testSetFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  public void testSetApkFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setApkFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getApkFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  public void testSetApkFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setApkFilter(null);

    // Assert
    assertNull(classPathEntry.getApkFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  public void testSetApkFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setApkFilter(List)}
   */
  @Test
  public void testSetApkFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  public void testSetAabFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAabFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getAabFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  public void testSetAabFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAabFilter(null);

    // Assert
    assertNull(classPathEntry.getAabFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  public void testSetAabFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setAabFilter(List)}
   */
  @Test
  public void testSetAabFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  public void testSetJarFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJarFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getJarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  public void testSetJarFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJarFilter(null);

    // Assert
    assertNull(classPathEntry.getJarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  public void testSetJarFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setJarFilter(List)}
   */
  @Test
  public void testSetJarFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  public void testSetAarFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAarFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getAarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  public void testSetAarFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setAarFilter(null);

    // Assert
    assertNull(classPathEntry.getAarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  public void testSetAarFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setAarFilter(List)}
   */
  @Test
  public void testSetAarFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  public void testSetWarFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setWarFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getWarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  public void testSetWarFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setWarFilter(null);

    // Assert
    assertNull(classPathEntry.getWarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  public void testSetWarFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setWarFilter(List)}
   */
  @Test
  public void testSetWarFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  public void testSetEarFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setEarFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getEarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  public void testSetEarFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setEarFilter(null);

    // Assert
    assertNull(classPathEntry.getEarFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  public void testSetEarFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setEarFilter(List)}
   */
  @Test
  public void testSetEarFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  public void testSetJmodFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJmodFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getJmodFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  public void testSetJmodFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setJmodFilter(null);

    // Assert
    assertNull(classPathEntry.getJmodFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  public void testSetJmodFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setJmodFilter(List)}
   */
  @Test
  public void testSetJmodFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  public void testSetZipFilter() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setZipFilter(new ArrayList<>());

    // Assert
    assertNull(classPathEntry.getZipFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  public void testSetZipFilter2() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act
    classPathEntry.setZipFilter(null);

    // Assert
    assertNull(classPathEntry.getZipFilter());
    assertFalse(classPathEntry.isFiltered());
  }

  /**
   * Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  public void testSetZipFilter3() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#setZipFilter(List)}
   */
  @Test
  public void testSetZipFilter4() {
    // Arrange
    ClassPathEntry classPathEntry = new ClassPathEntry(
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
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString() {
    // Arrange and Act
    String actualToStringResult = (new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)).toString();

    // Assert
    assertEquals(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;;foo)"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add(";");
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;;';',foo)"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("(");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;;'(')"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add(")");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;;')')"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString6() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;;'')"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString7() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setApkFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;foo;;;;;;)"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString8() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setAabFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;foo;;;;;;;)"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString9() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setJarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(;;;;;;;foo;)"),
        actualToStringResult);
  }

  /**
   * Method under test: {@link ClassPathEntry#toString()}
   */
  @Test
  public void testToString10() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry = new ClassPathEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setAarFilter(filter);

    // Act
    String actualToStringResult = classPathEntry.toString();

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(), "(foo;;;;;;;;)"),
        actualToStringResult);
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    ClassPathEntry actualClassPathEntry = new ClassPathEntry(file, true);
    actualClassPathEntry.setFeatureName("Feature Name");
    actualClassPathEntry.setOutput(true);
    actualClassPathEntry.getAabFilter();
    actualClassPathEntry.getAarFilter();
    actualClassPathEntry.getApkFilter();
    actualClassPathEntry.getEarFilter();
    String actualFeatureName = actualClassPathEntry.getFeatureName();
    File actualFile = actualClassPathEntry.getFile();
    actualClassPathEntry.getFilter();
    actualClassPathEntry.getJarFilter();
    actualClassPathEntry.getJmodFilter();
    actualClassPathEntry.getWarFilter();
    actualClassPathEntry.getZipFilter();

    // Assert that nothing has changed
    assertEquals("Feature Name", actualFeatureName);
    assertTrue(actualClassPathEntry.isOutput());
    assertSame(file, actualFile);
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters2() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    ClassPathEntry actualClassPathEntry = new ClassPathEntry(file, true, "Feature Name");
    actualClassPathEntry.setFeatureName("Feature Name");
    actualClassPathEntry.setOutput(true);
    actualClassPathEntry.getAabFilter();
    actualClassPathEntry.getAarFilter();
    actualClassPathEntry.getApkFilter();
    actualClassPathEntry.getEarFilter();
    String actualFeatureName = actualClassPathEntry.getFeatureName();
    File actualFile = actualClassPathEntry.getFile();
    actualClassPathEntry.getFilter();
    actualClassPathEntry.getJarFilter();
    actualClassPathEntry.getJmodFilter();
    actualClassPathEntry.getWarFilter();
    actualClassPathEntry.getZipFilter();

    // Assert that nothing has changed
    assertEquals("Feature Name", actualFeatureName);
    assertTrue(actualClassPathEntry.isOutput());
    assertSame(file, actualFile);
  }
}
