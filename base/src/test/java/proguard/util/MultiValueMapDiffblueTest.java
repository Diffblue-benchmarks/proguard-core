package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiValueMapDiffblueTest {
  /**
   * Test {@link MultiValueMap#createValueSet()}.
   *
   * <p>Method under test: {@link MultiValueMap#createValueSet()}
   */
  @Test
  @DisplayName("Test createValueSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.util.MultiValueMap.createValueSet()"})
  void testCreateValueSet() {
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
  @DisplayName("Test createKeyMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map proguard.util.MultiValueMap.createKeyMap()"})
  void testCreateKeyMap() {
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
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.MultiValueMap.size()"})
  void testSize() {
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
  @DisplayName("Test keySet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.util.MultiValueMap.keySet()"})
  void testKeySet() {
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
  @DisplayName("Test values()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection proguard.util.MultiValueMap.values()"})
  void testValues() {
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
  @DisplayName("Test entrySet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.util.MultiValueMap.entrySet()"})
  void testEntrySet() {
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
  @DisplayName("Test put(Object, Object); given MultiValueMap (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.put(java.lang.Object, java.lang.Object)"})
  void testPut_givenMultiValueMap() {
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
  @DisplayName(
      "Test put(Object, Object); given MultiValueMap (default constructor) 'Key' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.put(java.lang.Object, java.lang.Object)"})
  void testPut_givenMultiValueMapKeyIsValue() {
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
  @DisplayName(
      "Test putAll(Set, Object) with 'key', 'value'; given MultiValueMap (default constructor) '42' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.lang.Object)"})
  void testPutAllWithKeyValue_givenMultiValueMap42IsValue() {
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
  @DisplayName(
      "Test putAll(Set, Object) with 'key', 'value'; given MultiValueMap (default constructor); then MultiValueMap (default constructor) values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.lang.Object)"})
  void testPutAllWithKeyValue_givenMultiValueMap_thenMultiValueMapValuesSizeIsOne() {
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
  @DisplayName(
      "Test putAll(Set, Object) with 'key', 'value'; given two; then MultiValueMap (default constructor) values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.lang.Object)"})
  void testPutAllWithKeyValue_givenTwo_thenMultiValueMapValuesSizeIsTwo() {
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
  @DisplayName(
      "Test putAll(Set, Object) with 'key', 'value'; when HashSet(); then MultiValueMap (default constructor) size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.lang.Object)"})
  void testPutAllWithKeyValue_whenHashSet_thenMultiValueMapSizeIsZero() {
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
  @DisplayName(
      "Test putAll(Object, Set) with 'key', 'values'; given '42'; then MultiValueMap (default constructor) Values is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.lang.Object, java.util.Set)"})
  void testPutAllWithKeyValues_given42_thenMultiValueMapValuesIsHashSet() {
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
  @DisplayName("Test putAll(Object, Set) with 'key', 'values'; given two; when HashSet() add two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.lang.Object, java.util.Set)"})
  void testPutAllWithKeyValues_givenTwo_whenHashSetAddTwo() {
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
  @DisplayName(
      "Test putAll(Object, Set) with 'key', 'values'; then MultiValueMap (default constructor) Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.lang.Object, java.util.Set)"})
  void testPutAllWithKeyValues_thenMultiValueMapValuesSizeIsOne() {
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
  @DisplayName(
      "Test putAll(Object, Set) with 'key', 'values'; when HashSet(); then MultiValueMap (default constructor) Values Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.lang.Object, java.util.Set)"})
  void testPutAllWithKeyValues_whenHashSet_thenMultiValueMapValuesEmpty() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given MultiValueMap (default constructor) '42' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenMultiValueMap42IsValue() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given MultiValueMap (default constructor); then MultiValueMap (default constructor) size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapSizeIsZero() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given MultiValueMap (default constructor); then MultiValueMap (default constructor) size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapSizeIsZero2() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given MultiValueMap (default constructor); then MultiValueMap (default constructor) values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenMultiValueMap_thenMultiValueMapValuesSizeIsOne() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given two; then MultiValueMap (default constructor) values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenTwo_thenMultiValueMapValuesSizeIsTwo() {
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
  @DisplayName(
      "Test putAll(Set, Set) with 'keys', 'values'; given two; when HashSet() add two; then MultiValueMap (default constructor) size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.putAll(java.util.Set, java.util.Set)"})
  void testPutAllWithKeysValues_givenTwo_whenHashSetAddTwo_thenMultiValueMapSizeIsZero() {
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
  @DisplayName(
      "Test remove(Object, Object); given MultiValueMap (default constructor) All 'Key' is HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MultiValueMap.remove(java.lang.Object, java.lang.Object)"
  })
  void testRemove_givenMultiValueMapAllKeyIsHashSet_thenReturnFalse() {
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
  @DisplayName(
      "Test remove(Object, Object); given MultiValueMap (default constructor) 'Key' is 'Value'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MultiValueMap.remove(java.lang.Object, java.lang.Object)"
  })
  void testRemove_givenMultiValueMapKeyIsValue_thenReturnTrue() {
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
  @DisplayName(
      "Test remove(Object, Object); given MultiValueMap (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MultiValueMap.remove(java.lang.Object, java.lang.Object)"
  })
  void testRemove_givenMultiValueMap_thenReturnFalse() {
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
  @DisplayName("Test get(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.util.MultiValueMap.get(java.lang.Object)"})
  void testGet() {
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
  @DisplayName("Test getValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.util.MultiValueMap.getValues()"})
  void testGetValues() {
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
  @DisplayName("Test new MultiValueMap (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.MultiValueMap.<init>()"})
  void testNewMultiValueMap() {
    // Arrange and Act
    MultiValueMap<Object, Object> actualMultiValueMap = new MultiValueMap<>();

    // Assert
    assertEquals(0, actualMultiValueMap.size());
    assertTrue(actualMultiValueMap.values().isEmpty());
    assertTrue(actualMultiValueMap.getValues().isEmpty());
  }
}
