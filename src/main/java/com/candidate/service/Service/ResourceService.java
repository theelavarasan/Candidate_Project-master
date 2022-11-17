package com.candidate.service.Service;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    String createResource(ResourceDTO resource);

    String updateResource(ResourceDTO resource);

    String deleteResource(Long id);

    String deleteResourceAll();

    Optional<Resource> getResource(Long id);

    List<Resource> getResourceList();
}
