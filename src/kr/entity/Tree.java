package kr.entity;

/**
 * Created by amareelez on 14.12.16.
 */

public abstract class Tree implements Comparable<Tree> {
    protected String name;
    protected int age;
    protected Type type;

    public Tree() {
    }

    public Tree(String name, int age, Type type) {
        this.name = name;
        this.age = age;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
