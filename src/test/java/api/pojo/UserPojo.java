package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        // Геттеры и сеттеры
        // Пример для id и email, добавьте остальные самостоятельно
    }


