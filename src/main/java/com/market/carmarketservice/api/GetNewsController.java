package com.market.carmarketservice.api;

import com.market.carmarketservice.request.news.LinkRequest;
import com.market.carmarketservice.service.news.GetNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/pub")
public class GetNewsController {
    private final GetNewsService getNewsService;

    @PostMapping("/getPost")
    public ResponseEntity<Object> getPost(@RequestBody LinkRequest link) {
        return new ResponseEntity<>(getNewsService.getPost(link.getLink()), HttpStatus.OK);
    }

    @PostMapping("/getRss")
    public ResponseEntity<Object> getRss(@RequestBody LinkRequest link) {
        return new ResponseEntity<>(getNewsService.getRss(link.getLink()), HttpStatus.OK);
    }
}
