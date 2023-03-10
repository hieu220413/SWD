package fpt.asignment.estate_trading_system.post.controller;

import fpt.asignment.estate_trading_system.common.entity.Post;
import fpt.asignment.estate_trading_system.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Post")
public class PostController {
    @Autowired
    private PostService postService;

    @Operation(summary = "Get Posts With Ad ", description = "Get Post With Ad ", tags = {"Post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Posts successfully", content = @Content())})
    @RequestMapping(value = "/post/getWithAd",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<List<Post>> createSubscription(@Parameter(in = ParameterIn.DEFAULT, required = true, example = "0") @RequestParam int page,
                                                         @Parameter(in = ParameterIn.DEFAULT, required = true, example = "8") @RequestParam int perPage,
                                                         @Parameter(in = ParameterIn.DEFAULT, required = true, example = "-1") @RequestParam int area
    ) {
        return postService.findPostAdWithPagination(page, perPage, area);
    }
}
