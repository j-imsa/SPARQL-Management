package ir.jimsa.sparqlmanagement.unit.utility;


import ir.jimsa.sparqlmanagement.utility.id.PublicIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static ir.jimsa.sparqlmanagement.utility.constant.ProjectConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class PublicIdGeneratorTests {

    private PublicIdGenerator publicIdGenerator;

    @BeforeEach
    void setUp() {
        publicIdGenerator = new PublicIdGenerator();
    }

    @Nested
    @DisplayName("GeneratePublicId")
    class GeneratePublicIdTests {

        @ParameterizedTest
        @ValueSource(ints = {32, 64, 100, 512})
        @DisplayName("by different valid values, should return right length")
        void givenAValidLength_whenGeneratePublicId_thenReturnRightLength(int length) {
            String publicId = publicIdGenerator.generatePublicId(length);
            log.info("input length: {}, generated public_id length: {}", length, publicId.length());

            assertThat(publicId).hasSize(length);
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -100, -1, 0, 1, 31, 513, 1024, Integer.MAX_VALUE})
        @DisplayName("by different invalid values, should return default length")
        void givenAnInvalidLength_whenGeneratePublicId_thenReturnDefaultLength(int length) {
            String publicId = publicIdGenerator.generatePublicId(length);
            log.info("input length: {}, generated public_id length: {}", length, publicId.length());

            assertThat(publicId).hasSize(PUBLIC_ID_DEFAULT_LENGTH);
        }

        @RepeatedTest(1_000)
        @DisplayName("generated public_id must just include a special pattern: [A-Z][a-z][0-9][-][_]")
        void givenARandomLength_whenGeneratePublicId_thenReturnAEspecialStringIncludingJustValidCharacters() {
            Random random = new Random();
            int randomLength = random.nextInt((PUBLIC_ID_MAX_LENGTH - PUBLIC_ID_MIN_LENGTH) + 1) + PUBLIC_ID_MIN_LENGTH;

            String publicId = publicIdGenerator.generatePublicId(randomLength);
            log.info("randomLength length: {}, generated public_id length: {}", randomLength, publicId.length());

            assertThat(publicId)
                    .matches(PUBLIC_ID_PATTERN)
                    .hasSizeBetween(PUBLIC_ID_MIN_LENGTH, PUBLIC_ID_MAX_LENGTH);
        }

    }

}
