package entities;

public class Client implements Comparable<Client>, Identifiable{

    private static int counter = 0;

    public int id;
    public int age;
    public String name;

    public Client(String name, int age) {
        counter++;
        this.id = counter;
        this.age = age;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Client o) {
        int comparable = Integer.compare(this.getAge(), o.getAge());
        if(comparable == 0){
            comparable = Integer.compare(this.getId(), o.getId());
        }
        return comparable;
    }

    @Override
    public String toString() {
        return name +
                ", " + id;
    }
}
