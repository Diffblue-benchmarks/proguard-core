package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class KotlinConstantsDiffblueTest {
  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code multi-file class part}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenFive_thenReturnMultiFileClassPart() {
    // Arrange, Act and Assert
    assertEquals("multi-file class part", KotlinConstants.metadataKindToString(5));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code multi-file class facade}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenFour_thenReturnMultiFileClassFacade() {
    // Arrange, Act and Assert
    assertEquals("multi-file class facade", KotlinConstants.metadataKindToString(4));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code class}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenOne_thenReturnClass() {
    // Arrange, Act and Assert
    assertEquals("class", KotlinConstants.metadataKindToString(1));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code synthetic class}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenThree_thenReturnSyntheticClass() {
    // Arrange, Act and Assert
    assertEquals("synthetic class", KotlinConstants.metadataKindToString(3));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code file facade}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenTwo_thenReturnFileFacade() {
    // Arrange, Act and Assert
    assertEquals("file facade", KotlinConstants.metadataKindToString(2));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code unknown}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  public void testMetadataKindToString_whenZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals("unknown", KotlinConstants.metadataKindToString(0));
  }

  /**
   * Test {@link KotlinConstants#getKotlinType(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#getKotlinType(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz KotlinConstants.getKotlinType(Clazz)"})
  public void testGetKotlinType_whenLibraryClass_thenReturnLibraryClass() {
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
