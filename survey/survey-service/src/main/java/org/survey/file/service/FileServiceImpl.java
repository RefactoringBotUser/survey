package org.survey.file.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.survey.file.model.File;
import org.survey.file.repository.FileRepository;

import com.google.common.collect.Iterables;

@WebService(endpointInterface = "org.survey.file.service.FileService", serviceName = "fileService")
public class FileServiceImpl implements FileService {
    @Autowired
    FileRepository fileRepository;
    private static final File[] EMPTY_FILE_ARRAY = new File[0];

    @Override
    public File[] findAll() {
        Iterable<File> files = fileRepository.findAll();
        // return empty list instead of null
        if (Iterables.isEmpty(files)) {
            return EMPTY_FILE_ARRAY;
        } else {
            return Iterables.toArray(files, File.class);
        }
    }

    @Override
    public File create(@WebParam(name = "file") File file) {
        return fileRepository.save(file);
    }

    @Override
    public File update(@WebParam(name = "file") File file) {
        return fileRepository.save(file);
    }

    @Override
    public File findOne(@WebParam(name = "id") long id) {
        return fileRepository.findOne(id);
    }

    @Override
    public boolean exists(@WebParam(name = "id") long id) {
        return fileRepository.exists(id);
    }

    @Override
    public void delete(@WebParam(name = "id") long id) {
        if (fileRepository.exists(id)) {
            fileRepository.delete(id);
        }
    }

    @Override
    public long count() {
        return fileRepository.count();
    }
}
