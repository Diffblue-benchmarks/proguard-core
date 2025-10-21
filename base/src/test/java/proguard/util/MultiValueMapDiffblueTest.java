package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiValueMapDiffblueTest {
  /**
   * Test {@link MultiValueMap#createValueSet()}.
   *
   * <p>Method under test: {@link MultiValueMap#createValueSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set MultiValueMap.createValueSet()"})
  public void testCreateValueSet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.createValueSet().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#createKeyMap()}.
   *
   * <p>Method under test: {@link MultiValueMap#createKeyMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map MultiValueMap.createKeyMap()"})
  public void testCreateKeyMap() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.createKeyMap().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#size()}.
   *
   * <p>Method under test: {@link MultiValueMap#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiValueMap.size()"})
  public void testSize() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertEquals(0, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#keySet()}.
   *
   * <p>Method under test: {@link MultiValueMap#keySet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set MultiValueMap.keySet()"})
  public void testKeySet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.keySet().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#values()}.
   *
   * <p>Method under test: {@link MultiValueMap#values()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Collection MultiValueMap.values()"})
  public void testValues() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.values().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#entrySet()}.
   *
   * <p>Method under test: {@link MultiValueMap#entrySet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set MultiValueMap.entrySet()"})
  public void testEntrySet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.entrySet().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#put(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#put(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.put(Object, Object)"})
  public void testPut_givenMultiValueMap() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act
    multiValueMap.put("Key", "Value");

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#put(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor) {@code Key} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#put(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.put(Object, Object)"})
  public void testPut_givenMultiValueMapKeyIsValue() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act
    multiValueMap.put("Key", "Value");

    // Assert that nothing has changed
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor) {@code 42} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Object)"})
  public void testPutAllWithKeyValue_givenMultiValueMap42IsValue() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("42", "Value");

    HashSet<Object> key = new HashSet<>();
    key.add("42");

    // Act
    multiValueMap.putAll(key, "Value");

    // Assert that nothing has changed
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   *   <li>Then {@link MultiValueMap} (default constructor) values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Object)"})
  public void testPutAllWithKeyValue_givenMultiValueMap_thenMultiValueMapValuesSizeIsOne() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> key = new HashSet<>();
    key.add("42");

    // Act
    multiValueMap.putAll(key, "Value");

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then {@link MultiValueMap} (default constructor) values size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Object)"})
  public void testPutAllWithKeyValue_givenTwo_thenMultiValueMapValuesSizeIsTwo() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> key = new HashSet<>();
    key.add(2);
    key.add("42");

    // Act
    multiValueMap.putAll(key, "Value");

    // Assert
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(2, multiValueMap.values().size());
    assertEquals(2, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link MultiValueMap} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Object)"})
  public void testPutAllWithKeyValue_whenHashSet_thenMultiValueMapSizeIsZero() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act
    multiValueMap.putAll(new HashSet<>(), "Value");

    // Assert that nothing has changed
    assertEquals(0, multiValueMap.size());
    assertTrue(multiValueMap.values().isEmpty());
    assertTrue(multiValueMap.getValues().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#putAll(Object, Set)} with {@code key}, {@code values}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link MultiValueMap} (default constructor) Values is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Object, Set)"})
  public void testPutAllWithKeyValues_given42_thenMultiValueMapValuesIsHashSet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> values = new HashSet<>();
    values.add("42");

    // Act
    multiValueMap.putAll("Key", values);

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
    assertEquals(values, multiValueMap.getValues());
  }

  /**
   * Test {@link MultiValueMap#putAll(Object, Set)} with {@code key}, {@code values}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Object, Set)"})
  public void testPutAllWithKeyValues_givenTwo_whenHashSetAddTwo() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> values = new HashSet<>();
    values.add(2);
    values.add("42");

    // Act
    multiValueMap.putAll("Key", values);

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
    assertEquals(values, multiValueMap.getValues());
  }

  /**
   * Test {@link MultiValueMap#putAll(Object, Set)} with {@code key}, {@code values}.
   *
   * <ul>
   *   <li>Then {@link MultiValueMap} (default constructor) Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Object, Set)"})
  public void testPutAllWithKeyValues_thenMultiValueMapValuesSizeIsOne() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act
    multiValueMap.putAll("Key", new HashSet<>());

    // Assert that nothing has changed
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Object, Set)} with {@code key}, {@code values}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link MultiValueMap} (default constructor) Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Object, Set)"})
  public void testPutAllWithKeyValues_whenHashSet_thenMultiValueMapValuesEmpty() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act
    multiValueMap.putAll("Key", new HashSet<>());

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
    assertTrue(multiValueMap.getValues().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor) {@code 42} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenMultiValueMap42IsValue() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("42", "Value");

    HashSet<Object> keys = new HashSet<>();
    keys.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) new HashSet<>());

    // Assert that nothing has changed
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   *   <li>Then {@link MultiValueMap} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapSizeIsZero() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    HashSet<Object> keys = new HashSet<>();

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) new HashSet<>());

    // Assert that nothing has changed
    assertEquals(0, multiValueMap.size());
    assertTrue(multiValueMap.values().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   *   <li>Then {@link MultiValueMap} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapSizeIsZero2() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    HashSet<Object> keys = new HashSet<>();

    HashSet<Object> values = new HashSet<>();
    values.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) values);

    // Assert that nothing has changed
    assertEquals(0, multiValueMap.size());
    assertTrue(multiValueMap.values().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   *   <li>Then {@link MultiValueMap} (default constructor) values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapValuesSizeIsOne() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> keys = new HashSet<>();
    keys.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) new HashSet<>());

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then {@link MultiValueMap} (default constructor) values size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenTwo_thenMultiValueMapValuesSizeIsTwo() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> keys = new HashSet<>();
    keys.add(2);
    keys.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) new HashSet<>());

    // Assert
    assertEquals(2, multiValueMap.values().size());
    assertEquals(2, multiValueMap.size());
  }

  /**
   * Test {@link MultiValueMap#putAll(Set, Set)} with {@code keys}, {@code values}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then {@link MultiValueMap} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.putAll(Set, Set)"})
  public void testPutAllWithKeysValues_givenTwo_whenHashSetAddTwo_thenMultiValueMapSizeIsZero() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    HashSet<Object> keys = new HashSet<>();

    HashSet<Object> values = new HashSet<>();
    values.add(2);
    values.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) values);

    // Assert that nothing has changed
    assertEquals(0, multiValueMap.size());
    assertTrue(multiValueMap.values().isEmpty());
  }

  /**
   * Test {@link MultiValueMap#remove(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor) All {@code Key} is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiValueMap.remove(Object, Object)"})
  public void testRemove_givenMultiValueMapAllKeyIsHashSet_thenReturnFalse() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.putAll("Key", new HashSet<>());

    // Act and Assert
    assertFalse(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Test {@link MultiValueMap#remove(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor) {@code Key} is {@code Value}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiValueMap.remove(Object, Object)"})
  public void testRemove_givenMultiValueMapKeyIsValue_thenReturnTrue() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act and Assert
    assertTrue(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Test {@link MultiValueMap#remove(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MultiValueMap} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiValueMap.remove(Object, Object)"})
  public void testRemove_givenMultiValueMap_thenReturnFalse() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertFalse(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Test {@link MultiValueMap#get(Object)}.
   *
   * <p>Method under test: {@link MultiValueMap#get(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set MultiValueMap.get(Object)"})
  public void testGet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertNull(multiValueMap.get("Key"));
  }

  /**
   * Test {@link MultiValueMap#getValues()}.
   *
   * <p>Method under test: {@link MultiValueMap#getValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set MultiValueMap.getValues()"})
  public void testGetValues() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.getValues().isEmpty());
  }

  /**
   * Test new {@link MultiValueMap} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiValueMap}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiValueMap.<init>()"})
  public void testNewMultiValueMap() {
    // Arrange and Act
    MultiValueMap<Object, Object> actualMultiValueMap = new MultiValueMap<>();

    // Assert
    assertEquals(0, actualMultiValueMap.size());
    assertTrue(actualMultiValueMap.values().isEmpty());
    assertTrue(actualMultiValueMap.getValues().isEmpty());
  }
}
