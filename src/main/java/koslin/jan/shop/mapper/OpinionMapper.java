package koslin.jan.shop.mapper;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.entity.Category;
import koslin.jan.shop.entity.Opinion;
import koslin.jan.shop.entity.Product;
import koslin.jan.shop.entity.User;

public class OpinionMapper {
    public static OpinionDto toDto(Opinion opinion){
        return new OpinionDto(
                opinion.getId(),
                opinion.getStars(),
                opinion.getContent(),
                opinion.getCreatedAt(),
                opinion.getUser().getFirstName(),
                opinion.getProduct().getId()
        );
    }

    public static Opinion toEntity(OpinionDto opinionDto, Product product, User user){
        return new Opinion(
                opinionDto.getId(),
                opinionDto.getStars(),
                opinionDto.getContent(),
                opinionDto.getCreatedAt(),
                product,
                user
        );
    }
}
