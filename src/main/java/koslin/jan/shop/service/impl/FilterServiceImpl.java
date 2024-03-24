package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.FilterDto;
import koslin.jan.shop.entity.Filter;
import koslin.jan.shop.repository.FilterRepository;
import koslin.jan.shop.service.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;
    @Override
    public List<FilterDto> getFilters() {
        return filterRepository
                .findAll()
                .stream()
                .map(filter -> new FilterDto(filter.getName()))
                .toList();
    }
}
