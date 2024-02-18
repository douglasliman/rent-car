package com.digitalhouse.rentcar;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc

@SpringBootTest
class RentCarApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;


	@Test
	void contextLoads() {
		Assertions.assertNotNull(mvc);
	}

	// Testes para a entidade Category
	@Test
	public void categoryTests() throws Exception {
		addCategoryTest();
		getAllCategoriesTest();
		deleteCategoryTest();
		getCategoryByIdTest();
		updateCategoryByIdTest();
	}
	@Test
	public void addCategoryTest() throws Exception {
		String json = "{\n" +
				"  \"qualification\": \"Categoria de Teste\",\n" +
				"  \"description\": \"Descrição da Categoria de Teste\",\n" +
				"  \"imageUrl\": \"URL_da_Imagem_de_Test\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllCategoriesTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/categories"))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteCategoryTest() throws Exception {
		// Crie uma categoria enviando uma solicitação POST
		String json = "{\n" +
				"  \"qualification\": \"Categoria de Teste\",\n" +
				"  \"description\": \"Descrição da Categoria de Teste\",\n" +
				"  \"imageUrl\": \"URL_da_Imagem_de_Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da categoria criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID categoryId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de exclusão usando o ID da categoria criada
		this.mvc.perform(MockMvcRequestBuilders.delete("/v1/categories/{id}", categoryId))
				.andExpect(status().isNoContent());
	}

	@Test
	public void getCategoryByIdTest() throws Exception {
		// Crie uma categoria enviando uma solicitação POST
		String json = "{\n" +
				"  \"qualification\": \"Categoria de Teste\",\n" +
				"  \"description\": \"Descrição da Categoria de Teste\",\n" +
				"  \"imageUrl\": \"URL_da_Imagem_de_Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da categoria criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID categoryId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de busca usando o ID da categoria criada
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/categories/{id}", categoryId))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCategoryByIdTest() throws Exception {
		// Crie uma categoria enviando uma solicitação POST
		String json = "{\n" +
				"  \"qualification\": \"Categoria de Teste\",\n" +
				"  \"description\": \"Descrição da Categoria de Teste\",\n" +
				"  \"imageUrl\": \"URL_da_Imagem_de_Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da categoria criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID categoryId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Atualize a categoria usando o ID da categoria criada
		String updatedJson = "{\n" +
				"  \"description\": \"Nova Descrição\",\n" +
				"  \"imageUrl\": \"Nova_URL_da_Imagem\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.patch("/v1/categories/{id}", categoryId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedJson))
				.andExpect(status().isAccepted());


	}

	// Testes para a entidade City
	@Test
	public void cityTests() throws Exception {
		addCityTest();
		getAllCitiesTest();
	}

	@Test
	public void addCityTest() throws Exception {
		String json = "{\n" +
				"  \"name\": \"City Test\",\n" +
				"  \"state\": \"Test State\",\n" +
				"  \"country\": \"Test Country\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/cities")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllCitiesTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/cities"))
				.andExpect(status().isOk());
	}

	@Test
	public void featureTests() throws Exception {
		addFeatureTest();
		getAllFeaturesTest();
		deleteFeatureTest();
		getFeatureByIdTest();
		updateFeatureByIdTest();
	}

	@Test
	public void addFeatureTest() throws Exception {
		String json = "{\n" +
				"  \"name\": \"Feature Test\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/features")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllFeaturesTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/features"))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteFeatureTest() throws Exception {
		// Crie uma feature enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Feature Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/features")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da feature criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID featureId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de exclusão usando o ID da feature criada
		this.mvc.perform(MockMvcRequestBuilders.delete("/v1/features/{id}", featureId))
				.andExpect(status().isNoContent());
	}

	@Test
	public void getFeatureByIdTest() throws Exception {
		// Crie uma feature enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Feature Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/features")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da feature criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID featureId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de busca usando o ID da feature criada
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/features/{id}", featureId))
				.andExpect(status().isOk());
	}

	@Test
	public void updateFeatureByIdTest() throws Exception {
		// Crie uma feature enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Feature Test\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/features")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da feature criada a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID featureId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Atualize a feature usando o ID da feature criada
		String updatedJson = "{\n" +
				"  \"name\": \"Updated Feature\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.patch("/v1/features/{id}", featureId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedJson))
				.andExpect(status().isAccepted());
	}

	@Test
	public void productTests() throws Exception {
		addProductTest();
		getAllProductsTest();
		deleteProductTest();
		getProductByIdTest();
		updateProductByIdTest();
		getProductByCategoryTest();
		getProductByCityTest();
	}

	@Test
	public void addProductTest() throws Exception {
		String json = "{\n" +
				"  \"name\": \"Product Test\",\n" +
				"  \"description\": \"Description of Product Test\",\n" +
				"  \"price\": \"100.00\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllProductsTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/products"))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteProductTest() throws Exception {
		// Crie um produto enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Product Test\",\n" +
				"  \"description\": \"Description of Product Test\",\n" +
				"  \"price\": \"100.00\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID do produto criado a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID productId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de exclusão usando o ID do produto criado
		this.mvc.perform(MockMvcRequestBuilders.delete("/v1/products/{id}", productId))
				.andExpect(status().isNoContent());
	}

	@Test
	public void getProductByIdTest() throws Exception {
		// Crie um produto enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Product Test\",\n" +
				"  \"description\": \"Description of Product Test\",\n" +
				"  \"price\": \"100.00\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID do produto criado a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID productId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Execute o teste de busca usando o ID do produto criado
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/products/{id}", productId))
				.andExpect(status().isOk());
	}

	@Test
	public void updateProductByIdTest() throws Exception {
		// Crie um produto enviando uma solicitação POST
		String json = "{\n" +
				"  \"name\": \"Product Test\",\n" +
				"  \"description\": \"Description of Product Test\",\n" +
				"  \"price\": \"100.00\"\n" +
				"}";

		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID do produto criado a partir da resposta JSON
		String responseJson = result.getResponse().getContentAsString();
		UUID productId = UUID.fromString(mapper.readTree(responseJson).get("id").asText());

		// Atualize o produto usando o ID do produto criado
		String updatedJson = "{\n" +
				"  \"description\": \"Updated Description\",\n" +
				"  \"price\": \"150.00\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.patch("/v1/products/{id}", productId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedJson))
				.andExpect(status().isAccepted());
	}

	@Test
	public void getProductByCategoryTest() throws Exception {
		// Crie uma categoria enviando uma solicitação POST
		String categoryJson = "{\n" +
				"  \"qualification\": \"Category for Product Test\",\n" +
				"  \"description\": \"Description of Category for Product Test\",\n" +
				"  \"imageUrl\": \"URL_for_Category_Image\"\n" +
				"}";

		MvcResult categoryResult = this.mvc.perform(MockMvcRequestBuilders.post("/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(categoryJson))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da categoria criada a partir da resposta JSON
		String categoryResponseJson = categoryResult.getResponse().getContentAsString();
		UUID categoryId = UUID.fromString(mapper.readTree(categoryResponseJson).get("id").asText());

		// Crie um produto associado a essa categoria enviando uma solicitação POST
		String productJson = "{\n" +
				"  \"name\": \"Product for Category Test\",\n" +
				"  \"description\": \"Description of Product for Category Test\",\n" +
				"  \"price\": \"120.00\",\n" +
				"  \"category\": \"" + categoryId + "\"\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productJson))
				.andExpect(status().isCreated());

		// Execute o teste de busca por categoria usando o ID da categoria criada
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/products/searchByCategory")
						.param("id", categoryId.toString()))
				.andExpect(status().isOk());
	}

	@Test
	public void getProductByCityTest() throws Exception {
		// Crie uma cidade enviando uma solicitação POST
		String cityJson = "{\n" +
				"  \"name\": \"City for Product Test\",\n" +
				"  \"state\": \"State for Product Test\",\n" +
				"  \"country\": \"Country for Product Test\"\n" +
				"}";

		MvcResult cityResult = this.mvc.perform(MockMvcRequestBuilders.post("/v1/cities")
						.contentType(MediaType.APPLICATION_JSON)
						.content(cityJson))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID da cidade criada a partir da resposta JSON
		String cityResponseJson = cityResult.getResponse().getContentAsString();
		UUID cityId = UUID.fromString(mapper.readTree(cityResponseJson).get("id").asText());

		// Crie um produto associado a essa cidade enviando uma solicitação POST
		String productJson = "{\n" +
				"  \"name\": \"Product for City Test\",\n" +
				"  \"description\": \"Description of Product for City Test\",\n" +
				"  \"price\": \"120.00\",\n" +
				"  \"city\": \"" + cityId + "\"\n" +
				"}";

		MvcResult productResult = this.mvc.perform(MockMvcRequestBuilders.post("/v1/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productJson))
				.andExpect(status().isCreated())
				.andReturn();

		// Extraia o ID do produto criado a partir da resposta JSON
		String productResponseJson = productResult.getResponse().getContentAsString();
		UUID productId = UUID.fromString(mapper.readTree(productResponseJson).get("id").asText());

		// Execute o teste de busca por cidade usando o ID da cidade criada
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/products/searchByCity/{id}", cityId))
				.andExpect(status().isOk())
				// Verifique se a resposta contém o ID do produto criado
				.andExpect(jsonPath("$.id").value(productId.toString()));
	}

}