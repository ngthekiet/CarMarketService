package com.market.carmarketservice.api;

import com.market.carmarketservice.model.brand.Brand;
import com.market.carmarketservice.service.brand.BrandService;
import com.market.carmarketservice.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/pri")
public class BrandController {
    private final BrandService brandService;
    private final MessageService messageService;

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBrand() {
        try {
            return new ResponseEntity<>(brandService.getBrands(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(messageService.notFound(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBrand(@PathVariable("id") int id) {
        if (brandService.getBrand(id) != null)
            return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.OK);
        return new ResponseEntity<>(messageService.notFound(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    public ResponseEntity<Object> createCategory(@RequestBody Brand brand) {
        if (brandService.createBrand(brand))
            return new ResponseEntity<>(messageService.successes(), HttpStatus.OK);
        return new ResponseEntity<>(messageService.fail(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCategory(@RequestBody Brand brand, @PathVariable("id") int id) {
        if (brandService.updateBrand(brand, id))
            return new ResponseEntity<>(messageService.successes(), HttpStatus.OK);
        return new ResponseEntity<>(messageService.fail(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@PathVariable("id") int id) {
        if (brandService.deleteBrand(id))
            return new ResponseEntity<>(messageService.successes(), HttpStatus.OK);
        return new ResponseEntity<>(messageService.fail(), HttpStatus.BAD_REQUEST);
    }
}
