package com.softserve.osbb.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.osbb.model.Folder;
import com.softserve.osbb.model.Osbb;
import com.softserve.osbb.repository.FolderRepository;
import com.softserve.osbb.service.FolderService;
import com.softserve.osbb.service.exceptions.EntityNotFoundException;

/**
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 06.12.2016
 *
 */
@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository repository;

    @Override
    public void delete(Folder folder) {
        repository.delete(folder);
    }

    @Override
    public boolean deleteById(Integer id) {
        repository.delete(id);
        return (repository.findById(id) == null);
    }

    @Override
    public Folder update(Folder folder) {
        return repository.saveAndFlush(folder);
    }

    @Override
    public Folder update(Integer id, String name) {
        validateName(name);
        
        Folder folder = repository.findById(id);        
        if (folder == null) {
            throw new EntityNotFoundException(id);
        }
        folder.setName(name);        
        return update(folder);
    }
    
    @Override
    public List<Folder> findAll() {
        return repository.findAll();
    }

    @Override
    public Folder findById(Integer id) {
        Folder folder = repository.findById(id);
        if (folder == null) {
            throw new EntityNotFoundException(id);
        }
        return repository.findById(id);
    }    

    @Override
    public List<Folder> findByParentId(Integer parentId) {
        return repository.findByParentId(parentId);
    }

    @Override
    public List<Folder> findByParent(Folder parent) {
        return repository.findByParent(parent);
    }

    @Override
    public List<Folder> findByOsbb(Osbb osbb) {
        return repository.findByOsbb(osbb);
    }

    @Override
    public Folder save(String folderName, Integer parentId) {
        validateName(folderName);
        
        Folder folder = repository.findById(parentId);        
        if (folder != null) {
            Folder newFolder = new Folder();
            newFolder.setName(folderName);
            newFolder.setParent(folder);
            newFolder.setOsbb(folder.getOsbb());
            folder = repository.saveAndFlush(newFolder);
        } else {
            throw new EntityNotFoundException(parentId);
        }
        
        return folder;
    }

    private void validateName(String folderName) {
        if (!Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-_]{1,35}$").matcher(folderName).matches()) {
            throw new IllegalArgumentException("Folder name '" + folderName + "' not allowed!");
        }
    }

}
