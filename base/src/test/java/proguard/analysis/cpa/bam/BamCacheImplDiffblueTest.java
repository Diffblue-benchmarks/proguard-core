package proguard.analysis.cpa.bam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.interfaces.Precision;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class BamCacheImplDiffblueTest {
  /**
   * Test {@link BamCacheImpl#get(Signature)} with {@code blockKey}.
   *
   * <p>Method under test: {@link BamCacheImpl#get(Signature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection BamCacheImpl.get(Signature)"})
  public void testGetWithBlockKey() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection BamCacheImpl.get(Precision, Signature)"})
  public void testGetWithPrecisionBlockKey() {
    // Arrange
    BamCacheImpl<Signature> bamCacheImpl = new BamCacheImpl<>();

    // Act
    Collection<BlockAbstraction> actualGetResult =
        bamCacheImpl.get(null, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection BamCacheImpl.values()"})
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
   * Test {@link BamCacheImpl#getAllMethods()}.
   *
   * <p>Method under test: {@link BamCacheImpl#getAllMethods()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set BamCacheImpl.getAllMethods()"})
  public void testGetAllMethods() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BamCacheImpl.<init>()", "int BamCacheImpl.size()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BamCacheImpl<Signature> actualBamCacheImpl = new BamCacheImpl<>();

    // Assert
    assertEquals(0, actualBamCacheImpl.size());
  }
}
