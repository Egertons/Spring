package com.zhanglin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class People {
    @Autowired(required = false)
    private Dog dog;

    public People(@Nullable Cat cat) {
        this.cat = cat;
    }

    @Autowired
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
