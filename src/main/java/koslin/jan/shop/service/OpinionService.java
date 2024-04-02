package koslin.jan.shop.service;

import koslin.jan.shop.dto.OpinionDto;

import java.util.List;

public interface OpinionService {
    List<OpinionDto> getOpinionsByProductId(Long id);

    List<OpinionDto> getOpinionsByUsername(String username);

    OpinionDto createOpinion(int stars, String content, String username, Long productId);
}
