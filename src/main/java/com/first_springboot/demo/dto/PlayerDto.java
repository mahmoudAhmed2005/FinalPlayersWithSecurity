package com.first_springboot.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.first_springboot.demo.model.Player;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDto {

    //validation in serviceImpl

//    @JsonProperty("ref_num")
    private Long ref_num;

//@NotNull
//@Size(min = 2,max = 20)
//@Pattern(regexp = "[A-Z][a-z]+",  message = "First letter must be capital and the rest must be small" )
//@NotEmpty
@NotBlank(message = "player.invalid.name")
    private String name;

@Min(message = "player.invalid.number", value = 18)
@Max(message = "player.invalid.number",value = 100)
    private Integer number;

    private Double salary;

    private String details;

    private Long count;

    @Email
    private String email;






    public PlayerDto(Long ref_num, String name, Integer number, Double salary) {
        this.ref_num = ref_num;
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    public PlayerDto(String name, Integer number, Double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;

    }





    @Override
    public String toString() {
        return "Player{" +
                "ref_num=" + ref_num +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", salary=" + salary +
                '}';
    }
}
