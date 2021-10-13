package com.epam.esm.controller;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.service.CertificateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping
    public ResponseEntity<CertificateDto> create(@Valid @RequestBody CertificateDto certificateDto)
    {
        return ResponseEntity.status(CREATED).body(certificateService.create(certificateDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CertificateDto> getAll() {
        int i;
        i = 1;
        return certificateService.getAll();
    }

    @GetMapping("/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CertificateDto> getById(@PathVariable("id") @Min(1) long id) {
        return ResponseEntity.ok().body(certificateService.findById(id));

    }

    @PutMapping
    public ResponseEntity<CertificateDto> update(@Valid @RequestBody CertificateDto certificateDto) {
        return ResponseEntity.ok().body(certificateService.update(certificateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CertificateDto> delete(@PathVariable("id") @Min(1) long id) {
        certificateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
