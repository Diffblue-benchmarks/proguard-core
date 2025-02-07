package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class TryCatchNodeDiffblueTest {
  /**
   * Test {@link TryCatchNode#TryCatchNode(DexLabel, DexLabel, DexLabel[], String[])}.
   *
   * <p>Method under test: {@link TryCatchNode#TryCatchNode(DexLabel, DexLabel, DexLabel[],
   * String[])}
   */
  @Test
  @DisplayName("Test new TryCatchNode(DexLabel, DexLabel, DexLabel[], String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.TryCatchNode.<init>(proguard.dexfile.reader.DexLabel, proguard.dexfile.reader.DexLabel, proguard.dexfile.reader.DexLabel[], java.lang.String[])"
  })
  void testNewTryCatchNode() {
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
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() tryStmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.TryCatchNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeTryStmtsSizeIsOne() {
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
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.TryCatchNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
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
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.TryCatchNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
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
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.TryCatchNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
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
