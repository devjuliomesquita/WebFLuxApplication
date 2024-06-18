package com.juliomesquita.application.infra.controller.documentation;

import com.juliomesquita.application.infra.dtos.request.UserRequest;
import com.juliomesquita.application.infra.utils.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "USER - Request", description = "User - Request")
public interface UserControllerDoc {
    @Operation(operationId = "createUser", summary = "Criar um usuário.", description = "Criar um usuário.", tags = {"USER - Request"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful operation",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResponses.class))}),
                    @ApiResponse(responseCode = "400", description = "Bad Request.", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found.", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Conflict.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    @PostMapping(value = {"/user"}, produces = {"application/json"})
    Mono<ResponseEntity<ApiResponses>> createUser(
            @Parameter(name = "UserRequest", required = true)
            @RequestBody @Valid UserRequest request);
}
