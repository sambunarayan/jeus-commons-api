package jp.co.jeus.commons_api.commons.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    @Column
    private String en;
    @Column
    private String jp;
    @Column
    private String kr;
}
