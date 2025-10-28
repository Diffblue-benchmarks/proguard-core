package proguard.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.Test;

public class ListUtilDiffblueTest {
  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, new ArrayList<>());

    // Assert
    assertTrue(actualConcatenateResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate2() {
    // Arrange and Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(null, null);

    // Assert
    assertNull(actualConcatenateResult);
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate3() {
    // Arrange and Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(new ArrayList<>(), null);

    // Assert
    assertTrue(actualConcatenateResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate4() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, new ArrayList<>());

    // Assert
    assertEquals(1, actualConcatenateResult.size());
    assertEquals("42", actualConcatenateResult.get(0));
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate5() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");
    list1.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, new ArrayList<>());

    // Assert
    assertEquals(list1, actualConcatenateResult);
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate6() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, list2);

    // Assert
    assertEquals(1, actualConcatenateResult.size());
    assertEquals("42", actualConcatenateResult.get(0));
  }

  /**
   * Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  public void testConcatenate7() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");
    list2.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, list2);

    // Assert
    assertEquals(list2, actualConcatenateResult);
  }

  /**
   * Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  public void testFilter() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  public void testFilter2() {
    // Arrange
    LinkedHashSet<String> list = new LinkedHashSet<>();
    list.add("List");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  public void testFilter3() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertEquals(1, actualFilterResult.size());
    assertEquals("", actualFilterResult.get(0));
  }

  /**
   * Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  public void testFilter4() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("42");
    list.add("");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertEquals(1, actualFilterResult.size());
    assertEquals("", actualFilterResult.get(0));
  }

  /**
   * Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  public void testFilter5() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("foo");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new CollectionMatcher(new HashSet<>()));

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  public void testCommaSeparatedString() {
    // Arrange, Act and Assert
    assertEquals("", ListUtil.commaSeparatedString(new ArrayList<>(), true));
    assertNull(ListUtil.commaSeparatedString(null, false));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  public void testCommaSeparatedString2() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");
    list.add("List");

    // Act and Assert
    assertEquals("List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List",
        ListUtil.commaSeparatedString(list, false));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  public void testCommaSeparatedString3() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("foo");

    // Act and Assert
    assertEquals("foo", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  public void testCommaSeparatedString4() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("42");
    list.add("foo");

    // Act and Assert
    assertEquals("42,foo", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  public void testCommaSeparatedString5() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("");

    // Act and Assert
    assertEquals("''", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedList(String)}
   */
  @Test
  public void testCommaSeparatedList() {
    // Arrange and Act
    List<String> actualCommaSeparatedListResult = ListUtil.commaSeparatedList("String");

    // Assert
    assertEquals(1, actualCommaSeparatedListResult.size());
    assertEquals("String", actualCommaSeparatedListResult.get(0));
  }

  /**
   * Method under test: {@link ListUtil#commaSeparatedList(String)}
   */
  @Test
  public void testCommaSeparatedList2() {
    // Arrange and Act
    List<String> actualCommaSeparatedListResult = ListUtil.commaSeparatedList(null);

    // Assert
    assertNull(actualCommaSeparatedListResult);
  }

  /**
   * Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  public void testToIntArray() {
    // Arrange, Act and Assert
    assertEquals(0, ListUtil.toIntArray(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  public void testToIntArray2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);
    integerList.add(1);

    // Act and Assert
    assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        ListUtil.toIntArray(integerList));
  }

  /**
   * Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  public void testToIntArray3() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    // Act and Assert
    assertArrayEquals(new int[]{2}, ListUtil.toIntArray(integerList));
  }

  /**
   * Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  public void testToIntArray4() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);

    // Act and Assert
    assertArrayEquals(new int[]{1, 2}, ListUtil.toIntArray(integerList));
  }
}
