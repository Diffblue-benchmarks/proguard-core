package proguard.resources.file.visitor;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.file.FilePool;
import proguard.resources.file.ResourceFile;
import proguard.resources.file.ResourceFilePool;
import proguard.resources.kotlinmodule.KotlinModule;
import proguard.resources.kotlinmodule.visitor.KotlinModulePrinter;

class ResourceFilePresenceFilterDiffblueTest {
  /**
   * Test {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName("Test visitResourceFile(ResourceFile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testVisitResourceFile() {
    // Arrange
    ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
    resourceFiles.add(new ResourceFile("foo.txt", 3L));
    ResourceFilePool filePool = new ResourceFilePool(resourceFiles);
    ResourceFilePool filePool2 = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter presentResourceFileVisitor2 =
        new ResourceFilePresenceFilter(
            (FilePool) filePool2, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());

    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor2,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    ResourceFile resourceFile = mock(ResourceFile.class);
    when(resourceFile.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitResourceFile(resourceFile);

    // Assert
    verify(resourceFile, atLeast(1)).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName("Test visitResourceFile(ResourceFile); then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testVisitResourceFile_thenCallsAccept() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ArrayList<>());
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitResourceFile(resourceFile);

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#getFileName()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName("Test visitResourceFile(ResourceFile); then calls getFileName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testVisitResourceFile_thenCallsGetFileName() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());
    ResourceFile resourceFile = mock(ResourceFile.class);
    when(resourceFile.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitResourceFile(resourceFile);

    // Assert
    verify(resourceFile).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule2() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, new ResourceJavaReferenceCleaner(), null);
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule3() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new KotlinModulePrinter());
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule4() {
    // Arrange
    ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
    resourceFiles.add(new ResourceFile("foo.txt", 3L));
    ResourceFilePool filePool = new ResourceFilePool(resourceFiles);
    ResourceFilePool filePool2 = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter presentResourceFileVisitor2 =
        new ResourceFilePresenceFilter(
            (FilePool) filePool2, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());

    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor2,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule, atLeast(1)).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule5() {
    // Arrange
    ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
    resourceFiles.add(new ResourceFile("foo.txt", 3L));
    ResourceFilePool filePool = new ResourceFilePool(resourceFiles);
    ResourceFilePool filePool2 = new ResourceFilePool();
    ResourceFilePresenceFilter presentResourceFileVisitor =
        new ResourceFilePresenceFilter(
            (FilePool) filePool2, new ResourceJavaReferenceCleaner(), null);

    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule, atLeast(1)).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule6() {
    // Arrange
    ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
    resourceFiles.add(new ResourceFile("foo.txt", 3L));
    ResourceFilePool filePool = new ResourceFilePool(resourceFiles);
    ResourceFilePool filePool2 = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter presentResourceFileVisitor2 =
        new ResourceFilePresenceFilter(
            (FilePool) filePool2, presentResourceFileVisitor, new KotlinModulePrinter());

    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor2,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule, atLeast(1)).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <ul>
   *   <li>Given {@link ResourceFile#ResourceFile(String, long)} with fileName is {@code foo.txt}
   *       and fileSize is three.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModule(KotlinModule); given ResourceFile(String, long) with fileName is 'foo.txt' and fileSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule_givenResourceFileWithFileNameIsFooTxtAndFileSizeIsThree() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());
    KotlinModule kotlinModule = mock(KotlinModule.class);
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).getFileName();
  }

  /**
   * Test {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinModule#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName("Test visitKotlinModule(KotlinModule); then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFilePresenceFilter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule_thenCallsAccept() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ArrayList<>());
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool,
            presentResourceFileVisitor,
            new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner()));
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).accept(Mockito.<ResourceFileVisitor>any());
    when(kotlinModule.getFileName()).thenReturn("foo.txt");

    // Act
    resourceFilePresenceFilter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).getFileName();
    verify(kotlinModule).accept(isA(ResourceFileVisitor.class));
  }

  /**
   * Test {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}.
   *
   * <ul>
   *   <li>Given {@link ResourceFile#ResourceFile(String, long)} with fileName is {@code foo.txt}
   *       and fileSize is three.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test resourceFileVisitor(ResourceFile); given ResourceFile(String, long) with fileName is 'foo.txt' and fileSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.resources.file.visitor.ResourceFileVisitor proguard.resources.file.visitor.ResourceFilePresenceFilter.resourceFileVisitor(proguard.resources.file.ResourceFile)"
  })
  void testResourceFileVisitor_givenResourceFileWithFileNameIsFooTxtAndFileSizeIsThree() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult =
        resourceFilePresenceFilter.resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(presentResourceFileVisitor, actualResourceFileVisitorResult);
  }

  /**
   * Test {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}.
   *
   * <ul>
   *   <li>Then return {@link ResourceJavaReferenceCleaner}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  @DisplayName("Test resourceFileVisitor(ResourceFile); then return ResourceJavaReferenceCleaner")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.resources.file.visitor.ResourceFileVisitor proguard.resources.file.visitor.ResourceFilePresenceFilter.resourceFileVisitor(proguard.resources.file.ResourceFile)"
  })
  void testResourceFileVisitor_thenReturnResourceJavaReferenceCleaner() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceJavaReferenceCleaner missingResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, missingResourceFileVisitor);

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult =
        resourceFilePresenceFilter.resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(missingResourceFileVisitor, actualResourceFileVisitorResult);
  }
}
