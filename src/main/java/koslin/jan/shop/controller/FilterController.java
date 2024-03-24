package koslin.jan.shop.controller;

import koslin.jan.shop.dto.FilterDto;
import koslin.jan.shop.service.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/filters")
public class FilterController {

    private FilterService filterService;
    @GetMapping
    public ResponseEntity<List<FilterDto>> getFilters() {
        List<FilterDto> allFilters = filterService.getFilters();
        return new ResponseEntity<>(allFilters, HttpStatus.OK);
    }

}
