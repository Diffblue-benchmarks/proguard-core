package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexDebugNode;

public class DexDebugVisitorDiffblueTest {
  /**
   * Method under test: {@link DexDebugVisitor#visitParameterName(int, String)}
   */
  @Test
  public void testVisitParameterName() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitParameterName(1, "Name");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.parameterNames, ((DexDebugNode) dexDebugVisitor2).parameterNames);
  }

  /**
   * Method under test:
   * {@link DexDebugVisitor#visitStartLocal(int, DexLabel, String, String, String)}
   */
  @Test
  public void testVisitStartLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitStartLocal(1, new DexLabel(), "Name", "Type", "Signature");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitLineNumber(int, DexLabel)}
   */
  @Test
  public void testVisitLineNumber() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitLineNumber(2, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Method under test: {@link DexDebugVisitor#DexDebugVisitor()}
   */
  @Test
  public void testNewDexDebugVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexDebugVisitor()).visitor);
    assertNull((new DexDebugVisitor(new DexDebugVisitor())).visitor.visitor);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitEndLocal(int, DexLabel)}
   */
  @Test
  public void testVisitEndLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitEndLocal(1, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitSetFile(String)}
   */
  @Test
  public void testVisitSetFile() {
    // Arrange
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(new DexDebugNode());

    // Act
    dexDebugVisitor.visitSetFile("File");

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertEquals("File", ((DexDebugNode) dexDebugVisitor2).fineName);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitPrologue(DexLabel)}
   */
  @Test
  public void testVisitPrologue() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugVisitor.visitPrologue(dexLabel);

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = ((DexDebugNode) dexDebugVisitor2).debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Prologue);
    assertSame(dexLabel, ((DexDebugNode.DexDebugOpNode.Prologue) getResult).label);
    assertSame(visitor.debugNodes, dexDebugOpNodeList);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitEpiogue(DexLabel)}
   */
  @Test
  public void testVisitEpiogue() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);
    DexLabel dexLabel = new DexLabel();

    // Act
    dexDebugVisitor.visitEpiogue(dexLabel);

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    List<DexDebugNode.DexDebugOpNode> dexDebugOpNodeList = ((DexDebugNode) dexDebugVisitor2).debugNodes;
    assertEquals(1, dexDebugOpNodeList.size());
    DexDebugNode.DexDebugOpNode getResult = dexDebugOpNodeList.get(0);
    assertTrue(getResult instanceof DexDebugNode.DexDebugOpNode.Epiogue);
    assertSame(dexLabel, ((DexDebugNode.DexDebugOpNode.Epiogue) getResult).label);
    assertSame(visitor.debugNodes, dexDebugOpNodeList);
  }

  /**
   * Method under test: {@link DexDebugVisitor#visitRestartLocal(int, DexLabel)}
   */
  @Test
  public void testVisitRestartLocal() {
    // Arrange
    DexDebugNode visitor = new DexDebugNode();
    DexDebugVisitor dexDebugVisitor = new DexDebugVisitor(visitor);

    // Act
    dexDebugVisitor.visitRestartLocal(1, new DexLabel());

    // Assert
    DexDebugVisitor dexDebugVisitor2 = dexDebugVisitor.visitor;
    assertTrue(dexDebugVisitor2 instanceof DexDebugNode);
    assertSame(visitor.debugNodes, ((DexDebugNode) dexDebugVisitor2).debugNodes);
  }
}
