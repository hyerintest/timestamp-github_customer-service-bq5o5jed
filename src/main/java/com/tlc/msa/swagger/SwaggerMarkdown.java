package com.tlc.msa.swagger;

import lombok.Getter;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

@Getter
public enum SwaggerMarkdown {
    ACTUATOR("Actuator.md", "Actuator", SwaggerType.Tag),
    DESCRIPTION("Description.md", "Description", SwaggerType.Tag),
    LOGIN("Login.md", "Login", SwaggerType.Tag),
    REQUEST_CAR_RENTAL_CNTR_TAG("RequestCarRentalCntrTag.md", "RequestCarRentalCntr", SwaggerType.Tag),
    REQUEST_CAR_RENTAL_OPERATION("RequestCarRentalOperation.md", "requestCarRental", SwaggerType.Operation),
    REQUEST_CAR_RETURN_OPERATION("RequestCarReturnOperation.md", "requestCarRental", SwaggerType.Operation),

    ;

    private final String path;
    private final String name;
    private final SwaggerType type;

    SwaggerMarkdown(String path, String name, SwaggerType tag) {
        this.path = path;
        this.name = name;
        this.type = tag;
    }

    private Resource getResource() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        return resourceLoader.getResource(String.format("classpath:swagger/%s", path));
    }

    public String asString() {

        try (Reader reader = new InputStreamReader(getResource().getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static SwaggerMarkdown ofPath(String path) {
        return Arrays.stream(values())
        .filter(x -> x.getPath().equals(path))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("찾을 수 없는 MarkDown 파일입니다."));
    }
}
