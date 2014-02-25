import static org.junit.Assert.*;

import org.junit.Test;


public class inOrderTest {

	@Test
	public void test() {
		BinaryTree BT = new BinaryTree();
		BT.add(20);
		BT.add(33);
		BT.add(4);
		BT.add(10);
		BT.add(115);
		BT.add(0);
		BT.inOrderTraversal();
		//assertEquals(inOrder, "0 4 10 20 33 115");
	}

}
