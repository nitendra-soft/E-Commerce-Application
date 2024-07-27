package www.ecom.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.ecom.constants.AppConstants;
import www.ecom.dto.CategoryDto;
import www.ecom.props.AppProps;
import www.ecom.response.ApiResponse;
import www.ecom.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	private AppProps props;

	/**
	 * @param categoryDto
	 * @return
	 */
	
	@PostMapping
	public ResponseEntity<ApiResponse<CategoryDto>> addCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto addCategory = categoryService.addCategory(categoryDto);
		Map<String,String> messages = props.getMessages();

		ApiResponse<CategoryDto> response = new ApiResponse<>();

		if (addCategory != null) {
			response.setStatusCode(201);
			response.setMessage(messages.get(AppConstants.CATEGORY_ADDED));
			response.setData(addCategory);
		} else {
			response.setStatusCode(500);
			response.setMessage(messages.get(AppConstants.CATEGORY_ADD_ERR));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<CategoryDto>> updateCategory(@PathVariable("id") Integer categoryId,
			@RequestBody CategoryDto categoryDto) {
		Map<String,String> messages = props.getMessages();

		CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);

		ApiResponse<CategoryDto> response = new ApiResponse<>();

		if (updatedCategory != null) {
			response.setStatusCode(200);
			response.setMessage(messages.get(AppConstants.CATEGORY_UPDATE));
			response.setData(updatedCategory);
		} else {
			response.setStatusCode(500);
			response.setMessage(messages.get(AppConstants.CATEGORY_UPDATE_ERR));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<CategoryDto>>> getAllCategories() {
		
		Map<String,String> messages = props.getMessages();

		List<CategoryDto> categories = categoryService.getAllCategories();

		ApiResponse<List<CategoryDto>> response = new ApiResponse<>();

		if (categories != null) {
			response.setStatusCode(200);
			response.setMessage(messages.get(AppConstants.CATEGORY_FETCH));
			response.setData(categories);
		} else {
			response.setStatusCode(500);
			response.setMessage(messages.get(AppConstants.CATEGORY_FETCH_ERR));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<CategoryDto>> getCategoryById(@PathVariable("id") Integer categoryId) {

		CategoryDto category = categoryService.getCategoryById(categoryId);
		
		Map<String,String> messages = props.getMessages();

		ApiResponse<CategoryDto> response = new ApiResponse<>();

		if (category != null) {
			response.setStatusCode(200);
			response.setMessage(messages.get(AppConstants.CATEGORY_SELECT));
			response.setData(category);
		} else {
			response.setStatusCode(500);
			response.setMessage(messages.get(AppConstants.CATEGORY_SELECT_ERR));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<CategoryDto>> deleteCategoryById(@PathVariable("id") Integer categoryId) {
		CategoryDto deleteCategory = categoryService.deleteCategoryById(categoryId);
		
		Map<String,String> messages = props.getMessages();

		ApiResponse<CategoryDto> response = new ApiResponse<>();

		if (deleteCategory != null) {
			response.setStatusCode(200);
			response.setMessage(messages.get(AppConstants.CATEGORY_DELETE));
			response.setData(deleteCategory);
		} else {
			response.setStatusCode(500);
			response.setMessage(messages.get(AppConstants.CATEGORY_DELETE_ERR));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
