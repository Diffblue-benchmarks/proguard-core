package proguard.analysis.cpa.bam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.interfaces.Precision;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class BamCacheImplDiffblueTest {
  /**
   * Method under test: {@link BamCacheImpl#get(Precision, Signature)}
   */
  @Test
  public void testGet() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualGetResult = bamCacheImpl.get(null,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualGetResult instanceof Set);
    assertTrue(actualGetResult.isEmpty());
  }

  /**
   * Method under test: {@link BamCacheImpl#get(Signature)}
   */
  @Test
  public void testGet2() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualGetResult = bamCacheImpl
        .get(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualGetResult instanceof Set);
    assertTrue(actualGetResult.isEmpty());
  }

  /**
   * Method under test: {@link BamCacheImpl#values()}
   */
  @Test
  public void testValues() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualValuesResult = bamCacheImpl.values();

    // Assert
    assertTrue(actualValuesResult instanceof Set);
    assertTrue(actualValuesResult.isEmpty());
  }

  /**
   * Method under test: {@link BamCacheImpl#getAllMethods()}
   */
  @Test
  public void testGetAllMethods() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act and Assert
    assertTrue(bamCacheImpl.getAllMethods().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BamCacheImpl}
   *   <li>{@link BamCacheImpl#size()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BamCacheImpl<Signature> actualBamCacheImpl = new BamCacheImpl<>();

    // Assert
    assertEquals(0, actualBamCacheImpl.size());
  }
}
