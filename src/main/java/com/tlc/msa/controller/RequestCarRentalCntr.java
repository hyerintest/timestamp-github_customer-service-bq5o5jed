package com.tlc.msa.controller;

import com.tlc.msa.swagger.MarkdownDescription;
import com.tlc.msa.swagger.SwaggerMarkdown;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.assertj.core.util.Strings;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.tlc.msa.annotation.AnonymousCallable;
import com.tlc.msa.exception.InvalidParameterException;
import com.tlc.msa.exception.AuthException;
import com.tlc.msa.exception.NotAllowedMethodException;
import com.tlc.msa.exception.ServiceUnavailableException;
import com.tlc.msa.exception.PermissionDeniedException;
import com.tlc.msa.response.ResponseObject;

import com.tlc.msa.request.RequestCarRental_Vo;
import java.util.concurrent.Callable;

@RestController
@RequestMapping()
@MarkdownDescription(markdown = SwaggerMarkdown.REQUEST_CAR_RENTAL_CNTR_TAG)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "정상 응답", content = @Content(schema = @Schema(implementation = ResponseObject.class))),
        @ApiResponse(responseCode = "400", description = "권한 없음", content = @Content(schema = @Schema(implementation = InvalidParameterException.class))),
        @ApiResponse(responseCode = "401", description = "인증 실패", content = @Content(schema = @Schema(implementation = AuthException.class))),
        @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드", content = @Content(schema = @Schema(implementation = NotAllowedMethodException.class))),
        @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content(schema = @Schema(implementation = ServiceUnavailableException.class))),
        @ApiResponse(responseCode = "401", description = "권한 없음", content = @Content(schema = @Schema(implementation = PermissionDeniedException.class)))
    })
public class RequestCarRentalCntr {
    private Logger logger = LogManager.getLogger("com.tlc.msa");


    @AnonymousCallable
    @RequestMapping(value = "/rentals/request", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @MarkdownDescription(markdown = SwaggerMarkdown.REQUEST_CAR_RENTAL_OPERATION)
    public Callable<ResponseObject> requestCarRental(
        @Parameter(name = "requestCarRental", description = "This parameter for requestCarRental", required = true, schema = @Schema(type = "RequestCarRentalVo")) @RequestBody RequestCarRental_Vo requestCarRental_Vo) {

        return () -> {
            ResponseObject responseObject = new ResponseObject();
            responseObject.putResult(true);
            return responseObject;
        };
    }
    @AnonymousCallable
    @RequestMapping(value = "/rentals/return", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @MarkdownDescription(markdown = SwaggerMarkdown.REQUEST_CAR_RETURN_OPERATION)
    public Callable<ResponseObject> requestCarReturn(
        @Parameter(name = "rentalId", description = "This parameter for rentalId", required = true, schema = @Schema(type = "String")) @RequestBody String rentalId) {

        return () -> {
            ResponseObject responseObject = new ResponseObject();
            responseObject.putResult(true);
            return responseObject;
        };
    }
}
