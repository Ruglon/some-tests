package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserPojo> data;
    private SupportPojo support;

    // Геттеры и сеттеры

}
