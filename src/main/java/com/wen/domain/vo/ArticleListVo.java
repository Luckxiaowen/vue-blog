package com.wen.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListVo {
    private Integer id;

    private String title;

    private String introduction;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private Integer watchNumber;

    private String articleCoverUrl;

    private List<String> tagName;

    private List<Integer> tagId;
}
