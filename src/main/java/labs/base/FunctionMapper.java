package labs.base;

import labs.base.dto.EnrichDataDTO;
import labs.base.dto.PreviewDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FunctionMapper {
    public static Function<PreviewDTO, Function<Function<PreviewDTO, EnrichDataDTO>, Optional<EnrichDataDTO>>> setEnrichData =
            previewDTO -> enrichDataDTOFunction -> Optional.ofNullable(enrichDataDTOFunction.apply(previewDTO));

    public static Function<PreviewDTO, Function<Function<PreviewDTO, EnrichDataDTO>, Optional<List<String>>>> getEnrichDataShapes =
            previewDTO -> enrichDataDTOFunction -> Optional.ofNullable(enrichDataDTOFunction.apply(previewDTO))
                    .map(EnrichDataDTO::getShapes);


    public static void main(String[] args) {
        PreviewDTO previewDTO = new PreviewDTO();
        EnrichDataDTO enrichDataDTO = new EnrichDataDTO();
        enrichDataDTO.setShapes(Arrays.asList("circle", "square", "triangle"));
        previewDTO.setEnrichData(enrichDataDTO);

        Optional<EnrichDataDTO> enrichDataDTOOptional = setEnrichData.apply(previewDTO).apply(PreviewDTO::getEnrichData);

        getEnrichDataShapes.apply(previewDTO).apply(PreviewDTO::getEnrichData).ifPresent(System.out::println);

        if (enrichDataDTOOptional.isPresent()) {
            System.out.println("EnrichDataDTO is present");
        } else {
            System.out.println("EnrichDataDTO is not present");
        }

    }
}
