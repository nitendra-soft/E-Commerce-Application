package www.ecom.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import www.ecom.dto.ProductOrderDto;
import www.ecom.response.ApiResponse;

@FeignClient(name="07-Orders-Service")
public interface OrderClient {
	@PutMapping("/updateOrder")
	public ResponseEntity<ApiResponse<ProductOrderDto>> updateOrder(@RequestBody ProductOrderDto productOrderDto);

}
