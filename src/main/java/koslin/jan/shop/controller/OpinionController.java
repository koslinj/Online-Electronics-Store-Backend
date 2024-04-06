package koslin.jan.shop.controller;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.service.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/opinions")
public class OpinionController {

    private OpinionService opinionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<OpinionDto>> getOpinionsByProductId(@PathVariable("id") Long id) {
        List<OpinionDto> opions = opinionService.getOpinionsByProductId(id);
        return new ResponseEntity<>(opions, HttpStatus.OK);
    }

    @GetMapping(params = "username")
    public ResponseEntity<List<OpinionDto>> getOpinionsByUsername(@RequestParam String username) {
        List<OpinionDto> opions = opinionService.getOpinionsByUsername(username);
        return new ResponseEntity<>(opions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OpinionDto> createOpinion(
            @RequestParam("stars") String starsStr,
            @RequestParam("content") String content,
            @RequestParam("username") String username,
            @RequestParam("productId") String productIdStr
    ) {
            int stars = Integer.parseInt(starsStr);
            Long productId = Long.parseLong(productIdStr);
            OpinionDto saved = opinionService.createOpinion(stars, content, username, productId);

            return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
