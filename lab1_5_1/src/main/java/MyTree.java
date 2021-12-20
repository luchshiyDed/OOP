import java.net.Inet4Address;
import java.util.*;
import java.util.function.Consumer;

public class MyTree<T> implements Iterable {
    /**
     * Node type for tree nodes includes Value and a Key. Key differs one node from others.
     * @param <T>
     */
    public class Node<T> {
        private T Value;
        private Integer key;
        private ArrayList<Node> children;

        Node(int k, T Val) {
            key = k;
            Value = Val;
            children = new ArrayList<>();
        }

        public void changeValue(T val) {
            Value = val;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public T getValue() {
            return Value;
        }

        public Integer getKey() {
            return key;
        }

        private void addChild(Node n) {
            children.add(n);
        }

        @Override
        public String toString() {
            return "(" + key.toString() + "," + Value.toString() + ")";
        }

        Boolean isLeaf() {
            return !children.isEmpty();
        }

        private void deleteNode() {
            children.clear();
        }
    }

    private Node root;
    private ArrayList<Integer> keys;
    private Node finder;

    MyTree() {
        root = null;
        finder = null;
        keys = new ArrayList<Integer>();
    }

    /**
     * Specifies the root.
     * @param key root-node parameter that differs nodes with equal value.
     * @param val value of the root-Node
     */
    MyTree(int key, T val) {
        root = new Node(key, val);
        keys.add(key);
    }

    Node getRoot() {
        return root;
    }

    /**
     * Deletes a Node
     * @param key - Node's key which yuo want to delete
     * @return Deleted Node
     */
    Node remove(Integer key) {
        if (!keys.contains(key)) {
            throw new ArrayStoreException("No such node");
        }
        Consumer<Node> act = (Node a) -> {
            ((Node) a).children.forEach(x -> {
                if (((Node) x).getKey() == key) {
                    finder = (Node) x;
                }
            });
            ((Node) a).children.removeIf(b -> ((Node) b).getKey() == key);
        };
        depthGo(act, root);
        return finder;
    }

    /**
     * adds a child to the root, if root is not specified creates the root.
     * @param key unique identifier of a Node to differ  Nodes with same value
     * @param val Value of the Node
     */
    void add(Integer key, T val) {
        if (keys.contains(key)) {
            throw new ArrayStoreException("Keys must be unique for each value");
        }
        if (root == null) {
            root = new Node(key, val);
        } else {
            Node x = new Node(key, val);
            root.addChild(x);
        }
        keys.add(key);

    }

    /**
     * adds the Node as a child of the Node specified by the parentKey
     * @param key unique identifier of a Node
     * @param val value of the Node
     * @param parentKey unique identifier of the Node which will be the parent of new Node
     * @throws ArrayStoreException if there is no Node with key=parentKey or if there is already exist key.
     */
    void add(Integer key, T val, Integer parentKey) throws ArrayStoreException {
        if (!keys.contains(parentKey)) {
            throw new ArrayStoreException("No such parent node");
        }
        if (keys.contains(key)) {
            throw new ArrayStoreException("Keys must be unique for each value");
        }
        keys.add(key);
        Node x = new Node(key, val);
        if (root == null) {
            root = x;
        }
        Consumer<Node> act = (Node a) -> {
            if (((Node) a).getKey() == parentKey) {
                a.addChild(x);
            }
        };
        depthGo(act, root);
    }

    /**
     * makes action for each element of the tree in DFS order from the root
     * @param action
     */
    public void depthGo(Consumer action) {
        Node a = root;
        if (a == null) {
            return;
        }
        depthGo(action, (Node) a);
    }

    public void depthGo(Consumer action, Node a) {
        a.children.forEach(element -> depthGo(action, (Node) element));
        action.accept(a);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator() {
            private boolean flag = false;
            private ArrayDeque<Node> q = new ArrayDeque<Node>();

            @Override
            public boolean hasNext() {
                if (!flag) {
                    q.add(root);
                    flag = true;
                }
                return !q.isEmpty();
            }

            @Override
            public Node next() {
                Node a = q.pollFirst();
                ArrayList<Node> x = a.getChildren();
                for (Node itVar : x) {
                    q.addLast(itVar);
                }
                return a;
            }
        };
        return it;
    }
}

