package es.upm.miw.apaw.model.builder.article.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Article Tests")
class ArticleTest {

    private UUID sampleId;
    private List<Long> samplePhones;
    private List<String> sampleTags;
    private BigDecimal sampleRetailPrice;
    private BigDecimal sampleWholesalePrice;

    @BeforeEach
    void setUp() {
        sampleId = UUID.randomUUID();
        samplePhones = List.of(123456789L, 987654321L);
        sampleTags = List.of("electronics", "mobile", "smartphone");
        sampleRetailPrice = new BigDecimal("299.99");
        sampleWholesalePrice = new BigDecimal("199.99");
    }

    @Test
    void shouldCreateArticleWithNoArgsConstructor() {
        Article article = new Article();

        assertThat(article).isNotNull();
        assertThat(article.getId()).isNull();
        assertThat(article.getPhones()).isNull();
        assertThat(article.getReference()).isNull();
        assertThat(article.getDescription()).isNull();
        assertThat(article.getRetailPrice()).isNull();
        assertThat(article.getStock()).isNull();
        assertThat(article.getTags()).isNull();
        assertThat(article.getWholesalePrice()).isNull();
    }

    @Test
    @DisplayName("Should create Article with all-args constructor")
    void shouldCreateArticleWithAllArgsConstructor() {
        Article article = new Article(
                sampleId,
                samplePhones,
                "REF-001",
                "Sample Description",
                sampleRetailPrice,
                100,
                sampleTags,
                sampleWholesalePrice
        );

        assertThat(article).isNotNull();
        assertThat(article.getId()).isEqualTo(sampleId);
        assertThat(article.getPhones()).isEqualTo(samplePhones);
        assertThat(article.getReference()).isEqualTo("REF-001");
        assertThat(article.getDescription()).isEqualTo("Sample Description");
        assertThat(article.getRetailPrice()).isEqualTo(sampleRetailPrice);
        assertThat(article.getStock()).isEqualTo(100);
        assertThat(article.getTags()).isEqualTo(sampleTags);
        assertThat(article.getWholesalePrice()).isEqualTo(sampleWholesalePrice);
    }


    @Test
    @DisplayName("Should create Article using builder pattern")
    void shouldCreateArticleUsingBuilder() {
        // Given & When
        Article article = Article.builder()
                .reference("REF-002")
                .description("Built Article")
                .retailPrice(new BigDecimal("150.00"))
                .wholesalePrice(new BigDecimal("100.00"))
                .stock(50)
                .phone(111111111L)
                .phone(222222222L)
                .tag("category1")
                .tag("category2")
                .build();

        // Then
        assertThat(article).isNotNull();
        assertThat(article.getReference()).isEqualTo("REF-002");
        assertThat(article.getDescription()).isEqualTo("Built Article");
        assertThat(article.getRetailPrice()).isEqualTo(new BigDecimal("150.00"));
        assertThat(article.getWholesalePrice()).isEqualTo(new BigDecimal("100.00"));
        assertThat(article.getStock()).isEqualTo(50);
        assertThat(article.getPhones())
                .isNotNull()
                .hasSize(2)
                .containsExactly(111111111L, 222222222L);
        assertThat(article.getTags())
                .isNotNull()
                .hasSize(2)
                .containsExactly("category1", "category2");
    }

    @Test
    @DisplayName("Should create empty Article with builder")
    void shouldCreateEmptyArticleWithBuilder() {
        // Given & When
        Article article = Article.builder().build();

        // Then
        assertThat(article).isNotNull();
        assertThat(article.getId()).isNull();
        assertThat(article.getReference()).isNull();
        assertThat(article.getDescription()).isNull();
        assertThat(article.getRetailPrice()).isNull();
        assertThat(article.getWholesalePrice()).isNull();
        assertThat(article.getStock()).isNull();
    }

    @Test
    @DisplayName("Should handle multiple phones in builder")
    void shouldHandleMultiplePhonesInBuilder() {
        // Given
        Article article = Article.builder()
                .phone(123L)
                .phone(456L)
                .phone(789L)
                .build();

        // Then
        assertThat(article.getPhones())
                .hasSize(3)
                .containsExactly(123L, 456L, 789L);
    }

    @Test
    @DisplayName("Should handle multiple tags in builder")
    void shouldHandleMultipleTagsInBuilder() {
        // Given
        Article article = Article.builder()
                .tag("tag1")
                .tag("tag2")
                .tag("tag3")
                .build();

        // Then
        assertThat(article.getTags())
                .hasSize(3)
                .containsExactly("tag1", "tag2", "tag3");
    }

    @Test
    @DisplayName("Should allow method chaining in builder")
    void shouldAllowMethodChainingInBuilder() {
        // Given & When
        Article.Builder builder = Article.builder();
        Article.Builder chainedBuilder = builder
                .reference("CHAIN-001")
                .stock(25);

        // Then
        assertThat(chainedBuilder).isSameAs(builder);

        Article article = chainedBuilder.build();
        assertThat(article.getReference()).isEqualTo("CHAIN-001");
        assertThat(article.getStock()).isEqualTo(25);
    }


    @Test
    @DisplayName("Should get and set all properties correctly")
    void shouldGetAndSetAllProperties() {
        // Given
        Article article = new Article();

        // When & Then
        article.setId(sampleId);
        assertThat(article.getId()).isEqualTo(sampleId);

        article.setPhones(samplePhones);
        assertThat(article.getPhones()).isEqualTo(samplePhones);

        article.setReference("TEST-REF");
        assertThat(article.getReference()).isEqualTo("TEST-REF");

        article.setDescription("Test Description");
        assertThat(article.getDescription()).isEqualTo("Test Description");

        article.setRetailPrice(sampleRetailPrice);
        assertThat(article.getRetailPrice()).isEqualTo(sampleRetailPrice);

        article.setStock(75);
        assertThat(article.getStock()).isEqualTo(75);

        article.setTags(sampleTags);
        assertThat(article.getTags()).isEqualTo(sampleTags);

        article.setWholesalePrice(sampleWholesalePrice);
        assertThat(article.getWholesalePrice()).isEqualTo(sampleWholesalePrice);
    }


    @Test
    @DisplayName("Should be equal when all fields are equal")
    void shouldBeEqualWhenAllFieldsAreEqual() {
        // Given
        Article article1 = new Article(sampleId, samplePhones, "REF-001",
                "Description", sampleRetailPrice, 100, sampleTags, sampleWholesalePrice);
        Article article2 = new Article(sampleId, samplePhones, "REF-001",
                "Description", sampleRetailPrice, 100, sampleTags, sampleWholesalePrice);

        // Then
        assertThat(article1)
                .isEqualTo(article2)
                .hasSameHashCodeAs(article2);
    }

    @Test
    @DisplayName("Should not be equal when fields differ")
    void shouldNotBeEqualWhenFieldsDiffer() {
        // Given
        Article article1 = new Article(sampleId, samplePhones, "REF-001",
                "Description", sampleRetailPrice, 100, sampleTags, sampleWholesalePrice);
        Article article2 = new Article(sampleId, samplePhones, "REF-002",
                "Description", sampleRetailPrice, 100, sampleTags, sampleWholesalePrice);

        // Then
        assertThat(article1).isNotEqualTo(article2);
    }

    @Test
    @DisplayName("Should handle null values in equals")
    void shouldHandleNullValuesInEquals() {
        // Given
        Article article1 = new Article();
        Article article2 = new Article();

        // Then
        assertThat(article1).isEqualTo(article2);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("Should handle zero and negative stock values")
    void shouldHandleZeroAndNegativeStock(int stock) {
        // Given & When
        Article article = Article.builder()
                .stock(stock)
                .build();

        // Then
        assertThat(article.getStock()).isEqualTo(stock);
    }

    @Test
    @DisplayName("Should handle null values in builder gracefully")
    void shouldHandleNullValuesInBuilderGracefully() {
        // Given & When
        Article article = Article.builder()
                .reference(null)
                .description(null)
                .retailPrice(null)
                .wholesalePrice(null)
                .build();

        // Then
        assertThat(article).isNotNull();
        assertThat(article.getReference()).isNull();
        assertThat(article.getDescription()).isNull();
        assertThat(article.getRetailPrice()).isNull();
        assertThat(article.getWholesalePrice()).isNull();
    }

    @Test
    @DisplayName("Should handle empty strings in builder")
    void shouldHandleEmptyStringsInBuilder() {
        // Given & When
        Article article = Article.builder()
                .reference("")
                .description("")
                .tag("")
                .build();

        // Then
        assertThat(article.getReference()).isEmpty();
        assertThat(article.getDescription()).isEmpty();
        assertThat(article.getTags()).containsExactly("");
    }

    @Test
    @DisplayName("Should handle very large phone numbers")
    void shouldHandleVeryLargePhoneNumbers() {
        // Given
        long largePhoneNumber = Long.MAX_VALUE;

        // When
        Article article = Article.builder()
                .phone(largePhoneNumber)
                .build();

        // Then
        assertThat(article.getPhones())
                .hasSize(1)
                .containsExactly(largePhoneNumber);
    }

    @Test
    @DisplayName("Should handle precision in BigDecimal prices")
    void shouldHandlePrecisionInBigDecimalPrices() {
        // Given
        BigDecimal precisePrice = new BigDecimal("123.456789");

        // When
        Article article = Article.builder()
                .retailPrice(precisePrice)
                .wholesalePrice(precisePrice)
                .build();

        // Then
        assertThat(article.getRetailPrice()).isEqualByComparingTo(precisePrice);
        assertThat(article.getWholesalePrice()).isEqualByComparingTo(precisePrice);
    }


    @Test
    @DisplayName("Should generate toString with all fields")
    void shouldGenerateToStringWithAllFields() {
        // Given
        Article article = new Article(sampleId, samplePhones, "REF-001",
                "Description", sampleRetailPrice, 100, sampleTags, sampleWholesalePrice);

        // When
        String toString = article.toString();

        // Then
        assertThat(toString)
                .contains("Article(")
                .contains("id=" + sampleId)
                .contains("phones=" + samplePhones)
                .contains("reference=REF-001")
                .contains("description=Description")
                .contains("retailPrice=" + sampleRetailPrice)
                .contains("stock=100")
                .contains("tags=" + sampleTags)
                .contains("wholesalePrice=" + sampleWholesalePrice);
    }
}

