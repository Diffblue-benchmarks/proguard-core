package proguard.resources.kotlinmodule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;
import proguard.resources.kotlinmodule.visitor.KotlinModulePackageVisitor;

class KotlinModulePackageDiffblueTest {
  /**
   * Test {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link KotlinModulePackage#fileFacadeNames} size is two.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new KotlinModulePackage(String, List, Map); given '42'; then return fileFacadeNames size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.KotlinModulePackage.<init>(java.lang.String, java.util.List, java.util.Map)"
  })
  void testNewKotlinModulePackage_given42_thenReturnFileFacadeNamesSizeIsTwo() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    fileFacadeNames.add("foo");

    // Act
    KotlinModulePackage actualKotlinModulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Assert
    List<String> stringList = actualKotlinModulePackage.fileFacadeNames;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList =
        actualKotlinModulePackage.referencedFileFacades;
    assertEquals(2, kotlinFileFacadeKindMetadataList.size());
    assertNull(kotlinFileFacadeKindMetadataList.get(1));
  }

  /**
   * Test {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link KotlinModulePackage#fileFacadeNames} size is one.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new KotlinModulePackage(String, List, Map); given 'foo'; then return fileFacadeNames size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.KotlinModulePackage.<init>(java.lang.String, java.util.List, java.util.Map)"
  })
  void testNewKotlinModulePackage_givenFoo_thenReturnFileFacadeNamesSizeIsOne() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("foo");

    // Act
    KotlinModulePackage actualKotlinModulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Assert
    List<String> stringList = actualKotlinModulePackage.fileFacadeNames;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList =
        actualKotlinModulePackage.referencedFileFacades;
    assertEquals(1, kotlinFileFacadeKindMetadataList.size());
    assertNull(kotlinFileFacadeKindMetadataList.get(0));
  }

  /**
   * Test {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Fq Name}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new KotlinModulePackage(String, List, Map); when ArrayList(); then return 'Fq Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.KotlinModulePackage.<init>(java.lang.String, java.util.List, java.util.Map)"
  })
  void testNewKotlinModulePackage_whenArrayList_thenReturnFqName() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();

    // Act
    KotlinModulePackage actualKotlinModulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());

    // Assert
    assertEquals("Fq Name", actualKotlinModulePackage.fqName);
    assertTrue(actualKotlinModulePackage.fileFacadeNames.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedFileFacades.isEmpty());
    assertTrue(actualKotlinModulePackage.multiFileClassParts.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Test {@link KotlinModulePackage#accept(KotlinModule, KotlinModulePackageVisitor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link KotlinModulePackageVisitor#visitKotlinModulePackage(KotlinModule,
   *       KotlinModulePackage)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModulePackage#accept(KotlinModule,
   * KotlinModulePackageVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(KotlinModule, KotlinModulePackageVisitor); when 'null'; then calls visitKotlinModulePackage(KotlinModule, KotlinModulePackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.KotlinModulePackage.accept(proguard.resources.kotlinmodule.KotlinModule, proguard.resources.kotlinmodule.visitor.KotlinModulePackageVisitor)"
  })
  void testAccept_whenNull_thenCallsVisitKotlinModulePackage() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    KotlinModulePackage kotlinModulePackage =
        new KotlinModulePackage("Fq Name", fileFacadeNames, new HashMap<>());
    KotlinModulePackageVisitor kotlinModulePartVisitor = mock(KotlinModulePackageVisitor.class);
    doNothing()
        .when(kotlinModulePartVisitor)
        .visitKotlinModulePackage(Mockito.<KotlinModule>any(), Mockito.<KotlinModulePackage>any());

    // Act
    kotlinModulePackage.accept(null, kotlinModulePartVisitor);

    // Assert
    verify(kotlinModulePartVisitor)
        .visitKotlinModulePackage(isNull(), isA(KotlinModulePackage.class));
  }
}
