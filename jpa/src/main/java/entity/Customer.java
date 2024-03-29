package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
//@NoArgsConstructor // 기본생성자 반드시 필수!!  JPA -> new Customer()..
@Table(name="Customer_tb")
public class Customer {
    @Id
    @Column(name="cutomer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@Basic
    String name;
    LocalDate regDate;

    public Customer(){}

    public Customer(String name) {
        this.name = name;
        regDate = LocalDate.now();
    }

//    public Customer(String id, String name, LocalDate regDate) {
//        this.id = id;
//        this.name = name;
//        this.regDate = regDate;
//    }
}
