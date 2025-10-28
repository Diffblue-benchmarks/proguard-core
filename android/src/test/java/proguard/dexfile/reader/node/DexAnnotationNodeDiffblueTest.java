package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationAble;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;

public class DexAnnotationNodeDiffblueTest {
  /**
   * Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    DexClassNode av = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = av.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Type", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Method under test: {@link DexAnnotationNode.Item#Item(String, Object)}
   */
  @Test
  public void testItemNewItem() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DexAnnotationNode.Item("Name", Constant.Null)).name);
  }

  /**
   * Method under test: {@link DexAnnotationNode#visit(String, Object)}
   */
  @Test
  public void testVisit() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    Object object = Constant.Null;

    // Act
    dexAnnotationNode.visit("Name", object);

    // Assert
    List<DexAnnotationNode.Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    DexAnnotationNode.Item getResult = itemList.get(0);
    assertEquals("Name", getResult.name);
    assertSame(object, getResult.value);
  }

  /**
   * Method under test: {@link DexAnnotationNode#visitAnnotation(String, String)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexAnnotationNode.visitAnnotation("Name",
        "The characteristics of someone or something");

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    List<DexAnnotationNode.Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    assertEquals("Name", itemList.get(0).name);
    assertEquals("The characteristics of someone or something", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(Visibility.RUNTIME, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Method under test:
   * {@link DexAnnotationNode#visitEnum(String, String, String)}
   */
  @Test
  public void testVisitEnum() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    dexAnnotationNode.visitEnum("Name", "The characteristics of someone or something", "42");

    // Assert
    List<DexAnnotationNode.Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    DexAnnotationNode.Item getResult = itemList.get(0);
    Object object = getResult.value;
    assertTrue(object instanceof Field);
    assertEquals("42", ((Field) object).getName());
    assertEquals("Name", getResult.name);
    assertEquals("The characteristics of someone or something", ((Field) object).getOwner());
    assertEquals("The characteristics of someone or something", ((Field) object).getType());
  }

  /**
   * Method under test:
   * {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}
   */
  @Test
  public void testNewDexAnnotationNode() {
    // Arrange and Act
    DexAnnotationNode actualDexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Assert
    assertEquals("Type", actualDexAnnotationNode.type);
    assertEquals(Visibility.BUILD, actualDexAnnotationNode.visibility);
    assertTrue(actualDexAnnotationNode.items.isEmpty());
  }
}
