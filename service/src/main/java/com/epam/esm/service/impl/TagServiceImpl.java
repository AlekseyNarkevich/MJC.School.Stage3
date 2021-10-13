package com.epam.esm.service.impl;

import com.epam.esm.converter.TagConverter;
import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.repository.TagRepository;
import com.epam.esm.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagConverter converter;

    @Override
    public TagDto getById(Long id) {

        return converter.toDTO(tagRepository.getById(id).orElse(null));
    }

    @Override
    public List<Tag> getByCertificate(Long id) {

        return tagRepository.getByCertificate(id);
    }

    @Override
    public TagDto create(TagDto tagDto) {

        return converter.toDTO(tagRepository.add(converter.toEntity(tagDto)));
    }

    @Override
    public List<Tag> insertTags(Long certificateId, List<Tag> tag) {

        tag.forEach(t -> tagRepository.insertTag(certificateId, t.getId()));
        return tag;
    }

    @Override
    public void delete(Long id) {

    }
}

