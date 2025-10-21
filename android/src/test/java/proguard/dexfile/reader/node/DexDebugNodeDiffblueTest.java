package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.EndLocal;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Epiogue;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.LineNumber;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.Prologue;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.RestartLocal;
import proguard.dexfile.reader.node.DexDebugNode.DexDebugOpNode.StartLocalNode;
import proguard.dexfile.reader.visitors.DexDebugVisitor;

public class DexDebugNodeDiffblueTest {
  /**
   * Test {@link DexDebugNode#addDebug(DexDebugOpNode)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#addDebug(DexDebugOpNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.addDebug(DexDebugOpNode)"})
  public void testAddDebug_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());

    // Act
    dexDebugNode.addDebug(dexDebugNode2);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test DexDebugOpNode_EndLocal {@link DexDebugOpNode.EndLocal#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.EndLocal#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.EndLocal.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_EndLocalAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    EndLocal endLocal = new EndLocal(new DexLabel(), 1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    endLocal.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(endLocal.label, ((EndLocal) getResult).label);
  }

  /**
   * Test DexDebugOpNode_EndLocal {@link DexDebugOpNode.EndLocal#EndLocal(DexLabel, int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.EndLocal#EndLocal(DexLabel, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.EndLocal.<init>(DexLabel, int)"})
  public void testDexDebugOpNode_EndLocalNewEndLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new EndLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Test DexDebugOpNode_Epiogue {@link DexDebugOpNode.Epiogue#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.Epiogue#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.Epiogue.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_EpiogueAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    Epiogue epiogue = new Epiogue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    epiogue.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    assertSame(epiogue.label, ((Epiogue) getResult).label);
  }

  /**
   * Test DexDebugOpNode_LineNumber {@link DexDebugOpNode.LineNumber#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.LineNumber#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.LineNumber.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_LineNumberAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    LineNumber lineNumber = new LineNumber(new DexLabel(), 2);
    DexDebugNode cv = new DexDebugNode();

    // Act
    lineNumber.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult).line);
    assertSame(lineNumber.label, ((LineNumber) getResult).label);
  }

  /**
   * Test DexDebugOpNode_LineNumber {@link DexDebugOpNode.LineNumber#LineNumber(DexLabel, int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.LineNumber#LineNumber(DexLabel, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.LineNumber.<init>(DexLabel, int)"})
  public void testDexDebugOpNode_LineNumberNewLineNumber() {
    // Arrange, Act and Assert
    assertEquals(2, (new LineNumber(new DexLabel(), 2)).line);
  }

  /**
   * Test DexDebugOpNode_Prologue {@link DexDebugOpNode.Prologue#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.Prologue#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.Prologue.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_PrologueAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    Prologue prologue = new Prologue(new DexLabel());
    DexDebugNode cv = new DexDebugNode();

    // Act
    prologue.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Prologue);
    assertSame(prologue.label, ((Prologue) getResult).label);
  }

  /**
   * Test DexDebugOpNode_RestartLocal {@link DexDebugOpNode.RestartLocal#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugOpNode.RestartLocal#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.RestartLocal.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_RestartLocalAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    RestartLocal restartLocal = new RestartLocal(new DexLabel(), 1);
    DexDebugNode cv = new DexDebugNode();

    // Act
    restartLocal.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult).reg);
    assertSame(restartLocal.label, ((RestartLocal) getResult).label);
  }

  /**
   * Test DexDebugOpNode_RestartLocal {@link DexDebugOpNode.RestartLocal#RestartLocal(DexLabel,
   * int)}.
   *
   * <p>Method under test: {@link DexDebugOpNode.RestartLocal#RestartLocal(DexLabel, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugOpNode.RestartLocal.<init>(DexLabel, int)"})
  public void testDexDebugOpNode_RestartLocalNewRestartLocal() {
    // Arrange, Act and Assert
    assertEquals(1, (new RestartLocal(new DexLabel(), 1)).reg);
  }

  /**
   * Test DexDebugOpNode_StartLocalNode {@link StartLocalNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link StartLocalNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StartLocalNode.accept(DexDebugVisitor)"})
  public void testDexDebugOpNode_StartLocalNodeAccept_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    StartLocalNode startLocalNode =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");
    DexDebugNode cv = new DexDebugNode();

    // Act
    startLocalNode.accept(cv);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = cv.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertEquals(1, ((StartLocalNode) getResult).reg);
    assertSame(startLocalNode.label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test DexDebugOpNode_StartLocalNode {@link StartLocalNode#StartLocalNode(DexLabel, int, String,
   * String, String)}.
   *
   * <p>Method under test: {@link StartLocalNode#StartLocalNode(DexLabel, int, String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StartLocalNode.<init>(DexLabel, int, String, String, String)"})
  public void testDexDebugOpNode_StartLocalNodeNewStartLocalNode() {
    // Arrange and Act
    StartLocalNode actualStartLocalNode =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    // Assert
    assertEquals("Name", actualStartLocalNode.name);
    assertEquals("Signature", actualStartLocalNode.signature);
    assertEquals("Type", actualStartLocalNode.type);
    assertEquals(1, actualStartLocalNode.reg);
  }

  /**
   * Test {@link DexDebugNode#visitRestartLocal(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitRestartLocal(int, DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitRestartLocal(int, DexLabel)"})
  public void testVisitRestartLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitRestartLocal(1, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult).reg);
    assertSame(label, ((RestartLocal) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitParameterName(int, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames} is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitParameterName(int, String)"})
  public void testVisitParameterName_givenDexDebugNodeParameterNamesIsArrayList() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.parameterNames = new ArrayList<>();

    // Act
    dexDebugNode.visitParameterName(1, "Name");

    // Assert
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    assertNull(stringList.get(0));
  }

  /**
   * Test {@link DexDebugNode#visitParameterName(int, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames} size
   *       is two.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitParameterName(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitParameterName(int, String)"})
  public void testVisitParameterName_givenDexDebugNode_thenDexDebugNodeParameterNamesSizeIsTwo() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();

    // Act
    dexDebugNode.visitParameterName(1, "Name");

    // Assert
    List<String> stringList = dexDebugNode.parameterNames;
    assertEquals(2, stringList.size());
    assertEquals("Name", stringList.get(1));
    assertNull(stringList.get(0));
  }

  /**
   * Test {@link DexDebugNode#visitLineNumber(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitLineNumber(int, DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitLineNumber(int, DexLabel)"})
  public void testVisitLineNumber_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitLineNumber(2, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult).line);
    assertSame(label, ((LineNumber) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitStartLocal(int, DexLabel, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitStartLocal(int, DexLabel, String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitStartLocal(int, DexLabel, String, String, String)"})
  public void testVisitStartLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitStartLocal(1, label, "Name", "Type", "Signature");

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertEquals(1, ((StartLocalNode) getResult).reg);
    assertSame(label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitEndLocal(int, DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitEndLocal(int, DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitEndLocal(int, DexLabel)"})
  public void testVisitEndLocal_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel label = new DexLabel();

    // Act
    dexDebugNode.visitEndLocal(1, label);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(label, ((EndLocal) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept3() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept4() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept5() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept6() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept7() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept8() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitParameterName one and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNodeVisitParameterNameOneAndName() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitParameterName one and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNodeVisitParameterNameOneAndName2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNodeVisitSetFileFile() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNodeVisitSetFileFile2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor) visitSetFile {@code File}.
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#fineName} is {@code
   *       File}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNodeVisitSetFileFile_thenDexDebugNodeFineNameIsFile() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitSetFile("File");
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertEquals("File", v.fineName);
    assertSame(dexDebugNode2.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>When {@link DexDebugVisitor#DexDebugVisitor()}.
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_givenDexDebugNode_whenDexDebugVisitor_thenDexDebugNodeDebugNodesEmpty() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    assertTrue(dexDebugNode.debugNodes.isEmpty());
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.EndLocal}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstEndLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    EndLocal dexDebugNode2 = new EndLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof EndLocal);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertEquals(1, ((EndLocal) getResult).reg);
    assertSame(dexDebugNode2.label, ((EndLocal) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Epiogue#Epiogue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstIsEpiogueWithLabelIsDexLabel() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Epiogue#Epiogue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstIsEpiogueWithLabelIsDexLabel2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Prologue#Prologue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstIsPrologueWithLabelIsDexLabel() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor());

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first is
   *       {@link DexDebugOpNode.Prologue#Prologue(DexLabel)} with label is {@link
   *       DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstIsPrologueWithLabelIsDexLabel2() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);

    // Act
    dexDebugNode.accept(new DexDebugVisitor(new DexDebugVisitor()));

    // Assert that nothing has changed
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    assertSame(dexDebugNode2, dexDebugOpNodeList.get(0));
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.LineNumber}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstLineNumber() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    LineNumber dexDebugNode2 = new LineNumber(new DexLabel(), 2);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof LineNumber);
    assertEquals(2, ((LineNumber) getResult2).line);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((LineNumber) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.Prologue}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstPrologue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Prologue dexDebugNode2 = new Prologue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof Prologue);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((Prologue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.RestartLocal}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstRestartLocal() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    RestartLocal dexDebugNode2 = new RestartLocal(new DexLabel(), 1);

    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(1);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(0);
    assertTrue(getResult2 instanceof RestartLocal);
    assertEquals(1, ((RestartLocal) getResult2).reg);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode2.label, ((RestartLocal) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link StartLocalNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeDebugNodesFirstStartLocalNode() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    StartLocalNode dexDebugNode2 =
        new StartLocalNode(new DexLabel(), 1, "Name", "Type", "Signature");

    dexDebugNode.addDebug(dexDebugNode2);
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof StartLocalNode);
    assertEquals("Name", ((StartLocalNode) getResult).name);
    assertEquals("Signature", ((StartLocalNode) getResult).signature);
    assertEquals("Type", ((StartLocalNode) getResult).type);
    assertSame(dexDebugNode2.label, ((StartLocalNode) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#parameterNames}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_thenDexDebugNodeParameterNames() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    dexDebugNode.visitParameterName(1, "Name");
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    dexDebugNode.addDebug(new Epiogue(new DexLabel()));
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    assertEquals(dexDebugNode.parameterNames, v.parameterNames);
  }

  /**
   * Test {@link DexDebugNode#accept(DexDebugVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} first
   *       {@link DexDebugOpNode.Epiogue}.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#accept(DexDebugVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.accept(DexDebugVisitor)"})
  public void testAccept_whenDexDebugNode_thenDexDebugNodeDebugNodesFirstEpiogue() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    Epiogue dexDebugNode2 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode2);
    Epiogue dexDebugNode3 = new Epiogue(new DexLabel());
    dexDebugNode.addDebug(dexDebugNode3);
    DexDebugNode v = new DexDebugNode();

    // Act
    dexDebugNode.accept(v);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = v.debugNodes;
    assertEquals(2, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    DexDebugOpNode getResult2 = dexDebugOpNodeList.get(1);
    assertTrue(getResult2 instanceof Epiogue);
    assertSame(dexDebugNode2.label, ((Epiogue) getResult).label);
    assertSame(dexDebugNode3.label, ((Epiogue) getResult2).label);
  }

  /**
   * Test {@link DexDebugNode#visitPrologue(DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitPrologue(DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitPrologue(DexLabel)"})
  public void testVisitPrologue_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitPrologue(dexLabel);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Prologue);
    assertSame(dexLabel, ((Prologue) getResult).label);
  }

  /**
   * Test {@link DexDebugNode#visitEpiogue(DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexDebugNode} (default constructor).
   *   <li>Then {@link DexDebugNode} (default constructor) {@link DexDebugNode#debugNodes} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link DexDebugNode#visitEpiogue(DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.visitEpiogue(DexLabel)"})
  public void testVisitEpiogue_givenDexDebugNode_thenDexDebugNodeDebugNodesSizeIsOne() {
    // Arrange
    DexDebugNode dexDebugNode = new DexDebugNode();
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugNode.visitEpiogue(dexLabel);

    // Assert
    List<DexDebugOpNode> dexDebugOpNodeList = dexDebugNode.debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof Epiogue);
    assertSame(dexLabel, ((Epiogue) getResult).label);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DexDebugNode}
   *   <li>{@link DexDebugNode#visitSetFile(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexDebugNode.<init>()", "void DexDebugNode.visitSetFile(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DexDebugNode actualDexDebugNode = new DexDebugNode();
    actualDexDebugNode.visitSetFile("File");

    // Assert
    assertTrue(actualDexDebugNode.debugNodes.isEmpty());
  }
}
