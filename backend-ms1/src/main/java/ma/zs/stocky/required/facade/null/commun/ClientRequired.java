package  ma.zs.stocky.required.facade.commun;

import ma.zs.stocky.required.dto.commun.ClientDto;
import ma.zs.stocky.required.criteria.commun.ClientCriteria;
import ma.zs.stocky.zynerator.required.AbstractRequired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/admin/client")
public class ClientRequired extends AbstractRequired<ClientDto,ClientDto[]> {

    @Autowired
    RestTemplate restTemplate;

@Value("${ms.config.ms2.admin.url}")
    private String msUrl;
    private String localUrl = "client/";


    @GetMapping("")
    public List<ClientDto> findAll() {
        return super.findAll();
    }

    @PostMapping("find-by-criteria")
    public List<ClientDto> findByCriteria(@RequestBody ClientCriteria criteria) {
        return super.findByCriteria(criteria);
    }

    public ClientRequired() {
        super(ClientDto.class, ClientDto[].class);
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
