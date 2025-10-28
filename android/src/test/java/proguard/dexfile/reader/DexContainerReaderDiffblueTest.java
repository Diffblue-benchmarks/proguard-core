package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class DexContainerReaderDiffblueTest {
  /**
   * Method under test: {@link DexContainerReader#getDexVersion()}
   */
  @Test
  public void testGetDexVersion() {
    // Arrange, Act and Assert
    assertEquals(DexConstants.DEX_035, (new DexContainerReader(new ArrayList<>())).getDexVersion());
  }

  /**
   * Method under test: {@link DexContainerReader#getDexVersion()}
   */
  @Test
  public void testGetDexVersion2() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));

    // Act and Assert
    assertEquals(DexConstants.DEX_035, (new DexContainerReader(readers)).getDexVersion());
  }

  /**
   * Method under test: {@link DexContainerReader#getClassNames()}
   */
  @Test
  public void testGetClassNames() {
    // Arrange, Act and Assert
    assertTrue((new DexContainerReader(new ArrayList<>())).getClassNames().isEmpty());
  }

  /**
   * Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  public void testNewDexContainerReader() {
    // Arrange and Act
    DexContainerReader actualDexContainerReader = new DexContainerReader(new ArrayList<>());

    // Assert
    assertTrue(actualDexContainerReader.getClassNames().isEmpty());
    assertEquals(DexConstants.DEX_035, actualDexContainerReader.getDexVersion());
  }

  /**
   * Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  public void testNewDexContainerReader2() {
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
   * Method under test: {@link DexContainerReader#DexContainerReader(Collection)}
   */
  @Test
  public void testNewDexContainerReader3() {
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
}
