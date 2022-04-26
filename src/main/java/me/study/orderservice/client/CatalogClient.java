package me.study.orderservice.client;

import me.study.orderservice.vo.RequestCatalog;
import me.study.orderservice.vo.ResponseCatalog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="catalog-service")
public interface CatalogClient {

    @PostMapping("/catalogs/{productId}")
    ResponseCatalog minusStock(@PathVariable String productId
                                , @RequestBody RequestCatalog requestCatalog);
}
