package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class TryCatchNodeDiffblueTest {
  /**
   * Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode = new TryCatchNode(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode = new TryCatchNode(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode = new TryCatchNode(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});
    DexCodeNode cv = new DexCodeNode();

    // Act
    tryCatchNode.accept(cv);

    // Assert
    List<TryCatchNode> tryCatchNodeList = cv.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
    TryCatchNode getResult = tryCatchNodeList.get(0);
    assertSame(tryCatchNode.end, getResult.end);
    assertSame(tryCatchNode.handler, getResult.handler);
    assertSame(tryCatchNode.start, getResult.start);
    String[] stringArray = getResult.type;
    assertSame(tryCatchNode.type, stringArray);
    assertArrayEquals(new String[]{"Type"}, stringArray);
  }

  /**
   * Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode = new TryCatchNode(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test:
   * {@link TryCatchNode#TryCatchNode(DexLabel, DexLabel, DexLabel[], String[])}
   */
  @Test
  public void testNewTryCatchNode() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();

    // Act
    TryCatchNode actualTryCatchNode = new TryCatchNode(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});

    // Assert
    DexLabel[] dexLabelArray = actualTryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
    assertArrayEquals(new String[]{"Type"}, actualTryCatchNode.type);
  }
}
