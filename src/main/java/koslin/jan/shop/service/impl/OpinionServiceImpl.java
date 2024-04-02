package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.mapper.OpinionMapper;
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
                .map(OpinionMapper::toDto)
                .toList();
    }

    @Override
    public List<OpinionDto> getOpinionsByUsername(String username) {
        return opinionRepository.getAllByUserEmail(username)
                .stream()
                .map(OpinionMapper::toDto)
                .toList();
    }
}