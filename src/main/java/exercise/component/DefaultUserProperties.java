package exercise.component;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
@Setter
@Getter
public class DefaultUserProperties {
    private String fullName;
    private Integer age;
}
