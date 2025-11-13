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
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode.Item;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

class DexClassNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Interface Names}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexClassNode#DexClassNode(int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when array of String with 'Interface Names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexClassNode.<init>(int, String, String, String[])",
    "void DexClassNode.<init>(DexClassVisitor, int, String, String, String[])",
    "void DexClassNode.visitSource(String)"
  })
  void testGettersAndSetters_whenArrayOfStringWithInterfaceNames() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    // Act
    DexClassNode actualDexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[] {"Interface Names"}, actualDexClassNode.interfaceNames);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexClassNode#DexClassNode(DexClassVisitor, int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when DexClassVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexClassNode.<init>(int, String, String, String[])",
    "void DexClassNode.<init>(DexClassVisitor, int, String, String, String[])",
    "void DexClassNode.visitSource(String)"
  })
  void testGettersAndSetters_whenDexClassVisitor() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    // Act
    DexClassNode actualDexClassNode =
        new DexClassNode(new DexClassVisitor(), 1, "Class Name", "Super Class", interfaceNames);
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[] {"Interface Names"}, actualDexClassNode.interfaceNames);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertNull(dexClassNode.source);
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv2() {
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

    ArrayList<Item> itemList3 = new ArrayList<>();
    itemList3.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode3 = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode3.items = itemList3;

    ArrayList<DexAnnotationNode> dexAnnotationNodeList2 = new ArrayList<>();
    dexAnnotationNodeList2.add(dexAnnotationNode3);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    DexMethodNode dexMethodNode = new DexMethodNode(1, method);
    dexMethodNode.anns = dexAnnotationNodeList2;
    dexMethodNode.visitParameterAnnotation(1);
    dexMethodNode.codeNode = new DexCodeNode();

    ArrayList<DexMethodNode> dexMethodNodeList = new ArrayList<>();
    dexMethodNodeList.add(dexMethodNode);

    ArrayList<DexFieldNode> dexFieldNodeList = new ArrayList<>();
    Field field = new Field("Owner", "Name", "Type");
    DexFieldNode dexFieldNode = new DexFieldNode(1, field, Constant.Null);
    dexFieldNodeList.add(dexFieldNode);
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.anns = dexAnnotationNodeList;
    dexClassNode.methods = dexMethodNodeList;
    dexClassNode.fields = dexFieldNodeList;
    dexClassNode.visitSource("foo");
    DexClassVisitor dcv = new DexClassVisitor(new DexClassVisitor(new DexClassVisitor()));

    // Act
    dexClassNode.accept(new DexClassVisitor(dcv));

    // Assert that nothing has changed
    List<DexAnnotationNode> dexAnnotationNodeList3 = dexClassNode.anns;
    assertEquals(1, dexAnnotationNodeList3.size());
    DexAnnotationNode getResult = dexAnnotationNodeList3.get(0);
    assertEquals("Type", getResult.type);
    List<Item> itemList4 = getResult.items;
    assertEquals(1, itemList4.size());
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertSame(itemList2, itemList4);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv3() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv4() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv5() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv6() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitSource("File");
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv7() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dcv.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(2, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(1);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv8() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    Field field2 = new Field("Owner", "Name", "Type");
    dcv.visitField(1, field2, Constant.Null);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(2, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(1);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv9() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    dcv.visitMethod(1, method2);

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(2, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(1);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#anns} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first anns size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstAnnsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#fields} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first fields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstFieldsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexFieldNode> dexFieldNodeList = dexClassNodeList.get(0).fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    List<DexFieldNode> dexFieldNodeList2 = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(field, dexFieldNodeList2.get(0).field);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#methods} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first methods size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstMethodsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexMethodNode> dexMethodNodeList = dexClassNodeList.get(0).methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    List<DexMethodNode> dexMethodNodeList2 = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(method, dexMethodNodeList2.get(0).method);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first source is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstSourceIsFile() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitSource("File");
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("File", getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileNode} (default constructor).
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; when DexFileNode (default constructor); then DexFileNode (default constructor) clzs first source is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_whenDexFileNode_thenDexFileNodeClzsFirstSourceIsNull() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertNull(getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexClassNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexClassNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexClassNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#visitField(int, Field, Object)}.
   *
   * <p>Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  @DisplayName("Test visitField(int, Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexFieldVisitor DexClassNode.visitField(int, Field, Object)"})
  void testVisitField() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");

    // Act
    DexFieldVisitor actualVisitFieldResult = dexClassNode.visitField(1, field, Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field2 = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field2.getName());
    assertEquals("Owner", field2.getOwner());
    assertEquals("Type", field2.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Test {@link DexClassNode#visitField(int, Field, Object)}.
   *
   * <p>Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  @DisplayName("Test visitField(int, Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexFieldVisitor DexClassNode.visitField(int, Field, Object)"})
  void testVisitField2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.fields = new ArrayList<>();
    Field field = new Field("Owner", "Name", "Type");

    // Act
    DexFieldVisitor actualVisitFieldResult = dexClassNode.visitField(1, field, Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field2 = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field2.getName());
    assertEquals("Owner", field2.getOwner());
    assertEquals("Type", field2.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Test {@link DexClassNode#visitMethod(int, Method)}.
   *
   * <p>Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  @DisplayName("Test visitMethod(int, Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexMethodVisitor DexClassNode.visitMethod(int, Method)"})
  void testVisitMethod() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act
    DexMethodVisitor actualVisitMethodResult = dexClassNode.visitMethod(1, method);

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method2 = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, method2.getParameterTypes().length);
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link DexClassNode#visitMethod(int, Method)}.
   *
   * <p>Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  @DisplayName("Test visitMethod(int, Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexMethodVisitor DexClassNode.visitMethod(int, Method)"})
  void testVisitMethod2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.methods = new ArrayList<>();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act
    DexMethodVisitor actualVisitMethodResult = dexClassNode.visitMethod(1, method);

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method2 = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, method2.getParameterTypes().length);
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method2.getProto());
  }
}
