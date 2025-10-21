package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class TryCatchNodeDiffblueTest {
  /**
   * Test {@link TryCatchNode#TryCatchNode(DexLabel, DexLabel, DexLabel[], String[])}.
   *
   * <p>Method under test: {@link TryCatchNode#TryCatchNode(DexLabel, DexLabel, DexLabel[],
   * String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TryCatchNode.<init>(DexLabel, DexLabel, DexLabel[], String[])"})
  public void testNewTryCatchNode() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();

    // Act
    TryCatchNode actualTryCatchNode =
        new TryCatchNode(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});

    // Assert
    DexLabel[] dexLabelArray = actualTryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
    assertArrayEquals(new String[] {"Type"}, actualTryCatchNode.type);
  }

  /**
   * Test {@link TryCatchNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#tryStmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TryCatchNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeTryStmtsSizeIsOne() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode =
        new TryCatchNode(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});
    DexCodeNode cv = new DexCodeNode();

    // Act
    tryCatchNode.accept(cv);

    // Assert
    List<TryCatchNode> tryCatchNodeList = cv.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    TryCatchNode getResult = tryCatchNodeList.get(0);
    DexLabel[] dexLabelArray2 = getResult.handler;
    assertEquals(1, dexLabelArray2.length);
    assertSame(dexLabel, dexLabelArray[0]);
    assertSame(dexLabel, dexLabelArray2[0]);
    assertSame(tryCatchNode.end, getResult.end);
    assertSame(tryCatchNode.handler, dexLabelArray2);
    assertSame(tryCatchNode.start, getResult.start);
    String[] stringArray = getResult.type;
    assertSame(tryCatchNode.type, stringArray);
    assertArrayEquals(new String[] {"Type"}, stringArray);
  }

  /**
   * Test {@link TryCatchNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TryCatchNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode =
        new TryCatchNode(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link TryCatchNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TryCatchNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode =
        new TryCatchNode(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link TryCatchNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link TryCatchNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TryCatchNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    TryCatchNode tryCatchNode =
        new TryCatchNode(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});

    // Act
    tryCatchNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = tryCatchNode.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }
}
