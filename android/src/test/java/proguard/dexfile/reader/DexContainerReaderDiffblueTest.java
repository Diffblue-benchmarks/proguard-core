package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DexContainerReaderDiffblueTest {
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
  @DisplayName(
      "Test new DexContainerReader(Collection); given DexContainerReader(Collection) with readers is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexContainerReader.<init>(java.util.Collection)"
  })
  void testNewDexContainerReader_givenDexContainerReaderWithReadersIsArrayList() {
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
  @DisplayName(
      "Test new DexContainerReader(Collection); given DexContainerReader(Collection) with readers is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexContainerReader.<init>(java.util.Collection)"
  })
  void testNewDexContainerReader_givenDexContainerReaderWithReadersIsArrayList2() {
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
  @DisplayName(
      "Test new DexContainerReader(Collection); when ArrayList(); then return ClassNames Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexContainerReader.<init>(java.util.Collection)"
  })
  void testNewDexContainerReader_whenArrayList_thenReturnClassNamesEmpty() {
    // Arrange and Act
    DexContainerReader actualDexContainerReader = new DexContainerReader(new ArrayList<>());

    // Assert
    assertTrue(actualDexContainerReader.getClassNames().isEmpty());
    assertEquals(DexConstants.DEX_035, actualDexContainerReader.getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#init()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given ArrayList() add DexContainerReader(Collection) with readers is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexContainerReader.init()"})
  void testInit_givenArrayListAddDexContainerReaderWithReadersIsArrayList() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));
    DexContainerReader dexContainerReader = new DexContainerReader(readers);

    // Act
    dexContainerReader.init();

    // Assert that nothing has changed
    assertTrue(dexContainerReader.getClassNames().isEmpty());
  }

  /**
   * Test {@link DexContainerReader#init()}.
   *
   * <ul>
   *   <li>Then {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()} ClassNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#init()}
   */
  @Test
  @DisplayName(
      "Test init(); then DexContainerReader(Collection) with readers is ArrayList() ClassNames Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexContainerReader.init()"})
  void testInit_thenDexContainerReaderWithReadersIsArrayListClassNamesEmpty() {
    // Arrange
    DexContainerReader dexContainerReader = new DexContainerReader(new ArrayList<>());

    // Act
    dexContainerReader.init();

    // Assert that nothing has changed
    assertTrue(dexContainerReader.getClassNames().isEmpty());
  }

  /**
   * Test {@link DexContainerReader#init()}.
   *
   * <ul>
   *   <li>Then {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()} ClassNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#init()}
   */
  @Test
  @DisplayName(
      "Test init(); then DexContainerReader(Collection) with readers is ArrayList() ClassNames Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexContainerReader.init()"})
  void testInit_thenDexContainerReaderWithReadersIsArrayListClassNamesEmpty2() {
    // Arrange
    DexFileReader dexFileReader = mock(DexFileReader.class);
    when(dexFileReader.getClassNames()).thenReturn(new ArrayList<>());

    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(dexFileReader);
    DexContainerReader dexContainerReader = new DexContainerReader(readers);

    // Act
    dexContainerReader.init();

    // Assert that nothing has changed
    verify(dexFileReader, atLeast(1)).getClassNames();
    assertTrue(dexContainerReader.getClassNames().isEmpty());
  }

  /**
   * Test {@link DexContainerReader#init()}.
   *
   * <ul>
   *   <li>Then {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()} ClassNames is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#init()}
   */
  @Test
  @DisplayName(
      "Test init(); then DexContainerReader(Collection) with readers is ArrayList() ClassNames is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexContainerReader.init()"})
  void testInit_thenDexContainerReaderWithReadersIsArrayListClassNamesIsArrayList() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.addAll(new ArrayList<>());
    stringList.add("foo");
    DexFileReader dexFileReader = mock(DexFileReader.class);
    when(dexFileReader.getClassNames()).thenReturn(stringList);

    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(dexFileReader);
    DexContainerReader dexContainerReader = new DexContainerReader(readers);

    // Act
    dexContainerReader.init();

    // Assert
    verify(dexFileReader, atLeast(1)).getClassNames();
    assertEquals(stringList, dexContainerReader.getClassNames());
  }

  /**
   * Test {@link DexContainerReader#init()}.
   *
   * <ul>
   *   <li>Then {@link DexContainerReader#DexContainerReader(Collection)} with readers is {@link
   *       ArrayList#ArrayList()} ClassNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#init()}
   */
  @Test
  @DisplayName(
      "Test init(); then DexContainerReader(Collection) with readers is ArrayList() ClassNames size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexContainerReader.init()"})
  void testInit_thenDexContainerReaderWithReadersIsArrayListClassNamesSizeIsTwo() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    DexFileReader dexFileReader = mock(DexFileReader.class);
    when(dexFileReader.getClassNames()).thenReturn(stringList);

    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(dexFileReader);
    DexContainerReader dexContainerReader = new DexContainerReader(readers);

    // Act
    dexContainerReader.init();

    // Assert
    verify(dexFileReader, atLeast(1)).getClassNames();
    List<String> classNames = dexContainerReader.getClassNames();
    assertEquals(2, classNames.size());
    assertEquals("foo", classNames.get(1));
  }

  /**
   * Test {@link DexContainerReader#getDexVersion()}.
   *
   * <p>Method under test: {@link DexContainerReader#getDexVersion()}
   */
  @Test
  @DisplayName("Test getDexVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.dexfile.reader.DexContainerReader.getDexVersion()"})
  void testGetDexVersion() {
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
  @DisplayName(
      "Test getDexVersion(); given ArrayList() add DexContainerReader(Collection) with readers is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.dexfile.reader.DexContainerReader.getDexVersion()"})
  void testGetDexVersion_givenArrayListAddDexContainerReaderWithReadersIsArrayList() {
    // Arrange
    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(new DexContainerReader(new ArrayList<>()));

    // Act and Assert
    assertEquals(DexConstants.DEX_035, (new DexContainerReader(readers)).getDexVersion());
  }

  /**
   * Test {@link DexContainerReader#accept(Consumer)} with {@code stringConsumer}.
   *
   * <ul>
   *   <li>Then calls {@link DexFileReader#accept(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link DexContainerReader#accept(Consumer)}
   */
  @Test
  @DisplayName("Test accept(Consumer) with 'stringConsumer'; then calls accept(Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexContainerReader.accept(java.util.function.Consumer)"
  })
  void testAcceptWithStringConsumer_thenCallsAccept() {
    // Arrange
    DexFileReader dexFileReader = mock(DexFileReader.class);
    when(dexFileReader.getClassNames()).thenReturn(new ArrayList<>());
    doNothing().when(dexFileReader).accept(Mockito.<Consumer<String>>any());

    ArrayList<BaseDexFileReader> readers = new ArrayList<>();
    readers.add(dexFileReader);

    // Act
    (new DexContainerReader(readers)).accept(mock(Consumer.class));

    // Assert
    verify(dexFileReader).accept(isA(Consumer.class));
    verify(dexFileReader).getClassNames();
  }

  /**
   * Test {@link DexContainerReader#getClassNames()}.
   *
   * <p>Method under test: {@link DexContainerReader#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.dexfile.reader.DexContainerReader.getClassNames()"})
  void testGetClassNames() {
    // Arrange, Act and Assert
    assertTrue((new DexContainerReader(new ArrayList<>())).getClassNames().isEmpty());
  }
}
