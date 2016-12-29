package org.miage.m2sid.service.dto;

import java.io.Serializable;
import java.util.Objects;

import org.apache.tomcat.util.codec.binary.Base64;
import org.miage.m2sid.domain.PhotoGallery;




/**
 * A DTO for the Livre entity.
 */
public class PhotoGalleryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String pseudo;
	private Float longitude;
	private Float latitude;
	private String image;

	
    public PhotoGalleryDTO(PhotoGallery dto) {
		this.image=new String(Base64.decodeBase64(dto.getImage()));
		this.latitude=dto.getLatitude();
		this.longitude=dto.getLongitude();
		this.pseudo=dto.getPseudo();
	}
	
    public PhotoGalleryDTO(){
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

}
