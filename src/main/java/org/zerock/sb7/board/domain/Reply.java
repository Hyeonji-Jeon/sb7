package org.zerock.sb7.board.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    private String str;

    private String mid;

    private LocalDate regDate;

    private LocalDate modDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

}
