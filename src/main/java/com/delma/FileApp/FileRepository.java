package com.delma.FileApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FileRepository extends JpaRepository<FileModel, Long> {

}
