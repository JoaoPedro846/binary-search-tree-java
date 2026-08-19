package entities;

public class Client implements Comparable<Client>{

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

    public int getId() {
        return id;
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
    public int compareTo(Client o) {
        return Integer.compare(this.getAge(), o.getAge());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
