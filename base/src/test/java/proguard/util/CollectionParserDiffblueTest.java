package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CollectionParserDiffblueTest {
  /**
   * Test {@link CollectionParser#parse(String)} with {@code regularExpression}.
   *
   * <p>Method under test: {@link CollectionParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher CollectionParser.parse(String)"})
  public void testParseWithRegularExpression() {
    // Arrange and Act
    StringMatcher actualParseResult = (new CollectionParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link CollectionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher CollectionParser.parse(List)"})
  public void testParseWithRegularExpressions_given42_whenArrayListAdd42() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    ArrayList<String> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("foo");

    // Act
    StringMatcher actualParseResult = collectionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link CollectionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher CollectionParser.parse(List)"})
  public void testParseWithRegularExpressions_givenFoo_whenArrayListAddFoo() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    ArrayList<String> regularExpressions = new ArrayList<>();
    regularExpressions.add("foo");

    // Act
    StringMatcher actualParseResult = collectionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link CollectionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher CollectionParser.parse(List)"})
  public void testParseWithRegularExpressions_whenArrayList() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    // Act
    StringMatcher actualParseResult = collectionParser.parse(new ArrayList<>());

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
