package com.bit.springboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "freeboard_file")
public class FreeBoardFile {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private FreeBoard freeBoard;

    private String filename;

    private String fileoriginname;

    private String filepath;

    private String filetype;

}
