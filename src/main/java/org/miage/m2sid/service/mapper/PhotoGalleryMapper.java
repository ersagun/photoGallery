package org.miage.m2sid.service.mapper;

import org.miage.m2sid.domain.*;
import org.miage.m2sid.service.dto.PhotoGalleryDTO;
import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Livre and its DTO LivreDTO.
 */
@Mapper(componentModel = "spring")
public interface PhotoGalleryMapper {
    PhotoGalleryDTO photoGalleryToPhotoGalleryDTO(PhotoGallery photoGallery);
    PhotoGallery photoGalleryDTOToPhotoGallery(PhotoGalleryDTO photoGalleryDTO);
    List<PhotoGalleryDTO> photoGallerysToPhotoGalleryDTOs(List<PhotoGallery> photoGallerys);
    List<PhotoGallery> photoGalleryDTOsToPhotoGallery(List<PhotoGalleryDTO> photoGalleryDTOs); 
    
}
