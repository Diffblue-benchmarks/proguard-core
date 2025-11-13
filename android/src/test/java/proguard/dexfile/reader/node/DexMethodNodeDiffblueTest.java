package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode.Item;
import proguard.dexfile.reader.node.insn.ConstStmtNode;
import proguard.dexfile.reader.node.insn.DexLabelStmtNode;
import proguard.dexfile.reader.node.insn.FieldStmtNode;
import proguard.dexfile.reader.node.insn.FillArrayDataStmtNode;
import proguard.dexfile.reader.node.insn.FilledNewArrayStmtNode;
import proguard.dexfile.reader.node.insn.JumpStmtNode;
import proguard.dexfile.reader.node.insn.MethodCustomStmtNode;
import proguard.dexfile.reader.node.insn.MethodPolymorphicStmtNode;
import proguard.dexfile.reader.node.insn.Stmt0RNode;
import proguard.dexfile.reader.node.insn.Stmt1RNode;
import proguard.dexfile.reader.visitors.DexAnnotationAble;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexCodeVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

class DexMethodNodeDiffblueTest {
  /**
   * Test {@link DexMethodNode#DexMethodNode(DexMethodVisitor, int, Method)}.
   *
   * <ul>
   *   <li>When {@link DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#DexMethodNode(DexMethodVisitor, int, Method)}
   */
  @Test
  @DisplayName("Test new DexMethodNode(DexMethodVisitor, int, Method); when DexMethodVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexMethodNode.<init>(int, Method)",
    "void DexMethodNode.<init>(DexMethodVisitor, int, Method)"
  })
  void testNewDexMethodNode_whenDexMethodVisitor() {
    // Arrange
    DexMethodVisitor mv = new DexMethodVisitor();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act and Assert
    Method method2 = new DexMethodNode(mv, 1, method).method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertSame(proto, method2.getProto());
    assertArrayEquals(new String[] {"Parameter Types"}, method2.getParameterTypes());
  }

  /**
   * Test {@link DexMethodNode#DexMethodNode(int, Method)}.
   *
   * <ul>
   *   <li>When {@link Method#Method(String, String, Proto)} with {@code Owner} and {@code Name} and
   *       proto is {@link Proto#Proto(String[], String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#DexMethodNode(int, Method)}
   */
  @Test
  @DisplayName(
      "Test new DexMethodNode(int, Method); when Method(String, String, Proto) with 'Owner' and 'Name' and proto is Proto(String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexMethodNode.<init>(int, Method)",
    "void DexMethodNode.<init>(DexMethodVisitor, int, Method)"
  })
  void testNewDexMethodNode_whenMethodWithOwnerAndNameAndProtoIsProto() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act
    DexMethodNode actualDexMethodNode = new DexMethodNode(1, method);

    // Assert
    Method method2 = actualDexMethodNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertSame(proto, method2.getProto());
    assertArrayEquals(new String[] {"Parameter Types"}, method2.getParameterTypes());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(proto, dexMethodNode.method.getProto());
    assertSame(dexMethodNode.method, getResult.method);
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv2() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexMethodNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv3() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.visitParameterAnnotation(1);
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(proto, dexMethodNode.method.getProto());
    assertSame(dexMethodNode.method, getResult.method);
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv4() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();

    dexCodeNode.visitTryCatch(start, end, new DexLabel[] {new DexLabel()}, new String[] {"Type"});
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv5() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new ConstStmtNode(Op.NOP, 1, Constant.Null));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv6() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    Field field = new Field("Owner", "Name", "Type");
    dexCodeNode.add(new FieldStmtNode(Op.NOP, 1, 1, field));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv7() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv8() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    FilledNewArrayStmtNode stmt =
        new FilledNewArrayStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, "Type");
    dexCodeNode.add(stmt);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv9() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new JumpStmtNode(Op.NOP, 1, 1, new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv10() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode stmt =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, method, proto2);
    dexCodeNode.add(stmt);
    String[] parameterTypes3 = new String[] {"Parameter Types"};
    Proto proto3 = new Proto(parameterTypes3, "Return Type");
    Method method2 = new Method("Owner", "Name", proto3);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method2);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method3 = dexMethodNode.method;
    assertEquals(1, method3.getParameterTypes().length);
    assertSame(proto3, method3.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given ArrayList() add Item(String, Object) with 'Name' and value is Field(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenArrayListAddItemWithNameAndValueIsField() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    Field field = new Field("Owner", "Name", "Type");
    Item item = new Item("Name", field);
    itemList.add(item);
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item2 = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item2);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given ArrayList() add Item(String, Object) with 'Name' and value is Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenArrayListAddItemWithNameAndValueIsNull() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given ArrayList() add Item(String, Object) with 'Name' and value is Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenArrayListAddItemWithNameAndValueIsNull2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(new DexAnnotationNode("Type", Visibility.BUILD));
    dexAnnotationNodeList.add(dexAnnotationNode2);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link
   *       DexLabelStmtNode#DexLabelStmtNode(DexLabel)} with label is {@link DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given DexCodeNode() add DexLabelStmtNode(DexLabel) with label is DexLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenDexCodeNodeAddDexLabelStmtNodeWithLabelIsDexLabel() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link Stmt0RNode#Stmt0RNode(Op)} with op is
   *       {@code NOP}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given DexCodeNode() add Stmt0RNode(Op) with op is 'NOP'; then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenDexCodeNodeAddStmt0RNodeWithOpIsNop_thenArrayLengthIsOne() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt0RNode(Op.NOP));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link Stmt1RNode#Stmt1RNode(Op, int)} with
   *       op is {@code NOP} and a is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given DexCodeNode() add Stmt1RNode(Op, int) with op is 'NOP' and a is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenDexCodeNodeAddStmt1RNodeWithOpIsNopAndAIsOne() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt1RNode(Op.NOP, 1));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} visitRegister one.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given DexCodeNode() visitRegister one; then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenDexCodeNodeVisitRegisterOne_thenArrayLengthIsOne() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.visitRegister(1);
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>Given {@link MethodHandle#MethodHandle(int, Field)} with type is one and field is {@link
   *       Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; given MethodHandle(int, Field) with type is one and field is Field(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_givenMethodHandleWithTypeIsOneAndFieldIsField() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);

    DexCodeNode dexCodeNode = new DexCodeNode();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode stmt =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, "Name", proto, bsm, bsmArgs);
    dexCodeNode.add(stmt);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexClassVisitor dcv2 = new DexClassVisitor(new DexClassVisitor(dcv));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv2));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto2, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'; when DexClassVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_whenDexClassVisitor() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    dexMethodNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; when DexClassVisitor(DexClassVisitor) with dcv is DexClassVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassVisitor() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    Item item = new Item("Name", dexAnnotationNode);

    ArrayList<Item> itemList2 = new ArrayList<>();
    itemList2.add(item);
    DexAnnotationNode dexAnnotationNode2 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode2.items = itemList2;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode2);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    DexClassVisitor dcv = new DexClassVisitor(new DexClassVisitor(new DexClassVisitor()));

    // Act
    dexMethodNode.accept(new DexClassVisitor(dcv));

    // Assert that nothing has changed
    Method method2 = dexMethodNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(mv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = mv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();

    dexCodeNode.visitTryCatch(start, end, new DexLabel[] {new DexLabel()}, new String[] {"Type"});
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv3() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new ConstStmtNode(Op.NOP, 1, Constant.Null));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv4() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    Field field = new Field("Owner", "Name", "Type");
    dexCodeNode.add(new FieldStmtNode(Op.NOP, 1, 1, field));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv5() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv6() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    FilledNewArrayStmtNode stmt =
        new FilledNewArrayStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, "Type");
    dexCodeNode.add(stmt);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv7() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new JumpStmtNode(Op.NOP, 1, 1, new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv8() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode stmt =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, method, proto2);
    dexCodeNode.add(stmt);
    String[] parameterTypes3 = new String[] {"Parameter Types"};
    Proto proto3 = new Proto(parameterTypes3, "Return Type");
    Method method2 = new Method("Owner", "Name", proto3);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method2);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes4 = new String[] {"Parameter Types"};
    Proto proto4 = new Proto(parameterTypes4, "Return Type");
    Method method3 = new Method("Owner", "Name", proto4);
    DexMethodNode mv = new DexMethodNode(1, method3);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given ArrayList() add Item(String, Object) with 'Name' and value is Field(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenArrayListAddItemWithNameAndValueIsField() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    Field field = new Field("Owner", "Name", "Type");
    Item item = new Item("Name", field);
    itemList.add(item);
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given ArrayList() add Item(String, Object) with 'Name' and value is Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenArrayListAddItemWithNameAndValueIsNull() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)} with {@code Type}
   *       and visibility is {@code BUILD}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexAnnotationNode(String, Visibility) with 'Type' and visibility is 'BUILD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenDexAnnotationNodeWithTypeAndVisibilityIsBuild() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    Item item = new Item("Name", new DexAnnotationNode("Type", Visibility.BUILD));
    itemList.add(item);
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link
   *       DexLabelStmtNode#DexLabelStmtNode(DexLabel)} with label is {@link DexLabel#DexLabel()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexCodeNode() add DexLabelStmtNode(DexLabel) with label is DexLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenDexCodeNodeAddDexLabelStmtNodeWithLabelIsDexLabel() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link Stmt0RNode#Stmt0RNode(Op)} with op is
   *       {@code NOP}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexCodeNode() add Stmt0RNode(Op) with op is 'NOP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenDexCodeNodeAddStmt0RNodeWithOpIsNop() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt0RNode(Op.NOP));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} add {@link Stmt1RNode#Stmt1RNode(Op, int)} with
   *       op is {@code NOP} and a is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexCodeNode() add Stmt1RNode(Op, int) with op is 'NOP' and a is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenDexCodeNodeAddStmt1RNodeWithOpIsNopAndAIsOne() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt1RNode(Op.NOP, 1));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} visitRegister one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'; given DexCodeNode() visitRegister one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenDexCodeNodeVisitRegisterOne() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.visitRegister(1);
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link MethodHandle#MethodHandle(int, Field)} with type is one and field is {@link
   *       Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given MethodHandle(int, Field) with type is one and field is Field(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_givenMethodHandleWithTypeIsOneAndFieldIsField() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);

    DexCodeNode dexCodeNode = new DexCodeNode();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode stmt =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, 5, 1, 5}, "Name", proto, bsm, bsmArgs);
    dexCodeNode.add(stmt);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = dexCodeNode;
    String[] parameterTypes3 = new String[] {"Parameter Types"};
    Proto proto3 = new Proto(parameterTypes3, "Return Type");
    Method method2 = new Method("Owner", "Name", proto3);
    DexMethodNode mv = new DexMethodNode(1, method2);

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(mv)));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Then {@link DexMethodNode#DexMethodNode(int, Method)} with access is one and method is
   *       {@link Method#Method(String, String, Proto)} {@link DexMethodNode#anns} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; then DexMethodNode(int, Method) with access is one and method is Method(String, String, Proto) anns is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_thenDexMethodNodeWithAccessIsOneAndMethodIsMethodAnnsIsNull() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    dexMethodNode.accept(new DexMethodVisitor());

    // Assert that nothing has changed
    assertNull(dexMethodNode.anns);
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Then {@link DexMethodNode#DexMethodNode(int, Method)} with access is one and method is
   *       {@link Method#Method(String, String, Proto)} {@link DexMethodNode#anns} size is two.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; then DexMethodNode(int, Method) with access is one and method is Method(String, String, Proto) anns size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_thenDexMethodNodeWithAccessIsOneAndMethodIsMethodAnnsSizeIsTwo() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);

    DexMethodNode mv = new DexMethodNode(1, method2);
    mv.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexMethodNode.accept(mv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = mv.anns;
    assertEquals(2, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(1);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>When {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)} with mv is {@link
   *       DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; when DexMethodVisitor(DexMethodVisitor) with mv is DexMethodVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexMethodNode.accept(DexMethodVisitor)"})
  void testAcceptWithMv_whenDexMethodVisitorWithMvIsDexMethodVisitor() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList = new ArrayList<>();
    dexAnnotationNodeList.add(dexAnnotationNode);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();

    // Act
    dexMethodNode.accept(new DexMethodVisitor(new DexMethodVisitor(new DexMethodVisitor())));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexMethodNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    DexAnnotationNode getResult = dexAnnotationNodeList2.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList2 = getResult.items;
    assertEquals(1, itemList2.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList, itemList2);
  }

  /**
   * Test {@link DexMethodNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexMethodNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexMethodNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodNode#DexMethodNode(int, Method)} with access is one and method is
   *       {@link Method#Method(String, String, Proto)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexMethodNode(int, Method) with access is one and method is Method(String, String, Proto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation_givenDexMethodNodeWithAccessIsOneAndMethodIsMethod() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexMethodNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @DisplayName("Test visitCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  void testVisitCode() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @DisplayName("Test visitCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  void testVisitCode2() {
    // Arrange
    DexMethodVisitor mv = new DexMethodVisitor();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(mv, -1, method);

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @DisplayName("Test visitCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  void testVisitCode3() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode mv = new DexMethodNode(-1, method);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);

    DexMethodNode dexMethodNode = new DexMethodNode(mv, -1, method2);

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitParameterAnnotation(int)}.
   *
   * <p>Method under test: {@link DexMethodNode#visitParameterAnnotation(int)}
   */
  @Test
  @DisplayName("Test visitParameterAnnotation(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationAble DexMethodNode.visitParameterAnnotation(int)"})
  void testVisitParameterAnnotation() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    DexAnnotationAble actualVisitParameterAnnotationResult =
        dexMethodNode.visitParameterAnnotation(1);

    // Assert
    Method method2 = dexMethodNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    List<DexAnnotationNode>[] listArray = dexMethodNode.parameterAnns;
    assertNull(listArray[0]);
    assertNull(dexMethodNode.anns);
    assertNull(dexMethodNode.codeNode);
    assertNull(actualVisitParameterAnnotationResult);
    assertEquals(1, method2.getParameterTypes().length);
    assertEquals(1, listArray.length);
    assertEquals(1, dexMethodNode.access);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#visitParameterAnnotation(int)}.
   *
   * <p>Method under test: {@link DexMethodNode#visitParameterAnnotation(int)}
   */
  @Test
  @DisplayName("Test visitParameterAnnotation(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationAble DexMethodNode.visitParameterAnnotation(int)"})
  void testVisitParameterAnnotation2() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.visitParameterAnnotation(1);

    // Act
    DexAnnotationAble actualVisitParameterAnnotationResult =
        dexMethodNode.visitParameterAnnotation(1);

    // Assert
    Method method2 = dexMethodNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    List<DexAnnotationNode>[] listArray = dexMethodNode.parameterAnns;
    assertNull(listArray[0]);
    assertNull(dexMethodNode.anns);
    assertNull(dexMethodNode.codeNode);
    assertNull(actualVisitParameterAnnotationResult);
    assertEquals(1, method2.getParameterTypes().length);
    assertEquals(1, listArray.length);
    assertEquals(1, dexMethodNode.access);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexMethodNode#visitParameterAnnotation(int)}.
   *
   * <ul>
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#visitParameterAnnotation(int)}
   */
  @Test
  @DisplayName("Test visitParameterAnnotation(int); then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationAble DexMethodNode.visitParameterAnnotation(int)"})
  void testVisitParameterAnnotation_thenSecondElementIsNull() {
    // Arrange
    Proto proto =
        new Proto(
            new String[] {
              "Warning, ignoring parameter annotations for out of range parameter index ", " in: "
            },
            "Return Type");
    Method method = new Method("Owner", "Name", proto);
    DexMethodNode dexMethodNode = new DexMethodNode(1, method);

    // Act
    dexMethodNode.visitParameterAnnotation(1);

    // Assert
    Method method2 = dexMethodNode.method;
    assertEquals(
        "(Warning, ignoring parameter annotations for out of range parameter index  in: )Return Type",
        method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    List<DexAnnotationNode>[] listArray = dexMethodNode.parameterAnns;
    assertNull(listArray[0]);
    assertNull(listArray[1]);
    assertNull(dexMethodNode.anns);
    assertNull(dexMethodNode.codeNode);
    assertEquals(1, dexMethodNode.access);
    assertEquals(2, method2.getParameterTypes().length);
    assertEquals(2, listArray.length);
    assertSame(proto, method2.getProto());
  }
}
