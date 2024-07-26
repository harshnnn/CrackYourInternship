
class LinkedList {
	Node head; 

	class Node {
		int data;
		Node next, bottom;
		Node(int data)
		{
			this.data = data;
			next = null;
			bottom = null;
		}
	}

	Node merge(Node a, Node b)
	{
		if (a == null)
			return b;
		if (b == null)
			return a;

		Node result;

		if (a.data < b.data) {
			result = a;
			result.bottom = merge(a.bottom, b);
		}

		else {
			result = b;
			result.bottom = merge(a, b.bottom);
		}
		result.next = null;
		return result;
	}

	Node flatten(Node root)
	{
		if (root == null || root.next == null)
			return root;
		root.next = flatten(root.next);
		root = merge(root, root.next);
		return root;
	}
	Node push(Node head_ref, int data)
	{
		Node new_node = new Node(data);
		new_node.bottom = head_ref;
		head_ref = new_node;
		return head_ref;
	}

	void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.bottom;
		}
		System.out.println();
	}

} 
