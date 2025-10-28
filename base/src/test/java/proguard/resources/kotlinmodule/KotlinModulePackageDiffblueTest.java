package proguard.resources.kotlinmodule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;

public class KotlinModulePackageDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  public void testNewKotlinModulePackage() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();

    // Act
    KotlinModulePackage actualKotlinModulePackage = new KotlinModulePackage("Fq Name", fileFacadeNames,
        new HashMap<>());

    // Assert
    assertEquals("Fq Name", actualKotlinModulePackage.fqName);
    assertTrue(actualKotlinModulePackage.fileFacadeNames.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedFileFacades.isEmpty());
    assertTrue(actualKotlinModulePackage.multiFileClassParts.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Method under test:
   * {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  public void testNewKotlinModulePackage2() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("foo");

    // Act
    KotlinModulePackage actualKotlinModulePackage = new KotlinModulePackage("Fq Name", fileFacadeNames,
        new HashMap<>());

    // Assert
    assertEquals("Fq Name", actualKotlinModulePackage.fqName);
    List<String> stringList = actualKotlinModulePackage.fileFacadeNames;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList = actualKotlinModulePackage.referencedFileFacades;
    assertEquals(1, kotlinFileFacadeKindMetadataList.size());
    assertNull(kotlinFileFacadeKindMetadataList.get(0));
    assertTrue(actualKotlinModulePackage.multiFileClassParts.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedMultiFileParts.isEmpty());
  }

  /**
   * Method under test:
   * {@link KotlinModulePackage#KotlinModulePackage(String, List, Map)}
   */
  @Test
  public void testNewKotlinModulePackage3() {
    // Arrange
    ArrayList<String> fileFacadeNames = new ArrayList<>();
    fileFacadeNames.add("42");
    fileFacadeNames.add("foo");

    // Act
    KotlinModulePackage actualKotlinModulePackage = new KotlinModulePackage("Fq Name", fileFacadeNames,
        new HashMap<>());

    // Assert
    List<String> stringList = actualKotlinModulePackage.fileFacadeNames;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("Fq Name", actualKotlinModulePackage.fqName);
    assertEquals("foo", stringList.get(1));
    List<KotlinFileFacadeKindMetadata> kotlinFileFacadeKindMetadataList = actualKotlinModulePackage.referencedFileFacades;
    assertEquals(2, kotlinFileFacadeKindMetadataList.size());
    assertNull(kotlinFileFacadeKindMetadataList.get(0));
    assertNull(kotlinFileFacadeKindMetadataList.get(1));
    assertTrue(actualKotlinModulePackage.multiFileClassParts.isEmpty());
    assertTrue(actualKotlinModulePackage.referencedMultiFileParts.isEmpty());
  }
}
