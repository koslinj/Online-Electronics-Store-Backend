package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.repository.OpinionRepository;
import koslin.jan.shop.service.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpinionServiceImpl implements OpinionService {

    private OpinionRepository opinionRepository;

    @Override
    public List<OpinionDto> getOpinionsByProductId(Long id) {
        return opinionRepository.getAllByProductId(id)
                .stream()
                .map(opinion -> {
                    OpinionDto opinionDto = new OpinionDto();
                    opinionDto.setId(opinion.getId());
                    opinionDto.setStars(opinion.getStars());
                    opinionDto.setContent(opinion.getContent());
                    opinionDto.setCreatedAt(opinion.getCreatedAt());
                    opinionDto.setUser(opinion.getUser().getFirstName());
                    return opinionDto;
                })
                .toList();
    }
}