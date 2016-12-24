package org.miage.m2sid.repository;

import org.miage.m2sid.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the PhotoGallery entity.
 */
@SuppressWarnings("unused")
public interface PhotoGalleryRepository extends JpaRepository<PhotoGallery,Long> {

}
