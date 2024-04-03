package koslin.jan.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpinionDto {
    private Long id;
    private int stars;
    private String content;
    private Instant createdAt;
    private String user;
    private Long productId;
}
