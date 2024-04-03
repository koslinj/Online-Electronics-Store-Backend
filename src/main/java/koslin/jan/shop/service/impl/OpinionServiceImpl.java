package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.entity.Opinion;
import koslin.jan.shop.entity.Product;
import koslin.jan.shop.entity.User;
import koslin.jan.shop.mapper.OpinionMapper;
import koslin.jan.shop.repository.OpinionRepository;
import koslin.jan.shop.repository.ProductRepository;
import koslin.jan.shop.repository.UserRepository;
import koslin.jan.shop.service.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpinionServiceImpl implements OpinionService {

    private OpinionRepository opinionRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

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

    @Override
    public OpinionDto createOpinion(int stars, String content, String username, Long productId) {
        OpinionDto dto = new OpinionDto();
        dto.setStars(stars);
        dto.setContent(content);
        Product product = productRepository.findById(productId).orElseThrow();
        User user = userRepository.findByEmail(username).orElseThrow();

        Opinion opinion = OpinionMapper.toEntity(dto, product, user);
        Opinion saved = opinionRepository.save(opinion);
        return OpinionMapper.toDto(saved);
    }
}