package com.candidate.service.Impl;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;
import com.candidate.repo.ResourceRepo;
import com.candidate.service.Service.ResourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepo resourceRepo;

    @Override
    public String createResource(ResourceDTO resource) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        resourceRepo.save(resource1);
        return "resource created";
    }

    @Override
    public String updateResource(ResourceDTO resource) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Resource resource1 = mapper.map(resource, Resource.class);
        resourceRepo.save(resource1);
        return "resource updated";
    }

    @Override
    public String deleteResource(Long id) {
        Optional<Resource> resource = resourceRepo.findById(id);
        if (resource.isPresent()) {
            resourceRepo.delete(resource.get());
            return id+" resource deleted";
        }
        return "resource not found";
    }

    @Override
    public String deleteResourceAll() {
        resourceRepo.deleteAll();
        return "all resources deleted";
    }

    @Override
    public Optional<Resource> getResource(Long id) {
        Optional<Resource> resource = resourceRepo.findById(id);
        if (resource.isPresent()) {
            return resource;
        }
        return resource;
    }
    @Override
    public List<Resource> getResourceList() {
        return resourceRepo.findAll();
    }

}
