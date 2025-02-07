package proguard.resources.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.file.visitor.MultiResourceFileVisitor;
import proguard.resources.file.visitor.ResourceFileVisitor;
import proguard.resources.file.visitor.ResourceJavaReferenceCleaner;
import proguard.resources.kotlinmodule.visitor.KotlinModulePrinter;
import proguard.util.StringMatcher;

class ResourceFilePoolDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceFilePool#ResourceFilePool()}
   *   <li>{@link ResourceFilePool#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.<init>()",
    "java.lang.String proguard.resources.file.ResourceFilePool.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool();

    // Assert
    assertEquals("{}", actualResourceFilePool.toString());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#ResourceFilePool(ResourceFile[])}.
   *
   * <ul>
   *   <li>Then return {@link ResourceFilePool#resourceFileMap} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#ResourceFilePool(ResourceFile[])}
   */
  @Test
  @DisplayName("Test new ResourceFilePool(ResourceFile[]); then return resourceFileMap size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.<init>(proguard.resources.file.ResourceFile[])"
  })
  void testNewResourceFilePool_thenReturnResourceFileMapSizeIsOne() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool(resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = actualResourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, actualResourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#ResourceFilePool(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#ResourceFilePool(Iterable)}
   */
  @Test
  @DisplayName("Test new ResourceFilePool(Iterable); when ArrayList(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.resources.file.ResourceFilePool.<init>(java.lang.Iterable)"})
  void testNewResourceFilePool_whenArrayList_thenReturnSizeIsZero() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool(new ArrayList<>());

    // Assert
    assertEquals(0, actualResourceFilePool.size());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#addResourceFile(String, ResourceFile)} with {@code fileName},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ResourceFilePool#addResourceFile(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test addResourceFile(String, ResourceFile) with 'fileName', 'resourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.addResourceFile(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testAddResourceFileWithFileNameResourceFile() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    resourceFilePool.addResourceFile("foo.txt", resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = resourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, resourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#addResourceFile(ResourceFile)} with {@code resourceFile}.
   *
   * <ul>
   *   <li>Then {@link ResourceFilePool#ResourceFilePool()} {@link ResourceFilePool#resourceFileMap}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#addResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addResourceFile(ResourceFile) with 'resourceFile'; then ResourceFilePool() resourceFileMap size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.addResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testAddResourceFileWithResourceFile_thenResourceFilePoolResourceFileMapSizeIsOne() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    resourceFilePool.addResourceFile(resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = resourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, resourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#getResourceFile(String)}.
   *
   * <p>Method under test: {@link ResourceFilePool#getResourceFile(String)}
   */
  @Test
  @DisplayName("Test getResourceFile(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.resources.file.ResourceFile proguard.resources.file.ResourceFilePool.getResourceFile(java.lang.String)"
  })
  void testGetResourceFile() {
    // Arrange, Act and Assert
    assertNull((new ResourceFilePool()).getResourceFile("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#size()}.
   *
   * <p>Method under test: {@link ResourceFilePool#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.resources.file.ResourceFilePool.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ResourceFilePool()).size());
  }

  /**
   * Test {@link ResourceFilePool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Given {@link ResourceFilePool#ResourceFilePool()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  @DisplayName("Test refreshedCopy(); given ResourceFilePool(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.resources.file.ResourceFilePool proguard.resources.file.ResourceFilePool.refreshedCopy()"
  })
  void testRefreshedCopy_givenResourceFilePool_thenReturnSizeIsZero() {
    // Arrange and Act
    ResourceFilePool actualRefreshedCopyResult = (new ResourceFilePool()).refreshedCopy();

    // Assert
    assertEquals(0, actualRefreshedCopyResult.size());
    assertTrue(actualRefreshedCopyResult.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  @DisplayName("Test refreshedCopy(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.resources.file.ResourceFilePool proguard.resources.file.ResourceFilePool.refreshedCopy()"
  })
  void testRefreshedCopy_thenReturnSizeIsOne() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));

    // Act
    ResourceFilePool actualRefreshedCopyResult = resourceFilePool.refreshedCopy();

    // Assert
    assertEquals(1, actualRefreshedCopyResult.size());
    assertEquals(resourceFilePool.resourceFileMap, actualRefreshedCopyResult.resourceFileMap);
  }

  /**
   * Test {@link ResourceFilePool#resourceFileNames()}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFileNames()}
   */
  @Test
  @DisplayName("Test resourceFileNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.resources.file.ResourceFilePool.resourceFileNames()"})
  void testResourceFileNames() {
    // Arrange, Act and Assert
    assertTrue((new ResourceFilePool()).resourceFileNames().isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(List, ResourceFileVisitor)} with {@code List},
   * {@code ResourceFileVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(List, ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(List, ResourceFileVisitor) with 'List', 'ResourceFileVisitor'; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(java.util.List, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithListResourceFileVisitor_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);
    ArrayList<String> fileNameFilter = new ArrayList<>();

    // Act
    resourceFilePool.resourceFilesAccept(fileNameFilter, new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(List, ResourceFileVisitor)} with {@code List},
   * {@code ResourceFileVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#getFileName()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(List, ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(List, ResourceFileVisitor) with 'List', 'ResourceFileVisitor'; then calls getFileName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(java.util.List, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithListResourceFileVisitor_thenCallsGetFileName() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);

    ArrayList<String> fileNameFilter = new ArrayList<>();
    fileNameFilter.add("foo");

    // Act
    resourceFilePool.resourceFilesAccept(fileNameFilter, new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).getFileName();
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(ResourceFileVisitor)} with {@code
   * ResourceFileVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(ResourceFileVisitor) with 'ResourceFileVisitor'; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithResourceFileVisitor_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);

    // Act
    resourceFilePool.resourceFilesAccept(new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);

    // Act
    resourceFilePool.resourceFilesAccept(fileNameFilter, new ResourceJavaReferenceCleaner());

    // Assert
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor2() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ResourceFilePool resourceFilePool =
        new ResourceFilePool(resourceFile, new ResourceFile("foo.txt", 3L));
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);

    // Act
    resourceFilePool.resourceFilesAccept(
        fileNameFilter, new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));

    // Assert
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor3() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ResourceFilePool resourceFilePool =
        new ResourceFilePool(resourceFile, new ResourceFile("foo.txt", 3L));
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);

    // Act
    resourceFilePool.resourceFilesAccept(
        fileNameFilter, new MultiResourceFileVisitor(new KotlinModulePrinter()));

    // Assert
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor4() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ResourceFilePool resourceFilePool =
        new ResourceFilePool(resourceFile, new ResourceFile("foo.txt", 3L));
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);

    // Act
    resourceFilePool.resourceFilesAccept(fileNameFilter, new MultiResourceFileVisitor());

    // Assert
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor5() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ResourceFilePool resourceFilePool =
        new ResourceFilePool(resourceFile, new ResourceFile("foo.txt", 3L));
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);
    ResourceJavaReferenceCleaner resourceJavaReferenceCleaner = new ResourceJavaReferenceCleaner();

    // Act
    resourceFilePool.resourceFilesAccept(
        fileNameFilter,
        new MultiResourceFileVisitor(
            resourceJavaReferenceCleaner, new ResourceJavaReferenceCleaner()));

    // Assert
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(StringMatcher, ResourceFileVisitor)} with
   * {@code StringMatcher}, {@code ResourceFileVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(StringMatcher,
   * ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(StringMatcher, ResourceFileVisitor) with 'StringMatcher', 'ResourceFileVisitor'; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(proguard.util.StringMatcher, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringMatcherResourceFileVisitor_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);
    StringMatcher fileNameFilter = mock(StringMatcher.class);
    when(fileNameFilter.matches(Mockito.<String>any())).thenReturn(true);

    // Act
    resourceFilePool.resourceFilesAccept(fileNameFilter, new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
    verify(fileNameFilter).matches(eq("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#resourceFilesAccept(String, ResourceFileVisitor)} with {@code
   * String}, {@code ResourceFileVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFilesAccept(String, ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFilesAccept(String, ResourceFileVisitor) with 'String', 'ResourceFileVisitor'; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.ResourceFilePool.resourceFilesAccept(java.lang.String, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFilesAcceptWithStringResourceFileVisitor_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);

    // Act
    resourceFilePool.resourceFilesAccept("foo.txt", new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
  }
}
