
public class DynamicList {
    // начальный размер массива по умолчанию
    private static final int DEFAULT_CAPACITY = 10;
 
    // массив, в котором будут храниться строки
    private String[] elements;
 
    // индекс, который показывает номер в массиве, куда нужно вставлять следующую строку
    private int index;
 
    // конструктор без аргументов
    public DynamicList() {
        this(DEFAULT_CAPACITY);
    }
 
    // конструктор, в котором задается начальный размер массива
    public DynamicList(int capacity) {
        elements = new String[capacity];
    }
 
    public void add(String element) {
        // если в массиве места уже нет, то создаем массив в 2 раза больше
        // и в него перезаписываем значения из старого массива
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
        // индекс равен нулю означает, что в списке еще нет ни одного елемента
        // и когда мы пытаемся взять елемент вылетает исключение
        if (index == 0)
            throw new IllegalArgumentException("List is empty");
        return elements[index - 1];
    }
 
    // проверяем, находится ли индекс в диапазоне от нуля до длины массива - 1
    // этот метод для методов вставить по индексу и удалить по индексу
    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }
    public String get(int id) {
        checkIndex(id);
        return elements[id];
    }
 
    public String remove() {
        // если пытаемся удалить елемент когда вообще нет елементов
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