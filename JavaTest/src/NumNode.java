// we have the class NumNode in the file NumNode.java

public class NumNode

{
	// by making Nodes variable static, it will be common to all
	// instances of the class
	private static NumNode Nodes = null;

	int Value;
	NumNode Next;

	// constructor
	public NumNode(int V) {
		Value = V;
		Next = null;
	}

	// make the following methods visible externally, e.g. to main(), via
	// public; the ones which are class methods rather than instance
	// methods also are static

	public static NumNode Head() {
		return Nodes;
	}

	public void Insert() {
		if (Nodes == null) {
			Nodes = this;
			return;
		} else if (Value > Nodes.Value) {
			this.Next = Nodes;
			Nodes = this;
			return;
		} else {
			for (NumNode N = Nodes; N.Next != null; N = N.Next) {
				if (N.Next.Value < Value) {
					this.Next = N.Next;
					N.Next = this;
					return;
				} else if (N.Next.Next == null) {
					N.Next.Next = this;
					return;
				}
			}
		}
	}

	public static void PrintList() {
		if (Nodes == null)
			return;
		for (NumNode N = Nodes; N != null; N = N.Next)
			System.out.println(N.Value);
	}

}
