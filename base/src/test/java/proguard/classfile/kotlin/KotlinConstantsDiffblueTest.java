package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class KotlinConstantsDiffblueTest {
  /**
   * Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  public void testMetadataKindToString() {
    // Arrange, Act and Assert
    assertEquals("class", KotlinConstants.metadataKindToString(1));
    assertEquals("file facade", KotlinConstants.metadataKindToString(2));
    assertEquals("synthetic class", KotlinConstants.metadataKindToString(3));
    assertEquals("multi-file class facade", KotlinConstants.metadataKindToString(4));
    assertEquals("multi-file class part", KotlinConstants.metadataKindToString(5));
    assertEquals("unknown", KotlinConstants.metadataKindToString(0));
  }

  /**
   * Method under test: {@link KotlinConstants#getKotlinType(Clazz)}
   */
  @Test
  public void testGetKotlinType() {
    // Arrange and Act
    Clazz actualKotlinType = KotlinConstants.getKotlinType(new LibraryClass());

    // Assert
    assertTrue(actualKotlinType instanceof LibraryClass);
    assertNull(((LibraryClass) actualKotlinType).interfaceNames);
    assertNull(((LibraryClass) actualKotlinType).fields);
    assertNull(((LibraryClass) actualKotlinType).methods);
    assertNull(actualKotlinType.getProcessingInfo());
    assertNull(actualKotlinType.getName());
    assertNull(actualKotlinType.getSuperName());
    assertNull(actualKotlinType.getFeatureName());
    assertNull(actualKotlinType.getSuperClass());
    assertNull(((LibraryClass) actualKotlinType).kotlinMetadata);
    assertEquals(0, actualKotlinType.getAccessFlags());
    assertEquals(0, actualKotlinType.getInterfaceCount());
    assertEquals(0, actualKotlinType.getProcessingFlags());
    assertEquals(0, ((LibraryClass) actualKotlinType).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) actualKotlinType).subClasses.length);
    assertEquals(0, ((LibraryClass) actualKotlinType).subClassCount);
    assertTrue(actualKotlinType.getExtraFeatureNames().isEmpty());
  }
}
