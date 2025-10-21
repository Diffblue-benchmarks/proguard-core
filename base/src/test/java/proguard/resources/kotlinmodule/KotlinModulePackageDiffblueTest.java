package proguard.resources.kotlinmodule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;

public class KotlinModulePackageDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinModulePackage.<init>(String, List, Map)"})
  public void testNewKotlinModulePackage_given42_thenReturnFileFacadeNamesSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinModulePackage.<init>(String, List, Map)"})
  public void testNewKotlinModulePackage_givenFoo_thenReturnFileFacadeNamesSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinModulePackage.<init>(String, List, Map)"})
  public void testNewKotlinModulePackage_whenArrayList_thenReturnFqName() {
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
}
