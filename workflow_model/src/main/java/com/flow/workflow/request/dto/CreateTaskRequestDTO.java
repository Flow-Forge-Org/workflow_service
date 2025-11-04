package com.flow.workflow.request.dto;

import jakarta.validation.constraints.*;
import java.util.Map;

public record CreateTaskRequestDTO (
        @NotBlank @Size(max = 255)
        String taskName,

        @NotBlank
        String taskType,

        @NotNull
        Map<String, Object> parameters,

        Long timeoutSeconds
) {

}
