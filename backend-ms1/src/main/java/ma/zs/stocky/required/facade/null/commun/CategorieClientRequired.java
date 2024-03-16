package  ma.zs.stocky.required.facade.commun;

import ma.zs.stocky.required.dto.commun.CategorieClientDto;
import ma.zs.stocky.required.criteria.commun.CategorieClientCriteria;
import ma.zs.stocky.zynerator.required.AbstractRequired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categorieClient")
public class CategorieClientRequired extends AbstractRequired<CategorieClientDto,CategorieClientDto[]> {

    @Autowired
    RestTemplate restTemplate;

@Value("${ms.config.ms2.admin.url}")
    private String msUrl;
    private String localUrl = "categorieClient/";


    @GetMapping("")
    public List<CategorieClientDto> findAll() {
        return super.findAll();
    }

    @PostMapping("find-by-criteria")
    public List<CategorieClientDto> findByCriteria(@RequestBody CategorieClientCriteria criteria) {
        return super.findByCriteria(criteria);
    }

    public CategorieClientRequired() {
        super(CategorieClientDto.class, CategorieClientDto[].class);
    }

    @Override
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    @Override
    public String getMsUrl() {
        return msUrl;
    }
    @Override
    public String getLocalUrl() {
        return localUrl;
    }
}
