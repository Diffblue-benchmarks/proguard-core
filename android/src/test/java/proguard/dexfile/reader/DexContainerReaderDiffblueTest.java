package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DexContainerReaderDiffblueTest {
  /**
   * Test {@link DexContainerReader#DexContainerReader(Collection)}.
   *
   * <ul>
   *   <li>Given {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexContainerReader.<init>(Collection)"})
  public void testNewDexContainerReader_givenDexContainerReaderWithReadersIsArrayList() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));

    // Act
    DexContainerReader actualDexContainerReader = new DexContainerReader(readers);

    // Assert
    assertTrue(actualDexContainerReader.getClassNames().isEmpty());
    assertEquals(DexConstants.DEX_035, actualDexContainerReader.getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#DexContainerReader(Collection)}.
   *
   * <ul>
   *   <li>Given {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexContainerReader.<init>(Collection)"})
  public void testNewDexContainerReader_givenDexContainerReaderWithReadersIsArrayList2() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));
    readers.add(new DexContainerReader(new ArrayList<>()));

    // Act
    DexContainerReader actualDexContainerReader = new DexContainerReader(readers);

    // Assert
    assertTrue(actualDexContainerReader.getClassNames().isEmpty());
    assertEquals(DexConstants.DEX_035, actualDexContainerReader.getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#DexContainerReader(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ClassNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexContainerReader.<init>(Collection)"})
  public void testNewDexContainerReader_whenArrayList_thenReturnClassNamesEmpty() {
    // Arrange and Act
    DexContainerReader actualDexContainerReader = new DexContainerReader(new ArrayList<>());

    // Assert
    assertTrue(actualDexContainerReader.getClassNames().isEmpty());
    assertEquals(DexConstants.DEX_035, actualDexContainerReader.getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#getDexVersion()}.
   *
   * <p>Method under test: {@link DexContainerReader#getDexVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexContainerReader.getDexVersion()"})
  public void testGetDexVersion() {
    // Arrange, Act and Assert
    assertEquals(DexConstants.DEX_035, (new DexContainerReader(new ArrayList<>())).getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#getDexVersion()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#getDexVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexContainerReader.getDexVersion()"})
  public void testGetDexVersion_givenArrayListAddDexContainerReaderWithReadersIsArrayList() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));

    // Act and Assert
    assertEquals(DexConstants.DEX_035, (new DexContainerReader(readers)).getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#getClassNames()}.
   *
   * <p>Method under test: {@link DexContainerReader#getClassNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List DexContainerReader.getClassNames()"})
  public void testGetClassNames() {
    // Arrange, Act and Assert
    assertTrue((new DexContainerReader(new ArrayList<>())).getClassNames().isEmpty());
  }
}
