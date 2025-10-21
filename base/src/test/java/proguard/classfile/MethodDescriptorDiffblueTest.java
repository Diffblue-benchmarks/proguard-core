package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodDescriptorDiffblueTest {
  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
  public void testNewMethodDescriptor_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("42");
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, actualMethodDescriptor.getArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ArgumentTypes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
  public void testNewMethodDescriptor_givenFoo_thenReturnArgumentTypesIsArrayList() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, actualMethodDescriptor.getArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return PrettyArgumentTypes is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodDescriptor.<init>(String, List)"})
  public void testNewMethodDescriptor_whenArrayList_thenReturnPrettyArgumentTypesIsEmptyString() {
    // Arrange and Act
    MethodDescriptor actualMethodDescriptor =
        new MethodDescriptor("Return Type", new ArrayList<>());

    // Assert
    assertEquals("", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertTrue(actualMethodDescriptor.getArgumentTypes().isEmpty());
  }

  /**
   * Test {@link MethodDescriptor#MethodDescriptor(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return PrettyArgumentTypes is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#MethodDescriptor(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodDescriptor.<init>(String)"})
  public void testNewMethodDescriptor_whenNull_thenReturnPrettyArgumentTypesIsQuestionMark() {
    // Arrange and Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor(null);

    // Assert
    assertEquals("?", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("?", actualMethodDescriptor.getPrettyReturnType());
    assertNull(actualMethodDescriptor.getReturnType());
    assertNull(actualMethodDescriptor.getArgumentTypes());
    assertTrue(actualMethodDescriptor.isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#isIncomplete()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#isIncomplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodDescriptor.isIncomplete()"})
  public void testIsIncomplete_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MethodDescriptor("Return Type", new ArrayList<>())).isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#isIncomplete()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#isIncomplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodDescriptor.isIncomplete()"})
  public void testIsIncomplete_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MethodDescriptor(null, new ArrayList<>())).isIncomplete());
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNull(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNull(
            null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNull(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNull_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNull(null, null));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("", new ArrayList<>());

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    ArrayList<String> argumentTypes2 = new ArrayList<>();
    argumentTypes2.add("42");

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", argumentTypes2)));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar_thenReturnTrue() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(
            null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Test {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor,
   * MethodDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodDescriptor.matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)"
  })
  public void testMatchesIgnoreNullAndDollar_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNullAndDollar(null, null));
  }

  /**
   * Test {@link MethodDescriptor#getPrettyReturnType()}.
   *
   * <ul>
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#getPrettyReturnType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MethodDescriptor.getPrettyReturnType()"})
  public void testGetPrettyReturnType_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", (new MethodDescriptor(null, new ArrayList<>())).getPrettyReturnType());
  }

  /**
   * Test {@link MethodDescriptor#getPrettyArgumentTypes()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#getPrettyArgumentTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MethodDescriptor.getPrettyArgumentTypes()"})
  public void testGetPrettyArgumentTypes_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", (new MethodDescriptor("Return Type", new ArrayList<>())).getPrettyArgumentTypes());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code (foo)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  public void testToString_givenArrayListAddFoo_thenReturnFooReturnType() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act and Assert
    assertEquals(
        "(foo)Return Type", (new MethodDescriptor("Return Type", argumentTypes)).toString());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ()?}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  public void testToString_thenReturnLeftParenthesisRightParenthesisQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("()?", (new MethodDescriptor(null, new ArrayList<>())).toString());
  }

  /**
   * Test {@link MethodDescriptor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ()Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MethodDescriptor.toString()"})
  public void testToString_thenReturnReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "()Return Type", (new MethodDescriptor("Return Type", new ArrayList<>())).toString());
  }

  /**
   * Test {@link MethodDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodDescriptor#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodDescriptor.equals(Object)", "int MethodDescriptor.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodDescriptor("Return Type", new ArrayList<>()), "42");
  }
}
