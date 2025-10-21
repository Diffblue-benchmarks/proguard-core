package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode.Item;
import proguard.dexfile.reader.visitors.DexAnnotationAble;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;

public class DexAnnotationNodeDiffblueTest {
  /**
   * Test Item {@link Item#Item(String, Object)}.
   *
   * <p>Method under test: {@link Item#Item(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Item.<init>(String, Object)"})
  public void testItemNewItem() {
    // Arrange, Act and Assert
    assertEquals("Name", (new Item("Name", Constant.Null)).name);
  }

  /**
   * Test {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   *
   * <p>Method under test: {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationNode.<init>(String, Visibility)"})
  public void testNewDexAnnotationNode() {
    // Arrange and Act
    DexAnnotationNode actualDexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Assert
    assertEquals("Type", actualDexAnnotationNode.type);
    assertEquals(Visibility.BUILD, actualDexAnnotationNode.visibility);
    assertTrue(actualDexAnnotationNode.items.isEmpty());
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationNode.accept(DexAnnotationAble)"})
  public void testAccept() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    DexClassNode av =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

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
   * Test {@link DexAnnotationNode#visit(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)} with {@code Type}
   *       and visibility is {@code BUILD} {@link DexAnnotationNode#items} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visit(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationNode.visit(String, Object)"})
  public void testVisit_thenDexAnnotationNodeWithTypeAndVisibilityIsBuildItemsSizeIsOne() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    Object object = Constant.Null;

    // Act
    dexAnnotationNode.visit("Name", object);

    // Assert
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    Item getResult = itemList.get(0);
    assertEquals("Name", getResult.name);
    assertSame(object, getResult.value);
  }

  /**
   * Test {@link DexAnnotationNode#visitAnnotation(String, String)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visitAnnotation(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexAnnotationNode.visitAnnotation(String, String)"})
  public void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexAnnotationNode.visitAnnotation("Name", "The characteristics of someone or something");

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    assertEquals("Name", itemList.get(0).name);
    assertEquals(
        "The characteristics of someone or something",
        ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(Visibility.RUNTIME, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexAnnotationNode#visitEnum(String, String, String)}.
   *
   * <ul>
   *   <li>Then {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)} with {@code Type}
   *       and visibility is {@code BUILD} {@link DexAnnotationNode#items} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visitEnum(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationNode.visitEnum(String, String, String)"})
  public void testVisitEnum_thenDexAnnotationNodeWithTypeAndVisibilityIsBuildItemsSizeIsOne() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    dexAnnotationNode.visitEnum("Name", "The characteristics of someone or something", "42");

    // Assert
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    Item getResult = itemList.get(0);
    Object object = getResult.value;
    assertTrue(object instanceof Field);
    assertEquals("42", ((Field) object).getName());
    assertEquals("Name", getResult.name);
    assertEquals("The characteristics of someone or something", ((Field) object).getOwner());
    assertEquals("The characteristics of someone or something", ((Field) object).getType());
  }
}
