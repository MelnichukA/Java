
public class DynamicList {
    // ��������� ������ ������� �� ���������
    private static final int DEFAULT_CAPACITY = 10;
 
    // ������, � ������� ����� ��������� ������
    private String[] elements;
 
    // ������, ������� ���������� ����� � �������, ���� ����� ��������� ��������� ������
    private int index;
 
    // ����������� ��� ����������
    public DynamicList() {
        this(DEFAULT_CAPACITY);
    }
 
    // �����������, � ������� �������� ��������� ������ �������
    public DynamicList(int capacity) {
        elements = new String[capacity];
    }
 
    public void add(String element) {
        // ���� � ������� ����� ��� ���, �� ������� ������ � 2 ���� ������
        // � � ���� �������������� �������� �� ������� �������
        if (index == elements.length)
            growArray();
        elements[index++] = element;
    }
 
    private void growArray() {
        String[] newArray = new String[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }
 
    public String get() {
        // ������ ����� ���� ��������, ��� � ������ ��� ��� �� ������ ��������
        // � ����� �� �������� ����� ������� �������� ����������
        if (index == 0)
            throw new IllegalArgumentException("List is empty");
        return elements[index - 1];
    }
 
    // ���������, ��������� �� ������ � ��������� �� ���� �� ����� ������� - 1
    // ���� ����� ��� ������� �������� �� ������� � ������� �� �������
    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }
    public String get(int id) {
        checkIndex(id);
        return elements[id];
    }
 
    public String remove() {
        // ���� �������� ������� ������� ����� ������ ��� ���������
        if (index == 0)
            throw new RuntimeException("List is empty");
 
        String result = elements[index - 1];
        index--;
        return result;
    }
 
    public String remove(int id) {
        String result = get(id);
        System.arraycopy(elements, id + 1, elements, id, index - id - 1);
        elements[id + 1] = null;
        index--;
        return result;
    }
 
    public boolean delete() {
        if (index == 0)
            return false;
 
        index = 0;
        elements = new String[DEFAULT_CAPACITY];
        return true;
    }
 
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < index; i++) {
            result += elements[i] + " ";
        }
        result += "]";
        return result;
    }
}