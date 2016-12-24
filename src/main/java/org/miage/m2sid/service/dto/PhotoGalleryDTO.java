package org.miage.m2sid.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.miage.m2sid.domain.PhotoGallery;




/**
 * A DTO for the Livre entity.
 */
public class PhotoGalleryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    public PhotoGalleryDTO(PhotoGallery dto) {
		this.id=dto.getId();
		this.image=dto.getImage();
		this.latitude=dto.getLatitude();
		this.longitude=dto.getLongitude();
		this.pseudo=dto.getPseudo();
	}
	
    public PhotoGalleryDTO(){
	}
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private Long id;

	private String pseudo;

	private Float longitude;

	private Float latitude;

	private String image;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PhotoGalleryDTO livreDTO = (PhotoGalleryDTO) o;

		if (!Objects.equals(id, livreDTO.id))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
