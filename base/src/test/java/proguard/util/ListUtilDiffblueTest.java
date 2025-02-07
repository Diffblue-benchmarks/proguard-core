package proguard.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ListUtilDiffblueTest {
  /**
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName(
      "Test concatenate(List, List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, new ArrayList<>());

    // Assert
    assertEquals(list1, actualConcatenateResult);
  }

  /**
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName(
      "Test concatenate(List, List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_given42_whenArrayListAdd42_thenReturnArrayList2() {
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
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName(
      "Test concatenate(List, List); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
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
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName(
      "Test concatenate(List, List); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");
    list2.add("42");

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, list2);

    // Assert
    assertEquals(2, actualConcatenateResult.size());
    assertEquals("42", actualConcatenateResult.get(0));
    assertEquals("42", actualConcatenateResult.get(1));
  }

  /**
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName("Test concatenate(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    // Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(list1, new ArrayList<>());

    // Assert
    assertTrue(actualConcatenateResult.isEmpty());
  }

  /**
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName("Test concatenate(List, List); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(new ArrayList<>(), null);

    // Assert
    assertTrue(actualConcatenateResult.isEmpty());
  }

  /**
   * Test {@link ListUtil#concatenate(List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#concatenate(List, List)}
   */
  @Test
  @DisplayName("Test concatenate(List, List); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.concatenate(java.util.List, java.util.List)"
  })
  void testConcatenate_whenNull_thenReturnNull() {
    // Arrange and Act
    List<Object> actualConcatenateResult = ListUtil.concatenate(null, null);

    // Assert
    assertNull(actualConcatenateResult);
  }

  /**
   * Test {@link ListUtil#filter(Collection, StringMatcher)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test filter(Collection, StringMatcher); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.filter(java.util.Collection, proguard.util.StringMatcher)"
  })
  void testFilter_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
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
   * Test {@link ListUtil#filter(Collection, StringMatcher)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test filter(Collection, StringMatcher); given empty string; when ArrayList() add empty string; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.filter(java.util.Collection, proguard.util.StringMatcher)"
  })
  void testFilter_givenEmptyString_whenArrayListAddEmptyString_thenReturnArrayList() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertEquals(list, actualFilterResult);
  }

  /**
   * Test {@link ListUtil#filter(Collection, StringMatcher)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test filter(Collection, StringMatcher); given 'foo'; when ArrayList() add 'foo'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.filter(java.util.Collection, proguard.util.StringMatcher)"
  })
  void testFilter_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("foo");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new CollectionMatcher(new HashSet<>()));

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link ListUtil#filter(Collection, StringMatcher)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code List}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test filter(Collection, StringMatcher); given 'List'; when LinkedHashSet() add 'List'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.filter(java.util.Collection, proguard.util.StringMatcher)"
  })
  void testFilter_givenList_whenLinkedHashSetAddList_thenReturnEmpty() {
    // Arrange
    LinkedHashSet<String> list = new LinkedHashSet<>();
    list.add("List");

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link ListUtil#filter(Collection, StringMatcher)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#filter(Collection, StringMatcher)}
   */
  @Test
  @DisplayName("Test filter(Collection, StringMatcher); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.util.ListUtil.filter(java.util.Collection, proguard.util.StringMatcher)"
  })
  void testFilter_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();

    // Act
    List<String> actualFilterResult = ListUtil.filter(list, new EmptyStringMatcher());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName("Test commaSeparatedString(List, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString() {
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
    assertEquals(
        "List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List,List",
        ListUtil.commaSeparatedString(list, false));
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42,foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test commaSeparatedString(List, boolean); given '42'; when ArrayList() add '42'; then return '42,foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString_given42_whenArrayListAdd42_thenReturn42Foo() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("42");
    list.add("foo");

    // Act and Assert
    assertEquals("42,foo", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code ''}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName("Test commaSeparatedString(List, boolean); given empty string; then return ''''")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString_givenEmptyString_thenReturnApostropheApostrophe() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("");

    // Act and Assert
    assertEquals("''", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test commaSeparatedString(List, boolean); given 'foo'; when ArrayList() add 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString_givenFoo_whenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("foo");

    // Act and Assert
    assertEquals("foo", ListUtil.commaSeparatedString(list, true));
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test commaSeparatedString(List, boolean); when ArrayList(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ListUtil.commaSeparatedString(new ArrayList<>(), true));
  }

  /**
   * Test {@link ListUtil#commaSeparatedString(List, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedString(List, boolean)}
   */
  @Test
  @DisplayName("Test commaSeparatedString(List, boolean); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ListUtil.commaSeparatedString(java.util.List, boolean)"
  })
  void testCommaSeparatedString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ListUtil.commaSeparatedString(null, false));
  }

  /**
   * Test {@link ListUtil#commaSeparatedList(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedList(String)}
   */
  @Test
  @DisplayName("Test commaSeparatedList(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.util.ListUtil.commaSeparatedList(java.lang.String)"})
  void testCommaSeparatedList_whenNull_thenReturnNull() {
    // Arrange and Act
    List<String> actualCommaSeparatedListResult = ListUtil.commaSeparatedList(null);

    // Assert
    assertNull(actualCommaSeparatedListResult);
  }

  /**
   * Test {@link ListUtil#commaSeparatedList(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#commaSeparatedList(String)}
   */
  @Test
  @DisplayName("Test commaSeparatedList(String); when 'String'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.util.ListUtil.commaSeparatedList(java.lang.String)"})
  void testCommaSeparatedList_whenString_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualCommaSeparatedListResult = ListUtil.commaSeparatedList("String");

    // Assert
    assertEquals(1, actualCommaSeparatedListResult.size());
    assertEquals("String", actualCommaSeparatedListResult.get(0));
  }

  /**
   * Test {@link ListUtil#toIntArray(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return array of {@code int} with one and one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  @DisplayName(
      "Test toIntArray(List); given one; when ArrayList() add one; then return array of int with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] proguard.util.ListUtil.toIntArray(java.util.List)"})
  void testToIntArray_givenOne_whenArrayListAddOne_thenReturnArrayOfIntWithOneAndOne() {
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
    assertArrayEquals(
        new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        ListUtil.toIntArray(integerList));
  }

  /**
   * Test {@link ListUtil#toIntArray(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return array of {@code int} with one and two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  @DisplayName(
      "Test toIntArray(List); given one; when ArrayList() add one; then return array of int with one and two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] proguard.util.ListUtil.toIntArray(java.util.List)"})
  void testToIntArray_givenOne_whenArrayListAddOne_thenReturnArrayOfIntWithOneAndTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);

    // Act and Assert
    assertArrayEquals(new int[] {1, 2}, ListUtil.toIntArray(integerList));
  }

  /**
   * Test {@link ListUtil#toIntArray(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return array of {@code int} with two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  @DisplayName(
      "Test toIntArray(List); given two; when ArrayList() add two; then return array of int with two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] proguard.util.ListUtil.toIntArray(java.util.List)"})
  void testToIntArray_givenTwo_whenArrayListAddTwo_thenReturnArrayOfIntWithTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    // Act and Assert
    assertArrayEquals(new int[] {2}, ListUtil.toIntArray(integerList));
  }

  /**
   * Test {@link ListUtil#toIntArray(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtil#toIntArray(List)}
   */
  @Test
  @DisplayName("Test toIntArray(List); when ArrayList(); then return empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] proguard.util.ListUtil.toIntArray(java.util.List)"})
  void testToIntArray_whenArrayList_thenReturnEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {}, ListUtil.toIntArray(new ArrayList<>()));
  }
}
