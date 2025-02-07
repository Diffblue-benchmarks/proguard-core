package proguard.resources.kotlinmodule.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata;
import proguard.resources.kotlinmodule.KotlinModule;
import proguard.resources.kotlinmodule.KotlinModulePackage;
import proguard.resources.kotlinmodule.visitor.KotlinModulePackageVisitor;

class KotlinModuleReferenceInitializerDiffblueTest {
  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModule(KotlinModule)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinModule#modulePackagesAccept(KotlinModulePackageVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleReferenceInitializer#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModule(KotlinModule); then calls modulePackagesAccept(KotlinModulePackageVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule_thenCallsModulePackagesAccept() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).modulePackagesAccept(Mockito.<KotlinModulePackageVisitor>any());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).modulePackagesAccept(isA(KotlinModulePackageVisitor.class));
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage2() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage3() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(
            new LibraryClass(
                1,
                "This Class Name",
                "Super Class Name",
                new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn")));
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    verify(programClassPool).getClass(eq("42"));
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage4() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinFileFacadeKindMetadata(new int[] {1, 0, 1, 0}, 1, "Xs", "Pn"));

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert
    verify(programClassPool).getClass(eq("42"));
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList =
        modulePackage.referencedFileFacades;
    assertEquals(1, kotlinFileFacadeKindMetadataList.size());
    assertSame(libraryClass.kotlinMetadata, kotlinFileFacadeKindMetadataList.get(0));
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage5() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(
            new LibraryClass(
                1,
                "This Class Name",
                "Super Class Name",
                new KotlinMultiFilePartKindMetadata(new int[] {1, 0, 1, 0}, 1, "Xs", "Pn")));
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    verify(programClassPool).getClass(eq("42"));
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage6() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinFileFacadeKindMetadata(new int[] {1, 0, 1, 0}, 1, "Xs", "Pn"));

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("", "");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList =
        modulePackage.referencedFileFacades;
    assertEquals(1, kotlinFileFacadeKindMetadataList.size());
    assertSame(libraryClass.kotlinMetadata, kotlinFileFacadeKindMetadataList.get(0));
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName("Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage7() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinMultiFilePartKindMetadata(new int[] {1, 0, 1, 0}, 1, "Xs", "Pn"));

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("42", "42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(eq("42"));
    Map<String, KotlinMultiFilePartKindMetadata> stringKotlinMultiFilePartKindMetadataMap =
        modulePackage.referencedMultiFileParts;
    assertEquals(1, stringKotlinMultiFilePartKindMetadataMap.size());
    KotlinMetadata expectedGetResult = libraryClass.kotlinMetadata;
    assertSame(expectedGetResult, stringKotlinMultiFilePartKindMetadataMap.get("42"));
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); given ClassPool getClass(String) return LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_givenClassPoolGetClassReturnLibraryClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    verify(programClassPool).getClass(eq("42"));
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); given ClassPool getClass(String) return LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_givenClassPoolGetClassReturnLibraryClass2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("42", "42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    verify(programClassPool, atLeast(1)).getClass(eq("42"));
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_givenEmptyString() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("", "");
    multiFileClassParts.put("42", "42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", new ArrayList<>(), multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_givenFoo_whenArrayListAddFoo() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("foo");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); given 'foo'; when HashMap() 'foo' is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_givenFoo_whenHashMapFooIs42() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("foo", "42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", new ArrayList<>(), multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); when HashMap() '42' is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_whenHashMap42Is42() {
    // Arrange
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("42", "42");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", new ArrayList<>(), multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule,
   * KotlinModulePackage)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinModuleReferenceInitializer#visitKotlinModulePackage(KotlinModule, KotlinModulePackage)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModulePackage(KotlinModule, KotlinModulePackage); when HashMap() 'foo' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.util.KotlinModuleReferenceInitializer.visitKotlinModulePackage(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.KotlinModulePackage)"
  })
  void testVisitKotlinModulePackage_whenHashMapFooIsFoo() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(
            new LibraryClass(
                1,
                "This Class Name",
                "Super Class Name",
                new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn")));
    KotlinModuleReferenceInitializer kotlinModuleReferenceInitializer =
        new KotlinModuleReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);

    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");

    HashMap<String, String> multiFileClassParts = new HashMap<>();
    multiFileClassParts.put("foo", "foo");
    KotlinModulePackage modulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, multiFileClassParts);

    // Act
    kotlinModuleReferenceInitializer.visitKotlinModulePackage(null, modulePackage);

    // Assert that nothing has changed
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    assertEquals(1, modulePackage.referencedFileFacades.size());
    assertTrue(modulePackage.referencedMultiFileParts.isEmpty());
  }
}
