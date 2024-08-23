package com.bit.springboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@Table(name = "freeboard_file")
@DynamicInsert
@SequenceGenerator(
        name = "FreeBoardFileSeqGenerator",
        sequenceName = "freeboard_file_seq",
        initialValue = 1, allocationSize = 1
)
public class FreeBoardFile {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FreeBoardFileSeqGenerator"
    )
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "board_id")
    private FreeBoard freeBoard;

    private String filename;

    private String fileoriginname;

    private String filepath;

    private String filetype;

}
