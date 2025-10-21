package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LineNumberTableAttributeDiffblueTest {
  /**
   * Test {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#LineNumberTableAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LineNumberTableAttribute.<init>()",
    "void LineNumberTableAttribute.<init>(int, int, LineNumberInfo[])"
  })
  public void testNewLineNumberTableAttribute() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute = new LineNumberTableAttribute();

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LineNumberTableAttribute#LineNumberTableAttribute(int, int, LineNumberInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#LineNumberTableAttribute(int, int,
   * LineNumberInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LineNumberTableAttribute.<init>()",
    "void LineNumberTableAttribute.<init>(int, int, LineNumberInfo[])"
  })
  public void testNewLineNumberTableAttribute_whenOne() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getLineNumber(int)"})
  public void testGetLineNumber_givenLineNumberTableAttribute_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLineNumber(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getLineNumber(int)"})
  public void testGetLineNumber_thenReturnTwo() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getLineNumber(int)"})
  public void testGetLineNumber_whenZero_thenReturnTwo() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LineNumberTableAttribute.getSource(int)"})
  public void testGetSource() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LineNumberTableAttribute.getSource(int)"})
  public void testGetSource_givenLineNumberTableAttribute_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getSource(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LineNumberTableAttribute.getSource(int)"})
  public void testGetSource_whenZero() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LineNumberInfo LineNumberTableAttribute.getLineNumberInfo(int)"})
  public void testGetLineNumberInfo() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LineNumberInfo LineNumberTableAttribute.getLineNumberInfo(int)"})
  public void testGetLineNumberInfo_givenLineNumberTableAttribute_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getLineNumberInfo(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LineNumberInfo LineNumberTableAttribute.getLineNumberInfo(int)"})
  public void testGetLineNumberInfo_whenZero() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLowestLineNumber()}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLowestLineNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getLowestLineNumber()"})
  public void testGetLowestLineNumber_givenLineNumberTableAttribute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLowestLineNumber());
  }

  /**
   * Test {@link LineNumberTableAttribute#getLowestLineNumber()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLowestLineNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getLowestLineNumber()"})
  public void testGetLowestLineNumber_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2,
        (new LineNumberTableAttribute(1, 1, new LineNumberInfo[] {new LineNumberInfo(1, 2)}))
            .getLowestLineNumber());
  }

  /**
   * Test {@link LineNumberTableAttribute#getHighestLineNumber()}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getHighestLineNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LineNumberTableAttribute.getHighestLineNumber()"})
  public void testGetHighestLineNumber_givenLineNumberTableAttribute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getHighestLineNumber());
  }
}
