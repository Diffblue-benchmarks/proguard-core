package proguard.analysis.cpa.bam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.Precision;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

class BamCacheImplDiffblueTest {
  /**
   * Test {@link BamCacheImpl#get(Signature)} with {@code blockKey}.
   *
   * <p>Method under test: {@link BamCacheImpl#get(Signature)}
   */
  @Test
  @DisplayName("Test get(Signature) with 'blockKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.bam.BamCacheImpl.get(proguard.classfile.Signature)"
  })
  void testGetWithBlockKey() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualGetResult =
        bamCacheImpl.get(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualGetResult instanceof Set);
    assertTrue(actualGetResult.isEmpty());
  }

  /**
   * Test {@link BamCacheImpl#get(Precision, Signature)} with {@code precision}, {@code blockKey}.
   *
   * <p>Method under test: {@link BamCacheImpl#get(Precision, Signature)}
   */
  @Test
  @DisplayName("Test get(Precision, Signature) with 'precision', 'blockKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.bam.BamCacheImpl.get(proguard.analysis.cpa.interfaces.Precision, proguard.classfile.Signature)"
  })
  void testGetWithPrecisionBlockKey() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualGetResult =
        bamCacheImpl.get(
            mock(Precision.class), ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualGetResult instanceof Set);
    assertTrue(actualGetResult.isEmpty());
  }

  /**
   * Test {@link BamCacheImpl#values()}.
   *
   * <p>Method under test: {@link BamCacheImpl#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection proguard.analysis.cpa.bam.BamCacheImpl.values()"})
  void testValues() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualValuesResult = bamCacheImpl.values();

    // Assert
    assertTrue(actualValuesResult instanceof Set);
    assertTrue(actualValuesResult.isEmpty());
  }

  /**
   * Test {@link BamCacheImpl#getAllMethods()}.
   *
   * <p>Method under test: {@link BamCacheImpl#getAllMethods()}
   */
  @Test
  @DisplayName("Test getAllMethods()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.analysis.cpa.bam.BamCacheImpl.getAllMethods()"})
  void testGetAllMethods() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act and Assert
    assertTrue(bamCacheImpl.getAllMethods().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BamCacheImpl}
   *   <li>{@link BamCacheImpl#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.bam.BamCacheImpl.<init>()",
    "int proguard.analysis.cpa.bam.BamCacheImpl.size()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BamCacheImpl<Signature> actualBamCacheImpl = new BamCacheImpl<>();

    // Assert
    assertEquals(0, actualBamCacheImpl.size());
  }
}
