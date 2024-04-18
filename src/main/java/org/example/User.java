package org.example;

import java.util.Objects;

public class User {
    int id;
    String fio;

    public void setFio(String fio) {
        this.fio = fio;
    }

    double money;

    public User(int id, String fio, double money) {
        this.id = id;
        this.fio = fio;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Double.compare(money, user.money) == 0 && Objects.equals(fio, user.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, money);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", money=" + money +
                '}';
    }
}
