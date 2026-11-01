package com.first_springboot.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Player {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(unique = true)
    private String name;

    @Column(name="player_number")
    private Integer number;

    private Double salary;







    public Player(String name, Integer number, Double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }







    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", salary=" + salary +
                '}';
    }
}
