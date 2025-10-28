package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class LineNumberTableAttributeDiffblueTest {
  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  public void testGetLineNumber() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLineNumber(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  public void testGetLineNumber2() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  public void testGetLineNumber3() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(0));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  public void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getSource(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  public void testGetSource2() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  public void testGetSource3() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(0));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  public void testGetLineNumberInfo() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getLineNumberInfo(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  public void testGetLineNumberInfo2() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(1));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  public void testGetLineNumberInfo3() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(0));
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getLowestLineNumber()}
   */
  @Test
  public void testGetLowestLineNumber() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLowestLineNumber());
    assertEquals(2,
        (new LineNumberTableAttribute(1, 1, new LineNumberInfo[]{new LineNumberInfo(1, 2)})).getLowestLineNumber());
  }

  /**
   * Method under test: {@link LineNumberTableAttribute#getHighestLineNumber()}
   */
  @Test
  public void testGetHighestLineNumber() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getHighestLineNumber());
  }

  /**
   * Method under test:
   * {@link LineNumberTableAttribute#LineNumberTableAttribute()}
   */
  @Test
  public void testNewLineNumberTableAttribute() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute = new LineNumberTableAttribute();

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link LineNumberTableAttribute#LineNumberTableAttribute(int, int, LineNumberInfo[])}
   */
  @Test
  public void testNewLineNumberTableAttribute2() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute = new LineNumberTableAttribute(1, 3,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }
}
