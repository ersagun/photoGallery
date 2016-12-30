package org.miage.m2sid.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.miage.m2sid.domain.PhotoGallery;
import org.miage.m2sid.repository.*;
import org.miage.m2sid.service.dto.PhotoGalleryDTO;
import org.miage.m2sid.web.util.HeaderUtil;
import org.miage.m2sid.web.util.PaginationUtil;

import javax.inject.Inject;

/**
 * REST controller for managing Livre.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PhotoGalleryResource {

    private final Logger log = LoggerFactory.getLogger(PhotoGalleryResource.class);

    @Inject
    private PhotoGalleryRepository PhotoGalleryRepository;
    
   // @Inject
  //  private PhotoGalleryMapper photoGalleryMapper;
    //private PhotoGalleryMapper photoGalleryMapper= Mappers.getMapper( PhotoGalleryMapper.class );

    

    /**
     * POST  /livres : Create a new livre.
     *
     * @param PhotoGalleryDTO the livreDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new livreDTO, or with status 400 (Bad Request) if the livre has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @CrossOrigin
    @RequestMapping(value = "/photoGallery",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoGalleryDTO> createPhotoGallery(@RequestBody PhotoGalleryDTO photoGalleryDTO) throws URISyntaxException {
        log.debug("REST request to save photoGallery : {}", photoGalleryDTO);
        if (photoGalleryDTO.getPseudo() == null || photoGalleryDTO.getImage() == null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("photoGallery", "image_pseudo", "image and pseudo required")).body(null);
        }
        PhotoGallery photoGallery = new PhotoGallery(photoGalleryDTO);
        photoGallery = PhotoGalleryRepository.save(photoGallery);
        
        
        return ResponseEntity.created(new URI("/api/photoGallery/" + photoGallery.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("photoGallery", photoGallery.getId().toString()))
            .body(photoGalleryDTO);
    }

    /**
     * PUT  /livres : Updates an existing livre.
     *
     * @param livreDTO the livreDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated livreDTO,
     * or with status 400 (Bad Request) if the livreDTO is not valid,
     * or with status 500 (Internal Server Error) if the livreDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/photoGallery",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoGalleryDTO> updateLivre(@RequestBody PhotoGalleryDTO photoGalleryDTO) throws URISyntaxException {
        log.debug("REST request to update Livre : {}", photoGalleryDTO);
        if (photoGalleryDTO.getPseudo() == null || photoGalleryDTO.getImage() == null) {
            return createPhotoGallery(photoGalleryDTO);
        }
        PhotoGallery photoGallery = new PhotoGallery(photoGalleryDTO);
        photoGallery = PhotoGalleryRepository.save(photoGallery);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("photoGallery", photoGallery.getId().toString()))
            .body(photoGalleryDTO);
    }

    /**
     * GET  /livres : get all the livres.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of livres in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @RequestMapping(value = "/photoGallery",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
   
    public ResponseEntity<List<PhotoGalleryDTO>> getAllPhotoGallery(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of photos");
        Page<PhotoGallery> page = PhotoGalleryRepository.findAll(pageable);
       
        List<PhotoGalleryDTO> lph=new ArrayList<PhotoGalleryDTO>();
        for(PhotoGallery pg: page){
        	PhotoGalleryDTO pgDTO = new PhotoGalleryDTO(pg);
        	pgDTO.setId(pg.getId());
        	lph.add(pgDTO);
        }
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/photoGallery");
        return new ResponseEntity<>(lph, headers, HttpStatus.OK);
    }

    /**
     * GET  /livres/:id : get the "id" livre.
     *
     * @param id the id of the livreDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the livreDTO, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/photoGallery/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoGalleryDTO> getPhotoGallery(@PathVariable Long id) {
        log.debug("REST request to get PhotoGallery : {}", id);
        PhotoGallery photoGallery = PhotoGalleryRepository.findOne(id);
        PhotoGalleryDTO photoGalleryDTO = new PhotoGalleryDTO(photoGallery);
        return Optional.ofNullable(photoGalleryDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /livres/:id : delete the "id" livre.
     *
     * @param id the id of the livreDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/photoGallery/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
 
    public ResponseEntity<Void> deletePhotoGallery(@PathVariable Long id) {
        log.debug("REST request to delete PhotoGallery : {}", id);
        PhotoGalleryRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("PhotoGallery", id.toString())).build();
    }

}
