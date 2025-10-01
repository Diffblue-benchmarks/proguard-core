package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.charset.Charset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectUtilDiffblueTest {
  /**
   * Test {@link ObjectUtil#equal(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#equal(Object, Object)}
   */
  @Test
  @DisplayName("Test equal(Object, Object); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectUtil.equal(Object, Object)"})
  void testEqual_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ObjectUtil.equal(null, "Object2"));
  }

  /**
   * Test {@link ObjectUtil#equal(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#equal(Object, Object)}
   */
  @Test
  @DisplayName("Test equal(Object, Object); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectUtil.equal(Object, Object)"})
  void testEqual_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ObjectUtil.equal(null, null));
  }

  /**
   * Test {@link ObjectUtil#equal(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Object1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#equal(Object, Object)}
   */
  @Test
  @DisplayName("Test equal(Object, Object); when 'Object1'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectUtil.equal(Object, Object)"})
  void testEqual_whenObject1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ObjectUtil.equal("Object1", "Object2"));
  }

  /**
   * Test {@link ObjectUtil#hashCode(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#hashCode(Object)}
   */
  @Test
  @DisplayName("Test hashCode(Object) with 'Object'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.hashCode(Object)"})
  void testHashCodeWithObject_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectUtil.hashCode(null));
  }

  /**
   * Test {@link ObjectUtil#hashCode(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code -1939501217}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#hashCode(Object)}
   */
  @Test
  @DisplayName("Test hashCode(Object) with 'Object'; when 'Object'; then return '-1939501217'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.hashCode(Object)"})
  void testHashCodeWithObject_whenObject_thenReturn1939501217() {
    // Arrange, Act and Assert
    assertEquals(-1939501217, ObjectUtil.hashCode("Object"));
  }

  /**
   * Test {@link ObjectUtil#compare(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When forName {@code UTF-8}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#compare(Comparable, Comparable)}
   */
  @Test
  @DisplayName("Test compare(Comparable, Comparable); when forName 'UTF-8'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.compare(Comparable, Comparable)"})
  void testCompare_whenForNameUtf8_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ObjectUtil.compare(Charset.forName("UTF-8"), null));
  }

  /**
   * Test {@link ObjectUtil#compare(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When forName {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#compare(Comparable, Comparable)}
   */
  @Test
  @DisplayName("Test compare(Comparable, Comparable); when forName 'UTF-8'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.compare(Comparable, Comparable)"})
  void testCompare_whenForNameUtf8_thenReturnZero() {
    // Arrange
    Charset object1 = Charset.forName("UTF-8");

    // Act and Assert
    assertEquals(0, ObjectUtil.compare(object1, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link ObjectUtil#compare(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#compare(Comparable, Comparable)}
   */
  @Test
  @DisplayName("Test compare(Comparable, Comparable); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.compare(Comparable, Comparable)"})
  void testCompare_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ObjectUtil.compare(null, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link ObjectUtil#compare(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtil#compare(Comparable, Comparable)}
   */
  @Test
  @DisplayName("Test compare(Comparable, Comparable); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectUtil.compare(Comparable, Comparable)"})
  void testCompare_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectUtil.compare(null, null));
  }
}
