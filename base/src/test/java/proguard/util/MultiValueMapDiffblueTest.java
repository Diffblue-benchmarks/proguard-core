package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class MultiValueMapDiffblueTest {
  /**
   * Method under test: {@link MultiValueMap#createValueSet()}
   */
  @Test
  public void testCreateValueSet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.createValueSet().isEmpty());
  }

  /**
   * Method under test: {@link MultiValueMap#createKeyMap()}
   */
  @Test
  public void testCreateKeyMap() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.createKeyMap().isEmpty());
  }

  /**
   * Method under test: {@link MultiValueMap#size()}
   */
  @Test
  public void testSize() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertEquals(0, multiValueMap.size());
  }

  /**
   * Method under test: {@link MultiValueMap#keySet()}
   */
  @Test
  public void testKeySet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.keySet().isEmpty());
  }

  /**
   * Method under test: {@link MultiValueMap#values()}
   */
  @Test
  public void testValues() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.values().isEmpty());
  }

  /**
   * Method under test: {@link MultiValueMap#entrySet()}
   */
  @Test
  public void testEntrySet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.entrySet().isEmpty());
  }

  /**
   * Method under test: {@link MultiValueMap#put(Object, Object)}
   */
  @Test
  public void testPut() {
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
   * Method under test: {@link MultiValueMap#put(Object, Object)}
   */
  @Test
  public void testPut2() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act
    multiValueMap.put("Key", "Value");

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  public void testPutAll() {
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
   * Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  public void testPutAll2() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act
    multiValueMap.putAll("Key", new HashSet<>());

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  public void testPutAll3() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    HashSet<Object> values = new HashSet<>();
    values.add("42");

    // Act
    multiValueMap.putAll("Key", values);

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.getValues().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Method under test: {@link MultiValueMap#putAll(Object, Set)}
   */
  @Test
  public void testPutAll4() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  public void testPutAll5() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  public void testPutAll6() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  public void testPutAll7() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Object)}
   */
  @Test
  public void testPutAll8() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("42", "Value");

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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll9() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll10() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll11() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll12() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll13() {
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
   * Method under test: {@link MultiValueMap#putAll(Set, Set)}
   */
  @Test
  public void testPutAll14() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("42", "Value");

    HashSet<Object> keys = new HashSet<>();
    keys.add("42");

    // Act
    multiValueMap.putAll((Set<Object>) keys, (Set<Object>) new HashSet<>());

    // Assert
    assertEquals(1, multiValueMap.values().size());
    assertEquals(1, multiValueMap.size());
  }

  /**
   * Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  public void testRemove() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertFalse(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  public void testRemove2() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.put("Key", "Value");

    // Act and Assert
    assertTrue(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Method under test: {@link MultiValueMap#remove(Object, Object)}
   */
  @Test
  public void testRemove3() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
    multiValueMap.putAll("Key", new HashSet<>());

    // Act and Assert
    assertFalse(multiValueMap.remove("Key", "Value"));
  }

  /**
   * Method under test: {@link MultiValueMap#get(Object)}
   */
  @Test
  public void testGet() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertNull(multiValueMap.get("Key"));
  }

  /**
   * Method under test: {@link MultiValueMap#getValues()}
   */
  @Test
  public void testGetValues() {
    // Arrange
    MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();

    // Act and Assert
    assertTrue(multiValueMap.getValues().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MultiValueMap}
   */
  @Test
  public void testNewMultiValueMap() {
    // Arrange and Act
    MultiValueMap<Object, Object> actualMultiValueMap = new MultiValueMap<>();

    // Assert
    assertEquals(0, actualMultiValueMap.size());
    assertTrue(actualMultiValueMap.values().isEmpty());
    assertTrue(actualMultiValueMap.getValues().isEmpty());
  }
}
