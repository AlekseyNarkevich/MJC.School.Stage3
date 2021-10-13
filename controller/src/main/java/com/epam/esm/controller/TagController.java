package com.epam.esm.controller;

import com.epam.esm.dto.TagDto;
import com.epam.esm.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<TagDto> create(TagDto tagDto) {
        return ResponseEntity.status(CREATED).body(tagService.create(tagDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(tagService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TagDto> delete(@PathVariable("id") long id) {
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

